public class Person {
    // Create attributes of Person objects
    String position;
    String name;
    String email;
    String telephone;
    String physAddress;

    // Person class constructor
    public Person(String position, String name, String email, String telephone, String physAddress) {
        this.position = position;
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.physAddress = physAddress;
    }

    // Define personToString method to display individual Person
    public String personToString() {
        String personDetails = "Position: " + position;
        personDetails += "\nName: " + name;
        personDetails += "\nEmail: " + email;
        personDetails += "\nTelephone: " + telephone;
        personDetails += "\nPhysical Address: " + physAddress;

        return personDetails;
    }
}