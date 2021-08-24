package eci.edu.laboratorio1.controller;

import eci.edu.laboratorio1.Service.UserService;

import eci.edu.laboratorio1.data.User;
import eci.edu.laboratorio1.dto.UserDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(@Autowired UserService userService){
        this.userService=userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> all(){
    	try {
            return new ResponseEntity<>(userService.all(),HttpStatus.ACCEPTED);
        }catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable String id){
    	try {
            return new ResponseEntity<>(userService.findById(id),HttpStatus.ACCEPTED);
        }catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping
    public ResponseEntity<User> create(@RequestBody UserDto userDto){
    	try {
    		User usuario=new User(userDto.getName(),userDto.getEmail(),userDto.getLastName(),userDto.getCreated());
    
           return new ResponseEntity<>(usuario,HttpStatus.ACCEPTED);
        }catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("{/id}")
    public ResponseEntity<User> update(@RequestBody UserDto userDto, @PathVariable String id){
    	try {
    		User usuario=new User(userDto.getName(),userDto.getEmail(),userDto.getLastName(),userDto.getCreated());
    		usuario.setId(id);
            return new ResponseEntity<>(userService.update(usuario, id),HttpStatus.ACCEPTED);
        }catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping
    public ResponseEntity<Boolean> delete(@PathVariable String id){
    	try {
    		userService.deleteById(id);
            return new ResponseEntity<>(true,HttpStatus.ACCEPTED);
        }catch(Exception e) {
            return new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
        }
    }



}
