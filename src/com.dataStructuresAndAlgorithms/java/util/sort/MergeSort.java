package util.sort;
/*
归并排序t
 */
public class MergeSort {
    public void mergeSort(int[] nums,int left,int right){
            if(left>=right){            //分治结束条件，若不符合条件，将一直进行递归分治，若符合条件则及进行合并
                return;
            }
            //分治
            int mid = (left+right)/2;
            mergeSort(nums,left,mid);
            mergeSort(nums,mid+1,right);
            //合并
            merge(nums,left,mid,right);
    }
    //合并
    public  static void merge(int nums[],int left,int mid,int right){
        int s1 = left;
        int s2 = mid+1;
        int[] ret = new int[right - left +1 ];                             //定义新数组用于存放合并段
        int i = 0;

        while(s1<=mid&&s2<=right){                                         //比较两个合并段中的数的大小
            if(nums[s1]<=nums[s2]){                                          //若nums[s1] <= nums[s2]：则将nums[s1]存入新数组并将s1索引自增，再次与num[s2],比较
                ret[i++] = nums[s1++];                                          //nums[s2]同理
            }else{
                ret[i++] = nums[s2++];
            }
        }
        while(s1<=mid){
            ret[i++] = nums[s1++];                                             //最后判断哪个合并段还剩有元素，直接复制到新数组最后
        }
        while(s2<=right){
            ret[i++] = nums[s2++];
        }
        for (int j = 0; j < ret.length; j++) {
            nums[j+left] = ret[j];
        }
    }

    public static void main(String[] args) {
        int[] a = new int[] {1,4,8,65,9,2};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(a,0,a.length-1);
        for (int i = 0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}
