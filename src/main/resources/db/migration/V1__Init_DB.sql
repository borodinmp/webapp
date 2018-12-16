create sequence hibernate_sequence start 1 increment 1;

create table information (
  id int8 not null,
  name_org varchar(255) unique,
  inn varchar(64) unique,
  ogrn varchar(64) unique,
  address varchar(255),
  primary key (id)
);
