package cse.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;

@WebListener
public class MongoDBContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            ServletContext ctx = sce.getServletContext();
//            String connectionString = "mongodb+srv://rady:xDYW1sqVcSKQWmJ4@cluster0.7ah7gqn.mongodb.net/?retryWrites=true&w=majority";
            MongoClientURI uri = new MongoClientURI("mongodb+srv://rady:xDYW1sqVcSKQWmJ4@cluster0.7ah7gqn.mongodb.net/?retryWrites=true&w=majority");
            MongoClient mongo = new MongoClient(uri);
            System.out.println("MongoClient initialized successfully");
            sce.getServletContext().setAttribute("MONGO_CLIENT", mongo);
        } catch (MongoException e) {
            throw new RuntimeException("MongoClient init failed");
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        MongoClient mongo = (MongoClient) sce.getServletContext()
                .getAttribute("MONGO_CLIENT");
        mongo.close();
        System.out.println("MongoClient closed successfully");
    }

}
