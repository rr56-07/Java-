import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListOpsTest {
    ListOps listManager = new ListOps();
    List<Integer> list = new ArrayList<>();
    @Test
    public void testAddElement() {
        listManager.addElement(list, 10);
        listManager.addElement(list, 20);

        assertTrue(list.contains(10));
        assertTrue(list.contains(20));
        assertEquals(2, listManager.getSize(list));
    }

    @Test
    public void testRemElement(){
        listManager.removeElement(list,10);
        assertFalse(list.contains(10));
    }
    @Test
    public void testSizeofList(){
        listManager.addElement(list, 10);
        listManager.addElement(list, 20);
        listManager.removeElement(list,10);
        assertEquals(1,listManager.getSize(list));
    }
}