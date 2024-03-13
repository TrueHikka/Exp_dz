package org.example.exceptions.userNotFound;

import java.util.List;

public interface Users {
    List<User> getUsers();

    User findUserById(Integer id) throws UserNotFoundException;
}
