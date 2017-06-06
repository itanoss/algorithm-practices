
public class Queue<T> {
    private class Node {
        private Node next;
        private T data;
    }

    private Node first;
    private Node last;

    public T remove() {
        if(first == null) throw new EmptyException();
        T data = first.data;
        first = first.next;
        return data;
    }

    public void add(T data) {
        Node n = new Node();
        n.data = data;
        if(this.last != null) this.last.next = n;
        this.last = n;
        if(this.first == null) this.first = this.last;
    }

    public T peek() {
        if(first == null) throw new EmptyException();
        return first.data;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public static class EmptyException extends RuntimeException {
    }

    public static void main(String[] args) {
        Queue<Integer> q = new Queue<>();
        System.out.println(q.isEmpty());
        q.add(1);
        System.out.println(q.isEmpty());
        System.out.println(q.peek());
        q.add(2);
        System.out.println(q.peek());
        System.out.println(q.remove());
        System.out.println(q.peek());
        System.out.println(q.remove());
        System.out.println(q.isEmpty());
        //System.out.println(s.pop());
    }
}
