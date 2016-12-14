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
	  int select = data[counter];
	  total[counter] = smallest;
	  data[indexOf] = select;
      } 
  } 
    
    public static void insertionSort(int[] data){
	int temp = 0;
	for(int counter = 1; counter < data.length; counter++){
	    if (data[counter] > data[counter - 1]){
		counter++;
	    }
	    else{
		temp = data[counter];
		while (temp <= data[counter]){
		    data[counter] = data[counter - 1];
		}
		data[counter] = temp;
	    }
	}
    }
   
    

}
