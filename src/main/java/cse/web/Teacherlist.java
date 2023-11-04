package cse.web;

import com.mongodb.MongoClient;
import cse.web.dao.UserDao;
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
@WebServlet("/teacherlist")

public class Teacherlist extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Teacherlist() {
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

        List<User> teachers = userDao.getAllTeacher();

        request.setAttribute("teachers",teachers);

        RequestDispatcher view=request.getRequestDispatcher("components/admin/Teacherlist.jsp");
        view.forward(request,response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String id = request.getParameter("param"); // retrieve the value of the "param" parameter
        System.out.println("Parameter value: " + id);
        MongoClient mongo = (MongoClient) request.getServletContext()
                .getAttribute("MONGO_CLIENT");
        UserDao userDao = new UserDao(mongo);
        System.out.println(id);
        userDao.delete(id);
        String message = "Request processed successfully.";
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(message);
    }

}
