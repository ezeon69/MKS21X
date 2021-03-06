import java.util.*;

public class SuperArrayIterator implements Iterator<String>{
    
    private SuperArray data;
    private int element = 0;

    public SuperArrayIterator(SuperArray ary){
	data = ary;
    }

    public boolean hasNext(){
        return element < data.size();
    }

    public String next(){
	if (hasNext()){
	    String total = data.get(element);
	    element++;
	    return total;
	}
	else{
	    throw new NoSuchElementException();
	}
    }
	
    public void remove(){
	throw new UnsupportedOperationException();
    }
}
class SuperArray implements Iterable<String>{
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

    public int size(){
	return size;
    }

    public void clear(){
	size = 0;
    }

    public boolean add(String element){
	if (size() == data.length){
	    grow();
	}

	data[size()] = element;
	size++;
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
	
    private void grow(){
	int counter = 0;
	String newArr[] = new String[data.length*2];
	while (counter < newArr.length){
	 newArr[counter] = data[counter];
	counter += 1;
	}
	data = newArr;
    }

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
    
    public Iterator<String> iterator(){
	return new SuperArrayIterator(this);
    }
}
