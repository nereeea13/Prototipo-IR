
INSERT INTO users(id,username,password,role) VALUES
    (1,'jefe','jefe','JEFE'),
    (2,'empleado1','empleado1','EMPLEADO'),
    (3,'empleado2','empleado2','EMPLEADO');


INSERT INTO productos(id,nombre,descripcion,precio,fecha_caducidad, categoria, foto) VALUES
     (1,'Manzana','manzana pink lady', 0.5,'2025-12-26', 'FRESCOS', '/images/manzana.jpg'),
     (2,'Croquetas de Jamón','croquetas de jamón marca DIA', 4.75,'2026-02-26', 'CONGELADOS', '/images/croquetas de jamon.jpg'),
     (3,'Arroz bomba','arroz bomba marca La Fallera', 5.10,'2026-12-26', 'DESPENSA', '/images/arroz bomba.jpg'),
     (4,'Zumo de piña','zumo de piña recién exprimido', 3.80,'2025-12-15', 'BEBIDAS', '/images/zumo.jpg'),
     (5,'Lejía','lejía blanca de baños', 3.10,null, 'HOGAR', '/images/lejia.jpg'),
     (6,'Jabón de manos','jabón de manos olor lavanda', 2.20,null, 'CUIDADO_PERSONAL', '/images/jabon de manos.jpg'),
     (7, 'Pasta Fusilli', 'pasta fusilli italiana Barilla', 1.35, '2026-08-10', 'DESPENSA', '/images/pasta fusili.jpg'),
     (8, 'Leche entera', 'leche entera semipasteurizada 1L', 1.05, '2025-12-30', 'FRESCOS', '/images/leche.jpg'),
     (9, 'Huevos camperos', 'huevos camperos pack 12 unidades', 2.95, '2025-12-22', 'FRESCOS', '/images/huevos.jpg'),
     (10, 'Agua mineral', 'agua mineral natural botella 1.5L', 0.75, '2027-05-10', 'BEBIDAS', '/images/agua.jpg'),
     (11, 'Papel higiénico', 'papel higiénico doble capa pack 12', 4.10, null, 'HOGAR', '/images/papel higiénico.jpg'),
     (12, 'Champú anticaspa', 'champú anticaspa marca DIA 400ml', 3.40, null, 'CUIDADO_PERSONAL', '/images/champu anticaspa.jpg'),
     (13, 'Pollo entero', 'pollo fresco entero preparado', 6.80, '2025-12-14', 'FRESCOS', '/images/pollo entero.jpg'),
     (14, 'Pizza congelada', 'pizza congelada jamón y queso', 2.95, '2026-03-01', 'CONGELADOS', '/images/pizza.jpg'),
     (15, 'Helado de vainilla', 'helado de vainilla tarrina 1L', 3.20, '2026-06-20', 'CONGELADOS', '/images/helado de vainilla.jpg'),
     (16, 'Cacao soluble', 'cacao soluble en polvo 500g', 3.50, '2027-02-10', 'DESPENSA', '/images/cacao soluble.jpg'),
     (17, 'Galletas María', 'galletas María clásicas pack 3', 1.20, '2027-01-10', 'DESPENSA', '/images/galletas.jpg'),
     (18, 'Cerveza rubia', 'cerveza rubia lata 33cl', 0.85, '2026-10-10', 'BEBIDAS', '/images/cerveza rubia.jpg'),
     (19, 'Detergente líquido', 'detergente ropa marsella', 7.90, null, 'HOGAR', '/images/detergente liquido.jpg'),
     (20, 'Gel corporal', 'gel corporal leche de coco', 2.95, null, 'CUIDADO_PERSONAL', '/images/gel corporal.jpg');

INSERT INTO stock_producto(id, stock_total, stock_minimo, stock_almacen, stock_expuesto, producto_id) VALUES
    (1, 120, 20, 80, 40, 1),   -- Manzana
    (2, 60, 10, 40, 20, 2),    -- Croquetas congeladas
    (3, 200, 30, 180, 20, 3),  -- Arroz
    (4, 90, 15, 60, 30, 4),    -- Zumo de piña
    (5, 150, 20, 150, 0, 5),   -- Lejía
    (6, 110, 15, 100, 10, 6),  -- Jabón de manos

    (7, 180, 30, 160, 20, 7),  -- Pasta fusilli
    (8, 140, 20, 100, 40, 8),  -- Leche entera
    (9, 90, 15, 60, 30, 9),    -- Huevos
    (10, 220, 30, 200, 20, 10),-- Agua mineral
    (11, 130, 20, 130, 0, 11), -- Papel higiénico

    (12, 100, 15, 90, 10, 12), -- Champú anticaspa
    (13, 50, 10, 30, 20, 13),  -- Pollo entero
    (14, 70, 10, 50, 20, 14),  -- Pizza congelada
    (15, 85, 10, 70, 15, 15),  -- Helado vainilla
    (16, 180, 25, 160, 20, 16),-- Cacao soluble

    (17, 210, 30, 190, 20, 17),-- Galletas María
    (18, 300, 40, 260, 40, 18),-- Cerveza rubia
    (19, 90, 15, 90, 0, 19),   -- Detergente líquido
    (20, 120, 20, 110, 10, 20);-- Gel corporal


