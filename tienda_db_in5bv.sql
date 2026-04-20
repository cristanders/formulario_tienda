drop database if exists tienda_db_in5bv;
create database tienda_db_in5bv;
use tienda_db_in5bv;
 
create table usuario(
	id_usuario int auto_increment not null primary key,
    nombre_usuario varchar(60) not null,
    apellido_usuario varchar(60) not null,
    edad_usuario int not null
);
 
create table categoria(
	id_categoria int auto_increment not null primary key,
    nombre_categoria varchar(60) not null,
    descripcion_categoria varchar(150)
);
 
create table producto(
	id_producto int auto_increment not null primary key,
    nombre_producto varchar(80) not null,
    precio_producto decimal(10,2) not null,
    stock int not null,
    id_categoria int not null,
    constraint fk_producto_categoria
        foreign key (id_categoria)
        references categoria(id_categoria)
);
 
create table pedido(
	id_pedido int auto_increment not null primary key,
    fecha_pedido varchar(60) not null,
    total_pedido decimal(10,2) not null,
    id_usuario int not null,
    constraint fk_pedido_usuario
        foreign key (id_usuario)
        references usuario(id_usuario)
);
 
create table detalle_pedido(
	id_detalle int auto_increment not null primary key,
    cantidad int not null,
    precio_unitario decimal(10,2) not null,
    id_pedido int not null,
    id_producto int not null,
    constraint fk_detalle_pedido
        foreign key (id_pedido)
        references pedido(id_pedido),
    constraint fk_detalle_producto
        foreign key (id_producto)
        references producto(id_producto)
);
 
 INSERT INTO categoria (nombre_categoria) VALUES ('Dulces');
 INSERT INTO categoria (nombre_categoria) VALUES ('Herramientas');
  INSERT INTO categoria (nombre_categoria) VALUES ('armas');
select * from usuario;