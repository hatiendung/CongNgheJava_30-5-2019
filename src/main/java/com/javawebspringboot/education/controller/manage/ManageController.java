package com.javawebspringboot.education.controller.manage;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javawebspringboot.education.model.User;
import com.javawebspringboot.education.service.UserService;

@Controller
public class ManageController {

	@Autowired
	private UserService userService;

	@RequestMapping("/manage/")
	public String studentHomePage() {
		return "manage/homeManage";
	}

	@RequestMapping("/manage/xem-danh-sach-giang-vien")
	public String showListLecturer(Model model, @RequestParam("page") Optional<Integer> page) {
		Sort sortable = Sort.by("idUser").ascending();
		int size = 10;
		int currentPage = page.orElse(1);
		Pageable pageable = PageRequest.of(currentPage - 1, size, sortable);
		Page<User> listLecturer = userService.findAllLecturer(pageable);
		model.addAttribute("listLecturer", listLecturer);

		int totalPages = listLecturer.getTotalPages();
		if (totalPages > 0) {
			List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
			model.addAttribute("totalPages", totalPages);
			model.addAttribute("pageNumbers", pageNumbers);
		}
		return "manage/listLecturer";
	}

	@RequestMapping("/manage/xem-danh-sach-sinh-vien")
	public String showListStudent(Model model, @RequestParam("page") Optional<Integer> page) {
		Sort sortable = Sort.by("idUser").ascending();
		int size = 40;
		int currentPage = page.orElse(1);
		Pageable pageable = PageRequest.of(currentPage - 1, size, sortable);
		Page<User> userList = userService.findAllStudent(pageable);

		model.addAttribute("listStudent", userList);

		int totalPages = userList.getTotalPages();
		if (totalPages > 0) {
			List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
			model.addAttribute("totalPages", totalPages);
			model.addAttribute("pageNumbers", pageNumbers);
		}

		return "manage/listStudent";
	}

}
