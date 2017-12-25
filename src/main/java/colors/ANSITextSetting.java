package colors;

public interface ANSITextSetting {
//    String ZERO_WIDTH_SPACE ="\u200b";
//    String ZERO_WIDTH_SPACE_NEW_LINE ="\u200b\n";
    String ZERO_WIDTH_SPACE ="";
    String ZERO_WIDTH_SPACE_NEW_LINE ="\n";
    /***************************************************************************
     *                                                                         *
     * ABSTRACT Methods                                                        *
     *                                                                         *
     **************************************************************************/
    String code();
    /***************************************************************************
     *                                                                         *
     * DEFAULT Methods                                                         *
     *                                                                         *
     **************************************************************************/
    default String value(){
        return "\033["
                +this.code()
                +"m"
                +ANSITextSetting.ZERO_WIDTH_SPACE;
    }

}
