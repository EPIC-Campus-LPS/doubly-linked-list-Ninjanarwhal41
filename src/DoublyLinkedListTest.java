import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {

    @org.junit.jupiter.api.Test
    void add() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(1);
        list.add(2);
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
    }

    @org.junit.jupiter.api.Test
    void testAdd() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(1, 10);
        list.add(2, 20);
        list.add(0, 30);
        assertEquals(10, list.get(1));
        assertEquals(20, list.get(2));
        assertEquals(30, list.get(0));
    }

    @org.junit.jupiter.api.Test
    void remove() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        assertEquals(30, list.remove());
        assertEquals(20, list.remove());
        assertEquals(10, list.remove());


    }

    @org.junit.jupiter.api.Test
    void testRemove() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(20);
        list.add(2);
        list.add(30);
        assertEquals(2, list.remove(1));
        assertEquals(30, list.remove(2));
    }

    @org.junit.jupiter.api.Test
    void get() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(1);
        assertEquals(1, list.get(0));
    }

    @org.junit.jupiter.api.Test
    void set() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(10);
        list.add(20);
        list.set(1, 10);
        assertEquals(10, list.get(0));
    }

    @org.junit.jupiter.api.Test
    void size() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        assertEquals(3, list.size());
    }
    @org.junit.jupiter.api.Test
    void isEmpty() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove();
        list.remove();
        assertFalse(list.isEmpty());
        list.remove();
        assertTrue(list.isEmpty());
    }
}