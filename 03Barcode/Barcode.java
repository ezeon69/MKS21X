public class BarCode implements Comparable<Barcode>{
    // instance variables
    private String _zip;
    private int _checkDigit;

    // constructors
    //precondtion: _zip.length() = 5 and zip contains only digits.
    //postcondition: throws a runtime exception zip is not the correct length
    //               or zip contains a non digit
    //               _zip and _checkDigit are initialized.
   public BarCode(String zip) {
       if (zip.length() == 5) || (zip.matches("[0-9]+")){
	       _zip = zip;
	       _checkDigit = sumDigits(zip) % 10; //placeholder
	   }
       else{
	   throw new RunTimeException();
       }
   }
   
   //sumDigits
   public int sumDigits(String x){
       int total = 0;
       int counter = 0;
       while (counter < x.length){
	   total += x[counter];
	   counter++;
       }
       return total;
   }
   //switch
   int num = 0;
   switch(num){
   case '0' :
       num = ||:::;
       break;
   case '1' :
       num = :::||;
       break;
   case '2' :
       num = ::|:|;
       break;
   case '3' :
       num = ::||:;
       break;
   case '4' :
       num = :|::|;
   case '5' :
       num = :|:|:;
       break;
   case '6' :
       num = :||::;
       break;
   case '7' :
       num = |:::|;
       break;
   case '8' :
       num = |::|:;
       break;
   case '9' :
       num = |:|::;
       break;
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
	   total += _zip[counter];
	   counter ++;
       }
       return total;
   }
   
   //postcondition: format zip + check digit + barcode 
   //ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"      
   public String toString(){
       String total = "|";
   }


   // postcondition: compares the zip + checkdigit, in numerical order. 
   public int compareTo(Barcode other){

   }
   
}
