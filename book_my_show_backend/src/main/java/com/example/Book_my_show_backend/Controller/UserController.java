package com.example.Book_my_show_backend.Controller;

import com.example.Book_my_show_backend.Dtos.UserRequestDto;
import com.example.Book_my_show_backend.Models.UserEntity;
import com.example.Book_my_show_backend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
@Autowired
    UserService userService;
@PostMapping("/add_user")
    public ResponseEntity<String> adduser(@RequestBody()UserRequestDto userRequestDto){
     String s= userService.adduser(userRequestDto);
    return new ResponseEntity<>(s, HttpStatus.CREATED);
}
@GetMapping("/get_user")
    public ResponseEntity<UserEntity> getUserByName(@RequestParam("name") String name){
    UserEntity user = userService.getuser(name);
    return new ResponseEntity<>(user,HttpStatus.ACCEPTED);
}
@GetMapping("/get_allusers")
    public ResponseEntity<List<UserEntity>> findAllUsers(){
    List<UserEntity> userEntityList = userService.getAllUsers();
    return new ResponseEntity<>(userEntityList,HttpStatus.OK);
}
}
