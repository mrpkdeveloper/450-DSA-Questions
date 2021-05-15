package graphs;

import java.util.Arrays;

public class bridgeinagraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] adj = { { 0, 1, 1, 0 }, { 1, 0, 1, 1 }, { 1, 1, 0, 0 }, { 0, 1, 0, 0 } };
		bridge(adj);

	}

	public static void bridge(int[][] adj) {
		int[] vis = new int[adj.length];
		int[] par = new int[adj.length];
		int[] rt = new int[adj.length];
		int[] lt = new int[adj.length];

		Arrays.fill(par, -1);
		Arrays.fill(rt, -1);
		Arrays.fill(lt, -1);

		for (int i = 0; i < adj.length; i++) {
			if (vis[i] == 0) {
				dfs(adj, vis, par, rt, lt, i, 0);
			}
		}

	}

	// tarjans algo
	public static void dfs(int[][] adj, int[] vis, int[] par, int[] rt, int[] lt, int src, int t) {
		vis[src] = 1;
		rt[src] = t;
		lt[src] = t;
		int[] nbr = adj[src];
		for (int i = 0; i < nbr.length; i++) {
			if (nbr[i] == 1 && vis[i] == 0) {  
				par[i] = src;
				dfs(adj, vis, par, rt, lt, i, t + 1);
				lt[src] = Math.min(lt[src], lt[i]);
				if (lt[i] > rt[src]) {
					System.out.println(src + " - " + i);
				}
			} else if (nbr[i] == 1 && i != par[src]) {
				lt[src] = Math.min(lt[src], rt[i]);    
			}
		}
	}

}
