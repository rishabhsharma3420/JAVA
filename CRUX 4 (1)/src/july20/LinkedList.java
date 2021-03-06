package july20;

public class LinkedList {

	private class Node {
		private int data;
		private Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	public void addlast(int value) {
		Node node = new Node();
		node.data = value;
		node.next = null;
		if (this.size == 0) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
			tail = node;
		}
		size++;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}

	public void display() {
		Node temp = new Node();
		temp = head;
		while (temp != null) {
			System.out.print(temp.data + "\t");
			temp = temp.next;
		}
		System.out.print("\n{--------------------------------------------------------------}\n");
	}

	public void addstart(int val) {
		Node node = new Node();
		node.data = val;
		node.next = head;
		head = node;
		size++;
	}

	public int getfirst() throws Exception {
		if (size == 0) {
			throw new Exception("Empty list");
		}
		return head.data;
	}

	public int getlast() throws Exception {
		if (size == 0) {
			throw new Exception("EMPTY LIST");
		}
		return tail.data;
	}

	public int getmid(int index) throws Exception {
		if (size == 0) {
			throw new Exception("LIST EMPTY");
		}
		if (index < 0 || index >= size) {
			throw new Exception("Wrong INDEX");
		}
		Node temp = new Node();
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		return temp.data;
	}

	public void addmid(int val, int index) throws Exception {
		if (size == 0) {
			throw new Exception("LIST EMPTY");
		}
		if (index < 0 || index > size) {
			throw new Exception("Wrong INDEX");
		}
		if (index == 0) {
			addstart(val);
		} else if (index == size - 1) {
			addlast(val);
		} else {
			Node temp = head;
			temp = getNode(index - 1);
			Node add = new Node();
			add.data = val;
			add.next = temp.next;
			temp.next = add;
			size++;
		}
	}

	public Node getNode(int index) throws Exception {
		if (size == 0) {
			throw new Exception("LIST EMPTY");
		}
		if (index < 0 || index >= size) {
			throw new Exception("Wrong INDEX");
		}
		Node temp = head;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		return temp;
	}

	public int remlast() throws Exception {
		if (size == 0) {
			throw new Exception("List EMPTY");
		}
		int rv = tail.data;
		if (size == 1) {
			return remfirst();
		}
		Node temp = head;
		temp = getNode(size - 2);
		temp.next = null;
		tail = temp;
		size--;
		return rv;
	}

	public int remfirst() throws Exception {
		if (size == 0) {
			throw new Exception("LIST EMPTY");
		}
		int rv = head.data;
		if (size == 1) {
			head = tail = null;
			size = 0;
		} else {

			Node temp = head;
			temp = getNode(1);
			head = temp;
			size--;
		}
		return rv;
	}

	public int remmid(int index) throws Exception {
		if (index < 0 || index > size) {
			throw new Exception("LIST EMPTY");
		}
		if (index == 0) {
			return remfirst();

		}
		if (index == size - 1) {
			return remlast();

		}
		Node temp1 = head;
		temp1 = getNode(index - 1);
		Node temp2 = head;
		temp2 = getNode(index);
		temp1.next = temp2.next;
		temp2.next = null;
		int rv = temp2.data;

		size--;
		return rv;
	}

	public void reversedataI() throws Exception {
		if (size == 0) {
			throw new Exception("LIST EMPTY");
		}
		if (size == 1) {
			return;
		}

		for (int i = 1; i < (size) / 2; i++) {
			Node temp1 = getNode(i);
			Node temp2 = getNode(size - i);
			swap(temp1.data, temp2.data);
		}
		int temp = head.data;
		head.data = tail.data;
		tail.data = temp;

	}

	public void swap(int i, int j) {
		int temp = i;
		i = j;
		j = temp;
	}

