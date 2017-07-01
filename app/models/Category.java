package models;

import play.data.validation.Constraints;

import javax.persistence.Entity;

@Entity
public class Category extends BaseModel {

    public String itemId;

    @Constraints.Required
    public String name;

    public String price;
}

