package me.chongfeng.javaee.taglib.test;

public class TestMessage {
    public static void main(String[] args) {
        System.out.println(Messages.getString("TestMessage.0", "A", "B")); //$NON-NLS-1$
    }
}
