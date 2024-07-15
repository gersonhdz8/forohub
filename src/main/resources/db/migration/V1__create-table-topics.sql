create table topicos(
    
    id bigint not null auto_increment,
    titulo varchar(100) not null,
    mensaje varchar(100) not null,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estado boolean not null,    
    nombre_curso varchar(100) not null,

    primary key(id)

);