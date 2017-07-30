package trie;

public class Client {

	public static void main(String[] args) throws Exception {
		Trie trie = new Trie();
		trie.addword("and");
		trie.addword("ant");
		trie.addword("art");
		trie.addword("arc");
		trie.addword("buy");
		trie.addword("but");
		trie.addword("bug");
		trie.addword("an");
		trie.addword("sea");
		trie.addword("seen");

		System.out.println(trie.searchWord("see"));
		System.out.println(trie.searchWord("an"));
		trie.removeWord("an");
		System.out.println(trie.searchWord("an"));
		trie.display();
		trie.numofwords();
		trie.numofnodes();
	}

}
