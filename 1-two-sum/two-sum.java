class Solution {
    public int[] twoSum(int[] nums, int target) {
         Map<Integer, Integer> seen = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            // If the complement exists in our map, we found the solution
            if (seen.containsKey(complement)) {
                return new int[] { seen.get(complement), i };
            }
            
            // Otherwise, add the current number and its index to the map
            seen.put(nums[i], i);
        }
        
        // Return an empty array if no solution is found (though the problem guarantees one)
        return new int[] {};
    }
}