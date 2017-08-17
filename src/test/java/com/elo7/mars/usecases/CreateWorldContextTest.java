package com.elo7.mars.usecases;

import com.elo7.mars.domains.WorldContext;
import com.elo7.mars.domains.commands.MoveCommand;
import com.elo7.mars.domains.commands.TurnLeftCommand;
import com.elo7.mars.domains.commands.TurnRightCommand;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

@RunWith(MockitoJUnitRunner.class)
public class CreateWorldContextTest {

    @InjectMocks
    private CreateWorldContext createWorldContext;

    @Mock
    private CommandBuilder commandBuilder;


    @Test
    public void test_create_one_rover() throws Exception {
        final String input = "5 5\n1 2 N\nRMM";
        Mockito.when(commandBuilder.build("RMM")).thenReturn(Arrays.asList(new TurnRightCommand(), new MoveCommand(), new MoveCommand()));

        final WorldContext worldContext = createWorldContext.create(input);
        Assert.assertTrue(worldContext.getMars() != null);
        Assert.assertEquals(1, worldContext.getRoverMap().size());
    }

    @Test
    public void test_create_two_rover() throws Exception {
        final String input = "6 7\n1 2 N\nRMM\n3 2 E\nLMR";
        Mockito.when(commandBuilder.build("RMM")).thenReturn(Arrays.asList(new TurnRightCommand(), new MoveCommand(), new MoveCommand()));
        Mockito.when(commandBuilder.build("LMR")).thenReturn(Arrays.asList(new TurnLeftCommand(), new MoveCommand(), new TurnRightCommand()));

        final WorldContext worldContext = createWorldContext.create(input);
        Assert.assertTrue(worldContext.getMars() != null);
        Assert.assertEquals(2, worldContext.getRoverMap().size());
    }

}
