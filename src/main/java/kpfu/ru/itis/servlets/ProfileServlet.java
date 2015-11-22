package kpfu.ru.itis.servlets;

import kpfu.ru.itis.models.User;
import kpfu.ru.itis.repository.UserRepository;
import kpfu.ru.itis.repository.impl.UserRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ProfileServlet extends HttpServlet {

    private UserRepository userRepository;

    public ProfileServlet() {
        userRepository = new UserRepositoryImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletUtil.checkAuth(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletUtil.checkAuth(request, response);
        User user = userRepository.findUser((String)request.getSession().getAttribute("login"));
        request.setAttribute("user", user);
        request.getRequestDispatcher("profile.jsp").forward(request, response);
    }
}
