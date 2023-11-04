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
@WebServlet("/studentlist")

public class Studentlist extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Studentlist() {
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

        List<User> students = userDao.getAllStudent();

        request.setAttribute("students",students);


        RequestDispatcher view=request.getRequestDispatcher("components/admin/Studentlist.jsp");
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
