package org.example.exceptions.userNotFound;

import java.util.ArrayList;
import java.util.List;

public class UsersList implements Users{
    private List<User> users;

    public UsersList() {
        users = new ArrayList<>();
        users.add(new User(1, "Martin Iden", "martin.doe@example.com"));
        users.add(new User(2, "Kaene West", "kaene.smith@example.com"));
    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public User findUserById(Integer id) throws UserNotFoundException{
        if (id < 0) {
            throw new UserNotFoundException("Переданный идентификатор меньше 0. Попробуйте снова");
        }

        for (User user : users) {
            if (user.getUserId().equals(id)) {
                return user;
            }
        }

        throw new UserNotFoundException("Пользователь с id=" + id + " не найден. Попробуйте снова");
    }
}
