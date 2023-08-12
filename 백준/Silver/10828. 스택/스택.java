import java.io.*;
import java.util.EmptyStackException;


public class Main {
    static class Node<E> {
        public E data;
        public Node<E> link;

        public Node(E data, Node<E> link) {
            this.data = data;
            this.link = link;
        }
    }

    static class LinkedListStack<E> {
        private Node<E> top;
        private int count = 0;

        public void push(E e) {
            top = new Node<>(e, top);

            count += 1;
        }

        public int pop() {
            if (isEmpty() == 1) {
                return -1;
            }

            Node<E> popped = top;
            top = popped.link;

            count -= 1;

            return (int) popped.data;
        }

        public int peek() {
            if (isEmpty() == 1) {
                return -1;
            }

            return (int) top.data;
        }

        public int size() {
            return count;
        }

        public int isEmpty() {
            if (top == null) {
                return 1;
            }
            else {
                return 0;
            }
        }
    }

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        LinkedListStack<Integer> lls = new LinkedListStack();

        for (int test = 1; test <= N; test++) {
            String[] split = br.readLine().split(" ");

            if (split[0].equals("push")) {
                lls.push(Integer.parseInt(split[1]));
            }
            else if (split[0].equals("pop")) {
                sb.append(lls.pop()).append("\n");
            }
            else if (split[0].equals("top")) {
                sb.append(lls.peek()).append("\n");
            }
            else if (split[0].equals("size")) {
                sb.append(lls.size()).append("\n");
            }
            else if (split[0].equals("empty")) {
                sb.append(lls.isEmpty()).append("\n");
            }
        }

        // 출력
        System.out.println(sb);
    }
}