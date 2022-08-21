-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th8 21, 2022 lúc 05:27 PM
-- Phiên bản máy phục vụ: 10.4.24-MariaDB
-- Phiên bản PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `book_table_online`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `account`
--

CREATE TABLE `account` (
  `id` int(11) NOT NULL,
  `username` varchar(250) NOT NULL,
  `password` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `account`
--

INSERT INTO `account` (`id`, `username`, `password`) VALUES
(9, 'user', '$2a$10$BD5qkvA1Uu4vG7rx4zksK.UepRgGXe8GruzBRYpCLoJL6nW1maVJy'),
(10, 'admin', '$2a$10$W1pew0LdKA6yhBXJu7C9DOHATRPE52J7FA9heVnKz8rkpfkw0Etxm'),
(11, 'ADMIN', '$2a$10$GAFizQcR3aYSppSIatW62uU6WYJlcGJCBF.cVCYD16jteHWkj81E.'),
(12, 'acc2', '$2a$10$W1pew0LdKA6yhBXJu7C9DOHATRPE52J7FA9heVnKz8rkpfkw0Etxm'),
(13, 'admin2', '$2a$10$CkaEJYQyrUfoojA8iszBguLB9XiT8VhouUmdk0ix8RpXKImSj3kBa'),
(14, 'admin2', '$2a$10$S1ivt3pnFgzhq0uyIjizH.wu8XrnmPcV0g/Nm/WpqZsbGACFpqrmG'),
(15, 'admin2', '$2a$10$U2xSux58FeFDKghaTiXlYedyshEnXTXsZnNs8zA7M82WDLDjvRiGS'),
(16, 'admin3', '$2a$10$AjoeYRBMwIeIBpMZggHy0u3y3TNi//qbBqK9sQd1HgrJPnQ.qtG.K');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `account_role`
--

CREATE TABLE `account_role` (
  `accountid` int(11) NOT NULL,
  `roleid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `account_role`
--

INSERT INTO `account_role` (`accountid`, `roleid`) VALUES
(9, 2),
(10, 1),
(11, 2),
(12, 2),
(13, 1),
(13, 2),
(14, 2),
(15, 2),
(16, 1),
(16, 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `booking`
--

CREATE TABLE `booking` (
  `id` int(11) NOT NULL,
  `accountid` int(11) NOT NULL,
  `tableid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `booking`
--

INSERT INTO `booking` (`id`, `accountid`, `tableid`) VALUES
(1, 10, 2),
(2, 10, 3),
(3, 10, 4),
(4, 10, 1),
(5, 12, 1),
(6, 12, 2),
(7, 12, 3),
(8, 12, 4),
(9, 12, 1),
(10, 13, 1),
(11, 13, 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `restauranttable`
--

CREATE TABLE `restauranttable` (
  `id` int(11) NOT NULL,
  `seat` int(250) NOT NULL,
  `tabletypeid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `restauranttable`
--

INSERT INTO `restauranttable` (`id`, `seat`, `tabletypeid`) VALUES
(1, 8, 2),
(2, 6, 1),
(3, 12, 2),
(4, 20, 2),
(7, 24, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `role`
--

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `name` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `role`
--

INSERT INTO `role` (`id`, `name`) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tabletype`
--

CREATE TABLE `tabletype` (
  `id` int(11) NOT NULL,
  `name` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `tabletype`
--

INSERT INTO `tabletype` (`id`, `name`) VALUES
(1, '12345'),
(2, 'multiple 2'),
(3, 'new type');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `account_role`
--
ALTER TABLE `account_role`
  ADD PRIMARY KEY (`accountid`,`roleid`),
  ADD KEY `roleid` (`roleid`);

--
-- Chỉ mục cho bảng `booking`
--
ALTER TABLE `booking`
  ADD PRIMARY KEY (`id`),
  ADD KEY `accountid` (`accountid`),
  ADD KEY `tableid` (`tableid`);

--
-- Chỉ mục cho bảng `restauranttable`
--
ALTER TABLE `restauranttable`
  ADD PRIMARY KEY (`id`),
  ADD KEY `tabletypeid` (`tabletypeid`);

--
-- Chỉ mục cho bảng `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `tabletype`
--
ALTER TABLE `tabletype`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `account`
--
ALTER TABLE `account`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT cho bảng `booking`
--
ALTER TABLE `booking`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT cho bảng `restauranttable`
--
ALTER TABLE `restauranttable`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT cho bảng `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `tabletype`
--
ALTER TABLE `tabletype`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `account_role`
--
ALTER TABLE `account_role`
  ADD CONSTRAINT `account_role_ibfk_1` FOREIGN KEY (`accountid`) REFERENCES `account` (`id`),
  ADD CONSTRAINT `account_role_ibfk_2` FOREIGN KEY (`roleid`) REFERENCES `role` (`id`);

--
-- Các ràng buộc cho bảng `booking`
--
ALTER TABLE `booking`
  ADD CONSTRAINT `booking_ibfk_1` FOREIGN KEY (`accountid`) REFERENCES `account` (`id`),
  ADD CONSTRAINT `booking_ibfk_2` FOREIGN KEY (`tableid`) REFERENCES `restauranttable` (`id`);

--
-- Các ràng buộc cho bảng `restauranttable`
--
ALTER TABLE `restauranttable`
  ADD CONSTRAINT `restauranttable_ibfk_1` FOREIGN KEY (`tabletypeid`) REFERENCES `tabletype` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
