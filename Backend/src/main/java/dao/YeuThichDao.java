/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import java.util.Arrays;
import model.Truyen;
import org.bson.Document;
import util.DatabaseHelper;

/**
 *
 * @author suckm
 */
public class YeuThichDao {

    MongoDatabase mongo = null;
    MongoCollection mc = null;

    public YeuThichDao() {
        DatabaseHelper dh = DatabaseHelper.getSingletonInstance();
        mongo = dh.getMongo();
        mc = mongo.getCollection("userfav");
    }
    
    public String getYeuThichById(String userName) {
        BasicDBObject field = new BasicDBObject();
        field.put("fav", 1);
        field.put("_id", 0);
        
        FindIterable<Document> res = mc.find(eq("name", userName))
                .projection(field);
        
        return res.first().toJson().toString();
    }
    
    public void addYeuThichById(String userName, Truyen t) {
        String idTruyen = "DRM5";
        String tenTruyen = "Doremon tap 5";
        String nxb = "Kim Dong";
        
        mc.updateOne(new Document("name", userName), new Document("$push",
                 new Document("fav", new Document("id", t.getId())
                        .append("ten", t.getTen())
                        .append("nxb", t.getNxb()))));
    }
    
    public void addNewDanhSachYeuThichById(String userName) {
        
        mc.insertOne(new Document("name", userName)
                .append("fav", Arrays.asList()));
    }
    
}
