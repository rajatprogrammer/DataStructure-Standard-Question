package String;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/text-justification/
public class textjustification {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
//	public List<String> fullJustify(String[] words, int maxWidth) {
//        List<String> res=new ArrayList<>();
//        List<StringBuilder> line=new ArrayList<>();
//        int totLetters=0;
//        for(String word:words) {
//            int len=word.length(), size=line.size();
//            if(totLetters+size+len>maxWidth) {
//                int space = maxWidth - totLetters;
//                if(size==1) {
//                    res.add(line.get(0).toString()+" ".repeat(space));
//                } else {
//                    int spc=space/(size-1), r=space%(size-1);
//                    for(int i=0;i<r;i++)
//                        line.get(i).append(" ");
//                    res.add(String.join(" ".repeat(spc),line));
//                }
//                totLetters=0;
//                line.clear();
//            }
//            totLetters+=len;
//            line.add(new StringBuilder(word));
//        }
//        String last=String.join(" ",line);
//        res.add(String.format("%-"+maxWidth+"s",last));
//        return res;
//    }
//

}
