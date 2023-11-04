package cse.web;

import com.mongodb.MongoClient;
import cse.web.dao.UserDao;
import cse.web.dao.CourseDao;
import cse.web.model.User;
import cse.web.model.Course;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HelloJSP
 */
@WebServlet("/createcourse")

public class Createnewcourse extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Createnewcourse() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        HttpSession session = request.getSession(false);
        MongoClient mongo = (MongoClient) request.getServletContext()
                .getAttribute("MONGO_CLIENT");

        UserDao userDao = new UserDao(mongo);

        List<User> teacher = userDao.getAllTeacher();

        request.setAttribute("teacher",teacher);

        RequestDispatcher view=request.getRequestDispatcher("components/admin/Createnewcourse.jsp");
        view.forward(request,response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        Course course = new Course();
        course.setCourseCode(request.getParameter("courseCode"));
        course.setCourseName(request.getParameter("courseName"));
        course.setCourseTeacher(request.getParameter("courseTeacher"));
        MongoClient mongo = (MongoClient) request.getServletContext()
                .getAttribute("MONGO_CLIENT");
        CourseDao courseDao = new CourseDao(mongo);
        courseDao.create(course);
        System.out.println("Course Created Successfully...");

        String url = "/webproject/dashboard";
        response.sendRedirect(url);
    }

}
