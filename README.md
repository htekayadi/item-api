# Prerequisites

Java 1.8
Play Framework 2.5.x
Ebean
MySQL

## Database Setup
$create database tapiver_dev;

## Database Setup
$create database tapiver_dev;

bc. POST localhost:9000/items
{
  "items" : [
    {
      "name" : "Iphone 7+ 32gb",
      "category" : "phone",
      "price"  : "$900"
    },
    {
       "name" : "Iphone 7+ 64gb",
       "category" : "phone",
       "price"  : "$1000"
    },
    {
       "name" : "Teh Botol",
       "category" : "drink",
       "price"  : "$1"
    }
  ]
}

bc. GET localhost:9000/items

bc. GET localhost:9000/items/{itemId}

bc. GET localhost:9000/searchitems?category=phone
