package utils;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import play.libs.Json;

public class ResponseUtils {
    public static ObjectNode createResponse(
            ArrayNode response) {
        ObjectNode result = Json.newObject();
        result.put("success", response);

        return result;
    }
}