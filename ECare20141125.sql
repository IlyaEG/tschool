CREATE DATABASE  IF NOT EXISTS `ECareDB` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `ECareDB`;
-- MySQL dump 10.13  Distrib 5.5.40, for debian-linux-gnu (x86_64)
--
-- Host: 127.0.0.1    Database: ECareDB
-- ------------------------------------------------------
-- Server version	5.5.40-0ubuntu0.14.04.1

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
-- Table structure for table `contract`
--

DROP TABLE IF EXISTS `contract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contract` (
  `number` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `tariff_id` int(11) NOT NULL,
  `locked_by` int(11) DEFAULT NULL,
  PRIMARY KEY (`number`),
  KEY `contract_tariff` (`tariff_id`),
  KEY `contract_customer_id` (`customer_id`),
  KEY `contract_locked_by` (`locked_by`),
  CONSTRAINT `fk_contract_customer_id` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`person_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_contract_locked_by` FOREIGN KEY (`locked_by`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_contract_tariff` FOREIGN KEY (`tariff_id`) REFERENCES `tariff` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract`
--

LOCK TABLES `contract` WRITE;
/*!40000 ALTER TABLE `contract` DISABLE KEYS */;
INSERT INTO `contract` VALUES (15,3,2,NULL),(20,3,1,NULL),(34,4,4,NULL),(48,4,1,NULL),(58,6,3,NULL),(72,7,5,NULL);
/*!40000 ALTER TABLE `contract` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contract_option`
--

DROP TABLE IF EXISTS `contract_option`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contract_option` (
  `contract_number` int(11) NOT NULL,
  `option_id` int(11) NOT NULL,
  PRIMARY KEY (`contract_number`,`option_id`),
  KEY `contract_option_option` (`option_id`),
  KEY `contract_option_contract` (`contract_number`),
  CONSTRAINT `fk_contract_option_contract` FOREIGN KEY (`contract_number`) REFERENCES `contract` (`number`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_contract_option_option` FOREIGN KEY (`option_id`) REFERENCES `option` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract_option`
--

LOCK TABLES `contract_option` WRITE;
/*!40000 ALTER TABLE `contract_option` DISABLE KEYS */;
INSERT INTO `contract_option` VALUES (20,1),(58,2),(15,3),(58,3);
/*!40000 ALTER TABLE `contract_option` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `person_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_passport` varchar(45) NOT NULL,
  `locked` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`person_id`),
  UNIQUE KEY `customer_passport_UNIQUE` (`customer_passport`),
  UNIQUE KEY `UK_o0cl31ufkwyc47ntdqu6d4c48` (`customer_passport`),
  KEY `Customer_person_id` (`person_id`),
  CONSTRAINT `fk_Customer_Person` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (3,'11 11 111 111',1),(4,'22 22 222 222',0),(5,'092371',0),(6,'4536',0),(7,'345642g5',0),(8,'101',0),(9,'4005 684119',0),(10,'a23df4',0);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `person_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`person_id`),
  KEY `employee_person_id` (`person_id`),
  CONSTRAINT `fk_Employee_Person` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `incompatible_option`
--

DROP TABLE IF EXISTS `incompatible_option`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `incompatible_option` (
  `incomp_id_1` int(11) NOT NULL,
  `incomp_id_2` int(11) NOT NULL,
  PRIMARY KEY (`incomp_id_1`,`incomp_id_2`),
  KEY `incompatible_option_1` (`incomp_id_1`),
  KEY `incompatible_option_2` (`incomp_id_2`),
  CONSTRAINT `fk_incompatible_option_1` FOREIGN KEY (`incomp_id_1`) REFERENCES `option` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_incompatible_option_2` FOREIGN KEY (`incomp_id_2`) REFERENCES `option` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `incompatible_option`
--

LOCK TABLES `incompatible_option` WRITE;
/*!40000 ALTER TABLE `incompatible_option` DISABLE KEYS */;
/*!40000 ALTER TABLE `incompatible_option` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `option`
--

DROP TABLE IF EXISTS `option`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `option` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `rate` float NOT NULL,
  `price` float NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  UNIQUE KEY `UK_9ox7f1nspwyvlk3gfhfj9rmmj` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `option`
--

LOCK TABLES `option` WRITE;
/*!40000 ALTER TABLE `option` DISABLE KEYS */;
INSERT INTO `option` VALUES (1,'100 SMS',1.1,1.1),(2,'100 MMS',2.2,2.2),(3,'1 GiB',3.3,3.3),(4,'2 GiB',4.4,4.4),(5,'Home calls',5.5,5.5);
/*!40000 ALTER TABLE `option` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `surname` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `adress` varchar(200) DEFAULT NULL,
  `role_id` int(11) NOT NULL,
  `birthdate` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `person_role_id` (`role_id`),
  CONSTRAINT `fk_Person_Role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,'Super','Admin','a','a@ecare','',1,NULL),(3,'Galileo','Galilei','g','gg@ecare','Italy',2,'1985-01-12'),(4,'Georg','Ohm','g','go@ecare','Germany',2,'1789-03-06'),(5,'Isaac','Newton','i','in@ecare','England',2,'1642-12-25'),(6,'Hermann','surname1','g','gw@ecare','Germany',2,'1885-11-09'),(7,'Richard','Feynman','r','rf@ecare','United States',2,'1918-05-11'),(8,'Enrico','Fermi','e','ef@ecare','Italy',2,'1901-09-29'),(9,'Ilya','Grigoryev','i','i@ecare','Vyborgskoe sh.',2,'1985-11-06'),(10,'test','test','2','2@2','dfwerv',2,'2001-01-01');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `related_option`
--

DROP TABLE IF EXISTS `related_option`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `related_option` (
  `rel_id_1` int(11) NOT NULL,
  `rel_id_2` int(11) NOT NULL,
  PRIMARY KEY (`rel_id_1`,`rel_id_2`),
  KEY `RelatedOption_1` (`rel_id_1`),
  KEY `RelatedOption_2` (`rel_id_2`),
  CONSTRAINT `fk_RelatedOption_1` FOREIGN KEY (`rel_id_1`) REFERENCES `option` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_RelatedOption_2` FOREIGN KEY (`rel_id_2`) REFERENCES `option` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `related_option`
--

LOCK TABLES `related_option` WRITE;
/*!40000 ALTER TABLE `related_option` DISABLE KEYS */;
/*!40000 ALTER TABLE `related_option` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  UNIQUE KEY `UK_8sewwnpamngi6b1dwaa88askk` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (2,'customer'),(1,'employee');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tariff`
--

DROP TABLE IF EXISTS `tariff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tariff` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `rate` float NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Name_UNIQUE` (`name`),
  UNIQUE KEY `UK_paeau3s55i9vxqwoioinyjwjt` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tariff`
--

LOCK TABLES `tariff` WRITE;
/*!40000 ALTER TABLE `tariff` DISABLE KEYS */;
INSERT INTO `tariff` VALUES (1,'Calls+SMS',2.2),(2,'JustCalls',3.3),(3,'Cheap',5.5),(4,'Internet',100),(5,'Ultd.',100500);
/*!40000 ALTER TABLE `tariff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tariff_option`
--

DROP TABLE IF EXISTS `tariff_option`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tariff_option` (
  `option_id` int(11) NOT NULL,
  `tariff_id` int(11) NOT NULL,
  PRIMARY KEY (`option_id`,`tariff_id`),
  KEY `tariff_option_tariff` (`tariff_id`),
  KEY `tariff_option_option` (`option_id`),
  CONSTRAINT `fk_tariff_option_option` FOREIGN KEY (`option_id`) REFERENCES `option` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tariff_option_tariff` FOREIGN KEY (`tariff_id`) REFERENCES `tariff` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tariff_option`
--

LOCK TABLES `tariff_option` WRITE;
/*!40000 ALTER TABLE `tariff_option` DISABLE KEYS */;
INSERT INTO `tariff_option` VALUES (1,1),(2,1),(3,1),(4,1),(5,1),(3,2),(4,2),(1,3),(2,3),(3,3),(4,3),(5,5);
/*!40000 ALTER TABLE `tariff_option` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-11-25 19:31:17
