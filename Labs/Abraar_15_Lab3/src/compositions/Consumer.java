package compositions;

/**
 * Student Number: XXXXXXXXX
 * Student Name: Abraar Sadek
 * Course: COMP228
 * Section: 015
 * Username: Abraar
 * File Creation Date: 10/21/2023
 */

//Consumer Class
public class Consumer {

    //Consumer Class Properties
    private String id;
    private String name;

    //Default Consumer Constructor
    public Consumer() {
        this.id = "X000";
        this.name = "XXXXX XXXXX";
    } //End of Default Consumer Constructor

    //Parameterized Consumer Constructor
    public Consumer(String id, String name) {
        this.id = id;
        this.name = name;
    } //End of Parameterized Consumer Constructor

    //Consumer Class Properties Getters & Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    //End of Consumer Class Properties Getters & Setters

    //toString Method
    @Override
    public String toString() {
        return "Consumer: " +
                "\nConsumer ID: " + id +
                "\nConsumer Name: " + name + "\n";
    } //End of toString Method

} //End of Consumer Class
