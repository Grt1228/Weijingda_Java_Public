package com.jgsu.pojo;

public class NewContent {
    private String newId;

    private String content;

    public NewContent(String newId, String content) {
        this.newId = newId;
        this.content = content;
    }

    public NewContent() {
        super();
    }

    public String getNewId() {
        return newId;
    }

    public void setNewId(String newId) {
        this.newId = newId == null ? null : newId.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}