-- MySQL dump 10.13  Distrib 5.6.35, for Win64 (x86_64)
--
-- Host: localhost    Database: student_system
-- ------------------------------------------------------
-- Server version	5.6.35-log

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
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `number` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `age` int(11) NOT NULL,
  `place` varchar(255) NOT NULL,
  `chi` int(11) NOT NULL,
  `math` int(11) NOT NULL,
  `eng` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'101','张三',18,'河南',99,99,99),(2,'102','李四',19,'上海',92,80,55),(3,'103','王五',20,'广东',88,79,88),(4,'104','马六',21,'云南',75,88,99),(5,'105','赵七',17,'云南',88,54,67),(6,'106','陈八',24,'河南',87,77,33),(7,'107','朱九',23,'湖南',91,44,56),(8,'108','小红',8,'湖北',82,77,90),(9,'109','小强',8,'黑龙江',78,35,88),(10,'110','大白',17,'辽宁',73,42,71),(11,'111','小花',20,'上海',73,76,88),(12,'112','小新',7,'天津',59,59,59),(13,'113','小黄',14,'山东',78,30,93),(14,'114','张太难',20,'河南',100,100,100),(15,'115','张杰',40,'湖北',70,71,88),(16,'116','谢娜',40,'湖南',88,39,77),(17,'117','周杰伦',41,'台湾',80,44,20),(18,'118','猪小明',32,'云南',81,60,72),(19,'119','陈翔',36,'云南',71,30,69),(20,'120','王炸',32,'云南',90,41,49),(21,'121','毛台',45,'云南',76,56,57),(22,'122','冷萌',29,'云南',88,82,90),(23,'123','灰太狼',35,'浙江',67,90,74),(24,'124','蕉太狼',18,'四川',72,72,73),(25,'125','红太狼',35,'福建',80,65,72);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-17 10:52:10
