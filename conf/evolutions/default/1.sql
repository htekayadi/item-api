# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table category (
  id                        bigint auto_increment not null,
  item_id                   varchar(255),
  name                      varchar(255),
  price                     varchar(255),
  constraint pk_category primary key (id))
;

create table item (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  price                     varchar(255),
  category                  varchar(255),
  constraint pk_item primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table category;

drop table item;

SET FOREIGN_KEY_CHECKS=1;

