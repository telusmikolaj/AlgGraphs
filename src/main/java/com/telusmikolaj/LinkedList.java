package com.telusmikolaj;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class LinkedList<T> implements Iterable<T>{

    private Node<T> head;
    private int size = 0;

    public void add(T value) {
        head = new Node<>(value, head);
        size ++;
    }

    public T remove() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }

        T data = head.getValue();
        head = head.getNext();
        size--;
        return data;
    }

    public void print() {
        Node<T> currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.getValue());
            currentNode = currentNode.getNext();
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T data = current.getValue();
                current = current.getNext();
                return data;
            }
        };
    }
    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action);
    }
}
