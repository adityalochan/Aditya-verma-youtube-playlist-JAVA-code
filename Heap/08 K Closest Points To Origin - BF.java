--------------------------------------------------------------------------------------------------------------
 BRUTEFORCE 
--------------------------------------------------------------------------------------------------------------

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

--------------------------------------------------------------------------------------------------------------
 HEAP 
--------------------------------------------------------------------------------------------------------------

 public int[][] kClosest(int[][] points, int k) {
    // Max-heap to store the points and their distances
    PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

    // Step 1: Calculate the distance squared and add the points to the heap
    for (int[] point : points) {
        int distanceSquared = point[0] * point[0] + point[1] * point[1];  // Euclidean distance squared
        maxHeap.add(new int[]{distanceSquared, point[0], point[1]});

        // Step 2: Ensure the heap has at most k points
        if (maxHeap.size() > k) {
            maxHeap.poll();  // Remove the farthest point
        }
    }

    // Step 3: Extract the k closest points from the heap
    int[][] result = new int[k][2];
    int index = 0;
    while (!maxHeap.isEmpty()) {
        int[] point = maxHeap.poll();
        result[index++] = new int[]{point[1], point[2]};  // Store the point's coordinates
    }

    return result;
}
