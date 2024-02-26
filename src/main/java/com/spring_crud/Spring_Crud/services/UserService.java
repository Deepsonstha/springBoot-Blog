package com.spring_crud.Spring_Crud.services;


import com.spring_crud.Spring_Crud.payloads.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    UserDTO createUser(UserDTO user);
    UserDTO updateUser(UserDTO user, int userID);
    UserDTO   getUserById(int userId);
    List<UserDTO> getUserList();
    void deleteUser(int userId);

}
