create table Categoria (
	categoriaid int primary key auto_increment,
	nombre varchar(100)
);

create table Producto (
	productoid int primary key auto_increment,
	nombre varchar(100),
	categoriaid int,
	precio decimal(7, 2),
	stock int,
	activo boolean default true,
	foreign key (categoriaid) references Categoria(categoriaid)
);

create table Cliente (
	clienteid int primary key auto_increment,
	nombre varchar(100),
	direccion varchar(200),
	email varchar(100),
	telefono varchar(15)
);

create table Venta (
	ventaid int primary key auto_increment,
	clienteid int,
	fecha datetime,
	foreign key (clienteid) references Cliente(clienteid)
);

create table DetalleVenta (
	ventaid int,
	productoid int,
	cantidad int,
	preciounitario decimal(7, 2),
	primary key (ventaid, productoid),
	foreign key (ventaid) references Venta(ventaid),
	foreign key (productoid) references Producto(productoid)
);

insert into Categoria (nombre) 
values ('Celulares'), 
       ('Accesorios'), 
       ('Tablets');

insert into Producto (nombre, categoriaid, precio, stock) 
values ('iPhone 14', 1, 999.99, 25), 
       ('Samsung Galaxy S23', 1, 849.99, 30), 
       ('Google Pixel 7', 1, 599.99, 20), 
       ('Funda para iPhone 14', 2, 19.99, 100), 
       ('Cargador inalámbrico', 2, 29.99, 75), 
       ('Auriculares Bluetooth', 2, 49.99, 50), 
       ('iPad Pro', 3, 1099.99, 15), 
       ('Samsung Galaxy Tab S8', 3, 799.99, 10);

insert into Cliente (nombre, direccion, email, telefono) 
values ('Carlos Mendoza', 'Calle Principal 456', 'carlos@example.com', '1234567890'), 
       ('Laura García', 'Avenida del Sol 789', 'laura@example.com', '0987654321');

insert into Venta (clienteid, fecha) 
values (1, '2024-10-01 10:30:00'), 
       (2, '2024-10-02 14:15:00');

insert into DetalleVenta (ventaid, productoid, cantidad, preciounitario) 
values (1, 1, 1, 999.99), 
       (1, 4, 2, 19.99), 
       (2, 2, 1, 849.99), 
       (2, 6, 1, 49.99);
