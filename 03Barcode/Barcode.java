public class Barcode implements Comparable<Barcode>{
    // instance variables
    private String _zip;
    private int _checkDigit;
    private static String[] helper = { "||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::" };

    
    public Barcode(String zip) {
	if ((zip.length() == 5) || (zip.matches("[0-9]+"))){
	    _zip = zip;
	    _checkDigit = checkSum(zip) % 10;
	}
	else{
	    throw new IllegalArgumentException("zipcode not length 5 or contains illegal characters");
	}
    }
   
    // postcondition: computes and returns the check sum for _zip
    private static int checkSum(String x){
	int counter = 0;
	int total = 0;
	while (counter < x.length()){
	    total += x.charAt(counter) - '0';
	    counter ++;
       }
       return total;
    }
    private static int helperDigit(String x){	
	for (int counter = 0; counter < helper.length; counter++) {
	    if (helper[counter].equals(x)){
		return counter;
	    }
	}
	    throw new IllegalArgumentException("Encoded ints are invalid or non-barcode characters are used.");
    }

 

    private static int checkSumCode(String code) {
	int total = 0;
	for (int counter = 0; counter < code.length() - 4; counter += 5) {
	    total += helperDigit(code.substring(counter,counter+5));       
	}
	return total;
    }
	
    //toCode method
    public static String toCode(String zip){
	if (!(zip.length() == 5) || !(zip.matches("[0-9]+"))){
	   throw new IllegalArgumentException();
	}
	zip += checkSum(zip) % 10;
	String total = "|";
	for (int counter = 0; counter < zip.length(); counter++) {
	    total += helper[zip.charAt(counter) - '0'];
	}
        return total + "|";
	}
   
   //postcondition: format zip + check digit + barcode 
   //ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"      
   public String toString(){
       String total = _zip + _checkDigit + " |";
       for (int counter = 0; counter < _zip.length(); counter++) {
	   char c = _zip.charAt(counter);
	   switch (c) {
	   case '0': total += "||:::";
	       break;	           	    
	   case '1': total += ":::||";
	       break;
	   case '2': total += "::|:|";
	       break;
	   case '3': total += "::||:";
	       break;
	   case '4': total += ":|::|";
	       break;
	   case '5': total += ":|:|:";
	       break;
	   case '6': total += ":||::";
	       break;
	   case '7': total += "|:::|";
	       break;
	   case '8': total += "|::|:";
	       break;
	   case '9': total += "|:|::";
	       break;
	    default: break;
	    }
	}
	return total + "|";
   }

   public static String toZip(String code){ 
       if (code.length() != 32){
	   throw new IllegalArgumentException("code length is not 32");
       } //code not length 32
       if ((code.charAt(0) != '|') || (code.charAt(code.length()-1) != '|')){
	   throw new IllegalArgumentException("code does not begin or end with |!");
       }//code does not begin/end with |
       int counter = 0;
       while (counter < code.length()){
	   if ((code.charAt(counter) != '|') || (code.charAt(counter) != ':')){
	       throw new IllegalArgumentException("non-barcode characters used");
	   }
	   counter++;
       }//non-barcode characters in code
       if (checkSumCode(code.substring(1,26))%10 != helperDigit(code.substring(26,31))) {
	   throw new IllegalArgumentException("checksum is invalid");
       }
       String total = "";
        for (int i = 1; i < code.length() - 6; i += 5) {
	    total += helperDigit(code.substring(i,i+5));       
	}
	return total + checkSum(total) % 10;    
   }
   // postcondition: compares the zip + checkdigit, in numerical order. 
   public int compareTo(Barcode other){
       return (Integer.valueOf(_zip+_checkDigit)).compareTo(Integer.valueOf(other._zip+other._checkDigit));
   }
    
}
