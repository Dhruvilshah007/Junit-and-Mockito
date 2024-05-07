package com.luv2code.tdd;

//import org.junit.jupiter.api.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FizzBuzzTest {

    //    If number is divisible by 3,print Fizz
    //    If number is divisible by 5,print Buzz
    //    If number is divisible by 3 and 5,print FizzBuzz
    //    If number is not divisible by 3 or 5,then print the number

    @DisplayName("Divisible by Three")
    @Test
    @Order(1)
    void testForDivisibleByThree() {
//        fail(fail);
        String expected = "Fizz";
        assertEquals(expected, FizzBuzz.compute(3), "Should return Fizz");
    }

    @DisplayName("Divisible by Five")
    @Test
    @Order(2)
    void testForDivisibleByFive() {
        String expected = "Buzz";
        assertEquals(expected, FizzBuzz.compute(5), "Should return Buzz");
    }


    @DisplayName("Divisible by Three and Five")
    @Test
    @Order(3)
    void testForDivisibleByThreeAndFive() {
        String expected = "FizzBuzz";
        assertEquals(expected, FizzBuzz.compute(15), "Should return FizzBuzz");
    }

    @DisplayName("Not Divisible by Three or Five")
    @Test
    @Order(4)
    void testForNotDivisibleByThreeOrFive() {
        String expected = "4";
        assertEquals(expected, FizzBuzz.compute(4), "Should return Number");
    }


    //Parameterized Test(Running test for multiple test cases)

    @DisplayName("Testing with csv data")
    @ParameterizedTest(name = "value={0},expected={1}") //Name of loop invocation
//    @ParameterizedTest
    @CsvSource({
            "1,1", "2,2", "3,Fizz", "4,4", "5,Buzz", "6,Fizz", "7,7"
    })
    @Order(5)
    void testCsvData(int value, String expected) {
        assertEquals(expected, FizzBuzz.compute(value));
    }

    @DisplayName("Testing from Small CSV file data")
    @ParameterizedTest(name = "value={0},expected={1}")
    @CsvFileSource(resources = "/fizzbuzz-csv-data.csv")
    @Order(6)
    void testFromCsvFileSmallDataset(int value, String expected) {
        assertEquals(expected, FizzBuzz.compute(value));
    }

    @DisplayName("Testing from Medium CSV file data")
    @ParameterizedTest(name = "value={0},expected={1}")
    @CsvFileSource(resources = "/medium-test-data.csv")
    @Order(7)
    void testFromCsvFileMediumDataset(int value, String expected) {
        assertEquals(expected, FizzBuzz.compute(value));
    }

    @DisplayName("Testing from Large CSV file data")
    @ParameterizedTest(name = "value={0},expected={1}")
    @CsvFileSource(resources = "/large-test-data.csv")
    @Order(8)
    void testFromCsvFileLargeDataset(int value, String expected) {
        assertEquals(expected, FizzBuzz.compute(value));
    }
}
