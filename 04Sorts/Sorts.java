public class Sorts{
  /**EDIT THIS METHOD TO MATCH YOUR NAME 
  */
  public static String name(){
    return "06.Luo.Jiajun"; 
  }

  /**Selection sort of an int array. 
  *Upon completion, the elements of the array will be in increasing order.
  *@param data  the elements to be sorted.
  */
  public static void selectionSort(int[] data){  
      for(int counter = 0; counter < data.length - 1; counter++){
	  int smallest = data[counter];
	  int indexOf = counter;
	  for (int counter2 = 0; counter2 < data.length; counter2++){
	      if (data[counter2] < smallest){
		  smallest = data[counter2];
		  indexOf = counter2;
	      }
	  }
	  int switch = data[counter];
	  total[counter] = smallest;
	  data[indexOf] = switch;
      } 
  } 
<<<<<<< HEAD
    
    public static void insertionSort(int[] data){  
	
    }
   
    public static void main (String[] args){
	int test[] = new int[] {40,30,20,10,70,80,61,42,79,95};
	selectionSort(test);
	test.toString();
    }
=======
>>>>>>> f23bdce0635f36fbfcc43defd0b025b5ede8b300
}
