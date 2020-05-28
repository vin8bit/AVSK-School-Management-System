-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jun 04, 2019 at 08:41 PM
-- Server version: 5.7.19
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `navyug_database`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `id` varchar(6) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `password`) VALUES
('101', 'avsk');

-- --------------------------------------------------------

--
-- Table structure for table `jun2019`
--

DROP TABLE IF EXISTS `jun2019`;
CREATE TABLE IF NOT EXISTS `jun2019` (
  `s_no` varchar(10) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `class2` varchar(8) DEFAULT NULL,
  `father_name` varchar(50) DEFAULT NULL,
  `roll_no` varchar(4) DEFAULT NULL,
  `admission_no` varchar(10) NOT NULL,
  `date2` varchar(12) DEFAULT NULL,
  `tuition_fee` varchar(8) DEFAULT NULL,
  `late_fee` varchar(8) DEFAULT NULL,
  `annual_fee` varchar(8) DEFAULT NULL,
  `other_fee` varchar(8) DEFAULT NULL,
  `admission_fee` varchar(8) DEFAULT NULL,
  `total` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`admission_no`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `staff_table`
--

DROP TABLE IF EXISTS `staff_table`;
CREATE TABLE IF NOT EXISTS `staff_table` (
  `staff_id` varchar(10) NOT NULL,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `dob1` varchar(40) NOT NULL,
  `phone_no` varchar(13) NOT NULL,
  `father_name` varchar(50) NOT NULL,
  `gender` varchar(7) NOT NULL,
  `email_id` varchar(50) NOT NULL,
  `qualification` varchar(15) NOT NULL,
  `designation` varchar(40) NOT NULL,
  `salary` varchar(8) NOT NULL,
  `joining_date` varchar(40) NOT NULL,
  `address` varchar(100) NOT NULL,
  `status` varchar(11) NOT NULL,
  PRIMARY KEY (`staff_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `students_table`
--

DROP TABLE IF EXISTS `students_table`;
CREATE TABLE IF NOT EXISTS `students_table` (
  `admission_no` varchar(10) NOT NULL,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `roll_no` varchar(3) NOT NULL,
  `class2` varchar(8) NOT NULL,
  `father_name` varchar(50) NOT NULL,
  `father_no` varchar(10) NOT NULL,
  `father_occupation` varchar(30) NOT NULL,
  `mother_name` varchar(50) NOT NULL,
  `mother_no` varchar(10) NOT NULL,
  `mother_occupation` varchar(30) NOT NULL,
  `address` varchar(100) NOT NULL,
  `gender` varchar(6) NOT NULL,
  `caste` varchar(7) NOT NULL,
  `dob` varchar(11) NOT NULL,
  `admission_date` varchar(11) NOT NULL,
  `fees` varchar(6) NOT NULL,
  `status` varchar(20) NOT NULL,
  PRIMARY KEY (`admission_no`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
