package oy.tol.tra;

import java.util.Arrays;

public class QueueImplementation<SS> implements QueueInterface<SS> {

    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private int capacity;
    private SS[] elements;

    @SuppressWarnings("unchecked")
    public QueueImplementation(int capacity) {
        this.capacity = capacity > 0 ? capacity : DEFAULT_CAPACITY;
        this.elements = (SS[]) new Object[this.capacity];
        this.size = 0;
    }

    public QueueImplementation() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public void enqueue(SS element) {
        if (element == null) {
            throw new NullPointerException("Can not add null element to the queue");
        }
        if (size == capacity) {
            reallocate();
        }
        elements[size++] = element;
    }

    @Override
    public SS dequeue() {
        if (isEmpty()) {
            throw new QueueIsEmptyException("Queue is empty can not dequeue");
        }
        SS element = elements[0];
        System.arraycopy(elements, 1, elements, 0, --size);
        return element;
    }

    @Override
    public SS element() {
        if (isEmpty()) {
            throw new QueueIsEmptyException("Queue is empty can not retrieve element");
        }
        return elements[0];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        Arrays.fill(elements, null);
        size = 0;
    }

    @Override
    public int capacity() {
        return capacity;
    }

    @SuppressWarnings("unchecked")
    private void reallocate() {
        capacity *= 2;
        SS[] newArray = (SS[]) new Object[capacity];
        System.arraycopy(elements, 0, newArray, 0, size);
        elements = newArray;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}