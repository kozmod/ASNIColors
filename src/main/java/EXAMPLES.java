import colors.ANSIRows;
import colors.ANSITemplate;
import colors.ANSIText;
import colors.ANSIc;

/**
 * EXAMPLE
 */
public class EXAMPLES {
    public static void main(String[] args) {
        /**
         * Imperative
         */
        ANSIc.rows(
                ANSIc.text("Green").setTemplate(ANSIc.Color.GREEN),
                ANSIc.text("Blur ", true),
                ANSIc.text("is new row ", "yes ",0000),
                ANSIc.text(
                        "Change color -> ",
                        ANSIc.text("PURPLE ").setTemplate(ANSIc.Color.PURPLE),
                        11111
                ),
                ANSIc.text("Blue ",
                        ANSIc.text(
                                (char)116,
                                (char)114,
                                (char)117,
                                (char)101
                        ).setTemplate(ANSIc.Color.RED,ANSIc.Property.UNDERLINE))
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
                                (char)101)
                )).println();
    }

}
