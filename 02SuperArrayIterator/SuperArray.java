public class SuperArray{
    private String[] data;
    private int size;
    
    public SuperArray(){
	data = new String[10];
	size = 0;
    }
    
    public SuperArray(int initialCapacity){
	if (initialCapacity < 0){
	    throw new IllegalArgumentException("Specified initial capacity less than 0");
	}
	data = new String[initialCapacity];
        size = 0;
    }
    
    public SuperArray(String[] ary){
	data = new String[ary.length];
		
        for (int counter = 0; counter < ary.length; counter++){
            data[counter] = ary[counter];
        }
    }
    
    //0
    //constructor make an empty superArray should make size 0, 
    //but the data capacity 10.

    public int size(){
	return size;
    }

    public void clear(){
	size = 0;
    }
    //1
    /*add the value n to the next available slot in the superArray.
     *this will change the size. This function should always work
     *And will resize the SuperArray if needed.*/

    /* public void add(int element){
	if (size() == data.length){
	    grow();
	}
	data[size() - 1] = n;
	size ++;
	}*/

    public boolean add(String element) {
	add(size,element);
	return true;
    }
    
    public void add(int index, String element) {
	if(index < 0 || index > size()) {
	    throw new IndexOutOfBoundsException();
	}
	if(size() == data.length) {
	    grow();
	}	   
	
	for(int i = size(); i > index; i--) {
	    data[i] = data[i - 1];
	}
	data[index] = element;
	size++;
    }
	

    //2
    /**Resize the data, by making a new array, then copying over 	    elements, use this as your data.
     */

    private void grow(){
	int bigSize;
	int counter = 0;
	if (size == 0){

	bigSize = 2;
	  }
	else{
	   bigSize = size * 2;
	}
	String newArr[] = new String[bigSize];
	while (counter < newArr.length){
	 newArr[counter] = data[counter];
	counter += 1;
	}
	data = newArr;
    }

    //3
    /**format the super array like this :   [ 1, 3, 6, 8, 23, 99, 	    -4, 	5] 
    *commas between... square bracket start/end and no comma at 	    end.*/
    /*public String toString(){
        String total = "[";
	for(int i = 0; i < size ; i++) {
	    if(i == size - 1) {
		return total + data[i] + "]";
	    }
	    total += data[i] + ", ";
	}
	return total + "]";
	}  */


    //4
    /**format the super array like this :   [ 1, 8, 23, 99, -4, 	    5, _, _, _, _]   
    *(capacity is 10, but only 6 are used)
    *commas between... square bracket start/end and no comma at 	    end.
    *unused slots should be printed as _ (underscores) */
    /*public String toStringDebug(){
	String total = "[";
	int counter = 0;
	while (counter < data.length){
	    if (data[counter] == 0){
	total = total + " _,";
	    }
	    else {
	total = total + " " + data[counter] + ",";
	    }
	    counter ++;
	}
	total += "]";
	return total;
	}*/
	
    public boolean isEmpty(){
	return size == 0;
    }

    public String set(int index, String element){
	if ((index < 0) || (index >= size())){
	    throw new IndexOutOfBoundsException("index is less than 0 or greater than size");
	}
        String copy = data[index];
	data[index] = element;
	return copy;
    }
    
    public String get(int index){
	if ((index < 0) || (index >= size())){
	    throw new IndexOutOfBoundsException("index is less than 0 or greater than size");
	}
	return data[index];
    }

    public String remove(int index){
	if ((index < 0) || (index >= size())){
	    throw new IndexOutOfBoundsException("index is less than 0 or greater than size");
	}
	String total = data[index];
	while (index < size - 1){
	    data[index] = data[index+1];
	    index ++;
	}
	size --;
	return total;
    }

    public String[] toArray() {
	String[] total = new String[size];
	for(int i = 0; i < size; i++){
	    total[i] = data[i];
	}
	return total;
    }

    public int indexOf(String i){
	int counter = 0;
	while (counter < data.length){
	    if (data[counter] == i){
	return counter;
	    }
	    counter++;
	}
	return -1;
    }

    public int lastIndexOf(String i){
        for (int counter = size()-1; counter >= 0; counter--){
	    if (data[counter].equals(i)){
		return counter;
	    }
	}
	return -1;
    }

}
