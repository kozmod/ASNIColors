package colors;

import java.util.stream.Collector;
import java.util.stream.Stream;

public class ANSIText extends ANSIc {
    private Object[] texts;
    /***************************************************************************
     *                                                                         *
     * Constructors                                                            *
     *                                                                         *
     **************************************************************************/
    public ANSIText(Object text) {
        super();
        this.texts = new Object[]{text};
    }
    public ANSIText(ANSITemplate template,Object ... texts) {
        super(template);
        this.texts =  texts;
    }
    public ANSIText(ANSITemplate template,Object text) {
        super(template);
        this.texts = new Object[]{text};
    }
    public ANSIText(Object ... texts) {
        super();
        this.texts =  texts;
    }
    /***************************************************************************
     *                                                                         *
     * Constructors - Package-Private                                          *
     *                                                                         *
     **************************************************************************/
    ANSIText(String postfix, Object text) {
        super(postfix);
        this.texts = new Object[]{text};
    }
    ANSIText(String postfix,Object ... texts) {
        super(postfix);
        this.texts =  texts;
    }
    ANSIText(ANSITemplate template,String postfix,Object ... texts) {
        super(template,postfix);
        this.texts =  texts;
    }
    ANSIText(ANSITemplate template,String postfix, Object text) {
        super(template,postfix);
        this.texts = new Object[]{text};
    }
    /***************************************************************************
     *                                                                         *
     * Methods                                                                 *
     *                                                                         *
     **************************************************************************/

    @Override
    public Object[] value() {
        Stream<Object> valueStream = Stream.of(texts)
                .map(item ->{
                    if(super.template != null) {
                        item =  super.template.toString()
//                                + ANSITextSetting.ZERO_WIDTH_SPACE
                                + item
                                + ANSIc.Reset.ALL.value();
                    }
                    item = item + postfix;
                    return item;
                });
        return valueStream.toArray(size ->new Object[size]);
    }
    @Override
    public String toString() {
        return  Stream.of(this.value())
                .collect(Collector.of(
                        StringBuilder::new,
                        (b ,s) -> b.append(s),
                        (b1, b2) -> b1.append(b2),
                        StringBuilder::toString
                        )
                );
    }
}