	public void reversepointerI() throws Exception {
		if (size == 0) {
			throw new Exception("LIST EMPTY");
		}
		if (size == 1) {
			return;
		}
		Node prev = null;
		Node curr = head;
		Node temp1 = head;
		while (curr != null) {
			Node temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		head = tail;
		tail = temp1;
		tail.next = null;

	}

	public void reversepointerR() throws Exception {
		if (size == 0) {
			throw new Exception("LIST EMPTY");
		}
		if (size == 1) {
			return;
		}
		reversepointerhelper(null, head);
		Node temp = head;
		head = tail;
		tail = temp;
		tail.next = null;

	}

	private void reversepointerhelper(Node prev, Node curr) {
		if (curr == null) {
			return;
		}
		Node temp = curr.next;
		curr.next = prev;
		reversepointerhelper(curr, temp);
	}

	public void reversedataR() throws Exception {
		if (size == 0) {
			throw new Exception("LIST EMPTY");
		}
		if (size == 1) {
			return;
		}
		Heapmover left = new Heapmover();
		left.node = head;
		reversedatahelper(left, head, 0);
	}

	private void reversedatahelper(Heapmover left, Node right, int c) {
		if (right == null) {
			return;
		}
		reversedatahelper(left, right.next, c + 1);
		if (c >= size / 2) {
			int temp = left.node.data;
			left.node.data = right.data;
			right.data = temp;
			left.node = left.node.next;
		}
	}

	private class Heapmover {
		Node node;
		int count;
	}

	public void fold() throws Exception {
		if (size == 0) {
			throw new Exception("LIST EMPTY");
		}
		Heapmover left = new Heapmover();
		left.node = head;
		foldhelper(left, head, 0);
	}

	private void foldhelper(Heapmover left, Node right, int c) {
		if (right == null) {
			return;
		}

		foldhelper(left, right.next, c + 1);
		if (c > size / 2) {
			Node temp = left.node.next;
			left.node.next = right;
			right.next = temp;
			left.node = temp;
		}
		if (c == size / 2) {
			tail = right;
			right.next = null;
		}
	}

	public int lastindex(int index) throws Exception {
		if (index <= 0 || index > size) {
			throw new Exception("ERROR");
		}
		if (index == size) {
			return getfirst();
		}
		Heapmover one = new Heapmover();
		one.count = 1;
		return lastindexhelper(one, head, index);
	}

	private int lastindexhelper(Heapmover one, Node right, int index) {
		if (right == null) {
			return one.count;
		}
		int ans = lastindexhelper(one, right.next, index);

		if (index == one.count) {
			ans = right.data;
		}
		one.count++;
		return ans;
	}

	public boolean palindrome() throws Exception {
		if (size == 0) {
			throw new Exception("LIST EMPTY");
		}
		Heapmover one = new Heapmover();
		one.node = head;
		one.count = 1;
		return palindromehelper(one, head);
	}

	private boolean palindromehelper(Heapmover left, Node right) {
		if (right == null) {
			return true;
		}
		boolean ans = palindromehelper(left, right.next);
		if (ans == true && left.node.data == right.data) {
			left.node = left.node.next;
			return true;
		} else {
			return false;
		}

	}

	private Node midnode() {
		Node fast = head;
		Node slow = head;
		while (true) {
			if (fast.next == null || fast.next == tail) {
				break;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public void krev(int k) throws Exception {
		if (size % k != 0 || k <= 0 || k >= size) {
			throw new Exception("INVALID K");
		}
		Node prev = null;
		Node curr = head;
		Node start = head;
		Node end = null;
		boolean c = true;
		for (int i = 0; i < size / k; i++) {
			for (int j = 0; j < k; j++) {
				Node temp1 = curr.next;
				curr.next = prev;
				prev = curr;
				curr = temp1;
			}
			if (c) {
				head = prev;
				c = false;
			} else {
				end.next = prev;
			}
			end = start;

			start.next = curr;
			start = curr;
		}
		tail = end;
		tail.next = null;

	}

	public LinkedList mergesortedlists(LinkedList other) {
		LinkedList merged = new LinkedList();
		Node tt = this.head;
		Node ot = other.head;
		while (ot != null && tt != null) {
			if (ot.data < tt.data) {
				merged.addlast(ot.data);
				ot = ot.next;
			} else {
				merged.addlast(tt.data);
				tt = tt.next;
			}
		}
		while (ot != null) {
			merged.addlast(ot.data);
			ot = ot.next;
		}
		while (tt != null) {
			merged.addlast(tt.data);
			tt = tt.next;
		}

		return merged;
	}

	public LinkedList mergesort() {
		if (head == tail) {
			return this;
		}
		Node mid = midnode();
		Node midn = mid.next;
		LinkedList fh = new LinkedList();
		LinkedList sh = new LinkedList();
		fh.head = head;
		fh.tail = mid;
		fh.tail.next = null;

		sh.head = midn;
		sh.tail = tail;

		fh = fh.mergesort();
		sh = sh.mergesort();
		LinkedList sorted = fh.mergesortedlists(sh);
		return sorted;

	}
}
