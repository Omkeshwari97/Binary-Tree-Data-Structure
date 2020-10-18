package binarytreedatastructure;

public class MyBinaryTree<K extends Comparable<K>>
{
	private MyBinaryNode<K> root;
	
	public void add(K key)
	{
		this.root = this.addRecursively(root, key);
	}

	private MyBinaryNode<K> addRecursively(MyBinaryNode<K> current, K key) 
	{
		if(current == null)
		{
			return new MyBinaryNode<K>(key);
		}
		
		int compareResult = key.compareTo(current.key);
		
		if(compareResult == 0)
		{
			return current;
		}
		
		if(compareResult < 0)
		{
			current.left = addRecursively(current.left, key);
		}
		
		if(compareResult > 0)
		{
			current.right = addRecursively(current.right, key);
		}
		
		return current;
	}

	public int getSize() 
	{
		return this.getSizeRecursive(root);
	}

	private int getSizeRecursive(MyBinaryNode<K> current) 
	{
		return current == null ? 0 : 1 + this.getSizeRecursive(current.left)
										+ this.getSizeRecursive(current.right);
	}

	public boolean search(K searchKey) 
	{
		return this.searchRecursively(root, searchKey);
	}
	
	private boolean searchRecursively(MyBinaryNode<K> currrent ,K searchKey) 
	{			
		if(currrent == null)
		{
			return false;
		}
		
		if(searchKey.compareTo(currrent.key) == 0)
		{
			return true;
		}
		
		if(searchKey.compareTo(currrent.key) < 0)
		{
			return searchRecursively(currrent.left, searchKey);
		}
		
		if(searchKey.compareTo(currrent.key) > 0)
		{
			return searchRecursively(currrent.right, searchKey);
		}
		
		return false;
	}	
}
