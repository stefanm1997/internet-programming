-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: ip_aero
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Dumping data for table `access_number`
--

LOCK TABLES `access_number` WRITE;
/*!40000 ALTER TABLE `access_number` DISABLE KEYS */;
INSERT INTO `access_number` VALUES (5,'2021-09-14',8),(13,'2021-09-15',13),(14,'2021-09-16',1),(15,'2021-09-17',53),(16,'2021-09-20',5),(17,'2021-09-22',2),(18,'2021-09-27',1),(19,'2021-09-28',1),(20,'2021-09-29',30),(21,'2021-09-30',18),(22,'2021-10-01',9),(23,'2021-10-02',5),(24,'2021-10-03',17),(25,'2021-10-04',2);
/*!40000 ALTER TABLE `access_number` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `admin_user`
--

LOCK TABLES `admin_user` WRITE;
/*!40000 ALTER TABLE `admin_user` DISABLE KEYS */;
INSERT INTO `admin_user` VALUES (1,'admin','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918','Admin','Admin'),(2,'test','9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08','Test','Test');
/*!40000 ALTER TABLE `admin_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `employer`
--

LOCK TABLES `employer` WRITE;
/*!40000 ALTER TABLE `employer` DISABLE KEYS */;
INSERT INTO `employer` VALUES (1,'test','test','Test','Test'),(3,'proba22','0e85510f97a75739aa35970c47e08178b868238b269c387e0a7abba49bbd4153','proba','proba'),(4,'bla','4df3c3f68fcc83b27e9d42c90431a72499f17875c81a599b566c9889b9696703','bla','bla');
/*!40000 ALTER TABLE `employer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `flight`
--

LOCK TABLES `flight` WRITE;
/*!40000 ALTER TABLE `flight` DISABLE KEYS */;
INSERT INTO `flight` VALUES (1,3,'no descr','no file','type','arrival',1,4),(2,5,'descr','file','type','departure',3,1),(4,11,'descrPUT','filePUT','type','arrival',2,4),(7,3,'bla','bla','worker','arrival',1,2),(11,14,'no','no','worker','departure',2,3),(12,16,'yes','yes','passenger','arrival',4,1),(13,3,'heh','heh','passenger','arrival',2,1),(14,56,'bro','bro','worker','arrival',4,3),(15,10,'mrk','gii','worker','departure',4,2),(16,43,'bla','gro','passenger','departure',4,3),(17,67,'mrk','giii','worker','arrival',1,3),(18,23,NULL,NULL,'worker','arrival',1,4),(20,29,NULL,NULL,'passenger','deaprture',1,3),(22,81,NULL,NULL,'worker','departure',1,3);
/*!40000 ALTER TABLE `flight` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `flight_schedule`
--

LOCK TABLES `flight_schedule` WRITE;
/*!40000 ALTER TABLE `flight_schedule` DISABLE KEYS */;
INSERT INTO `flight_schedule` VALUES (1,1),(2,1),(23,1),(1,2),(3,2),(4,2),(29,2),(2,4),(4,4),(22,4),(25,4),(31,4),(24,7),(30,11),(11,12),(12,12),(13,12),(26,12),(28,12),(27,13),(30,13),(24,14),(29,14),(26,15),(32,15),(32,16),(35,16),(37,16),(32,17),(36,17),(38,17),(40,17),(38,18),(39,18),(40,18),(45,18),(35,20),(41,20),(42,20),(33,22),(34,22),(35,22),(36,22),(37,22),(43,22),(44,22);
/*!40000 ALTER TABLE `flight_schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` VALUES (1,'Serbia ','RS','SRB','Belgrade'),(2,'Croatia','HR','CRO','Zagreb'),(3,'Bih','BA','BIH','Sarajevo'),(4,'Germany','DE','GER','Berlin'),(5,'Montenegro','CG','MNE','Podgorica'),(6,'France','FR','FRA','Paris');
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` VALUES (1,'Subject','Content','Read'),(2,'Sub','Contgggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggdddddddddddddddddddddddaaaaaaaaaaaaaaaaaaaaeggggggggggggasssssssssssssss','Read'),(3,'Naslov','Mail to: test@mail.com\n	Sadrzaj poruke','Read'),(4,'Subject mess','Mail to: proba@hotmail.com\n  	Idi idi moja vilo','New');
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `reservation`
--

LOCK TABLES `reservation` WRITE;
/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
INSERT INTO `reservation` VALUES (1,1,2,'Declined','2021-08-24',''),(3,1,4,'New','2021-09-01',''),(4,2,7,'New','2021-09-29','Razlog'),(5,1,12,'New','2021-10-05',NULL),(6,1,13,'Declined','2021-09-30',NULL),(7,1,1,'Declined','2021-10-19',NULL),(8,1,12,'Declined','2021-10-10',NULL),(9,9,12,'New','2021-10-13',NULL),(10,9,1,'New','2021-10-29',NULL),(11,9,1,'Declined','2021-10-07',NULL),(12,9,1,'New','2021-10-24',NULL),(13,1,7,'Declined','2021-10-31','neki razlog');
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `schedule`
--

LOCK TABLES `schedule` WRITE;
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
INSERT INTO `schedule` VALUES (1,'2021-08-23','monday','15'),(2,'2021-08-22','sunday','11'),(3,'2021-08-21','saturday','18'),(4,'2021-08-21','saturdayPUT','18PUT'),(5,'2021-8-10','monday','15'),(6,'2021-8-28','monday','13'),(7,'2021-8-2','monday','11'),(8,'2021-8-9','wedneesday','15'),(9,'2021-8-31','monday','14'),(10,'2021-8-1','monday','1'),(11,'2021-8-1','monday','1'),(12,'2021-8-1','monday','1'),(13,'2021-8-15','friday','19'),(14,'2021-7-29','test','12'),(15,'2021-8-27','tes','11'),(16,'2021-8-16','wednsday','18'),(17,'2021-8-17','monday','13'),(18,'2021-8-26','wedneesday','13'),(19,'2021-8-26','wedneesday','13'),(20,'2021-8-26','wedneesday','13'),(21,'2021-8-7','monday','6'),(22,'2021-8-8','friday','1'),(23,'2021-09-28','tuesday','14'),(24,'2021-09-28','tuesday','20'),(25,'2021-09-28','tuesday','22'),(26,'2021-09-29','wednesday','10'),(27,'2021-09-27','monday','12'),(28,'2021-09-28','tuesday','19'),(29,'2021-09-29','wednesday','12'),(30,'2021-09-29','wednesday','09'),(31,'2021-10-01','thursday','18'),(32,'2021-10-03','sunday','14'),(33,'2021-10-5','Tuesday','17'),(34,'2021-10-6','Wednesday','10'),(35,'2021-10-05','Tuesday','06'),(36,'2021-10-05','Tuesday','11'),(37,'2021-10-04','Monday','18'),(38,'2021-10-04','Monday','08'),(39,'2021-10-05','Friday','22'),(40,'2021-10-04','Monday','06'),(41,'2021-10-05','Tuesday','09'),(42,'2021-10-04','Monday','12'),(43,'2021-10-06','Wednesday','18'),(44,'2021-10-06','Wednesday','22'),(45,'2021-10-04','Monday','01');
/*!40000 ALTER TABLE `schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'test@mail.com','Marko','Markovic','Street 50','USA','test','9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08','Passenger'),(2,'pero@mail.com','Pero','Peric','Petrov Gaj','RSK','perop','0db9df7d8e7ff24ae5980d8862caf37b60f0e3ef9165630a8d64247c9d42cfd3','tip'),(3,'milincic.s@hotmail.com','bla','bla','bla','Åland','test','9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08','Passenger'),(4,'mrk','hnjo','hnjo','adr','Bulgaria','test','9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08','Worker'),(5,'','','','','Åland','test','9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08','Passenger'),(7,'asg','gasg','gas124','gag','Åland','test','9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08','Passenger'),(8,'fsa','gasg222','bla','gasg','Åland','test','9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08','Passenger'),(9,'mirkom@mail.com','Mirko','Mirkovic','Gradiska','Bosnia','mirkom','62449c2561e9bd39e21203143de197cb1e40af5b4da668ac90ca71a199c93033','Worker'),(10,'mitarm@mail.com','Mitar','Miric','Prnjavor','Germany','mitarm','0bdfc776ce03c81d2488a2d11076744a70035e364f5ff3ad704ce719a04ae66f','Passenger'),(11,'stankos@mail.com','Stanko','Stankovic','Prnjavor','Czech','stankos','c97337e6f88f775ed9d6f8b7ca792e6676abea5bea89eba74ab88478610a6bcf','Passenger'),(12,'petric@mail.com','Petar','Periccc','Trebinje','Bosnia and Herzegovina','perop','7a67c96c77909113c84c1437930dd7f74d154b214c5f6864c17f0c795de86659','Worker');
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

-- Dump completed on 2021-10-04 23:51:27
