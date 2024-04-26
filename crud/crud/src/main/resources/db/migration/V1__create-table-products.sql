CREATE TABLE product (
    id CHAR(36) primary key unique not null,
    name TEXT not null,
    price_in_cents FLOAT not null
);