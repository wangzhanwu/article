-- MySQL dump 10.10
--
-- Host: localhost    Database: article
-- ------------------------------------------------------
-- Server version	5.0.22-community-nt

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `t_article`
--

DROP TABLE IF EXISTS `t_article`;
CREATE TABLE `t_article` (
  `id` varchar(32) NOT NULL,
  `title` varchar(100) NOT NULL,
  `content` text,
  `author` varchar(60) NOT NULL,
  `description` varchar(200) default NULL,
  `is_published` varchar(1) NOT NULL default '1',
  `is_delete` varchar(1) NOT NULL default '0',
  `create_time` datetime NOT NULL,
  `update_time` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `user_id` varchar(32) NOT NULL,
  `category_id` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `t_article`
--


/*!40000 ALTER TABLE `t_article` DISABLE KEYS */;
LOCK TABLES `t_article` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `t_article` ENABLE KEYS */;

--
-- Table structure for table `t_category`
--

DROP TABLE IF EXISTS `t_category`;
CREATE TABLE `t_category` (
  `category_id` int(11) NOT NULL auto_increment,
  `category_name` varchar(20) NOT NULL,
  PRIMARY KEY  (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `t_category`
--


/*!40000 ALTER TABLE `t_category` DISABLE KEYS */;
LOCK TABLES `t_category` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `t_category` ENABLE KEYS */;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` varchar(32) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `photo` varchar(1024) default NULL,
  `email` varchar(60) default NULL,
  `sex` varchar(2) default NULL,
  `address` varchar(100) default NULL,
  `nickname` varchar(30) default NULL,
  `description` varchar(200) default NULL,
  `age` int(11) default NULL,
  `is_delete` varchar(1) default NULL,
  `create_time` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `modify_time` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `t_user`
--


/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
LOCK TABLES `t_user` WRITE;
INSERT INTO `t_user` VALUES ('42b9fa056de1422fab0c308f80456700','wang','123456',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-05-10 13:02:22',NULL),('7376f4c05e1744cdb9dd95e3eea96921','zhan','123456',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-05-11 07:08:04',NULL),('9d708bcfa09048aea679b1eccce8b419','wu','123456',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-05-11 09:20:45',NULL),('fa03e4d4cbe04f62b1a6b908afb31871','王占武','123456',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-05-12 13:24:22',NULL);
UNLOCK TABLES;
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

