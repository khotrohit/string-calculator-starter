package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorShould {
  
    StringCalculator calculator=new StringCalculator();	
    
    // to check for empty input
    @Test
    void empty_string_should_return_0() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(0, stringCalculator.add(""));
    }
    // to check for 1 input 
    @Test
    void string_with_single_number_should_return_number_as_int() {
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
	public void acceptNewline()
	{
		assertEquals(6, calculator.add("1\n2,3"));
	}
    // to check and support multiple delimiters
    @Test
	public void anyDelimeter()
	{
		assertEquals(3, calculator.add("//;\n1;2"));
	}

}
