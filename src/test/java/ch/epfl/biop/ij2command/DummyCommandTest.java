package ch.epfl.biop.ij2command;

import net.imagej.ImageJ;
import org.junit.Assert;
import org.junit.Test;
import org.scijava.command.CommandModule;
import java.util.concurrent.Future;

public class DummyCommandTest {

    @Test
    public void run() throws Exception {
        // Arrange
        // create the ImageJ application context with all available services
        final ImageJ ij = new ImageJ();

        // Act
        Future<CommandModule> m = ij.command().run(DummyCommand.class, true, "number1", 2, "number2", 3);

        // Assert
        Assert.assertEquals(m.get().getOutput("the_answer_to_everything"), 42);
    }
}