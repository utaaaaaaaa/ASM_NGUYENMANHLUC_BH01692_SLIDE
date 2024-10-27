public class Dijkstra {
    static final int INF = Integer.MAX_VALUE;

    public int minDistance(int[] dist, boolean[] sptSet, int vertices) {
        int min = INF, minIndex = -1;
        for (int v = 0; v < vertices; v++)
            if (!sptSet[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        return minIndex;
    }

    public void dijkstra(int[][] graph, int src, int vertices) {
        int[] dist = new int[vertices];
        boolean[] sptSet = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            dist[i] = INF;
            sptSet[i] = false;
        }
        dist[src] = 0;

        for (int count = 0; count < vertices - 1; count++) {
            int u = minDistance(dist, sptSet, vertices);
            sptSet[u] = true;

            for (int v = 0; v < vertices; v++)
                if (!sptSet[v] && graph[u][v] != 0 &&
                        dist[u] != INF && dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }
    }
}
