DROP DATABASE if exists `alplaneta`;
CREATE DATABASE if not exists `alplaneta`;
USE alplaneta;

CREATE TABLE `local` (
  `idLocal` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idLocal`)
);

CREATE TABLE `rol` (
  `idRol` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`idRol`)
);

CREATE TABLE `login` (
  `idLogin` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(45) NOT NULL,
  `contrasena` varchar(45) NOT NULL,
  `idRol` int(11) NOT NULL,
  `estado` varchar(45) NOT NULL,
  PRIMARY KEY (`idLogin`)
);

CREATE TABLE `administrador` (
  `idAdministrador` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `dni` varchar(10) NOT NULL,
  `idLogin` int(11) NOT NULL,
  `mail` varchar(45) NOT NULL,
  `idLocal` int(11) NOT NULL,
  PRIMARY KEY (`idAdministrador`)
);

CREATE TABLE `administrativo` (
  `idAdministrativo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `dni` varchar(10) NOT NULL,
  `idLogin` int(11) NOT NULL,
  `mail` varchar(45) NOT NULL,
  `idLocal` int(11) NOT NULL,
  PRIMARY KEY (`idAdministrativo`)
);

CREATE TABLE `coordinador` (
  `idCoordinador` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `dni` varchar(10) NOT NULL,
  `idLogin` int(11) NOT NULL,
  `mail` varchar(45) NOT NULL,
  `idLocal` int(11) NOT NULL,
  PRIMARY KEY (`idCoordinador`)
);

CREATE TABLE `contador` (
  `idContador` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `dni` varchar(10) NOT NULL,
  `idLogin` int(11) NOT NULL,
  `mail` varchar(45) NOT NULL,
  `idLocal` int(11) NOT NULL,
  PRIMARY KEY (`idContador`)
);

CREATE TABLE `mediocontacto` (
  `idMedioContacto` int(11) NOT NULL AUTO_INCREMENT,
  `numeroFijo` varchar(45) NOT NULL,
  `numeroCelular` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`idMedioContacto`)
);

CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `dni` varchar(8) NOT NULL,
  `fechaNacimiento` date DEFAULT NULL,
  `idMedioContacto` int(11) NOT NULL,
  `idLogin` int(11) NOT NULL,
  `mail` varchar(45) NOT NULL,
  PRIMARY KEY (`idCliente`)
);


CREATE TABLE `pais` (
  `idPais` int(11) NOT NULL AUTO_INCREMENT,
  `paisnombre` varchar(255) NOT NULL,
  PRIMARY KEY (`idPais`)
);

CREATE TABLE `provincia` (
  `idProvincia` int(11) NOT NULL AUTO_INCREMENT,
  `idPais` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`idProvincia`)
);



CREATE TABLE `ciudad` (
  `idCiudad` int(11) NOT NULL AUTO_INCREMENT,
  `idProvincia` int(11) NOT NULL,
  `ciudadNombre` varchar(255) NOT NULL,
  PRIMARY KEY (`idCiudad`)
);

CREATE TABLE `formapago` (
  `idformapago` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(255) NOT NULL,
  PRIMARY KEY (`idformapago`)
);

CREATE TABLE `pago` (
  `idPago` int(11) AUTO_INCREMENT,
  `idAdministrativo` int(11) NOT NULL,  
  `fechaPago` date NOT NULL,
  `monto` decimal(11,0) NOT NULL,
  `idformapago` int(11),
  PRIMARY KEY (`idPago`)
);

CREATE TABLE `estadospasaje` (
  `idEstadoPasaje` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`idEstadoPasaje`)
);


CREATE TABLE `horario` (
  `idHorario` int(11) NOT NULL AUTO_INCREMENT,
  `hora` varchar(10) NOT NULL,
  PRIMARY KEY (`idHorario`)
);

CREATE TABLE `transporte` (
  `idTransporte` int(11) NOT NULL AUTO_INCREMENT,
  `nombreTransporte` varchar(45) NOT NULL,
  PRIMARY KEY (`idTransporte`)
);

CREATE TABLE `viaje` (
  `idViaje` int(11) NOT NULL AUTO_INCREMENT,
  `fechaSalida` date NOT NULL,
  `fechaLlegada` date NOT NULL,
  `precio` decimal(11,0) NOT NULL,
  `idCiudadOrigen` int(11) NOT NULL,
  `idCiudadDestino` int(11) NOT NULL,
  `idProvinciaOrigen` int(11) NOT NULL,
  `idProvinciaDestino` int(11) NOT NULL,
  `idPaisOrigen` int(11) NOT NULL,
  `idPaisDestino` int(11) NOT NULL,
  `horaSalida` varchar(255) DEFAULT NULL,
  `idTransporte` int(11) NOT NULL,
  `horasEstimadas` int(11) NOT NULL,
  `capacidad` int(11) NOT NULL,
  PRIMARY KEY (`idViaje`)
);

CREATE TABLE `pasaje` (
  `idPasaje` int(11) AUTO_INCREMENT,
  `numeroComprobante` varchar(11) NOT NULL,
  `fechaVencimiento` date,
  `valorViaje` decimal(11,0) NOT NULL,
  `montoAPagar` decimal(11,0) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `idViaje` int(11) NOT NULL,
  `idAdministrativo` int(11) NOT NULL,
  `idEstadoPasaje` int(11) NOT NULL,
  `motivoCancelacion` varchar(45),
  `fechaCancelacion` date,
  PRIMARY KEY (`idPasaje`)
); 

CREATE TABLE `pagos_pasaje` (
  `idPagoPasaje` int(11) NOT NULL AUTO_INCREMENT,
  `idPago` int(11) NOT NULL,
  `idPasaje` int(11)NOT NULL,
  PRIMARY KEY (`idPagoPasaje`)
);

CREATE TABLE `pasajero` (
    `idPasajero` int(11) AUTO_INCREMENT,
    `nombre` varchar(45) NOT NULL,
    `apellido` varchar(45) NOT NULL,
    `dni` varchar(45) NOT NULL,
    `fechaNacimiento` date,
    `telefono` varchar(45) NOT NULL,
    `email` varchar(45),
    PRIMARY KEY (`idPasajero`)
);

CREATE TABLE `pasajes_pasajeros` (
  `idPasajePasajero` int(11) NOT NULL AUTO_INCREMENT,
  `idPasaje` int(11) NOT NULL,
  `idPasajero` int(11) NOT NULL,
  PRIMARY KEY (`idPasajePasajero`)
);

CREATE TABLE `estadoevento`(
  `idEstadoEvento` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`idEstadoEvento`)
);

CREATE TABLE `evento`(
  `idEvento` int(11) NOT NULL AUTO_INCREMENT,
  `fechaIngreso` date NOT NULL,
  `fechaEvento` date NOT NULL,
  `horaEvento` time NOT NULL,
  `descripcion` varchar(60) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `idAdministrativo` int(11) NOT NULL,
  `idEstadoEvento` int(11) NOT NULL,
  `motivoReprogramacion` varchar(600) NOT NULL,
  `visto` int(1) NOT NULL,
  PRIMARY KEY (`idEvento`)
);


CREATE TABLE `regimenpunto`(
`idRegimenPunto` int(11) NOT NULL AUTO_INCREMENT,
 `punto` int(11) NOT NULL,
`ARS`  int(11) NOT NULL,
`vencimiento` int(11) NOT NULL,
 PRIMARY KEY (`idRegimenPunto`)
);

CREATE TABLE `punto` (
  `idPunto` int(11) NOT NULL AUTO_INCREMENT,
  `punto` int(11) NOT NULL,
  `vencimiento` date NOT NULL,  
  `idCliente` int(11) NOT NULL,
  PRIMARY KEY (`idPunto`),
  FOREIGN KEY (`idCliente`)  references cliente(`idCliente`)
);


CREATE TABLE `promocion`(
`idPromocion` int(11) NOT NULL AUTO_INCREMENT,
`porcentaje` int (3) NOT NULL,
`stock` int (11) NOT NULL,
`fechaVencimiento` date NOT NULL,
`estado` varchar(8) NOT NULL,
PRIMARY KEY (`idPromocion`)
);

CREATE TABLE `viaje_promocion` (
  `idViajePromocion` int(11) NOT NULL AUTO_INCREMENT,
  `idViaje` int(11) NOT NULL,
  `idPromocion` int(11)NOT NULL,
  PRIMARY KEY (`idViajePromocion`)
);

CREATE TABLE `tarjeta` (
	`idtarjeta` int(11)  NOT NULL AUTO_INCREMENT,
	`nrotarjeta`  char(16),
	`vencimiento`  char(6),
    PRIMARY KEY(`idtarjeta`)
);

ALTER TABLE `login` ADD FOREIGN KEY (`idRol`) references rol(`idRol`);
ALTER TABLE `administrador` ADD FOREIGN KEY (`idLogin`)  references login(`idLogin`);
ALTER TABLE `administrador` ADD FOREIGN KEY (`idLocal`)  references local(`idLocal`);
ALTER TABLE `administrativo` ADD FOREIGN KEY (`idLogin`)  references login(`idLogin`);
ALTER TABLE `administrativo` ADD FOREIGN KEY (`idLocal`)  references local(`idLocal`);
ALTER TABLE `coordinador` ADD FOREIGN KEY (`idLogin`)  references login(`idLogin`);
ALTER TABLE `coordinador` ADD FOREIGN KEY (`idLocal`)  references local(`idLocal`);
ALTER TABLE `contador` ADD FOREIGN KEY (`idLogin`)  references login(`idLogin`);
ALTER TABLE `contador` ADD FOREIGN KEY (`idLocal`)  references local(`idLocal`);

ALTER TABLE `cliente` ADD FOREIGN KEY (`idMedioContacto`) references mediocontacto(`idMedioContacto`);
ALTER TABLE `cliente` ADD FOREIGN KEY (`idLogin`) references login(`idLogin`);

ALTER TABLE `pago` ADD FOREIGN KEY (`idformapago`) references formapago(`idformapago`);
ALTER TABLE `pago` ADD FOREIGN KEY (`idAdministrativo`) references administrativo(`idAdministrativo`);

ALTER TABLE `provincia` ADD FOREIGN KEY (`idPais`)  references pais(`idPais`);
ALTER TABLE `ciudad` ADD FOREIGN KEY (`idProvincia`) references provincia(`idProvincia`);

ALTER TABLE `viaje` ADD FOREIGN KEY (`idCiudadOrigen`) references ciudad(`idCiudad`);
ALTER TABLE `viaje` ADD FOREIGN KEY (`idCiudadDestino`) references ciudad(`idCiudad`);
ALTER TABLE `viaje` ADD FOREIGN KEY (`idProvinciaOrigen`) references provincia(`idProvincia`);
ALTER TABLE `viaje` ADD FOREIGN KEY (`idProvinciaDestino`) references provincia(`idProvincia`);
ALTER TABLE `viaje` ADD FOREIGN KEY (`idPaisOrigen`) references pais(`idPais`);
ALTER TABLE `viaje` ADD FOREIGN KEY (`idPaisDestino`) references pais(`idPais`);
ALTER TABLE `viaje` ADD FOREIGN KEY (`idTransporte`) references transporte(`idTransporte`);

ALTER TABLE `pasaje` ADD FOREIGN KEY (`idCliente`)  references cliente(`idCliente`);
ALTER TABLE `pasaje` ADD FOREIGN KEY (`idViaje`) references viaje(`idViaje`);
ALTER TABLE `pasaje` ADD FOREIGN KEY (`idAdministrativo`) references administrativo (`idAdministrativo`);
ALTER TABLE `pasaje` ADD FOREIGN KEY (`idEstadoPasaje`) references estadospasaje(`idEstadoPasaje`);

ALTER TABLE `pagos_pasaje` ADD FOREIGN KEY (`idPago`)  references pago(`idPago`);
ALTER TABLE `pagos_pasaje` ADD FOREIGN KEY (`idPasaje`)  references pasaje(`idPasaje`);

