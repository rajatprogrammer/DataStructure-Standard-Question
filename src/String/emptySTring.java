package String;
//https://www.geeksforgeeks.org/search-in-an-array-of-strings-where-non-empty-strings-are-sorted/
public class emptySTring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str[] = {"for", "", "", "", "geeks", "ide", "", "practice", "" , "", "quiz", "", ""};
		System.out.print(compareString(str,"practice",0,str.length-1));
	}
	
	public static boolean compareString(String str[],String search,int start,int end) {
		 if (start > end) 
	            return false; 
			int mid = (start+end)/2;
			if(str[mid].isEmpty() || str[mid]==null) {
				// If mid is empty, search in both sides of mid 
	            // and find the closest non-empty string, and 
	            // set mid accordingly. 
				int left=mid-1;
				int right=mid+1;
				while(true) {
					if (left < right && right > end) 
	                    return false; 
					else if(right<=end && !(str[right].isEmpty() || str[right]==null)) {
						mid = right; 
						break;
					}else if(left >= right && !(str[left].isEmpty() || str[left]==null)) {
						 mid = left; 
		                  break; 
					}
					left--;
					right++;
				}
			}
			if(search.compareTo(str[mid])==0) {
				return true;
			}
			else if(search.compareTo(str[mid])>0) {
				return compareString(str,search,mid+1,end);
			}else {
				return compareString(str,search,start,mid);
			}
		}	

}
