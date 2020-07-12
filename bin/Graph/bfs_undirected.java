package Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class bfs_undirected {
	
	 static class graph_verted {
		private LinkedList<Integer> adj[];
		private int V;
		
		public graph_verted(int V) {
			// TODO Auto-generated constructor stub
			this.V=V;
			adj=new LinkedList[V]; 
			for(int i=0;i<V;i++) {
				adj[i]= new LinkedList<Integer>();
			}
		}
		  void addEdge(graph_verted list,int v,int u) {
			  list.adj[v].add(u);
		 }
		   void printGraph(graph_verted list) 
		    { 
		        for (int i = 0; i < list.adj.length; i++) { 
		            System.out.println("\nAdjacency list of vertex" + i); 
		            for (int j = 0; j < list.adj[i].size(); j++) { 
		                System.out.print(" -> "+list.adj[i].get(j)); 
		            } 
		            System.out.println(); 
		        } 
		    }
		   void BFS(int StartSource,graph_verted list) {
			   boolean visited[] = new boolean[list.V]; 
			   System.out.println();
			   Queue<Integer> q = new LinkedList<Integer>();
			   q.add(StartSource);
			   while(!q.isEmpty()) {
				   int vertex = q.poll();
				   if(!visited[vertex]) {
					   System.out.print(vertex+"-->");
					   q.addAll(list.adj[vertex]); 
					   visited[vertex] = true;
				   }
			   }
		   }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		graph_verted undirected_list = new graph_verted(5);
		undirected_list.addEdge(undirected_list,0,1);
		undirected_list.addEdge(undirected_list,0,4);
		undirected_list.addEdge(undirected_list,0,2);
		undirected_list.addEdge(undirected_list,1,0);
		undirected_list.addEdge(undirected_list,1,4);
		undirected_list.addEdge(undirected_list,1,2);
		undirected_list.addEdge(undirected_list,2,0);
		undirected_list.addEdge(undirected_list,2,3);
		undirected_list.addEdge(undirected_list,4,3);
		undirected_list.addEdge(undirected_list,4,1);
		undirected_list.addEdge(undirected_list,3,2);
		undirected_list.addEdge(undirected_list,3,4);
		undirected_list.addEdge(undirected_list,3,3);
		undirected_list.printGraph(undirected_list);
		System.out.print("-----------BFS UNDRICTED GRAPH----------");
		undirected_list.BFS(0, undirected_list);
		graph_verted directed = new graph_verted(4);
		directed.addEdge(directed,0, 1); 
		directed.addEdge(directed,0, 2); 
		directed.addEdge(directed,1, 2); 
		directed.addEdge(directed,2, 0); 
		directed.addEdge(directed,2, 3); 
		directed.addEdge(directed,3, 3);
		System.out.println("-----------BFS DIRECTED GRAPH----------");
		directed.BFS(2, directed);
	}

}
