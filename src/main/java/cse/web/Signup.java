package cse.web;

import com.mongodb.MongoClient;
import cse.web.dao.UserDao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloJSP
 */
@WebServlet("/signup")

public class Signup extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signup() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        RequestDispatcher view=request.getRequestDispatcher("pages/Signup.jsp");
        view.forward(request,response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        cse.web.model.User user = new cse.web.model.User();
        user.setReg(request.getParameter("reg"));
        user.setName(request.getParameter("name"));
        user.setEmail(request.getParameter("email"));
        user.setPassword(request.getParameter("password"));
        user.setDept(request.getParameter("dept"));
        user.setRole(request.getParameter("role"));




        MongoClient mongo = (MongoClient) request.getServletContext()
                .getAttribute("MONGO_CLIENT");
        UserDao userDao = new UserDao(mongo);
        userDao.create(user);
        System.out.println("User Created Successfully...");

        String url = "/webproject/login";
        response.sendRedirect(url);
    }

}
