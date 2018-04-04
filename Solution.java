import java.util.ArrayList;
import java.util.List;

public class Solution {

	  Node root;
	
	public static void main(String ard[]) {
		Solution tree = new Solution();
		int i=0;
		 int inorder[] = new int[]{21,16,10,4,15,30,28,32};
		 int a[]=new int[inorder.length];
	        int len = inorder.length;
	        Node mynode = tree.buildTree(inorder, 0, len - 1, tree.root);
	        System.out.println("Inorder traversal of the constructed tree is ");
	        //tree.printInorder(mynode);
	        List<Integer> list = new ArrayList<Integer>();
	        tree.printPreorder(mynode,list);
	        for (Integer integer : list) {
				a[i++]=integer;
			}
	        System.out.println(a);
	}
	
	Node buildTree(int inorder[], int start, int end, Node node) 
    {
        if (start > end)
            return null;
  
        /* Find index of the min element from Binary Tree */
        int i = min(inorder, start, end);
  
        /* Pick the min value and make it root */
        node = new Node(inorder[i]);
  
        /* If this is the only element in inorder[start..end],
         then return it */
        if (start == end)
            return node;
  
        /* Using index in Inorder traversal, construct left and
         right subtress */
        node.left = buildTree(inorder, start, i - 1, node.left);
        node.right = buildTree(inorder, i + 1, end, node.right);
  
        return node;
    }
  
    /* UTILITY FUNCTIONS */
     
    /* Function to find index of the maximum value in arr[start...end] */
     int min(int arr[], int strt, int end) 
    {
        int i, min = arr[strt], minind = strt;
        for (i = strt + 1; i <= end; i++) 
        {
            if (arr[i] < min) 
            {
                min = arr[i];
                minind = i;
            }
        }
        return minind;
    }
    
     void printInorder(Node node) 
    {
        if (node == null)
            return;
  
        /* first recur on left child */
        printInorder(node.left);
  
        /* then print the data of node */
        System.out.print(node.data + " ");
  
        /* now recur on right child */
        printInorder(node.right);
    }
     
     void printPreorder(Node node,List<Integer> arr)
     {
         if (node == null)
             return;
  
         /* first print data of node */
         System.out.print(node.data + " ");
         arr.add(node.data);  
         /* then recur on left sutree */
         printPreorder(node.left,arr);
  
         /* now recur on right subtree */
         printPreorder(node.right,arr);
     }
    
	class Node 
	{
	    int data;
	    Node left, right;
	  
	    Node(int item) 
	    {
	        data = item;
	        left = right = null;
	    }
	}
	
	
}
