//https://leetcode.com/problems/median-of-two-sorted-arrays

// First Solution - Time Efficiency O(n + m), Space Efficiency (n + m)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] newArray = new int [nums1.length + nums2.length];
        int i = 0, nums1Index = 0, nums2Index = 0;

        while(nums1Index < nums1.length && nums2Index < nums2.length) {
            if(nums1[nums1Index] < nums2[nums2Index]) 
                newArray[i++] = nums1[nums1Index++];
            else
                newArray[i++] = nums2[nums2Index++];
        }

        while(nums1Index < nums1.length)
            newArray[i++] = nums1[nums1Index++];

        while (nums2Index < nums2.length)
            newArray[i++] = nums2[nums2Index++];

        if(newArray.length % 2 != 0)
            return newArray[newArray.length / 2];
        else
            return (newArray[newArray.length / 2] + newArray[(newArray.length / 2) - 1]) / 2.0;
    }
}

// Second Solution - Time Efficiency O(n + m), Space Efficiency O(1)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0;
        int size1 = nums1.length;
        int size2 = nums2.length;
        int i = 0, nums1Index = 0, nums2Index = 0, med = 0, prevMed = 0;

        while(i <= (size1 + size2) / 2) {
            prevMed = med;

            if(nums1Index < size1 && nums2Index < size2) {
                if(nums1[nums1Index] < nums2[nums2Index])
                    med = nums1[nums1Index++];
                else
                    med = nums2[nums2Index++];
            } else if (nums1Index < size1)
                med = nums1[nums1Index++];
            else 
                med = nums2[nums2Index++];

            i++;
        }

        if((size1 + size2) % 2 != 0)
            return med;
        else
            return (med + prevMed) / 2.0;
    }
}

//Third Solution - Time Efficiency O(log(min(n, m))), Space Efficiency O(1)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size1 = nums1.length, size2 = nums2.length;
        
        if (size1 > size2)
            return findMedianSortedArrays(nums2, nums1);
        
        int totalSize = size1 + size2;
        // Left size ("arrays combined"). If totalSize is odd, +1 element
        int leftSize = (size1 + size2 + 1) / 2;
        // Binary search params for searching in nums1
        int low = 0, high = size1; 
        
        while (low <= high) {
            // Calculate mid index for nums1. So mid1 + mid2 = left
            int mid1 = (low + high) >> 1; // = (low + high) / 2 
            int mid2 = leftSize - mid1; // Calculate mid index for nums2.
            
            // Default values for vars used for the elements located
            // at the left or right of mid1 and mid2 respectively.
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE,
                r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
            
            // Determine real values of l1, l2, r1, and r2
            // If sizes are < 2, default values are used.
            if (mid1 < size1)
                r1 = nums1[mid1];
            if (mid2 < size2)
                r2 = nums2[mid2];
            if (mid1 - 1 >= 0)
                l1 = nums1[mid1 - 1];
            if (mid2 - 1 >= 0)
                l2 = nums2[mid2 - 1];
            

            // The partition is correct, we found the median
            if (l1 <= r2 && l2 <= r1) {
                if (totalSize % 2 == 1)
                    return Math.max(l1, l2);
                else
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
            }
            // Move towards the left side of nums1
            else if (l1 > r2) 
                high = mid1 - 1;
            // Move towards the right side of nums1 (l2 > r1)
            else
                low = mid1 + 1;
        }
        
        return 0; // If the code reaches here, the arrays were not sorted.
    }
}