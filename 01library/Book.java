public class Book{

    private String author;
    private String title;
    private String ISBN;
    
    public Book(){
    }

    public Book(String creator,String name,String id){
	author = creator;
	title = name;
	ISBN = id;
    }

    public String getAuthor(){
	return author;
    }

    public String getTitle(){
	return title;
    }

    public String getISBN(){
	return ISBN;
    }

    public void setAuthor(String creator){
	author = creator;
    }

     public void setTitle(String name){
	title = name;
    }

     public void setISBN(String id){
	ISBN = id;
    }
    
    public String toString(){
	return title + ", " +  author + ", " + ISBN;
    }
}

    abstract Class LibraryBook extends Book implements Comparable<LibraryBook>{
	
    private String callNumber;

    public LibraryBook(String creator, String name, String id, String orderNumber){
	super(creator, name, id);
	callNumber = orderNumber;
    }

    public String getCallNumber(){
	return callNumber;
    }

    public void setCallNumber(String orderNumber){
        callNumber = orderNumber;
    }
	
    abstract void checkout(String patron, String due);

    abstract void returned();

    abstract String circulationStatus(){

    }
    
    public int compareTo(LibraryBook x){
	return callNumber.compareTo(x.getCallNumber());
    }

    public String toString(){
	return super.toString() + circulationStatus() + callNumber;
    }


}

}
    
