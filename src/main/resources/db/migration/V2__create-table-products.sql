create table products (
    id bigint not null auto_increment,
    name varchar(200) not null,
    category varchar(20) not null,
    unit_value numeric(8,2) not null,

    primary key(id)
);