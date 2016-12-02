import java.util.Iterator;

public class SuperArrayIterator implements Iterator<string>{
    
    private SuperArray data;
    private String element;

    public SuperArrayIterator(SuperArray nums, String current){
	data = nums;
	element = current;
    }

    public boolean hasNext(){
        return current < data.size();
    }

    public String next(){
        element++;
	return element;
    }
	
    public void remove(){
	throw new UnsupportedOperationException();
    }
}
