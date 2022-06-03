-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 03, 2022 at 03:14 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kamera`
--

-- --------------------------------------------------------

--
-- Table structure for table `data_kamera`
--

CREATE TABLE `data_kamera` (
  `merek` varchar(30) NOT NULL,
  `jenis` varchar(30) NOT NULL,
  `lensa` varchar(30) NOT NULL,
  `tahun` varchar(30) NOT NULL,
  `biaya` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `data_kamera`
--

INSERT INTO `data_kamera` (`merek`, `jenis`, `lensa`, `tahun`, `biaya`) VALUES
('Canon EOS 4000D', 'DSLR', 'Kit', '2020', '60000'),
('Canon EOS80', 'DSLR', 'Wide', '2019', '70000'),
('Canon M500', 'Mirorless', 'Kit', '2016', '50000'),
('FujiFilm', 'Analog', 'Analog', '2014', '50000'),
('Nikon D5200', 'DSLR', 'Prime', '2017', '55000'),
('Nikon D5600', 'DSLR', 'Prime', '2016', '55000'),
('Sony Alpha SLT A99', 'DSLR', 'Kit', '2019', '60000'),
('Sony DSC H300', 'Mirorless', 'Kit', '2017', '50000');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `data_kamera`
--
ALTER TABLE `data_kamera`
  ADD PRIMARY KEY (`merek`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
