package genericTrees;

public class Client {

	public static void main(String[] args) {
		GenericTree a=new GenericTree();
//		a.display();
//		a.printAtDepth(1);
		a.preorder();
		System.out.println("\n---------------------------------");
		GenericTree b=new GenericTree();
		b.preorder();
		System.out.println("\n---------------------------------");
		System.out.println(a.checkisomers(b));
	}

}
