package cse.web.dao;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import cse.web.converter.ProductConverter;
import cse.web.model.product;
import org.bson.Document;
import org.bson.types.ObjectId;

public class productDao {
    private MongoCollection<Document> coll;

    public productDao(MongoClient mongo) {
        this.coll = mongo.getDatabase("rady").getCollection("product");
    }

    public product create(product p) {
        Document doc = ProductConverter.toDocument(p);
        this.coll.insertOne(doc);
        ObjectId id = (ObjectId) doc.get("_id");
        p.setId(id.toString());
        return p;
    }

}
