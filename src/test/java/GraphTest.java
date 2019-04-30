import org.junit.Assert;
import org.junit.Test;

public class GraphTest {


    @Test
    public void test(){
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

        System.out.println(directedGraph.toString());

        Assert.assertEquals("b4:\n" +
                "b1:\n" +
                " -> b2 (W: 2);\n" +
                " -> b3 (W: 1);\n" +
                " -> b4 (W: 5);\n" +
                " -> b5 (W: 2);\n" +
                " -> b6 (W: 7);\n" +
                " -> b7 (W: 1);\n" +
                "b3:\n" +
                "a1:\n" +
                " -> a2 (W: 2);\n" +
                "b2:\n" +
                "a2:\n" +
                "c1:\n" +
                " -> c2 (W: 4);\n" +
                "b5:\n" +
                "b7:\n" +
                "b6:\n" +
                "c2:\n", directedGraph.toString());
    }

    @Test
    public void existTest(){
        DirectedGraph directedGraph = new DirectedGraph();
        directedGraph.addEdge("q1","q2", 1);
        Assert.assertTrue(directedGraph.edgeExist("q1", "q2"));
        Assert.assertFalse(directedGraph.edgeExist("0", "1"));
        directedGraph.addVertex("0");
        directedGraph.addVertex("1");
        Assert.assertTrue(directedGraph.vertexExist("0"));
        Assert.assertFalse(directedGraph.edgeExist("0", "1"));
    }



}
