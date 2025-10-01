package pt.pa.adts.queue;

public class QueueLinkedListNoNulls<T> extends QueueLinkedList<T> {

    public QueueLinkedListNoNulls() {
        super();
    }

    @Override
    public void enqueue(T elem) throws QueueFullException, NullNotAllowedException {
        if (elem == null) {
            throw new NullNotAllowedException("Element cannot be null");
        }
        super.enqueue(elem);
    }
}


