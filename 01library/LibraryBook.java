public abstract Class LibraryBook extends Book implements Comparable<LibraryBook>{
    private String callNumber;

    public LibraryBook(String creator, String name, String id, String orderNumber){
	super(creator, name, id);
	callNumber = orderNumber;
    }

    public String getAuthor(){
	super();
    }

    public String getTitle(){
	super();
    }

    public String getISBN(){
	super();
    }

    public void setAuthor(String creator){
	super();
    }

    public void setTitle(String name){
	super();
    }

    public void setISBN(String id){
	super();
    }
	
    public abstract void checkout(String patron, String due){

    }

    public abstract void returned(){

    }

    public abstract String circulationStatus(){

    }
    
    public compareTo(){

    }

    public String toString(){
	
    }


}
