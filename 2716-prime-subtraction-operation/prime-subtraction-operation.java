class Solution {
    public boolean primeSubOperation(int[] nums) {
        int n = nums.length;
        
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) continue;
            
            int dif = nums[i] - nums[i + 1];
            int p = findPrime(dif + 1);
            
            if (p >= nums[i]) return false;
            nums[i] -= p;
        }
        return true;
    }
    
    private int findPrime(int n) {
        if (isPrime(n)) return n;
        return findPrime(n + 1);
    }
    
    private boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}