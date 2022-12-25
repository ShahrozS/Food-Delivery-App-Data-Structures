import com.mysql.cj.protocol.x.StatementExecuteOkMessageListener;

import java.sql.*;
import java.util.LinkedList;
import java.util.Scanner;

public class Admin {

    Connection con = dbconnect.getConnection();
void adminscreen(FoodLinkedList f,usersqueue q){

    System.out.println("1: Enter a food item.");
    System.out.println("2: Current Orders. ");
    System.out.println("3: Delete an item. ");
    System.out.println("4: Show Customer list. ");
    System.out.println("5: Go to login Screen. ");
    Scanner sc = new Scanner(System.in);
    int c = sc.nextInt();
    switch (c){
        case 1:{

            enterafooditem(f,q);


    }break;
        case 2:{
            currentorders(f, q);


        }break;

        case 3:{

            f.printnoqty(f);
            System.out.println("Enter the Id of the item you want to delete: ");
            int item = sc.nextInt();
            f.Delete_Record(item);


            String sql = "Delete from fooditems Where id =? ";
            try {
                PreparedStatement pr =  con.prepareStatement(sql);
                pr.setInt(1,item);
                pr.executeUpdate();
                System.out.println("Record Deleted.");
                adminscreen(f,q);
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }break;
        case 4:{

customerlist(f,q);

        }break;
        case 5:{
            Login l = new Login();
            l.login(q," ");
        }

    }


}

void customerlist(FoodLinkedList f , usersqueue q){
    Statement stmnt = null;
    try {
        System.out.println("Following is the list of current registered users: ");
        stmnt = con.createStatement();
        ResultSet rs = stmnt.executeQuery("Select * FROM users");

        System.out.format("%-5s %10s %10s %10s" , "ID", "UserName" ,"Email","Contact");
        System.out.println();
        while(rs.next()){

            System.out.format("%-5s %10s %10s %10s" , rs.getInt("id"),rs.getString("name"),rs.getString("email") , rs.getString("contact"));

            System.out.println();
        }


        System.out.println("1. Go back. ");
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        switch (x){
            case 1: {
                adminscreen(f,q);
            }
            case 2: {

            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }



}
void currentorders(FoodLinkedList f,usersqueue q){
    System.out.println();
    System.out.println("Current Orders inbound are: ");
    q.print();
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter 1 to dispatch the First in order: ");
    System.out.println("Enter 2 to go back. ");
    int x= sc.nextInt();

    switch (x){
        case 1:{
            q.dequeue();
            currentorders(f,q);
        }
        case 2: {

            adminscreen(f,q);

        }
    }



}
void enterafooditem(FoodLinkedList f,usersqueue q){
    Scanner sc = new Scanner(System.in);
    String Cat ,name;
    int id,qty,price;
    System.out.println("Category ( Desi ,Fast, Chinese, Sides, Drink )    : ");
    Cat = sc.nextLine();
    System.out.println("Food Name: ");
    name = sc.nextLine();
    System.out.println("Price: ");
    price = sc.nextInt();

    f.insert(Cat,0,name,price,0);
    Connection con = dbconnect.getConnection();

    try {
        Statement stmnt = con.createStatement();

        String sql = "insert into fooditems(Category,Name,Quantity,Price) values(?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, Cat);
        pst.setString(2, name);
        pst.setInt(3, 0);
        pst.setInt(4, price);

        int updatedrowcount = pst.executeUpdate();

        if (updatedrowcount > 0) {
            System.out.println("Record inserted!");
            f.printnoqty(f);
            adminscreen(f,q);
        } else {
            System.out.println("Insertion failure");
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

}


}
