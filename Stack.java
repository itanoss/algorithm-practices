
public class Stack<T> {
    private class Node {
        private Node next;
        private T data;
    }

    private Node top;

    public T pop() {
        if(top == null) throw new EmptyException();
        T data = top.data;
        top = top.next;
        return data;
    }

    public void push(T data) {
        Node n = new Node();
        n.data = data;
        n.next = this.top;
        this.top = n;
    }

    public T peek() {
        if(top == null) throw new EmptyException();
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public static class EmptyException extends RuntimeException {
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        System.out.println(s.isEmpty());
        s.push(1);
        System.out.println(s.isEmpty());
        System.out.println(s.peek());
        s.push(2);
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.isEmpty());
        //System.out.println(s.pop());
    }
}
