
INSERT INTO situacion (id, descripcion) VALUES
                                            ('REG', 'REGISTRADO'),
                                            ('PAG', 'PAGADO'),
                                            ('ASI', 'ASIGNADO'),
                                            ('COC', 'COCINANDO'),
                                            ('REP', 'REPARTIR'),
                                            ('ENT', 'ENTREGADO');

INSERT INTO tipo_usuario (id, descripcion) VALUES
                                               ('CLI', 'Cliente'),
                                               ('ADM', 'Administrador'),
                                               ('REP', 'Repartidor'),
                                               ('PIZ', 'Pizzero');


INSERT INTO forma_pago (id, descripcion) VALUES
                                             ('TDC', 'Tarjeta de Credito'),
                                             ('TDE', 'Tarjeta de Debito'),
                                             ('PAY', 'Paypal'),
                                             ('MPA', 'Mercado Pago'),
                                             ('CUP', 'Cupon');


INSERT INTO tipo_articulo (id, descripcion) VALUES
                                                ('PIZ', 'PIZZA'),
                                                ('BEB', 'BEBIDA'),
                                                ('POS', 'POSTRE'),
                                                ('COM', 'COMPLEMENTO');


INSERT INTO tamano (id, descripcion, tipo_articulo) VALUES
                                                        ('CHI', 'CHICA', 'PIZ'),
                                                        ('MED', 'MEDIANA', 'PIZ'),
                                                        ('GRA', 'GRANDE', 'PIZ'),
                                                        ('FAM', 'FAMILIAR', 'PIZ'),
                                                        ('JUM', 'JUMBO', 'PIZ'),
                                                        ('600', '600ml', 'BEB'),
                                                        ('1LT', '1 Litro', 'BEB');


INSERT INTO usuario
(primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, correo, telefono, celular, tipo_usuario, contrasena)
VALUES
    ('Oscar', '', 'Salas', 'Gutierrez', 'ospegu_10@hotmail.com', '4499174062', '4499113310', 'CLI', MD5('osalas')),
    ('Luis', 'Enrique', 'Wong', 'Martinez', 'erawong@hotmail.com', '', '4498781249', 'PIZ', MD5('ewong')),
    ('Ana', 'Paula', 'Garcia', 'Rangel', 'anaP_med@gmail.com', '', '4496138201', 'PIZ', MD5('agarcia')),
    ('Alfonso', '', 'Padilla', 'Alonso', 'padillaAlonso@gmail.com', '4491232246', '4497237643', 'REP', MD5('apadilla')),
    ('Carlos', 'Daniel', 'Camacho', 'Munoz', 'danmartiles@gmail.com', '4499764931', '4498973778', 'CLI', MD5('root')),
    ('Jose', 'Angel', 'Camacho', 'Munoz', 'joseangelcamachomunoz@hotmail.com', '4491234567', '4498765321', 'PIZ', MD5('angel')),
    ('Gabriel', 'Emmanuel', 'Camacho', 'Munoz', 'garbiel_77_@hotmail.com', '4492345689', '4499765432', 'PIZ', MD5('emmanuel')),
    ('Yulissa', 'Marisol', 'Soto', 'Reyes', 'yulissa_77@hotmail.com', '4491036896', '4493478956', 'REP', MD5('yulissa')),
    ('Maribel', '', 'Guerrero', 'Contreras', 'maribelguerrero150@gmail.com', '4968517372', '4961168993', 'ADM', MD5('maribel')),
    ('Alan', 'Rogelio', 'Bejar', 'Cruz', 'alannc@hotmail.com', '', '4651188889', 'PIZ', MD5('alann')),
    ('Jaun', 'Jose', 'Rodriguez', 'Lara', 'juanlara@gmail.com', '', '4961273711', 'PIZ', MD5('juan')),
    ('Jaime', '', 'Zamora', 'Lira', 'jaimeza@gmail.com', '4967890123', '4964567890', 'CLI', MD5('jaime'));


