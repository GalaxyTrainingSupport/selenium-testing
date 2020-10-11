package pe.edu.galaxy.listeners;

import org.junit.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(pe.edu.galaxy.listeners.ListenerTestNG.class)
public class ListenersDemo2 {
  @Test
  public void test_6() {
	  System.out.println("Running test 6");
	  Assert.assertTrue(false);
  }
  @Test
  public void test_4() {
	  System.out.println("Running test 4");
	  throw new SkipException("this method not implemented yet");
  }
  @Test
  public void test_5() {
	  System.out.println("Running test 5");
  }
  
}
