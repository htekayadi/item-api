package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import models.Item;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import services.ItemService;

import java.util.List;

import static play.libs.Json.toJson;

public class ItemController extends Controller {

    public Result all(){
        List<Item> items = ItemService.all();
        return ok(toJson(items));
    }

    public Result get(String id){
        Item item = ItemService.findById(id);

        if (item == null){
            return notFound("Item not found!");
        }

        return ok(toJson(item));

    }
    
    @BodyParser.Of(BodyParser.Json.class)
    public Result create(){
        ObjectNode response = ItemService.create(request().body());
        return ok(response);
    }

    public Result find(String category){
        List<Item> items = ItemService.findByCategory(category);

        if (items == null){
            return notFound("Item not found!");
        }

        return ok(toJson(items));
    }
}
