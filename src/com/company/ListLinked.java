package com.company;

public class ListLinked {

    private Post firstItem;
    private Post lastItem;

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
            firstItem = new Post(value);
            lastItem = firstItem;
            return;
        }
        Post currentItem = firstItem;
        while (true) {
            if (currentItem.getValue().equals(before)) {

                Post newItem = new Post(value);
                if (currentItem.getPrev() == null) {
                    firstItem = newItem;
                    newItem.setNext(currentItem);
                    currentItem.setPrev(newItem);
                    return;
                }
                newItem.setPrev(currentItem.getPrev());
                newItem.setNext(currentItem);
                currentItem.getPrev().setNext(newItem);
                currentItem.setPrev(newItem);
                return;
            }

            if (currentItem.getNext() == null) {
                Post newPost = new Post(value);
                newPost.setPrev(currentItem);
                currentItem.setNext(newPost);
                lastItem = newPost;
                return;
            }

            currentItem = currentItem.getNext();
        }
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

                if (prevItem == null && nextItem == null) {
                    firstItem = null;
                    lastItem = null;
                } else if (nextItem == null) {
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
