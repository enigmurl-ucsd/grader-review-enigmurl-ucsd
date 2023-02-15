import static org.junit.Assert.*;
import org.junit.*;
import java.util.Arrays;
import java.util.*;

class IsMoon implements StringChecker {
  public boolean checkString(String s) {
    return s.equalsIgnoreCase("moon");
  }
}

class StringExample implements StringChecker {
    public boolean checkString(String s) {
        return s.startsWith("Good");
    }
}

public class TestListExamples {
 
    @Test
    public void testFilter() {
        ArrayList<String> x = new ArrayList<>();
        x.add("Good1");
        x.add("Good2");
        assertEquals(x, ListExamples.filter(x, new StringExample()));
    }
    
   @Test(timeout = 500)
    public void testMergeRightEnd() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }

    @Test(timeout = 1000)
    public void testMerge() {
        ArrayList<String> x = new ArrayList<>();
        ArrayList<String> y = new ArrayList<>();
        y.add("Good1");
        assertEquals(y, ListExamples.merge(x,y));
    }

    @Test(timeout = 1000)
    public void testMergeGood() {
        ArrayList<String> x = new ArrayList<>();
        x.add("Good1");
        ArrayList<String> y = new ArrayList<>();
        assertEquals(x, ListExamples.merge(x,y));
    }
}
