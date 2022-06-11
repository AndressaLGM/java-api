package com.teste.demoapi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teste.demoapi.model.Users;
import com.teste.demoapi.repository.UsersRepository;


@RestController
@RequestMapping("/users")
public class UsersController {

  @Autowired
  private UsersRepository usersRepository;

  @GetMapping
  public List<Users> index(){
    return usersRepository.findAll();
  }

  @GetMapping(path = {"/{id}"})
  public Optional<Users> show(@PathVariable long id){
    return usersRepository.findById(id);
  }

  @PostMapping
  public Users create(@RequestBody Users users) {
    return usersRepository.save(users);
  }

  @PutMapping
  public void update(@RequestBody Users users){
    if(users.getId() > 0) {
      usersRepository.save(users);
    }
  }

  @DeleteMapping
  public void delete(@RequestParam Users id){
    usersRepository.delete(id);
  }

}
