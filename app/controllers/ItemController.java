package controllers;

import com.avaje.ebean.Model;
import com.fasterxml.jackson.databind.JsonNode;
import models.Item;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;
import java.util.UUID;

import static play.libs.Json.toJson;

public class ItemController extends Controller {

    public Result all(){

        List<Item> items = new Model.Finder(String.class, Item.class).all();

        return ok(toJson(items));
    }

    public Result get(String id){

        Item item = Item.find.byId(id);

        if (item == null){
            return notFound("Item not found!");
        }

        return ok(toJson(item));

    }
    
    @BodyParser.Of(BodyParser.Json.class)
    public Result create(){
        JsonNode json = request().body().asJson();

        for (JsonNode itemNode : json.withArray("items")) {
            Item item = Json.fromJson(itemNode, Item.class);

            if (item.toString().equals("")){
                return badRequest("Missing parameter");
            }
            item.itemId = UUID.randomUUID().toString();
            item.save();
        }

        return ok(Json.newObject());
    }

    public Result find(String category){
        List<Item> items = Item.find.where()
                .like("category", "%"+category+"%")
                .findList();

        if (items == null){
            return notFound("Item not found!");
        }

        return ok(toJson(items));
    }
}
