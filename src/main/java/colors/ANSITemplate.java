package colors;

public class ANSITemplate {
    private final  ANSITextSetting[] settings;
    /***************************************************************************
     *                                                                         *
     * Constructors                                                            *
     *                                                                         *
     **************************************************************************/
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
        StringBuilder value = new StringBuilder("\033[");
        for (int i = 0; i < settings.length; i++) {
            value.append(settings[i].code());
            if(i == settings.length -1) {
                value.append("m").append(ANSITextSetting.ZERO_WIDTH_SPACE);
            }else{
                value.append(";");
            }
        }
        return value.toString();
    }
}
