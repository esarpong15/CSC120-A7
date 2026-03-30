/* This is a stub for the Library class */
import java.util.Hashtable;
import java.util.Map;

public class Library extends Building implements LibraryRequirements {

  private Hashtable<String, Boolean> collection;

  // Constructor
  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.collection = new Hashtable<String, Boolean>();
    System.out.println("You have built a library: 📖");
  }

    public String toString(){
      return(super.toString());
    }

    /**
     * Update the Hashtable containing
     * the collection every time we add a title
     */
    public void addTitle(String title){
      this.collection.put(title, true);
    }
    
    /**
     * Update the Hashtable containing the collection every 
     * time we remove a title
     */
    public String removeTitle(String title){
      // return the title that we removed
      this.collection.remove(title);
      return "The title "+title+" has been removed";
    } 

    /**
     * Checks a book out
     */
    public void checkOut(String title){
      this.collection.replace(title, true, false);
      System.out.println("You've checked out: "+title+", Enjoy!");
      }
    

    /**
     * Returns a checked out book 
     */
    public void returnBook(String title){
      this.collection.replace(title, false, true);
      System.out.println("You've returned: "+title+", Thank you!");
    }

    /**
     * Returns true if the title appears as a key in 
     * the Libary's collection, false otherwise
     */
    public boolean containsTitle(String title){
      if (this.collection.containsKey(title)){
        System.out.println("The collection has this title.");
        return this.collection.containsKey(title);
      } else {
        System.out.println("The collection does not have this title.");
        return false;
    }
  }

    /**
    * Returns true if the title is currently available, 
    * false otherwise
     */
    public boolean isAvailable(String title){
      if (this.collection.contains(title)){
        System.out.println("The book is available.");
        return this.collection.contains(title);
      } else {
        System.out.println("This book isn't available right now.");
        return false;
    }
  }

    /**
    * Prints out the entire collection in an easy-to-read 
    * way (including checkout status)  
     */
    public void printCollection(){
      if(this.collection.isEmpty()){
        System.out.println("The library is empty.");
        return;
      }
      
      for(Map.Entry<String, Boolean> entry : this.collection.entrySet()){
        String status = entry.getValue() ? "Available" : "Checked out";
        System.out.println("Title: "+entry.getKey()+", Checkout Status: "+ status);
      }
    } 
  
  
  public static void main(String[] args) {
    Library hillyerLibrary = new Library("Hillyer Art Library", "123 Lane", 3);

    System.out.println(hillyerLibrary);

    // Adding book titles
    hillyerLibrary.addTitle("Twilight");
    hillyerLibrary.addTitle("Becoming Michelle Obama");
    hillyerLibrary.addTitle("The Darkest Minds");

    // Checking inventory
    hillyerLibrary.printCollection();

    // Checking out
    hillyerLibrary.checkOut("Twilight");
    hillyerLibrary.removeTitle("Twilight");

    // Checking inventory
    hillyerLibrary.printCollection();

    // Returning a book
    hillyerLibrary.addTitle("Twilight");
    hillyerLibrary.returnBook("Twilight");

    // Checking inventory
    hillyerLibrary.printCollection();


  }
  
  
}