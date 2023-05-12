create table customers(
    id bigint not null auto_increment,
    name varchar(200) not null,
    cpf varchar(20) not null unique,
    email varchar(200) not null unique,
    phone_number varchar (20) not null,
    activity_status varchar(5),

    primary key(id)
);