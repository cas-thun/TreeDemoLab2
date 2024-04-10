class Node{
   int value;
   Node left, right;
   
   public Node(int value){
      this.value = value;
      left = null;
      right = null;
   }

}

class BinarySearchTree{

   Node root;
   
   
   /*
   recursive insert method
   */
   public Node insert(Node root, int value){
      //base case
      if(root == null){
         root = new Node(value);
         return root;
      }
      
      //recursive step
      if(value < root.value){
         root.left = insert(root.left, value); 
      }else{
         root.right = insert(root.right, value);
      }
      
      return root;
   }
   
   
   
   /**
    * Traverses the tree in pre-order
    * @param root the root of the tree
   */
   public void preOrderTraversal(Node root){
      //implement me
      if(root == null){
         return;
      }
      System.out.println(root + " ");
      preOrderTraversal(root.left);
      preOrderTraversal(root.right);
      
   }




   /**
    * Traverses the tree in in-order
    * @param root the root of the tree
    */
   public void inOrderTraversal(Node root){
   
      if(root == null){
         return;
      }
      preOrderTraversal(root.left);
      System.out.println(root + " ");
      preOrderTraversal(root.right);
   }




   /**
    * Traverses the tree in post-order
    * @param root the root of the tree
    */
   public void postOrderTraversal(Node root){
      if(root == null){
         return;
      }
      preOrderTraversal(root.left);
      preOrderTraversal(root.right);
      System.out.println(root + " ");
   }
   
   
   
   /**
    * Finds a node with a specific value
    * @param root the root of the tree
    * @param key the value that is being searched for
    * @return if the value is found
   */
   public boolean find(Node root, int key){
	  //implement me
     if(root == null){
      return false;
     }
     if(root.value == key){
      return true;
     }
     
     if(key > root.value){
      return find(root.right, key);
     }
     
     if(key < root.value){
      return find(root.left, key);
     }
     
     return false;
              
   }
   
   
   
   /**
    * Gets the minimum value in the tree
    * @param root the root of the tree
    * @return the minimum value in the tree
   */
   public int getMin(Node root){
      //implement me
      if(root == null){
         return Integer.MAX_VALUE;
      }
      
      if(root.left != null){
         return getMin(root.left);
      }else{
         return root.value;
      }
   }



   /**
    * Gets the maximum value in the tree
    * @param root the root of the tree
    * @return the maximum value in the tree
    */
   public int getMax(Node root){
	  
     if(root == null){
         return Integer.MIN_VALUE;
      }
      
      if(root.right != null){
         return getMin(root.right);
      }else{
         return root.value;
      }
   }
   
   
   
   /*
   this method will not compile until getMax
   is implemented
   */
   public Node delete(Node root, int key){
      
      if(root == null){
         return root;
      }else if(key < root.value){
         root.left = delete(root.left, key);
      }else if(key > root.value){
         root.right = delete(root.right, key);
      }else{
         //node has been found
         if(root.left==null && root.right==null){
            //case #1: leaf node
            root = null;
         }else if(root.right == null){
            //case #2 : only left child
            root = root.left;
         }else if(root.left == null){
            //case #2 : only right child
            root = root.right;
         }else{
            //case #3 : 2 children
            root.value = getMax(root.left);
            root.left = delete(root.left, root.value);
         }
      }
      return root;  
   }
   
   
   
}



public class TreeDemo{
   public static void main(String[] args){
      BinarySearchTree t1  = new BinarySearchTree();
      t1.insert(null, 24);
      t1.insert(null, 80);
      t1.insert(null, 18);
      t1.insert(null, 9);
      t1.insert(null, 90);
      t1.insert(null, 22);
            
      System.out.print("in-order :   ");
      t1.inOrderTraversal(t1.root);
      System.out.println();
           
      
   }  
}