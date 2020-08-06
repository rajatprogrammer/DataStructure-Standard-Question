package MISC;

public class max_heap {

	int capacity;
	int heap[];
	int size=0;
	public max_heap(int capacity) {
		this.capacity = capacity;
		this.heap =  new int[capacity+1];
		this.heap[0] = Integer.MAX_VALUE;
	}
	public int getParent(int pos) {
		return (pos/2);
	}
	public int getLeft(int pos) {
			return (2*pos);
	}
	public int getRight(int pos) {
		return (2*pos+1);
	}
	public void swap(int l,int r) {
		int temp = heap[l];
		heap[l] = heap[r];
		heap[r]= temp;
	}
	public boolean  checkLeafNode(int pos) {
//		if (pos >= (size / 2) && pos <= size) { 
//            return true; 
//        } 
		if(pos<size && pos<=size/2) {
			return false;
		}
        return true; 
	}
	public void insert(int item) {
		heap[++size] = item;
		int current = size;
		while(heap[current]> heap[getParent(current)]) {
			swap(current,getParent(current));
			current = getParent(current);
		}
	}
	
	public int getMax() {
		int popped = heap[1]; 
		heap[1] = heap[size--];
        maxHeapify(1); 
        return popped; 
		
	}
	public void print() 
    { 
        for (int i = 1; i <= size / 2; i++) { 
            System.out.print(" PARENT : " + heap[i] + " LEFT CHILD : " + 
            		heap[2 * i] + " RIGHT CHILD :" + heap[2 * i + 1]); 
            System.out.println(); 
        } 
    } 
	private void maxHeapify(int pos) {
		System.out.print( "dsdsd"+ heap[pos]);
		// TODO Auto-generated method stub
		if(checkLeafNode(pos))
			return ;
		else {
			while(heap[pos]<heap[getLeft(pos)] || heap[pos]<heap[getRight(pos)]) {
				if(heap[getLeft(pos)]<heap[getRight(pos)]) {
					swap(pos,getRight(pos));
					maxHeapify(getRight(pos));
				}else {
					swap(pos,getLeft(pos));
					maxHeapify(getLeft(pos));
				}
			}
		}
	}
	
	public static void main(String arg[]) {
		max_heap ob1 =new max_heap(11);
		ob1.insert(50); 
		ob1.insert(30); 
		ob1.insert(8); 
		ob1.insert(20); 
		ob1.insert(84); 
		ob1.insert(19); 
		ob1.insert(6); 
		ob1.insert(22); 
		ob1.insert(9); 
		ob1.insert(159); 
		ob1.print();
//		for(int i=1;i<ob1.heap.length;i++) {
//			System.out.print( "-->" +ob1.heap[i] );
//		}
		// get maximum
		System.out.println();
		System.out.print( "-->max" +ob1.getMax() );
		System.out.print( "-->max" +ob1.getMax() );
		System.out.print( "-->max" +ob1.getMax() );
		System.out.print( "-->max" +ob1.getMax() );
		System.out.print( "-->max" +ob1.getMax() );
		System.out.print( "-->max" +ob1.getMax() );
		System.out.print( "-->max" +ob1.getMax() );
		System.out.print( "-->max" +ob1.getMax() );
		System.out.print( "-->max" +ob1.getMax() );
		System.out.print( "-->max" +ob1.getMax() );
		System.out.print( "-->max" +ob1.getMax() );
		
		
		
	}
}
