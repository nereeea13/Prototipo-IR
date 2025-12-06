
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



