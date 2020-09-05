package Tree;

public class convert_array_to_bst {

	public static void main(String[] args) {
			int arr[] = {-10,-3,0,5,9};
			convert_array_to_bst ob1 =new convert_array_to_bst();
			ob1.sortedArrayToBST(arr);
	}
	public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
    
    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode curr = new TreeNode(nums[mid]);
        curr.left = helper(nums, left, mid - 1);
        curr.right = helper(nums, mid + 1, right);
        return curr;
    } 

}
