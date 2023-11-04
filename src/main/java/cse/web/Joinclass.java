package cse.web;

import com.mongodb.MongoClient;
import cse.web.dao.EnrollDao;
import cse.web.dao.UserDao;
import cse.web.model.Enroll;

import java.io.IOException;

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
@WebServlet("/joinclass")

public class Joinclass extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Joinclass() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // TODO Auto-generated method stub
        RequestDispatcher view=request.getRequestDispatcher("components/user/Joinclass.jsp");
        view.forward(request,response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //doGet(request, response);

        HttpSession session = request.getSession(false);
        Enroll enroll = new Enroll();
        enroll.setCourseCode(request.getParameter("courseCode"));
        enroll.setStudentId((String) session.getAttribute("id"));
        MongoClient mongo = (MongoClient) request.getServletContext()
                .getAttribute("MONGO_CLIENT");
        EnrollDao enrollDao = new EnrollDao(mongo);
        enrollDao.create(enroll);
        System.out.println("Course Enrolled Successfully...");

        String url = "/webproject/dashboard";
        response.sendRedirect(url);


    }

}
