package pe.edu.galaxy.listeners;

import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(pe.edu.galaxy.listeners.ListenerTestNG.class)
public class ListenersDemo {
  @Test
  public void test_1() {
	  System.out.println("Running test 1");
  }
  @Test
  public void test_2() {
	  System.out.println("Running test 2");
  }
  @Test
  public void test_3() {
	  System.out.println("Running test 3");
  }
  
}
