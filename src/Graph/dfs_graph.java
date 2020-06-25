package Graph;

import java.util.ArrayList;
import java.util.List;

public class dfs_graph {
	ArrayList<ArrayList<Integer>> V;
		public dfs_graph(int v) {
			V=new ArrayList<ArrayList<Integer>>();
			for(int i=0;i<=v;i++) {
				V.add(i,new ArrayList<Integer>());
			}
		}
		void addEdge(int source,int des) {
			V.get(source).add(des);
		}
		
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dfs_graph ob1 = new dfs_graph(3);
		ob1.addEdge(0, 1); 
		ob1.addEdge(0, 2); 
		ob1.addEdge(1, 2); 
		ob1.addEdge(2, 0); 
		ob1.addEdge(2, 3); 
		ob1.addEdge(3, 3); 
		boolean visted[] = new boolean[4];
		List<Integer> res = new ArrayList<Integer>();
		ob1.dfs(visted,res,1);
		for (Integer integer : res) {
			System.out.print(integer+ "-");
		}
		
	}
	
	void dfs(boolean visited[],List<Integer> res,int start) {
		visited[start]=true;
		ArrayList<Integer> t1 =  V.get(start);
		while(t1.size()>0) {
			if(visited[t1.get(0)]) {
				t1.remove(0);
				continue;
			}
			int data = t1.get(0);
			t1.remove(0);
			dfs(visited,res,data);
		}
		res.add(0,start);
	}

}
