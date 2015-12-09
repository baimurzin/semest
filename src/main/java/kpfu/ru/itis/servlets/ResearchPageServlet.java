package kpfu.ru.itis.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import kpfu.ru.itis.models.Events;
import kpfu.ru.itis.repository.EventRepository;
import kpfu.ru.itis.repository.impl.EventRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ResearchPageServlet extends HttpServlet {

    private EventRepository eventRepository = null;

    public ResearchPageServlet() {
        eventRepository = new EventRepositoryImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String query = request.getParameter("query");
        List<Events> eventsList =  eventRepository.searchByName(query);
        List<Events> eventsByDate = eventRepository.searchByDate(query);
        eventsList.addAll(eventsByDate);
        response.setContentType("application/json");

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getOutputStream(), eventsList);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("research.jsp").forward(request, response);
    }
}
