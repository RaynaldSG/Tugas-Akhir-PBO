-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 23, 2023 at 08:56 AM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sewa_kamera`
--

-- --------------------------------------------------------

--
-- Table structure for table `history`
--

CREATE TABLE `history` (
  `id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `lama_sewa` int(11) NOT NULL,
  `total` int(11) NOT NULL,
  `description` text NOT NULL,
  `tanggal_pinjam` datetime NOT NULL,
  `tanggal_tenggat` datetime NOT NULL,
  `user_id` int(11) NOT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `history`
--

INSERT INTO `history` (`id`, `name`, `lama_sewa`, `total`, `description`, `tanggal_pinjam`, `tanggal_tenggat`, `user_id`, `status`) VALUES
(2, 'user', 3, 1275000, 'Sony A7 IV(3x), Fujifilm X-H2(3x), Canon EOS R6(4x) ', '2023-05-22 20:56:33', '2023-05-25 20:56:33', 2, 'COMPLETED'),
(3, 'user', 33, 12705000, 'Fujifilm X-H2(3x), Sony A7 IV(2x), Canon EOS R6(4x) ', '2023-05-22 21:05:51', '2023-06-24 21:05:51', 2, 'COMPLETED'),
(4, 'user', 3, 1110000, 'Canon EOS R6(3x), Fujifilm X-H2(4x), Sony A7 IV(2x) ', '2023-05-22 22:57:51', '2023-05-25 22:57:51', 2, 'COMPLETED'),
(5, 'user', 3, 240000, 'Sony A7 IV(2x) ', '2023-05-23 12:12:59', '2023-05-26 12:12:59', 2, 'COMPLETED');

-- --------------------------------------------------------

--
-- Table structure for table `kamera`
--

CREATE TABLE `kamera` (
  `id` int(11) NOT NULL,
  `model` varchar(30) NOT NULL,
  `merk` varchar(30) NOT NULL,
  `price` int(11) NOT NULL,
  `img` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kamera`
--

INSERT INTO `kamera` (`id`, `model`, `merk`, `price`, `img`) VALUES
(1, 'Sony A7 IV', 'Sony', 40000, '/assets/image/IMG_Sony-A7-IV.png'),
(2, 'Fujifilm X-H2', 'Fujifilm', 35000, '/assets/image/Fujifilm-XH2.png'),
(4, 'Canon EOS R6', 'Canon', 50000, '/assets/image/Canon-EOS-R6 (1).jpg');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `id` int(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `status` varchar(10) NOT NULL,
  `id_user` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`id`, `username`, `password`, `status`, `id_user`) VALUES
(1, 'admin', 'admin', 'admin', NULL),
(2, 'user', 'user', 'user', 2),
(3, 'tes', 'tes', 'user', 3),
(15, 'tes', 'tes1', 'user', 15),
(17, 'tes', 'tes', 'user', 17);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `telepon` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `nama`, `alamat`, `telepon`) VALUES
(2, 'user', 'user', 'user'),
(3, 'tes', 'tes', '123'),
(15, 'tes', 'tes', '123'),
(17, 'dawdaw', 'dwad', '12');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `history`
--
ALTER TABLE `history`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `kamera`
--
ALTER TABLE `kamera`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_user` (`id_user`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `history`
--
ALTER TABLE `history`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `kamera`
--
ALTER TABLE `kamera`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `history`
--
ALTER TABLE `history`
  ADD CONSTRAINT `user_id_riwayat` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Constraints for table `login`
--
ALTER TABLE `login`
  ADD CONSTRAINT `user_info` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
