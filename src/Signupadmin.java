import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Signupadmin {
    static void insertvalues(usersqueue q){
        ;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = sc.nextLine();
        System.out.println("Enter your password: ");
        String password = sc.nextLine();
        hash h = new hash();
        String hashedpass =h.encrypt(password);
//        String hashedpass = Signupcustomer.dohash(password);
        if(name.isEmpty()||password.isEmpty()){
            System.out.println("Please fill all feilds! ");
            insertvalues(q);
        }else {
            try {
                Connection con = dbconnect.getConnection();
                String sql = "insert into admin(name,password) values(?,?)";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, name);
                pst.setString(2, hashedpass);

                int updatedrowcount = pst.executeUpdate();
                if (updatedrowcount > 0) {
                    System.out.println("Record inserted!");
                    Login l = new Login();
                    l.login(q,name);
                } else {
                    System.out.println("Insertion failure");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}
