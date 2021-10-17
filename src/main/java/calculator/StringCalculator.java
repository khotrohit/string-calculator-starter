package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



class StringCalculator {

    static int count=0;

	public int add(String input) throws StringCalculatorException {
    	//if string is empty it returns 0
    	int sum=0;
       List<Integer> list =new ArrayList<>();
       if(input.isEmpty())
    	    return 0;
       else {
    	   if(input.length()==1)
    	      return Integer.parseInt(input);   //if string length is 1 it returns first element converted to integer
    	   else {
    		   //these will check for 2 or more numbers
    		   String[] nums = StringCalculator.split(input);
    		   
    		   for (String num : nums) {
    			   //check for negative
    			   if (Integer.parseInt(num) < 0) {
                       list.add(Integer.parseInt(num));
                   }
    			   else if(Integer.parseInt(num)>1000)
    				   num="0";
    	            sum += Integer.parseInt(num);
    	        }
    		   if(list.size()>0)
    			   throw new StringCalculatorException("negatives not allowed: "+list.toString());
    		   return sum;
    	   }
         }
      }
    private static String[] split(String str)
	{   // to allow Support different delimiters
    	 if(str.startsWith("//["))
			return splitMulCustomDelWithAnyLength(str);
    	 else if (str.startsWith("//")) {
             String delimiter = str.substring(2, 3);
             return str.substring(4).split(delimiter);
    	 }
    	 else {
    		 String[] nums = str.split(",|\n");  // /n added to use /n as delimiter
    			return nums;
    	 }
	}
    
    //count no of calls to add 
    public static int getCallCount()
	{
		return count;
	}
    
    private static String[] splitMulCustomDelWithAnyLength(String str)
	{
		Matcher m = Pattern.compile("//(\\[.+\\])+\n(.*)").matcher(str);
		m.matches();
		String del = m.group(1);
		String delimeters = new String();
		
		int l = del.length(),last =0;
		for(int i =0; i<l ; i++)
		{
			if(del.charAt(i) == ']' && i != l-1)
			{	
				delimeters += del.substring(last,i);
				delimeters += "]|";
				last = i+1;
				
			}
			
			else if(i == l-1)
				delimeters += del.substring(last,i) + "]";
		}
		String nums = m.group(2);
		
		return nums.split(delimeters); 
		
		
	}
   
}