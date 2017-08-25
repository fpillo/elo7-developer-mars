package com.elo7.mars.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.elo7.mars.domains.Mars;

@Component
public class UpdateMars {

    private final Mars mars;

    @Autowired
    public UpdateMars(final Mars mars) {
        this.mars = mars;
    }

    public Mars update(final Integer x, final Integer y) {
        return mars.update(x, y);
    }

}
