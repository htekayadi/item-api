# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table category (
  id                            bigint auto_increment not null,
  item_id                       varchar(255),
  name                          varchar(255),
  price                         varchar(255),
  constraint pk_category primary key (id)
);

create table item (
  id                            bigint auto_increment not null,
  item_id                       varchar(255),
  name                          varchar(255),
  price                         varchar(255),
  constraint pk_item primary key (id)
);


# --- !Downs

drop table if exists category;

drop table if exists item;

