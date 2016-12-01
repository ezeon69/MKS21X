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
//librarybook
abstract class LibraryBook extends Book implements Comparable<LibraryBook>{
	
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

    abstract String circulationStatus();
    
    public int compareTo(LibraryBook x){
	return callNumber.compareTo(x.getCallNumber());
    }

    public String toString(){
	return super.toString() + ", " + circulationStatus() + ", " + callNumber + "\n";
    }
    
    }
//referencebook
    class ReferenceBook extends LibraryBook {

    String collection;

    public ReferenceBook(String author, String title, String ISBN, String callNumber, String list){
        super(author,title,ISBN,callNumber);
	collection = list;
    }

    public String getCollection(){
	return collection;
    }

    public void setCollection(String list){
        collection = list;
    }

    public void checkout(String patron, String due){
	System.out.println("cannot check out a reference book.");
    }

    public void returned(){
	System.out.println("reference book could not have been checked out -- return impossible");
    }

    public String circulationStatus(){
	return "non-circulating reference book";
    }

    public String toString(){
	return super.toString() + ", " + collection + "\n";
    }

}
//circulatingbook
class CirculatingBook extends LibraryBook {

    String currentHolder;
    String dueDate;
    String patron;

    public CirculatingBook(String author, String title, String ISBN, String callNumber){
	super(author,title,ISBN,callNumber);
	currentHolder = null;
	dueDate = null;
    }

    public String getCurrentHolder(){
	return currentHolder;
    }

    public String getDueDate(){
	return dueDate;
    }

    public void setCurrentHolder(String currentHolder){
	this.currentHolder = currentHolder;
    }

    public void setDueDate(String dueDate){
	this.dueDate = dueDate;
    }

    public void checkout(String patron, String due){
	this.patron = patron;
	this.dueDate = due;
    }

    public void returned(){
	currentHolder = null;
	dueDate = null;
    }

    public String circulationStatus(){
        if (currentHolder == null){
	    return "book available on shelves";
	} else {
	    return "current holder: " + currentHolder + "\ndue date: "+dueDate;
	}
    }

    public String toString(){
	return super.toString() + ", " + circulationStatus() + "\n";
    }
}




    
