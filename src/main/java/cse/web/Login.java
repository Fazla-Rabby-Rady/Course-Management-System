package cse.web;

import com.mongodb.MongoClient;
import cse.web.dao.UserDao;
import cse.web.model.User;

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
@WebServlet("/login")

public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        RequestDispatcher view=request.getRequestDispatcher("pages/Login.jsp");
        view.forward(request,response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
      //  doGet(request, response);

        String email = request.getParameter("email");
        String pass = request.getParameter("password");

        MongoClient mongo = (MongoClient) request.getServletContext()
                .getAttribute("MONGO_CLIENT");
        UserDao userDao = new UserDao(mongo);
        User user = userDao.checkCredentials(email,pass);

        System.out.println(email+pass);

        if (user == null) {
            response.sendRedirect("login.jsp?error=1");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("email", email);
            session.setAttribute("name", user.getName());
            session.setAttribute("id", user.getId());
            session.setAttribute("role", user.getRole());
            session.setAttribute("isLoggedIn", true);

            System.out.println(" Logged In Successfully...");

            String url = "/webproject/dashboard";
            response.sendRedirect(url);
        }





    }

}
