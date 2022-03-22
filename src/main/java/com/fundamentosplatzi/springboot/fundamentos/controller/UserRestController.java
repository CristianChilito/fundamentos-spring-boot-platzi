package com.fundamentosplatzi.springboot.fundamentos.controller;

import com.fundamentosplatzi.springboot.fundamentos.caseuse.CreateUser;
import com.fundamentosplatzi.springboot.fundamentos.caseuse.DeleteUser;
import com.fundamentosplatzi.springboot.fundamentos.caseuse.GetUser;
import com.fundamentosplatzi.springboot.fundamentos.caseuse.UpdateUser;
import com.fundamentosplatzi.springboot.fundamentos.entity.User;
import com.fundamentosplatzi.springboot.fundamentos.repository.UserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    private GetUser getUser;
    private CreateUser createUser;
    private DeleteUser deleteUser;
    private UpdateUser updateUser;
    private UserRepository userRepository;

    public UserRestController(GetUser getUser,CreateUser createUser,DeleteUser deleteUser,UpdateUser updateUser,UserRepository userRepository) {
        this.getUser = getUser;
        this.deleteUser = deleteUser;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.userRepository = userRepository;
    }
    @GetMapping("/")
    List<User>get(){return getUser.getAll();}
    @PostMapping("/createuser")
    ResponseEntity<User> newUser(@RequestBody User neUser)
    {
        return  new ResponseEntity<>(createUser.save(neUser), HttpStatus.CREATED);
    }
    @DeleteMapping("/deleteUser/{id}")
    ResponseEntity deleteUser(@PathVariable Long id){
        deleteUser.remove(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/updateUser/{id}")
    ResponseEntity<User> replaceUser(@RequestBody User newUser,@PathVariable Long id)
    {
       return new ResponseEntity<>(updateUser.update(newUser,id),HttpStatus.OK);
    }
    @GetMapping("/pageable")
    public List<User> getUserPageable(@RequestParam int page, @RequestParam int size) {
        return userRepository.findAll(PageRequest.of(page, size)).getContent();
    }
}
