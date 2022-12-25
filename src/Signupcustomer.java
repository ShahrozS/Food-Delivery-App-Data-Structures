import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLOutput;
import java.util.Scanner;
public class Signupcustomer {

static void insertvalues(usersqueue q){

    Scanner sc = new Scanner(System.in);
    System.out.println("Enter your name: ");

    String name = sc.nextLine();
    System.out.println("Enter your password: ");
    String password = sc.nextLine();
    hash h = new hash();
//String hashedpass = dohash(password);
String hashedpass = h.encrypt(password);
System.out.println("Enter your email: ");
 String email = sc.nextLine();
    System.out.println("Enter your contact: ");
String contact= sc.nextLine();
if(name.isEmpty()||password.isEmpty()||email.isEmpty()||contact.isEmpty()){
    System.out.println("Please fill all feilds! ");
    insertvalues(q);
}else {
    try {
        Connection con = dbconnect.getConnection();
        String sql = "insert into users(name,password,email,contact) values(?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, name);
        pst.setString(2, hashedpass);
        pst.setString(3, email);
        pst.setString(4, contact);

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
static String dohash(String password){
    try {
        MessageDigest msgdgst = MessageDigest.getInstance("MD5");
        msgdgst.update(password.getBytes());
        byte[] result = msgdgst.digest();

        StringBuilder sb = new StringBuilder();
        for(byte b : result){
            sb.append(String.format("%02x",b));

        }
        return sb.toString();
    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
    }
    return " ";


}

}

