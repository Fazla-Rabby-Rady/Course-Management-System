package cse.web.converter;

import cse.web.model.Enroll;
import org.bson.Document;
import org.bson.types.ObjectId;

public class EnrollConverter {

    public static Document toDocument(Enroll u) {
        Document doc = new Document("courseId", u.getCourseCode());
        doc.append("studentId", new ObjectId(u.getStudentId()));
        if (u.getId() != null) {
            doc.append("_id", new ObjectId(u.getId()));
        }
        return doc;
    }

    public static Enroll toCourse(Document doc) {
        Enroll u = new Enroll();
        u.setId(((ObjectId) doc.get("_id")).toString());
        u.setCourseCode((doc.get("courseId")).toString());
        u.setStudentId(((ObjectId) doc.get("studentId")).toString());
        return u;
    }

}
