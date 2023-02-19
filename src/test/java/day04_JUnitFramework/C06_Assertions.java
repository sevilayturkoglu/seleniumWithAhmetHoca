package day04_JUnitFramework;

import org.junit.Assert;
import org.junit.Test;

public class C06_Assertions {
    String str1 = "Ali";
    String str2 = "ali";

    @Test
    public void test01() {
        Assert.assertEquals("esit degil",str1,str2);
        if (str1.equals(str2)) {

            System.out.println("esit pass");
        } else {
            System.out.println("esit degil fail");
        }
    }

    @Test
    public void test02() {
Assert.assertTrue(str1.contains("A"));
        if (str1.contains("A")) {

            System.out.println("olumlu pass");
        } else {
            System.out.println("olumlu degil fail");
        }
    }

    @Test
    public void test03() {
Assert.assertFalse(str2.contains("c"));
        if (!str2.contains("c")) {

            System.out.println("negatif pass");
        } else {
            System.out.println("negatif degil fail");
        }
    }
}