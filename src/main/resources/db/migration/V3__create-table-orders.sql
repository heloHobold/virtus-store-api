create table orders (
    id bigint not null auto_increment,
    value_order numeric(8,2) not null,
    date_order date,

    primary key(id)
);