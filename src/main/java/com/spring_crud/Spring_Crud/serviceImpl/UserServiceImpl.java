package com.spring_crud.Spring_Crud.serviceImpl;

import com.spring_crud.Spring_Crud.entities.User;
import com.spring_crud.Spring_Crud.exceptions.NotFoundException;
import com.spring_crud.Spring_Crud.payloads.UserDTO;
import com.spring_crud.Spring_Crud.repositories.UserRepository;
import com.spring_crud.Spring_Crud.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = this.dtoToUser(userDTO);
        User saveUser = repository.save(user);
        return userToDTo(saveUser);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, int userID) {
        User foundUser = this.repository.findById(userID)
                .orElseThrow(() -> new NotFoundException("User Not Found"));
        System.out.println("updaete :: "+foundUser);
        foundUser.setName(userDTO.getName());
        foundUser.setEmail(userDTO.getEmail());
        foundUser.setAbout(userDTO.getAbout());
        User  updateUser = this.repository.save(foundUser);
        return userToDTo(updateUser);
    }

    @Override
    public UserDTO getUserById(int userId) {
        User foundUser = this.repository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User Not Found"));

        return userToDTo(foundUser);
    }

    @Override
    public List<UserDTO> getUserList() {
        List<User> users = this.repository.findAll();
        return users.stream().map(user -> this.userToDTo(user)).collect(Collectors.toList());
    }

    @Override
    public void deleteUser(int userId) {
        User foundUser = this.repository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User Not Found"));
        this.repository.delete(foundUser);

    }



//    convert user dto to user
    private User dtoToUser(UserDTO userDTO){

//        user.setId(userDTO.getId());
//        user.setName(userDTO.getName());
//        user.setEmail(userDTO.getEmail());
//        user.setPassword(userDTO.getPassword());
//        user.setAbout(userDTO.getAbout());
        return this.modelMapper.map(userDTO, User.class);
    }

    //convert user to user dto
    private UserDTO userToDTo(User user){
//        UserDTO userDTO = new UserDTO();
//        userDTO.setId(user.getId());
//        userDTO.setName(user.getName());
//        userDTO.setEmail(user.getEmail());
//        userDTO.setPassword(user.getPassword());
//        userDTO.setAbout(user.getAbout());
        return this.modelMapper.map(user, UserDTO.class);

    }
}
