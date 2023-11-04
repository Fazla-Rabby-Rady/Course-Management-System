package cse.web.dao;


import cse.web.model.Enroll;
import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;


import cse.web.converter.UserConverter;
import cse.web.model.User;

import java.util.ArrayList;
import java.util.List;


public class UserDao {

    private MongoCollection<Document> coll;

    public UserDao(MongoClient mongo) {
        this.coll = mongo.getDatabase("webproject").getCollection("user");
    }


    public User create(User p) {
        Document doc = UserConverter.toDocument(p);
        this.coll.insertOne(doc);
        ObjectId id = (ObjectId) doc.get("_id");
        p.setId(id.toString());
        return p;
    }

    public User checkCredentials(String email, String password) {
        Document doc = this.coll.find(
                Filters.and(
                        Filters.eq("email", email),
                        Filters.eq("password", password)
                )).first();
        if (doc == null)
            return null;
        else return UserConverter.toUser(doc);
    }

    public int getUserCount(String role) {
        return (int) coll.count(Filters.eq("role", role));
    }

    public List<User> getAllTeacher() {
        List<User> teacherList = new ArrayList<>();
        for (Document doc : coll.find(Filters.eq("role", "teacher"))) {
            teacherList.add(UserConverter.toUser(doc));
        }
        return teacherList;
    }
    public List<User> getAllStudent() {
        List<User> studentList = new ArrayList<>();
        for (Document doc : coll.find(Filters.eq("role", "student"))) {
            studentList.add(UserConverter.toUser(doc));
        }
        return studentList;
    }

    public List<User> getCourseWiseStudentDetails(List<Enroll> enrolls) {
        List<User> users = new ArrayList<>();

        for (Enroll enroll : enrolls) {
            String id = enroll.getStudentId();

            Document doc = coll.find(Filters.eq("_id", new ObjectId(id))).first();
            if (doc != null) {

                users.add(UserConverter.toUser(doc));
            }
        }
        return users;
    }

    public void delete(String id){
        this.coll.deleteOne(Filters.eq("_id", new ObjectId(id)));
    }
}
