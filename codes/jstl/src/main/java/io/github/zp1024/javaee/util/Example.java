package io.github.zp1024.javaee.util;

import java.util.ListResourceBundle;

public class Example extends ListResourceBundle {
    public Object[][] getContents() {
        return contents;
    }

    static final Object[][] contents =
                    {{"count.one", "一"}, {"count.two", "二"}, {"count.three", "三"},};
}
