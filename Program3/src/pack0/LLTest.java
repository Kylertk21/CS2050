package pack0;

public class LLTest {
public static void main(String[] args) {
	MyLinkedList obj=new MyLinkedList();
	
	obj.push("hi");
	obj.push("There");
	obj.push("b");
	obj.pop();
	
	obj.print();
	
	String top=obj.peek();
	
	System.out.println("top: " + top);
	System.out.println(obj.pop());
}
}
