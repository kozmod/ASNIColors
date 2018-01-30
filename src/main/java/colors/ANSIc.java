package colors;

import java.util.List;

public abstract class ANSIc {
    /***************************************************************************
     *                                                                         *
     * ENUMS                                                                   *
     *                                                                         *
     **************************************************************************/
    public enum Reset implements ANSITextSetting {
        ALL      (0),
        INTENSITY(22),
        UNDERLINE(24),
        BLINK    (25),
        REVERSE  (27);
        Reset(int value){
            this.value = value;
        }
        @Override
        public String code() {
            return String.valueOf(value);
        }
        private int value;
    }
    public enum Background implements ANSITextSetting {
        BLACK (40),  // BLACK
        RED   (41),    // RED
        GREEN (42),  // GREEN
        YELLOW(43), // YELLOW
        BLUED (44),   // BLUE
        PURPLE(45), // PURPLE
        CYAN  (46),   // CYAN
        WHITE (47);  // WHITE
        Background(int value){
            this.value = value;
        }
        @Override
        public String code() {
            return String.valueOf(value);
        }
        private int value;
    }
    public enum Color implements ANSITextSetting {
        // Regular Colors
        BLACK (30),   // BLACK
        RED   (31),     // RED
        GREEN (32),   // GREEN
        YELLOW(33),  // YELLOW
        BLUE  (34),    // BLUE
        PURPLE(35),  // PURPLE
        CYAN  (36),    // CYAN
        WHITE (37);   // WHITE
        Color(int value){
            this.value = value;
        }
        @Override
        public String code() {
            return String.valueOf(value);
        }
        private int value;
    }
    public enum THI implements ANSITextSetting {
        // High Intensity
        BLACK (90),  // BLACK
        RED   (91),    // RED
        GREEN (92),  // GREEN
        YELLOW(93), // YELLOW
        BLUE  (94),   // BLUE
        PURPLE(95), // PURPLE
        CYAN  (96),   // CYAN
        WHITE (97);  // WHITE
        THI(int value){
            this.value = value;
        }
        @Override
        public String code() {
            return String.valueOf(value);
        }
        private int value;
    }
    public enum Property implements ANSITextSetting {
        BOLD       (1),
        SEMI_BRIGHT(2),
        UNDERLINE  (4),
        BLINK      (5),
        REVERSE    (7);
        Property(int value){
            this.value = value;
        }
        @Override
        public String code() {
            return String.valueOf(value);
        }
        private int value;
    }
    /***************************************************************************
     *                                                                         *
     * Fields                                                                  *
     *                                                                         *
     **************************************************************************/
    ANSITemplate template;
    String postfix ;
    /***************************************************************************
     *                                                                         *
     * Constructors                                                            *
     *                                                                         *
     **************************************************************************/
    ANSIc() {
        this.template = new ANSITemplate();
        this.postfix  = ANSITextSetting.ZERO_WIDTH_SPACE;
    }

    ANSIc(ANSITemplate template) {
        this.template = template;
        this.postfix  = ANSITextSetting.ZERO_WIDTH_SPACE;
    }
    ANSIc(String postfix) {
        this.template = new ANSITemplate();
        this.postfix  = postfix;
    }
    ANSIc(ANSITemplate template, String postfix) {
        this.template = template;
        this.postfix  = postfix;
    }
    /***************************************************************************
     *                                                                         *
     * ABSTRACT Methods                                                        *
     *                                                                         *
     **************************************************************************/
    protected abstract List<Object> value();
    /***************************************************************************
     *                                                                         *
     * Methods                                                                 *
     *                                                                         *
     **************************************************************************/
    /**
     * System.out.print(this.toString())
     */
    public void print() {
        System.out.print(this.toString() + ANSIc.Reset.ALL.value());
    }
    /**
     *  System.out.println(this.toString())
     */
    public void println() {
        System.out.println(this.toString() + ANSIc.Reset.ALL.value());
    }

    /**
     * Set template to text-data use codes from enums.
     * @param ansiColorSettings enums of codes
     * @return ANSIc with set template
     */
    public ANSIc setTemplate(ANSITextSetting... ansiColorSettings) {
        this.template = new ANSITemplate(ansiColorSettings);
        return  this;
    }
    /**
     * Set template to text-data use ANSITemplate object.
     * @param template ANSITemplate object
     * @return ANSIc with set template
     */
    public ANSIc setTemplate(ANSITemplate template) {
        this.template = template;
        return  this;
    }
    /***************************************************************************
     *                                                                         *
     * Static Methods                                                          *
     *                                                                         *
     **************************************************************************/
    /**
     * printer.ANSIc Text
     * @param texts array of text-data which have to apply the template
     * @return ANSIText
     */
    public static ANSIText text(Object ... texts){
        return new ANSIText(texts);
    }
    /**
     * printer.ANSIc Text
     * @param text 'Object' of text-data which have to apply the template
     * @return ANSIText
     */
    public static ANSIText text(Object text){
        return new ANSIText(text);
    }
    /**
     * printer.ANSIc Rows
     * @param texts array of text-data which have to apply the template
     * @return ANSIRows
     */
    public static ANSIRows rows(Object ... texts){
        return new ANSIRows(texts);
    }
    /**
     * printer.ANSIc Rows
     * @param text  'Object' of text-data which have to apply the template
     * @return ANSIRows
     */
    public static ANSIRows rows(Object text){
        return new ANSIRows(text);
    }

}
