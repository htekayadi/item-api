# Prerequisites
* Java 1.8
* Play 2.5
* Ebean
* MySQL

## Database Setup
$create database tapiver_dev;

## API Routes
POST localhost:9000/items
```
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
```

GET localhost:9000/items

GET localhost:9000/items/{itemId}

GET localhost:9000/searchitems?category=phone
