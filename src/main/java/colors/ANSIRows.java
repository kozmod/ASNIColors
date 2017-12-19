package colors;

public class ANSIRows extends ANSIText {
    /***************************************************************************
     *                                                                         *
     * Constructors                                                            *
     *                                                                         *
     **************************************************************************/
    public ANSIRows(Object text) {
        super(
                ANSITextSetting.ZERO_WIDTH_SPACE_NEW_LINE,
                text
        );
    }
    public ANSIRows(Object... texts) {
        super(
                ANSITextSetting.ZERO_WIDTH_SPACE_NEW_LINE,
                texts
        );
    }
    public ANSIRows(ANSITemplate template,Object text) {
        super(
                template,
                ANSITextSetting.ZERO_WIDTH_SPACE_NEW_LINE,
                text
        );
    }
    public ANSIRows(ANSITemplate template,Object... texts) {
        super(
                template,
                ANSITextSetting.ZERO_WIDTH_SPACE_NEW_LINE,
                texts
        );
    }



}
