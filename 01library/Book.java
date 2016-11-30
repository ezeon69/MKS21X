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
    
