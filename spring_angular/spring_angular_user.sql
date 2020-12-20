-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: spring_angular
-- ------------------------------------------------------
-- Server version	8.0.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `create_at` date DEFAULT NULL,
  `gender` bit(1) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `update_at` date DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,NULL,NULL,NULL,_binary '\0',NULL,'$2a$10$EbQQh3LL4hk6Ap4EwKPZb.zshghn6dmP/ytvBurOTksDMBR94aQVu',_binary '\0',NULL,'phihung1','Phi Hung','hung1@gmail.com'),(2,NULL,NULL,NULL,_binary '\0',NULL,'$2a$10$3WTrur2AJ32ppyGKoWlaKu9NUYMyxMXMkNqvWDZvlZzSFW1UnghpK',_binary '\0',NULL,'phihung2','Phi Hung','hung2@gmail.com'),(3,NULL,NULL,NULL,_binary '\0',NULL,'$2a$10$fIqzQpAoCMztLwjkN8NuSefIg12ABnzfl.lkeTARf15mjz1KZWJni',_binary '\0',NULL,'phihung3','Phi Hung','hung3@gmail.com'),(4,NULL,NULL,NULL,_binary '\0',NULL,'$2a$10$td7XGahDbnOvLTXfCOhSHOwbPiJ8nnp/IcbHxDjH2xfedsawxmIky',_binary '\0',NULL,'phihung4','Phi Hùng','hung4@gmail.com'),(5,NULL,NULL,NULL,_binary '\0',NULL,'$2a$10$TwG1QZbpZpZRM8JowDiJpOWq3RuqDtlye9EjfBDmS9OIgN3G8t/j2',_binary '\0',NULL,'phihung5','Phi Hung ','hung5@gmail.com');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-21  0:20:45
