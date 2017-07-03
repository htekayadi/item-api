package controllers;

import com.avaje.ebean.Model;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
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
        ArrayNode arrayResponse = Json.newArray();

        for (JsonNode itemNode : json.withArray("items")) {
            Item item = Json.fromJson(itemNode, Item.class);

            if (item.toString().equals("")){
                return badRequest("Missing parameter");
            }
            item.itemId = UUID.randomUUID().toString();
            item.save();

            ObjectNode jsonResponse = Json.newObject();
            jsonResponse.put("itemId", item.itemId);
            jsonResponse.put("name", item.name);
            arrayResponse.add(jsonResponse);
        }

        ObjectNode response = Json.newObject();
        response.put("success", arrayResponse);
        return ok(response);
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
