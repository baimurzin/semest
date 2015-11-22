package kpfu.ru.itis.servlets;

import kpfu.ru.itis.models.User;
import kpfu.ru.itis.repository.UserRepository;
import kpfu.ru.itis.repository.impl.UserRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class RegisterServlet extends HttpServlet {

    private UserRepository userRepository;

    public RegisterServlet() {
        userRepository = new UserRepositoryImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        User user = userRepository.findUser(login);
        if (user != null) {
            request.setAttribute("error", "User already exist");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        } else {
            user = new User(login, password);
            userRepository.addUser(user);
            request.getSession().setAttribute("login", user.getLogin());
        }
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }
}
