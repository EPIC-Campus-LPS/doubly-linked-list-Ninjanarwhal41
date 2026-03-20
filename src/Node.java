public class Node<E> {
    private E value;
    private Node<E> previous;
    private Node<E> next;

    public Node(E value){
        this.value = value;
    }

    public Node(E value, Node<E> previous){
        this.value = value;
        this.previous = previous;
    }

    public void setValue(E value){
        this.value = value;
    }

    public E getValue(){
        return value;
    }

    public boolean equals(Node<E> node){
        return value.equals(node.getValue());
    }

    public void setNextNode(Node<E> node){
        next = node;
    }

    public void setPreviousNode(Node<E> node){
        previous = node;
    }

    public Node<E> getNextNode(){
        return next;
    }

    public Node<E> getPreviousNode(){
        return previous;
    }

    @Override
    public String toString() {
        if (previous == null && next == null){
            return value.toString();
        }
        else if (next == null){
            return "Previous node: " + previous.getValue() + " Current node: " + value;

        }
        else if  (previous == null){
            return "Current node: " + value + " Next node: " + next.getValue();
        }
        return "Previous node: " + previous.getValue() + "Current node: " + value + " Next Node: " + next.getValue();
    }

    public static void main(String[] args){
        /*Node<String> first = new Node<>("obtuse");

        Node<String> next = new Node<>("rubber goose");
        first.setNextNode(next);
        next.setPreviousNode(first);

        Node<String> after = new Node<>("guava juice", next);
        next.setNextNode(after);
        System.out.println(after.getPreviousNode().getValue()); // "rubber goose"

        Node<String> last = new Node<>("giant snake");
        System.out.println(next.equals(last)); */
    }
}
