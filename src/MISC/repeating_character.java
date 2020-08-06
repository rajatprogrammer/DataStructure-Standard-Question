package MISC;

public class repeating_character {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		repeating_character.printlongestNonSubstring("abbbbcda");
	}
	static void printlongestNonSubstring(String s) {
		if(s.length()>0) {
			int cur_len=1;
			int max_len=1;
			int prev_index=0;
			String current_sub=s.charAt(0)+"";
			String max_sub = s.charAt(0) +"";
			int visited[]=new int[256];
			for(int i=0;i<visited.length;i++) {
				visited[i]=-1;
			}
			visited[s.charAt(0)]=0;
			for(int i=1;i<s.length();i++) {
				prev_index=visited[s.charAt(i)];
				 // System.out.println("pevious Index" + prev_index);
				if(prev_index!=-1)
				{
					 System.out.println(current_sub +i);
					if(max_len<cur_len) {
						max_len=cur_len;
						max_sub=current_sub;
						if(s.charAt(i)==s.charAt(i-1))
						{
							current_sub="";
						}
						current_sub = current_sub + s.charAt(i);
					}
					else {
						if(prev_index==i-1 && s.charAt(i)==s.charAt(i-1)) {
							current_sub = "" +s.charAt(i);
						}else if(prev_index<i) {
							current_sub = current_sub + s.charAt(i);
						}
						else {
							current_sub = current_sub + s.charAt(i);
						}
					}
					// System.out.println( "current "+ current_sub);
				}else {
					if(prev_index==-1) {
						cur_len++;
						current_sub = current_sub + s.charAt(i);
					}else {
						if(max_len<cur_len) {
							max_len=cur_len;
							max_sub=current_sub;
						}
					}

				}
				visited[s.charAt(i)]=i;
			}
			if(max_len<cur_len) {
				max_len=cur_len;
				max_sub=current_sub;
			}
			System.out.print(max_sub);
			
		}
	}
	

}
