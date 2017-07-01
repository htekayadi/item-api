package models;

import play.data.validation.Constraints;

import javax.persistence.Entity;

@Entity
public class Item extends BaseModel {

    private static final long serialVersionUID = 1L;

    public String itemId;

    @Constraints.Required
    public String name;

    public String price;
}

