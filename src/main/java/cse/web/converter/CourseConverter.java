package cse.web.converter;

import cse.web.model.Course;
import org.bson.Document;
import org.bson.types.ObjectId;

public class CourseConverter {


    public static Document toDocument(Course u) {
        Document doc = new Document("courseName", u.getCourseName());
        doc.append("courseCode", u.getCourseCode());
        doc.append("courseTeacher", u.getCourseTeacher());
        if (u.getId() != null) {
            doc.append("_id", new ObjectId(u.getId()));
        }
        return doc;
    }

    public static Course toCourse(Document doc, String teacherName) {
        Course u = new Course();
        u.setCourseName((String) doc.get("courseName"));
        u.setCourseCode((String) doc.get("courseCode"));
        u.setCourseTeacher(teacherName);
        u.setId(((ObjectId) doc.get("_id")).toString());
        return u;
    }

}
