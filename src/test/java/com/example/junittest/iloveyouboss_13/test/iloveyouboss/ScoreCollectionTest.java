/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/utj2 for more book information.
***/
package com.example.junittest.iloveyouboss_13.test.iloveyouboss;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import com.example.junittest.iloveyouboss_13.src.iloveyouboss.ScoreCollection;
import org.junit.*;

public class ScoreCollectionTest {
   @Test
   public void answersArithmeticMeanOfTwoNumbers() {
      ScoreCollection collection = new ScoreCollection();
      collection.add(() -> 5);
      collection.add(() -> 7);
      
      int actualResult = collection.arithmeticMean();
      
      assertThat(actualResult, equalTo(6));
   }
}
