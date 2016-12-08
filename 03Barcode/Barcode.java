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
	   throw new RuntimeException();
       }
   }

   // postcondition: Creates a copy of a bar code.
   public Barcode clone(){
       Barcode copy = new Barcode(_zip);
       return copy;
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
   
   //postcondition: format zip + check digit + barcode 
   //ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"      
   public String toString(){
       String total = _zip + _checkDigit + "  |";
       for (int i = 0; i < _zip.length(); i++) {
	   char c = _zip.charAt(i);
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


   // postcondition: compares the zip + checkdigit, in numerical order. 
   public int compareTo(Barcode other){
       return (Integer.valueOf(_zip+_checkDigit)).compareTo(Integer.valueOf(other._zip+other._checkDigit));
   }
    
}
