package Arrays;

public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i = 0;i<nums2.length;i++){
            nums1[nums1.length-1-i] = nums2[i];
        }
        for(int i=0;i<nums1.length-1;i++){
            for(int j = 0; j<nums1.length-1;j++){
                if(nums1[j]>nums1[j+1]){
                    int temp = nums1[j];
                    nums1[j] = nums1[j+1];
                    nums1[j+1] = temp;
                }
            }
        }
    }
}
