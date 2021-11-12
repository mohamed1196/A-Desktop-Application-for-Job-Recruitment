-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3308
-- Generation Time: May 08, 2020 at 10:21 AM
-- Server version: 8.0.18
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `recruit_me`
--

-- --------------------------------------------------------

--
-- Table structure for table `application`
--

DROP TABLE IF EXISTS `application`;
CREATE TABLE IF NOT EXISTS `application` (
  `app_id` int(11) NOT NULL AUTO_INCREMENT,
  `app_name` varchar(255) NOT NULL,
  `app_email` varchar(255) NOT NULL,
  `app_qualification` varchar(255) NOT NULL,
  `app_brief` varchar(255) NOT NULL,
  `app_js_id` int(11) NOT NULL,
  PRIMARY KEY (`app_id`),
  KEY `js_foreign` (`app_js_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `application`
--

INSERT INTO `application` (`app_id`, `app_name`, `app_email`, `app_qualification`, `app_brief`, `app_js_id`) VALUES
(1, 'mazen', 'mazen@mazen.com', 'ICS Student', 'motivated and active', 107),
(2, 'mazen', 'mazen@mazen.com', 'mm', 'jTextField4', 107),
(3, 'jTextField1', 'jTextField2', 'jTextField3', 'jTextField4', 107);

-- --------------------------------------------------------

--
-- Table structure for table `employer`
--

DROP TABLE IF EXISTS `employer`;
CREATE TABLE IF NOT EXISTS `employer` (
  `emp_id` int(11) NOT NULL,
  `emp_jobRole` varchar(255) NOT NULL,
  `emp_company_name` varchar(255) NOT NULL,
  `emp_company_phone` varchar(255) NOT NULL,
  `emp_company_industry` varchar(255) NOT NULL,
  `emp_bussiness_mail` varchar(255) NOT NULL,
  `emp_company_website` varchar(255) NOT NULL,
  `emp_company_address` varchar(255) NOT NULL,
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `employer`
--

INSERT INTO `employer` (`emp_id`, `emp_jobRole`, `emp_company_name`, `emp_company_phone`, `emp_company_industry`, `emp_bussiness_mail`, `emp_company_website`, `emp_company_address`) VALUES
(106, 'sasd', 'dasdsad', '0100000', 'abavavsca', 'avavsavsa', 'adsvdasvsd', 'sdvavdsav');

-- --------------------------------------------------------

--
-- Table structure for table `jobseeker`
--

DROP TABLE IF EXISTS `jobseeker`;
CREATE TABLE IF NOT EXISTS `jobseeker` (
  `js_id` int(11) NOT NULL,
  `js_degree` varchar(255) NOT NULL,
  `js_careerLvl` varchar(255) NOT NULL,
  KEY `jobseeker_foreign` (`js_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `jobseeker`
--

INSERT INTO `jobseeker` (`js_id`, `js_degree`, `js_careerLvl`) VALUES
(107, 'student', 'entry'),
(108, 'student', 'entry');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `u_id` int(11) NOT NULL AUTO_INCREMENT,
  `u_name` varchar(255) NOT NULL,
  `u_age` int(10) NOT NULL,
  `u_phone` varchar(255) NOT NULL,
  `u_address` varchar(255) NOT NULL,
  `u_gender` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `u_email` varchar(255) NOT NULL,
  `u_password` varchar(255) NOT NULL,
  `u_type` varchar(255) NOT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`u_id`, `u_name`, `u_age`, `u_phone`, `u_address`, `u_gender`, `u_email`, `u_password`, `u_type`) VALUES
(1, 'Omar', 25, '01059626233', 'New Cairo', 'male', 'omar22@yahoo.com', '123456', 'admin'),
(106, 'mego', 22, '0100000', 'helwan', 'Male', 'mego@mego.com', '123456', 'employer'),
(107, 'mazen', 21, '0100000', 'obour', 'male', 'mazen@mazen.com', '123456', 'jobseeker'),
(108, 'Islam', 21, '01000000', 'obour', 'male', 'islam@islam.com', '123456', 'jobseeker');

-- --------------------------------------------------------

--
-- Table structure for table `vacancy`
--

DROP TABLE IF EXISTS `vacancy`;
CREATE TABLE IF NOT EXISTS `vacancy` (
  `v_id` int(11) NOT NULL AUTO_INCREMENT,
  `v_title` varchar(255) NOT NULL,
  `v_type` varchar(255) NOT NULL,
  `v_about` varchar(255) NOT NULL,
  `v_requirements` varchar(255) NOT NULL,
  `v_edu_lvl` varchar(255) NOT NULL,
  `v_lang` varchar(255) NOT NULL,
  `v_salary` float NOT NULL,
  `v_open_position` int(11) NOT NULL,
  `employer_id` int(11) NOT NULL,
  PRIMARY KEY (`v_id`),
  KEY `emp_foreign` (`employer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `vacancy`
--

INSERT INTO `vacancy` (`v_id`, `v_title`, `v_type`, `v_about`, `v_requirements`, `v_edu_lvl`, `v_lang`, `v_salary`, `v_open_position`, `employer_id`) VALUES
(1, 'vdsvsadv', 'asdvdsavads', 'sadvdsav', 'sdvasdv', 'asdvasdv', 'sdavsadv', 20000, 20000, 106),
(9, 'jTextField1', 'jTextField2', 'jTextField3', 'jTextField4', 'jTextField5', 'jTextField6', 0, 0, 106);

-- --------------------------------------------------------

--
-- Table structure for table `vacancyapp`
--

DROP TABLE IF EXISTS `vacancyapp`;
CREATE TABLE IF NOT EXISTS `vacancyapp` (
  `appID` int(11) NOT NULL,
  `vacancyID` int(11) NOT NULL,
  PRIMARY KEY (`appID`,`vacancyID`),
  KEY `vacancy_foreign` (`vacancyID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `vacancyapp`
--

INSERT INTO `vacancyapp` (`appID`, `vacancyID`) VALUES
(1, 1),
(3, 1),
(1, 9);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `application`
--
ALTER TABLE `application`
  ADD CONSTRAINT `js_foreign` FOREIGN KEY (`app_js_id`) REFERENCES `jobseeker` (`js_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `employer`
--
ALTER TABLE `employer`
  ADD CONSTRAINT `employer_foreign` FOREIGN KEY (`emp_id`) REFERENCES `user` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `jobseeker`
--
ALTER TABLE `jobseeker`
  ADD CONSTRAINT `jobseeker_foreign` FOREIGN KEY (`js_id`) REFERENCES `user` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `vacancy`
--
ALTER TABLE `vacancy`
  ADD CONSTRAINT `Emp_Foregin` FOREIGN KEY (`employer_id`) REFERENCES `employer` (`emp_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `vacancyapp`
--
ALTER TABLE `vacancyapp`
  ADD CONSTRAINT `application_foreign` FOREIGN KEY (`appID`) REFERENCES `application` (`app_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `vacancy_foreign` FOREIGN KEY (`vacancyID`) REFERENCES `vacancy` (`v_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
