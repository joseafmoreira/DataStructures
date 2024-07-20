package dev.joseafmoreira.adts;

import java.util.Iterator;

/**
 * <h2>
 * GraphADT
 * </h2>
 * <p>
 * The {@code GraphADT} interface that specifies the behavior of a graph
 * </p>
 * <p>
 * Author: ESTG-ED-2324
 * </p>
 */
public interface GraphADT<T> {
    /**
     * Adds a vertex to this graph.
     *
     * @param vertex the vertex to be added
     */
    void addVertex(T vertex);

    /**
     * Removes the specified vertex from this graph.
     *
     * @param vertex the vertex to be removed
     */
    void removeVertex(T vertex);

    /**
     * Adds an edge between two vertices in this graph.
     *
     * @param vertex1 the first vertex of the edge
     * @param vertex2 the second vertex of the edge
     */
    void addEdge(T vertex1, T vertex2);

    /**
     * Removes the edge between two vertices in this graph.
     *
     * @param vertex1 the first vertex of the edge
     * @param vertex2 the second vertex of the edge
     */
    void removeEdge(T vertex1, T vertex2);

    /**
     * Returns an iterator that performs a breadth-first search traversal of this graph.
     *
     * @return an iterator that traverses this graph in breadth-first order
     */
    Iterator<T> iteratorBFS();

    /**
     * Returns an iterator for performing a depth-first search traversal of this graph.
     *
     * @return an iterator for depth-first search traversal
     */
    Iterator<T> iteratorDFS();

    /**
     * Returns an iterator that traverses the shortest path from the startVertex to the targetVertex in this graph.
     * The iterator visits each vertex in the path in the order they appear in the path.
     *
     * @param startVertex the starting vertex of the path
     * @param targetVertex the target vertex of the path
     * @return an iterator that traverses the shortest path from the startVertex to the targetVertex
     */
    Iterator<T> iteratorShortestPath(T startVertex, T targetVertex);

    /**
     * Checks if this graph is connected.
     *
     * @return true if this graph is connected, false otherwise.
     */
    boolean isConnected();

    /**
     * Checks if this graph is empty.
     *
     * @return true if this graph is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Returns the number of vertices in this graph.
     *
     * @return the number of vertices in this graph
     */
    int size();

    /**
     * Returns a string representation of this graph.
     *
     * @return a string representation of this graph
     */
    @Override
    String toString();
}
