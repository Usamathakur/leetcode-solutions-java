class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> num_map = new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            int complement = target - nums[i];
            
            if(num_map.containsKey(complement)){
                return new int[] {num_map.get(complement),i};
            }
            num_map.put(nums[i],i);
        }
        throw new IllegalArgumentException("no match found");
    }
}
