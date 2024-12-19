CREATE DATABASE  IF NOT EXISTS `jdbc_demo` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `jdbc_demo`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: jdbc_demo
-- ------------------------------------------------------
-- Server version	8.3.0

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
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'John Doe','john.doe@example.com'),(2,'Jane Smith','jane.smith@example.com'),(3,'Alice Johnson','alice.johnson@example.com'),(4,'James','jamesb@gmail.com'),(5,'Wayne Rooney','Wr10@gmail.com'),(6,'John Brook','Cenab@gmail.com'),(7,'Wayne Rooney','Wr10@gmail.com'),(8,'James Smith','james.smith@example.com'),(9,'Sophia Brown','sophia.brown@example.com'),(10,'Olivia Johnson','olivia.johnson@example.com'),(11,'Liam Taylor','liam.taylor@example.com'),(12,'Mason Anderson','mason.anderson@example.com'),(13,'Lucas Martin','lucas.martin@example.com'),(14,'Ava Clark','ava.clark@example.com'),(15,'Isabella Lewis','isabella.lewis@example.com'),(16,'Elijah Walker','elijah.walker@example.com'),(17,'Amelia Perez','amelia.perez@example.com'),(18,'Harper Hall','harper.hall@example.com'),(19,'Ethan Young','ethan.young@example.com'),(20,'Charlotte King','charlotte.king@example.com'),(21,'Jacob Scott','jacob.scott@example.com'),(22,'Michael Wright','michael.wright@example.com'),(23,'Alexander Green','alexander.green@example.com'),(24,'Ella Adams','ella.adams@example.com'),(25,'Jackson Baker','jackson.baker@example.com'),(26,'Scarlett Nelson','scarlett.nelson@example.com'),(27,'Benjamin Carter','benjamin.carter@example.com'),(28,'Jack Mitchell','jack.mitchell@example.com'),(29,'Zoe Hill','zoe.hill@example.com'),(30,'Mila Harris','mila.harris@example.com'),(31,'Grayson Collins','grayson.collins@example.com'),(32,'Wyatt Rivera','wyatt.rivera@example.com'),(33,'Victoria Green','victoria.green@example.com'),(34,'Madison Cooper','madison.cooper@example.com'),(35,'David Morgan','david.morgan@example.com'),(36,'Chloe Perez','chloe.perez@example.com'),(37,'Maya Cooper','maya.cooper@example.com'),(38,'Matthew Murphy','matthew.murphy@example.com'),(39,'Grace Martinez','grace.martinez@example.com'),(40,'Lily Robinson','lily.robinson@example.com'),(41,'David Lopez','david.lopez@example.com'),(42,'Ella Phillips','ella.phillips@example.com'),(43,'Landon Evans','landon.evans@example.com'),(44,'Sophie Wright','sophie.wright@example.com'),(45,'Dylan Foster','dylan.foster@example.com'),(46,'Evelyn Reed','evelyn.reed@example.com'),(47,'Mason Harris','mason.harris@example.com'),(48,'Aiden Bennett','aiden.bennett@example.com'),(49,'John Martinez','john.martinez@example.com'),(50,'Leo Roberts','leo.roberts@example.com'),(51,'Nora Murphy','nora.murphy@example.com'),(52,'Cameron Turner','cameron.turner@example.com'),(53,'Hannah Ward','hannah.ward@example.com'),(54,'Samuel James','samuel.james@example.com'),(55,'Amos Carter','amos.carter@example.com'),(56,'Natalie Scott','natalie.scott@example.com');
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

-- Dump completed on 2024-12-18 21:56:02
