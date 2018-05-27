

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Till Wischniewski
 *
 * @version 1.0
 */

@DisplayName("meineListeTest with three test cases ")
class MeineArrayListTest {

    private MeineArrayList meineListe = new MeineArrayList(2,1);

    @AfterEach
    public void clearList() {
        meineListe.removeAll();
    }

       @Nested
    @DisplayName("empty list")
    class MeineArrayListTestEmptyList {

        @Test
        public void testAddElement() {
            meineListe.addElement(2);
            System.out.println(meineListe);
            assertEquals(1, meineListe.getSize());
        }

        @Test
        public void testRemoveElement() {

            assertEquals(null, meineListe.removeElement(0));
        }
        @Test
        public void testRemoveAll() {
            meineListe.removeAll();

            assertEquals(0, meineListe.getSize());
        }
        @Test
        public void testToString() {

            assertEquals("[null, null]",meineListe.toString());
        }

    }

    @Nested
    @DisplayName("not empty, inside capacity")
    class MeineArrayListTestInsideCapacity {

        @BeforeEach
        public void init() {
            meineListe.addElement(9);
        }

        @Test
        public void testAddElement() {
            meineListe.addElement(2);
            System.out.println(meineListe);
            assertEquals(2, meineListe.getSize());
        }

        @Test
        public void testRemoveElement() {

            assertEquals(9, meineListe.removeElement(0));
        }

        @Test
        public void testRemoveElementOutOfBound() {

            assertEquals(null, meineListe.removeElement(2));
        }

        @Test
        public void testRemoveAll() {
            meineListe.removeAll();

            assertEquals(0, meineListe.getSize());
        }
        @Test
        public void testToString() {

            assertEquals("[9, null]",meineListe.toString());
        }

    }

    @Nested
    @DisplayName("full capacity, increase capacity")
    class MeineArrayListTestFullCapacity {

        @BeforeEach
        public void init() {
            meineListe.addElement(9);
            meineListe.addElement(5);
        }

        @Test
        public void testAddElement() {
            meineListe.addElement(2);
            System.out.println(meineListe);
            assertEquals(3, meineListe.getSize());
        }

        @Test
        public void testRemoveElement() {
            Object removedElement = meineListe.removeElement(1);
            assertEquals(5, removedElement);
            assertNotEquals(2, meineListe.getSize());

        }

        @Test
        public void testRemoveAll() {
            meineListe.removeAll();

            assertEquals(0, meineListe.getSize());
        }
        @Test
        public void testToString() {

            assertEquals("[9, 5]",meineListe.toString());
        }

    }

    @Nested
    @DisplayName("reduce capacity")
    class MeineArrayListTestReduceCapacity {

        @BeforeEach
        public void init() {
            meineListe.addElement(9);
            meineListe.addElement(5);
            meineListe.addElement(4);
        }

        @Test
        public void testAddElement() {
            meineListe.addElement(2);
            System.out.println(meineListe);
            assertEquals(4, meineListe.getSize());
        }

        @Test
        public void testRemoveElement() {
            Object removedElement = meineListe.removeElement(1);
            assertEquals(5, removedElement);
            assertEquals(2, meineListe.getSize());
        }

        @Test
        public void testRemoveAll() {
            meineListe.removeAll();

            assertEquals(0, meineListe.getSize());
        }
        @Test
        public void testToString() {

            assertEquals("[9, 5, 4]",meineListe.toString());
        }

    }

}

