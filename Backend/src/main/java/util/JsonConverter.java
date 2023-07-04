/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template


 */

package util;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;

/**
 *
 * @author suckm
 */
public class JsonConverter {
    private Gson gson = new Gson();
    private String jsonString = "";

    public JsonConverter(BufferedReader bf) {
        jsonString = toJsonString(bf);
    }
    
    private String toJsonString(BufferedReader bf){
        String jsonString = "";
        String line = null;
        try {
            while((line = bf.readLine()) != null){
                jsonString += line;
            }
        } catch (IOException ex) {
            Logger.getLogger(JsonConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jsonString.trim();
    }
    
    public Object convertJsonToObject(Object o){
        Object t = gson.fromJson(jsonString, o.getClass());
        System.out.println(o.getClass());
        return t;
    }
    
    public JsonObject getJsonObject(){
        JsonParser parser = new JsonParser();
        return parser.parse(jsonString).getAsJsonObject();
    }

    public String getJsonString() {
        return jsonString;
    }
    
    
    
}