INSERT INTO articulo (id, ingredientes, vigente, nombre, tipo_articulo) VALUES
                                                                            ('HAW', 'Queso, piña, jamon', true, 'Hawaiana', 'PIZ'),
                                                                            ('PEP', 'Queso, pepperoni', true, 'Pepperoni', 'PIZ'),
                                                                            ('QUE', 'Queso', true, 'Queso', 'PIZ'),
                                                                            ('MEX', 'Queso, pimiento, carne molida, chile serrano, salchicha', false, 'Mexicana', 'PIZ'),
                                                                            ('BE1', 'NA', true, 'Coca-Cola', 'BEB'),
                                                                            ('BE2', 'NA', true, 'Sprite', 'BEB');


INSERT INTO detalle_articulo (precio, tamano, articulo) VALUES
                                                            (100, 'CHI', 'HAW'),
                                                            (110.50, 'MED', 'HAW'),
                                                            (150, 'GRA', 'HAW'),
                                                            (180.50, 'FAM', 'HAW'),
                                                            (230, 'JUM', 'HAW'),
                                                            (90, 'CHI', 'PEP'),
                                                            (105, 'MED', 'PEP'),
                                                            (140.50, 'GRA', 'PEP'),
                                                            (167.50, 'FAM', 'PEP'),
                                                            (210, 'JUM', 'PEP'),
                                                            (50, 'CHI', 'QUE'),
                                                            (80, 'MED', 'QUE'),
                                                            (110, 'GRA', 'QUE'),
                                                            (126.50, 'FAM', 'QUE'),
                                                            (140, 'JUM', 'QUE'),
                                                            (111, 'CHI', 'MEX'),
                                                            (136, 'MED', 'MEX'),
                                                            (166.50, 'GRA', 'MEX'),
                                                            (199.50, 'FAM', 'MEX'),
                                                            (260, 'JUM', 'MEX'),
                                                            (20, '600', 'BE1'),
                                                            (50, '1LT', 'BE1'),
                                                            (20, '600', 'BE2'),
                                                            (50, '1LT', 'BE2');


INSERT INTO pedido (fecha_pedido, forma_pago, total, referencia, situacion, usuario, fecha_pago) VALUES
                                                                                                     ('2021-07-05', 'TDE', 260, '16562133', 'ENT', 'ospegu_10@hotmail.com', '2021-07-05'),
                                                                                                     ('2021-07-06', 'TDC', 50, '12341324', 'ASI', 'padillaAlonso@gmail.com', '2021-07-06'),
                                                                                                     ('2021-07-05', 'TDC', 50, '12356789', 'ENT', 'danmartiles@gmail.com', '2021-07-05'),
                                                                                                     ('2021-07-06', 'CUP', 100, '16578945', 'REP', 'yulissa_77@hotmail.com', '2021-07-06'),
                                                                                                     ('2021-07-06', 'PAY', 126.50, '0123456', 'COC', 'danmartiles@gmail.com', '2021-07-06'),
                                                                                                     ('2021-07-05', 'TDC', 150, '16578945', 'ENT', 'ospegu_10@hotmail.com', '2021-07-05');


INSERT INTO detalle_pedido (pedido, detalle_articulo,cantidad) VALUES
                                                                   (1, 20,1),
                                                                   (1,19,3),
                                                                   (2, 11,1),
                                                                   (3, 11,1),
                                                                   (4, 1,1),
                                                                   (5, 14,1),
                                                                   (6, 3,1);


INSERT INTO Domicilio (calle, numero, colonia, codigo_postal, municipio, estado, usuario) VALUES
                                                                                         ('Juan Sanchez', '301', 'Loma los negritos', '20310', 'AGUSCALIENTES', 'AGUSCALIENTES', 'danmartiles@gmail.com'),
                                                                                         ('J. G. Icazbalceta', '16', 'Benito Juarez', '20310', 'AGUSCALIENTES', 'AGUSCALIENTES', 'jaimeza@gmail.com'),
                                                                                         ('San Rafael', '210', 'San Cayetano', '20210', 'AGUSCALIENTES', 'AGUSCALIENTES', 'ospegu_10@hotmail.com');