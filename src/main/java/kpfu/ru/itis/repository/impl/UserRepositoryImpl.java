package kpfu.ru.itis.repository.impl;

import kpfu.ru.itis.db.DBConnection;
import kpfu.ru.itis.models.User;
import kpfu.ru.itis.repository.UserRepository;
import kpfu.ru.itis.util.CommonUtil;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserRepositoryImpl implements UserRepository {

    public void addUser(User user) {
        Connection connection = DBConnection.getCon();
        try {
            PreparedStatement ps = connection.prepareStatement("insert into USERS (login, password, EMAIL, BIRTH_DATE) values (?,?,?, ?);");
            ps.setString(1, user.getLogin());
            String hashedPassword = CommonUtil.decodeString(user.getPassword());
            ps.setString(2, hashedPassword);
            ps.setString(3, user.getEmail());
            ps.setDate(4, user.getBirthDate());
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
            if (!rs.next())
                return null;

            user = new User(rs.getString("login"), rs.getString("password"));
            user.setCountry(rs.getString("country"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));//хешированный пароль, для того, чтобы сверить с вводом
            user.setBirthDate(rs.getDate("birth_date"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

}
