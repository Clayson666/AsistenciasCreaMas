-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 25-10-2024 a las 02:31:54
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `asistenciacrea`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asistencia`
--

CREATE TABLE `asistencia` (
  `idasistencia` int(11) NOT NULL,
  `asistencia` varchar(255) DEFAULT NULL,
  `fecha` datetime(6) DEFAULT NULL,
  `persona_idpersona` int(11) DEFAULT NULL,
  `semana_idsemana` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `asistencia`
--

INSERT INTO `asistencia` (`idasistencia`, `asistencia`, `fecha`, `persona_idpersona`, `semana_idsemana`) VALUES
(1, 'Asistió', '2024-10-15 13:14:13.000000', 1, 1),
(2, 'Asistió', '2024-10-15 13:14:13.000000', 5, 1),
(3, 'Asistió', '2024-10-15 13:14:13.000000', 9, 1),
(4, 'Asistió', '2024-10-15 13:14:13.000000', 13, 1),
(5, 'Asistió', '2024-10-15 13:14:15.000000', 1, 2),
(6, 'Asistió', '2024-10-15 13:14:15.000000', 5, 2),
(7, 'Asistió', '2024-10-15 13:14:15.000000', 9, 2),
(8, 'Asistió', '2024-10-15 13:14:15.000000', 13, 2),
(9, 'Asistió', '2024-10-15 18:17:30.000000', 1, 3),
(10, 'Asistió', '2024-10-15 18:17:30.000000', 5, 3),
(11, 'Asistió', '2024-10-15 18:17:30.000000', 9, 3),
(12, 'Asistió', '2024-10-15 18:17:30.000000', 13, 3),
(13, 'Asistió', '2024-10-15 18:17:33.000000', 1, 4),
(14, 'Asistió', '2024-10-15 18:17:33.000000', 5, 4),
(15, 'Asistió', '2024-10-15 18:17:33.000000', 9, 4),
(16, 'Asistió', '2024-10-15 18:17:33.000000', 13, 4),
(17, 'Asistió', '2024-10-15 18:17:35.000000', 1, 5),
(18, 'Asistió', '2024-10-15 18:17:35.000000', 5, 5),
(19, 'Asistió', '2024-10-15 18:17:35.000000', 9, 5),
(20, 'Asistió', '2024-10-15 18:17:35.000000', 13, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `creando`
--

CREATE TABLE `creando` (
  `idpersona` int(11) NOT NULL,
  `taller` varchar(255) DEFAULT NULL,
  `ciclo` varchar(255) DEFAULT NULL,
  `rol` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `creando`
--

INSERT INTO `creando` (`idpersona`, `taller`, `ciclo`, `rol`) VALUES
(1, 'futbol', 'ciclo 1', 'Creando Docente'),
(2, 'basquet', 'ciclo 2', 'Creando Docente'),
(3, 'artes', 'ciclo 3', 'Creando Docente'),
(4, 'magia', 'ciclo 4', 'Creando Docente'),
(5, 'soprano', 'ciclo 1', 'Creando Docente'),
(6, 'freestyle', 'ciclo 2', 'Creando Docente'),
(7, 'futbol', 'ciclo 3', 'Creando Docente'),
(8, 'basquet', 'ciclo 4', 'Creando Docente'),
(9, 'artes', 'ciclo 1', 'Creando Docente'),
(10, 'magia', 'ciclo 2', 'Creando Docente'),
(11, 'soprano', 'ciclo 3', 'Creando Docente'),
(12, 'freestyle', 'ciclo 4', 'Creando Docente'),
(13, 'futbol', 'ciclo 1', 'Creando Docente'),
(14, 'basquet', 'ciclo 2', 'Creando Docente');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `creandolideres`
--

CREATE TABLE `creandolideres` (
  `idpersona` int(11) NOT NULL,
  `rol` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lugar`
--

CREATE TABLE `lugar` (
  `idLugar` int(11) NOT NULL,
  `nombreLugar` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `lugar`
--

INSERT INTO `lugar` (`idLugar`, `nombreLugar`) VALUES
(1, 'Colegio maria auxiliadora'),
(2, 'Colegio manuel robles'),
(3, 'Colegio santo tomas'),
(4, 'Colegio sana gustin');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `idpersona` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `sexo` varchar(255) DEFAULT NULL,
  `celular` varchar(255) DEFAULT NULL,
  `dni` varchar(255) DEFAULT NULL,
  `idLugar` int(11) DEFAULT NULL,
  `idPrograma` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`idpersona`, `nombre`, `apellido`, `sexo`, `celular`, `dni`, `idLugar`, `idPrograma`) VALUES
