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
-- Table structure for table `rfq`
--

DROP TABLE IF EXISTS `rfq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `rfq` (
  `rfqID` varchar(45) NOT NULL,
  `PRID` varchar(45) DEFAULT NULL,
  `companyID` varchar(45) DEFAULT NULL,
  `finance_StaffID` varchar(45) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `due_date` date DEFAULT NULL,
  PRIMARY KEY (`rfqID`),
  KEY `pr_id_idx` (`PRID`),
  KEY `company_id_idx` (`companyID`),
  KEY `financestaffid_idx` (`finance_StaffID`),
  CONSTRAINT `company_id` FOREIGN KEY (`companyID`) REFERENCES `company` (`companyid`),
  CONSTRAINT `financestaffid` FOREIGN KEY (`finance_StaffID`) REFERENCES `finance_staff` (`finance_staffid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `pr_id` FOREIGN KEY (`PRID`) REFERENCES `pr` (`prid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rfq`
--

LOCK TABLES `rfq` WRITE;
/*!40000 ALTER TABLE `rfq` DISABLE KEYS */;
INSERT INTO `rfq` VALUES ('RFQ1000','PR1002','C0001','FS0001','2019-05-01','2019-05-18'),('RFQ1001','PR1003','C0001','FS0001','2019-05-18','2019-06-01'),('RFQ1002','PR1001','C0001','FS0001','2019-05-18','2019-01-01'),('RFQ1003','PR1020','C0001','FS0001','2019-05-18','2019-01-02'),('RFQ1004','PR1007','C0001','FS0001','2019-05-20','2019-05-30'),('RFQ1005','PR1026','C0001','FS0001','2019-05-20','2019-12-12'),('RFQ1006','PR1025','C0001','FS0001','2019-05-20','2019-01-01'),('RFQ1007','PR1027','C0001','FS0001','2019-05-20','2019-12-12');
/*!40000 ALTER TABLE `rfq` ENABLE KEYS */;
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
