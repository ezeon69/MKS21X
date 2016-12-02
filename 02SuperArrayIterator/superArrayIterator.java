import java.util.Iterator;

public class SuperArrayIterator implements Iterator<string>{
    
    private SuperArray data;
    private int element;

    public SuperArrayIterator(SuperArray nums, int current){
	data = nums;
	element = current;
    }

    public boolean hasNext(){
	try{
	    return next();
	}catch (NoSuchElementException e){
	    return false;
		}
	return true;
    }

    public int next(){
	
    }
	
    public void remove(){
	throw new UnsupportedOperationException();
    }
