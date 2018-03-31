package cci.stringbuffer;

import java.util.ArrayList;
import java.util.List;

public class MyStringBuffer {
    private final List<String> strings;

    public MyStringBuffer(List<String> strings) {
        this.strings = strings;
    }

    public MyStringBuffer() {
        this.strings = new ArrayList<>();
    }

    public void append(String s) {
        strings.add(s);
    }

    @Override
    public String toString() {
        String concatenated = "";
        for (String s : strings) {
            concatenated = concatenated + s;
        }
        return concatenated;
    }

    public static void main(String[] args) {
        MyStringBuffer buffer = new MyStringBuffer();
        buffer.append("jeden");
        buffer.append(" ");
        buffer.append("dwa");
        System.out.println(buffer);
    }
}
