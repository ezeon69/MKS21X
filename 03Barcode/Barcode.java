public class Barcode implements Comparable<Barcode>{
    // instance variables
    private String _zip;
    private int _checkDigit;

    // constructors
    //precondtion: _zip.length() = 5 and zip contains only digits.
    //postcondition: throws a runtime exception zip is not the correct length
    //               or zip contains a non digit
    //               _zip and _checkDigit are initialized.
   public Barcode(String zip) {
       if ((zip.length() == 5) || (zip.matches("[0-9]+"))){
	       _zip = zip;
	       _checkDigit = checkSum() % 10;
	   }
       else{
	   throw new IllegalArgumentException();
       }
   }
   
   // postcondition: computes and returns the check sum for _zip
   private int checkSum(){
       int counter = 0;
       int total = 0;
       while (counter < _zip.length()){
	   total += _zip.charAt(counter) - '0';
	   counter ++;
       }
       return total;
   }
   //toCode method
   public static String toCode(String zip){
       if (!(zip.length() == 5) || !(zip.matches("[0-9]+"))){
	   throw new IllegalArgumentException();
       }
       String total = "|";
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
       if (code.length !== 32){
	   throw new IllegalArgumentException("code length is not 32");
       } //code not length 32
       if ((code[0] !== '|') || (code[code.length] !== '|')){
	   throw new IllegalArgumentException("code does not begin or end with |!");
       }//code does not begin/end with |
       int counter = 0;
       while (counter < code.length){
	   if ((code[counter] !== '|') || (code[counter] !== ':')){
	       throw new IllegalArgumentException("non-barcode characters used");
	   }
	   counter++;
       }//non-barcode characters in code
   }
   // postcondition: compares the zip + checkdigit, in numerical order. 
   public int compareTo(Barcode other){
       return (Integer.valueOf(_zip+_checkDigit)).compareTo(Integer.valueOf(other._zip+other._checkDigit));
   }
    
}
