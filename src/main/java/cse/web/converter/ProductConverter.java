package cse.web.converter;

import cse.web.model.product;
import org.bson.Document;
import org.bson.types.ObjectId;

public class ProductConverter {
    public static Document toDocument(product p) {
        Document doc = new Document("name", p.getName()).append("password", p.getPassword());
        if (p.getId() != null) {
            doc.append("_id", new ObjectId(p.getId()));
        }
        return doc;
    }

    // convert MongoDB Document to Product
    // take special note of converting ObjectId to String
    public static product toProduct(Document doc) {
        product p = new product();
        p.setName((String) doc.get("name"));
        p.setPassword((String) doc.get("password"));
        p.setId(((ObjectId) doc.get("_id")).toString());
        return p;
    }
}
