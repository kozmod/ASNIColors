package colors;

import java.util.List;
    /**
     *ANSIc abstract class realizes "System.out.print" logic and containse factory methods to build colored rows and texts.
     *<br>Also this class contains enumeration of colors, background colors,high intensity, and text propertirs.
     */
public abstract class ANSIc {
    ANSITemplate template;
    String postfix ;
    /***************************************************************************
     *                                                                         *
     * ENUMS                                                                   *
     *                                                                         *
     **************************************************************************/
    /**
     * "Reset" variables.
     */
    public enum Reset implements ANSITextSetting {
        ALL      ( 0), // RESET ALL SETTINGS
        INTENSITY(22), // RESET INTENSITY
        UNDERLINE(24), // RESET UNDERLINE
        BLINK    (25), // RESET BLINK
        REVERSE  (27); // RESET REVERSE
        Reset(int value){
            this.value = value;
        }
        @Override
        public String code() {
            return String.valueOf(value);
        }
        private int value;
    }
    /**
     * "Background" variables.
     */
    public enum Background implements ANSITextSetting {
        BLACK (40),  // BLACK
        RED   (41),  // RED
        GREEN (42),  // GREEN
        YELLOW(43),  // YELLOW
        BLUED (44),  // BLUE
        PURPLE(45),  // PURPLE
        CYAN  (46),  // CYAN
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
    /**
     * "Regular Color" variables.
     */
    public enum Color implements ANSITextSetting {
        BLACK (30),   // BLACK
        RED   (31),   // RED
        GREEN (32),   // GREEN
        YELLOW(33),   // YELLOW
        BLUE  (34),   // BLUE
        PURPLE(35),   // PURPLE
        CYAN  (36),   // CYAN
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
    /**
     * "High Intensity" variables.
     */
    public enum THI implements ANSITextSetting {
        BLACK (90),  // BLACK
        RED   (91),  // RED
        GREEN (92),  // GREEN
        YELLOW(93),  // YELLOW
        BLUE  (94),  // BLUE
        PURPLE(95),  // PURPLE
        CYAN  (96),  // CYAN
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
    /**
     * "Text style (Property)" variables.
     */
    public enum Property implements ANSITextSetting {
        BOLD       (1), // BOLD
        SEMI_BRIGHT(2), // SEMI-BRIGHT
        UNDERLINE  (4), // UNDERLINE
        BLINK      (5), // BLINK
        REVERSE    (7); // REVERSE
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
    public ANSIc template(ANSITextSetting ... ansiColorSettings) {
        this.template = new ANSITemplate(ansiColorSettings);
        return  this;
    }
    /**
     * Set template to text-data use ANSITemplate object.
     * @param template ANSITemplate object
     * @return ANSIc with set template
     */
    public ANSIc template(ANSITemplate template) {
        this.template = template;
        return  this;
    }
    /***************************************************************************
     *                                                                         *
     * Factory Methods                                                         *
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
