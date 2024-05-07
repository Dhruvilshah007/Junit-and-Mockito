package org.luv2code.junitdemo;

import com.luv2code.junitdemo.DemoUtils;
import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


//Unit test structure

//Steps for Unit Test
//Set up -> initializing CLass    DemoUtils demoUtils = new DemoUtils();
//Execute -> calling method       int actual = demoUtils.add(2,4);
//Assert -> assert                assertEquals(6, demoUtils.add(2, 4),"2+4 must be 6");

//test classes are generally not public

//DisplayName are for Displaying names for test.

//@DisplayNameGeneration(DisplayNameGenerator.Simple.class)
//@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
//@DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)

//Order Test case
//@TestMethodOrder(MethodOrderer.DisplayName.class)
//@TestMethodOrder(MethodOrderer.MethodName.class)
//@TestMethodOrder(MethodOrderer.Random.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DemoUtilsTest {



    //Set up
    DemoUtils demoUtils;


    @BeforeEach
    void setupBeforeEach() {
        demoUtils = new DemoUtils();
        System.out.println("@BeforeEach executes before the execution of each test method");
        //BeforeEach->Can be used to create objects, set up test data
    }

    @AfterEach
    void tearDownAfterEach() {
        System.out.println("Running @AfterEach");
        System.out.println();

        //AfterEach->Can be used to release resources,clean up test data
    }


    //By default BeforeAll and AfterAll must be static
    //because they are executed before and after all test methods in the test class. Making them static ensures that they can be called without an instance of the test class being created, which is necessary for these methods to run at the appropriate times. This requirement helps ensure that these methods behave consistently across different test environments and scenarios.
    @BeforeAll
    static void setupBeforeEachClass() {
        System.out.println("@BeforeAll executes only once before all test methods execution in the class");
        //BeforeAll->Can be used get database connections,connect to remote servers
    }

    @AfterAll
    static void tearDownAfterAll() {
        System.out.println("@AfterAll executes only once after all test methods execution in the class");
        //AfterAll->Can be used release database connections,disconnect from remote servers
    }


    @Test
    @DisplayName("Multiply")
    void testMultiple(){

        assertEquals(12,demoUtils.multiply(4,3),"4*3 must be 12");

    }



    @Test
    @DisplayName("Equals and Not Equals")
    @Order(3)
    void testEqualsAndNotEquals() {

        System.out.println("Running test: testEqualsAndNotEquals");

        assertEquals(6, demoUtils.add(2, 4), "2+4 must be 6");
        assertNotEquals(6, demoUtils.add(1, 9), "1+9 must not be 6");
    }

    @Test
    @DisplayName("Null and Not null ")
    @Order(1)
    void testNullAndNotNull() {

        System.out.println("Running test: testNullAndNotNull");

        String str1 = null;
        String str2 = "luv2code";

        assertNull(demoUtils.checkNull(str1), "Object should be null");
        assertNotNull(demoUtils.checkNull(str2), "Object should not be null");

    }

    @Test
    @DisplayName("Same and Not Same ")
    @Order(-4)
    void testSameAndNotSame(){
        String str="luv2code";


        assertSame(demoUtils.getAcademy(),demoUtils.getAcademyDuplicate(),"Objects Should refer to same object");

        assertNotSame(str,demoUtils.getAcademyDuplicate(),"Objects Should not refer to same object");
    }

    @Test
    @DisplayName("True and False")
    void testTrueAndFalse(){
        int gradeOne=10;
        int gradeTwo=5;

        assertTrue(demoUtils.isGreater(gradeOne,gradeTwo),"This should return true");
        assertFalse(demoUtils.isGreater(gradeTwo,gradeOne),"This should return true");

    }

    @Test
    @DisplayName("Array Equals")
    void testArrayEquals(){
       String[] stringArray={"A","B","C"};

       assertArrayEquals(stringArray,demoUtils.getFirstThreeLettersOfAlphabet(),"Arrays should be the same");
    }

    @Test
    @DisplayName("Iterable Equals")
    void testIterableEquals(){
        List<String> theList=List.of("luv","2","code");

        assertIterableEquals(theList,demoUtils.getAcademyInList(),"Expected list should be same as actual list");
    }


    @Test
    @DisplayName("Iterable Equals")
    void testLinesMatch(){
        List<String> theList=List.of("luv","2","code");

        assertLinesMatch(theList,demoUtils.getAcademyInList(),"Lines should match");
    }

    @Test
    @DisplayName("Throws and Doesn't Throw")
    void testThrowsAndDoesNotThrow(){
        assertThrows(Exception.class,()->{demoUtils.throwException((-1));},"Should throw exception");
        assertDoesNotThrow(()->{demoUtils.throwException(9);},"Should not throw exception");
    }

    @Test
    @DisplayName("Timeout")
    void testTimeout(){
       assertTimeoutPreemptively(Duration.ofSeconds(3),()->{demoUtils.checkTimeout();},"Method should execute in 3 seconds");

    }





}

