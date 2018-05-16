import java.util.*;

public class MyTree extends BinarySearchTree 
{
	public void main (String args[])
	{
		BinarySearchTree t = new BinarySearchTree();

		t.insert(new KeyedItem("M")); 
		t.insert(new KeyedItem("J"));
		t.insert(new KeyedItem("D"));
		t.insert(new KeyedItem("F"));
		t.insert(new KeyedItem("L"));
		t.insert(new KeyedItem("W"));
		t.insert(new KeyedItem("S"));
		t.insert(new KeyedItem("T"));
		t.insert(new KeyedItem("Z"));

		if (root == null) return;	
		
		t.inorder();	
		//t.preorder();
		//t.countNodes();
	}
}
