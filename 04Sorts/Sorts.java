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
      int smallest = 0;
      int total[] = new int[data.length];
      for(int counter = 0; counter < data.length; counter++){
	  for (int counter2 = 0; counter2 < data.length; counter2++){
	      if (counter2 == 0){
		  smallest = data[counter2];
	      }
	      if (data[counter2] < smallest){
		  smallest = data[counter2];
	      }
	  }
	  total[counter] = smallest;
      } 
  } 
    
    public static void insertionSort(int[] data){  
	
    }
   
    public static void main (String[] args){
	int test[] = new int[] {40,30,20,10,70,80,61,42,79,95};
	selectionSort(test);
	test.toString();
    }
}
