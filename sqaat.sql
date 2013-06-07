-- phpMyAdmin SQL Dump
-- version 3.4.10.1
-- http://www.phpmyadmin.net
--
-- Värd: localhost
-- Skapad: 06 jun 2013 kl 07:06
-- Serverversion: 5.5.20
-- PHP-version: 5.3.10

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Databas: `sqaat`
--

-- --------------------------------------------------------

--
-- Tabellstruktur `gunsmith`
--

CREATE TABLE IF NOT EXISTS `gunsmith` (
  `id` int(11) NOT NULL,
  `location` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumpning av Data i tabell `gunsmith`
--

INSERT INTO `gunsmith` (`id`, `location`) VALUES
(1, 'Harbin');

-- --------------------------------------------------------

--
-- Tabellstruktur `item`
--

CREATE TABLE IF NOT EXISTS `item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `price` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumpning av Data i tabell `item`
--

INSERT INTO `item` (`id`, `name`, `price`) VALUES
(1, 'lock', 45),
(2, 'stock', 30),
(3, 'barrel', 25);

-- --------------------------------------------------------

--
-- Tabellstruktur `sale`
--

CREATE TABLE IF NOT EXISTS `sale` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `salesperson` int(11) NOT NULL,
  `town` int(11) NOT NULL, 
  `item` int(11) NOT NULL,
  `date` date NOT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellstruktur `salesperson`
--

CREATE TABLE IF NOT EXISTS `salesperson` (
  `id` int(11) NOT NULL,
  `gunsmith` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `gunsmith` (`gunsmith`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumpning av Data i tabell `salesperson`
--

INSERT INTO `salesperson` (`id`, `gunsmith`) VALUES
(2, 1),
(3, 1);

-- --------------------------------------------------------

--
-- Tabellstruktur `town`
--

CREATE TABLE IF NOT EXISTS `town` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumpning av Data i tabell `town`
--

INSERT INTO `town` (`id`, `name`) VALUES
(1, 'Phoenix'),
(2, 'Tucson'),
(3, 'Mesa'),
(4, 'Chandler'),
(5, 'Glendale');

-- --------------------------------------------------------

--
-- Tabellstruktur `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumpning av Data i tabell `user`
--

INSERT INTO `user` (`id`, `name`, `password`) VALUES
(1, 'gunner', 'gunner'),
(2, 'niklas', 'niklas'),
(3, 'david', 'david');

--
-- Restriktioner för dumpade tabeller
--

--
-- Restriktioner för tabell `gunsmith`
--
ALTER TABLE `gunsmith`
  ADD CONSTRAINT `gunsmith_ibfk_1` FOREIGN KEY (`id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Restriktioner för tabell `sale`
--
ALTER TABLE `sale`
  ADD CONSTRAINT `sale_ibfk_1` FOREIGN KEY (`salesperson`) REFERENCES `salesperson` (`id`),
  ADD CONSTRAINT `sale_ibfk_2` FOREIGN KEY (`town`) REFERENCES `town` (`id`),
  ADD CONSTRAINT `sale_ibfk_3` FOREIGN KEY (`item`) REFERENCES `item` (`id`);

--
-- Restriktioner för tabell `salesperson`
--
ALTER TABLE `salesperson`
  ADD CONSTRAINT `salesperson_ibfk_1` FOREIGN KEY (`id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `salesperson_ibfk_2` FOREIGN KEY (`gunsmith`) REFERENCES `gunsmith` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
