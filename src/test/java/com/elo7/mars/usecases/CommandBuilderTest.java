package com.elo7.mars.usecases;

import com.elo7.mars.domains.Mars;
import com.elo7.mars.domains.commands.Command;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.Iterator;

public class CommandBuilderTest {

    private CommandBuilder commandBuilder;

    private Mars mars;

    @Before
    public void setUp() {
        mars = new Mars(10, 10);
        commandBuilder = new CommandBuilder(mars);
    }

    @Test
    public void test_build_M() throws Exception {
        final Collection<Command> commands = commandBuilder.build("M");

        Assert.assertEquals(1, commands.size());
        Assert.assertEquals("M", commands.iterator().next().toString());
    }

    @Test
    public void test_build_L() throws Exception {
        final Collection<Command> commands = commandBuilder.build("L");

        Assert.assertEquals(1, commands.size());
        Assert.assertEquals("L", commands.iterator().next().toString());
    }

    @Test
    public void test_build_R() throws Exception {
        final Collection<Command> commands = commandBuilder.build("R");

        Assert.assertEquals(1, commands.size());
        Assert.assertEquals("R", commands.iterator().next().toString());
    }

    @Test
    public void test_build_MLR() throws Exception {
        final Collection<Command> commands = commandBuilder.build("MLR");

        Assert.assertEquals(3, commands.size());
        Assert.assertEquals("MLR", getCommand(commands));
    }

    @Test
    public void test_build_MLRRMM() throws Exception {
        final Collection<Command> commands = commandBuilder.build("MLRRMM");

        Assert.assertEquals(6, commands.size());
        Assert.assertEquals("MLRRMM", getCommand(commands));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_build_invalid_F() throws Exception {
        final Collection<Command> commands = commandBuilder.build("F");
    }

    private String getCommand(final Collection<Command> commands) {
        final StringBuilder sb = new StringBuilder();
        final Iterator<Command> iterator = commands.iterator();
        while(iterator.hasNext()) {
            sb.append(iterator.next().toString());
        }

        return sb.toString();
    }


}
