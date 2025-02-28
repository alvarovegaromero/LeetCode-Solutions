//https://leetcode.com/problems/candy

class Solution {
    public int candy(int[] ratings) {
        int size = ratings.length;

        int[] candies = new int[size];
        Arrays.fill(candies, 1);

        // Start left to right, comparing with left neighbour
        for(int i = 1; i < size ; i++)
            if(ratings[i - 1] < ratings[i])
                candies[i] = candies[i - 1] + 1;

        // Opposite - Only increase if current candy number is less than right neighbour
        int result = candies[size - 1];
        for(int i = size - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1])
                candies[i] = candies[i + 1] + 1;
                
            result += candies[i];
        }

        return result;
    }
}