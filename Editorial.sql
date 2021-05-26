/*Creacion de la base de datos*/
CREATE DATABASE bd_editorial;

USE bd_editorial;

/*Crear tabla*/
CREATE TABLE tbl_autor(
	id_autor INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nombre_autor VARCHAR(35) NOT NULL,
	apellido_autor VARCHAR(35) NOT NULL,
	nacionalidad_autor VARCHAR(35) NOT NULL,
	edad_autor INT,
	id_libro_fk INT
);

CREATE TABLE tbl_libro(
	id_libro INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nombre_libro VARCHAR(35) NOT NULL,
	genero_libro VARCHAR(35) NOT NULL,
	paginas_libro INT, 
	idioma_libro VARCHAR(35)
);

/*Colocar llave forania*/
ALTER TABLE tbl_autor ADD FOREIGN KEY (id_libro_fk)
REFERENCES tbl_libro (id_libro);

/*Proceso almacenado*/
INSERT INTO tbl_libro (nombre_libro, genero_libro, paginas_libro, idioma_libro)
VALUES ('', '', , '');

INSERT INTO tbl_autor (nombre_autor, apellido_autor, nacionalidad_autor, edad_autor, id_libro_fk)
VALUES ('', '', '', , );


/*Vista tabla*/
SELECT * FROM tbl_autor;
SELECT * FROM tbl_libro;

/*INNER JOIN*/
SELECT * FROM tbl_autor A
INNER JOIN tbl_libro L
ON A.id_libro_fk = L.id_libro

/*LEFT JOIN*/
SELECT * FROM tbl_autor A
LEFT JOIN tbl_libro L
ON A.id_libro_fk = L.id_libro

/*RIGHT JOIN*/
SELECT * FROM tbl_autor A
RIGHT JOIN tbl_libro L
ON A.id_libro_fk = L.id_libro