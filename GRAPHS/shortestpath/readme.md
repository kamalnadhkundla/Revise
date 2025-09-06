Djkastra does not work when there is negative weight or negative cycle.
do path with minimum effort, cheapest filight with k stops,network delay time
dijkstra whenever graph comes with postive distances.
but lets assume some of the weights are -ve in that case use bellman ford.
why do we use bellman ford instead of dijkstra ? bellman ford works with the directed edges, even if they are given undirected graph convert it to an directed graph.
Because Dijkstra works like this:

It picks the node with the smallest distance seen so far.

It says “this distance is final” and never looks back.

If later we discover a negative edge, that earlier “final” distance could actually be wrong → Dijkstra fails.

How bellman ford works run the loop for v-1 times thats it instead of doing once like dijkstra we iteerate over v-1 times
but why ? cause the intuition  is if there are v vertices in the graph we believe that a node needs v-1 edges at most to reach the destination. like A->B->C, so iterating V-1 times means since in a graph of N nodes, in worst case we iterate N-1 times to reach to end.
Each relaxation step guarantees shortest paths using a certain number of edges:

After 1st iteration → shortest paths that use at most 1 edge.

After 2nd iteration → shortest paths that use at most 2 edges.

…

After (V-1)th iteration → shortest paths that use at most V-1 edges. Here we follow the standard bellman algorithm rather than a priority queue. if the total weight is less than 0 meaning thats a negative cycle.
 

 Floyd Warshall Algorithm
 -----------------------
 this is multi node shortest algorithm so from every node we can say the shortest dist to another node. unlinke djkstra and bellamn ford as they are single source shortest path.
 