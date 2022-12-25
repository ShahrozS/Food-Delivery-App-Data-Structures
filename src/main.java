import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        welcome w = new welcome();
        w.welcome1();


    }

}

class welcome{

    void welcome1() {
        usersqueue q = new usersqueue();
        System.out.println("-----Welcome to Sizz Food App----");
        System.out.println("Press 1 to continue");
        Scanner sc = new Scanner(System.in);
       Login l = new Login();
        int x  = sc.nextInt();

switch (x)
{
    case 1:{
        l.login(q,"");

    }
    break;
    default:
        System.out.println("Enter 1 to continue");
 welcome1();
}

    }




}