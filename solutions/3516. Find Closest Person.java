//https://leetcode.com/problems/find-closest-person

// Use absolute difference to find the closest using the URM equation
// xfinal = speed*time + xorigin => t = (xf - xo)/s and since s = 1 and 
// time is positive => t = |xf - x0|
// Time Complexity: O(1)
// Space Complexity: O(1)
class Solution {
    public int findClosest(int x, int y, int z) {
        int timeX = Math.abs(z - x);
        int timeY = Math.abs(z - y);

        if(timeX == timeY)
            return 0;
        else if(timeX < timeY)
            return 1;
        else
            return 2;
    }
}