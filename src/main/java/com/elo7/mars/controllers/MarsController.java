package com.elo7.mars.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.elo7.mars.controllers.json.MarsJson;
import com.elo7.mars.domains.Mars;
import com.elo7.mars.usecases.UpdateMars;

@RestController
public class MarsController {

    private final UpdateMars updateMars;

    @Autowired
    public MarsController(final UpdateMars updateMars) {
        this.updateMars = updateMars;
    }

    @PutMapping(value = "/mars", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Mars update(@RequestBody final MarsJson marsJson) {
        return updateMars.update(marsJson.getX(), marsJson.getY());
    }


}
