package cse.web.dao;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import cse.web.converter.EnrollConverter;
import cse.web.model.Enroll;
import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;

import java.util.ArrayList;
import java.util.List;

public class EnrollDao {

    private MongoCollection<Document> coll, user;

    public EnrollDao(MongoClient mongo) {
        this.coll = mongo.getDatabase("webproject").getCollection("enroll");
    }

    public Enroll create(Enroll p) {
        Document doc = EnrollConverter.toDocument(p);
        this.coll.insertOne(doc);
        ObjectId id = (ObjectId) doc.get("_id");
        p.setId(id.toString());
        return p;
    }

    public List<Enroll> getEnrolledCourseCode(String studentId) {
//    	System.out.println("From EnrollDao "+ studentId);
        FindIterable<Document> iterable = coll.find(Filters.eq("studentId", new ObjectId(studentId)));
        List<Enroll> list = new ArrayList<>();
        for (Document doc : iterable) {
            list.add(EnrollConverter.toCourse(doc));
        }
        return list;
    }

    public List<Enroll> getCourseWiseEnrolledStudents(String code){

        List<Enroll> list = new ArrayList<>();
        FindIterable<Document> iterable = coll.find(Filters.eq("courseId", code));

        for (Document doc : iterable) {
            list.add(EnrollConverter.toCourse(doc));
        }


        return list;

    }
}
