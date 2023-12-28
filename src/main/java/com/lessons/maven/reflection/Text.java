package com.lessons.maven.reflection;

@ClassConfig(prefix = "message")
public class Text extends Message{
    @Required
    private String text;

    public Text(String sender) {
        super(sender);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}