ALTER TABLE `pasajes_pasajeros` ADD FOREIGN KEY (`idPasaje`)  references pasaje(`idPasaje`);
ALTER TABLE `pasajes_pasajeros` ADD FOREIGN KEY (`idPasajero`)  references pasajero(`idPasajero`);

ALTER TABLE `evento` ADD FOREIGN KEY (`idCliente`) references cliente(`idCliente`);
ALTER TABLE `evento` ADD FOREIGN KEY (`idAdministrativo`) references administrativo(`idAdministrativo`);
ALTER TABLE `evento` ADD FOREIGN KEY (`idEstadoEvento`) references estadoevento(`idEstadoEvento`);

ALTER TABLE `viaje_promocion` ADD FOREIGN KEY (`idViaje`)  references viaje(`idViaje`);
ALTER TABLE `viaje_promocion` ADD FOREIGN KEY (`idPromocion`)  references promocion(`idPromocion`);

INSERT INTO local VALUES (1,'AlPlaneta First Local','Beltran 887'),(2,'AlPlaneta Ultimate Local','Calle Falsa 123'), (3,'AlPlaneta Last Local', 'Last 001');
INSERT INTO rol VALUES (1,'administrador'),(2,'administrativo'),(3,'coordinador'),(4,'contador'),(5,'cliente');
INSERT INTO login VALUES (1,'sol','sol123',2,'activo'),(2,'lizz','liz123',1,'activo'),(3,'Mica','mica123',3,'activo'),(4,'Seba','seba123',5,'activo'),(5,'nico','nico123',5,'activo'),(9,'sebaContador','123',4,'activo');
INSERT INTO mediocontacto VALUES (1,'44514236','1532691249','lizzmoreno@gmail.com'),(2,'46649865','1546823599','alplanetaproject@gmail.com'),(3,'44329865','1523234598','solhoyos@hotmail.com'),(4,'44513295','1546853265','avila_nico@yahoo.com'),(5,'44661634','1598564571','juan.p@gmail.com'),(6,'44513269','1562773216','pepito.lopez@hotmail.com'),(7,'44519723','1565379812','legrand_mirta@yahoo.com.ar');
INSERT INTO administrador VALUES (1,'lizz',2,'moreno.lizk@gmail.com',1);
INSERT INTO administrativo VALUES (1,'solAdministrativa',1,'hoyos.mariasol@gmail.com',1);
INSERT INTO coordinador VALUES(1,'MicaCoordinadora',3,'micavera@gmail.com',1);
INSERT INTO contador VALUES(1,'SebasContador',9,'sebas@gmail.com',1);

