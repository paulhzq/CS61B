import static org.junit.Assert.*;
import org.junit.Test;

public class TestLinkedListDeque1B {
    @Test
    public void TestIsEmpty() {
      StudentLinkedListDeque<Integer> saq1 = new StudentLinkedListDeque<Integer>();
      boolean result=saq1.isEmpty();
      assertEquals(true,result);
    }

    @Test
    public void TestAddFrist() {
      StudentLinkedListDeque<Integer> saq1 = new StudentLinkedListDeque<Integer>();
      saq1.addFirst(5);
      int size = saq1.size();
      //int item = saq1.get(0);
      assertEquals(1,size);
      //assertEquals(5,item);
    }
    @Test
    public void TestAddFrist2() {
      StudentLinkedListDeque<Integer> saq1 = new StudentLinkedListDeque<Integer>();
      saq1.addFirst(5);
      int item = saq1.get(0);
      assertEquals(5,item);
    }

    @Test
    public void TestAddFirst3(){
      StudentLinkedListDeque<Integer> saq1 = new StudentLinkedListDeque<Integer>();
      saq1.addFirst(5);
      saq1.addFirst(10);
      int item = saq1.get(1);
      assertEquals(5,item);
    }

    @Test
    public void TestAddFirst4(){
      StudentLinkedListDeque<Integer> saq1 = new StudentLinkedListDeque<Integer>();
      saq1.addFirst(5);
      saq1.addFirst(10);
      int item = saq1.get(0);
      assertEquals(10,item);
    }

    @Test
    public void TestAddLast(){
      StudentLinkedListDeque<Integer> saq1 = new StudentLinkedListDeque<Integer>();
      saq1.addLast(5);
      int item = saq1.get(0);
      assertEquals(5,item);
    }

    @Test
    public void TestAddLast2(){
      StudentLinkedListDeque<Integer> saq1 = new StudentLinkedListDeque<Integer>();
      saq1.addLast(5);
      saq1.addLast(10);
      int item = saq1.get(1);
      assertEquals(10,item);
    }

    @Test
    public void TestAddLast3(){
      StudentLinkedListDeque<Integer> saq1 = new StudentLinkedListDeque<Integer>();
      saq1.addLast(5);
      saq1.addLast(10);
      saq1.addFirst(3);
      int item = saq1.get(2);
      assertEquals(10,item);
    }

    @Test
    public void TestAddLast4(){
      StudentLinkedListDeque<Integer> saq1 = new StudentLinkedListDeque<Integer>();
      saq1.addLast(5);
      saq1.addLast(10);
      int item = saq1.get(1);
      assertEquals(10,item);
    }

    @Test
    public void TestRemoveFirst(){
      StudentLinkedListDeque<Integer> saq1 = new StudentLinkedListDeque<Integer>();
      Integer result =saq1.removeFirst();
      assertEquals(null,result);
    }

    @Test
    public void TestRemoveFirst2(){
      StudentLinkedListDeque<Integer> saq1 = new StudentLinkedListDeque<Integer>();
      saq1.addFirst(1);
      saq1.addFirst(2);
      saq1.addFirst(3);
      saq1.addLast(0);
      saq1.addFirst(4);
      int result =saq1.removeFirst();
      assertEquals(4,result);
    }

    @Test
    public void TestRemoveFirst3(){
      StudentLinkedListDeque<Integer> saq1 = new StudentLinkedListDeque<Integer>();
      saq1.addLast(1);
      saq1.addLast(2);
      saq1.addLast(3);
      saq1.addLast(4);
      int result =saq1.removeFirst();
      assertEquals(1,result);
    }

    @Test
    public void TestRemoveLast(){
      StudentLinkedListDeque<Integer> saq1 = new StudentLinkedListDeque<Integer>();
      Integer result =saq1.removeLast();
      assertEquals(null,result);
    }

    @Test
    public void TestRemoveLast2(){
      StudentLinkedListDeque<Integer> saq1 = new StudentLinkedListDeque<Integer>();
      saq1.addLast(1);
      saq1.addLast(2);
      saq1.addLast(3);
      saq1.addLast(4);
      int result =saq1.removeLast();
      int a =saq1.get(0);
      assertEquals(4,result);
      assertEquals(1,a);
    }
    /*Test the array resize if size==array.length*/
    @Test
    public void TestArrayResize() {
      StudentLinkedListDeque<Integer> saq1 = new StudentLinkedListDeque<Integer>();
      saq1.addLast(1);
      saq1.addLast(2);
      saq1.addLast(3);
      saq1.addLast(4);
      saq1.addLast(5);
      saq1.addLast(6);
      saq1.addLast(7);
      saq1.addLast(8);
      saq1.addLast(9);
      int size = saq1.size();
      assertEquals(9,size);
    }

    @Test
    public void TestArrayResize2() {
      StudentLinkedListDeque<Integer> saq1 = new StudentLinkedListDeque<Integer>();
      saq1.addLast(1);
      saq1.addLast(2);
      saq1.addLast(3);
      saq1.addLast(4);
      saq1.addLast(5);
      saq1.addLast(6);
      saq1.addLast(7);
      saq1.addLast(8);
      saq1.addLast(9);
      saq1.removeFirst();
      saq1.removeFirst();
      int result = saq1.get(0);
      assertEquals(3,result);
    }

    /*this is the bug found,when double size the array,run this test should getthe 17 but actually get 16.*/
    @Test
    public void TestArrayResize3() {
      StudentLinkedListDeque<Integer> saq1 = new StudentLinkedListDeque<Integer>();
      for(int i =1;i<=20;i++) {
        saq1.addLast(i);
      }
      for(int i=1;i<=16;i++){
        saq1.removeFirst();
      }
      int result =saq1.get(0);
      assertEquals(17,result);
    }

    @Test
    public void TestArrayResize4() {
      StudentLinkedListDeque<Integer> saq1 = new StudentLinkedListDeque<Integer>();
      for(int i =1;i<=20;i++) {
        saq1.addFirst(i);
      }
      for(int i=1;i<=16;i++){
        saq1.removeLast();
      }
      int size = saq1.size();
      assertEquals(4,size);
      int result =saq1.get(3);
      assertEquals("Oh noooo!\nThis is bad:\n resize and get the first number " + result
                   + " not equal to " + "17" + "!",
                   17, result);
    }





    public static void main(String... args) {
          jh61b.junit.TestRunner.runTests("all", TestLinkedListDeque1B.class);
    }

}
