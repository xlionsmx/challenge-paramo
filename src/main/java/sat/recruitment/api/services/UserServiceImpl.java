/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sat.recruitment.api.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sat.recruitment.api.domain.user.User;
import sat.recruitment.api.dto.UserDto;
import sat.recruitment.api.mappers.UserMapper;

/**
 *
 * @author lsanmartin
 */
@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    FileService fileService;
    
    @Autowired
    UserMapper userMapper;

    @Override
    public boolean isUserDuplicated(UserDto userToSearch) {
        return  getUsers().stream()
                        .anyMatch(user -> areEmailOrPhoneEquals(user, userToSearch) ||
                                          areNameAndAddressEquals(user, userToSearch));     
    }

    @Override
    public List<User> getUsers() {        
        return getUsersFromFile("/users.txt");
    }
    
    public List<User>  getUsersFromFile(String filePath){
        List<User> users = new ArrayList<User>();     
        try {
            List<String> linesFromFile;
            linesFromFile = fileService.getResourceFileAsListString(filePath);
            linesFromFile.forEach(line -> users.add(getUserFromLine(line)));
        } catch (IOException ex) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }
    
    public User getUserFromLine(String line){
        
        String[] lineSplitted = line.split(",");
        User user = new User();
        userMapper.arrayStringToUser(lineSplitted, user);
        return user;     
    }
    
    
    public boolean areEmailOrPhoneEquals(User user1, UserDto user2){
        return user1.getEmail().equals(user2.getEmail()) || user1.getPhone().equals(user2.getPhone());       
    }
    
    public boolean areNameAndAddressEquals(User user1, UserDto user2){
        return user1.getName().equals(user2.getName()) && user1.getAddress().equals(user2.getAddress());       
    }
    

  
}
