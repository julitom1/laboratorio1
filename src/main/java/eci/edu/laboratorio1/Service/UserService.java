package eci.edu.laboratorio1.Service;

import eci.edu.laboratorio1.data.User;

import java.util.List;

public interface UserService {

    User create(User user);

    User findById(String id) throws usersNotFoundException;

    List<User> all();

    void deleteById(String id) throws usersNotFoundException;

    User update (User user, String userId) throws usersNotFoundException;

	
}
