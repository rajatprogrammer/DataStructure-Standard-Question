package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//https://leetcode.com/problems/network-delay-time/
public class network_delay {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		network_delay ob1 = new network_delay();
		int times[][] = {{2,1,1},{2,3,1},{3,4,1}};
		System.out.println(ob1.networkDelayTime(times,4,2));
	}
	public int networkDelayTime(int[][] times, int N, int k) {
        boolean visit[][]=new boolean[N+1][N+1];
        int weight[][]=new int[N+1][N+1];
        List<Integer>adjecent[]=new ArrayList[N+1];
        for(int i=0;i<=N;i++)adjecent[i]=new ArrayList<>();
        int cost[]=new int[N+1];
        Arrays.fill(cost,Integer.MAX_VALUE);
        for(int A[]:times){
            int v1=A[0],v2=A[1],w=A[2];
            adjecent[v1].add(v2);
            weight[v1][v2]=w;
        }
        Queue<int[]>pq=new LinkedList<>();
        cost[k]=0;
        pq.add(new int[]{k,0});
        while(pq.size()!=0){
            int pair[]=pq.poll();
            int v=pair[0],w=pair[1];
            
            List<Integer>childs=adjecent[v];
            for(int c:childs){
                if(w+weight[v][c]<cost[c]){
                    pq.add(new int[]{c,w+weight[v][c]});
                    cost[c]=Math.min(cost[c],w+weight[v][c]);
                }
            }
        }
        int res=0;
        for(int i=1;i<cost.length;i++){
            if(cost[i]==Integer.MAX_VALUE)return -1;
            res=Math.max(cost[i],res);
        }
        return res;
    }

}
