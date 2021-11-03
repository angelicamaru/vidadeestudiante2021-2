CREATE TABLE `panaaliado` (
	`IdPanaAliado` int NOT NULL AUTO_INCREMENT,
	`Correo` tinytext NOT NULL,
	`Descripcion` MediumBlob NOT NULL,
	`Nombre` tinytext NOT NULL,
	`Carrera` tinytext NOT NULL,
	PRIMARY KEY (`IdPanaAliado`)
);

CREATE TABLE `usuario` (
	`IdUsuario` int NOT NULL AUTO_INCREMENT,
	`Nombre` tinytext NOT NULL,
	`Clave` tinytext NOT NULL,
	`Correo` tinytext NOT NULL,
	PRIMARY KEY (`IdUsuario`)
);

CREATE TABLE `guerrero` (
	`IdGuerrero` int NOT NULL AUTO_INCREMENT,
	`Correo` tinytext NOT NULL,
	`CodigoPromocional` tinytext NOT NULL,
	`Nombre` tinytext NOT NULL,
	`Clave` tinytext NOT NULL,
	PRIMARY KEY (`IdGuerrero`)
);

CREATE TABLE `producto` (
	`IdProducto` int NOT NULL AUTO_INCREMENT,
	`Nombre` tinytext NOT NULL,
	`Descripcion` MediumBlob NOT NULL,
	`Precio` FLOAT NOT NULL,
	`Imagen` LONGBLOB NOT NULL,
	`numeroDisponible` int NOT NULL,
	PRIMARY KEY (`IdProducto`)
);

CREATE TABLE `evento` (
	`IdEvento` int NOT NULL AUTO_INCREMENT,
	`Fecha` DATE NOT NULL,
	`Imagen` LONGBLOB NOT NULL,
	`Titulo` tinytext NOT NULL,
	`Descripcion` Blob NOT NULL,
	`Lugar` tinytext NOT NULL,
	`Promotor` tinytext NOT NULL,
	`Contacto` tinytext NOT NULL,
	`Costo` int NOT NULL,
	PRIMARY KEY (`IdEvento`)
);

CREATE TABLE `blog` (
	`IdBlog` int NOT NULL AUTO_INCREMENT,
	`Fecha` DATE NOT NULL,
	`Imagen` LONGBLOB NOT NULL,
	`Titulo` tinytext NOT NULL,
	`Descripcion` MediumBlob NOT NULL,
	`Autor` tinytext NOT NULL,
	`EtiquetaUno` tinytext NOT NULL,
	`EtiquetaDos` tinytext NOT NULL,
	PRIMARY KEY (`IdBlog`)
);

CREATE TABLE `UsuarioProducto` (
	`IdUsuario` int NOT NULL,
	`IdProducto` int NOT NULL,
	`Fecha` DATETIME NOT NULL,
	`Descripcion` TEXT NOT NULL,
	PRIMARY KEY (`IdUsuario`,`IdProducto`,`Fecha`)
);

CREATE TABLE `GuerreroComProducto` (
	`IdGuerrero` int NOT NULL,
	`IdProducto` int NOT NULL,
	`Fecha` int NOT NULL,
	PRIMARY KEY (`IdGuerrero`,`IdProducto`,`Fecha`)
);

CREATE TABLE `GuerreroPromProducto` (
	`IdGuerrero` int NOT NULL,
	`IdProducto` int NOT NULL,
	`Fecha` int NOT NULL,
	PRIMARY KEY (`IdGuerrero`,`IdProducto`,`Fecha`)
);

/*ALTER TABLE `evento` ADD CONSTRAINT `evento_fk0` FOREIGN KEY (`IdUsuario`) REFERENCES `usuario`(`IdUsuario`);*/

