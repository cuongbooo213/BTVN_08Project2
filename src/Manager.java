
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Cuong
 */
public class Manager {
    private static final ArrayList<Product> ListSP = new ArrayList<>();
    private static final ArrayList<Customer> ListPerson = new ArrayList<>();

    public static void main(String[] args) {
        Product sp1 = new Product("Laptop", "P001", 1000.0);
        Product sp2 = new Product("Smartwatch", "P004", 200.0);
        Product sp3 = new Product("Smartphone", "P002", 700.0);
        ListSP.add(sp1);
        ListSP.add(sp2);
        ListSP.add(sp3);
        Customer per1 = new Customer("VN", "TRUONG TRAN CUONG", "20", "male");
        Customer per2 = new Customer("US", "Jane Smith", "22", "Female");
        Customer per3 = new Customer("JP","Yamada Hanako", "28", "Female");
        ListPerson.add(per1);
        ListPerson.add(per2);
        ListPerson.add(per3);
        Scanner scanner = new Scanner(System.in);
        int choice;
//        Scanner sc= new Scanner(System.in);
//        int n = sc.nextInt();
//        sc.nextLine();
//        Product[] SP = new Product[n];
//       f6_sortByPrice();
////       f3_allProduct();
//f7_allPerson();
        do {
            F0_menu();
            System.out.print("Enter selection: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    Scanner sc = new Scanner(System.in);
                    System.out.print("Enter the product number you want to add: ");
                    int n = sc.nextInt();
                    Product[] SP = new Product[n];
                    f1_addNewProduct(SP, n);
                    for (int i = 0; i < n; i++) {
                        ListSP.add(SP[i]);
                    }
                    break;
                case 2:
                    System.out.print("Enter ID: ");
                    f2_updatePrice();
                    break;
                case 3:
                    f3_allProduct();
                    break;
                case 4:
                    Scanner sn = new Scanner(System.in);
                    System.out.print("Enter the product number you want to add: ");
                    int a = sn.nextInt();
                    Customer[] NP = new Customer[a];
                    f4_addPerson(NP, a);
                    for (int i = 0; i < a; i++) {
                        ListPerson.add(NP[i]);
                    }
                    break;
                case 5:
                    System.out.print("Enter ID: ");
                    f5_productByID();
                    break;
                case 6:
                    f6_sortByPrice();
                    break;
                case 7:
                    f7_allPerson();
                    break;
                case 8:
                    System.out.println("Exit the program!!!");
                    break;
                default:
                    System.out.println("Enter another option.");
            }

        } while (choice != 8);

    }
    public static void F0_menu(){
        System.out.println("===============MENU=============");
        System.out.println("1.Add a new product to the Store");
        System.out.println("2.Update price for a particular product");
        System.out.println("3.A list of all available products in the Store");
        System.out.println("4.Add a new person");
        System.out.println("5.Print information of an Order by Order ID");
        System.out.println("6.Sort all products by product price as ascending ");
        System.out.println("7.Print information of all Customer ");
        System.out.println("8.Quit");
    
    }
    public static void f1_addNewProduct(Product[] SP,int n){
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            System.out.print("Input name: ");
            String name = sc.nextLine();
            System.out.print("Input id: ");
            String id = sc.nextLine();
            System.out.print("Input price: ");
            double price = sc.nextDouble();
            sc.nextLine();
            SP[i] = new Product(name, id, price);
        }
    }
    public static void f2_updatePrice(){
        Scanner sc = new Scanner(System.in);
        String ID = sc.nextLine();
        int flag =0;
        for (int i = 0; i < ListSP.size(); i++) {
            if (ListSP.get(i).getId().equals(ID)) {
                System.out.print("Enter new amount: ");
                ListSP.get(i).setPrice(sc.nextDouble());
                sc.nextLine();
                flag = 1;
            }
        }
        if (flag==0) {
            System.out.println("ID not found.");
        }
    }
    public static void f3_allProduct(){
        for (int i = 0; i < ListSP.size(); i++) {
            System.out.println(ListSP.get(i).toString());
        }
    }
    public static void f4_addPerson(Customer[] NP, int n){
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            System.out.print("Your country: ");
            String country = sc.nextLine();
            System.out.print("Your name: ");
            String name = sc.nextLine();
            System.out.print("Your age: ");
            String age = sc.nextLine();
            System.out.print("Your sex: ");
            String sex = sc.nextLine();
            NP[i] = new Customer(country, name, age, sex);
        }
    }
    public static void f5_productByID(){
        Scanner sc = new Scanner(System.in);
        String ID = sc.nextLine();
        for (int i = 0; i < ListSP.size(); i++) {
            if (ListSP.get(i).getId().equals(ID)) {
                System.out.println(ListSP.get(i).toString());
            }
        }
    }
    public static void f6_sortByPrice(){
        Product temp = new Product();
        int a = ListSP.size();
        Product[] Arr;
        Arr = new Product[a];
        for (int i = 0; i < a; i++) {
            Arr[i] =ListSP.get(i);
        }
        for (int i = 0; i <a-1; i++) {
            for (int j = i+1; j <a; j++) {
                if (Arr[i].compareTo(Arr[j])>0) {
                    temp = Arr[i];
                    Arr[i]=Arr[j];
                    Arr[j]=temp;
                }
            }
        }
        for (int i = 0; i < ListSP.size(); i++) {
            System.out.println(Arr[i].toString());
        }
    }
    public static void f7_allPerson(){
        for (int i = 0; i < ListPerson.size(); i++) {
            System.out.print(ListPerson.get(i).toString()+" ");
            ListPerson.get(i).language();
        }
    }
}
