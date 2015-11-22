package kpfu.ru.itis.repository.impl;

import kpfu.ru.itis.db.DBConnection;
import kpfu.ru.itis.models.Events;
import kpfu.ru.itis.repository.EventRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventRepositoryImpl implements EventRepository {
    public List<Events> searchByName(String name) {
        Connection connection = DBConnection.getCon();
        List<Events> eventsList = new ArrayList<Events>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * from EVENTS WHERE EVENT_NAME like ?");
            statement.setString(1, "%" + name + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Events events = new Events();
                events.setDate(rs.getDate("date"));
                events.setEventName(rs.getString("event_name"));
                eventsList.add(events);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eventsList;
    }

    public List<Events> searchByDate(Date date) {
        return null;
    }
}
