import jdk.jfr.Category;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Homepage {
    usertree t = new usertree();
    void home(FoodLinkedList f,usersqueue q,String uname){

        System.out.println();
        System.out.println();
        System.out.println("     What you would like to order," + uname+ ".");

        System.out.println("1: Desi food section. ");
        System.out.println("2: Chinease food section. ");
        System.out.println("3: Fast food section. ");
        System.out.println("4: Sides. ");
        System.out.println("5: Drinks. ");
        System.out.println("6: Confirm order? ");
        System.out.println("7: Check your order status: ");
        System.out.println("8: Back. ");

        Connection con = dbconnect.getConnection();


        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();

        switch(c){
            case 1:{

                try {
                    System.out.printf("\t\tDesi Section\t\t\n");
                    System.out.println();
                    Statement stmnt = con.createStatement();
                    String sql = "Select * from fooditems where Category like 'Desi' ";

                    PreparedStatement pr = con.prepareStatement(sql);
//                    pr.setString(1,"Desi");
                    ResultSet rs = stmnt.executeQuery(sql);

                    System.out.format("%-4s %-20s %5s" , "ID" , "Food name","Price" );  System.out.println();

                    while(rs.next()){


                        System.out.format("%-4s %-20s %5s" ,rs.getInt("id"),rs.getString("name"),rs.getInt("Price") );
                        System.out.println();
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }


            }break;
            case 2:{
                try {
                    System.out.printf("\t\tChinese Section\t\t\n");  System.out.println();
                    Statement stmnt = con.createStatement();
                    String sql = "Select * from fooditems where Category like 'Chinese' ";

                    PreparedStatement pr = con.prepareStatement(sql);
//                    pr.setString(1,"Desi");
                    ResultSet rs = stmnt.executeQuery(sql);

                    System.out.format("%-4s %-20s %5s" , "ID" , "Food name","Price" );  System.out.println();

                    while(rs.next()){
                        System.out.format("%-4s %-20s %5s" ,rs.getInt("id"),rs.getString("name"),rs.getInt("Price") );
                        System.out.println();
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }break;
            case 3:{
                try {
                    System.out.printf("\t\tFast Food Section\t\t\n");  System.out.println();
                    Statement stmnt = con.createStatement();
                    String sql = "Select * from fooditems where Category like 'Fast' ";

                    PreparedStatement pr = con.prepareStatement(sql);
//                    pr.setString(1,"Desi");
                    ResultSet rs = stmnt.executeQuery(sql);

                    System.out.format("%-4s %-20s %5s" , "ID" , "Food name","Price" );  System.out.println();
                    System.out.println("ID    Food name         Price");
                    while(rs.next()){


                        System.out.format("%-4s %-20s %5s" ,rs.getInt("id"),rs.getString("name"),rs.getInt("Price") );
                        System.out.println();
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }break;
            case 4:{
                try {
                    System.out.printf("\t\tSides Section\t\t\n");  System.out.println();
                    Statement stmnt = con.createStatement();
                    String sql = "Select * from fooditems where Category like 'Sides' ";

                    PreparedStatement pr = con.prepareStatement(sql);
//                    pr.setString(1,"Desi");
                    ResultSet rs = stmnt.executeQuery(sql);

                    System.out.format("%-4s %-10s %10s" , "ID" , "Food name","Price" );  System.out.println();

                    while(rs.next()){


                        System.out.format("%-4s %-20s %5s" ,rs.getInt("id"),rs.getString("name"),rs.getInt("Price") );
                        System.out.println();
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }break;
            case 5:{
                try {

                    System.out.printf("\t\tDrink Section\t\t\n");  System.out.println();

                    Statement stmnt = con.createStatement();
                    String sql = "Select * from fooditems where Category like 'Drink' ";

                    PreparedStatement pr = con.prepareStatement(sql);
//                    pr.setString(1,"Desi");
                    ResultSet rs = stmnt.executeQuery(sql);

                    System.out.format("%-4s %-20s %5s" , "ID" , "Food name","Price" );  System.out.println();

                    while(rs.next()){


                        System.out.format("%-4s %-20s %5s" ,rs.getInt("id"),rs.getString("name"),rs.getInt("Price") );
                        System.out.println();
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }break;
            case 6:{
                yourorderscreen(t,f,q,uname);
            }break;
            case 7:{
                checkstatus(uname,q);
            }break;
            case 8:{
Login l = new Login();
l.login(q,"");
            }break;

        }

        System.out.println("1: Wanna order? ");
        System.out.println("2: Go back.");
        int ord  = sc.nextInt();
        switch (ord)
        {
            case 1:{
                System.out.println("Enter ID of what you wanna order: ");
                int orderedId = sc.nextInt();
                System.out.println("Enter quantity: ");
                int qty = sc.nextInt();


                    if (t.isexist(orderedId) == false) {
                        String sql = "Select * from fooditems where id like " + orderedId + "";
                        Statement stmnt = null;


                        try {
                            stmnt = con.createStatement();
                            ResultSet rs = stmnt.executeQuery(sql);
                            while (rs.next()) {
                                t.insert(orderedId, rs.getString("Name"), qty, rs.getInt("Price"));
                            }

                          home(f,q,uname);


                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                    } else {
                        t.duplinode(orderedId, qty);
                        home(f,q,uname);
                    }
                }
            break;

case 2:{
                home(f,q,uname);

            }break;
        }
        if(ord>2){
            System.out.println("Wrong choice (choose between 1-2).");
            home(f,q,uname);
        }

    }

    
 void yourorderscreen(usertree t,FoodLinkedList f,usersqueue q,String uname){

   if(t.isempty()==false) {

       Scanner sc = new Scanner(System.in);
       System.out.printf("\t\t\tYour Order\t\t\t\n\n");

       t.inorder();
       System.out.println();

       System.out.println("1: Delete an item? ");
       System.out.println("2: Order more? ");
       System.out.println("3: Checkout. ");
       System.out.println("4: Go back. ");


       int cnfrm = sc.nextInt();

       switch (cnfrm) {

           case 1: {

               System.out.println("Enter ID of the item you wanna delete from the list: ");
               int id = sc.nextInt();
               t.deleteKey(id);
               yourorderscreen(t,f,q,uname);

           }
           case 2: {
               home(f,q,uname);


           }
           case 3: {

               q.enqueue(uname,t);
               checkout(f,uname,t,q);

           }
           case 4: {
Login l = new Login();
l.login(q,uname);
           }

       }
   }
else{
       System.out.println("Order something!! ");
       home(f,q,uname);
   }

}
void checkstatus(String uname, usersqueue q){

if(q.search(uname)){
    System.out.println("Your order is still processing " + uname + ".");
    System.out.println("Thankyou for your patience! ");

}
else{
    System.out.println("Your order has been dispatched "+uname+" .");
    System.out.println("Thankyou for Ordering! ");
}
    System.out.println("Enter 1 to go to login page. ");
    Scanner sc = new Scanner(System.in);
    int x = sc.nextInt();
    if(x == 1){
        Login l = new Login();
        l.login(q,uname);
    }

}
    void checkout(FoodLinkedList f,String uname,usertree t,usersqueue q){

        System.out.printf("\t\t\t---Your Final order is---");
        System.out.println();
        t.inorder();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
//        System.out.println(dtf.format(now));
        System.out.println();



        System.out.println("Your total bill is : " + t.bill()+ " Rs + tax");
        System.out.println("Order placed on "+ dtf.format(now)+". Will Deliver in 15-40 minutes. ");
        System.out.println("Thankyou for Ordering "+uname+ " !!");
        System.out.println();Login l = new Login();

        System.out.println("Press 1 to go back to Login page: ");
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        switch (x){
            case 1:
            {
                l.login(q,uname);
            }break;
        }


    }
}



