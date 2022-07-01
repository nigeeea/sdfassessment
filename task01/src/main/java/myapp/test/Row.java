package myapp.test;

public class Row {

    //instance variables - should be different for each csv read..... read first line -> split, ->String array-> set IV?
    String first_name;
    String last_name;
    String address;
    String years;

    //constructor
    public Row(String firstName, String lastName, String addr, String yrs){
        this.first_name=firstName;
        this.last_name=lastName;
        this.address=addr;
        this.years=yrs;
    }

    //getters and setters

    public String getFirst_name() {
        return this.first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return this.last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getYears() {
        return this.years;
    }

    public void setYears(String years) {
        this.years = years;
    }


    
}
