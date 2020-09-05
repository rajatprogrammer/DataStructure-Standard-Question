package SegmentTree;

import java.util.Arrays;

//for creating segment tree in array if length of array is odd then 
//segment tree created is 2*next power of 2 greater then array length -1 i.e arr.length =3 so segmentTree length = 2*4-1=7
// if array is even then segment tree is equal to 2*array length-1 i.e arr.length=2 so segmentTree length =2*2-1;
//left child =2*pos+1
//right child=2*pos+2
//root=(pos-1)/2
//https://www.geeksforgeeks.org/segment-tree-set-2-range-maximum-query-node-update/
public class max_range_querry {
	int sGTree[];
	max_range_querry(int n){
		sGTree = new int[n];
		Arrays.fill(sGTree,Integer.MIN_VALUE);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 1, 2, 6, 9, 10};
		int pow = (int)Math.ceil(Math.log(arr.length)/Math.log(2));
		int maxSize= (2*(int)Math.pow(2, pow))-1;
		max_range_querry ob1= new max_range_querry(maxSize);
		ob1.createSegemtTree(arr,0,arr.length-1,0);
		System.out.println(Arrays.toString(ob1.sGTree));
		int output1=ob1.RangeQuery(0,2,0,arr.length-1, 0);
		System.out.println(output1);
	}
	public  void createSegemtTree(int arr[],int low,int high,int pos) {
		if(low==high) {
			sGTree[pos]=arr[low];
			return;
		}
		int mid=(low+high)/2;
		createSegemtTree(arr,low,mid,2*pos+1);
		createSegemtTree(arr,mid+1,high,2*pos+2);
		sGTree[pos]=Math.max(sGTree[2*pos+1], sGTree[2*pos+2]);
	}
	public int RangeQuery(int qlow,int qhigh ,int low,int high,int pos) {
		if(qlow<=low && qhigh>=high) { //complete overlap
			return sGTree[pos];
		}
		if(qlow>high || qhigh<low) { //no overlap
			return Integer.MIN_VALUE;
		}
		int mid = (low+high)/2;
		int lf=RangeQuery(qlow,qhigh,low,mid,2*pos+1); //partial overlap
		int rf=RangeQuery(qlow,qhigh,mid+1,high,2*pos+2); 
		return Math.max(lf,rf);
	}
}