INSERT INTO empleados 
(id, nombre, apellidos, dni, telefono, email, salario,
 dias_vacaciones_verano_restantes, dias_vacaciones_invierno_restantes,
 rol, contrato_horas_semanales, tipo_contrato, preferencia_turno, estado, foto)
VALUES
(1, 'Laura', 'García Pérez', '12345678A', '600111222', 'laura.garcia@super.com', 1200, 6, 4, 'CAJERO', 40, 'JORNADA_COMPLETA', 'MANANA', 'ACTIVO', '/images/avatar empleado.jpg'),

(2, 'Carlos', 'Santos Ruiz', '23456789B', '600222333', 'carlos.santos@super.com', 1100, 5, 3, 'REPONEDOR', 30, 'PARCIAL', 'TARDE', 'ACTIVO', '/images/avatar empleado.jpg'),

(3, 'María', 'Lopez Díaz', '34567890C', '600333444', 'maria.lopez@super.com', 1500, 7, 5, 'JEFE_TIENDA', 40, 'JORNADA_COMPLETA', 'INDIFERENTE', 'ACTIVO', '/images/avatar empleado.jpg'),

(4, 'Javier', 'Torres Molina', '45678901D', '600444555', 'javier.torres@super.com', 1150, 4, 2, 'CAJERO', 20, 'PARCIAL', 'TARDE', 'ACTIVO', '/images/avatar empleado.jpg'),

(5, 'Andrea', 'Muñoz Vera', '56789012E', '600555666', 'andrea.munoz@super.com', 1250, 6, 3, 'REPONEDOR', 35, 'JORNADA_COMPLETA', 'MANANA', 'ACTIVO', '/images/avatar empleado.jpg'),

(6, 'Pablo', 'Martín López', '67890123F', '600666777', 'pablo.martin@super.com', 1000, 4, 3, 'PESCADERO', 25, 'PARCIAL', 'MANANA', 'ACTIVO', '/images/avatar empleado.jpg'),

(7, 'Sonia', 'Navarro Ruiz', '78901234G', '600777888', 'sonia.navarro@super.com', 1400, 7, 4, 'PANADERO', 40, 'JORNADA_COMPLETA', 'INDIFERENTE', 'ACTIVO', '/images/avatar empleado.jpg'),

(8, 'Miguel', 'Herrera Soto', '89012345H', '600888999', 'miguel.herrera@super.com', 1600, 9, 5, 'CARNICERO', 40, 'JORNADA_COMPLETA', 'TARDE', 'ACTIVO', '/images/avatar empleado.jpg'),

(9, 'Raquel', 'Dominguez Alba', '90123456I', '600999000', 'raquel.dominguez@super.com', 1300, 6, 3, 'CAJERO', 30, 'PARCIAL', 'MANANA', 'INACTIVO', '/images/avatar empleado.jpg'),

(10, 'David', 'Serrano Cruz', '01234567J', '611222333', 'david.serrano@super.com', 1450, 6, 4, 'REPONEDOR', 37, 'JORNADA_COMPLETA', 'TARDE', 'ACTIVO', '/images/avatar empleado.jpg');




INSERT INTO pedido_mercancia (id, fecha_creacion, fecha_llegada, estado) VALUES
-- EN PROCESO (3)
(7,  '2025-12-18', NULL, 'EN_PROCESO'),
(8,  '2025-12-19', NULL, 'EN_PROCESO'),
(9,  '2025-12-20', NULL, 'EN_PROCESO'),

-- EN PREPARACIÓN (2)
(10, '2025-12-15', NULL, 'EN_PREPARACION'),
(11, '2025-12-16', NULL, 'EN_PREPARACION'),

