import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int k;
    static List<List<Edge>> edges = new ArrayList<>();
    static long[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        distance = new long[n + 1];
        Arrays.fill(distance, 100_000_000_000L);

        for(int i = 0; i <= n; i++) {
            edges.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges.get(v).add(new Edge(u, c));
        }

        st = new StringTokenizer(br.readLine());
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        while (st.hasMoreTokens()) {
            int interviewLocation = Integer.parseInt(st.nextToken());
            pq.add(new Edge(interviewLocation, 0));
            distance[interviewLocation] = 0;
        }


        while (!pq.isEmpty()) {
            Edge currentEdge = pq.poll();

            if (currentEdge.distance > distance[currentEdge.cityNumber])
                continue;

            for (Edge next : edges.get(currentEdge.cityNumber)) {
                long nextDis = currentEdge.distance + next.distance;
                if (distance[next.cityNumber] > nextDis) {
                    pq.add(new Edge(next.cityNumber, nextDis));
                    distance[next.cityNumber] = nextDis;
                }
            }

        }

        long maxDistance = Integer.MIN_VALUE;
        int cityNumber = -1;
        for (int i = 1; i <= n; i++) {
            if (distance[i] > maxDistance) {
                maxDistance = distance[i];
                cityNumber = i;
            }
        }

        System.out.println(cityNumber);
        System.out.println(maxDistance);
    }


    static class Edge implements Comparable<Edge>{
        int cityNumber;
        long distance;

        public Edge(int cityNumber, long distance) {
            this.cityNumber = cityNumber;
            this.distance = distance;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.distance, o.distance);
        }
    }

}