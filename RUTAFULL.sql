-- Crear tabla Departamentos
CREATE DATABASE RutasDB;
GO
USE RutasDB;

CREATE TABLE Departamento (
    Id INT PRIMARY KEY IDENTITY (1,1),
    NombreDepartamento VARCHAR(50) NOT NULL
);

-- Crear tabla Rol
CREATE TABLE Rol (
    [Id] INT PRIMARY KEY IDENTITY (1,1),
    NombreRol VARCHAR(100) NOT NULL
);

-- Crear tabla Usuarios
CREATE TABLE Usuario (
    Id INT PRIMARY KEY IDENTITY (1,1),
	IdRol INT NOT NULL,
    Nombre VARCHAR(50) NOT NULL,
    Apellido VARCHAR(50) NOT NULL,
    [Login] VARCHAR(100) NOT NULL,
    [Password] VARCHAR(100) NOT NULL,  
	Estatus tinyint NOT NULL,
	[FechaRegistro] DateTime not null,
    FOREIGN KEY (IdRol) REFERENCES Rol(id)
);
USE RutasDB;
-- Crear tabla Rutas
CREATE TABLE Ruta (
    Id INT PRIMARY KEY IDENTITY (1,1),
	IdDepartamento INT NOT NULL,
    NombreRuta VARCHAR(100) NOT NULL,
    Recorrido VARCHAR(255),
	PuntoSalida VARCHAR (200)NOT NULL,
	PuntoLlegada VARCHAR (200) NOT NULL,
    HoraInicio VARCHAR(100),
	HoraFin VARCHAR(100),
	CodigoBus Varchar(100),
    FOREIGN KEY (IdDepartamento) REFERENCES Departamento(Id),
    
);

use RutasDB;
DECLARE @password VARCHAR(100);
SET @password = 'PEPAS';

DECLARE @encryptedPassword VARCHAR(32);
SET @encryptedPassword = CONVERT(VARCHAR(32), HASHBYTES('MD5', @password), 2);

INSERT INTO Usuario (IdRol, Nombre, Apellido, Login, Password, Estatus, FechaRegistro)
VALUES (1, 'John', 'Doe', 'john.doe', @encryptedPassword, 1, GETDATE());