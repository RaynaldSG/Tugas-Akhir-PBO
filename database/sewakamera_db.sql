-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 23, 2023 at 12:29 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sewakamera_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `data_sewa`
--

CREATE TABLE `data_sewa` (
  `id` int(11) NOT NULL,
  `id_history` int(11) NOT NULL,
  `id_kamera` int(11) DEFAULT NULL,
  `model` varchar(30) NOT NULL,
  `merk` varchar(30) NOT NULL,
  `price` int(11) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `status` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `data_sewa`
--

INSERT INTO `data_sewa` (`id`, `id_history`, `id_kamera`, `model`, `merk`, `price`, `jumlah`, `status`) VALUES
(2, 9, 4, '', '', 0, 1, 'Belum Dikembalikan'),
(3, 10, 4, '', '', 0, 3, 'Belum Dikembalikan'),
(5, 11, 1, '', '', 0, 2, 'Belum Dikembalikan'),
(6, 11, 4, '', '', 0, 3, 'Belum Dikembalikan'),
(8, 12, 4, '', '', 0, 2, 'Dikembalikan'),
(11, 13, 4, '', '', 0, 1, 'Dikembalikan'),
(12, 14, 4, '', '', 0, 1, 'Dikembalikan'),
(15, 15, 4, '', '', 0, 1, 'Dikembalikan'),
(17, 16, 4, '', '', 0, 1, 'Dikembalikan'),
(18, 16, 1, '', '', 0, 3, 'Dikembalikan'),
(20, 17, 4, '', '', 0, 2, 'Dikembalikan'),
(21, 17, 1, '', '', 0, 3, 'Dikembalikan'),
(23, 18, 4, '', '', 0, 2, 'Dikembalikan'),
(24, 18, 2, '', '', 0, 1, 'Dikembalikan'),
(25, 18, 1, '', '', 0, 3, 'Dikembalikan'),
(27, 19, 4, '', '', 0, 2, 'Dikembalikan'),
(28, 19, 1, '', '', 0, 3, 'Dikembalikan'),
(30, 20, 4, '', '', 0, 3, 'Dikembalikan'),
(31, 21, 1, '', '', 0, 2, 'Dikembalikan'),
(34, 24, NULL, '', '', 0, 3, 'Dikembalikan'),
(35, 25, 1, '', '', 0, 2, 'Dikembalikan'),
(36, 26, 10, '', '', 0, 3, 'Dikembalikan'),
(37, 27, 10, '', '', 0, 3, 'Dikembalikan'),
(38, 28, 10, '', '', 0, 2, 'Dikembalikan'),
(39, 29, 10, '', '', 0, 1, 'Dikembalikan'),
(40, 30, 10, '', '', 0, 2, 'Dikembalikan'),
(41, 31, 10, '', '', 0, 1, 'Dikembalikan'),
(42, 32, 1, '', '', 0, 1, 'Dikembalikan'),
(43, 33, 10, 'a', 'a', 20000, 1, 'Dikembalikan'),
(44, 34, 10, 'a', 'a', 20000, 1, 'Dikembalikan'),
(45, 35, 10, 'a', 'a', 20000, 1, 'Dikembalikan'),
(46, 36, 1, 'Sony A7 IV', 'Sony', 40000, 1, 'Dikembalikan'),
(47, 37, 1, 'Sony A7 IV', 'Sony', 40000, 1, 'Belum DIkembalikan'),
(48, 37, 10, 'a', 'a', 20000, 1, 'Belum DIkembalikan');

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `history`
--

INSERT INTO `history` (`id`, `name`, `lama_sewa`, `total`, `description`, `tanggal_pinjam`, `tanggal_tenggat`, `user_id`, `status`) VALUES
(2, 'user', 3, 1275000, 'Sony A7 IV(3x), Fujifilm X-H2(3x), Canon EOS R6(4x) ', '2023-05-22 20:56:33', '2023-05-25 20:56:33', 2, 'COMPLETED'),
(3, 'user', 33, 12705000, 'Fujifilm X-H2(3x), Sony A7 IV(2x), Canon EOS R6(4x) ', '2023-05-22 21:05:51', '2023-06-24 21:05:51', 2, 'COMPLETED'),
(4, 'user', 3, 1110000, 'Canon EOS R6(3x), Fujifilm X-H2(4x), Sony A7 IV(2x) ', '2023-05-22 22:57:51', '2023-05-25 22:57:51', 2, 'COMPLETED'),
(5, 'user', 3, 240000, 'Sony A7 IV(2x) ', '2023-05-23 12:12:59', '2023-05-26 12:12:59', 2, 'COMPLETED'),
(6, 'user', 1, 900000, 'A(45x) ', '2023-06-19 12:14:15', '2023-06-20 12:14:15', 2, 'INCOMPLETED'),
(7, 'user', 2, 290000, 'Sony A7 IV(1x), Fujifilm X-H2(3x) ', '2023-06-19 12:41:07', '2023-06-21 12:41:07', 2, 'INCOMPLETED'),
(8, 'user', 2, 140000, 'Canon EOS R6(1x), A(1x) ', '2023-06-20 20:22:23', '2023-06-22 20:22:23', 2, 'INCOMPLETED'),
(9, 'user', 2, 180000, 'A(2x), Canon EOS R6(1x) ', '2023-06-20 21:14:06', '2023-06-22 21:14:06', 2, 'COMPLETED'),
(10, 'user', 1, 210000, 'Canon EOS R6(3x), A(3x) ', '2023-06-20 21:34:35', '2023-06-21 21:34:35', 2, 'COMPLETED'),
(11, 'user', 1, 290000, 'Sony A7 IV(2x), Canon EOS R6(3x), A(3x) ', '2023-06-20 21:36:24', '2023-06-21 21:36:24', 2, 'COMPLETED'),
(12, 'user', 1, 160000, 'Canon EOS R6(2x), A(3x) ', '2023-06-20 21:38:57', '2023-06-21 21:38:57', 2, 'COMPLETED'),
(13, 'user', 2, 140000, 'A(1x), Canon EOS R6(1x) ', '2023-06-21 16:13:30', '2023-06-23 16:13:30', 2, 'COMPLETED'),
(14, 'user', 3, 210000, 'Canon EOS R6(1x), A(1x) ', '2023-06-21 16:14:45', '2023-06-24 16:14:45', 2, 'COMPLETED'),
(15, 'user', 2, 180000, 'A(2x), Canon EOS R6(1x) ', '2023-06-21 16:15:38', '2023-06-23 16:15:38', 2, 'COMPLETED'),
(16, 'user', 3, 630000, 'A(2x), Canon EOS R6(1x), Sony A7 IV(3x) ', '2023-06-21 16:19:58', '2023-06-24 16:19:58', 2, 'COMPLETED'),
(17, 'user', 10, 2600000, 'A(2x), Canon EOS R6(2x), Sony A7 IV(3x) ', '2023-06-21 16:22:03', '2023-07-01 16:22:03', 2, 'COMPLETED'),
(18, 'user', 22, 6490000, 'A(2x), Canon EOS R6(2x), Fujifilm X-H2(1x), Sony A7 IV(3x) ', '2023-06-21 16:23:15', '2023-07-13 16:23:15', 2, 'COMPLETED'),
(19, 'user', 4, 1040000, 'A(2x), Canon EOS R6(2x), Sony A7 IV(3x) ', '2023-06-21 16:24:44', '2023-06-25 16:24:44', 2, 'COMPLETED'),
(20, 'user', 2, 380000, 'A(2x), Canon EOS R6(3x) ', '2023-06-21 16:27:16', '2023-06-23 16:27:16', 2, 'COMPLETED'),
(21, 'user', 3, 240000, 'Sony A7 IV(2x) ', '2023-06-21 16:36:02', '2023-06-24 16:36:02', 2, 'COMPLETED'),
(22, 'user', 1, 40000, 'A(2x) ', '2023-06-21 21:38:48', '2023-06-22 21:38:48', 2, 'COMPLETED'),
(23, 'user', 1, 40000, 'A(2x) ', '2023-06-21 21:41:21', '2023-06-22 21:41:21', 2, 'COMPLETED'),
(24, 'user', 2, 132, 'a(3x) ', '2023-06-21 21:42:51', '2023-06-23 21:42:51', 2, 'COMPLETED'),
(25, 'user', 2, 160000, 'Sony A7 IV(2x) ', '2023-06-21 22:11:32', '2023-06-23 22:11:32', 2, 'COMPLETED'),
(26, 'user', 2, 120000, 'a(3x) ', '2023-06-22 15:49:17', '2023-06-24 15:49:17', 2, 'COMPLETED'),
(27, 'tes', 2, 120000, 'a(3x) ', '2023-06-22 16:00:11', '2023-06-24 16:00:11', 3, 'COMPLETED'),
(28, 'user', 3, 120000, 'a(2x) ', '2023-06-22 21:03:59', '2023-06-25 21:03:59', 2, 'COMPLETED'),
(29, 'user', 1, 20000, 'a(1x) ', '2023-06-22 21:06:00', '2023-06-23 21:06:00', 2, 'COMPLETED'),
(30, 'user', 1, 40000, 'a(2x) ', '2023-06-22 21:07:07', '2023-06-23 21:07:07', 2, 'COMPLETED'),
(31, 'user', 1, 20000, 'a(1x) ', '2023-06-22 21:08:54', '2023-06-23 21:08:54', 2, 'COMPLETED'),
(32, 'user', 1, 40000, 'Sony A7 IV(1x) ', '2023-06-22 21:10:22', '2023-06-23 21:10:22', 2, 'COMPLETED'),
(33, 'user', 1, 20000, 'a(1x) ', '2023-06-23 16:46:13', '2023-06-24 16:46:13', 2, 'COMPLETED'),
(34, 'user', 1, 20000, 'a(1x) ', '2023-06-23 17:01:01', '2023-06-24 17:01:01', 2, 'COMPLETED'),
(35, 'user', 1, 20000, 'a(1x) ', '2023-06-23 17:03:07', '2023-06-24 17:03:07', 2, 'COMPLETED'),
(36, 'user', 1, 40000, 'Sony A7 IV(1x) ', '2023-06-23 17:04:09', '2023-06-24 17:04:09', 2, 'COMPLETED'),
(37, 'user', 1, 60000, 'Sony A7 IV(1x), a(1x) ', '2023-06-23 17:14:57', '2023-06-24 17:14:57', 2, 'INCOMPLETED');

-- --------------------------------------------------------

--
-- Table structure for table `kamera`
--

CREATE TABLE `kamera` (
  `id` int(11) NOT NULL,
  `model` varchar(30) NOT NULL,
  `merk` varchar(30) NOT NULL,
  `price` int(11) NOT NULL,
  `stock` int(11) NOT NULL,
  `img` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `kamera`
--

INSERT INTO `kamera` (`id`, `model`, `merk`, `price`, `stock`, `img`) VALUES
(1, 'Sony A7 IV', 'Sony', 40000, 1, '/assets/image/IMG_Sony-A7-IV.png'),
(2, 'Fujifilm X-H2', 'Fujifilm', 35000, 1, '/assets/image/Fujifilm-XH2.png'),
(4, 'Canon EOS R6', 'Canon', 50000, 1, '/assets/image/Canon-EOS-R6 (1).jpg'),
(10, 'a', 'a', 20000, 2, '');

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
-- Indexes for table `data_sewa`
--
ALTER TABLE `data_sewa`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_history` (`id_history`),
  ADD KEY `id_kamera` (`id_kamera`);

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
-- AUTO_INCREMENT for table `data_sewa`
--
ALTER TABLE `data_sewa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- AUTO_INCREMENT for table `history`
--
ALTER TABLE `history`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT for table `kamera`
--
ALTER TABLE `kamera`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

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
-- Constraints for table `data_sewa`
--
ALTER TABLE `data_sewa`
  ADD CONSTRAINT `sewa-history` FOREIGN KEY (`id_history`) REFERENCES `history` (`id`),
  ADD CONSTRAINT `sewa-kamera` FOREIGN KEY (`id_kamera`) REFERENCES `kamera` (`id`) ON DELETE SET NULL;

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
