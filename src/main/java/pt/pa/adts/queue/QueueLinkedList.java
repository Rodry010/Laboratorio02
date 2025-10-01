package pt.pa.adts.queue;

/**
 * This class must implement the Queue interface
 * @param <T>
 */
public class QueueLinkedList<T> implements Queue<T> {

    private ListNode header, trailer;
    private int size;

    public QueueLinkedList() {
        header = new ListNode(null, null, null);
        trailer = new ListNode(null, header, null);
        header.next = trailer;
        size = 0;
    }

    public void enqueue(T elem) throws QueueFullException, NullPointerException {
        if (elem == null) {
            throw new NullPointerException("Element cannot be null");
        } else {
            ListNode newNode = new ListNode(elem, trailer.prev, trailer);
            trailer.prev.next = newNode;
            trailer.prev = newNode;
            size++;
        }
    }

    public T dequeue() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException("Queue is empty");
        } else {
            ListNode firstNode = header.next;
            T element = firstNode.element;
            header.next = firstNode.next;
            firstNode.next.prev = header;
            size--;
            return element;
        }
    }

    public T front() throws QueueEmptyException {
        return header.next.element;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        header.next = trailer;
        trailer.prev = header;
        size = 0;
    }

    private class ListNode {
        private T element;
        private ListNode next;
        private ListNode prev;

        public ListNode(T element, ListNode prev, ListNode next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