-- EN ENTREGA (2)
(12, '2025-12-12', NULL, 'EN_ENTREGA'),
(13, '2025-12-13', NULL, 'EN_ENTREGA'),

-- ENTREGADO (1)
(14, '2025-11-28', '2025-12-02', 'ENTREGADO');



INSERT INTO lineas_pedido
(id, pedido_id, producto_id, cantidad_solicitada, cantidad_recibida)
VALUES
(19, 7, 1, 60, 0),
(20, 7, 8, 40, 0),
(21, 7, 9, 30, 0);

INSERT INTO lineas_pedido
(id, pedido_id, producto_id, cantidad_solicitada, cantidad_recibida)
VALUES
(22, 8, 3, 100, 0),
(23, 8, 7, 80, 0),
(24, 8, 17, 70, 0);

INSERT INTO lineas_pedido
(id, pedido_id, producto_id, cantidad_solicitada, cantidad_recibida)
VALUES
(27, 10, 2, 50, 0),
(28, 10, 14, 40, 0),
(29, 10, 15, 30, 0);

INSERT INTO lineas_pedido
(id, pedido_id, producto_id, cantidad_solicitada, cantidad_recibida)
VALUES
(30, 11, 5, 70, 0),
(31, 11, 11, 60, 0);

INSERT INTO lineas_pedido
(id, pedido_id, producto_id, cantidad_solicitada, cantidad_recibida)
VALUES
(32, 12, 6, 80, 40),
(33, 12, 12, 50, 25);

INSERT INTO lineas_pedido
(id, pedido_id, producto_id, cantidad_solicitada, cantidad_recibida)
VALUES
(34, 13, 4, 90, 45),
(35, 13, 16, 60, 30);

INSERT INTO lineas_pedido
(id, pedido_id, producto_id, cantidad_solicitada, cantidad_recibida)
VALUES
(36, 14, 13, 40, 30),
(37, 14, 20, 50, 20);


