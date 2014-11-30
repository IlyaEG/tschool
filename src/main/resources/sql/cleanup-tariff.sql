
USE `ECareDB`;
LOCK TABLES `tariff` WRITE;
/*!40000 ALTER TABLE `tariff` DISABLE KEYS */;
DELETE FROM `tariff` WHERE name like 'test-tariff';
/*!40000 ALTER TABLE `tariff` ENABLE KEYS */;
UNLOCK TABLES;
