package cse.web.dao;

import cse.web.model.Enroll;
import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;


import cse.web.converter.CourseConverter;
import cse.web.model.Course;

import java.util.ArrayList;
import java.util.List;


public class CourseDao {

    private MongoCollection<Document> coll,user;

    public CourseDao(MongoClient mongo) {
        this.coll = mongo.getDatabase("webproject").getCollection("course");
        this.user = mongo.getDatabase("webproject").getCollection("user");
    }

    public Course create(Course p) {
        Document doc = CourseConverter.toDocument(p);
        this.coll.insertOne(doc);
        ObjectId id = (ObjectId) doc.get("_id");
        p.setId(id.toString());
        return p;
    }

    public int getCourseCount() {
        return (int) coll.count();
    }

    public List<Course> getAllCourse() {
        List<Course> courseList = new ArrayList<>();
        FindIterable<Document> iterable = coll.find();
        for (Document doc : iterable) {
            String teacherName = getTeacherNameByID(doc.get("courseTeacher").toString());

            courseList.add(CourseConverter.toCourse(doc,teacherName));
        }
        return courseList;
    }

    private String getTeacherNameByID(String id) {
        Document doc = user.find(Filters.eq("_id", new ObjectId(id))).first();

        if (doc == null) {
            return "Unknown";
        }
        return doc.getString("name");
    }

    public List<Course> getEnrolledCourses(List<Enroll> enrolls) {
        List<Course> courses = new ArrayList<>();

        for (Enroll enroll : enrolls) {
            String id = enroll.getCourseCode();
            Document doc = coll.find(Filters.eq("courseCode", id)).first();
            if (doc != null) {
                String teacherName = getTeacherNameByID(doc.get("courseTeacher").toString());
                courses.add(CourseConverter.toCourse(doc, teacherName));
            }
        }
        return courses;
    }

    public List<Course> getAssignedCourses(String id){
        List<Course> courses = new ArrayList<>();
        FindIterable<Document> iterable = coll.find(Filters.eq("courseTeacher", id));

        for (Document doc : iterable) {
            String teacherName = getTeacherNameByID(doc.get("courseTeacher").toString());

            courses.add(CourseConverter.toCourse(doc,teacherName));
        }

        return courses;
    }

//    public List<Course> getAllCourseCode (){
//
//        List<Course> list = new ArrayList<>();
//
//        for(Document doc : coll.find()) {
//            String teacherName = getTeacherNameByID(doc.get("courseTeacher").toString());
//            list.add(CourseConverter.toCourse(doc,teacherName));
//        }
//
//        return list;
//    }
//

}
