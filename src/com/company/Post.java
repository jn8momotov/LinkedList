package com.company;

public class Post {

    private String value;
    private Post next;
    private Post prev;

    public Post(String value) {
        this.value = value;
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

}
