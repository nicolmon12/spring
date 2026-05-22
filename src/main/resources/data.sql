-- Datos de ejemplo para Asociaciones
INSERT INTO asociacion (nombre, pais, presidente) VALUES ('FIFA', 'Suiza', 'Gianni Infantino');
INSERT INTO asociacion (nombre, pais, presidente) VALUES ('UEFA', 'Suiza', 'Aleksander Ceferin');
INSERT INTO asociacion (nombre, pais, presidente) VALUES ('CONMEBOL', 'Paraguay', 'Alejandro Dominguez');

-- Datos de ejemplo para Clubes
INSERT INTO club (nombre, ciudad) VALUES ('Real Madrid', 'Madrid');
INSERT INTO club (nombre, ciudad) VALUES ('Barcelona FC', 'Barcelona');
INSERT INTO club (nombre, ciudad) VALUES ('Atletico de Madrid', 'Madrid');
INSERT INTO club (nombre, ciudad) VALUES ('Sevilla FC', 'Sevilla');
INSERT INTO club (nombre, ciudad) VALUES ('Valencia CF', 'Valencia');

-- Datos de ejemplo para Entrenadores
INSERT INTO entrenador (nombre, apellido, edad, nacionalidad, club_id) VALUES ('Carlo', 'Ancelotti', 65, 'Italiana', 1);
INSERT INTO entrenador (nombre, apellido, edad, nacionalidad, club_id) VALUES ('Xavi', 'Hernandez', 44, 'Espanola', 2);
INSERT INTO entrenador (nombre, apellido, edad, nacionalidad, club_id) VALUES ('Diego', 'Simeone', 54, 'Argentina', 3);

-- Asignar entrenador principal a cada club
UPDATE club SET entrenador_id = 1 WHERE id = 1;
UPDATE club SET entrenador_id = 2 WHERE id = 2;
UPDATE club SET entrenador_id = 3 WHERE id = 3;

-- Datos de ejemplo para Jugadores
INSERT INTO jugador (nombre, apellido, numero, posicion, club_id) VALUES ('Vinicius', 'Jr', 7, 'Delantero', 1);
INSERT INTO jugador (nombre, apellido, numero, posicion, club_id) VALUES ('Luka', 'Modric', 10, 'Mediocampista', 1);
INSERT INTO jugador (nombre, apellido, numero, posicion, club_id) VALUES ('Pedri', 'Gonzalez', 8, 'Mediocampista', 2);
INSERT INTO jugador (nombre, apellido, numero, posicion, club_id) VALUES ('Robert', 'Lewandowski', 9, 'Delantero', 2);
INSERT INTO jugador (nombre, apellido, numero, posicion, club_id) VALUES ('Antoine', 'Griezmann', 7, 'Delantero', 3);

-- Datos de ejemplo para Competiciones
INSERT INTO competicion (nombre, monto_premio, fecha_inicio, fecha_fin) VALUES ('La Liga', 5000000, '2024-08-15', '2025-05-25');
INSERT INTO competicion (nombre, monto_premio, fecha_inicio, fecha_fin) VALUES ('Champions League', 15000000, '2024-09-17', '2025-05-31');
INSERT INTO competicion (nombre, monto_premio, fecha_inicio, fecha_fin) VALUES ('Copa del Rey', 1800000, '2024-10-01', '2025-04-26');

-- Relacion ManyToMany: Competicion <-> Club
INSERT INTO competicion_clubes (competicion_id, clubes_id) VALUES (1, 1);
INSERT INTO competicion_clubes (competicion_id, clubes_id) VALUES (1, 2);
INSERT INTO competicion_clubes (competicion_id, clubes_id) VALUES (1, 3);
INSERT INTO competicion_clubes (competicion_id, clubes_id) VALUES (2, 1);
INSERT INTO competicion_clubes (competicion_id, clubes_id) VALUES (2, 2);
INSERT INTO competicion_clubes (competicion_id, clubes_id) VALUES (3, 1);
INSERT INTO competicion_clubes (competicion_id, clubes_id) VALUES (3, 3);
