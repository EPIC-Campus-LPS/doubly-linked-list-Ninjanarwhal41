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
        Node<E> newNode = new Node<E>((E) element);
        Node<E> current = head;
        if(i < 0 || i > size()){
            throw new IndexOutOfBoundsException("Index out of Bounds");
        }
        if (i == 0){
            newNode.setNextNode(head);
            head.setPreviousNode(newNode);
            head = newNode;
            return;
        }
        for (int pos = 0; pos < i -1; pos++){
            if (current.getNextNode() == null){
                break;
            }
            current = current.getNextNode();
        }

        newNode.setPreviousNode(current);
        newNode.setNextNode(current.getNextNode());
        current.setNextNode(newNode);
    }

    /**
     * Removes the last element from the list
     */
    @Override
    public Object remove() {
        if (head == null){
            return null;
        }
        if (head == tail){
            Node<E> temp = tail;
            tail.setValue(null);
            head.setValue(null);
            return temp.getValue();
        }
        Node<E> temp = tail;
        tail = tail.getPreviousNode();
        tail.setNextNode(null);
        return temp.getValue();
    }

    /**
     * Remove element at index i
     * If index is invalid, throws IndexOutOfBoundsException
     * @param i index of the element to remove
     * @return the element that was removed
     */
    @Override
    public Object remove(int i) throws IndexOutOfBoundsException {
        E value = null;
        if (i < 0 || i > size() - 1){
            throw new IndexOutOfBoundsException("Index out of Bounds");
        }
        if (i == 0){
            value = head.getValue();
            head = head.getNextNode();
            head.setPreviousNode(null);
            return value;
        }
        Node<E> current = head;
        for (int pos = 0; pos < i; pos++){
            if (current.getNextNode() == null){
                break;
            }
            current = current.getNextNode();
        }

        value = current.getValue();
        current.getPreviousNode().setNextNode(current.getNextNode());
        current.setNextNode(null);
        current.setPreviousNode(null);
        return value;
    }

    /**
     * Gets the element at index i
     * If index is invalid, throws IndexOutOfBoundsException
     * @param i index of the element
     * @return the element
     */
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
    /**
     * Sets the element at i to a new value
     * If index is invalid, throws IndexOutOfBoundsException
     * @param i index of the element to set
     * @param element new value of the element
     */
    @Override
    public void set(int i, Object element) throws IndexOutOfBoundsException {
        int pos = 0;
        Node<E> current = head;
        for (int j = 0; j < i; j++){
            current = current.getNextNode();
        }
        current.setValue((E) element);
    }
    /**
     * Returns the size of the list
     * @return the size of the list
     */
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

    /**
     * Prints out the list in the format [value1, value2, value3, …]
     * @return a String of the list
     */
    @Override
    public boolean isEmpty() {
        return head == null;
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
        System.out.println(list.isEmpty()); //true
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(1, 30);
        list.add(2, 40);
        System.out.println(list.toString()); // [10, 30, 40, 20, 30]

        System.out.println(list.size()); // 5
        System.out.println(list.isEmpty()); // false

        list.remove(); //removes 30
        System.out.println(list.toString()); //[10, 30, 40, 20]
        System.out.println(list.remove()); // 20
        System.out.println(list.toString()); // [10, 30, 40]

        /*

        list.set(0, 20);
        System.out.println(list.get(0)); // 20
        System.out.println(list.toString()); // [20, 30, 40]

        list.add(2, 40); // [20, 30, 40, 40]
        list.add(0, 5); // [5, 20, 30, 40, 40]
        list.set(2, 50); //[5, 20, 50, 40, 40]
        System.out.println(list.toString());

        //list.remove(4);
        //list.remove(2);
        System.out.println(list.size()); // 3
        System.out.println(list.toString()); //[5, 20, 40]

         */
    }
}
