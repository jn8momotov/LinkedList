package com.company;

public class ListLinked {

    private Post firstItem;
    private Post lastItem;

    public ListLinked() {}

    void showAllList() {
        int index = 1;
        Post currentItem = firstItem;
        while (currentItem != null) {
            System.out.println(index + " item: " + currentItem.getValue());
            currentItem = currentItem.getNext();
            index++;
        }
    }

    void addBefore(String before, String value) {
        if (firstItem == null) {
            firstItem = new Post(value, null);
            lastItem = firstItem;
            return;
        }
        Post currentItem = firstItem;
        Post prevItem =  firstItem.getPrev();
        while (currentItem != null) {
            if (currentItem.getValue().equals(before)) {
                Post nextItem = currentItem.getNext();
                Post newItem = new Post(value, nextItem, currentItem);
                currentItem.setNext(newItem);
                if (nextItem == null) {
                    lastItem = newItem;
                    return;
                }
                nextItem.setPrev(newItem);
                return;
            }
            prevItem = currentItem;
            currentItem = currentItem.getNext();
        }
        Post newPost = new Post(value, prevItem);
        prevItem.setNext(newPost);
        lastItem = newPost;
    }

    void removeLast(String value) {
        if (lastItem == null) {
            System.out.println("List is empty!");
            return;
        }
        Post currentItem = lastItem;
        while (currentItem != null) {
            if (currentItem.getValue().equals(value)) {
                Post nextItem = currentItem.getNext();
                Post prevItem = currentItem.getPrev();

                if (nextItem == null) {
                    lastItem = prevItem;
                    prevItem.setNext(null);
                } else if (prevItem == null) {
                    firstItem = nextItem;
                    nextItem.setPrev(null);
                } else {
                    nextItem.setPrev(prevItem);
                    prevItem.setNext(nextItem);
                }

                currentItem = null;
                System.out.println("Value is remove!");
                return;
            }
            currentItem = currentItem.getPrev();
        }
        System.out.println("Value is not found!");
    }

    Boolean searchText(String value) {
        Post currentItem = firstItem;
        while (currentItem != null) {
            if (currentItem.getValue().equals(value)) {
                return true;
            }
            currentItem = currentItem.getNext();
        }
        return false;
    }

}
