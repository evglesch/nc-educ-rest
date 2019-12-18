package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService service;

    @ApiOperation(value = "Get one by ID", notes = "Find single person by it's ID")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public Person getById(@PathVariable("id") String id) {
        return service.getById(id);
    }

    @ApiOperation(value = "Get all", notes = "Retrieve all persons from DB")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public Map<String, Person> getAll() {
        return service.getAll();
    }

    @ApiOperation(value = "Create one", notes = "Create new person")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Created")})
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public Person create(@RequestBody Person data) {
        return service.create(data);
    }

    @ApiOperation(value = "Update one", notes = "Update existing person")
    @ApiResponses(value = {@ApiResponse(code = 202, message = "Accepted")})
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Person update(
            @PathVariable("id") String id,
            @RequestBody Person data) {
        return service.update(id, data);
    }

    @ApiOperation(value = "Delete one", notes = "Delete existing person")
    @ApiResponses(value = {@ApiResponse(code = 204, message = "No Content")})
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") String id) {
        service.delete(id);
    }
}
