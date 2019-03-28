package com.company;

public class Post {

    private String value;
    private Post next;
    private Post prev;

    public Post(String value, Post prev) {
        this.value = value;
        this.prev = prev;
    }

    public Post(String value, Post next, Post prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }


    public String getValue() {
        return value;
    }

    public Post getNext() {
        return next;
    }

    public Post getPrev() {
        return prev;
    }

    public void setNext(Post next) {
        this.next = next;
    }

    public void setPrev(Post prev) {
        this.prev = prev;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