-- Turnos: 6 turnos por cada empleado (empleado_id 1..10)
INSERT INTO turnos (id, tipo, hora_inicio, hora_fin, fecha, estado, empleado_id) VALUES
    (1, 'FIJO', '08:00:00', '12:00:00', '2025-12-01', 'ASIGNADO', 1),
    (2, 'PARTIDO', '14:00:00', '18:00:00', '2025-12-02', 'ASIGNADO', 1),
    (3, 'ROTATIVO', '09:00:00', '13:00:00', '2025-12-03', 'ASIGNADO', 1),
    (4, 'FIJO', '08:00:00', '12:00:00', '2025-12-04', 'ASIGNADO', 1),
    (5, 'PARTIDO', '14:00:00', '18:00:00', '2025-12-05', 'ASIGNADO', 1),
    (6, 'ROTATIVO', '09:00:00', '13:00:00', '2025-12-06', 'ASIGNADO', 1),

    (7, 'FIJO', '08:00:00', '12:00:00', '2025-12-01', 'ASIGNADO', 2),
    (8, 'PARTIDO', '14:00:00', '18:00:00', '2025-12-02', 'ASIGNADO', 2),
    (9, 'ROTATIVO', '09:00:00', '13:00:00', '2025-12-03', 'ASIGNADO', 2),
    (10, 'FIJO', '08:00:00', '12:00:00', '2025-12-04', 'ASIGNADO', 2),
    (11, 'PARTIDO', '14:00:00', '18:00:00', '2025-12-05', 'ASIGNADO', 2),
    (12, 'ROTATIVO', '09:00:00', '13:00:00', '2025-12-06', 'ASIGNADO', 2),

    (13, 'FIJO', '08:00:00', '12:00:00', '2025-12-01', 'ASIGNADO', 3),
    (14, 'PARTIDO', '14:00:00', '18:00:00', '2025-12-02', 'ASIGNADO', 3),
    (15, 'ROTATIVO', '09:00:00', '13:00:00', '2025-12-03', 'ASIGNADO', 3),
    (16, 'FIJO', '08:00:00', '12:00:00', '2025-12-04', 'ASIGNADO', 3),
    (17, 'PARTIDO', '14:00:00', '18:00:00', '2025-12-05', 'ASIGNADO', 3),
    (18, 'ROTATIVO', '09:00:00', '13:00:00', '2025-12-06', 'ASIGNADO', 3),

    (19, 'FIJO', '08:00:00', '12:00:00', '2025-12-01', 'ASIGNADO', 4),
    (20, 'PARTIDO', '14:00:00', '18:00:00', '2025-12-02', 'ASIGNADO', 4),
    (21, 'ROTATIVO', '09:00:00', '13:00:00', '2025-12-03', 'ASIGNADO', 4),
    (22, 'FIJO', '08:00:00', '12:00:00', '2025-12-04', 'ASIGNADO', 4),
    (23, 'PARTIDO', '14:00:00', '18:00:00', '2025-12-05', 'ASIGNADO', 4),
    (24, 'ROTATIVO', '09:00:00', '13:00:00', '2025-12-06', 'ASIGNADO', 4),

    (25, 'FIJO', '08:00:00', '12:00:00', '2025-12-01', 'ASIGNADO', 5),
    (26, 'PARTIDO', '14:00:00', '18:00:00', '2025-12-02', 'ASIGNADO', 5),
    (27, 'ROTATIVO', '09:00:00', '13:00:00', '2025-12-03', 'ASIGNADO', 5),
    (28, 'FIJO', '08:00:00', '12:00:00', '2025-12-04', 'ASIGNADO', 5),
    (29, 'PARTIDO', '14:00:00', '18:00:00', '2025-12-05', 'ASIGNADO', 5),
    (30, 'ROTATIVO', '09:00:00', '13:00:00', '2025-12-06', 'ASIGNADO', 5),

    (31, 'FIJO', '08:00:00', '12:00:00', '2025-12-01', 'ASIGNADO', 6),
    (32, 'PARTIDO', '14:00:00', '18:00:00', '2025-12-02', 'ASIGNADO', 6),
    (33, 'ROTATIVO', '09:00:00', '13:00:00', '2025-12-03', 'ASIGNADO', 6),
    (34, 'FIJO', '08:00:00', '12:00:00', '2025-12-04', 'ASIGNADO', 6),
    (35, 'PARTIDO', '14:00:00', '18:00:00', '2025-12-05', 'ASIGNADO', 6),
    (36, 'ROTATIVO', '09:00:00', '13:00:00', '2025-12-06', 'ASIGNADO', 6),

    (37, 'FIJO', '08:00:00', '12:00:00', '2025-12-01', 'ASIGNADO', 7),
    (38, 'PARTIDO', '14:00:00', '18:00:00', '2025-12-02', 'ASIGNADO', 7),
    (39, 'ROTATIVO', '09:00:00', '13:00:00', '2025-12-03', 'ASIGNADO', 7),
    (40, 'FIJO', '08:00:00', '12:00:00', '2025-12-04', 'ASIGNADO', 7),
    (41, 'PARTIDO', '14:00:00', '18:00:00', '2025-12-05', 'ASIGNADO', 7),
    (42, 'ROTATIVO', '09:00:00', '13:00:00', '2025-12-06', 'ASIGNADO', 7),

    (43, 'FIJO', '08:00:00', '12:00:00', '2025-12-01', 'ASIGNADO', 8),
    (44, 'PARTIDO', '14:00:00', '18:00:00', '2025-12-02', 'ASIGNADO', 8),
    (45, 'ROTATIVO', '09:00:00', '13:00:00', '2025-12-03', 'ASIGNADO', 8),
    (46, 'FIJO', '08:00:00', '12:00:00', '2025-12-04', 'ASIGNADO', 8),
    (47, 'PARTIDO', '14:00:00', '18:00:00', '2025-12-05', 'ASIGNADO', 8),
    (48, 'ROTATIVO', '09:00:00', '13:00:00', '2025-12-06', 'ASIGNADO', 8),

    (49, 'FIJO', '08:00:00', '12:00:00', '2025-12-01', 'ASIGNADO', 9),
    (50, 'PARTIDO', '14:00:00', '18:00:00', '2025-12-02', 'ASIGNADO', 9),
    (51, 'ROTATIVO', '09:00:00', '13:00:00', '2025-12-03', 'ASIGNADO', 9),
    (52, 'FIJO', '08:00:00', '12:00:00', '2025-12-04', 'ASIGNADO', 9),
    (53, 'PARTIDO', '14:00:00', '18:00:00', '2025-12-05', 'ASIGNADO', 9),
    (54, 'ROTATIVO', '09:00:00', '13:00:00', '2025-12-06', 'ASIGNADO', 9),

    (55, 'FIJO', '08:00:00', '12:00:00', '2025-12-01', 'ASIGNADO', 10),
    (56, 'PARTIDO', '14:00:00', '18:00:00', '2025-12-02', 'ASIGNADO', 10),
    (57, 'ROTATIVO', '09:00:00', '13:00:00', '2025-12-03', 'ASIGNADO', 10),
    (58, 'FIJO', '08:00:00', '12:00:00', '2025-12-04', 'ASIGNADO', 10),
    (59, 'PARTIDO', '14:00:00', '18:00:00', '2025-12-05', 'ASIGNADO', 10),
    (60, 'ROTATIVO', '09:00:00', '13:00:00', '2025-12-06', 'ASIGNADO', 10);


