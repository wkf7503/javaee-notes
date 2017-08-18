/**
 * The Apache License 2.0 Copyright (c) 2017 Victor Zhang
 */
package me.chongfeng.javaee.taglib;

/**
 * @author victor zhang
 * @date 2017/4/3.
 */

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HelloTag extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.println("Hello Custom Tag!");
    }
}
