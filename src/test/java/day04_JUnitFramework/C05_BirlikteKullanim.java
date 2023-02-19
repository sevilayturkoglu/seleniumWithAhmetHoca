package day04_JUnitFramework;

import org.junit.*;

public class C05_BirlikteKullanim {
    @BeforeClass
    public static void beforeClass(){
        System.out.println("Before class calisti");
    }@AfterClass
    public static void afterClass(){
        System.out.println("after class calisti");
    }@Before
    public void before(){
        System.out.println("before method calisti");
    }@After
    public void after(){
        System.out.println("after method calisti");
    }
    @Test
    public void test01(){
        System.out.println("test01 calisti");
    }@Test
    public void test02(){
        System.out.println("test02 calisti");
    }@Test
    public void test03(){
        System.out.println("test03 calisti");
    }
}
