package coursera.algorithms1.week2.assignments.queues;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private static class Node<E> {
        private E data;
        private Node<E> next;
        private Node<E> prev;
    }

    private Node<Item> head = null;
    private Node<Item> tail = null;

    private int size = 0;

    // is the deque empty?
    public boolean isEmpty() {
        return head == null;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        requiresNonNull(item);

        Node<Item> node = new Node<>();
        node.data = item;

        if (isEmpty()) {
            head = node;
            tail = head;
        }
        else {
            node.next = head;
            head.prev = node;
            head = node;
        }

        size++;
    }

    // add the item to the back
    public void addLast(Item item) {
        requiresNonNull(item);

        if (isEmpty()) {
            addFirst(item);
            return;
        }

        Node<Item> node = new Node<>();
        node.data = item;
        node.prev = tail;
        tail.next = node;
        tail = node;

        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        requiresNonEmpty();

        Node<Item> node = head;
        head = head.next;
        node.next = null;

        if (head != null)
            head.prev = null;
        else
            tail = null;

        size--;

        return node.data;
    }

    // remove and return the item from the back
    public Item removeLast() {
        requiresNonEmpty();

        Node<Item> node = tail;
        tail = tail.prev;
        node.prev = null;

        if (tail != null)
            tail.next = null;
        else
            head = null;

        size--;

        return node.data;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new Iterator<>() {
            private Node<Item> curr = head;

            public boolean hasNext() {
                return curr != null;
            }

            public Item next() {
                if (!hasNext())
                    throw new NoSuchElementException();

                Node<Item> node = curr;
                curr = curr.next;
                return node.data;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    private void requiresNonEmpty() {
        if (head == null)
            throw new NoSuchElementException();
    }

    private void requiresNonNull(Item item) {
        if (item == null)
            throw new IllegalArgumentException("Item should not be null");
    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addLast(3);
        deque.addLast(4);

        StdOut.println("Deque size is " + deque.size);

        for (int data : deque) {
            StdOut.println(data);
        }

        int first = deque.removeFirst();
        StdOut.println("First was " + first);

        int last = deque.removeLast();
        StdOut.println("Last was " + last);

        StdOut.println("Deque size is " + deque.size);

        first = deque.removeFirst();
        StdOut.println("First was " + first);

        last = deque.removeLast();
        StdOut.println("Last was " + last);

        for (int data : deque) {
            StdOut.println(data);
        }

        try {
            deque.removeFirst();
        } catch (NoSuchElementException ex) {
            StdOut.println("Queue is now empty");
        }

        try {
            deque.removeLast();
        } catch (NoSuchElementException ex) {
            StdOut.println("Queue is now empty");
        }
    }
}
