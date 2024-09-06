import java.util.*;
import java.io.*;

class Main {
    static int INF = Integer.MAX_VALUE;
    static int V, E, K;
    static List<Node>[] list;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        
        list = new ArrayList[V+1];
        for(int i=1;i<=V;i++)
            list[i] = new ArrayList<>();
        
        for(int i=0;i<E;i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            
            list[s].add(new Node(d, w));
        }
        
        int[] dist = new int[V+1];
        for(int i=1;i<=V;i++) {
            if(i != K)
                dist[i] = INF;
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(K, 0));
        
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            
            if(dist[now.idx] < now.weight) continue;
            
            for(Node n:list[now.idx]) {
                int temp = now.weight + n.weight;
                if(dist[n.idx] > temp) {
                    dist[n.idx] = temp;
                    pq.add(new Node(n.idx, temp));
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=V;i++) {
            if(dist[i] == INF)
                sb.append("INF" + "\n");
            else sb.append(dist[i] + "\n");
        }
        
        System.out.print(sb);
    }
}

class Node implements Comparable<Node> {
    int idx, weight;
    
    Node(int idx, int weight) {
        this.idx = idx;
        this.weight = weight;
    }
    
    public int compareTo(Node n) {
        return this.weight > n.weight ? 1 : -1;
    }
}