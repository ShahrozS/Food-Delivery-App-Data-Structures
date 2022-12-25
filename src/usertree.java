public class usertree {
    treenode root;


    usertree() { root = null; }

    usertree(int id,String foodname,int qty , int price) { root = new treenode(id,foodname,qty,price); }


    void insert(int id,String foodname,int qty,int price) { root = insertRec(root,id,foodname,qty,price); }


    treenode insertRec(treenode root, int id,String foodname,int qty,int price)
    {

        if (root == null) {
            root = new treenode(id,foodname,qty,price);
            return root;
        }


        else if (id < root.id)
            root.left = insertRec(root.left, id,foodname,qty,price);
        else if (id > root.id)
            root.right = insertRec(root.right,id,foodname,qty,price);


        return root;
    }
    public boolean search(treenode root, int id)
    {
        // Base Cases: root is null or key is present at root
        if(root==null){
            return false;
        }
        if ( root.id==id) {
            return true;
        }
        // Key is greater than root's key
        if (root.id < id) {
            return search(root.right, id);
        }
        else if(root.id>id) {// Key is smaller than root's key
            return search(root.left, id);
        }
return false;
    }
boolean isexist(int id){

      if(search(root,id)){
          return true;
      }
      else{
          return false;
      }

}
    public boolean searchval(treenode root, int id,int qty)
    {


        if(root==null){
            return false;
        }
            if ( root.id == id) {
                root.qty = root.qty + qty;

            }
            // Key is greater than root's key
            if (root.id < id)
                return searchval(root.right, id, qty);

            // Key is smaller than root's key
            return searchval(root.left, id, qty);


    }

  void duplinode(int id,int qty){

        searchval(root,id,qty);


    }

    int bill(){

        return totalbill(0,root);
    }
    int totalbill(int sum,treenode root){

        if(root!=null){
          sum =   totalbill(sum,root.left);
            sum = sum + (root.qty* root.price);
            sum = totalbill(sum,root.right);

        }

        return sum;
    }

    void inorder() {         System.out.format("%-4s %-20s %10s %10s " , "ID" , "Food Name","Quantity","Price" );
        System.out.println();
        inorderRec(root); }

    void inorderRec(treenode root) {


        if (root != null) {
            inorderRec(root.left);
            System.out.format("%-4s %-20s %10s %10s " , root.id , root.foodname,root.qty,root.price );System.out.println();

//            System.out.println(root.id + "  " +root.foodname+ " " + root.qty + " "+root.price);
            inorderRec(root.right);
        }

    }

    boolean isempty(){
        if(root == null){
            return true;
        }
        else
        {
            return false;
        }
    }
    void deleteKey(int id) { root = deleteRec(root, id); }


    treenode deleteRec(treenode root, int id)
    {

        if (root == null)
            return root;


        if (id < root.id)
            root.left = deleteRec(root.left, id);
        else if (id > root.id)
            root.right = deleteRec(root.right, id);

        else {

            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.id = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.id);
        }

        return root;
    }

    int minValue(treenode root)
    {
        int minv = root.id;
        while (root.left != null)
        {
            minv = root.left.id;
            root = root.left;
        }
        return minv;
    }


}
class treenode{
int id;
 String foodname;
 int qty;
 int price;
treenode(int id ,String foodname,int qty,int price){
   this.id = id;
    this.foodname = foodname;
    this.qty = qty;
    this.price = price;
}
 treenode right;
 treenode left;

}

