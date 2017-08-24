package com.elo7.mars.controllers.json;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MoveRoverJson {

    private UUID uuid;

    private String command;

}
