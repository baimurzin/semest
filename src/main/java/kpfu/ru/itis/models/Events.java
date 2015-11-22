package kpfu.ru.itis.models;

import java.sql.Date;

/**
 * Created by vlad on 13.11.2015.
 */
public class Events {
    private String eventName;
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
}
