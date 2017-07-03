package models;


import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Item extends BaseModel {

    private static final long serialVersionUID = 1L;

//    public String itemId;

    @Constraints.Required
    public String name;

    public String price;

//    @ManyToOne
    public String category;

    public static Finder<Long, Item> find
            = new Finder<Long, Item>(Long.class, Item.class);
}

