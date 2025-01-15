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
