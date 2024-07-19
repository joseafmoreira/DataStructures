package dev.joseafmoreira.adts;

/**
 * <h2>
 * NetworkADT
 * </h2>
 * <p>
 * The <code>NetworkADT</code> interface that specifies the behavior of a network
 * </p>
 * <p>
 * This abstract data type extends {@link GraphADT}
 * </p>
 * <p>
 * Author: ESTG-ED-2324
 * </p>
 */
public interface NetworkADT<T> extends GraphADT<T> {
    /**
     * Adds an edge between two vertices in this network with the specified weight.
     *
     * @param vertex1 the first vertex of the edge
     * @param vertex2 the second vertex of the edge
     * @param weight the weight of the edge
     */
    void addEdge(T vertex1, T vertex2, double weight);

    /**
     * Calculates the weight of the shortest path between the startVertex and the targetVertex in this network.
     *
     * @param startVertex the starting vertex of the path
     * @param targetVertex the target vertex of the path
     * @return the weight of the shortest path between the startVertex and the targetVertex
     */
    double shortestPathWeight(T startVertex, T targetVertex);
}
