/* This is a stub for the Cafe class */
public class Cafe extends Building implements CafeRequirements {

    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    // Constructor
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }

    public String toString(){
        return (super.toString());
    }
    
    /**
     * Sells a coffee by reducing the inventory based on parameters.
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        if (this.nCoffeeOunces >= size && this.nSugarPackets >= nSugarPackets && 
            this.nCreams >= nCreams && this.nCups >= 1) {
            this.nCoffeeOunces-=size;
            this.nSugarPackets-=nSugarPackets;
            this.nCreams-=nCreams;
            this.nCups-=1;
            System.out.println("Coffee sold! Enjoy your drink.");
        } else {
            System.out.println("Low stock, Calling restock...");

            // Calling the restock method from within sellCoffee
            restock(50, 10, 10, 5);

            // Attempt to sell again after restocking
            sellCoffee(size, nSugarPackets, nCreams);
        }
    }
    
    /**
     * Restocks the cafe inventory.
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        // restock when necessary
        this.nCoffeeOunces=nCoffeeOunces;
        this.nSugarPackets=nSugarPackets;
        this.nCreams=nCreams;
        this.nCups=nCups;
    }

    public static void main(String[] args) {
        Cafe ccCafe = new Cafe("Campus Center Cafe", "100 Elm St", 1,  20, 10, 10, 5);
        System.out.println(ccCafe);

        //buying one coffee
        ccCafe.sellCoffee(12, 2, 3);

        //buying another coffee
        ccCafe.sellCoffee(16,2,2);
    }
    
}
