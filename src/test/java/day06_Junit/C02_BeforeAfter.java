package day06_Junit;

import org.junit.*;

public class C02_BeforeAfter {
    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Tum class'dan once tek bir sefer calisir");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Her Methoddan once bir kez calisir");
    }

    @Test
    public void test01() {
        System.out.println("Test01 Calisti");
    }@Test
    public void test02() {
        System.out.println("Test02 Calisti");
    }@Test
    public void test03() {
        System.out.println("Test03 Calisti");
    }@Test
    public void test04() {
        System.out.println("Test04 Calisti");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Her Methoddan sonra bir kez calisir");
    }

    @AfterClass
    public static void afterClass() throws Exception {

    }
}
