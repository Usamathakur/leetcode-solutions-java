class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        int lengthA = nums1.length;
        int lengthB = nums2.length;
        
        int low = 0;
        int high =lengthA;
        
        while(low<=high){
            int partitionA = (low+high)/2;
            int partitionB = (lengthA + lengthB +1)/2 - partitionA;
            
            int maxLeftA = partitionA == 0 ? Integer.MIN_VALUE : nums1[partitionA - 1];
            int minRightA = partitionA == lengthA ? Integer.MAX_VALUE : nums1[partitionA];
            
            int maxLeftB = partitionB == 0 ? Integer.MIN_VALUE : nums2[partitionB - 1];
            int minRightB = partitionB == lengthB ? Integer.MAX_VALUE : nums2[partitionB];
            
            if(maxLeftA <= minRightB && maxLeftB <= minRightA){
                
                if((lengthA + lengthB) % 2 == 0){
                    return ((double)Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB))/2;
                }else{
                    return ((double)Math.max(maxLeftA, maxLeftB));
                }
            }else if(maxLeftA>minRightB){
                high = partitionA -1;
            }else{
                low = partitionA +1;
            }
        }
        throw new IllegalArgumentException();
    }
}
