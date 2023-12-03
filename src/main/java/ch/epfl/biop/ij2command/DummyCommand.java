package ch.epfl.biop.ij2command;

import org.scijava.ItemIO;
import org.scijava.command.Command;
import org.scijava.platform.PlatformService;
import org.scijava.plugin.Parameter;
import org.scijava.plugin.Plugin;
import org.scijava.ui.UIService;

import java.io.IOException;
import java.net.URL;

/**
 * This example illustrates how to create an ImageJ 2 {@link Command} plugin.
 * The pom file of this project is customized for the PTBIOP Organization (biop.epfl.ch)
 * <p>
 * The code here is opening the biop website. The command can be tested in the java DummyCommandTest class.
 * </p>
 */

@SuppressWarnings("unused") // fields are filled by scijava processors through reflection
@Plugin(type = Command.class, menuPath = "Plugins>BIOP>Dummy Command")
public class DummyCommand implements Command {

    @Parameter
    UIService uiService;

    @Parameter
    PlatformService ps;

    @Parameter(label = "Please enter your first number",
               style = "format:0.000") // Formatting is important to display decimal precision
    double number1;

    @Parameter
    double number2;

    @Parameter(label = "What is your nickname?",
               description = "(This description is displayed when hovering over this field)")
    String name;

    @Parameter(type = ItemIO.OUTPUT)
    int the_answer_to_everything;

    @Override
    public void run() {
        uiService.show("Hello "+name+" !");
        try {
            ps.open(new URL("https://biop.epfl.ch"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        the_answer_to_everything = 42;
    }


}
