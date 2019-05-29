import java.util.*;

public class DirectedGraph {

    private ArrayList<Edge> listEdges = new ArrayList<Edge>();

    public void changeVertexName(String prevName, String newName) {
        for (Edge edge : listEdges) {
            if (edge.getFirstNode().equals(new Vertex(prevName))) {
                edge.getFirstNode().setVertexName(newName);

            } else if (vertexExists(edge.getSecondNode().getVertexName())) {
                if (edge.getSecondNode().equals(new Vertex(prevName))) {
                    edge.getSecondNode().setVertexName(newName);

                }
            }
        }
    }

    public void changeEdgeWeight(String v1, String v2, int oldWEight, int newWeight) {
        for (Edge edge : listEdges) {
            if (edge.equals(new Edge(v1, v2, oldWEight))) {
                edge.setWeight(newWeight);
            }
        }
    }

    public List getEdgeInputs(String v) {
        ArrayList<Edge> inputs = new ArrayList<Edge>();
        for (Edge edge : listEdges) {
            if (edge.getFirstNode().getVertexName() != null &&
                    edge.getSecondNode().toString() != null &&
                    !edge.toString().equals("")) {
                if (edge.getSecondNode().getVertexName().equals(v)) {
                    inputs.add(edge);
                }
            }
        }
        return inputs;
    }




    public List getEdgeOutputs(String v) {
        ArrayList<Edge> outputs = new ArrayList<Edge>();
        for (Edge edge : listEdges) {
            if (edge.getFirstNode().getVertexName() != null &&
                    edge.getSecondNode().getVertexName() != null &&
                    !edge.toString().equals("")) {
                if (edge.getFirstNode().getVertexName().equals(v)) {
                    outputs.add(edge);
                }
            }
        }
        return outputs;
    }

    public void deleteVertex(String v) {
        for (Edge edge : listEdges) {
            if (edge.getFirstNode().getVertexName().equals(v)) {
                edge.setFirstNode(null);
            } else if (edge.getSecondNode().getVertexName().equals(v)) {
                edge.setSecondNode(null);
            }
        }
    }

    public void deleteEdge(Edge edge) {
        listEdges.remove(edge);

    }

    public boolean vertexExists(String v) {
        for (Edge edge : listEdges) {
            if (edge.getFirstNode() == null) return false;

            if (edge.getFirstNode().getVertexName().equals(v)
                    || edge.getSecondNode().equals(new Vertex(v))) return true;
        }
        return false;
    }

    public boolean edgeExists(Edge edge) {
        return listEdges.contains(edge);
    }

    public Vertex addVertex(String vertexName) {
        Edge edge = new Edge(vertexName, null, null);
        if (!listEdges.contains(edge) && !vertexExists(vertexName)) {
            listEdges.add(edge);
        }

        return edge.getFirstNode();
    }

    public void addEdge(String firstVertex, String secondVertex, Integer weight) {

        Edge edge = new Edge(firstVertex, secondVertex, weight);
        if (!edgeExists(edge)) {
            listEdges.add(edge);
        }
    }

    public  List<Edge> getGraph() {
        return listEdges;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < listEdges.size(); i++) {
            sb.append(listEdges.get(i).toString());
        }
        return sb.toString();
    }


    @Override
    public int hashCode() {
        return 32 + this.getGraph().hashCode() * 8;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!o.equals(this)) return false;
        if (o.getClass() != this.getClass()) return false;
        DirectedGraph dg = (DirectedGraph) o;
        return dg.getGraph().equals(this.getGraph());
    }

}
