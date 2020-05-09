// https://www.geeksforgeeks.org/graph-and-its-representations/
package Graph;

import java.util.ArrayList;
import java.util.List;

class graph{
	graph(List<List<Integer>> adj,int v,int u){
		adj.get(v).add(u);
		adj.get(u).add(v);
		
	}
}

public class undirected_graph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> list = new  ArrayList<List<Integer>>(4);
		 for (int i = 0; i < 5; i++) 
			 list.add(new ArrayList<Integer>()); 
		 
		 new graph(list, 0, 1);
		 new graph(list, 0, 4);
		 new graph(list, 0, 2);
		 new graph(list, 2, 1);
		 new graph(list, 2, 3);
		 new graph(list, 1, 4);
		 new graph(list, 3, 4);
		 printGraph(list);
	}
	static void printGraph(List<List<Integer>> adj) 
    { 
        for (int i = 0; i < adj.size(); i++) { 
            System.out.println("\nAdjacency list of vertex" + i); 
            for (int j = 0; j < adj.get(i).size(); j++) { 
                System.out.print(" -> "+adj.get(i).get(j)); 
            } 
            System.out.println(); 
        } 
    } 

}
