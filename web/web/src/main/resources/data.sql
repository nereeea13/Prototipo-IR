
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
     (7, 'Pasta Fusilli', 'pasta fusilli italiana Barilla', 1.35, '2026-08-10', 'DESPENSA', '/images/pasta fusilli.jpg'),
     (8, 'Leche entera', 'leche entera semipasteurizada 1L', 1.05, '2025-12-30', 'FRESCOS', null),
     (9, 'Huevos camperos', 'huevos camperos pack 12 unidades', 2.95, '2025-12-22', 'FRESCOS', null),
     (10, 'Agua mineral', 'agua mineral natural botella 1.5L', 0.75, '2027-05-10', 'BEBIDAS', null),
     (11, 'Papel higiénico', 'papel higiénico doble capa pack 12', 4.10, null, 'HOGAR', null),
     (12, 'Champú anticaspa', 'champú anticaspa marca DIA 400ml', 3.40, null, 'CUIDADO_PERSONAL', null),
     (13, 'Pollo entero', 'pollo fresco entero preparado', 6.80, '2025-12-14', 'FRESCOS', null),
     (14, 'Pizza congelada', 'pizza congelada jamón y queso', 2.95, '2026-03-01', 'CONGELADOS', null),
     (15, 'Helado de vainilla', 'helado de vainilla tarrina 1L', 3.20, '2026-06-20', 'CONGELADOS', null),
     (16, 'Cacao soluble', 'cacao soluble en polvo 500g', 3.50, '2027-02-10', 'DESPENSA', null),
     (17, 'Galletas María', 'galletas María clásicas pack 3', 1.20, '2027-01-10', 'DESPENSA', null),
     (18, 'Cerveza rubia', 'cerveza rubia lata 33cl', 0.85, '2026-10-10', 'BEBIDAS', null),
     (19, 'Detergente líquido', 'detergente ropa 50 lavados', 7.90, null, 'HOGAR', null),
     (20, 'Gel corporal', 'gel corporal hidratante aloe 750ml', 2.95, null, 'CUIDADO_PERSONAL', null);


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





