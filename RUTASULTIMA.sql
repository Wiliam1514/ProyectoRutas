-- Crear tabla Departamentos
CREATE DATABASE Rutas;
GO
USE Rutas;

CREATE TABLE Departamentos (
    Id INT PRIMARY KEY IDENTITY (1,1),
    NombreDepartamento VARCHAR(50) NOT NULL
);

-- Crear tabla Roles
CREATE TABLE Roles (
    Id INT PRIMARY KEY IDENTITY (1,1),
    NombreRol VARCHAR(50) NOT NULL
);

-- Insertar roles iniciales
INSERT INTO Roles ( NombreRol)
VALUES
    ( 'Administrador'),
    ( 'Conductor'),
    ( 'Usuario Regular');

-- Crear tabla Usuarios
CREATE TABLE Usuarios (
    Id INT PRIMARY KEY IDENTITY (1,1),
	IdRol INT,
    Nombre VARCHAR(50) NOT NULL,
    Apellido VARCHAR(50) NOT NULL,
    [Login] VARCHAR(100) NOT NULL,
    [Password] VARCHAR(100) NOT NULL,  
	Estatus tinyint NOT NULL,
	[FechaRegistro] DateTime not null,
    FOREIGN KEY (IdRol) REFERENCES Roles(Id)
);

-- Crear tabla Autobuses
CREATE TABLE Autobuses (
    Id INT PRIMARY KEY IDENTITY (1,1),
    NumeroAutobus VARCHAR(20) NOT NULL,
    Capacidad INT NOT NULL,
    Modelo VARCHAR(50) NOT NULL,
    AnioFabricacion INT NOT NULL
);

-- Crear tabla Rutas
CREATE TABLE Rutas (
    Id INT PRIMARY KEY IDENTITY (1,1),
	IdDepartamento INT,
    IdConductor INT,
    IdAutobus INT,
    NombreRuta VARCHAR(100) NOT NULL,
    Descripcion VARCHAR(255),
    Horario VARCHAR(100),
    FOREIGN KEY (IdDepartamento) REFERENCES Departamentos(Id),
    FOREIGN KEY (IdConductor) REFERENCES Usuarios(Id),
    FOREIGN KEY (IdAutobus) REFERENCES Autobuses(Id)
);