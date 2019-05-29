import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GraphTest {


    @Test
    public void addingElementsTest() {
        DirectedGraph directedGraph = new DirectedGraph();
        directedGraph.addEdge("a1", "a2", 2);
        directedGraph.addVertex("b1");
        directedGraph.addVertex("b2");
        directedGraph.addVertex("c1");
        directedGraph.addEdge("c1", "c2", 4);
        directedGraph.addEdge("b1", "b2", 2);
        directedGraph.addEdge("b1", "b3", 1);
        directedGraph.addEdge("b1", "b4", 5);
        directedGraph.addEdge("b1", "b5", 2);
        directedGraph.addEdge("b1", "b6", 7);
        directedGraph.addEdge("b1", "b7", 1);
        directedGraph.addVertex("0000");
        Assert.assertEquals("a1:\n" +
                " -> a2 (Weight: 2);\n" +
                "b1\n" +
                "b2\n" +
                "c1\n" +
                "c1:\n" +
                " -> c2 (Weight: 4);\n" +
                "b1:\n" +
                " -> b2 (Weight: 2);\n" +
                "b1:\n" +
                " -> b3 (Weight: 1);\n" +
                "b1:\n" +
                " -> b4 (Weight: 5);\n" +
                "b1:\n" +
                " -> b5 (Weight: 2);\n" +
                "b1:\n" +
                " -> b6 (Weight: 7);\n" +
                "b1:\n" +
                " -> b7 (Weight: 1);\n" +
                "0000\n", directedGraph.toString());
        Assert.assertEquals("000", directedGraph.addVertex("000").getVertexName());
    }

    @Test
    public void existTest() {
        DirectedGraph directedGraph = new DirectedGraph();
        directedGraph.addEdge("q1", "q2", 1);
        Assert.assertTrue(directedGraph.edgeExists(new Edge("q1", "q2", 1)));
        Assert.assertFalse(directedGraph.edgeExists(new Edge("0", "1", 1)));
        directedGraph.addVertex("0");
        directedGraph.addVertex("1");
        Assert.assertTrue(directedGraph.vertexExists("0"));
        Assert.assertFalse(directedGraph.edgeExists(new Edge("0", "1", 1)));
    }

    @Test
    public void equalsTest() {
        Vertex firstV = new Vertex("a");
        Vertex secondV = new Vertex("a");
        Assert.assertEquals(firstV, secondV);
        secondV = new Vertex("b");
        Assert.assertNotEquals(firstV, secondV);
        Edge firstE = new Edge(firstV.getVertexName(), secondV.getVertexName(), 1);
        Edge secondE = new Edge(firstV.getVertexName(), secondV.getVertexName(), 1);
        Assert.assertEquals(firstE, secondE);
        secondE = new Edge(firstV.getVertexName(), secondV.getVertexName(), 2);
        Assert.assertNotEquals(firstE, secondE);
        secondE = new Edge(firstV.getVertexName(), firstV.getVertexName(), 1);
        Assert.assertNotEquals(firstE, secondE);

    }

    @Test
    public void gettingEdgeInpOrOutp() {
        DirectedGraph directedGraph = new DirectedGraph();
        directedGraph.addVertex("in1");
        directedGraph.addVertex("in2");
        directedGraph.addEdge("in1", "out1", 1);
        directedGraph.addEdge("in1", "out2", 1);
        directedGraph.addEdge("in1", "out3", 1);
        directedGraph.addEdge("in2", "out2", 2);
        directedGraph.addEdge("in3", "out2", 2);
        directedGraph.addEdge("in4", "out2", 2);
        List<Edge> expected = new ArrayList<Edge>();
        expected.add(new Edge("in1", "out1", 1));
        expected.add(new Edge("in1", "out2", 1));
        expected.add(new Edge("in1", "out3", 1));
        Assert.
                assertEquals(expected, directedGraph.getEdgeOutputs("in1"));
        expected = new ArrayList<Edge>();
        expected.add(new Edge("in1", "out2", 1));
        expected.add(new Edge("in2", "out2", 2));
        expected.add(new Edge("in3", "out2", 2));
        expected.add(new Edge("in4", "out2", 2));
        Assert.assertEquals(expected, directedGraph.getEdgeInputs("out2"));
    }

    @Test
    public void deletingElementsTest() {
        DirectedGraph directedGraph = new DirectedGraph();
        directedGraph.addVertex("a");
        Assert.assertTrue(directedGraph.vertexExists("a"));
        directedGraph.deleteVertex("a");
        Assert.assertFalse(directedGraph.vertexExists("a"));
        directedGraph.addEdge("a", "b", 10);
        Assert.assertTrue(directedGraph.edgeExists(new Edge("a", "b", 10)));
        directedGraph.deleteEdge(new Edge("a", "b", 10));
        Assert.assertFalse(directedGraph.edgeExists(new Edge("a", "b", 10)));
    }

    @Test
    public void changingElementsTest() {
        DirectedGraph directedGraph = new DirectedGraph();
        directedGraph.addVertex("a");
        directedGraph.addEdge("a", "c", 1);
        Assert.assertTrue(directedGraph.edgeExists(new Edge("a", "c", 1)));
        directedGraph.changeVertexName("a", "b");
        Assert.assertTrue(directedGraph.edgeExists(new Edge("b", "c", 1)));
        Assert.assertFalse(directedGraph.edgeExists(new Edge("a", "c", 1)));
        directedGraph.addEdge("c", "b", 128);
        directedGraph.changeEdgeWeight("c", "b", 128, 1488);
        Assert.assertTrue(directedGraph.edgeExists(new Edge("c","b", 1488)));
    }

}
