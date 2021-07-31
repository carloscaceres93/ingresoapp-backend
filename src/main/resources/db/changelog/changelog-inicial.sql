-- liquibase formatted sql

-- changeset hiko:1
-- comment: creacion de tablas
CREATE TABLE maestro(
	id INT NOT NULL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(255) NOT NULL
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
    email VARCHAR(300),
    fecha_ingreso DATE,
    id_area INT NOT NULL,
	 	FOREIGN KEY (id_area) REFERENCES detalle(id),
	id_estado INT DEFAULT 1,
	 	FOREIGN KEY (id_estado) REFERENCES detalle(id),
	fecha_hora_registro DATETIME DEFAULT NOW(),
    fecha_hora_edicion DATETIME
);

-- changeset hiko:2
-- comment: Datos iniciales

INSERT INTO maestro VALUES
	(1, 'ESTADO', 'Estado del registro la empleado'),
    (2, 'TIPO IDENTIFICACION', 'Tipo de docuemnto de identidad del empleado'),
    (3, 'AREA', 'Dependencia o area de trabajo la cual pertenece el empleado');
    
INSERT INTO detalle(nombre, descripcion, id_maestro) VALUES
	('ACTIVO', 'Estado actual del empleado', 1),
    ('INACTIVO', 'Estado actual del empleado', 1),
    
    ('CC', 'CEDULA DE CIUDADANIA', 2),
    ('CE', 'CEDULA DE EXTRANJERIA', 2),
    ('PA', 'PASAPORTE', 2),
    ('PE', 'PERMISO ESPECIAL', 2),
    ('CC', 'CEDULA DE CIUDADANIA', 2),
	
    ('ADMINISTRACION', 'Area de administración', 3),
    ('FINANCIERA', 'Area de Financiera', 3),
    ('COMPRAS', 'Area de Compras', 3),
    ('INFRAESTRUCTURA', 'Area de Infraestructura', 3),
    ('OPERACION', 'Area de Operación', 3),
    ('INFRAESTRUCTURA', 'Area de Infraestructura', 3),
    ('SERVICIOS VARIOS', 'Area de Servicios Varios', 3);
    
INSERT INTO pais(nombre, abreviatura, dominio) VALUES
    ('COLOMBIA', 'CO', 'cidenet.com.co'),
    ('ESTADOS UNIDOS', 'US', 'cidenet.com.us');