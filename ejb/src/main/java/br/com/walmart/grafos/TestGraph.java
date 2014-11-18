/*
 * Desenvolvido por Anderson Lobo Feitosa, 2014
 */
package br.com.walmart.grafos;

public class TestGraph {

	public static void main(String... args) throws VertexException {

		Graph g = createGraph();

		printVertices(g);

		printEdges(g);

		Vertex v = g.getVertex(0);
		GraphUtil.dethFirstSearch(v);

		GraphUtil.resetStatus(g);

		GraphUtil.breathFirstSearch(v);

		GraphUtil.resetStatus(g);

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
			System.out.print("Vertex:" + vertex.getId() + "-"
					+ vertex.getName());
			System.out.print(" - Adjacents");
			for (Vertex va : vertex.getAdjacents()) {
				System.out.print(" - " + va.getId() + ":" + va.getName());
			}
			System.out.println();
		}
	}

	private static Graph createGraph() throws VertexException {
		Graph g = new Graph();
		Vertex v0 = g.insertVertex(0, "V0");
		Vertex v1 = g.insertVertex(1, "V1");
		Vertex v2 = g.insertVertex(2, "V2");
		Vertex v3 = g.insertVertex(3, "V3");
		Vertex v4 = g.insertVertex(4, "V4");
		Vertex v5 = g.insertVertex(5, "V5");
		Vertex v6 = g.insertVertex(6, "V6");
		g.insertEdge(v0, v1, 2);
		g.insertEdge(v0, v2, 3);
		g.insertEdge(v0, v3, 4);
		g.insertEdge(v1, v4, 7);
		g.insertEdge(v1, v2, 1);
		g.insertEdge(v2, v5, 9);
		g.insertEdge(v2, v3, 2);
		g.insertEdge(v3, v6, 1);
		g.insertEdge(v4, v5, 2);
		g.insertEdge(v5, v6, 2);
		return g;
	}
}