-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 07, 2019 at 03:40 AM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `project`
--

-- --------------------------------------------------------

--
-- Table structure for table `items`
--

CREATE TABLE `items` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `price` int(255) NOT NULL,
  `stock` int(255) NOT NULL,
  `barcode` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `items`
--

INSERT INTO `items` (`id`, `name`, `price`, `stock`, `barcode`) VALUES
(2, 'Iphone 6S', 20000, 123, NULL),
(4, 'Samsung S7', 1000000, 115, NULL),
(8, 'MI Power Bank', 19000, 14, NULL),
(12, 'lux', 60, 250, NULL),
(13, 'shampoo', 25500, 10, '1122'),
(14, 'Ali mota', 69, 10, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `receipt`
--

CREATE TABLE `receipt` (
  `id` int(11) NOT NULL,
  `date` varchar(255) NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `receipt`
--

INSERT INTO `receipt` (`id`, `date`, `quantity`, `price`) VALUES
(20005296, '2019-18-12', 200, 455555),
(20005297, '2019/01/04', 360000, 3),
(20005298, '2019/01/04', 2120000, 2),
(20005299, '2019/01/04', 2079000, 3),
(20005300, '2019/01/04', 2079000, 3),
(20005301, '2019/01/04', 1000000, 1),
(20005302, '2019/01/04', 1000000, 1),
(20005303, '2019/01/04', 1100000, 1),
(20005304, '2019/01/04', 2000000, 1),
(20005305, '2019/01/04', 2030000, 2),
(20005306, '2019/01/04', 2000500, 2),
(20005307, '2019/01/04', 1111000, 2),
(20005308, '2019/01/05', 2000000, 1),
(20005309, '2019/01/06', 100, 1),
(20005310, '2019/01/07', 100, 1),
(20005311, '2019/01/07', 20060, 2);

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

CREATE TABLE `sales` (
  `id` int(255) NOT NULL,
  `date` varchar(255) NOT NULL,
  `quantity` int(255) NOT NULL,
  `amount` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`id`, `date`, `quantity`, `amount`) VALUES
(20005287, '2019-01-08', 10, 500000),
(20005288, 'ahsir', 12, 12),
(20005289, 'date', 12, 12),
(20005290, 'date', 12, 12),
(20005291, '2019/01/04', 3, 249000),
(20005292, '2019/01/04', 1, 200000),
(20005293, '2019/01/04', 1, 200000),
(20005294, '2019/01/04', 1, 300000),
(20005295, '2019/01/04', 1, 100000),
(20005296, '2019/01/04', 2, 160000),
(20005297, '2019/01/04', 3, 360000),
(20005298, '2019/01/04', 2, 2120000),
(20005299, '2019/01/04', 3, 2079000),
(20005300, '2019/01/04', 3, 2079000),
(20005301, '2019/01/04', 1, 1000000),
(20005302, '2019/01/04', 1, 1000000),
(20005303, '2019/01/04', 1, 1100000),
(20005304, '2019/01/04', 1, 2000000),
(20005305, '2019/01/04', 2, 2030000),
(20005306, '2019/01/04', 2, 2000500),
(20005307, '2019/01/04', 2, 1111000),
(20005308, '2019/01/05', 1, 2000000),
(20005309, '2019/01/06', 1, 100),
(20005310, '2019/01/07', 1, 100),
(20005311, '2019/01/07', 2, 20060);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `rank` int(10) NOT NULL DEFAULT '0',
  `name` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `password`, `rank`, `name`, `phone`, `address`) VALUES
(4, 'alihamza', 'Aliali123', 0, 'Umer Farooq', '0300656613', 'Punjab.Pk'),
(6, 'alihamaali', 'Nowaystoo', 0, 'Ali Hamza', '03006788999', 'KCH,PK'),
(8, 'usama', 'nowayyy', 0, 'Usama najeeb', '03004565444', 'NEWS,FEED'),
(10, 'ali', '1234', 0, 'Ali Hamza', '03247411040', 'fsd'),
(101, 'admin', '123', 1, 'Armaghan', '03034222283', 'FAisaalabd');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `items`
--
ALTER TABLE `items`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `receipt`
--
ALTER TABLE `receipt`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sales`
--
ALTER TABLE `sales`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `items`
--
ALTER TABLE `items`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `receipt`
--
ALTER TABLE `receipt`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20005312;

--
-- AUTO_INCREMENT for table `sales`
--
ALTER TABLE `sales`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20005312;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=102;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
