-- liquibase formatted sql

-- changeset hiko:1
-- comment: creacion de tablas
CREATE TABLE maestro(
	id INT NOT NULL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(50) NOT NULL
);

CREATE TABLE detalle(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(50) NOT NULL,
    id_maestro INT NOT NULL,
	 	FOREIGN KEY (id_maestro) REFERENCES maestro(id)
);

CREATE TABLE pais(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(20) NOT NULL,
    abreviatura VARCHAR(2) NOT NULL,
    dominio VARCHAR(20) NOT NULL
);

CREATE TABLE empleado(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    primer_apellido VARCHAR(20) NOT NULL,
    segundo_apellido VARCHAR(20),
    primer_nombre VARCHAR(20) NOT NULL,
    otro_nombre VARCHAR(50),
	id_pais INT NOT NULL,
	 	FOREIGN KEY (id_pais) REFERENCES pais(id),
	id_tipo_identificacion INT NOT NULL,
	 	FOREIGN KEY (id_tipo_identificacion) REFERENCES detalle(id),
	numero_identificacion VARCHAR(20) NOT NULL UNIQUE,
    email VARCHAR(300) NOT NULL UNIQUE,
    fecha_ingreso DATE NOT NULL,
    id_area INT NOT NULL,
	 	FOREIGN KEY (id_area) REFERENCES detalle(id),
	id_estado INT DEFAULT 1,
	 	FOREIGN KEY (id_estado) REFERENCES detalle(id),
	fecha_hora_registro DATETIME NOT NULL,
    fecha_hora_edicion DATETIME NOT NULL
);