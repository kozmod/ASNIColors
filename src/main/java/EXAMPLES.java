

import colors.ANSIRows;
import colors.ANSITemplate;
import colors.ANSIText;
import colors.ANSIc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * EXAMPLE
 */
public class EXAMPLES {
    public static void main(String[] args) {
        /**
         * Start EXAMPLES
         */
        System.err.println("--------------   Start   ----------------\n"
                         + "---------   System.err.println   --------\n"
                         + "-----------------------------------------\n");
        /**
         * Simple write text.txt to check String
         */
        ANSIc coloredOutput =ANSIc.text(
                "Blue",
                ANSIc.text(
                        " ",
                        (char)116,
                        (char)114,
                        (char)117,
                        (char)101,
                        " ",
                        ANSIc.text(" ", 8," ", false," ")
                                .setTemplate(ANSIc.Color.GREEN,ANSIc.Property.BOLD),
                        11
                ).setTemplate(ANSIc.Color.RED, ANSIc.Background.CYAN),
                1111

        );
        coloredOutput.setTemplate(ANSIc.Color.BLUE, ANSIc.Property.UNDERLINE);
        coloredOutput.println();
        /**
         * Save coloredOutput to file to check string...
         */
        try {
            PrintWriter pw = new PrintWriter(new File("colored-text.txt"));
            pw.write( coloredOutput.toString());
            pw.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        /**
         * Imperative
         */
        ANSIc.rows(
                ANSIc.text("Green").setTemplate(ANSIc.Color.GREEN),
                "START TEXT ",
                ANSIc.text("Blur ", true),
                ANSIc.text("is new row ", "yes ",0000,'r',999).setTemplate(ANSIc.Color.RED),
                ANSIc.text(
                        "Change color -> ",
                        ANSIc.text("PURPLE ").setTemplate(ANSIc.Color.PURPLE),
                        11111
                ),
                ANSIc.text(
                        "Blue ",
                        ANSIc.text(
                                (char)116,
                                (char)114,
                                (char)117,
                                (char)101
                        ).setTemplate(ANSIc.Color.RED,ANSIc.Property.UNDERLINE)
                )
        ).setTemplate(ANSIc.Color.BLUE).println();
        /**
         * Declarative stile
         */
        new ANSIRows(new ANSITemplate(ANSIc.Color.BLUE),
                new ANSIText(new ANSITemplate(ANSIc.Color.GREEN),"Green"),
                "START TEXT ",
                new ANSIText("Blur ", true),
                new ANSIText(new ANSITemplate(ANSIc.Color.RED),
                        "is new row ", "yes ",0000,'r',999),
                new ANSIText(
                        "Change color -> ",
                        new ANSIText(new ANSITemplate(ANSIc.Color.PURPLE), "PURPLE "),
                        11111
                ),
                new ANSIText(
                        "Blue ",
                        new ANSIText(
                                new ANSITemplate(
                                        ANSIc.Color.RED,
                                        ANSIc.Property.UNDERLINE
                                ),
                                (char)116,
                                (char)114,
                                (char)117,
                                (char)101
                        )
                )
        ).println();
        /**
         * Checking that all changes canceled!!!
         */
        System.out.println("----------------- END -------------------\n"
                         + "- Checking that all changes canceled!!! -\n"
                         + "-----------------------------------------\n");


    }

}