INSERT INTO pais VALUES (1,'Australia'),(2,'Austria'),(3,'Azerbaiyán'),(4,'Anguilla'),(5,'Argentina'),(6,'Armenia'),(7,'Bielorrusia'),(8,'Belice'),(9,'Bélgica'),(10,'Bermudas'),(11,'Bulgaria'),(12,'Brasil'),(13,'Reino Unido'),(14,'Hungría'),(15,'Vietnam'),(16,'Haiti'),(17,'Guadalupe'),(18,'Alemania'),(19,'Países Bajos, Holanda'),(20,'Grecia'),(21,'Georgia'),(22,'Dinamarca'),(23,'Egipto'),(24,'Israel'),(25,'India'),(26,'Irán'),(27,'Irlanda'),(28,'España'),(29,'Italia'),(30,'Kazajstán'),(31,'Camerún'),(32,'Canadá'),(33,'Chipre'),(34,'Kirguistán'),(35,'China'),(36,'Costa Rica'),(37,'Kuwait'),(38,'Letonia'),(39,'Libia'),(40,'Lituania'),(41,'Luxemburgo'),(42,'México'),(43,'Moldavia'),(44,'Mónaco'),(45,'Nueva Zelanda'),(46,'Noruega'),(47,'Polonia'),(48,'Portugal'),(49,'Reunión'),(50,'Rusia'),(51,'El Salvador'),(52,'Eslovaquia'),(53,'Eslovenia'),(54,'Surinam'),(55,'Estados Unidos'),(56,'Tadjikistan'),(57,'Turkmenistan'),(58,'Islas Turcas y Caicos'),(59,'Turquía'),(60,'Uganda'),(61,'Uzbekistán'),(62,'Ucrania'),(63,'Finlandia'),(64,'Francia'),(65,'República Checa'),(66,'Suiza'),(67,'Suecia'),(68,'Estonia'),(69,'Corea del Sur'),(70,'Japón'),(71,'Croacia'),(72,'Rumanía'),(73,'Hong Kong'),(74,'Indonesia'),(75,'Jordania'),(76,'Malasia'),(77,'Singapur'),(78,'Taiwan'),(79,'Bosnia y Herzegovina'),(80,'Bahamas'),(81,'Chile'),(82,'Colombia'),(83,'Islandia'),(84,'Corea del Norte'),(85,'Macedonia'),(86,'Malta'),(87,'Pakistán'),(88,'Papúa-Nueva Guinea'),(89,'Perú'),(90,'Filipinas'),(91,'Arabia Saudita'),(92,'Tailandia'),(93,'Emiratos árabes Unidos'),(94,'Groenlandia'),(95,'Venezuela'),(96,'Zimbabwe'),(97,'Kenia'),(98,'Algeria'),(99,'Líbano'),(100,'Botsuana'),(101,'Tanzania'),(102,'Namibia'),(103,'Ecuador'),(104,'Marruecos'),(105,'Ghana'),(106,'Siria'),(107,'Nepal'),(108,'Mauritania'),(109,'Seychelles'),(110,'Paraguay'),(111,'Uruguay'),(112,'Congo (Brazzaville)'),(113,'Cuba'),(114,'Albania'),(115,'Nigeria'),(116,'Zambia'),(117,'Mozambique'),(119,'Angola'),(120,'Sri Lanka'),(121,'Etiopía'),(122,'Túnez'),(123,'Bolivia'),(124,'Panamá'),(125,'Malawi'),(126,'Liechtenstein'),(127,'Bahrein'),(128,'Barbados'),(130,'Chad'),(131,'Man, Isla de'),(132,'Jamaica'),(133,'Malí'),(134,'Madagascar'),(135,'Senegal'),(136,'Togo'),(137,'Honduras'),(138,'República Dominicana'),(139,'Mongolia'),(140,'Irak'),(141,'Sudáfrica'),(142,'Aruba'),(143,'Gibraltar'),(144,'Afganistán'),(145,'Andorra'),(147,'Antigua y Barbuda'),(149,'Bangladesh'),(151,'Benín'),(152,'Bután'),(154,'Islas Virgenes Británicas'),(155,'Brunéi'),(156,'Burkina Faso'),(157,'Burundi'),(158,'Camboya'),(159,'Cabo Verde'),(164,'Comores'),(165,'Congo (Kinshasa)'),(166,'Cook, Islas'),(168,'Costa de Marfil'),(169,'Djibouti, Yibuti'),(171,'Timor Oriental'),(172,'Guinea Ecuatorial'),(173,'Eritrea'),(175,'Feroe, Islas'),(176,'Fiyi'),(178,'Polinesia Francesa'),(180,'Gabón'),(181,'Gambia'),(184,'Granada'),(185,'Guatemala'),(186,'Guernsey'),(187,'Guinea'),(188,'Guinea-Bissau'),(189,'Guyana'),(193,'Jersey'),(195,'Kiribati'),(196,'Laos'),(197,'Lesotho'),(198,'Liberia'),(200,'Maldivas'),(201,'Martinica'),(202,'Mauricio'),(205,'Myanmar'),(206,'Nauru'),(207,'Antillas Holandesas'),(208,'Nueva Caledonia'),(209,'Nicaragua'),(210,'Níger'),(212,'Norfolk Island'),(213,'Omán'),(215,'Isla Pitcairn'),(216,'Qatar'),(217,'Ruanda'),(218,'Santa Elena'),(219,'San Cristobal y Nevis'),(220,'Santa Lucía'),(221,'San Pedro y Miquelón'),(222,'San Vincente y Granadinas'),(223,'Samoa'),(224,'San Marino'),(225,'San Tomé y Príncipe'),(226,'Serbia y Montenegro'),(227,'Sierra Leona'),(228,'Islas Salomón'),(229,'Somalia'),(232,'Sudán'),(234,'Swazilandia'),(235,'Tokelau'),(236,'Tonga'),(237,'Trinidad y Tobago'),(239,'Tuvalu'),(240,'Vanuatu'),(241,'Wallis y Futuna'),(242,'Sáhara Occidental'),(243,'Yemen'),(246,'Puerto Rico');
INSERT INTO provincia VALUES (1,3,'Azerbaijan'),(2,3,'Nargorni Karabakh'),(3,3,'Nakhichevanskaya Region'),(4,4,'Anguilla'),(5,7,'Brestskaya obl.'),(6,7,'Vitebskaya obl.'),(7,7,'Gomelskaya obl.'),(8,7,'Grodnenskaya obl.'),(9,7,'Minskaya obl.'),(10,7,'Mogilevskaya obl.'),(11,8,'Belize'),(12,10,'Hamilton'),(13,15,'Dong Bang Song Cuu Long'),(14,15,'Dong Bang Song Hong'),(15,15,'Dong Nam Bo'),(16,15,'Duyen Hai Mien Trung'),(17,15,'Khu Bon Cu'),(18,15,'Mien Nui Va Trung Du'),(19,15,'Thai Nguyen'),(20,16,'Artibonite'),(21,16,'Grand&#039;Anse'),(22,16,'North West'),(23,16,'West'),(24,16,'South'),(25,16,'South East'),(26,17,'Grande-Terre'),(27,17,'Basse-Terre'),(28,21,'Abkhazia'),(29,21,'Ajaria'),(30,21,'Georgia'),(31,21,'South Ossetia'),(32,23,'Al QÄhira'),(33,23,'Aswan'),(34,23,'Asyut'),(35,23,'Beni Suef'),(36,23,'Gharbia'),(37,23,'Damietta'),(38,24,'Southern District'),(39,24,'Central District'),(40,24,'Northern District'),(41,24,'Haifa'),(42,24,'Tel Aviv'),(43,24,'Jerusalem'),(44,25,'Bangala'),(45,25,'Chhattisgarh'),(46,25,'Karnataka'),(47,25,'Uttaranchal'),(48,25,'Andhara Pradesh'),(49,25,'Assam'),(50,25,'Bihar'),(51,25,'Gujarat'),(52,25,'Jammu and Kashmir'),(53,25,'Kerala'),(54,25,'Madhya Pradesh'),(55,25,'Manipur'),(56,25,'Maharashtra'),(57,25,'Megahalaya'),(58,25,'Orissa'),(59,25,'Punjab'),(60,25,'Pondisheri'),(61,25,'Rajasthan'),(62,25,'Tamil Nadu'),(63,25,'Tripura'),(64,25,'Uttar Pradesh'),(65,25,'Haryana'),(66,25,'Chandigarh'),(67,26,'Azarbayjan-e Khavari'),(68,26,'Esfahan'),(69,26,'Hamadan'),(70,26,'Kordestan'),(71,26,'Markazi'),(72,26,'Sistan-e Baluches'),(73,26,'Yazd'),(74,26,'Kerman'),(75,26,'Kermanshakhan'),(76,26,'Mazenderan'),(77,26,'Tehran'),(78,26,'Fars'),(79,26,'Horasan'),(80,26,'Husistan'),(81,30,'Aktyubinskaya obl.'),(82,30,'Alma-Atinskaya obl.'),(83,30,'Vostochno-Kazahstanskaya obl.'),(84,30,'Gurevskaya obl.'),(85,30,'Zhambylskaya obl. (Dzhambulskaya obl.)'),(86,30,'Dzhezkazganskaya obl.'),(87,30,'Karagandinskaya obl.'),(88,30,'Kzyl-Ordinskaya obl.'),(89,30,'Kokchetavskaya obl.'),(90,30,'Kustanaiskaya obl.'),(91,30,'Mangystauskaya (Mangyshlakskaya obl.)'),(92,30,'Pavlodarskaya obl.'),(93,30,'Severo-Kazahstanskaya obl.'),(94,30,'Taldy-Kurganskaya obl.'),(95,30,'Turgaiskaya obl.'),(96,30,'Akmolinskaya obl. (Tselinogradskaya obl.)'),(97,30,'Chimkentskaya obl.'),(98,31,'Littoral'),(99,31,'Southwest Region'),(100,31,'North'),(101,31,'Central'),(102,33,'Government controlled area'),(103,33,'Turkish controlled area'),(104,34,'Issik Kulskaya Region'),(105,34,'Kyrgyzstan'),(106,34,'Narinskaya Region'),(107,34,'Oshskaya Region'),(108,34,'Tallaskaya Region'),(109,37,'al-Jahra'),(110,37,'al-Kuwait'),(111,38,'Latviya'),(112,39,'Tarabulus'),(113,39,'Bengasi'),(114,40,'Litva'),(115,43,'Moldova'),(116,45,'Auckland'),(117,45,'Bay of Plenty'),(118,45,'Canterbury'),(119,45,'Gisborne'),(120,45,'Hawke&#039;s Bay'),(121,45,'Manawatu-Wanganui'),(122,45,'Marlborough'),(123,45,'Nelson'),(124,45,'Northland'),(125,45,'Otago'),(126,45,'Southland'),(127,45,'Taranaki'),(128,45,'Tasman'),(129,45,'Waikato'),(130,45,'Wellington'),(131,45,'West Coast'),(132,49,'Saint-Denis'),(133,50,'Altaiskii krai'),(134,50,'Amurskaya obl.'),(135,50,'Arhangelskaya obl.'),(136,50,'Astrahanskaya obl.'),(137,50,'Bashkiriya obl.'),(138,50,'Belgorodskaya obl.'),(139,50,'Bryanskaya obl.'),(140,50,'Buryatiya'),(141,50,'Vladimirskaya obl.'),(142,50,'Volgogradskaya obl.'),(143,50,'Vologodskaya obl.'),(144,50,'Voronezhskaya obl.'),(145,50,'Nizhegorodskaya obl.'),(146,50,'Dagestan'),(147,50,'Evreiskaya obl.'),(148,50,'Ivanovskaya obl.'),(149,50,'Irkutskaya obl.'),(150,50,'Kabardino-Balkariya'),(151,50,'Kaliningradskaya obl.'),(152,50,'Tverskaya obl.'),(153,50,'Kalmykiya'),(154,50,'Kaluzhskaya obl.'),(155,50,'Kamchatskaya obl.'),(156,50,'Kareliya'),(157,50,'Kemerovskaya obl.'),(158,50,'Kirovskaya obl.'),(159,50,'Komi'),(160,50,'Kostromskaya obl.'),(161,50,'Krasnodarskii krai'),(162,50,'Krasnoyarskii krai'),(163,50,'Kurganskaya obl.'),(164,50,'Kurskaya obl.'),(165,50,'Lipetskaya obl.'),(166,50,'Magadanskaya obl.'),(167,50,'Marii El'),(168,50,'Mordoviya'),(169,50,'Moscow &amp; Moscow Region'),(170,50,'Murmanskaya obl.'),(171,50,'Novgorodskaya obl.'),(172,50,'Novosibirskaya obl.'),(173,50,'Omskaya obl.'),(174,50,'Orenburgskaya obl.'),(175,50,'Orlovskaya obl.'),(176,50,'Penzenskaya obl.'),(177,50,'Permskiy krai'),(178,50,'Primorskii krai'),(179,50,'Pskovskaya obl.'),(180,50,'Rostovskaya obl.'),(181,50,'Ryazanskaya obl.'),(182,50,'Samarskaya obl.'),(183,50,'Saint-Petersburg and Region'),(184,50,'Saratovskaya obl.'),(185,50,'Saha (Yakutiya)'),(186,50,'Sahalin'),(187,50,'Sverdlovskaya obl.'),(188,50,'Severnaya Osetiya'),(189,50,'Smolenskaya obl.'),(190,50,'Stavropolskii krai'),(191,50,'Tambovskaya obl.'),(192,50,'Tatarstan'),(193,50,'Tomskaya obl.'),(195,50,'Tulskaya obl.'),(196,50,'Tyumenskaya obl. i Hanty-Mansiiskii AO'),(197,50,'Udmurtiya'),(198,50,'Ulyanovskaya obl.'),(199,50,'Uralskaya obl.'),(200,50,'Habarovskii krai'),(201,50,'Chelyabinskaya obl.'),(202,50,'Checheno-Ingushetiya'),(203,50,'Chitinskaya obl.'),(204,50,'Chuvashiya'),(205,50,'Yaroslavskaya obl.'),(206,51,'Ahuachapán'),(207,51,'Cuscatlán'),(208,51,'La Libertad'),(209,51,'La Paz'),(210,51,'La Unión'),(211,51,'San Miguel'),(212,51,'San Salvador'),(213,51,'Santa Ana'),(214,51,'Sonsonate'),(215,54,'Paramaribo'),(216,56,'Gorno-Badakhshan Region'),(217,56,'Kuljabsk Region'),(218,56,'Kurgan-Tjube Region'),(219,56,'Sughd Region'),(220,56,'Tajikistan'),(221,57,'Ashgabat Region'),(222,57,'Krasnovodsk Region'),(223,57,'Mary Region'),(224,57,'Tashauz Region'),(225,57,'Chardzhou Region'),(226,58,'Grand Turk'),(227,59,'Bartin'),(228,59,'Bayburt'),(229,59,'Karabuk'),(230,59,'Adana'),(231,59,'Aydin'),(232,59,'Amasya'),(233,59,'Ankara'),(234,59,'Antalya'),(235,59,'Artvin'),(236,59,'Afion'),(237,59,'Balikesir'),(238,59,'Bilecik'),(239,59,'Bursa'),(240,59,'Gaziantep'),(241,59,'Denizli'),(242,59,'Izmir'),(243,59,'Isparta'),(244,59,'Icel'),(245,59,'Kayseri'),(246,59,'Kars'),(247,59,'Kodjaeli'),(248,59,'Konya'),(249,59,'Kirklareli'),(250,59,'Kutahya'),(251,59,'Malatya'),(252,59,'Manisa'),(253,59,'Sakarya'),(254,59,'Samsun'),(255,59,'Sivas'),(256,59,'Istanbul'),(257,59,'Trabzon'),(258,59,'Corum'),(259,59,'Edirne'),(260,59,'Elazig'),(261,59,'Erzincan'),(262,59,'Erzurum'),(263,59,'Eskisehir'),(264,60,'Jinja'),(265,60,'Kampala'),(266,61,'Andijon Region'),(267,61,'Buxoro Region'),(268,61,'Jizzac Region'),(269,61,'Qaraqalpaqstan'),(270,61,'Qashqadaryo Region'),(271,61,'Navoiy Region'),(272,61,'Namangan Region'),(273,61,'Samarqand Region'),(274,61,'Surxondaryo Region'),(275,61,'Sirdaryo Region'),(276,61,'Tashkent Region'),(277,61,'Fergana Region'),(278,61,'Xorazm Region'),(279,62,'Vinnitskaya obl.'),(280,62,'Volynskaya obl.'),(281,62,'Dnepropetrovskaya obl.'),(282,62,'Donetskaya obl.'),(283,62,'Zhitomirskaya obl.'),(284,62,'Zakarpatskaya obl.'),(285,62,'Zaporozhskaya obl.'),(286,62,'Ivano-Frankovskaya obl.'),(287,62,'Kievskaya obl.'),(288,62,'Kirovogradskaya obl.'),(289,62,'Krymskaya obl.'),(290,62,'Luganskaya obl.'),(291,62,'Lvovskaya obl.'),(292,62,'Nikolaevskaya obl.'),(293,62,'Odesskaya obl.'),(294,62,'Poltavskaya obl.'),(295,62,'Rovenskaya obl.'),(296,62,'Sumskaya obl.'),(297,62,'Ternopolskaya obl.'),(298,62,'Harkovskaya obl.'),(299,62,'Hersonskaya obl.'),(300,62,'Hmelnitskaya obl.'),(301,62,'Cherkasskaya obl.'),(302,62,'Chernigovskaya obl.'),(303,62,'Chernovitskaya obl.'),(304,68,'Estoniya'),(305,69,'Cheju'),(306,69,'Chollabuk'),(307,69,'Chollanam'),(308,69,'Chungcheongbuk'),(309,69,'Chungcheongnam'),(310,69,'Incheon'),(311,69,'Kangweon'),(312,69,'Kwangju'),(313,69,'Kyeonggi'),(314,69,'Kyeongsangbuk'),(315,69,'Kyeongsangnam'),(316,69,'Pusan'),(317,69,'Seoul'),(318,69,'Taegu'),(319,69,'Taejeon'),(320,69,'Ulsan'),(321,70,'Aichi'),(322,70,'Akita'),(323,70,'Aomori'),(324,70,'Wakayama'),(325,70,'Gifu'),(326,70,'Gunma'),(327,70,'Ibaraki'),(328,70,'Iwate'),(329,70,'Ishikawa'),(330,70,'Kagawa'),(331,70,'Kagoshima'),(332,70,'Kanagawa'),(333,70,'Kyoto'),(334,70,'Kochi'),(335,70,'Kumamoto'),(336,70,'Mie'),(337,70,'Miyagi'),(338,70,'Miyazaki'),(339,70,'Nagano'),(340,70,'Nagasaki'),(341,70,'Nara'),(342,70,'Niigata'),(343,70,'Okayama'),(344,70,'Okinawa'),(345,70,'Osaka'),(346,70,'Saga'),(347,70,'Saitama'),(348,70,'Shiga'),(349,70,'Shizuoka'),(350,70,'Shimane'),(351,70,'Tiba'),(352,70,'Tokyo'),(353,70,'Tokushima'),(354,70,'Tochigi'),(355,70,'Tottori'),(356,70,'Toyama'),(357,70,'Fukui'),(358,70,'Fukuoka'),(359,70,'Fukushima'),(360,70,'Hiroshima'),(361,70,'Hokkaido'),(362,70,'Hyogo'),(363,70,'Yoshimi'),(364,70,'Yamagata'),(365,70,'Yamaguchi'),(366,70,'Yamanashi'),(368,73,'Hong Kong'),(369,74,'Indonesia'),(370,75,'Jordan'),(371,76,'Malaysia'),(372,77,'Singapore'),(373,78,'Taiwan'),(374,30,'Kazahstan'),(375,62,'Ukraina'),(376,25,'India'),(377,23,'Egypt'),(378,106,'Damascus'),(379,131,'Isle of Man'),(380,30,'Zapadno-Kazahstanskaya obl.'),(381,50,'Adygeya'),(382,50,'Hakasiya'),(383,93,'Dubai'),(384,50,'Chukotskii AO'),(385,99,'Beirut'),(386,137,'Tegucigalpa'),(387,138,'Santo Domingo'),(388,139,'Ulan Bator'),(389,23,'Sinai'),(390,140,'Baghdad'),(391,140,'Basra'),(392,140,'Mosul'),(393,141,'Johannesburg'),(394,104,'Morocco'),(395,104,'Tangier'),(396,50,'Yamalo-Nenetskii AO'),(397,122,'Tunisia'),(398,92,'Thailand'),(399,117,'Mozambique'),(400,84,'Korea'),(401,87,'Pakistan'),(402,142,'Aruba'),(403,80,'Bahamas'),(404,69,'South Korea'),(405,132,'Jamaica'),(406,93,'Sharjah'),(407,93,'Abu Dhabi'),(409,24,'Ramat Hagolan'),(410,115,'Nigeria'),(411,64,'Ain'),(412,64,'Haute-Savoie'),(413,64,'Aisne'),(414,64,'Allier'),(415,64,'Alpes-de-Haute-Provence'),(416,64,'Hautes-Alpes'),(417,64,'Alpes-Maritimes'),(418,64,'Ard&egrave;che'),(419,64,'Ardennes'),(420,64,'Ari&egrave;ge'),(421,64,'Aube'),(422,64,'Aude'),(423,64,'Aveyron'),(424,64,'Bouches-du-Rh&ocirc;ne'),(425,64,'Calvados'),(426,64,'Cantal'),(427,64,'Charente'),(428,64,'Charente Maritime'),(429,64,'Cher'),(430,64,'Corr&egrave;ze'),(431,64,'Dordogne'),(432,64,'Corse'),(433,64,'C&ocirc;te d&#039;Or'),(434,64,'Sa&ocirc;ne et Loire'),(435,64,'C&ocirc;tes d&#039;Armor'),(436,64,'Creuse'),(437,64,'Doubs'),(438,64,'Dr&ocirc;me'),(439,64,'Eure'),(440,64,'Eure-et-Loire'),(441,64,'Finist&egrave;re'),(442,64,'Gard'),(443,64,'Haute-Garonne'),(444,64,'Gers'),(445,64,'Gironde'),(446,64,'Hérault'),(447,64,'Ille et Vilaine'),(448,64,'Indre'),(449,64,'Indre-et-Loire'),(450,64,'Isère'),(451,64,'Jura'),(452,64,'Landes'),(453,64,'Loir-et-Cher'),(454,64,'Loire'),(455,64,'Rh&ocirc;ne'),(456,64,'Haute-Loire'),(457,64,'Loire Atlantique'),(458,64,'Loiret'),(459,64,'Lot'),(460,64,'Lot-et-Garonne'),(461,64,'Loz&egrave;re'),(462,64,'Maine et Loire'),(463,64,'Manche'),(464,64,'Marne'),(465,64,'Haute-Marne'),(466,64,'Mayenne'),(467,64,'Meurthe-et-Moselle'),(468,64,'Meuse'),(469,64,'Morbihan'),(470,64,'Moselle'),(471,64,'Ni&egrave;vre'),(472,64,'Nord'),(473,64,'Oise'),(474,64,'Orne'),(475,64,'Pas-de-Calais'),(476,64,'Puy-de-D&ocirc;me'),(477,64,'Pyrénées-Atlantiques'),(478,64,'Hautes-Pyrénées'),(479,64,'Pyrénées-Orientales'),(480,64,'Bas Rhin'),(481,64,'Haut Rhin'),(482,64,'Haute-Sa&ocirc;ne'),(483,64,'Sarthe'),(484,64,'Savoie'),(485,64,'Paris'),(486,64,'Seine-Maritime'),(487,64,'Seine-et-Marne'),(488,64,'Yvelines'),(489,64,'Deux-S&egrave;vres'),(490,64,'Somme'),(491,64,'Tarn'),(492,64,'Tarn-et-Garonne'),(493,64,'Var'),(494,64,'Vaucluse'),(495,64,'Vendée'),(496,64,'Vienne'),(497,64,'Haute-Vienne'),(498,64,'Vosges'),(499,64,'Yonne'),(500,64,'Territoire de Belfort'),(501,64,'Essonne'),(502,64,'Hauts-de-Seine'),(503,64,'Seine-Saint-Denis'),(504,64,'Val-de-Marne'),(505,64,'Val-d&#039;Oise'),(506,29,'Piemonte - Torino'),(507,29,'Piemonte - Alessandria'),(508,29,'Piemonte - Asti'),(509,29,'Piemonte - Biella'),(510,29,'Piemonte - Cuneo'),(511,29,'Piemonte - Novara'),(512,29,'Piemonte - Verbania'),(513,29,'Piemonte - Vercelli'),(514,29,'Valle d&#039;Aosta - Aosta'),(515,29,'Lombardia - Milano'),(516,29,'Lombardia - Bergamo'),(517,29,'Lombardia - Brescia'),(518,29,'Lombardia - Como'),(519,29,'Lombardia - Cremona'),(520,29,'Lombardia - Lecco'),(521,29,'Lombardia - Lodi'),(522,29,'Lombardia - Mantova'),(523,29,'Lombardia - Pavia'),(524,29,'Lombardia - Sondrio'),(525,29,'Lombardia - Varese'),(526,29,'Trentino Alto Adige - Trento'),(527,29,'Trentino Alto Adige - Bolzano'),(528,29,'Veneto - Venezia'),(529,29,'Veneto - Belluno'),(530,29,'Veneto - Padova'),(531,29,'Veneto - Rovigo'),(532,29,'Veneto - Treviso'),(533,29,'Veneto - Verona'),(534,29,'Veneto - Vicenza'),(535,29,'Friuli Venezia Giulia - Trieste'),(536,29,'Friuli Venezia Giulia - Gorizia'),(537,29,'Friuli Venezia Giulia - Pordenone'),(538,29,'Friuli Venezia Giulia - Udine'),(539,29,'Liguria - Genova'),(540,29,'Liguria - Imperia'),(541,29,'Liguria - La Spezia'),(542,29,'Liguria - Savona'),(543,29,'Emilia Romagna - Bologna'),(544,29,'Emilia Romagna - Ferrara'),(545,29,'Emilia Romagna - Forlì-Cesena'),(546,29,'Emilia Romagna - Modena'),(547,29,'Emilia Romagna - Parma'),(548,29,'Emilia Romagna - Piacenza'),(549,29,'Emilia Romagna - Ravenna'),(550,29,'Emilia Romagna - Reggio Emilia'),(551,29,'Emilia Romagna - Rimini'),(552,29,'Toscana - Firenze'),(553,29,'Toscana - Arezzo'),(554,29,'Toscana - Grosseto'),(555,29,'Toscana - Livorno'),(556,29,'Toscana - Lucca'),(557,29,'Toscana - Massa Carrara'),(558,29,'Toscana - Pisa'),(559,29,'Toscana - Pistoia'),(560,29,'Toscana - Prato'),(561,29,'Toscana - Siena'),(562,29,'Umbria - Perugia'),(563,29,'Umbria - Terni'),(564,29,'Marche - Ancona'),(565,29,'Marche - Ascoli Piceno'),(566,29,'Marche - Macerata'),(567,29,'Marche - Pesaro - Urbino'),(568,29,'Lazio - Roma'),(569,29,'Lazio - Frosinone'),(570,29,'Lazio - Latina'),(571,29,'Lazio - Rieti'),(572,29,'Lazio - Viterbo'),(573,29,'Abruzzo - L´Aquila'),(574,29,'Abruzzo - Chieti'),(575,29,'Abruzzo - Pescara'),(576,29,'Abruzzo - Teramo'),(577,29,'Molise - Campobasso'),(578,29,'Molise - Isernia'),(579,29,'Campania - Napoli'),(580,29,'Campania - Avellino'),(581,29,'Campania - Benevento'),(582,29,'Campania - Caserta'),(583,29,'Campania - Salerno'),(584,29,'Puglia - Bari'),(585,29,'Puglia - Brindisi'),(586,29,'Puglia - Foggia'),(587,29,'Puglia - Lecce'),(588,29,'Puglia - Taranto'),(589,29,'Basilicata - Potenza'),(590,29,'Basilicata - Matera'),(591,29,'Calabria - Catanzaro'),(592,29,'Calabria - Cosenza'),(593,29,'Calabria - Crotone'),(594,29,'Calabria - Reggio Calabria'),(595,29,'Calabria - Vibo Valentia'),(596,29,'Sicilia - Palermo'),(597,29,'Sicilia - Agrigento'),(598,29,'Sicilia - Caltanissetta'),(599,29,'Sicilia - Catania'),(600,29,'Sicilia - Enna'),(601,29,'Sicilia - Messina'),(602,29,'Sicilia - Ragusa'),(603,29,'Sicilia - Siracusa'),(604,29,'Sicilia - Trapani'),(605,29,'Sardegna - Cagliari'),(606,29,'Sardegna - Nuoro'),(607,29,'Sardegna - Oristano'),(608,29,'Sardegna - Sassari'),(609,28,'Las Palmas'),(610,28,'Soria'),(611,28,'Palencia'),(612,28,'Zamora'),(613,28,'Cádiz'),(614,28,'Navarra'),(615,28,'Ourense'),(616,28,'Segovia'),(617,28,'Guip&uacute;zcoa'),(618,28,'Ciudad Real'),(619,28,'Vizcaya'),(620,28,'álava'),(621,28,'A Coruña'),(622,28,'Cantabria'),(623,28,'Almería'),(624,28,'Zaragoza'),(625,28,'Santa Cruz de Tenerife'),(626,28,'Cáceres'),(627,28,'Guadalajara'),(628,28,'ávila'),(629,28,'Toledo'),(630,28,'Castellón'),(631,28,'Tarragona'),(632,28,'Lugo'),(633,28,'La Rioja'),(634,28,'Ceuta'),(635,28,'Murcia'),(636,28,'Salamanca'),(637,28,'Valladolid'),(638,28,'Jaén'),(639,28,'Girona'),(640,28,'Granada'),(641,28,'Alacant'),(642,28,'Córdoba'),(643,28,'Albacete'),(644,28,'Cuenca'),(645,28,'Pontevedra'),(646,28,'Teruel'),(647,28,'Melilla'),(648,28,'Barcelona'),(649,28,'Badajoz'),(650,28,'Madrid'),(651,28,'Sevilla'),(652,28,'Val&egrave;ncia'),(653,28,'Huelva'),(654,28,'Lleida'),(655,28,'León'),(656,28,'Illes Balears'),(657,28,'Burgos'),(658,28,'Huesca'),(659,28,'Asturias'),(660,28,'Málaga'),(661,144,'Afghanistan'),(662,210,'Niger'),(663,133,'Mali'),(664,156,'Burkina Faso'),(665,136,'Togo'),(666,151,'Benin'),(667,119,'Angola'),(668,102,'Namibia'),(669,100,'Botswana'),(670,134,'Madagascar'),(671,202,'Mauritius'),(672,196,'Laos'),(673,158,'Cambodia'),(674,90,'Philippines'),(675,88,'Papua New Guinea'),(676,228,'Solomon Islands'),(677,240,'Vanuatu'),(678,176,'Fiji'),(679,223,'Samoa'),(680,206,'Nauru'),(681,168,'Cote D&#039;Ivoire'),(682,198,'Liberia'),(683,187,'Guinea'),(684,189,'Guyana'),(685,98,'Algeria'),(686,147,'Antigua and Barbuda'),(687,127,'Bahrain'),(688,149,'Bangladesh'),(689,128,'Barbados'),(690,152,'Bhutan'),(691,155,'Brunei'),(692,157,'Burundi'),(693,159,'Cape Verde'),(694,130,'Chad'),(695,164,'Comoros'),(696,112,'Congo (Brazzaville)'),(697,169,'Djibouti'),(698,171,'East Timor'),(699,173,'Eritrea'),(700,121,'Ethiopia'),(701,180,'Gabon'),(702,181,'Gambia'),(703,105,'Ghana'),(704,197,'Lesotho'),(705,125,'Malawi'),(706,200,'Maldives'),(707,205,'Myanmar (Burma)'),(708,107,'Nepal'),(709,213,'Oman'),(710,217,'Rwanda'),(711,91,'Saudi Arabia'),(712,120,'Sri Lanka'),(713,232,'Sudan'),(714,234,'Swaziland'),(715,101,'Tanzania'),(716,236,'Tonga'),(717,239,'Tuvalu'),(718,242,'Western Sahara'),(719,243,'Yemen'),(720,116,'Zambia'),(721,96,'Zimbabwe'),(722,66,'Aargau'),(723,66,'Appenzell Innerrhoden'),(724,66,'Appenzell Ausserrhoden'),(725,66,'Bern'),(726,66,'Basel-Landschaft'),(727,66,'Basel-Stadt'),(728,66,'Fribourg'),(729,66,'Gen&egrave;ve'),(730,66,'Glarus'),(731,66,'Graubünden'),(732,66,'Jura'),(733,66,'Luzern'),(734,66,'Neuch&acirc;tel'),(735,66,'Nidwalden'),(736,66,'Obwalden'),(737,66,'Sankt Gallen'),(738,66,'Schaffhausen'),(739,66,'Solothurn'),(740,66,'Schwyz'),(741,66,'Thurgau'),(742,66,'Ticino'),(743,66,'Uri'),(744,66,'Vaud'),(745,66,'Valais'),(746,66,'Zug'),(747,66,'Zürich'),(749,48,'Aveiro'),(750,48,'Beja'),(751,48,'Braga'),(752,48,'Braganca'),(753,48,'Castelo Branco'),(754,48,'Coimbra'),(755,48,'Evora'),(756,48,'Faro'),(757,48,'Madeira'),(758,48,'Guarda'),(759,48,'Leiria'),(760,48,'Lisboa'),(761,48,'Portalegre'),(762,48,'Porto'),(763,48,'Santarem'),(764,48,'Setubal'),(765,48,'Viana do Castelo'),(766,48,'Vila Real'),(767,48,'Viseu'),(768,48,'Azores'),(769,55,'Armed Forces Americas'),(770,55,'Armed Forces Europe'),(771,55,'Alaska'),(772,55,'Alabama'),(773,55,'Armed Forces Pacific'),(774,55,'Arkansas'),(775,55,'American Samoa'),(776,55,'Arizona'),(777,55,'California'),(778,55,'Colorado'),(779,55,'Connecticut'),(780,55,'District of Columbia'),(781,55,'Delaware'),(782,55,'Florida'),(783,55,'Federated States of Micronesia'),(784,55,'Georgia'),(786,55,'Hawaii'),(787,55,'Iowa'),(788,55,'Idaho'),(789,55,'Illinois'),(790,55,'Indiana'),(791,55,'Kansas'),(792,55,'Kentucky'),(793,55,'Louisiana'),(794,55,'Massachusetts'),(795,55,'Maryland'),(796,55,'Maine'),(797,55,'Marshall Islands'),(798,55,'Michigan'),(799,55,'Minnesota'),(800,55,'Missouri'),(801,55,'Northern Mariana Islands'),(802,55,'Mississippi'),(803,55,'Montana'),(804,55,'North Carolina'),(805,55,'North Dakota'),(806,55,'Nebraska'),(807,55,'New Hampshire'),(808,55,'New Jersey'),(809,55,'New Mexico'),(810,55,'Nevada'),(811,55,'New York'),(812,55,'Ohio'),(813,55,'Oklahoma'),(814,55,'Oregon'),(815,55,'Pennsylvania'),(816,246,'Puerto Rico'),(817,55,'Palau'),(818,55,'Rhode Island'),(819,55,'South Carolina'),(820,55,'South Dakota'),(821,55,'Tennessee'),(822,55,'Texas'),(823,55,'Utah'),(824,55,'Virginia'),(825,55,'Virgin Islands'),(826,55,'Vermont'),(827,55,'Washington'),(828,55,'West Virginia'),(829,55,'Wisconsin'),(830,55,'Wyoming'),(831,94,'Greenland'),(832,18,'Brandenburg'),(833,18,'Baden-Württemberg'),(834,18,'Bayern'),(835,18,'Hessen'),(836,18,'Hamburg'),(837,18,'Mecklenburg-Vorpommern'),(838,18,'Niedersachsen'),(839,18,'Nordrhein-Westfalen'),(840,18,'Rheinland-Pfalz'),(841,18,'Schleswig-Holstein'),(842,18,'Sachsen'),(843,18,'Sachsen-Anhalt'),(844,18,'Thüringen'),(845,18,'Berlin'),(846,18,'Bremen'),(847,18,'Saarland'),(848,13,'Scotland North'),(849,13,'England - East'),(850,13,'England - West Midlands'),(851,13,'England - South West'),(852,13,'England - North West'),(853,13,'England - Yorks &amp; Humber'),(854,13,'England - South East'),(855,13,'England - London'),(856,13,'Northern Ireland'),(857,13,'England - North East'),(858,13,'Wales South'),(859,13,'Wales North'),(860,13,'England - East Midlands'),(861,13,'Scotland Central'),(862,13,'Scotland South'),(863,13,'Channel Islands'),(864,13,'Isle of Man'),(865,2,'Burgenland'),(866,2,'Kärnten'),(867,2,'Niederösterreich'),(868,2,'Oberösterreich'),(869,2,'Salzburg'),(870,2,'Steiermark'),(871,2,'Tirol'),(872,2,'Vorarlberg'),(873,2,'Wien'),(874,9,'Bruxelles'),(875,9,'West-Vlaanderen'),(876,9,'Oost-Vlaanderen'),(877,9,'Limburg'),(878,9,'Vlaams Brabant'),(879,9,'Antwerpen'),(880,9,'LiÄge'),(881,9,'Namur'),(882,9,'Hainaut'),(883,9,'Luxembourg'),(884,9,'Brabant Wallon'),(887,67,'Blekinge Lan'),(888,67,'Gavleborgs Lan'),(890,67,'Gotlands Lan'),(891,67,'Hallands Lan'),(892,67,'Jamtlands Lan'),(893,67,'Jonkopings Lan'),(894,67,'Kalmar Lan'),(895,67,'Dalarnas Lan'),(897,67,'Kronobergs Lan'),(899,67,'Norrbottens Lan'),(900,67,'Orebro Lan'),(901,67,'Ostergotlands Lan'),(903,67,'Sodermanlands Lan'),(904,67,'Uppsala Lan'),(905,67,'Varmlands Lan'),(906,67,'Vasterbottens Lan'),(907,67,'Vasternorrlands Lan'),(908,67,'Vastmanlands Lan'),(909,67,'Stockholms Lan'),(910,67,'Skane Lan'),(911,67,'Vastra Gotaland'),(913,46,'Akershus'),(914,46,'Aust-Agder'),(915,46,'Buskerud'),(916,46,'Finnmark'),(917,46,'Hedmark'),(918,46,'Hordaland'),(919,46,'More og Romsdal'),(920,46,'Nordland'),(921,46,'Nord-Trondelag'),(922,46,'Oppland'),(923,46,'Oslo'),(924,46,'Ostfold'),(925,46,'Rogaland'),(926,46,'Sogn og Fjordane'),(927,46,'Sor-Trondelag'),(928,46,'Telemark'),(929,46,'Troms'),(930,46,'Vest-Agder'),(931,46,'Vestfold'),(933,63,'&ETH;&bull;land'),(934,63,'Lapland'),(935,63,'Oulu'),(936,63,'Southern Finland'),(937,63,'Eastern Finland'),(938,63,'Western Finland'),(940,22,'Arhus'),(941,22,'Bornholm'),(942,22,'Frederiksborg'),(943,22,'Fyn'),(944,22,'Kobenhavn'),(945,22,'Staden Kobenhavn'),(946,22,'Nordjylland'),(947,22,'Ribe'),(948,22,'Ringkobing'),(949,22,'Roskilde'),(950,22,'Sonderjylland'),(951,22,'Storstrom'),(952,22,'Vejle'),(953,22,'Vestsjalland'),(954,22,'Viborg'),(956,65,'Hlavni Mesto Praha'),(957,65,'Jihomoravsky Kraj'),(958,65,'Jihocesky Kraj'),(959,65,'Vysocina'),(960,65,'Karlovarsky Kraj'),(961,65,'Kralovehradecky Kraj'),(962,65,'Liberecky Kraj'),(963,65,'Olomoucky Kraj'),(964,65,'Moravskoslezsky Kraj'),(965,65,'Pardubicky Kraj'),(966,65,'Plzensky Kraj'),(967,65,'Stredocesky Kraj'),(968,65,'Ustecky Kraj'),(969,65,'Zlinsky Kraj'),(971,114,'Berat'),(972,114,'Diber'),(973,114,'Durres'),(974,114,'Elbasan'),(975,114,'Fier'),(976,114,'Gjirokaster'),(977,114,'Korce'),(978,114,'Kukes'),(979,114,'Lezhe'),(980,114,'Shkoder'),(981,114,'Tirane'),(982,114,'Vlore'),(984,145,'Canillo'),(985,145,'Encamp'),(986,145,'La Massana'),(987,145,'Ordino'),(988,145,'Sant Julia de Loria'),(989,145,'Andorra la Vella'),(990,145,'Escaldes-Engordany'),(992,6,'Aragatsotn'),(993,6,'Ararat'),(994,6,'Armavir'),(995,6,'Geghark&#039;unik&#039;'),(996,6,'Kotayk&#039;'),(997,6,'Lorri'),(998,6,'Shirak'),(999,6,'Syunik&#039;'),(1000,6,'Tavush'),(1001,6,'Vayots&#039; Dzor'),(1002,6,'Yerevan'),(1004,79,'Federation of Bosnia and Herzegovina'),(1005,79,'Republika Srpska'),(1007,11,'Mikhaylovgrad'),(1008,11,'Blagoevgrad'),(1009,11,'Burgas'),(1010,11,'Dobrich'),(1011,11,'Gabrovo'),(1012,11,'Grad Sofiya'),(1013,11,'Khaskovo'),(1014,11,'Kurdzhali'),(1015,11,'Kyustendil'),(1016,11,'Lovech'),(1017,11,'Montana'),(1018,11,'Pazardzhik'),(1019,11,'Pernik'),(1020,11,'Pleven'),(1021,11,'Plovdiv'),(1022,11,'Razgrad'),(1023,11,'Ruse'),(1024,11,'Shumen'),(1025,11,'Silistra'),(1026,11,'Sliven'),(1027,11,'Smolyan'),(1028,11,'Sofiya'),(1029,11,'Stara Zagora'),(1030,11,'Turgovishte'),(1031,11,'Varna'),(1032,11,'Veliko Turnovo'),(1033,11,'Vidin'),(1034,11,'Vratsa'),(1035,11,'Yambol'),(1037,71,'Bjelovarsko-Bilogorska'),(1038,71,'Brodsko-Posavska'),(1039,71,'Dubrovacko-Neretvanska'),(1040,71,'Istarska'),(1041,71,'Karlovacka'),(1042,71,'Koprivnicko-Krizevacka'),(1043,71,'Krapinsko-Zagorska'),(1044,71,'Licko-Senjska'),(1045,71,'Medimurska'),(1046,71,'Osjecko-Baranjska'),(1047,71,'Pozesko-Slavonska'),(1048,71,'Primorsko-Goranska'),(1049,71,'Sibensko-Kninska'),(1050,71,'Sisacko-Moslavacka'),(1051,71,'Splitsko-Dalmatinska'),(1052,71,'Varazdinska'),(1053,71,'Viroviticko-Podravska'),(1054,71,'Vukovarsko-Srijemska'),(1055,71,'Zadarska'),(1056,71,'Zagrebacka'),(1057,71,'Grad Zagreb'),(1059,143,'Gibraltar'),(1060,20,'Evros'),(1061,20,'Rodhopi'),(1062,20,'Xanthi'),(1063,20,'Drama'),(1064,20,'Serrai'),(1065,20,'Kilkis'),(1066,20,'Pella'),(1067,20,'Florina'),(1068,20,'Kastoria'),(1069,20,'Grevena'),(1070,20,'Kozani'),(1071,20,'Imathia'),(1072,20,'Thessaloniki'),(1073,20,'Kavala'),(1074,20,'Khalkidhiki'),(1075,20,'Pieria'),(1076,20,'Ioannina'),(1077,20,'Thesprotia'),(1078,20,'Preveza'),(1079,20,'Arta'),(1080,20,'Larisa'),(1081,20,'Trikala'),(1082,20,'Kardhitsa'),(1083,20,'Magnisia'),(1084,20,'Kerkira'),(1085,20,'Levkas'),(1086,20,'Kefallinia'),(1087,20,'Zakinthos'),(1088,20,'Fthiotis'),(1089,20,'Evritania'),(1090,20,'Aitolia kai Akarnania'),(1091,20,'Fokis'),(1092,20,'Voiotia'),(1093,20,'Evvoia'),(1094,20,'Attiki'),(1095,20,'Argolis'),(1096,20,'Korinthia'),(1097,20,'Akhaia'),(1098,20,'Ilia'),(1099,20,'Messinia'),(1100,20,'Arkadhia'),(1101,20,'Lakonia'),(1102,20,'Khania'),(1103,20,'Rethimni'),(1104,20,'Iraklion'),(1105,20,'Lasithi'),(1106,20,'Dhodhekanisos'),(1107,20,'Samos'),(1108,20,'Kikladhes'),(1109,20,'Khios'),(1110,20,'Lesvos'),(1112,14,'Bacs-Kiskun'),(1113,14,'Baranya'),(1114,14,'Bekes'),(1115,14,'Borsod-Abauj-Zemplen'),(1116,14,'Budapest'),(1117,14,'Csongrad'),(1118,14,'Debrecen'),(1119,14,'Fejer'),(1120,14,'Gyor-Moson-Sopron'),(1121,14,'Hajdu-Bihar'),(1122,14,'Heves'),(1123,14,'Komarom-Esztergom'),(1124,14,'Miskolc'),(1125,14,'Nograd'),(1126,14,'Pecs'),(1127,14,'Pest'),(1128,14,'Somogy'),(1129,14,'Szabolcs-Szatmar-Bereg'),(1130,14,'Szeged'),(1131,14,'Jasz-Nagykun-Szolnok'),(1132,14,'Tolna'),(1133,14,'Vas'),(1134,14,'Veszprem'),(1135,14,'Zala'),(1136,14,'Gyor'),(1150,14,'Veszprem'),(1152,126,'Balzers'),(1153,126,'Eschen'),(1154,126,'Gamprin'),(1155,126,'Mauren'),(1156,126,'Planken'),(1157,126,'Ruggell'),(1158,126,'Schaan'),(1159,126,'Schellenberg'),(1160,126,'Triesen'),(1161,126,'Triesenberg'),(1162,126,'Vaduz'),(1163,41,'Diekirch'),(1164,41,'Grevenmacher'),(1165,41,'Luxembourg'),(1167,85,'Aracinovo'),(1168,85,'Bac'),(1169,85,'Belcista'),(1170,85,'Berovo'),(1171,85,'Bistrica'),(1172,85,'Bitola'),(1173,85,'Blatec'),(1174,85,'Bogdanci'),(1175,85,'Bogomila'),(1176,85,'Bogovinje'),(1177,85,'Bosilovo'),(1179,85,'Cair'),(1180,85,'Capari'),(1181,85,'Caska'),(1182,85,'Cegrane'),(1184,85,'Centar Zupa'),(1187,85,'Debar'),(1188,85,'Delcevo'),(1190,85,'Demir Hisar'),(1191,85,'Demir Kapija'),(1195,85,'Dorce Petrov'),(1198,85,'Gazi Baba'),(1199,85,'Gevgelija'),(1200,85,'Gostivar'),(1201,85,'Gradsko'),(1204,85,'Jegunovce'),(1205,85,'Kamenjane'),(1207,85,'Karpos'),(1208,85,'Kavadarci'),(1209,85,'Kicevo'),(1210,85,'Kisela Voda'),(1211,85,'Klecevce'),(1212,85,'Kocani'),(1214,85,'Kondovo'),(1217,85,'Kratovo'),(1219,85,'Krivogastani'),(1220,85,'Krusevo'),(1223,85,'Kumanovo'),(1224,85,'Labunista'),(1225,85,'Lipkovo'),(1228,85,'Makedonska Kamenica'),(1229,85,'Makedonski Brod'),(1234,85,'Murtino'),(1235,85,'Negotino'),(1238,85,'Novo Selo'),(1240,85,'Ohrid'),(1242,85,'Orizari'),(1245,85,'Petrovec'),(1248,85,'Prilep'),(1249,85,'Probistip'),(1250,85,'Radovis'),(1252,85,'Resen'),(1253,85,'Rosoman'),(1256,85,'Saraj'),(1260,85,'Srbinovo'),(1262,85,'Star Dojran'),(1264,85,'Stip'),(1265,85,'Struga'),(1266,85,'Strumica'),(1267,85,'Studenicani'),(1268,85,'Suto Orizari'),(1269,85,'Sveti Nikole'),(1270,85,'Tearce'),(1271,85,'Tetovo'),(1273,85,'Valandovo'),(1275,85,'Veles'),(1277,85,'Vevcani'),(1278,85,'Vinica'),(1281,85,'Vrapciste'),(1286,85,'Zelino'),(1289,85,'Zrnovci'),(1291,86,'Malta'),(1292,44,'La Condamine'),(1293,44,'Monaco'),(1294,44,'Monte-Carlo'),(1295,47,'Biala Podlaska'),(1296,47,'Bialystok'),(1297,47,'Bielsko'),(1298,47,'Bydgoszcz'),(1299,47,'Chelm'),(1300,47,'Ciechanow'),(1301,47,'Czestochowa'),(1302,47,'Elblag'),(1303,47,'Gdansk'),(1304,47,'Gorzow'),(1305,47,'Jelenia Gora'),(1306,47,'Kalisz'),(1307,47,'Katowice'),(1308,47,'Kielce'),(1309,47,'Konin'),(1310,47,'Koszalin'),(1311,47,'Krakow'),(1312,47,'Krosno'),(1313,47,'Legnica'),(1314,47,'Leszno'),(1315,47,'Lodz'),(1316,47,'Lomza'),(1317,47,'Lublin'),(1318,47,'Nowy Sacz'),(1319,47,'Olsztyn'),(1320,47,'Opole'),(1321,47,'Ostroleka'),(1322,47,'Pila'),(1323,47,'Piotrkow'),(1324,47,'Plock'),(1325,47,'Poznan'),(1326,47,'Przemysl'),(1327,47,'Radom'),(1328,47,'Rzeszow'),(1329,47,'Siedlce'),(1330,47,'Sieradz'),(1331,47,'Skierniewice'),(1332,47,'Slupsk'),(1333,47,'Suwalki'),(1335,47,'Tarnobrzeg'),(1336,47,'Tarnow'),(1337,47,'Torun'),(1338,47,'Walbrzych'),(1339,47,'Warszawa'),(1340,47,'Wloclawek'),(1341,47,'Wroclaw'),(1342,47,'Zamosc'),(1343,47,'Zielona Gora'),(1344,47,'Dolnoslaskie'),(1345,47,'Kujawsko-Pomorskie'),(1346,47,'Lodzkie'),(1347,47,'Lubelskie'),(1348,47,'Lubuskie'),(1349,47,'Malopolskie'),(1350,47,'Mazowieckie'),(1351,47,'Opolskie'),(1352,47,'Podkarpackie'),(1353,47,'Podlaskie'),(1354,47,'Pomorskie'),(1355,47,'Slaskie'),(1356,47,'Swietokrzyskie'),(1357,47,'Warminsko-Mazurskie'),(1358,47,'Wielkopolskie'),(1359,47,'Zachodniopomorskie'),(1361,72,'Alba'),(1362,72,'Arad'),(1363,72,'Arges'),(1364,72,'Bacau'),(1365,72,'Bihor'),(1366,72,'Bistrita-Nasaud'),(1367,72,'Botosani'),(1368,72,'Braila'),(1369,72,'Brasov'),(1370,72,'Bucuresti'),(1371,72,'Buzau'),(1372,72,'Caras-Severin'),(1373,72,'Cluj'),(1374,72,'Constanta'),(1375,72,'Covasna'),(1376,72,'Dambovita'),(1377,72,'Dolj'),(1378,72,'Galati'),(1379,72,'Gorj'),(1380,72,'Harghita'),(1381,72,'Hunedoara'),(1382,72,'Ialomita'),(1383,72,'Iasi'),(1384,72,'Maramures'),(1385,72,'Mehedinti'),(1386,72,'Mures'),(1387,72,'Neamt'),(1388,72,'Olt'),(1389,72,'Prahova'),(1390,72,'Salaj'),(1391,72,'Satu Mare'),(1392,72,'Sibiu'),(1393,72,'Suceava'),(1394,72,'Teleorman'),(1395,72,'Timis'),(1396,72,'Tulcea'),(1397,72,'Vaslui'),(1398,72,'Valcea'),(1399,72,'Vrancea'),(1400,72,'Calarasi'),(1401,72,'Giurgiu'),(1404,224,'Acquaviva'),(1405,224,'Chiesanuova'),(1406,224,'Domagnano'),(1407,224,'Faetano'),(1408,224,'Fiorentino'),(1409,224,'Borgo Maggiore'),(1410,224,'San Marino'),(1411,224,'Monte Giardino'),(1412,224,'Serravalle'),(1413,52,'Banska Bystrica'),(1414,52,'Bratislava'),(1415,52,'Kosice'),(1416,52,'Nitra'),(1417,52,'Presov'),(1418,52,'Trencin'),(1419,52,'Trnava'),(1420,52,'Zilina'),(1423,53,'Beltinci'),(1425,53,'Bohinj'),(1426,53,'Borovnica'),(1427,53,'Bovec'),(1428,53,'Brda'),(1429,53,'Brezice'),(1430,53,'Brezovica'),(1432,53,'Cerklje na Gorenjskem'),(1434,53,'Cerkno'),(1436,53,'Crna na Koroskem'),(1437,53,'Crnomelj'),(1438,53,'Divaca'),(1439,53,'Dobrepolje'),(1440,53,'Dol pri Ljubljani'),(1443,53,'Duplek'),(1447,53,'Gornji Grad'),(1450,53,'Hrastnik'),(1451,53,'Hrpelje-Kozina'),(1452,53,'Idrija'),(1453,53,'Ig'),(1454,53,'Ilirska Bistrica'),(1455,53,'Ivancna Gorica'),(1462,53,'Komen'),(1463,53,'Koper-Capodistria'),(1464,53,'Kozje'),(1465,53,'Kranj'),(1466,53,'Kranjska Gora'),(1467,53,'Krsko'),(1469,53,'Lasko'),(1470,53,'Ljubljana'),(1471,53,'Ljubno'),(1472,53,'Logatec'),(1475,53,'Medvode'),(1476,53,'Menges'),(1478,53,'Mezica'),(1480,53,'Moravce'),(1482,53,'Mozirje'),(1483,53,'Murska Sobota'),(1487,53,'Nova Gorica'),(1489,53,'Ormoz'),(1491,53,'Pesnica'),(1494,53,'Postojna'),(1497,53,'Radece'),(1498,53,'Radenci'),(1500,53,'Radovljica'),(1502,53,'Rogaska Slatina'),(1505,53,'Sencur'),(1506,53,'Sentilj'),(1508,53,'Sevnica'),(1509,53,'Sezana'),(1511,53,'Skofja Loka'),(1513,53,'Slovenj Gradec'),(1514,53,'Slovenske Konjice'),(1515,53,'Smarje pri Jelsah'),(1521,53,'Tolmin'),(1522,53,'Trbovlje'),(1524,53,'Trzic'),(1526,53,'Velenje'),(1528,53,'Vipava'),(1531,53,'Vrhnika'),(1532,53,'Vuzenica'),(1533,53,'Zagorje ob Savi'),(1535,53,'Zelezniki'),(1536,53,'Ziri'),(1537,53,'Zrece'),(1539,53,'Domzale'),(1540,53,'Jesenice'),(1541,53,'Kamnik'),(1542,53,'Kocevje'),(1544,53,'Lenart'),(1545,53,'Litija'),(1546,53,'Ljutomer'),(1550,53,'Maribor'),(1552,53,'Novo Mesto'),(1553,53,'Piran'),(1554,53,'Preddvor'),(1555,53,'Ptuj'),(1556,53,'Ribnica'),(1558,53,'Sentjur pri Celju'),(1559,53,'Slovenska Bistrica'),(1560,53,'Videm'),(1562,53,'Zalec'),(1564,109,'Seychelles'),(1565,108,'Mauritania'),(1566,135,'Senegal'),(1567,154,'Road Town'),(1568,165,'Congo'),(1569,166,'Avarua'),(1570,172,'Malabo'),(1571,175,'Torshavn'),(1572,178,'Papeete'),(1573,184,'St George&#039;s'),(1574,186,'St Peter Port'),(1575,188,'Bissau'),(1576,193,'Saint Helier'),(1577,201,'Fort-de-France'),(1578,207,'Willemstad'),(1579,208,'Noumea'),(1580,212,'Kingston'),(1581,215,'Adamstown'),(1582,216,'Doha'),(1583,218,'Jamestown'),(1584,219,'Basseterre'),(1585,220,'Castries'),(1586,221,'Saint Pierre'),(1587,222,'Kingstown'),(1588,225,'San Tome'),(1589,226,'Belgrade'),(1590,227,'Freetown'),(1591,229,'Mogadishu'),(1592,235,'Fakaofo'),(1593,237,'Port of Spain'),(1594,241,'Mata-Utu'),(1596,89,'Amazonas'),(1597,89,'Ancash'),(1598,89,'Apurímac'),(1599,89,'Arequipa'),(1600,89,'Ayacucho'),(1601,89,'Cajamarca'),(1602,89,'Callao'),(1603,89,'Cusco'),(1604,89,'Huancavelica'),(1605,89,'Huánuco'),(1606,89,'Ica'),(1607,89,'Junín'),(1608,89,'La Libertad'),(1609,89,'Lambayeque'),(1610,89,'Lima'),(1611,89,'Loreto'),(1612,89,'Madre de Dios'),(1613,89,'Moquegua'),(1614,89,'Pasco'),(1615,89,'Piura'),(1616,89,'Puno'),(1617,89,'San Martín'),(1618,89,'Tacna'),(1619,89,'Tumbes'),(1620,89,'Ucayali'),(1622,110,'Alto Paraná'),(1623,110,'Amambay'),(1624,110,'Boquerón'),(1625,110,'Caaguaz&uacute;'),(1626,110,'Caazapá'),(1627,110,'Central'),(1628,110,'Concepción'),(1629,110,'Cordillera'),(1630,110,'Guairá'),(1631,110,'Itap&uacute;a'),(1632,110,'Misiones'),(1633,110,'Neembuc&uacute;'),(1634,110,'Paraguarí'),(1635,110,'Presidente Hayes'),(1636,110,'San Pedro'),(1637,110,'Alto Paraguay'),(1638,110,'Canindey&uacute;'),(1639,110,'Chaco'),(1642,111,'Artigas'),(1643,111,'Canelones'),(1644,111,'Cerro Largo'),(1645,111,'Colonia'),(1646,111,'Durazno'),(1647,111,'Flores'),(1648,111,'Florida'),(1649,111,'Lavalleja'),(1650,111,'Maldonado'),(1651,111,'Montevideo'),(1652,111,'Paysand&uacute;'),(1653,111,'Río Negro'),(1654,111,'Rivera'),(1655,111,'Rocha'),(1656,111,'Salto'),(1657,111,'San José'),(1658,111,'Soriano'),(1659,111,'Tacuarembó'),(1660,111,'Treinta y Tres'),(1662,81,'Región de Tarapacá'),(1663,81,'Región de Antofagasta'),(1664,81,'Región de Atacama'),(1665,81,'Región de Coquimbo'),(1666,81,'Región de Valparaíso'),(1667,81,'Región del Libertador General Bernardo O&#039;Higgins'),(1668,81,'Región del Maule'),(1669,81,'Región del Bío Bío'),(1670,81,'Región de La Araucanía'),(1671,81,'Región de Los Lagos'),(1672,81,'Región Aisén del General Carlos Ibáñez del Campo'),(1673,81,'Región de Magallanes y de la Antártica Chilena'),(1674,81,'Región Metropolitana de Santiago'),(1676,185,'Alta Verapaz'),(1677,185,'Baja Verapaz'),(1678,185,'Chimaltenango'),(1679,185,'Chiquimula'),(1680,185,'El Progreso'),(1681,185,'Escuintla'),(1682,185,'Guatemala'),(1683,185,'Huehuetenango'),(1684,185,'Izabal'),(1685,185,'Jalapa'),(1686,185,'Jutiapa'),(1687,185,'Petén'),(1688,185,'Quetzaltenango'),(1689,185,'Quiché'),(1690,185,'Retalhuleu'),(1691,185,'Sacatepéquez'),(1692,185,'San Marcos'),(1693,185,'Santa Rosa'),(1694,185,'Sololá'),(1695,185,'Suchitepequez'),(1696,185,'Totonicapán'),(1697,185,'Zacapa'),(1699,82,'Amazonas'),(1700,82,'Antioquia'),(1701,82,'Arauca'),(1702,82,'Atlántico'),(1703,82,'Caquetá'),(1704,82,'Cauca'),(1705,82,'César'),(1706,82,'Chocó'),(1707,82,'Córdoba'),(1708,82,'Guaviare'),(1709,82,'Guainía'),(1710,82,'Huila'),(1711,82,'La Guajira'),(1712,82,'Meta'),(1713,82,'Narino'),(1714,82,'Norte de Santander'),(1715,82,'Putumayo'),(1716,82,'Quindío'),(1717,82,'Risaralda'),(1718,82,'San Andrés y Providencia'),(1719,82,'Santander'),(1720,82,'Sucre'),(1721,82,'Tolima'),(1722,82,'Valle del Cauca'),(1723,82,'Vaupés'),(1724,82,'Vichada'),(1725,82,'Casanare'),(1726,82,'Cundinamarca'),(1727,82,'Distrito Especial'),(1730,82,'Caldas'),(1731,82,'Magdalena'),(1733,42,'Aguascalientes'),(1734,42,'Baja California'),(1735,42,'Baja California Sur'),(1736,42,'Campeche'),(1737,42,'Chiapas'),(1738,42,'Chihuahua'),(1739,42,'Coahuila de Zaragoza'),(1740,42,'Colima'),(1741,42,'Distrito Federal'),(1742,42,'Durango'),(1743,42,'Guanajuato'),(1744,42,'Guerrero'),(1745,42,'Hidalgo'),(1746,42,'Jalisco'),(1747,42,'México'),(1748,42,'Michoacán de Ocampo'),(1749,42,'Morelos'),(1750,42,'Nayarit'),(1751,42,'Nuevo León'),(1752,42,'Oaxaca'),(1753,42,'Puebla'),(1754,42,'Querétaro de Arteaga'),(1755,42,'Quintana Roo'),(1756,42,'San Luis Potosí'),(1757,42,'Sinaloa'),(1758,42,'Sonora'),(1759,42,'Tabasco'),(1760,42,'Tamaulipas'),(1761,42,'Tlaxcala'),(1762,42,'Veracruz-Llave'),(1763,42,'Yucatán'),(1764,42,'Zacatecas'),(1766,124,'Bocas del Toro'),(1767,124,'Chiriquí'),(1768,124,'Coclé'),(1769,124,'Colón'),(1770,124,'Darién'),(1771,124,'Herrera'),(1772,124,'Los Santos'),(1773,124,'Panamá'),(1774,124,'San Blas'),(1775,124,'Veraguas'),(1777,123,'Chuquisaca'),(1778,123,'Cochabamba'),(1779,123,'El Beni'),(1780,123,'La Paz'),(1781,123,'Oruro'),(1782,123,'Pando'),(1783,123,'Potosí'),(1784,123,'Santa Cruz'),(1785,123,'Tarija'),(1787,36,'Alajuela'),(1788,36,'Cartago'),(1789,36,'Guanacaste'),(1790,36,'Heredia'),(1791,36,'Limón'),(1792,36,'Puntarenas'),(1793,36,'San José'),(1795,103,'Galápagos'),(1796,103,'Azuay'),(1797,103,'Bolívar'),(1798,103,'Canar'),(1799,103,'Carchi'),(1800,103,'Chimborazo'),(1801,103,'Cotopaxi'),(1802,103,'El Oro'),(1803,103,'Esmeraldas'),(1804,103,'Guayas'),(1805,103,'Imbabura'),(1806,103,'Loja'),(1807,103,'Los Ríos'),(1808,103,'Manabí'),(1809,103,'Morona-Santiago'),(1810,103,'Pastaza'),(1811,103,'Pichincha'),(1812,103,'Tungurahua'),(1813,103,'Zamora-Chinchipe'),(1814,103,'Sucumbíos'),(1815,103,'Napo'),(1816,103,'Orellana'),(1818,5,'Buenos Aires'),(1819,5,'Catamarca'),(1820,5,'Chaco'),(1821,5,'Chubut'),(1822,5,'Córdoba'),(1823,5,'Corrientes'),(1824,5,'Distrito Federal'),(1825,5,'Entre Ríos'),(1826,5,'Formosa'),(1827,5,'Jujuy'),(1828,5,'La Pampa'),(1829,5,'La Rioja'),(1830,5,'Mendoza'),(1831,5,'Misiones'),(1832,5,'Neuquén'),(1833,5,'Río Negro'),(1834,5,'Salta'),(1835,5,'San Juan'),(1836,5,'San Luis'),(1837,5,'Santa Cruz'),(1838,5,'Santa Fe'),(1839,5,'Santiago del Estero'),(1840,5,'Tierra del Fuego'),(1841,5,'Tucumán'),(1843,95,'Amazonas'),(1844,95,'Anzoategui'),(1845,95,'Apure'),(1846,95,'Aragua'),(1847,95,'Barinas'),(1848,95,'Bolívar'),(1849,95,'Carabobo'),(1850,95,'Cojedes'),(1851,95,'Delta Amacuro'),(1852,95,'Falcón'),(1853,95,'Guárico'),(1854,95,'Lara'),(1855,95,'Mérida'),(1856,95,'Miranda'),(1857,95,'Monagas'),(1858,95,'Nueva Esparta'),(1859,95,'Portuguesa'),(1860,95,'Sucre'),(1861,95,'Táchira'),(1862,95,'Trujillo'),(1863,95,'Yaracuy'),(1864,95,'Zulia'),(1865,95,'Dependencias Federales'),(1866,95,'Distrito Capital'),(1867,95,'Vargas'),(1869,209,'Boaco'),(1870,209,'Carazo'),(1871,209,'Chinandega'),(1872,209,'Chontales'),(1873,209,'Estelí'),(1874,209,'Granada'),(1875,209,'Jinotega'),(1876,209,'León'),(1877,209,'Madriz'),(1878,209,'Managua'),(1879,209,'Masaya'),(1880,209,'Matagalpa'),(1881,209,'Nueva Segovia'),(1882,209,'Rio San Juan'),(1883,209,'Rivas'),(1884,209,'Zelaya'),(1886,113,'Pinar del Rio'),(1887,113,'Ciudad de la Habana'),(1888,113,'Matanzas'),(1889,113,'Isla de la Juventud'),(1890,113,'Camaguey'),(1891,113,'Ciego de Avila'),(1892,113,'Cienfuegos'),(1893,113,'Granma'),(1894,113,'Guantanamo'),(1895,113,'La Habana'),(1896,113,'Holguin'),(1897,113,'Las Tunas'),(1898,113,'Sancti Spiritus'),(1899,113,'Santiago de Cuba'),(1900,113,'Villa Clara'),(1901,12,'Acre'),(1902,12,'Alagoas'),(1903,12,'Amapa'),(1904,12,'Amazonas'),(1905,12,'Bahia'),(1906,12,'Ceara'),(1907,12,'Distrito Federal'),(1908,12,'Espirito Santo'),(1909,12,'Mato Grosso do Sul'),(1910,12,'Maranhao'),(1911,12,'Mato Grosso'),(1912,12,'Minas Gerais'),(1913,12,'Para'),(1914,12,'Paraiba'),(1915,12,'Parana'),(1916,12,'Piaui'),(1917,12,'Rio de Janeiro'),(1918,12,'Rio Grande do Norte'),(1919,12,'Rio Grande do Sul'),(1920,12,'Rondonia'),(1921,12,'Roraima'),(1922,12,'Santa Catarina'),(1923,12,'Sao Paulo'),(1924,12,'Sergipe'),(1925,12,'Goias'),(1926,12,'Pernambuco'),(1927,12,'Tocantins'),(1930,83,'Akureyri'),(1931,83,'Arnessysla'),(1932,83,'Austur-Bardastrandarsysla'),(1933,83,'Austur-Hunavatnssysla'),(1934,83,'Austur-Skaftafellssysla'),(1935,83,'Borgarfjardarsysla'),(1936,83,'Dalasysla'),(1937,83,'Eyjafjardarsysla'),(1938,83,'Gullbringusysla'),(1939,83,'Hafnarfjordur'),(1943,83,'Kjosarsysla'),(1944,83,'Kopavogur'),(1945,83,'Myrasysla'),(1946,83,'Neskaupstadur'),(1947,83,'Nordur-Isafjardarsysla'),(1948,83,'Nordur-Mulasysla'),(1949,83,'Nordur-Tingeyjarsysla'),(1950,83,'Olafsfjordur'),(1951,83,'Rangarvallasysla'),(1952,83,'Reykjavik'),(1953,83,'Saudarkrokur'),(1954,83,'Seydisfjordur'),(1956,83,'Skagafjardarsysla'),(1957,83,'Snafellsnes- og Hnappadalssysla'),(1958,83,'Strandasysla'),(1959,83,'Sudur-Mulasysla'),(1960,83,'Sudur-Tingeyjarsysla'),(1961,83,'Vestmannaeyjar'),(1962,83,'Vestur-Bardastrandarsysla'),(1964,83,'Vestur-Isafjardarsysla'),(1965,83,'Vestur-Skaftafellssysla'),(1966,35,'Anhui'),(1967,35,'Zhejiang'),(1968,35,'Jiangxi'),(1969,35,'Jiangsu'),(1970,35,'Jilin'),(1971,35,'Qinghai'),(1972,35,'Fujian'),(1973,35,'Heilongjiang'),(1974,35,'Henan'),(1975,35,'Hebei'),(1976,35,'Hunan'),(1977,35,'Hubei'),(1978,35,'Xinjiang'),(1979,35,'Xizang'),(1980,35,'Gansu'),(1981,35,'Guangxi'),(1982,35,'Guizhou'),(1983,35,'Liaoning'),(1984,35,'Nei Mongol'),(1985,35,'Ningxia'),(1986,35,'Beijing'),(1987,35,'Shanghai'),(1988,35,'Shanxi'),(1989,35,'Shandong'),(1990,35,'Shaanxi'),(1991,35,'Sichuan'),(1992,35,'Tianjin'),(1993,35,'Yunnan'),(1994,35,'Guangdong'),(1995,35,'Hainan'),(1996,35,'Chongqing'),(1997,97,'Central'),(1998,97,'Coast'),(1999,97,'Eastern'),(2000,97,'Nairobi Area'),(2001,97,'North-Eastern'),(2002,97,'Nyanza'),(2003,97,'Rift Valley'),(2004,97,'Western'),(2006,195,'Gilbert Islands'),(2007,195,'Line Islands'),(2008,195,'Phoenix Islands'),(2010,1,'Australian Capital Territory'),(2011,1,'New South Wales'),(2012,1,'Northern Territory'),(2013,1,'Queensland'),(2014,1,'South Australia'),(2015,1,'Tasmania'),(2016,1,'Victoria'),(2017,1,'Western Australia'),(2018,27,'Dublin'),(2019,27,'Galway'),(2020,27,'Kildare'),(2021,27,'Leitrim'),(2022,27,'Limerick'),(2023,27,'Mayo'),(2024,27,'Meath'),(2025,27,'Carlow'),(2026,27,'Kilkenny'),(2027,27,'Laois'),(2028,27,'Longford'),(2029,27,'Louth'),(2030,27,'Offaly'),(2031,27,'Westmeath'),(2032,27,'Wexford'),(2033,27,'Wicklow'),(2034,27,'Roscommon'),(2035,27,'Sligo'),(2036,27,'Clare'),(2037,27,'Cork'),(2038,27,'Kerry'),(2039,27,'Tipperary'),(2040,27,'Waterford'),(2041,27,'Cavan'),(2042,27,'Donegal'),(2043,27,'Monaghan'),(2044,50,'Karachaeva-Cherkesskaya Respublica'),(2045,50,'Raimirskii (Dolgano-Nenetskii) AO'),(2046,50,'Respublica Tiva'),(2047,32,'Newfoundland'),(2048,32,'Nova Scotia'),(2049,32,'Prince Edward Island'),(2050,32,'New Brunswick'),(2051,32,'Quebec'),(2052,32,'Ontario'),(2053,32,'Manitoba'),(2054,32,'Saskatchewan'),(2055,32,'Alberta'),(2056,32,'British Columbia'),(2057,32,'Nunavut'),(2058,32,'Northwest Territories'),(2059,32,'Yukon Territory'),(2060,19,'Drenthe'),(2061,19,'Friesland'),(2062,19,'Gelderland'),(2063,19,'Groningen'),(2064,19,'Limburg'),(2065,19,'Noord-Brabant'),(2066,19,'Noord-Holland'),(2067,19,'Utrecht'),(2068,19,'Zeeland'),(2069,19,'Zuid-Holland'),(2071,19,'Overijssel'),(2072,19,'Flevoland'),(2073,138,'Duarte'),(2074,138,'Puerto Plata'),(2075,138,'Valverde'),(2076,138,'María Trinidad Sánchez'),(2077,138,'Azua'),(2078,138,'Santiago'),(2079,138,'San Cristóbal'),(2080,138,'Peravia'),(2081,138,'Elías Piña'),(2082,138,'Barahona'),(2083,138,'Monte Plata'),(2084,138,'Salcedo'),(2085,138,'La Altagracia'),(2086,138,'San Juan'),(2087,138,'Monseñor Nouel'),(2088,138,'Monte Cristi'),(2089,138,'Espaillat'),(2090,138,'Sánchez Ramírez'),(2091,138,'La Vega'),(2092,138,'San Pedro de Macorís'),(2093,138,'Independencia'),(2094,138,'Dajabón'),(2095,138,'Baoruco'),(2096,138,'El Seibo'),(2097,138,'Hato Mayor'),(2098,138,'La Romana'),(2099,138,'Pedernales'),(2100,138,'Samaná'),(2101,138,'Santiago Rodríguez'),(2102,138,'San José de Ocoa'),(2103,70,'Chiba'),(2104,70,'Ehime'),(2105,70,'Oita'),(2106,85,'Skopje'),(2108,35,'Schanghai'),(2109,35,'Hongkong'),(2110,35,'Neimenggu'),(2111,35,'Aomen'),(2112,92,'Amnat Charoen'),(2113,92,'Ang Thong'),(2114,92,'Bangkok'),(2115,92,'Buri Ram'),(2116,92,'Chachoengsao'),(2117,92,'Chai Nat'),(2118,92,'Chaiyaphum'),(2119,92,'Chanthaburi'),(2120,92,'Chiang Mai'),(2121,92,'Chiang Rai'),(2122,92,'Chon Buri'),(2124,92,'Kalasin'),(2126,92,'Kanchanaburi'),(2127,92,'Khon Kaen'),(2128,92,'Krabi'),(2129,92,'Lampang'),(2131,92,'Loei'),(2132,92,'Lop Buri'),(2133,92,'Mae Hong Son'),(2134,92,'Maha Sarakham'),(2137,92,'Nakhon Pathom'),(2139,92,'Nakhon Ratchasima'),(2140,92,'Nakhon Sawan'),(2141,92,'Nakhon Si Thammarat'),(2143,92,'Narathiwat'),(2144,92,'Nong Bua Lam Phu'),(2145,92,'Nong Khai'),(2146,92,'Nonthaburi'),(2147,92,'Pathum Thani'),(2148,92,'Pattani'),(2149,92,'Phangnga'),(2150,92,'Phatthalung'),(2154,92,'Phichit'),(2155,92,'Phitsanulok'),(2156,92,'Phra Nakhon Si Ayutthaya'),(2157,92,'Phrae'),(2158,92,'Phuket'),(2159,92,'Prachin Buri'),(2160,92,'Prachuap Khiri Khan'),(2162,92,'Ratchaburi'),(2163,92,'Rayong'),(2164,92,'Roi Et'),(2165,92,'Sa Kaeo'),(2166,92,'Sakon Nakhon'),(2167,92,'Samut Prakan'),(2168,92,'Samut Sakhon'),(2169,92,'Samut Songkhran'),(2170,92,'Saraburi'),(2172,92,'Si Sa Ket'),(2173,92,'Sing Buri'),(2174,92,'Songkhla'),(2175,92,'Sukhothai'),(2176,92,'Suphan Buri'),(2177,92,'Surat Thani'),(2178,92,'Surin'),(2180,92,'Trang'),(2182,92,'Ubon Ratchathani'),(2183,92,'Udon Thani'),(2184,92,'Uthai Thani'),(2185,92,'Uttaradit'),(2186,92,'Yala'),(2187,92,'Yasothon'),(2188,69,'Busan'),(2189,69,'Daegu'),(2191,69,'Gangwon'),(2192,69,'Gwangju'),(2193,69,'Gyeonggi'),(2194,69,'Gyeongsangbuk'),(2195,69,'Gyeongsangnam'),(2196,69,'Jeju'),(2201,25,'Delhi'),(2202,81,'Región de Los Ríos'),(2203,81,'Región de Arica y Parinacota');

