package kpfu.ru.itis.repository;

import kpfu.ru.itis.models.Events;

import java.sql.Date;
import java.util.List;

/**
 */
public interface EventRepository {
    List<Events> searchByName(String name);
    List<Events> searchByDate(Date date);
}
