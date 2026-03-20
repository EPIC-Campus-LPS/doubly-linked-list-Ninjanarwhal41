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
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(1, 30);
        list.add(2, 40);
        assertEquals(30, list.get(1));
        assertEquals(40, list.get(2));
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
        assertEquals(30, list.remove(1));
        assertEquals(20, list.remove(0));
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
        assertEquals(10, list.get(1));
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

    @org.junit.jupiter.api.Test
    void emptyList(){
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
        assertNull(list.remove());
    }

    @org.junit.jupiter.api.Test
    void singleElementRemove() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(42);

        assertEquals(42, list.remove());
        assertTrue(list.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void addAtHead() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(10);
        list.add(0, 5);

        assertEquals(5, list.get(0));
        assertEquals(10, list.get(1));
    }

    @org.junit.jupiter.api.Test
    void addAtTailIndex() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(10);
        list.add(20);
        list.add(2, 30);

        assertEquals(30, list.get(2));
    }

    @org.junit.jupiter.api.Test
    void removeHeadIndex() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(10);
        list.add(20);

        assertEquals(10, list.remove(0));
        assertEquals(20, list.get(0));
    }

    @org.junit.jupiter.api.Test
    void invalidIndex() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(12, 3));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(1, 10));
    }
}