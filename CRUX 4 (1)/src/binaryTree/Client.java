package binaryTree;

public class Client {

	public static void main(String[] args) {
		BinaryTree b = new BinaryTree();
		b.display();
		// 50 true 25 true 12 false false true 37 false false true 75 true 62 false false true 87 false false
		//50 true 25 true 12 false false true 37 true 30 false false true 40 false false true 75 true 62 true 60 false false true 70 false false true 87 false false
		// System.out.println(b.height());
		// System.out.println(b.max());
		// System.out.println(b.find(25));
//		b.preorderI();
//		int[] post={12,30,40,37,25,62,87,75,50};
//		int[] in={12,25,30,37,40,50,62,75,87};
//		int[] pre={50,25,12,37,30,40,75,62,87};
//		BinaryTree bt=new BinaryTree(post, in,pre);
//		bt.display();
		System.out.println("-----------------------------------------");
		b.findBST();
//		b.display();
	}

}
