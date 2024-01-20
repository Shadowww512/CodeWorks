package labs.lab9;

public class Customer implements Comparable<Customer>{
    private String name,email,pets_selection, location, notes;
    private Double amount;
    public Customer(String name, String email, String pets_selection, Double amount, String location, String notes){
        this.name = name;
        this.email = email;
        this.pets_selection = pets_selection;
        this.location = location;
        this.notes = notes;
        this.amount = amount;
    }
    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getNotes(){
        return notes;
    }

    public Double getAmount(){
        return amount;
    }

    public String getLocation(){
        return location;
    }
    
    public String getpets_selection(){
        return pets_selection;
    }

    public String toString(){
        String info = "";
        info += "Name: " + name + "\n";
        info += "Email: " + email + "\n";
        info += "pet's selection: " + pets_selection + "\n";
        info += "Total Amount Spent: " + amount + "\n";
        info += "Home Store Location: " + location + "\n";
        info += "Notes: " + notes;
        return info;
    }

    public int compareTo(Customer other){
        return this.getName().compareTo(other.getName());
    }
}
