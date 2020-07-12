package Graph;
//https://www.geeksforgeeks.org/detect-cycle-in-an-undirected-graph-using-bfs/
import java.util.LinkedList;
import java.util.Queue;

public class detect_loop {
	static class graph_node{
		private int V;
		private LinkedList<Integer> adj[];
		public graph_node(int V) {
			// TODO Auto-generated constructor stub
			this.V=V;
			adj = new LinkedList[V];
			for(int i=0;i<V;i++) {
				adj[i]=new LinkedList<Integer>();
			}
		}
		static void addEdge(LinkedList<Integer> adj[],int v,int u) {
			adj[v].add(u);
		}
		static boolean detectCycleBFS(LinkedList<Integer> adj[],boolean visited[],int source,int V) {
			boolean[] visited_parent = new boolean[V];
			Queue<Integer> q = new LinkedList<Integer>();
			q.addAll(adj[source]);
			visited_parent[source]=true;
			visited[source]=true;
			while(!q.isEmpty()) {
				int v = q.poll();
				if(!visited_parent[v] && !visited[v]) {
					visited_parent[v]=true;
					visited[v]=true;
				}else {
					return true;
				}
			}
			return false;
		}
		static boolean isCycleNotConnected(LinkedList<Integer> adj[],int V) {
			boolean parent [] = new boolean[V];
			for(int i=0;i<V;i++) {
				if(!parent[i] && detectCycleBFS(adj,parent,i,V)) {
					return true;
				}
			}
			return false;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int V=4;
		graph_node list = new graph_node(V);
		graph_node.addEdge(list.adj, 0, 1); 
		graph_node.addEdge(list.adj, 1, 2); 
		graph_node.addEdge(list.adj, 2, 0); 
		 graph_node.addEdge(list.adj, 2, 3); 
		graph_node.addEdge(list.adj, 3, 3); 
		System.out.print(graph_node.isCycleNotConnected(list.adj,V));
	}

}
//code developed by rajat gupta
