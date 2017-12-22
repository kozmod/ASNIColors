

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
        ANSIc c =ANSIc.text(
                "Blue ",
                ANSIc.text(
                        (char)116,
                        (char)114,
                        (char)117,
                        (char)101,
                        ANSIc.text("111"),
                        11
                ).setTemplate(ANSIc.Color.RED,ANSIc.Property.UNDERLINE),
                1111

        );
        c.setTemplate(ANSIc.Color.BLUE);
        try {
            PrintWriter pw = new PrintWriter(new File("test.txt"));
            pw.write( c.toString());
            pw.flush();
            c.println();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        /**
         * Imperative
         */
        ANSIc.rows(
                ANSIc.text("Green").setTemplate(ANSIc.Color.GREEN),
                "Blur ", true,
                ANSIc.text("is new row ", "yes ",0000,'r',999,6666),
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
                new ANSIText("Blur ", true),
                new ANSIText("is new row ", " yes ", 000),
                new ANSIText(
                        "Change color -> ",
                        new ANSIText(new ANSITemplate(ANSIc.Color.PURPLE), "PURPLE "),
                        11111
                ),
                new ANSIText(
                        "Blue ",
                        new ANSIText(new ANSITemplate(ANSIc.Color.RED,ANSIc.Property.UNDERLINE) ,
                                (char)116,
                                (char)114,
                                (char)117,
                                (char)101
                        )
                )
        ).println();
    }

}