-- Horarios: 2 horarios (vigente = false)
INSERT INTO horarios (id, fecha_inicio, vigente) VALUES
    (1, '2026-01-01', false),
    (2, '2026-02-01', false);

-- Turnos asociados a Horario 1 (id 1): 3 turnos por empleado (empleado_id 1..10)
INSERT INTO turnos (id, tipo, hora_inicio, hora_fin, fecha, estado, empleado_id, horario_id) VALUES
    (61, 'FIJO', '08:00:00', '12:00:00', '2026-01-01', 'PENDIENTE', 1, 1),
    (62, 'PARTIDO', '14:00:00', '18:00:00', '2026-01-01', 'PENDIENTE', 1, 1),
    (63, 'ROTATIVO', '09:00:00', '13:00:00', '2026-01-01', 'PENDIENTE', 1, 1),

    (64, 'FIJO', '08:00:00', '12:00:00', '2026-01-01', 'PENDIENTE', 2, 1),
    (65, 'PARTIDO', '14:00:00', '18:00:00', '2026-01-01', 'PENDIENTE', 2, 1),
    (66, 'ROTATIVO', '09:00:00', '13:00:00', '2026-01-01', 'PENDIENTE', 2, 1),

    (67, 'FIJO', '08:00:00', '12:00:00', '2026-01-01', 'PENDIENTE', 3, 1),
    (68, 'PARTIDO', '14:00:00', '18:00:00', '2026-01-01', 'PENDIENTE', 3, 1),
    (69, 'ROTATIVO', '09:00:00', '13:00:00', '2026-01-01', 'PENDIENTE', 3, 1),

    (70, 'FIJO', '08:00:00', '12:00:00', '2026-01-01', 'PENDIENTE', 4, 1),
    (71, 'PARTIDO', '14:00:00', '18:00:00', '2026-01-01', 'PENDIENTE', 4, 1),
    (72, 'ROTATIVO', '09:00:00', '13:00:00', '2026-01-01', 'PENDIENTE', 4, 1),

    (73, 'FIJO', '08:00:00', '12:00:00', '2026-01-01', 'PENDIENTE', 5, 1),
    (74, 'PARTIDO', '14:00:00', '18:00:00', '2026-01-01', 'PENDIENTE', 5, 1),
    (75, 'ROTATIVO', '09:00:00', '13:00:00', '2026-01-01', 'PENDIENTE', 5, 1),

    (76, 'FIJO', '08:00:00', '12:00:00', '2026-01-01', 'PENDIENTE', 6, 1),
    (77, 'PARTIDO', '14:00:00', '18:00:00', '2026-01-01', 'PENDIENTE', 6, 1),
    (78, 'ROTATIVO', '09:00:00', '13:00:00', '2026-01-01', 'PENDIENTE', 6, 1),

    (79, 'FIJO', '08:00:00', '12:00:00', '2026-01-01', 'PENDIENTE', 7, 1),
    (80, 'PARTIDO', '14:00:00', '18:00:00', '2026-01-01', 'PENDIENTE', 7, 1),
    (81, 'ROTATIVO', '09:00:00', '13:00:00', '2026-01-01', 'PENDIENTE', 7, 1),

    (82, 'FIJO', '08:00:00', '12:00:00', '2026-01-01', 'PENDIENTE', 8, 1),
    (83, 'PARTIDO', '14:00:00', '18:00:00', '2026-01-01', 'PENDIENTE', 8, 1),
    (84, 'ROTATIVO', '09:00:00', '13:00:00', '2026-01-01', 'PENDIENTE', 8, 1),

    (85, 'FIJO', '08:00:00', '12:00:00', '2026-01-01', 'PENDIENTE', 9, 1),
    (86, 'PARTIDO', '14:00:00', '18:00:00', '2026-01-01', 'PENDIENTE', 9, 1),
    (87, 'ROTATIVO', '09:00:00', '13:00:00', '2026-01-01', 'PENDIENTE', 9, 1),

    (88, 'FIJO', '08:00:00', '12:00:00', '2026-01-01', 'PENDIENTE', 10, 1),
    (89, 'PARTIDO', '14:00:00', '18:00:00', '2026-01-01', 'PENDIENTE', 10, 1),
    (90, 'ROTATIVO', '09:00:00', '13:00:00', '2026-01-01', 'PENDIENTE', 10, 1);

