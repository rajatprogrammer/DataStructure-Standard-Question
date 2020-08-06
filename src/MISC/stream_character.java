package MISC;

import java.util.HashMap;

import org.omg.CORBA.FREE_MEM;

class doubly_node{
	doubly_node prev;
	doubly_node next;
	int count;
	char ch;
	public doubly_node(char ch) {
		this.count=1;
		this.ch=ch;
		this.prev=null;
		this.next=null;
	}
}

public class stream_character {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		stream_character.first_Non_Repeating("albbdeafg");
	}
	static void first_Non_Repeating(String arg) {
		if(arg.length()>=1 )
		{
			if(arg.length()==1) {
				System.out.print("first non repeating"+ arg);
			}else {
				doubly_node head= null,ptr=null;
				HashMap<Character,doubly_node> hs = new HashMap<Character, doubly_node>();
				for(int i=0;i<arg.length();i++) {
					if(hs.containsKey(arg.charAt(i))) {
						doubly_node delete = hs.get(arg.charAt(i));
						if(delete.prev==null && delete.next!=null) {
							head = delete.next;
							head.prev=null;
							delete=null;
						}
						else if(delete.next==null && delete.prev!=null) {
							doubly_node temp = delete.prev;
							temp.next=null;
							ptr=temp;
							delete=null;
							//FREE_MEM(delete);
						}else {
							doubly_node prev =delete.prev;
							doubly_node next = delete.next;
							prev.next = delete.next;
							next.prev=delete.prev;
							delete=null;
						}
					}
					else {
						if(head!=null) {
							doubly_node temp = new doubly_node(arg.charAt(i));
							ptr.next=temp;
							temp.prev=ptr;
							hs.put(arg.charAt(i),temp);
							ptr=temp;
							
						}else {
							head = new doubly_node(arg.charAt(i));
							ptr = head;
							hs.put(arg.charAt(i),head);
						}
					}
				}
				System.out.println("first not repeating is" + head.ch);
				
			}
		}
		
		
	}

}
