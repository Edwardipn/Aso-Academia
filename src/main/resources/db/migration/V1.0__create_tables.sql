CREATE TABLE Situacion
(
    id                   VARCHAR(3) NOT NULL,
    descripcion          VARCHAR(30) NOT NULL,
    semaforo             VARCHAR(12) NULL,
    PRIMARY KEY (id)
);

CREATE TABLE Tipo_Usuario
(
    id                   VARCHAR(3) NOT NULL,
    descripcion          VARCHAR(30) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE Usuario
(
    correo               VARCHAR(100) NOT NULL,
    primer_nombre        VARCHAR(50) NOT NULL,
    segundo_nombre       VARCHAR(50) NULL,
    primer_apellido      VARCHAR(50) NOT NULL,
    segundo_apellido     VARCHAR(50) NULL,
    telefono             VARCHAR(15) NULL, -- Ajustado la longitud del teléfono
    celular              VARCHAR(15) NOT NULL, -- Ajustado la longitud del celular
    tipo_usuario         VARCHAR(3) NOT NULL,
    contrasena           VARCHAR(250) NOT NULL, -- Ajustado la longitud de la contraseña
    PRIMARY KEY (correo),
    FOREIGN KEY (tipo_usuario) REFERENCES Tipo_Usuario (id)
);

ALTER TABLE Usuario
CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE Domicilio
(
    usuario              VARCHAR(100) NOT NULL,
    calle                VARCHAR(200) NOT NULL,
    numero               VARCHAR(50) NOT NULL,
    colonia              VARCHAR(200) NOT NULL,
    codigo_postal        VARCHAR(5) NOT NULL,
    municipio            VARCHAR(200) NULL,
    estado               VARCHAR(50) NULL,
    PRIMARY KEY (usuario),
    FOREIGN KEY (usuario) REFERENCES Usuario (correo)
);

CREATE TABLE Forma_Pago
(
    id                   VARCHAR(3) NOT NULL,
    descripcion          VARCHAR(30) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE Pedido
(
    id                   INT AUTO_INCREMENT NOT NULL,
    fecha_pedido         DATETIME NOT NULL, -- Cambiado a DATETIME
    forma_pago           VARCHAR(3) NOT NULL,
    total                DECIMAL(10,2) NOT NULL,
    referencia           VARCHAR(50) NOT NULL,
    situacion            VARCHAR(3) NULL,
    usuario              VARCHAR(200) NULL,
    fecha_pago           DATETIME NULL, -- Cambiado a DATETIME
    PRIMARY KEY (id),
    FOREIGN KEY (usuario) REFERENCES Usuario (correo),
    FOREIGN KEY (forma_pago) REFERENCES Forma_Pago (id),
    FOREIGN KEY (situacion) REFERENCES Situacion (id)
);

CREATE TABLE Tipo_Articulo
(
    id                   VARCHAR(3) NOT NULL,
    descripcion          VARCHAR(30) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE Tamano
(
    id                   VARCHAR(3) NOT NULL,
    descripcion          VARCHAR(30) NOT NULL,
    tipo_articulo        VARCHAR(3) NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (tipo_articulo) REFERENCES Tipo_Articulo (id)
);

CREATE TABLE Articulo
(
    id                   VARCHAR(3) NOT NULL,
    ingredientes         VARCHAR(200) NULL,
    vigente              BOOLEAN NULL,
    nombre               VARCHAR(50) NOT NULL,
    tipo_articulo        VARCHAR(3) NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (tipo_articulo) REFERENCES Tipo_Articulo (id)
);

CREATE TABLE Detalle_Articulo
(
    id                   INT AUTO_INCREMENT NOT NULL,
    precio               DECIMAL(10,2) NOT NULL,
    tamano               VARCHAR(3) NULL,
    articulo             VARCHAR(3) NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (tamano) REFERENCES Tamano (id),
    FOREIGN KEY (articulo) REFERENCES Articulo (id)
);

CREATE TABLE Detalle_Pedido
(
    pedido               INT NOT NULL,
    detalle_articulo     INT NOT NULL,
    cantidad             INT NOT NULL,
    PRIMARY KEY (pedido, detalle_articulo),
    FOREIGN KEY (pedido) REFERENCES Pedido (id),
    FOREIGN KEY (detalle_articulo) REFERENCES Detalle_Articulo (id)
);
