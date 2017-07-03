package models;


import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Item extends Model {

    private static final long serialVersionUID = 1L;

    @Id
    public String itemId;

    @Constraints.Required
    public String name;

    public String price;

    public String category;

    public static Finder<String, Item> find
            = new Finder<>(Item.class);
}

