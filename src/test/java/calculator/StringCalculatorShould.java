package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorShould {
  
    StringCalculator calculator=new StringCalculator();	
    
    // to check for empty input
    @Test
    void empty_string_should_return_0() throws Exception {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(0, stringCalculator.add(""));
    }
    // to check for 1 input 
    @Test
    void string_with_single_number_should_return_number_as_int() throws Exception {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(1, stringCalculator.add("1"));
    }
    // to check for 2 input and delimiter ,
    @Test
    public void addTwoNumberIsSumOfNumbers() throws Exception {
        StringCalculator calculator = new StringCalculator();
        assertEquals(3, calculator.add("1,2"));
    }
    // to check unknown amount of number 
    @Test
    public void addUnknownAmountOfNumber() throws Exception {
        StringCalculator calculator = new StringCalculator();
        assertEquals(13, calculator.add("1,2,5,3,2"));

    }
    // to check and accept new line character
    @Test
	public void acceptNewline() throws Exception
	{
		assertEquals(6, calculator.add("1\n2,3"));
	}
    // to check and support multiple delimiters
    @Test
	public void anyDelimeter() throws Exception
	{
		assertEquals(3, calculator.add("//;\n1;2"));
	}
    // to check for a single negative number;
    @Test
    public void throwExceptionIfNegativeNumber() {
        try {
            calculator.add("//;\n1;-2;5");
        }catch (Exception e) {
            assertEquals("negatives not allowed: [-2]", e.getMessage());
        }
    }
   //To check for a multiple negative number
    @Test
	public void multipleNegativeNumbers() throws Exception
	{
		try {
			calculator.add("-1,-2,3");
		}
		
		catch(Exception e)
		{
			assertEquals("negatives not allowed: [-1, -2]", e.getMessage());
		}
	}
    // To check no of calls to add method 
    @Test
	public void validateCallCount()
	{
		assertEquals(calculator.getCallCount(),calculator.count);
	}
    
    // To check no greater than 1000 
    @Test
	public void ignoreNumsGrtThn1000() throws Exception
	{
		assertEquals(2,calculator.add("2,1001"));
	}
    
    @Test
	public void validateAnyLengthDelimeter() throws Exception
	{
		assertEquals(6, calculator.add("//[***]\n1***2***3"));
	}
    @Test
	public void multipleDelimeter() throws Exception
	{
		assertEquals(6, calculator.add("//[*][%]\n1*2%3"));
	}
    @Test
	public void mulCustomDelWithAnyLength() throws Exception
	{
		assertEquals(6, calculator.add("//[**][%%]\n1**2%%3"));
	}
}
