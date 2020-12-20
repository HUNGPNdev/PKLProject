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
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `pro_id` bigint NOT NULL AUTO_INCREMENT,
  `create_at` date DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `details` text,
  `guarantee` varchar(255) DEFAULT NULL,
  `part` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `pro_name` varchar(255) DEFAULT NULL,
  `slug` varchar(255) DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `support` varchar(255) DEFAULT NULL,
  `update_at` date DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `cata_id` bigint NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pro_id`),
  KEY `FKihf9u9ele9oc1l5prseu423ab` (`cata_id`),
  CONSTRAINT `FKihf9u9ele9oc1l5prseu423ab` FOREIGN KEY (`cata_id`) REFERENCES `category` (`cata_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (2,NULL,NULL,'Xe Moto Kawasaki Z1000 ABS giá siêu tốt','12 thang','không có',20000,'KAWASSAKI H2rr','KAWASSAKI H2rr',_binary '','rút hồ sơ',NULL,NULL,1,'45_ninja-h2.jpg'),(3,NULL,NULL,'Xe Moto Kawasaki Z1000 ABS giá siêu tốt','12 thang','không có',20000,'KAWASSAKI z1000RR','KAWASSAKI z1000RR',_binary '','rút hồ sơ',NULL,NULL,1,'Z1000RR.jfif'),(4,NULL,NULL,'Xe Moto Kawasaki Z1000 ABS giá siêu tốt','12 thang','không có',15000,'HONDA CBR 1000RR','HONDA CBR 1000RR',_binary '','rút hồ sơ',NULL,NULL,2,'cbr100rr.jpg'),(5,NULL,NULL,'Xe Moto Kawasaki Z1000 ABS giá siêu tốt','12 thang','không có',17000,'SUZUKI GSX R1000','SUZUKI GSX R1000',_binary '','rút hồ sơ',NULL,NULL,6,'suzuki_r1000.jpg'),(6,NULL,NULL,'Xe Moto Kawasaki Z1000 ABS giá siêu tốt','12 thang','không có',18500,'YAMAHA R1','YAMAHA R1',_binary '','rút hồ sơ',NULL,NULL,8,'r1.jpg'),(7,NULL,NULL,'Xe Moto Kawasaki Z1000 ABS giá siêu tốt','12 thang','không có',20000,'BWM S1000rr','BWM S1000rr',_binary '','rút hồ sơ',NULL,NULL,11,'s1000rr.jpg');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
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
