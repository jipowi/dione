
INSERT INTO CATALOGO (DESCRIPCION_CATALOGO) VALUES ('Roles');
INSERT INTO CATALOGO (DESCRIPCION_CATALOGO) VALUES ('Competencias Interpersonales');
INSERT INTO CATALOGO (DESCRIPCION_CATALOGO) VALUES ('Competencias Instrumentales');
INSERT INTO CATALOGO (DESCRIPCION_CATALOGO) VALUES ('Competencias Sistematicas');

--Roles
INSERT INTO DETALLE_CATALOGO (ID_CATALOGO, COD_DETALLE_CATALOGO, DESC_DET_CATALOGO) VALUES (1, '1', 'Administrador');
INSERT INTO DETALLE_CATALOGO (ID_CATALOGO, COD_DETALLE_CATALOGO, DESC_DET_CATALOGO) VALUES (1, '2', 'Docente');
INSERT INTO DETALLE_CATALOGO (ID_CATALOGO, COD_DETALLE_CATALOGO, DESC_DET_CATALOGO) VALUES (1, '3', 'Inspector');

--Competencias Interpesonales
INSERT INTO DETALLE_CATALOGO (ID_CATALOGO, COD_DETALLE_CATALOGO, DESC_DET_CATALOGO) VALUES (2, '1', 'Capacidad cr�tica y autocr�tica');
INSERT INTO DETALLE_CATALOGO (ID_CATALOGO, COD_DETALLE_CATALOGO, DESC_DET_CATALOGO) VALUES (2, '2', 'Capacidad de trabajo en equipo');
INSERT INTO DETALLE_CATALOGO (ID_CATALOGO, COD_DETALLE_CATALOGO, DESC_DET_CATALOGO) VALUES (2, '3', 'Habilidades interpersonales');
INSERT INTO DETALLE_CATALOGO (ID_CATALOGO, COD_DETALLE_CATALOGO, DESC_DET_CATALOGO) VALUES (2, '4', 'Compromiso �tico');

--Competencias Instrumentales
INSERT INTO DETALLE_CATALOGO (ID_CATALOGO, COD_DETALLE_CATALOGO, DESC_DET_CATALOGO) VALUES (3, '1', 'Capacidad de abstracci�n, an�lisis y s�ntesis');
INSERT INTO DETALLE_CATALOGO (ID_CATALOGO, COD_DETALLE_CATALOGO, DESC_DET_CATALOGO) VALUES (3, '2', 'Capacidad para organizar y planificar el tiempo');
INSERT INTO DETALLE_CATALOGO (ID_CATALOGO, COD_DETALLE_CATALOGO, DESC_DET_CATALOGO) VALUES (3, '3', 'Habilidades en el uso de las tecnolog�as de la informaci�n y de la comunicaci�n');
INSERT INTO DETALLE_CATALOGO (ID_CATALOGO, COD_DETALLE_CATALOGO, DESC_DET_CATALOGO) VALUES (3, '4', 'Habilidades para buscar, procesar y analizar informaci�n procedente fuentes diversas');
INSERT INTO DETALLE_CATALOGO (ID_CATALOGO, COD_DETALLE_CATALOGO, DESC_DET_CATALOGO) VALUES (3, '5', 'Capacidad para identificar, plantear y resolver problemas');
INSERT INTO DETALLE_CATALOGO (ID_CATALOGO, COD_DETALLE_CATALOGO, DESC_DET_CATALOGO) VALUES (3, '6', 'Capacidad para tomar decisiones');

--Competencias Sistematicas
INSERT INTO DETALLE_CATALOGO (ID_CATALOGO, COD_DETALLE_CATALOGO, DESC_DET_CATALOGO) VALUES (4, '1', 'Capacidad de aplicar los conocimientos en la pr�ctica');
INSERT INTO DETALLE_CATALOGO (ID_CATALOGO, COD_DETALLE_CATALOGO, DESC_DET_CATALOGO) VALUES (4, '2', 'Capacidad de investigaci�n');
INSERT INTO DETALLE_CATALOGO (ID_CATALOGO, COD_DETALLE_CATALOGO, DESC_DET_CATALOGO) VALUES (4, '3', 'Capacidad de aprender y actualizarse permanentemente.');
INSERT INTO DETALLE_CATALOGO (ID_CATALOGO, COD_DETALLE_CATALOGO, DESC_DET_CATALOGO) VALUES (4, '4', 'Capacidad para actuar en nuevas situaciones');
INSERT INTO DETALLE_CATALOGO (ID_CATALOGO, COD_DETALLE_CATALOGO, DESC_DET_CATALOGO) VALUES (4, '5', 'Capacidad creativa');
INSERT INTO DETALLE_CATALOGO (ID_CATALOGO, COD_DETALLE_CATALOGO, DESC_DET_CATALOGO) VALUES (4, '6', 'Responsabilidad social y compromiso ciudadano');


