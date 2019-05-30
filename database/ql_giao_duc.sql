-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: ql_giaoduc
-- ------------------------------------------------------
-- Server version	5.7.26-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bangdiem`
--

DROP TABLE IF EXISTS `bangdiem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `bangdiem` (
  `id_bangdiem` int(11) NOT NULL AUTO_INCREMENT,
  `diem_qt` float DEFAULT '0',
  `diem_th` float DEFAULT '0',
  `diem_gk` float DEFAULT '0',
  `diem_ck` float DEFAULT '0',
  `diem_tb` float DEFAULT '0',
  `id_user` int(11) DEFAULT NULL,
  `id_monhoc` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_bangdiem`),
  KEY `fk_diem_monhoc_idx` (`id_monhoc`),
  KEY `fk_user_idx` (`id_user`),
  CONSTRAINT `fk_diem_monhoc` FOREIGN KEY (`id_monhoc`) REFERENCES `subject` (`id_monhoc`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bangdiem`
--

LOCK TABLES `bangdiem` WRITE;
/*!40000 ALTER TABLE `bangdiem` DISABLE KEYS */;
INSERT INTO `bangdiem` VALUES (1,10,10,10,10,10,10,5);
/*!40000 ALTER TABLE `bangdiem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cauhoi`
--

DROP TABLE IF EXISTS `cauhoi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cauhoi` (
  `id_cauhoi` int(11) NOT NULL AUTO_INCREMENT,
  `stt_cauhoi` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `noidungcauhoi` mediumtext COLLATE utf8_unicode_ci,
  `id_dethi` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_cauhoi`),
  KEY `fk_cauhoi_dethi_idx` (`id_dethi`),
  CONSTRAINT `fk_cauhoi_dethi` FOREIGN KEY (`id_dethi`) REFERENCES `dethi` (`id_dethi`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cauhoi`
--

LOCK TABLES `cauhoi` WRITE;
/*!40000 ALTER TABLE `cauhoi` DISABLE KEYS */;
INSERT INTO `cauhoi` VALUES (1,'câu 1','hen an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchange',5);
/*!40000 ALTER TABLE `cauhoi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coursegoal`
--

DROP TABLE IF EXISTS `coursegoal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `coursegoal` (
  `id_course_goal` int(11) NOT NULL AUTO_INCREMENT,
  `sign` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name_course_goal` mediumtext COLLATE utf8_unicode_ci,
  `id_subject` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_course_goal`),
  KEY `fk_chuanmh_mh_idx` (`id_subject`),
  CONSTRAINT `fk_cmh_mh` FOREIGN KEY (`id_subject`) REFERENCES `subject` (`id_monhoc`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coursegoal`
--

LOCK TABLES `coursegoal` WRITE;
/*!40000 ALTER TABLE `coursegoal` DISABLE KEYS */;
INSERT INTO `coursegoal` VALUES (1,'G1','Kết hợp làm việc cá nhân và nhóm để thảo luận và thực hiện đề tài theo nội dung môn học',5),(2,'G2','Trình bày được các khái niệm cơ bản liên quan đến nguyên lý lập trình, cách trao đổi thông tin giữa các cửa sổ, form trong ứng dụng. Khảo sát một số ứng dụng viết  bằng java. Hướng dẫn cài đặt các phần mềm liên quan đến môn học. Tổng quan về java.',5),(3,'G3','Hiểu và sử dụng cú pháp lệnh trong Java. Lập trình hướng đối tượng trong Java.',5),(4,'G4','Hiểu và sử dụng thành thạo các thành phần: AWT (Abstract Windowing Toolkit), Swing và thiết kế giao diện dùng thư viện JFC (Java Foundation Class)',5),(5,'G5','Hiểu và xử lý sự kiện (Listeners and Events) và phương pháp quản lý giao diện (Layout Manager).',5),(6,'G6','Hiểu và sử dụng kiến thức xử lý luồng và tập tin trong java.',5),(7,'G7','Dùng Java JDBC API để truy xuất dữ liệu từ trình quản trị CSDL SQL Server, MySQL . Sử dụng thành thạo các câu lệnh truy vấn trong ứng dụng',5),(8,'G8','Hiểu cách tổ chức code bằng mô hình MVC, hiểu Framework là gì. Cách tổ chức code bằng Framework Hibernate. Cài đặt, kiểm chứng ứng dụng đã đăng ký.',5),(9,'G9','Đóng gói và triển khai ứng dụng viết bằng ngôn ngữ lập trình java.',5),(10,'G1','Kiến thức nền tảng Java cơ bản và hướng đối tượng.',2),(11,'G2','Hiểu, phân tích, thiết kế và vận dụng được công nghệ J2SE: lập trình giao diện và cơ sở dữ liệu trên Java vào việc xây dựng một ứng dụng trên máy tính.',2),(12,'G3','Hiểu, phân tích, thiết kế và vận dụng được công nghệ J2EE: lập trình Web với Servlet và JSP vào việc xây dựng một ứng dụng web.',2),(13,'G4','Có kỹ năng làm việc nhóm.',2);
/*!40000 ALTER TABLE `coursegoal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coursesgoal_learningoutcome`
--

DROP TABLE IF EXISTS `coursesgoal_learningoutcome`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `coursesgoal_learningoutcome` (
  `id_courses_goal` int(11) NOT NULL,
  `id_learning_outcome` int(11) NOT NULL,
  PRIMARY KEY (`id_courses_goal`,`id_learning_outcome`),
  KEY `fk_idcdr_idx` (`id_learning_outcome`),
  CONSTRAINT `fk_idcdr` FOREIGN KEY (`id_learning_outcome`) REFERENCES `learningoutcome` (`id_chuandaura`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_idcnh_cmh` FOREIGN KEY (`id_courses_goal`) REFERENCES `coursegoal` (`id_course_goal`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coursesgoal_learningoutcome`
--

LOCK TABLES `coursesgoal_learningoutcome` WRITE;
/*!40000 ALTER TABLE `coursesgoal_learningoutcome` DISABLE KEYS */;
INSERT INTO `coursesgoal_learningoutcome` VALUES (10,2),(11,5),(12,5),(13,7),(11,10),(12,10);
/*!40000 ALTER TABLE `coursesgoal_learningoutcome` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dethi`
--

DROP TABLE IF EXISTS `dethi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `dethi` (
  `id_dethi` int(11) NOT NULL AUTO_INCREMENT,
  `id_monhoc` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_dethi`),
  KEY `fk_dethi_monhoc_idx` (`id_monhoc`),
  CONSTRAINT `fk_dethi_monhoc` FOREIGN KEY (`id_monhoc`) REFERENCES `subject` (`id_monhoc`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dethi`
--

LOCK TABLES `dethi` WRITE;
/*!40000 ALTER TABLE `dethi` DISABLE KEYS */;
INSERT INTO `dethi` VALUES (1,1),(2,2),(3,3),(4,4),(5,5),(6,6),(7,7),(8,8);
/*!40000 ALTER TABLE `dethi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khoa`
--

DROP TABLE IF EXISTS `khoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `khoa` (
  `id_khoa` int(11) NOT NULL AUTO_INCREMENT,
  `tenkhoa` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `id_user_truong_khoa` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_khoa`),
  KEY `fk_truong_khoa_idx` (`id_user_truong_khoa`),
  CONSTRAINT `fk_truong_khoa` FOREIGN KEY (`id_user_truong_khoa`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khoa`
--

LOCK TABLES `khoa` WRITE;
/*!40000 ALTER TABLE `khoa` DISABLE KEYS */;
INSERT INTO `khoa` VALUES (1,'Công nghệ thông tin',NULL),(2,'Kĩ thuật phần mềm',NULL),(3,'Khoa học máy tính',NULL),(4,'Hệ thống thông tin',NULL),(5,'Mạng máy tính và truyền thông',NULL),(6,'Kĩ thuật máy tính',NULL);
/*!40000 ALTER TABLE `khoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `learningoutcome`
--

DROP TABLE IF EXISTS `learningoutcome`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `learningoutcome` (
  `id_chuandaura` int(11) NOT NULL AUTO_INCREMENT,
  `kihieu` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tenchuandaura` mediumtext COLLATE utf8_unicode_ci,
  `id_khoa` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_chuandaura`),
  KEY `fk_chuandaura_khoa_idx` (`id_khoa`),
  CONSTRAINT `fk_chuandaura_khoa` FOREIGN KEY (`id_khoa`) REFERENCES `khoa` (`id_khoa`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `learningoutcome`
--

LOCK TABLES `learningoutcome` WRITE;
/*!40000 ALTER TABLE `learningoutcome` DISABLE KEYS */;
INSERT INTO `learningoutcome` VALUES (1,'L1',' Kiến thức ngành',1),(2,'L2','Lập luận phân tích và giải quyết vấn đề',1),(3,'L3','Thử nghiệm, khảo sát và khám phá tri thức',1),(4,'L4','Tư duy hệ thống',1),(5,'L5','Kỹ năng và thái độ cá nhân',1),(6,'L6','Đạo đức, trung thực và trách nhiệm',1),(7,'L7','Kỹ năng làm việc nhóm',1),(8,'L8','Kỹ năng giao tiếp',1),(9,'L9','Kỹ năng ngoại ngữ',1),(10,'L10','Hình thành ý tưởng, thiết kế, triển khai và vận hành trong bối cảnh doanh nghiệp và xã hội',1),(11,'L1','Nắm vững kiến thức khoa học cơ bản và kiến thức nền tảng nhóm ngành',2),(12,'L2','Nắm vững kiến thức ngành kỹ thuật nâng cao',2),(13,'L3','Kỹ năng lập luận phân tích và giải quyết vấn đề',2),(14,'L4','Kỹ năng thử nghiệm, khảo sát và khám phá tri thức',2),(15,'L5','Kỹ năng tư duy hệ thống',2),(16,'L6','Kỹ năng và thái độ cá nhân',2),(17,'L7','Kỹ năng giao tiếp và làm việc nhóm',2),(18,'L8','Kỹ năng học ngoại ngữ',2),(19,'L9','Hình thành ý tưởng, thiết kế, triển khai và vận hành trong bối cảnh doanh nghiệp và xã hội',2),(20,'L1','Kiến thức nền tảng của ngành KHMT',3),(21,'L2','Kiến thức chuyên ngành và nâng cao của ngành KHMT',3),(22,'L3','Kỹ năng lập luận tư duy và giải quyết vấn đề',3),(23,'L4','Kỹ năng nghiên cứu và khám phá tri thức',3),(24,'L5','Kỹ năng tư duy theo hệ thống',3),(25,'L6','Kỹ năng tự học và học suốt đời',3),(26,'L7','Các kỹ năng cá nhân và kỹ năng nhóm',3),(27,'L8','Các kỹ năng về ngoại ngữ',3),(28,'L9','Đạo đức, trách nhiệm và các giá trị cá nhân cốt lõi',3),(35,'L1','Nắm vững kiến thức khoa học cơ bản và có khả năng vận dụng vào chuyên ngành.',4),(36,'L2','Nắm vững kiến thức kiến thức nền tảng, nâng cao ngành hệ thống thông tin, các kỹ năng phân tích, thiết kế, lập trình, tổ chức và khám phá tri thức vận dụng vào thực tiễn nhằm hỗ trợ các hoạt động tác nghiệp và quản lý. Đề xuất giải pháp cho các vấn đề trong lĩnh vực CNTT để nâng cao sức cạnh tranh, phát triển của các tổ chức, doanh nghiệp, thiết lập các mục tiêu khả thi, chứng tỏ được sự hiểu biết phù hợp với đương thời. ',4),(37,'L3','Có khả năng làm việc trực tiếp bằng tiếng Anh trong lĩnh vực công nghệ thông tin, trình độ Anh văn đạt từ TOEIC 450, TOEFL iBT 45, TOEFL ITP 430, IELTS 4.5, BULATS 47 hoặc tương đương.',4),(38,'L4','Có kỹ năng tự học các kiến thức bổ trợ để phục vụ cho hướng công việc tương  lai.',4),(39,'L5','Có khả năng giao tiếp xã hội, kỹ năng làm việc nhóm với tác phong chuyên nghiệp và đạo đức nghề nghiệp tốt.',4),(40,'L6','Ý thức được vai trò, trách nhiệm, đạo đức nghề nghiệp trong xã hội, có thế giới  quan, nhân sinh quan đúng đắn và có khả năng nhận thức, đánh giá các hiện tượng một cách logic và tích cực.',4),(41,'L7','Có nhận thức được sự cần thiết của việc học tập suốt đời, có kiến thức chuyên môn rộng, hiểu được tác động của các công nghệ mới trong bối cảnh xã hội, kinh tế toàn cầu.',4),(42,'L1','Kiến thức về khoa học cơ bản',5),(43,'L2','Kiến thức của lĩnh vực Công nghệ Thông tin',5),(44,'L3','Kiến thức cơ sở ngành Mạng máy tính và Truyền thông',5),(45,'L4','Kiến thức về xã hội',5),(46,'L5','Kỹ năng lập luận phân tích và giải quyết vấn đề',5),(47,'L6','Kỹ năng thử nghiệm, nghiên cứu và khám phá tri thức',5),(48,'L7','Kỹ năng tư duy hệ thống',5),(49,'L8','Kỹ năng hình thành ý tưởng, kỹ thuật hệ thống',5),(50,'L9','Kỹ năng thiết kế',5),(51,'L10','Kỹ năng triển khai',5),(52,'L11','Kỹ năng vận hành, đánh giá, kiểm chứng và cải tiến.',5),(53,'L12','Kỹ năng làm việc nhóm, giao tiếp',5),(54,'L13','Kỹ năng ngoại ngữ',5),(55,'L14','Thái độ, tư tưởng và học tập',5),(56,'L15','Đạo đức, công bằng và các trách nhiệm xã hội',5),(57,'L1','Có kiến thức cơ bản và khả năng vận dụng vào chuyên ngành, nắm vững kiến thức kỹ thuật máy tính và ứng dụng vào thực tiễn.',6),(58,'L2','Có kiến thức rộng để từ đó hiểu được tác động của các công nghệ mới trong bối cảnh xã hội, kinh tế toàn cầu.',6),(59,'L3','Có khả năng nghiên cứu và thiết kế các bộ phận chức năng của máy tính hoặc các bộ phận số trong các thiết bị điện tử.',6),(60,'L4','Có khả năng về phân tích, thiết kế, xây dựng các phần cứng và lập trình các phần mềm chuyên dụng; nắm vững các kiến thức lập trình bao gồm cả lập trình cấp cao và cấp thấp, có khả năng lập trình cho các thiết bị ngoại vi, cho các hệ thống nhúng, firmware, driver, thiết bị di động.',6),(61,'L5','Có khả năng làm việc chuyên môn độc lập và phối hợp làm việc với các ngành liên quan để giải quyết các vấn đề phức tạp nảy sinh trong quá trình làm việc.',6),(62,'L6','Khả năng thiết lập các mục tiêu khả thi, lập kế hoạch phù hợp với điều kiện thực tế, giải quyết các vấn đề liên quan đến kỹ thuật máy tính.',6),(63,'L7','Khả năng giao tiếp xã hội, hợp tác và làm việc nhóm với tác phong và đạo đức nghề nghiệp tốt.',6),(64,'L8','Khả năng vận dụng các kiến thức, kỹ năng và kinh nghiệm để giải quyết các tình huống nghề nghiệp khác nhau, trong đó coi trọng kỹ năng giao tiếp.',6),(65,'L9','Khả năng ứng dụng các cơ sở toán học, nguyên lý giải thuật, và lý thuyết kỹ thuật máy tính trong việc mô hình và thiết kế các hệ thống sao cho chứng tỏ được sự hiểu biết về cách lựa chọn đó là phù hợp với đương thời.',6),(66,'L10','Có khả năng làm việc trực tiếp bằng tiếng Anh trong lĩnh vực công nghệ thông tin. Có trình độ Anh văn đạt từ VNU-ETP 8 (TOEFL iBT 35-45 điểm, PBT 417-450 điểm) hoặc tương đương.',6),(67,'L11','Có nhận thức về sự cần thiết và khả năng tham gia vào việc học tập suốt đời để có thể làm việc hiệu quả trong bối cảnh những công nghệ mới liên tục xuất hiện.',6),(68,'L12','Ý thức được vai trò, trách nhiệm, đạo đức nghề nghiệp trong xã hội. Có thế giới quan, nhân sinh quan đúng đắn và có khả năng nhận thức, đánh giá các hiện tượng một cách logic và tích cực. ',6);
/*!40000 ALTER TABLE `learningoutcome` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lopsinhoat`
--

DROP TABLE IF EXISTS `lopsinhoat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `lopsinhoat` (
  `id_lopsinhhoat` int(11) NOT NULL AUTO_INCREMENT,
  `tenlop` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `id_user_covanhoctap` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_lopsinhhoat`),
  KEY `fk_covanhoctap_idx` (`id_user_covanhoctap`),
  CONSTRAINT `fk_covanhoctap` FOREIGN KEY (`id_user_covanhoctap`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lopsinhoat`
--

LOCK TABLES `lopsinhoat` WRITE;
/*!40000 ALTER TABLE `lopsinhoat` DISABLE KEYS */;
INSERT INTO `lopsinhoat` VALUES (1,'CNTT2016',NULL),(2,'CNTT2017',NULL),(3,'CNTT2018',NULL),(4,'KTPM2014',NULL),(5,'KTPM2015',NULL),(6,'KTPM2018',NULL),(7,'HTTT2015',NULL),(8,'HTTT2016',NULL),(9,'HTTT2017',NULL);
/*!40000 ALTER TABLE `lopsinhoat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `role` (
  `id_role` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id_role`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_STUDENT'),(2,'ROLE_LECTURER'),(3,'ROLE_MANAGE');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `subject` (
  `id_monhoc` int(11) NOT NULL AUTO_INCREMENT,
  `ten_monhoc` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `code_subject` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tg_batdau` date DEFAULT '0000-00-00',
  `tg_ketthuc` date DEFAULT '0000-00-00',
  `so_tin_chi` int(2) DEFAULT '0',
  PRIMARY KEY (`id_monhoc`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (1,'Tối ưu hóa công cụ tìm kiếm','tuhcctk2019',NULL,NULL,4),(2,'Công nghệ Java','cnjava2019',NULL,NULL,4),(3,'Phát triển ứng dụng web','ptudw2019',NULL,NULL,4),(4,'Quản lý thông tin','qltt2018',NULL,NULL,4),(5,'Lập trình Java','ltjava2019',NULL,NULL,4),(6,'Internet và công nghệ Web','ivcnw2018',NULL,NULL,4),(7,'Hệ điều hành','hdh2018',NULL,NULL,4),(8,'Tư tưởng Hồ Chí Minh','tthcm2018',NULL,NULL,2);
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fullname` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ngay_sinh` date DEFAULT NULL,
  `id_khoa` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (10,'student','$2a$10$cHlUA/XniX6YWLdJvcKb/u9vdn9IMjGhWOcAO32nsjMXtm3lnP5Aq',NULL,NULL,NULL),(11,'lecturer','$2a$10$ff3hPk1isW8hdhaAqQ8Eje37vbSNSJ5XjbnFhFJD8Yrli4kagHcQq',NULL,NULL,NULL),(12,'manage1','$2a$10$cSBYRKQGbjjVn.6gW//8XuzUGItXyWVatSxVfFYKkKM244K7x51zu',NULL,NULL,NULL),(13,'manage2','$2a$10$8/OvXxypYQBtv1yJpqn6VOA7VduNN6LZG5hFsg5nymXJSjnKLsU4K',NULL,NULL,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_role` (
  `id_user` int(11) NOT NULL,
  `id_role` int(11) NOT NULL,
  PRIMARY KEY (`id_user`,`id_role`),
  KEY `fk_role_idx` (`id_role`),
  CONSTRAINT `fk_role` FOREIGN KEY (`id_role`) REFERENCES `role` (`id_role`),
  CONSTRAINT `fk_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (10,1),(11,2),(13,2),(12,3),(13,3);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_subject`
--

DROP TABLE IF EXISTS `user_subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_subject` (
  `id_user` int(11) NOT NULL,
  `id_monhoc` int(11) NOT NULL,
  PRIMARY KEY (`id_user`,`id_monhoc`),
  KEY `fk_monhoc_usermonhoc_idx` (`id_monhoc`),
  CONSTRAINT `fk_monhoc_usermonhoc` FOREIGN KEY (`id_monhoc`) REFERENCES `subject` (`id_monhoc`),
  CONSTRAINT `fk_user_usermonhoc` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_subject`
--

LOCK TABLES `user_subject` WRITE;
/*!40000 ALTER TABLE `user_subject` DISABLE KEYS */;
INSERT INTO `user_subject` VALUES (10,1),(10,2),(10,3),(10,4),(10,5),(10,6),(10,7),(10,8);
/*!40000 ALTER TABLE `user_subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_subject_coursesgoal`
--

DROP TABLE IF EXISTS `user_subject_coursesgoal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_subject_coursesgoal` (
  `id_user` int(11) NOT NULL,
  `id_subject` int(11) NOT NULL,
  `id_coursesgoal` int(11) NOT NULL,
  PRIMARY KEY (`id_user`,`id_subject`,`id_coursesgoal`),
  KEY `fk_subject_idsubject_idx` (`id_subject`),
  KEY `fk_coursesgoal_idx` (`id_coursesgoal`),
  CONSTRAINT `fk_coursesgoal` FOREIGN KEY (`id_coursesgoal`) REFERENCES `coursegoal` (`id_course_goal`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_subject_idsubject` FOREIGN KEY (`id_subject`) REFERENCES `subject` (`id_monhoc`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_iduser` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_subject_coursesgoal`
--

LOCK TABLES `user_subject_coursesgoal` WRITE;
/*!40000 ALTER TABLE `user_subject_coursesgoal` DISABLE KEYS */;
INSERT INTO `user_subject_coursesgoal` VALUES (10,5,1),(10,5,2),(10,5,3),(10,5,4),(10,5,5);
/*!40000 ALTER TABLE `user_subject_coursesgoal` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-18 14:31:01
