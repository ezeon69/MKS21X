public class OrderedSuperArray extends SuperArray{
  
    public OrderedSuperArray(){
	super();
    }
    
    public OrderedSuperArray(int capacity){
	super(capacity);
    }

    public OrderedSuperArray(String [] ary){
	super(ary.length);
        int counter = 0;
	while (counter < ary.length){
	    add(ary[counter]);
	    counter++;
	}
    }
    
    public int set(int index, int element){
	throw new UnsupportedOperationException();
    }
    
    public void add(int index, int element){
	throw new UnsupportedOperationException();
    }
    
    public boolean add(String element){
	super.add(sortedIndex(element),element);
	return true;
    }

    private int sortedIndex(String element){
	for (int counter = 0; counter < size(); counter++) {
	    if (get(counter).compareTo(element) >= 0) {
		return counter;
	    }
	}
	return size();
    }

}

    
        
