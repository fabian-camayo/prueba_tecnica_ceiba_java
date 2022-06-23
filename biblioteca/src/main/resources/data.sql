/**
 * Author:  Fabian Camayo
 * Created: 22/05/2022
 */
insert into libros (id,isbn,nombre,descripcion)values(1,'ASDA7884','LIBRO 1','Lorem Ipsum is simply dummy text of the printing and typesetting industry.');
insert into libros (id,isbn,nombre,descripcion)values(2,'AWQ489','LIBRO 2','Lorem Ipsum is simply dummy text of the printing and typesetting industry.');
insert into libros (id,isbn,nombre,descripcion)values(3,'EQWQW8545','LIBRO 3','Lorem Ipsum is simply dummy text of the printing and typesetting industry.');

insert into tipo_usuarios (id,nombre,rol)values(1, 'USUARIO_AFILIADO','AFILIADO');
insert into tipo_usuarios (id,nombre,rol)values(2, 'USUARIO_EMPLEADO','EMPLEADO');
insert into tipo_usuarios (id,nombre,rol)values(3, 'USUARIO_INVITADO','INVITADO');
insert into tipo_usuarios (id,nombre,rol)values(5, 'USUARIO_DESCONOCIDO','DESCONOCIDO');

insert into usuarios (id,tipo_usuario,identificacion,nombre)values(1, 1,'974148','USUARIO 1');
insert into usuarios (id,tipo_usuario,identificacion,nombre)values(2, 2,'7481545','USUARIO 2');
insert into usuarios (id,tipo_usuario,identificacion,nombre)values(3, 3,'74851254','USUARIO 3');
insert into usuarios (id,tipo_usuario,identificacion,nombre)values(4, 3,'1111111111','USUARIO 4');
insert into usuarios (id,tipo_usuario,identificacion,nombre)values(5, 1,'1111111111','USUARIO 5');
insert into usuarios (id,tipo_usuario,identificacion,nombre)values(6, 5,'1111111111','USUARIO 6');