--TABLA ESCUELAS
INSERT INTO ESCUELA VALUES(1,'CIENCIAS');
INSERT INTO ESCUELA VALUES(2,'CIVIL');
INSERT INTO ESCUELA VALUES(3,'COMPUTACION GRAFICA');

--TABLA MATERIAS
INSERT INTO MATERIA VALUES(1, 1, 'ANALISIS I');
INSERT INTO MATERIA VALUES(2, 1, 'ANALISIS II');
INSERT INTO MATERIA VALUES(3, 1, 'ANALISIS III');
INSERT INTO MATERIA VALUES(4, 1, 'FISICA I');
INSERT INTO MATERIA VALUES(5, 1, 'FISICA II');
INSERT INTO MATERIA VALUES(6, 2, 'PUENTES I');
INSERT INTO MATERIA VALUES(7, 2, 'FISICA');
INSERT INTO MATERIA VALUES(8, 3, 'DIBUJO');
INSERT INTO MATERIA VALUES(9, 3, 'DIBUJO ESPACIAL');
--TABLA PREREQUISITOS
INSERT INTO PREREQUISITO VALUES(1, 1, 'MATEMATICAS');
INSERT INTO PREREQUISITO VALUES(2, 1, 'ALGEBRA');
INSERT INTO PREREQUISITO VALUES(3, 2, 'ANALISIS I');

--TABLA COREQUISITO
INSERT INTO COREQUISITO VALUES(1, 1, 'COREQUISITO 1');
INSERT INTO COREQUISITO VALUES(2, 1, 'COREQUISITO 2');

--TABLA USUARIO
INSERT INTO USUARIO VALUES (1, 'admin', 'PAUL JIMENEZ','admin', '1719186262', 'A', 'A');

-- TABLA DE ROL
INSERT INTO ROL VALUES (1, 1, 'DOCENTE', 'DOCENTE', 'A');

--TABLA MENU
INSERT INTO MENU VALUES (1, NULL, 'Docente', NULL,'A');
INSERT INTO MENU VALUES (2, NULL, 'Syllabus', NULL,'A');
INSERT INTO MENU VALUES (3, NULL, 'Administracion', NULL,'A');

INSERT INTO MENU VALUES (6, 1, 'Ingresar Docente', '/pages/docente.jsf','A');
INSERT INTO MENU VALUES (7, 1, 'Ingresar Hoja de Vida', '/pages/hojaVida.jsf','A');
INSERT INTO MENU VALUES (8, 1, 'Buscar Docente', '/pages/buscarDocente.jsf','A');
INSERT INTO MENU VALUES (9, 2, 'Ingresar Syllabus', '/pages/syllabus.jsf','A');
INSERT INTO MENU VALUES (10, 2, 'Verificar cumplimiento syllabus', '/pages/cumplimientoSyllabus.jsf','A');
INSERT INTO MENU VALUES (11, 3, 'Ingresar Usuarios', '/pages/usuarios.jsf','A');

INSERT INTO ROL_MENU VALUES (1,1,1);
INSERT INTO ROL_MENU VALUES (2,2,1);
INSERT INTO ROL_MENU VALUES (3,3,1);
INSERT INTO ROL_MENU VALUES (4,6,1);
INSERT INTO ROL_MENU VALUES (5,7,1);
INSERT INTO ROL_MENU VALUES (6,8,1);
INSERT INTO ROL_MENU VALUES (7,9,1);
INSERT INTO ROL_MENU VALUES (8,10,1);
INSERT INTO ROL_MENU VALUES (9,11,1);