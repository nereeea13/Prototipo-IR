
INSERT INTO productos(id,nombre,descripcion,precio,fecha_caducidad, categoria) VALUES
     (1,'Manzana','manzana pink lady', 0.5,'2025-12-26', 'FRESCOS'),
     (2,'Croquetas de Jamón','croquetas de jamón marca DIA', 4.75,'2026-02-26', 'CONGELADOS'),
     (3,'Arroz bomba','arroz bomba marca La Fallera', 5.10,'2026-12-26', 'DESPENSA'),
     (4,'Zumo de piña','zumo de piña recién exprimido', 3.80,'2025-12-15', 'BEBIDAS'),
     (5,'Lejía','lejía blanca de baños', 3.10,null, 'HOGAR'),
     (6,'Jabón de manos','jabón de manos olor lavanda', 2.20,null, 'CUIDADO_PERSONAL');



INSERT INTO users(id,username,password,role) VALUES
    (1,'jefe','jefe','JEFE'),
    (2,'empleado1','empleado1','EMPLEADO'),
    (3,'empleado2','empleado2','EMPLEADO');


/*
INSERT INTO users(id,username,password,role) VALUES
    (1,'jefe','$2a$10$7QJf1o8e0G6H9c4cX9bZ1u5F8Kqz1Z1Z1Z1Z1Z1Z1Z1Z1Z1Z1Z1Z1Z','JEFE'),
    (2,'empleado1','$2a$10$EixZaYVK1fsbw1ZfbX3OXePaWxn96p36c6B8m7r9g6r9g6r9g6r9g6','EMPLEADO'),
    (3,'empleado2','$2a$10$EixZaYVK1fsbw1ZfbX3OXePaWxn96p36c6B8m7r9g6r9g6r9g6r9g6','EMPLEADO');
*/