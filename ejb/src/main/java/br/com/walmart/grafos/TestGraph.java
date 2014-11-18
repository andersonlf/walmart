/*
 * Desenvolvido por Anderson Lobo Feitosa, 2014
 */
package br.com.walmart.grafos;

public class TestGraph {

	public static void main(String... args) throws VertexException {

		Graph g = createGraph();

		printVertices(g);

		printEdges(g);

		Vertex v = g.getVertex("A");
//		GraphUtil.dethFirstSearch(v);
//
//		GraphUtil.resetStatus(g);
//
//		GraphUtil.breathFirstSearch(v);
//
//		GraphUtil.resetStatus(g);

		GraphUtil.dijkstra(v);
		GraphUtil.printShortestPathTo(g);
	}

	private static void printEdges(Graph g) {
		System.out.println("Edges = " + g.numEdges());
		for (Edge edge : g.edges()) {
			System.out.println("Edge = " + edge.getWeigth() + " "
					+ edge.getV1() + " - " + edge.getV2());
		}
		System.out.println();
	}

	private static void printVertices(Graph g) {
		System.out.println("Vertices = " + g.numVertices());
		for (Vertex vertex : g.vertices()) {
//			System.out.print("Vertex:" + vertex.getId() + "-"
//					+ vertex.getName());
			System.out.print("Vertex:" + vertex.getName());
			System.out.print(" - Adjacents");
			for (Vertex va : vertex.getAdjacents()) {
//				System.out.print(" - " + va.getId() + ":" + va.getName());
				System.out.print(" - " + va.getName());
			}
			System.out.println();
		}
	}

	private static Graph createGraph() throws VertexException {
		Graph g = new Graph();
		Vertex v0 = g.insertVertex(0, "A");
		Vertex v1 = g.insertVertex(1, "B");
		Vertex v2 = g.insertVertex(2, "C");
		Vertex v3 = g.insertVertex(3, "D");
		Vertex v4 = g.insertVertex(4, "E");
		g.insertEdge(v0, v1, 10);
		g.insertEdge(v1, v3, 15);
		g.insertEdge(v0, v2, 20);
		g.insertEdge(v2, v3, 30);
		g.insertEdge(v1, v4, 50);
		g.insertEdge(v3, v4, 30);
		return g;
	}
}