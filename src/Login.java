import java.sql.*;
import java.util.Scanner;

public class Login {
    static void clearConsole() {
        System.out.printf("\033[H\033[2J");
        System.out.flush();
    }
    void login(usersqueue q,String uname){

        FoodLinkedList f = new FoodLinkedList();
    Connection con  = dbconnect.getConnection();

        Statement stmnt = null;
        try {
            stmnt = con.createStatement();
            ResultSet rs = stmnt.executeQuery("Select * FROM FOODITEMS");

            while(rs.next()){
                f.insert(rs.getString("Category"),rs.getInt("Id"),rs.getString("Name"),rs.getInt("Price"),rs.getInt("Quantity"));
            }





        } catch (SQLException e) {
            e.printStackTrace();
        }



        System.out.println("Welcome to food delivery app!");

        System.out.println("1: Login?");
        System.out.println("2: Create a new account. ");
        System.out.println("3: Exit.");
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        switch (c){
            case 1:{
                System.out.println("Login as ");
                System.out.println("1: Customer");
                System.out.println("2: Admin ");
                System.out.println();
                System.out.println("3: Back to login screen");
                int x= sc.nextInt();
                switch (x){
                    case 1:{
                        System.out.println("Enter your username: ");
                        sc.nextLine();
                        String name = sc.nextLine();
                        System.out.println("Enter your password: ");
                        String pwd = sc.nextLine();
                        verificationcustomer(name,pwd,f,q);

                    }break;
                    case 2:{
                        System.out.println("Enter your username: ");
                        sc.nextLine();
                        String name = sc.nextLine();
                        System.out.println("Enter your password: ");
                        String pwd = sc.nextLine();
                        verificationadmin(name,pwd,f,q);


                    }break;
                    case 3:{
                        login(q,uname);
                    }
                }
            }break;
            case 2:{

                System.out.println("1: For Customer?");
                System.out.println("2: For Admin?");
                System.out.println("3: Go to login screen.");
                int x = sc.nextInt();

                switch (x) {
                    case 1: {
                        Signupcustomer.insertvalues(q);
                    }
                    case 2:{
                        Signupadmin.insertvalues(q);
                    }
                    case 3:{
                        login(q,uname);
                    }
                }
                }
            case 3:{
                System.exit(0);
            }
        }


    }

    void verificationcustomer(String name , String password,FoodLinkedList f , usersqueue q){

        if(name.equals("")){
            System.out.println("Username empty");
            login(q,name);
        }
        else if(password.equals("")){
            System.out.println("Password empty");
        login(q,name);}
        else{
            try
            {
                hash h = new hash();
                String hashedpass = h.encrypt(password);
//                String hashedpass = Signupcustomer.dohash(password);
                Connection con = dbconnect.getConnection();
                PreparedStatement pst = con.prepareStatement("Select * from users where name = ? and password = ?");
                pst.setString(1,name);
                pst.setString(2,hashedpass);

             ResultSet rs =  pst.executeQuery();

             if(rs.next()){
                 System.out.println("Login successfully");
                 Homepage home =  new Homepage();
                 home.home(f,q,name);
             }
             else{
                 System.out.println("Wrong Credentials. Try again.");

                 login(q,name);
             }
            }catch (Exception e){

            }

        }

    }
    void verificationadmin(String name , String password,FoodLinkedList f,usersqueue q){

        if(name.equals("")){
            System.out.println("Username empty");
            login(q,name);
        }
        else if(password.equals("")){
            System.out.println("Password empty");
            login(q,name);}
        else{
            try
            {
                hash h = new hash();
//                String hashedpass = Signupcustomer.dohash(password);
                    String hashedpass =h.encrypt(password);
                Connection con = dbconnect.getConnection();
                PreparedStatement pst = con.prepareStatement("Select * from admin where name = ? and password = ?");
                pst.setString(1,name);
                pst.setString(2,hashedpass);

                ResultSet rs =  pst.executeQuery();

                if(rs.next()){
                    System.out.println("Login successfully");
                    Admin n = new Admin();
                    n.adminscreen(f,q);
                }
                else{
                    System.out.println("Wrong Credentials. Try again.");

                    login(q,name);
                }
            }catch (Exception e){

            }

        }

    }


}
