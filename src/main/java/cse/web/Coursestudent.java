package cse.web;

import com.mongodb.MongoClient;
import cse.web.dao.EnrollDao;
import cse.web.dao.UserDao;
import cse.web.model.Enroll;
import cse.web.model.User;

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
@WebServlet("/coursestudent")

public class Coursestudent extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Coursestudent() {
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


        String courseCode = request.getParameter("courseCode");






        UserDao userDao = new UserDao(mongo);
        EnrollDao enrollDao = new EnrollDao(mongo);

        List<Enroll> enrolls = enrollDao.getCourseWiseEnrolledStudents(courseCode);

        List<User> users = userDao.getCourseWiseStudentDetails(enrolls);


        request.setAttribute("users",users);


        RequestDispatcher view=request.getRequestDispatcher("components/teacher/Coursestudent.jsp");
        view.forward(request,response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
