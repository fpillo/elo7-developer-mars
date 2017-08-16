package com.elo7.mars.domains;

import com.elo7.mars.domains.commands.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collection;
import java.util.Map;

@Getter
@AllArgsConstructor
public class WorldContext {

    private Mars mars;

    private Map<Rover, Collection<Command>> roverMap;

}
