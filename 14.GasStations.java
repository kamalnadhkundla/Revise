/*
 * We have a horizontal number line. On that number line, we have gas stations at positions stations[0], stations[1], ..., stations[n-1], where n is the size of the stations array. Now, we add k more gas stations so that d, the maximum distance between adjacent gas stations, is minimized. We have to find the smallest possible value of d. Find the answer exactly to 2 decimal places.
Note: stations is in a strictly increasing order
 */
public class 14.GasStations {

    // brute force so the end goal is minimize the answer, so if we have k gas stations where do we put them to get the min ans, in between the maximum distance right same in the array we will place the maximum sectors and place the gas stations

    public static double findSmallestMaxDist(int[] stations,int k){
        int n = stations.length;
        double maxans = 0;
        int[] sectorTrack = new int[n - 1]; 
    
        for (int cut = 1; cut <= k; cut++) {
            double maxval = 0;
            int maxIndex = -1;
    
            for (int j = 0; j < n - 1; j++) {
                int dist = stations[j + 1] - stations[j];
                double sector_dist = (double) dist / (sectorTrack[j] + 1);
                if (sector_dist > maxval) {
                    maxval = sector_dist;
                    maxIndex = j;
                }
            }
    
            sectorTrack[maxIndex]++;
        }
    
        for (int j = 0; j < n - 1; j++) {
            int dist = stations[j + 1] - stations[j];
            double sector_dist = (double) dist / (sectorTrack[j] + 1);
            maxans = Math.max(maxans, sector_dist);
        }
    
        return maxans;
    }
    
}
