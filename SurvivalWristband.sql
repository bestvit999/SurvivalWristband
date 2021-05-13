-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- 主機: 127.0.0.1:3306
-- 產生時間： 2017-12-24 08:43:19
-- 伺服器版本: 5.7.19-log
-- PHP 版本： 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 資料庫： `sa`
--

-- --------------------------------------------------------

--
-- 資料表結構 `daily state table`
--

DROP TABLE IF EXISTS `daily state table`;
CREATE TABLE IF NOT EXISTS `daily state table` (
  `dailyNumber` int(11) NOT NULL,
  `idleTime` double NOT NULL,
  `roomTemperature` double NOT NULL,
  PRIMARY KEY (`dailyNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- 資料表結構 `medical history table`
--

DROP TABLE IF EXISTS `medical history table`;
CREATE TABLE IF NOT EXISTS `medical history table` (
  `medical_number` int(10) NOT NULL,
  `account` int(11) NOT NULL,
  `physical_number` int(10) NOT NULL,
  `daily_number` int(10) NOT NULL,
  PRIMARY KEY (`medical_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 資料表結構 `physical state table`
--

DROP TABLE IF EXISTS `physical state table`;
CREATE TABLE IF NOT EXISTS `physical state table` (
  `physicalNumber` int(11) NOT NULL,
  `bodyTemperature` double NOT NULL,
  `pulse` double NOT NULL,
  `shakeCount` int(11) NOT NULL,
  PRIMARY KEY (`physicalNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- 資料表結構 `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `account` int(10) NOT NULL,
  `password` text NOT NULL,
  `userName` text NOT NULL,
  `emergency_phoneNumber` text NOT NULL,
  `emergency_contact_person` text NOT NULL,
  `address` text NOT NULL,
  PRIMARY KEY (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- 資料表結構 `wristband system table`
--

DROP TABLE IF EXISTS `wristband system table`;
CREATE TABLE IF NOT EXISTS `wristband system table` (
  `sucessfulOrnot` tinyint(1) NOT NULL,
  `account` int(10) NOT NULL,
  PRIMARY KEY (`account`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
