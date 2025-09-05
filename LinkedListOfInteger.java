public class LinkedListOfInteger {

    private Node head;
    private Node tail;
    private int count;

    private class Node {
        public Integer element;
        public Node next;

        public Node(Integer element) {
            this.element = element;
            this.next = null;
        }

        public Node(Integer element, Node next) {
            this.element = element;
            this.next = next;
        }

    }

    public LinkedListOfInteger() {// O(1)

        head = null;
        tail = null;
        count = 0;

    }

    public boolean isEmpty() {// O(1)
        return (head == null);
    }

    public int size() {// O(1)
        return count;
    }

    public void clear() {// O(1)
        head = null;
        tail = null;
        count = 0;
    }

    @Override
    public String toString() {// O(n)
        StringBuilder s = new StringBuilder();
        Node aux = head;
        while (aux != null) {
            s.append(aux.element.toString());
            s.append("\n");
            aux = aux.next;
        }
        return s.toString();
    }

    public void add(Integer element) {// O(1)

        Node n = new Node(element);

        if (head == null) {
            head = n;

        } else {
            tail.next = n;

        }

        tail = n;

        count++;

    }

    public boolean contains(Integer element) { // O(n)

        Node aux = head;

        while (aux != null) {
            if (aux.element.equals(element)) {
                return true;
            }

            aux = aux.next;

        }

        return false;

    }

    public Integer get(int index) {

        if (index >= size()) {

            throw new IndexOutOfBoundsException("ERRO" + index);

        }

        if (index == size() - 1) {

            return tail.element;

        }

        Node aux = head;

        int count_aux = 0;

        while (count_aux < index) {

            aux = aux.next;

            count_aux++;
        }

        return aux.element;

    }

    public int IndexOf(Integer element) {

        Node aux = head;

        int count_aux = 0;

        while (aux != null) {

            if (aux.element.equals(element)) {
                return count_aux;
            }

            aux = aux.next;
            count_aux++;

        }

        return -1;

    }

    public void add(int index, Integer element) {
        if (index >= size() || index < 0) {

            throw new IndexOutOfBoundsException("ERRO" + index);

        }

        Node n = new Node(element);

        if (index == 0) {
            if (head == null) {
                head = n;
                tail = n;
            }

            n.next = head;
            head = n;
        } else if (index == count) {
            tail.next = n;
            tail = n;
        } else {

            Node aux = head;

            for (int i = 0; i < index - 1; i++) {

                aux = aux.next;

            }

            n.next = aux.next;
            aux.next = n;

        }

        count++;

    }

    public boolean remove(Integer element) {
        if (count == 0) {
            return false;
        }

        if (head.element.equals(element)) {

            if (count == 1) {
                tail = null;
            }
            head = head.next;
            count--;
            return true;
        }

        Node ant = head;
        Node aux = head.next;

        for (int i = 1; i < count; i++) {

            if (aux.element.equals(element)) {
                if (aux == tail) {
                    tail = ant;
                    tail.next = null;
                } else {
                    ant.next = aux.next;
                }

                count--;
            }

            ant = ant.next;
            aux = aux.next;

        }

        return false;

    }

    public Integer set(int index, Integer element) {

        if (index >= size() || index < 0) {

            throw new IndexOutOfBoundsException("ERRO" + index);

        }

        if (index == count - 1) {

            Integer deleted_element = tail.element;

            tail.element = element;

            return deleted_element;

        } else {

            Node aux = head;

            for (int i = 0; i < index; i++) {

                aux = aux.next;

            }

            Integer deleted_element = aux.element;

            aux.element = element;

            return deleted_element;
        }

    }

    public Integer removeByIndex(int index) {

        if (index >= size() || index < 0) {

            throw new IndexOutOfBoundsException("ERRO" + index);

        }

        if (index == 0) {

            if (count == 1) {
                tail = null;
            }
            Integer deleted_element = head.element;
            head = head.next;
            count--;
            return deleted_element;
        }

        Node ant = head;
        Node aux = head.next;

        for (int i = 1; i < index; i++) {

            if (aux == tail) {
                Integer deleted_element = tail.element;
                tail = ant;
                tail.next = null;
                count--;
                return deleted_element;

            }

            ant = ant.next;
            aux = aux.next;

        }

        Integer deleted_element = aux.element;
        ant.next = aux.next;
        count--;
        return deleted_element;

    }

}