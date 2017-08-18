/**
 * The Apache License 2.0 Copyright (c) 2017 Victor Zhang
 */
package me.chongfeng.javaee.taglib;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * @author victor zhang
 * @date 2017/4/3.
 */
public class HelloTag2 extends SimpleTagSupport {
    StringWriter sw = new StringWriter();

    public void doTag() throws JspException, IOException {
        getJspBody().invoke(sw);
        getJspContext().getOut().println(sw.toString());
    }
}
