package colors;

public class ANSITemplate {
    private final  ANSITextSetting[] settings;
    /***************************************************************************
     *                                                                         *
     * Constructors                                                            *
     *                                                                         *
     **************************************************************************/
    public ANSITemplate() {
        this.settings = null;
    }
    public ANSITemplate(ANSITextSetting... settings) {
        this.settings = settings;
    }
    /***************************************************************************
     *                                                                         *
     * Methods                                                                 *
     *                                                                         *
     **************************************************************************/
    public ANSITextSetting[] value(){
        return this.settings;
    }
    @Override
    public String toString(){
        StringBuilder value = new StringBuilder(ANSITextSetting.ZERO_WIDTH_SPACE);
        if(settings != null) {
            value.append("\033[");
            for (int i = 0; i < settings.length; i++) {
                value.append(settings[i].code());
                if (i == settings.length - 1) {
                    value.append("m").append(ANSITextSetting.ZERO_WIDTH_SPACE);
                } else {
                    value.append(";");
                }
            }
        }
//        else{
//            value.append(ANSITextSetting.ZERO_WIDTH_SPACE + ANSIc.Reset.ALL.value());
//        }
        return value.toString();
    }
}
