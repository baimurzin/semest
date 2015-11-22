package kpfu.ru.itis.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletUtil {
    protected static void checkAuth(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("login") == null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }
    }
}
