import java.util.Scanner;

public class usersqueue {
    queuenode rear , front;

    public usersqueue() { this.front = this.rear = null; }


    void enqueue(String username , usertree t)
    {
        queuenode temp = new  queuenode(username,t);

        if (this.rear == null) {
            this.front = this.rear = temp;
            return;
        }
else {
            this.rear.next = temp;
            this.rear = temp;
        }
    }
    void dequeue()
    {
        if (this.front == null)
            return;

        queuenode temp = this.front;
        this.front = this.front.next;

        if (this.front == null)
            this.rear = null;
    }
    boolean isEmpty(){
        if(front==null){
            return true;
        }
        return false;
    }

    void peek(){


    }

void print()
{

  if(!isEmpty()) {
      System.out.println();

      int i = 1;
      queuenode temp = front;
      while (temp != null) {
          System.out.println("Customer " + (i++) + " : ");
          System.out.println("Name: " + temp.username);
          System.out.println("Order: ");
          temp.t.inorder();
          temp = temp.next;
      }
      System.out.println();
      System.out.println();
  }
  else{
      System.out.println("No pending order!");
  }
}

boolean search(String uname){
        queuenode temp = front;

        while(temp!=null){

            if(temp.username.equals(uname))
            {
                return true;
            }
            temp = temp.next;

        }
        return false;
}
  }



class queuenode{

    queuenode next;
    String username;
    usertree t;

    queuenode(String username , usertree t){
        this.username = username;
        this.t = t;
    }

}
