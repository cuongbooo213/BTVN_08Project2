/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Cuong
 */
public class Customer extends Person{
    private String country;

    public Customer(String country, String name, String age, String sex) {
        super(name, age, sex);
        this.country = country;
    }
    
    @Override
    public void language() {
        if (country.equals("USA")) {
            System.out.println("English");
        }else if (country.equals("VN")) {
            System.out.println("Vietnamese");
        }else if (country.equals("JP")) {
            System.out.println("Japanese");
        }else{
            System.out.println("don't know the country!!!");
        }
    }

    
    
    
    
    
}
