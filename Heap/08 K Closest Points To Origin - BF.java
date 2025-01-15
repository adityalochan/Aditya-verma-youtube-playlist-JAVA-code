
public int[][] kClosest(int[][] points, int k) {
    // Step 1: Create a list to store points along with their distances
    List<int[]> pointList = new ArrayList<>();

    // Step 2: Calculate the distance squared for each point and store it in the list
    for (int[] point : points) {
        int distanceSquared = point[0] * point[0] + point[1] * point[1];  // Distance squared
        pointList.add(new int[]{distanceSquared, point[0], point[1]});
    }

    // Step 3: Sort the points by their distance (distance squared for simplicity)
    pointList.sort((a, b) -> Integer.compare(a[0], b[0]));  // Sort by distance

    // Step 4: Pick the first k points from the sorted list
    int[][] result = new int[k][2];
    for (int i = 0; i < k; i++) {
        result[i] = new int[]{pointList.get(i)[1], pointList.get(i)[2]};  // Extract coordinates
    }

    return result;
}
