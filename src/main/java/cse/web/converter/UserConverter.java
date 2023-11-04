package cse.web.converter;

import cse.web.model.User;
import org.bson.Document;
import org.bson.types.ObjectId;

public class UserConverter {

    public static Document toDocument(User u) {
        Document doc = new Document("name", u.getName());
        doc.append("reg",u.getReg());
        doc.append("name",u.getName());
        doc.append("email",u.getEmail());
        doc.append("password", u.getPassword());
        doc.append("dept",u.getDept());
        doc.append("role",u.getRole());



        if (u.getId() != null) {
            doc.append("_id", new ObjectId(u.getId()));
        }
        return doc;
    }

    public static User toUser(Document doc) {
        User u = new User();
        u.setName((String) doc.get("name"));
        u.setReg((String) doc.get("reg"));
        u.setEmail((String) doc.get("email"));
        u.setPassword((String) doc.get("password"));
        u.setDept((String) doc.get(("dept")));
        u.setRole((String) doc.get("role"));


        u.setId(((ObjectId) doc.get("_id")).toString());
        return u;
    }

}
