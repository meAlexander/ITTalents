DROP DATABASE IF EXISTS gas_station;
CREATE DATABASE gas_station;
USE gas_station;

CREATE TABLE `station_loadings` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `kolonka_id` int NOT NULL,
  `fuel_quantity` int NOT NULL,
  `loading_time` datetime NOT NULL,
  `fuel_type` varchar(15) NOT NULL,
   owner_id INT NOT NULL, 
   benzindjiq_id INT NOT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;