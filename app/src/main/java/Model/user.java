package Model;

public class user {
    private String Address;
    private String Email;
    private String Name;
    private String Password;


    public user(){

    }
    public user(String address, String email, String name, String password) {
        Address = address;
        Email = email;
        Name = name;
        Password = password;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
