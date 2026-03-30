/* This is a stub for the House class */

import java.util.ArrayList;

public class House extends Building implements HouseRequirements{

  private ArrayList<Student> residents; // The <Student> tells Java what kind of data we plan to store IN the ArrayList
  private boolean hasDiningRoom;

  // Constructor
  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors);
    this.hasDiningRoom = true;
    this.residents = new ArrayList<Student>();
    System.out.println("You have built a house: 🏠");

  }
  public String toString(){
    return(super.toString()+System.lineSeparator()+"The resident(s) of this hosue is/are:"+this.residents+System.lineSeparator()+"Does it have a dining hall?: "+this.hasDiningRoom);
  }

  /**
   * Accessor for hasDiningRoom
   */
  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  } 

  /**
   * Accessor nResidents
   */
  public int nResidents(){
    return this.residents.size();
  } 

  /**
   * Updates the ArrayList of residents every time
   * someone moves in.
   */
  public void moveIn(Student s){
    this.residents.add(s);
  }

  /**
   * Updates the ArrayList of residents every time
   * someone moves out.
   * Returns the Student who moved out
   */
  public Student moveOut(Student s){
    this.residents.remove(s);
    return s;
  } 

  /**
   *  A boolean method that tells us whether or not
   *  a given person is a resident of the House.
   */
  public boolean isResident(Student s){
    return this.residents.contains(s);
  } 

  public static void main(String[] args) {
    Student elizabeth = new Student("Elizabeth", "99909abc", 2029);
    Student alice = new Student("Alice","1234xyz",2029);
    Student arriana = new Student("Arriana","5342arri",2029);
    Student jode = new Student("Jode","068jod",2029);
    House parsonsHouse = new House("Parsons", "24 Henshaw Ave",4, true);
    
    // Moving students into the House
    parsonsHouse.moveIn(elizabeth);
    parsonsHouse.moveIn(alice);
    parsonsHouse.moveIn(arriana);
    parsonsHouse.moveIn(jode);
    System.out.println(parsonsHouse);

    // Checking whether student is a resident
    parsonsHouse.isResident(elizabeth);
    System.out.println(parsonsHouse.isResident(elizabeth));

    // Moving student out of House
    parsonsHouse.moveOut(jode);
    System.out.println(parsonsHouse.moveOut(jode));

    
  }

}