package kpfu.ru.itis.repository;

import kpfu.ru.itis.models.User;

public interface UserRepository {
    void addUser(User user);
    User findUser(String name);
}
