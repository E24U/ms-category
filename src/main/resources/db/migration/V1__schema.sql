create table category
(
    id       int primary key,
    category varchar(55) not null unique,
    parent  varchar(55) not null
);