-- Turnos asociados a Horario 2 (id 2): 3 turnos por empleado (empleado_id 1..10)
INSERT INTO turnos (id, tipo, hora_inicio, hora_fin, fecha, estado, empleado_id, horario_id) VALUES
    (91, 'FIJO', '08:00:00', '12:00:00', '2026-02-01', 'PENDIENTE', 1, 2),
    (92, 'PARTIDO', '14:00:00', '18:00:00', '2026-02-01', 'PENDIENTE', 1, 2),
    (93, 'ROTATIVO', '09:00:00', '13:00:00', '2026-02-01', 'PENDIENTE', 1, 2),

    (94, 'FIJO', '08:00:00', '12:00:00', '2026-02-01', 'PENDIENTE', 2, 2),
    (95, 'PARTIDO', '14:00:00', '18:00:00', '2026-02-01', 'PENDIENTE', 2, 2),
    (96, 'ROTATIVO', '09:00:00', '13:00:00', '2026-02-01', 'PENDIENTE', 2, 2),

    (97, 'FIJO', '08:00:00', '12:00:00', '2026-02-01', 'PENDIENTE', 3, 2),
    (98, 'PARTIDO', '14:00:00', '18:00:00', '2026-02-01', 'PENDIENTE', 3, 2),
    (99, 'ROTATIVO', '09:00:00', '13:00:00', '2026-02-01', 'PENDIENTE', 3, 2),

    (100, 'FIJO', '08:00:00', '12:00:00', '2026-02-01', 'PENDIENTE', 4, 2),
    (101, 'PARTIDO', '14:00:00', '18:00:00', '2026-02-01', 'PENDIENTE', 4, 2),
    (102, 'ROTATIVO', '09:00:00', '13:00:00', '2026-02-01', 'PENDIENTE', 4, 2),

    (103, 'FIJO', '08:00:00', '12:00:00', '2026-02-01', 'PENDIENTE', 5, 2),
    (104, 'PARTIDO', '14:00:00', '18:00:00', '2026-02-01', 'PENDIENTE', 5, 2),
    (105, 'ROTATIVO', '09:00:00', '13:00:00', '2026-02-01', 'PENDIENTE', 5, 2),

    (106, 'FIJO', '08:00:00', '12:00:00', '2026-02-01', 'PENDIENTE', 6, 2),
    (107, 'PARTIDO', '14:00:00', '18:00:00', '2026-02-01', 'PENDIENTE', 6, 2),
    (108, 'ROTATIVO', '09:00:00', '13:00:00', '2026-02-01', 'PENDIENTE', 6, 2),

    (109, 'FIJO', '08:00:00', '12:00:00', '2026-02-01', 'PENDIENTE', 7, 2),
    (110, 'PARTIDO', '14:00:00', '18:00:00', '2026-02-01', 'PENDIENTE', 7, 2),
    (111, 'ROTATIVO', '09:00:00', '13:00:00', '2026-02-01', 'PENDIENTE', 7, 2),

    (112, 'FIJO', '08:00:00', '12:00:00', '2026-02-01', 'PENDIENTE', 8, 2),
    (113, 'PARTIDO', '14:00:00', '18:00:00', '2026-02-01', 'PENDIENTE', 8, 2),
    (114, 'ROTATIVO', '09:00:00', '13:00:00', '2026-02-01', 'PENDIENTE', 8, 2),

    (115, 'FIJO', '08:00:00', '12:00:00', '2026-02-01', 'PENDIENTE', 9, 2),
    (116, 'PARTIDO', '14:00:00', '18:00:00', '2026-02-01', 'PENDIENTE', 9, 2),
    (117, 'ROTATIVO', '09:00:00', '13:00:00', '2026-02-01', 'PENDIENTE', 9, 2),

    (118, 'FIJO', '08:00:00', '12:00:00', '2026-02-01', 'PENDIENTE', 10, 2),
    (119, 'PARTIDO', '14:00:00', '18:00:00', '2026-02-01', 'PENDIENTE', 10, 2),
    (120, 'ROTATIVO', '09:00:00', '13:00:00', '2026-02-01', 'PENDIENTE', 10, 2);
