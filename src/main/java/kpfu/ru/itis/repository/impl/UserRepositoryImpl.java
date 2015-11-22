package kpfu.ru.itis.repository.impl;

import kpfu.ru.itis.db.DBConnection;
import kpfu.ru.itis.models.User;
import kpfu.ru.itis.repository.UserRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserRepositoryImpl implements UserRepository {

    public void addUser(User user) {
        Connection connection = DBConnection.getCon();
        try {
            PreparedStatement ps = connection.prepareStatement("insert into USERS (login, password) values (?,?);");
            ps.setString(1, user.getLogin());;
            ps.setString(2, user.getPassword());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User findUser(String name) {
        Connection connection = DBConnection.getCon();
        User user = null;
        try {
            PreparedStatement ps = connection.prepareStatement("select * from USERS WHERE login = ?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if(!rs.next())
                return null;

            user = new User(rs.getString("login"), rs.getString("password"));
            user.setCountry(rs.getString("country"));
            user.setEmail(rs.getString("email"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
