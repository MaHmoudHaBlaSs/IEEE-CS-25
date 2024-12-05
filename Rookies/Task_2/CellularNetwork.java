import java.util.Scanner;

public class CellularNetwork {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int citiesN = scn.nextInt();
        int towersN = scn.nextInt();
        int[] cities = new int[citiesN];
        int[] towers = new int[towersN];
        for(int i = 0; i < citiesN; i++)
            cities[i] = scn.nextInt();
        for(int i = 0; i < towersN; i++)
            towers[i] = scn.nextInt();

        // Solution
        // Firstly, we need to know the nearest tower for each city.
        // Then, we will need to get distances between each city and its tower and continue with the max distance
        System.out.println(getMinRadius(cities, towers));
    }
    public static int getMinRadius(int[] cities, int[] towers){
        int maxR = 0;
        for (int city: cities) {
            int r = getNearestTowerDistance(city, towers);
            maxR = Math.max(maxR, r);
        }
        return maxR; // maxR ind NearestDistances is the min radius that any tower should have.
    }
    public static int getNearestTowerDistance(int city, int[] towers){ // Returning distance !!
        int l = 0, r = towers.length-1;

        while (l<=r){
            int mid = (l+r)/2;

            if (towers[mid] > city)
                r = mid-1;
            else if (towers[mid] < city)
                l = mid+1;
            else{ // towers[mid] == city
                return 0; // Exact match
            }
        }
        // loop will break if only left exceeded right or right exceeded left
        // this means left moves to right, and right moves to left.
        // so in all cases when the loop breaks left pointer will point to a point right to the city
        // and right pointer will point to a point left to the city
        // If this violation happened outside array boundaries it will be undefined and because we are
        // searching for min distance this side will be taken to infinity as it's imaginary distance.
        int rightNearestDistance = (l < towers.length)?Math.abs(city - towers[l]):Integer.MAX_VALUE;
        int leftNearestDistance = (r >= 0)?Math.abs(city - towers[r]):Integer.MAX_VALUE;
        // now we know the distances between the city and towers in both sides (if existed in both)

        return Math.min(rightNearestDistance, leftNearestDistance);
    }
}