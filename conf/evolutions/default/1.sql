# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table item (
  item_id                   varchar(255) not null,
  name                      varchar(255),
  price                     varchar(255),
  category                  varchar(255),
  constraint pk_item primary key (item_id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table item;

SET FOREIGN_KEY_CHECKS=1;

