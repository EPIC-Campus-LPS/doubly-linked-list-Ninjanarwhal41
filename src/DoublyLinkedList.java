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
            pos++;
            if(pos == i){
                current.setNextNode(temp);
                temp.setPreviousNode(current);
                current.setNextNode(temp);
                temp.setPreviousNode(current);
                break;
            }
        }



    }

    /**
     * Removes the last element from the list
     */
    @Override
    public Object remove() {
        if (tail == null){
            return null;
        }

        if (head == tail){
            head = null;
            tail = null;
            return null;
        }

        Node<E> temp = tail;
        tail.setValue(tail.getPreviousNode().getValue());
        tail.setNextNode(null);
        return temp;
    }


    @Override
    public Object remove(int i) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public Node<E> get(int i) throws IndexOutOfBoundsException {

        return null;
    }

    @Override
    public void set(int i, Object element) throws IndexOutOfBoundsException {


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

        return "[" + str + "]";
    }

    public static void main(String[] args){
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        System.out.println(list.isEmpty());
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println(list.toString()); // [10, 20, 30]

        System.out.println(list.size());
        System.out.println(list.isEmpty());

        list.remove(30);
        list.remove(20);
        System.out.println(list.toString());

        /*list.add(2, 40);
        list.add(0, 5);
        list.set(2, 50);
        System.out.println(list.toString()); // [5, 10, 50, 40, 30]

        list.remove(4);
        list.remove(2);
        System.out.println(list.size()); // 3
        System.out.println(list.toString()); // [5, 10, 40]

         */
    }
}