(1, 'Juan', 'Pérez', 'M', '999999999', '12345678', 1, 1),
(2, 'Ana', 'García', 'F', '988888888', '87654321', 2, 1),
(3, 'Carlos', 'Santos', 'M', '977777777', '11223344', 3, 1),
(4, 'Lucía', 'Ramos', 'F', '966666666', '44332211', 4, 1),
(5, 'Roberto', 'Martínez', 'M', '955555555', '55667788', 1, 1),
(6, 'Laura', 'Fernández', 'F', '944444444', '66778899', 2, 1),
(7, 'Pedro', 'Gómez', 'M', '933333333', '77889900', 3, 1),
(8, 'Carmen', 'Díaz', 'F', '922222222', '88990011', 4, 1),
(9, 'Miguel', 'Lopez', 'M', '911111111', '99001122', 1, 1),
(10, 'Sofía', 'Ruiz', 'F', '900000000', '10111213', 2, 1),
(11, 'Ricardo', 'Hernández', 'M', '989898989', '13141516', 3, 1),
(12, 'Elena', 'Torres', 'F', '979797979', '16171819', 4, 1),
(13, 'Daniel', 'Ortiz', 'M', '969696969', '19202122', 1, 1),
(14, 'Paula', 'Romero', 'F', '959595959', '22232425', 2, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `programa`
--

CREATE TABLE `programa` (
  `idprograma` int(11) NOT NULL,
  `nombrePrograma` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `programa`
--

INSERT INTO `programa` (`idprograma`, `nombrePrograma`) VALUES
(1, 'Dona tu talento');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `semana`
--

CREATE TABLE `semana` (
  `idsemana` int(11) NOT NULL,
  `nombreSemana` varchar(255) DEFAULT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `semana`
--

INSERT INTO `semana` (`idsemana`, `nombreSemana`, `fecha`) VALUES
(1, 'Bienvenida de lideres', '2024-10-15'),
(2, 'Bienvenida general', '2024-10-15'),
(3, 'Semana 1', '2024-10-15'),
(4, 'Semana 2', '2024-10-15'),
(5, 'Semana 3', '2024-10-15'),
(6, 'Semana 4', '2024-10-15');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `asistencia`
--
ALTER TABLE `asistencia`
  ADD PRIMARY KEY (`idasistencia`),
  ADD KEY `FK8rr2yo3bhng08c80vouo5nf00` (`persona_idpersona`),
  ADD KEY `FKd729q39b41ockakl8sqpw9vlv` (`semana_idsemana`);

--
-- Indices de la tabla `creando`
--
ALTER TABLE `creando`
  ADD PRIMARY KEY (`idpersona`);

--
-- Indices de la tabla `creandolideres`
--
ALTER TABLE `creandolideres`
  ADD PRIMARY KEY (`idpersona`);

--
-- Indices de la tabla `lugar`
--
ALTER TABLE `lugar`
  ADD PRIMARY KEY (`idLugar`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`idpersona`),
  ADD KEY `FKgc5nf2v9kdh5slm6lsb0r7a6j` (`idLugar`),
  ADD KEY `FK4yo0rawh067grda59j0rdrnrt` (`idPrograma`);

--
-- Indices de la tabla `programa`
--
ALTER TABLE `programa`
  ADD PRIMARY KEY (`idprograma`);

--
-- Indices de la tabla `semana`
--
ALTER TABLE `semana`
  ADD PRIMARY KEY (`idsemana`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `asistencia`
--
ALTER TABLE `asistencia`
  MODIFY `idasistencia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `lugar`
--
ALTER TABLE `lugar`
  MODIFY `idLugar` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `idpersona` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `programa`
--
ALTER TABLE `programa`
  MODIFY `idprograma` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `semana`
--
ALTER TABLE `semana`
  MODIFY `idsemana` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `asistencia`
--
ALTER TABLE `asistencia`
  ADD CONSTRAINT `FK8rr2yo3bhng08c80vouo5nf00` FOREIGN KEY (`persona_idpersona`) REFERENCES `persona` (`idpersona`),
  ADD CONSTRAINT `FKd729q39b41ockakl8sqpw9vlv` FOREIGN KEY (`semana_idsemana`) REFERENCES `semana` (`idsemana`);

--
-- Filtros para la tabla `creando`
--
ALTER TABLE `creando`
  ADD CONSTRAINT `FKqioqc8urxlbcm1e1syf51h25r` FOREIGN KEY (`idpersona`) REFERENCES `persona` (`idpersona`);

--
-- Filtros para la tabla `creandolideres`
--
ALTER TABLE `creandolideres`
  ADD CONSTRAINT `FKtox3k5gif2s4eoqdheiixqe73` FOREIGN KEY (`idpersona`) REFERENCES `persona` (`idpersona`);

--
-- Filtros para la tabla `persona`
--
ALTER TABLE `persona`
  ADD CONSTRAINT `FK4yo0rawh067grda59j0rdrnrt` FOREIGN KEY (`idPrograma`) REFERENCES `programa` (`idprograma`),
  ADD CONSTRAINT `FKgc5nf2v9kdh5slm6lsb0r7a6j` FOREIGN KEY (`idLugar`) REFERENCES `lugar` (`idLugar`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
