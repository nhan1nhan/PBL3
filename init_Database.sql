-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: localhost    Database: databasepbl3
-- ------------------------------------------------------
-- Server version	9.2.0

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
-- Table structure for table `barn`
--

DROP TABLE IF EXISTS `barn`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `barn` (
  `idBarn` int NOT NULL AUTO_INCREMENT,
  `nameBarn` varchar(10) NOT NULL,
  `numPig` int NOT NULL,
  `capacity` int NOT NULL,
  PRIMARY KEY (`idBarn`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `barn`
--

LOCK TABLES `barn` WRITE;
/*!40000 ALTER TABLE `barn` DISABLE KEYS */;
INSERT INTO `barn` VALUES (1,'Chuồng A',0,500),(2,'Chuồng B',0,500),(3,'Chuồng C',0,500),(4,'Chuồng D',0,500);
/*!40000 ALTER TABLE `barn` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entry`
--

DROP TABLE IF EXISTS `entry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `entry` (
  `idEntry` int NOT NULL AUTO_INCREMENT,
  `idBarn` int NOT NULL,
  `date` date NOT NULL,
  `number` int NOT NULL,
  `idUser` int NOT NULL,
  PRIMARY KEY (`idEntry`),
  KEY `idUserEntry_idx` (`idUser`),
  KEY `idBarnEntry_idx` (`idBarn`),
  CONSTRAINT `idBarnEntry` FOREIGN KEY (`idBarn`) REFERENCES `barn` (`idBarn`),
  CONSTRAINT `idUserEntry` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entry`
--

LOCK TABLES `entry` WRITE;
/*!40000 ALTER TABLE `entry` DISABLE KEYS */;
/*!40000 ALTER TABLE `entry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `export`
--

DROP TABLE IF EXISTS `export`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `export` (
  `idExport` int NOT NULL AUTO_INCREMENT,
  `idBarn` int NOT NULL,
  `date` date NOT NULL,
  `number` int NOT NULL,
  `idUser` int NOT NULL,
  PRIMARY KEY (`idExport`),
  KEY `idUserExport_idx` (`idUser`),
  KEY `idBarnExport_idx` (`idBarn`),
  CONSTRAINT `idBarnExport` FOREIGN KEY (`idBarn`) REFERENCES `barn` (`idBarn`),
  CONSTRAINT `idUserExport` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `export`
--

LOCK TABLES `export` WRITE;
/*!40000 ALTER TABLE `export` DISABLE KEYS */;
/*!40000 ALTER TABLE `export` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fcsd`
--

DROP TABLE IF EXISTS `fcsd`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fcsd` (
  `idFcsd` int NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `weight` int NOT NULL,
  `idUser` int NOT NULL,
  `idFood` int NOT NULL,
  PRIMARY KEY (`idFcsd`),
  KEY `idUser_idx` (`idUser`),
  KEY `idFood_idx` (`idFood`),
  CONSTRAINT `idFood` FOREIGN KEY (`idFood`) REFERENCES `food` (`idFood`),
  CONSTRAINT `idUser` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fcsd`
--

LOCK TABLES `fcsd` WRITE;
/*!40000 ALTER TABLE `fcsd` DISABLE KEYS */;
/*!40000 ALTER TABLE `fcsd` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `food`
--

DROP TABLE IF EXISTS `food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `food` (
  `idFood` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `price` int NOT NULL,
  PRIMARY KEY (`idFood`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `food`
--

LOCK TABLES `food` WRITE;
/*!40000 ALTER TABLE `food` DISABLE KEYS */;
INSERT INTO `food` VALUES (1,'Cám ',25000),(2,'Rau củ lộn xộn',15000),(3,'Bã rượu ',10000);
/*!40000 ALTER TABLE `food` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lost`
--

DROP TABLE IF EXISTS `lost`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lost` (
  `idlost` int NOT NULL AUTO_INCREMENT,
  `idBarn` int NOT NULL,
  `idUser` int NOT NULL,
  `date` datetime NOT NULL,
  `number` varchar(45) NOT NULL,
  `reason` varchar(45) NOT NULL,
  PRIMARY KEY (`idlost`),
  KEY `idUser_idx` (`idUser`),
  KEY `idUser_lost_idx` (`idUser`),
  KEY `idUserLost_idx` (`idUser`),
  KEY `idBarnLost_idx` (`idBarn`),
  CONSTRAINT `idBarnLost` FOREIGN KEY (`idBarn`) REFERENCES `barn` (`idBarn`),
  CONSTRAINT `idUserLost` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lost`
--

LOCK TABLES `lost` WRITE;
/*!40000 ALTER TABLE `lost` DISABLE KEYS */;
/*!40000 ALTER TABLE `lost` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `idUser` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `user` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `status` tinyint NOT NULL DEFAULT '1',
  `decent` tinyint NOT NULL,
  PRIMARY KEY (`idUser`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Nguyễn Xuân Tâm','xuantam123','123456',1,1),(2,'Nguyễn Hữu Nhân','nguyenhuunhan123','150905',1,0),(3,'Đào Hữu Quý','quydao0506','050605',1,0),(4,'Trương Ngọc Long','ngoclong2307','230705',0,0);
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

-- Dump completed on 2025-05-06 17:47:21
