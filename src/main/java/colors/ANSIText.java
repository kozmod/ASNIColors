package colors;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ANSIText extends ANSIc {
    private LinkedList<Object> texts = new LinkedList<>();
    /***************************************************************************
     *                                                                         *
     * Constructors                                                            *
     *                                                                         *
     **************************************************************************/
    public ANSIText(Object text) {
        super();
        this.texts.add(text);
    }
    public ANSIText(ANSITemplate template,Object ... texts) {
        super(template);
        this.texts.addAll(Arrays.asList(texts));
    }
    public ANSIText(ANSITemplate template,Object text) {
        super(template);
        this.texts.add(text);
    }
    public ANSIText(Object ... texts) {
        super();
        this.texts.addAll(Arrays.asList(texts));
    }
    /***************************************************************************
     *                                                                         *
     * Constructors - Package-Private                                          *
     *                                                                         *
     **************************************************************************/
    ANSIText(String postfix, Object text) {
        super(postfix);
        this.texts.add(text);
    }
    ANSIText(String postfix,Object ... texts) {
        super(postfix);
        this.texts.addAll(Arrays.asList(texts));
    }
    ANSIText(ANSITemplate template,String postfix,Object ... texts) {
        super(template,postfix);
        this.texts.addAll(Arrays.asList(texts));
    }
    ANSIText(ANSITemplate template,String postfix, Object text) {
        super(template,postfix);
        this.texts.add(text);
    }
    /***************************************************************************
     *                                                                         *
     * Methods                                                                 *
     *                                                                         *
     **************************************************************************/

    @Override
    public List<Object> value() {
        if(super.template != null)
            texts.addFirst(super.template.toString());
        String templateString =  super.template.toString();
        Stream<Object> s =texts.stream().map(item -> {
                    if(item.getClass().equals(ANSIText.class))  {
                        ((ANSIText)item).texts.addLast(templateString.toString());
                    }
                    item = item + postfix;
                    return item;
                }
        );
        return s.collect(Collectors.toList());
    }
    @Override
    public String toString() {
        return this.value().stream()
                .collect(Collector.of(
                        StringBuilder::new,
                        (b ,s) -> b.append(s),
                        (b1, b2) -> b1.append(b2),
                        StringBuilder::toString
                        )
                );
    }
}