INSERT INTO ciudad VALUES (1,1834,'Cafayate'),(2,1818,'Buenos Aires'),(3,1818,'La Plata'),(4,1822,'Córdoba'),(5,1838,'Rosario'),(6,1831,'Posadas'),(7,1825,'Parana'),(8,1836,'Villa Mercedes');

INSERT INTO cliente VALUES (1,'Seba','Apellido','36584266','1996-05-08',1,4,'posadas.sca@gmail.com'),(2,'Nico','Avila','32125322','1995-04-12',2,5,'alplanetaproject@gmail.com');
INSERT INTO formapago VALUES (1,'Efectivo'),(2,'Tarjeta');
INSERT INTO estadospasaje VALUES (1,'Vendido','Se abono el total del pasaje'),(2,'Reservado','Se abono un porcentaje del pasaje'),(3,'Pendiente','No se registro pago'),(4,'Cancelado','Se cancelo el pasaje');
INSERT INTO horario VALUES (1,'1:00'),(2,'2:00'),(3,'3:00'),(4,'4:00'),(5,'5:00'),(6,'6:00'),(7,'7:00'),(8,'8:00'),(9,'9:00'),(10,'10:00'),(11,'11:00'),(12,'12:00');
INSERT INTO transporte VALUES (1,'Avion'),(2,'Micro'),(3,'Buquebus');
INSERT INTO viaje VALUES (1,'2019-05-01','2019-05-02',500,2,1,1818,1818,5,5,'12:00',1,12,500),(2,'2019-05-04','2019-05-16',700,2,4,1818,1822,5,5,'3:00',2,14,150),(3,'2019-05-16','2019-05-28',1200,2,4,1818,1822,5,5,'7:00',3,24,1000);
INSERT INTO estadoevento VALUES (1,'pendiente','el evento aún no se realizó'), (2,'realizado','el evento ya se realizó'),(3,'cancelado','el evento fue cancelado'), (4,'vencido','el evento está vencido');

INSERT INTO evento VALUES (1,'2019-05-27','2019-05-30','15:00:00','Consulta sobre reserva de viaje',1,1,2,'',1), (2,'2019-05-28','2019-06-04','18:00:00','Llamar a cliente por reclamo',2,1,1,'',0), (3,'2019-05-28','2019-06-04','19:15:00','Llamar al cliente por viaje a San Juan, Argentina',1,1,1,'',0), (4,'2019-05-29','2019-06-06','15:00:00','Llamar al cliente por reclamo de un viaje',2,1,1,'',0);
INSERT INTO regimenpunto VALUES (1,1,100,4);

INSERT INTO promocion VALUES (1,15,200,'2019-10-04','activa');
INSERT INTO viaje_promocion VALUES (1,2,1);