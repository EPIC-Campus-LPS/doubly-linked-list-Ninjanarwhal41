public class DoublyLinkedList<E> implements List{
    Node<E> head;
    Node<E> tail;

    public DoublyLinkedList(){
        head = null;
        tail = null;
    }

    /**
     * Add an element to the end of the list
     * @param element element to add to the list
     */
    @Override
    public void add(Object element) {
        Node<E> temp = new Node<E>((E) element);
        if(tail == null){
            head = temp;
            tail = temp;
        }
        else{
            tail.setNextNode(temp);
            temp.setPreviousNode(tail);
            tail = temp;
        }
    }

    /**
     * Add an element to the list at index i
     * If index is invalid, throws IndexOutOfBoundsException
     * @param i index of the element
     * @param element element to add to the list
     */
    @Override
    public void add(int i, Object element) throws IndexOutOfBoundsException {
        Node<E> temp = new Node<E>((E) element);
        Node<E> current = head;
        int pos = 0;
        while(current.getNextNode() != null){
            current = current.getNextNode();
            pos++;
            if(pos == i){
                break;
            }
        }
        temp.setNextNode(current);
        temp.setPreviousNode(current.getPreviousNode());
        current.getPreviousNode().setNextNode(temp);
        current.setPreviousNode(temp);
    }

    /**
     * Removes the last element from the list
     */
    @Override
    public Object remove() {
        if (head == null){
            return null;
        }
        if(head.getNextNode() == null){
            head = null;
        }
        Node<E> current = head.getNextNode();
        while (current.getNextNode() != null){
            current = current.getNextNode();
        }
        current.getPreviousNode().setNextNode(null);

        return current.getValue();
    }


    @Override
    public Object remove(int i) throws IndexOutOfBoundsException {
        if (head == null){
            return null;
        }
        Node<E> current = head.getNextNode();
        for(int j = 0; j < i; j++){
            if (current.getNextNode() == null){
                break;
            }
            current = current.getNextNode();
        }
        if (current.getPreviousNode() != null){
            current.getPreviousNode().setNextNode(null);

        }
        return current.getValue();
    }

    @Override
    public E get(int i) throws IndexOutOfBoundsException {
        Node<E> current = head;
        for (int j = 0; j < i; j++){
            if (current.getNextNode() == null){
                break;
            }
            current = current.getNextNode();
        }
        return current.getValue();
    }

    @Override
    public void set(int i, Object element) throws IndexOutOfBoundsException {
        int pos = 0;
        Node<E> current = head;
        for (int j = 0; j < i; j++){
            current = current.getNextNode();
        }
        current.setValue((E) element);
    }

    @Override
    public int size() {
        int size = 0;
        Node<E> current = head;
        while (current != null){
            size++;
            current = current.getNextNode();
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null && tail == null;
    }

    public String toString() {
        String str = "";
        Node<E> current = head;
        while (current != null){
            str += current.getValue() + " ";
            current = current.getNextNode();

        }

        return "[" + str.substring(0, str.length() - 1) + "]";
    }

    public static void main(String[] args){
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        System.out.println(list.isEmpty());
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(1, 30);
        list.add(2, 40);
        System.out.println(list.toString()); // [10, 20, 30]

        System.out.println(list.size());
        System.out.println(list.isEmpty());

        list.remove();
        System.out.println(list.remove());
        System.out.println(list.toString());

        list.set(0, 20);
        System.out.println(list.get(0));
        System.out.println(list.toString());

        list.add(2, 40);
        list.add(0, 5);
        list.set(2, 50);
        System.out.println(list.toString()); // [5, 10, 50, 40, 30]

        list.remove(4);
        list.remove(2);
        System.out.println(list.size()); // 3
        System.out.println(list.toString()); // [5, 10, 40]
    }
}
