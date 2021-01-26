-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: purchasereq
-- ------------------------------------------------------
-- Server version	8.0.13

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
-- Table structure for table `pr`
--

DROP TABLE IF EXISTS `pr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pr` (
  `PRID` varchar(10) NOT NULL,
  `date` date DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `reason` varchar(45) DEFAULT NULL,
  `staffID` varchar(45) DEFAULT NULL,
  `managerID` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`PRID`),
  KEY `staffID_idx` (`staffID`),
  KEY `managerID_idx` (`managerID`),
  CONSTRAINT `managerID` FOREIGN KEY (`managerID`) REFERENCES `manager` (`managerid`),
  CONSTRAINT `staffID` FOREIGN KEY (`staffID`) REFERENCES `staff` (`staffid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pr`
--

LOCK TABLES `pr` WRITE;
/*!40000 ALTER TABLE `pr` DISABLE KEYS */;
INSERT INTO `pr` VALUES ('PR1000','2019-01-01','rejected','sorry man','ST1000','MN1000'),('PR1001','2010-01-01','approved','','ST1000','MN1000'),('PR1006','2019-08-01','rejected','i hate you','ST1000','MN1000'),('PR1007','2019-04-04','approved','','ST1000','MN1000'),('PR1008','2019-08-08','approved','','ST1000','MN1000'),('PR1009','2019-05-14','rejected','','ST1000','MN1000'),('PR1010','2019-01-01','rejected','Im sorry','ST1000','MN1000'),('PR1011','2019-12-12','rejected','toz','ST1000','MN1000'),('PR1012','2019-02-02','approved','','ST1000',NULL),('PR1013','2019-02-02','rejected','JUST BECAUSE I CAN','ST1000',NULL),('PR1014','2019-04-15','rejected','sorry','ST1000','MN1000'),('PR1015','2019-04-15','pending','no','ST1001',NULL),('PR1016','2019-04-15','pending','','ST1001',NULL),('PR1017','2019-04-15','pending','','ST1001',NULL),('PR1018','2019-04-15','rejected','no thanks','ST1001',NULL),('PR1019','2019-04-16','approved','','ST1001','MN1000'),('PR1020','2019-04-18','approved','','ST1000','MN1000'),('PR1021','2019-04-19','approved','','ST1001','MN1000'),('PR1022','2019-04-19','approved','','ST1001','MN1000'),('PR1023','2019-04-19','pending',NULL,'ST1001',NULL),('PR1024','2019-04-19','approved','','ST1000','MN1000'),('PR1025','2019-04-20','approved','','ST1001','MN1000'),('PR1026','2019-04-20','approved','','ST1001','MN1000'),('PR1027','2019-04-20','approved','','ST1001','MN1000');
/*!40000 ALTER TABLE `pr` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-20 21:16:19
