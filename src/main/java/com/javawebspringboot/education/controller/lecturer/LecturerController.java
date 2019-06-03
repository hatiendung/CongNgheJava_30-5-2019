package com.javawebspringboot.education.controller.lecturer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javawebspringboot.education.exception.ReadFileException;
import com.javawebspringboot.education.model.Subject;
import com.javawebspringboot.education.model.User;
import com.javawebspringboot.education.service.ScoresService;
import com.javawebspringboot.education.service.SubjectService;
import com.javawebspringboot.education.service.UserLearningOutcomeService;
import com.javawebspringboot.education.service.UserService;
import com.javawebspringboot.education.utiles.TableScore;

@Controller
public class LecturerController {

    @Autowired
    private UserService userService;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private ScoresService scoreService;

    @Autowired
    private UserLearningOutcomeService userLearningOutcomeService;

    @RequestMapping("/lecturer/")
    public String studentHomePage(Model model) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.findByUsername(userDetails.getUsername());
        model.addAttribute("user", user);
        return "lecturer/homeLecturer";
    }

    @RequestMapping(value = "/lecturer/subject/{idSubject}")
    public String showContest(Model model, @PathVariable(name = "idSubject") Integer idSubject) {

        Subject subject = subjectService.findByIdSubject(idSubject);
        model.addAttribute("subject", subject);
        model.addAttribute("subjectScore", scoreService.findBySubject(subject));

        if (ReadFileException.getMsgError() != "") {
            model.addAttribute("status", new ReadFileException().getMessage());
            ReadFileException.setMsgError("");
        }

        return "lecturer/subject";
    }

    @RequestMapping(value = "/lecturer/subject/{idSubject}/upload/{cotDiem}")
    public String readFileExcel(@PathVariable(name = "idSubject") Integer idSubject,
            @PathVariable(name = "cotDiem") String cotDiem, @RequestParam(name = "fileExcel") MultipartFile fileExcel) {

        List<TableScore> lisTableScores = null;
        try {
            lisTableScores = new ArrayList<>();
            lisTableScores = subjectService.fileHandler(fileExcel);
        } catch (ReadFileException ex) {
            return "redirect:/lecturer/subject/{idSubject}";
        }

        // file excel khong bi loi
        // xu li file
        if (lisTableScores != null) {
            subjectService.readData(lisTableScores, idSubject, cotDiem);
            
        }
        // mang ra de test - ko phải upload lai file
      //  userLearningOutcomeService.updateLearningOutcome(lisTableScores, idSubject);

        return "redirect:/lecturer/";
    }

}
