-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: studyskill
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `asks_and_replies`
--

DROP TABLE IF EXISTS `asks_and_replies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `asks_and_replies` (
  `id_asks_and_answers` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_students` int(10) unsigned NOT NULL,
  `id_teachers` int(10) unsigned NOT NULL,
  `questions` text,
  `answers` text,
  PRIMARY KEY (`id_asks_and_answers`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asks_and_replies`
--

LOCK TABLES `asks_and_replies` WRITE;
/*!40000 ALTER TABLE `asks_and_replies` DISABLE KEYS */;
/*!40000 ALTER TABLE `asks_and_replies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class_of_students`
--

DROP TABLE IF EXISTS `class_of_students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `class_of_students` (
  `id_class_of_students` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_students` int(10) unsigned NOT NULL,
  `id_classes` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id_class_of_students`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_of_students`
--

LOCK TABLES `class_of_students` WRITE;
/*!40000 ALTER TABLE `class_of_students` DISABLE KEYS */;
/*!40000 ALTER TABLE `class_of_students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classes`
--

DROP TABLE IF EXISTS `classes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `classes` (
  `id_classes` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `subject` varchar(20) NOT NULL,
  `id_teachers` int(10) unsigned NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `class_name` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id_classes`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classes`
--

LOCK TABLES `classes` WRITE;
/*!40000 ALTER TABLE `classes` DISABLE KEYS */;
/*!40000 ALTER TABLE `classes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `my_class`
--

DROP TABLE IF EXISTS `my_class`;
/*!50001 DROP VIEW IF EXISTS `my_class`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `my_class` AS SELECT 
 1 AS `class_name`,
 1 AS `subject`,
 1 AS `start_date`,
 1 AS `end_date`,
 1 AS `name`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `receptions`
--

DROP TABLE IF EXISTS `receptions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `receptions` (
  `id_receptions` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_requests` int(10) unsigned NOT NULL,
  `id_teachers` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id_receptions`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receptions`
--

LOCK TABLES `receptions` WRITE;
/*!40000 ALTER TABLE `receptions` DISABLE KEYS */;
/*!40000 ALTER TABLE `receptions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requests`
--

DROP TABLE IF EXISTS `requests`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `requests` (
  `id_requests` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_students` int(11) unsigned NOT NULL,
  `subject` varchar(20) NOT NULL,
  `grade` varchar(5) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `start_time` time NOT NULL,
  `end_time` time NOT NULL,
  `dead_line` datetime NOT NULL,
  `others` text,
  PRIMARY KEY (`id_requests`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requests`
--

LOCK TABLES `requests` WRITE;
/*!40000 ALTER TABLE `requests` DISABLE KEYS */;
/*!40000 ALTER TABLE `requests` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `students` (
  `id_students` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_users` int(10) unsigned NOT NULL,
  `credit` int(11) DEFAULT '0',
  `grade` varchar(5) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_students`),
  UNIQUE KEY `id_users_UNIQUE` (`id_users`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teachers`
--

DROP TABLE IF EXISTS `teachers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `teachers` (
  `id_teachers` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `subject` varchar(20) COLLATE utf8_bin NOT NULL,
  `id_users` int(10) unsigned NOT NULL,
  `school` varchar(15) COLLATE utf8_bin NOT NULL,
  `name` varchar(20) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id_teachers`),
  UNIQUE KEY `id_users_UNIQUE` (`id_users`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='basic information about teachers';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teachers`
--

LOCK TABLES `teachers` WRITE;
/*!40000 ALTER TABLE `teachers` DISABLE KEYS */;
/*!40000 ALTER TABLE `teachers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trade`
--

DROP TABLE IF EXISTS `trade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `trade` (
  `id_trade` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_students` int(10) unsigned NOT NULL,
  `id_classes` int(11) NOT NULL,
  `money` int(11) NOT NULL,
  `datetime` timestamp NOT NULL,
  PRIMARY KEY (`id_trade`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trade`
--

LOCK TABLES `trade` WRITE;
/*!40000 ALTER TABLE `trade` DISABLE KEYS */;
/*!40000 ALTER TABLE `trade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users` (
  `id_users` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nickname` varchar(15) COLLATE utf8_bin NOT NULL,
  `code` varchar(15) COLLATE utf8_bin NOT NULL,
  `age` int(11) NOT NULL,
  `sex` enum('f','m') COLLATE utf8_bin NOT NULL,
  `id_students` int(10) unsigned DEFAULT NULL,
  `id_teachers` int(10) unsigned DEFAULT NULL,
  `real_id` char(18) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id_users`),
  UNIQUE KEY `nickname_UNIQUE` (`nickname`),
  UNIQUE KEY `code_UNIQUE` (`code`),
  UNIQUE KEY `real_id_UNIQUE` (`real_id`),
  UNIQUE KEY `id_myclass_UNIQUE` (`id_students`),
  UNIQUE KEY `id_teachers_UNIQUE` (`id_teachers`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='basic information about students';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `my_class`
--

/*!50001 DROP VIEW IF EXISTS `my_class`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `my_class` AS select `c`.`class_name` AS `class_name`,`c`.`subject` AS `subject`,`c`.`start_date` AS `start_date`,`c`.`end_date` AS `end_date`,`t`.`name` AS `name` from (((`classes` `c` join `teachers` `t`) join `students` `s`) join `class_of_students` `cos`) where ((`cos`.`id_students` = `s`.`id_students`) and (`c`.`id_teachers` = `t`.`id_teachers`) and (`cos`.`id_classes` = `c`.`id_classes`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-09 12:23:06
