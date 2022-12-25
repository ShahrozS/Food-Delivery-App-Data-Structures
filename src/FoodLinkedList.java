import org.w3c.dom.ls.LSOutput;

public class FoodLinkedList {
Node head , tail;
    boolean check(int x)
    {
        // Base Case
        if (head == null)
            return false;

        Node t = new Node();
        t = head;

        // Traverse the Linked List
        while (t != null) {
            if (t.id == x)
                return true;
            t = t.next;
        }

        return false;
    }

    void insert(String category,int id,String name,int price,int qty){

        if(check(id)){
            System.out.println("Food id already exist");
            return;
        }


        Node newnode = new Node();

        newnode.category = category;
        newnode.id = id;
        newnode.foodname = name;
        newnode.qty = qty;
        newnode.price = price;
        newnode.next= null;
        newnode.prev = null;
        if(head ==null){
            head = newnode;
            tail = newnode;
        }
        else{
            Node n = head;
            while(n.next!=null){
                n = n.next;
            }
            newnode.prev = n;
            n.next = newnode;
            if(newnode.next==null){
                tail = newnode;
            }



        }


    }
    void Delete_Record (int id)
    {
        Node temp = head;
        Node last = tail;
        if(temp.id == id){
            head  = head.next;
       return;
        }
        if(last.id == id){
            tail = tail.prev;
        return;
        }
        while(temp.id!=id&&temp.next!=null){
            temp = temp.next;

        }
        if(temp.id != id){
            System.out.println("Data dont exists.");
            return;
        }
        Node previous = temp.prev;
        Node next = temp.next;

        next.prev = previous;
        previous.next = next;
        temp.next=  null;
        temp.prev=null;

    }

    void printnoqty(FoodLinkedList L){
        Node temp = L.head;
        System.out.println();
//        System.out.printf("ID\tFoodname\t\t\t\t\t\tPrice");
        System.out.format("%-5s %-20s %15s","ID" ,"Food name" , "Price");
        System.out.println();
        while(temp!=null){

            //            System.out.printf(temp.id+ "\t"+temp.foodname+"\t");
//            System.out.printf("\t\t\t"+temp.price+"\t"+temp.qty);
//            System.out.println();
            System.out.format("%-5s %-20s %15s", temp.id, temp.foodname, temp.price);
            System.out.println();

            temp = temp.next;
        }

    }
    void printwithqty(FoodLinkedList L){
        Node temp = L.head;
        System.out.println();
        System.out.printf("ID\tFoodname\t\t\tPrice");
        System.out.println();
        while(temp!=null){

//            System.out.printf(temp.id+ "\t"+temp.foodname+"\t");
//            System.out.printf("\t\t\t"+temp.price+"\t"+temp.qty);
//            System.out.println();
            System.out.format("%-5s%-5s$%s", temp.id, temp.foodname, temp.price);
            System.out.println();

            temp = temp.next;
        }

    }
}
class Node{
    String category;
    int id;
    String foodname;
    int price;
    int qty;
    Node next;
    Node prev;

}
