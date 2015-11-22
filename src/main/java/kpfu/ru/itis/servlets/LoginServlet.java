package kpfu.ru.itis.servlets;

import kpfu.ru.itis.models.User;
import kpfu.ru.itis.repository.UserRepository;
import kpfu.ru.itis.repository.impl.UserRepositoryImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ScheduledExecutorService;


public class LoginServlet extends HttpServlet {

    private UserRepository userRepository = null;

    public LoginServlet( ) {
        userRepository = new UserRepositoryImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        User user = userRepository.findUser(login);
        if (user == null) {
            req.setAttribute("error", "User not found");
        } else if (!user.getPassword().equals(password)) {
            req.setAttribute("error", "Incorrect password");
        } else  {
            HttpSession session = req.getSession();
            session.setAttribute("login", user.getLogin());
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher(req.getAttribute("error") == null ? "profile.jsp" : "login.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
        requestDispatcher.forward(req,resp);
    }
}
