package coursera.algorithms1.week2.assignments.queues;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

@SuppressWarnings("unchecked")
public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] items = (Item[]) new Object[1];

    private int top = 0;

    // is the randomized queue empty?
    public boolean isEmpty() {
        return top == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return top;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null)
            throw new IllegalArgumentException();

        if (top == items.length) {
            resize(2 * items.length);
        }

        items[top++] = item;
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (top == items.length / 4) {
            resize(items.length / 2);
        }

        int randomIndex = StdRandom.uniform(top);

        Item item = items[randomIndex];
        items[randomIndex] = items[--top];
        items[top] = null;

        return item;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty())
            throw new NoSuchElementException();

        int randomIndex = StdRandom.uniform(top);
        return items[randomIndex];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        Item[] copy = (Item[]) new Object[top];

        System.arraycopy(items, 0, copy, 0, top);

        StdRandom.shuffle(copy);

        return new Iterator<>() {
            private final Item[] array = copy;
            private int curr = 0;

            public boolean hasNext() {
                return curr < array.length;
            }

            public Item next() {
                if (!hasNext())
                    throw new NoSuchElementException();

                return array[curr++];
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    private void resize(int newSize) {
        Item[] newArray = (Item[]) new Object[newSize];
        System.arraycopy(items, 0, newArray, 0, top);
        items = newArray;
    }

    // unit testing (required)
    public static void main(String[] args) {
        int n = 5;
        RandomizedQueue<Integer> queue = new RandomizedQueue<>();

        for (int i = 0; i < n; i++)
            queue.enqueue(i);

        for (int a : queue) {
            for (int b : queue) {
                StdOut.print(a + "-" + b + " ");
            }
            StdOut.println();
        }
    }
}
