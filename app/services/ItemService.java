package services;

import com.avaje.ebean.Model;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import models.Item;
import play.libs.Json;
import play.mvc.Http;
import utils.ResponseUtils;

import java.lang.reflect.Type;
import java.util.List;
import java.util.UUID;

public class ItemService {
    public static ObjectNode create(List<Item> items) {
        ArrayNode arrayResponse = Json.newArray();
        for (Item item : items) {
            ObjectNode jsonResponse = Json.newObject();
            item.itemId = UUID.randomUUID().toString();
            item.save();

            jsonResponse.put("itemId", item.itemId);
            jsonResponse.put("name", item.name);
            arrayResponse.add(jsonResponse);
        }

        return ResponseUtils.createResponse(arrayResponse);
    }

    public static List<Item> all() {
        return new Model.Finder(String.class, Item.class).all();
    }

    public static Item findById(String id) {
        return Item.find.byId(id);
    }

    public static List<Item> findByCategory(String category) {
        return Item.find.where()
                .like("category", "%"+category+"%")
                .findList();
    }
}
