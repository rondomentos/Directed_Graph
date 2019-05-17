import java.util.*;

public class DirectedGraph {

    private LinkedHashMap<String, List<Edge>> vertexMap = new LinkedHashMap<String, List<Edge>>();

    public void changeVertexName(Vertex vertex, String name) {
        List<Edge> value = vertexMap.get(vertex.getVertexName());
        vertexMap.remove(vertex.getVertexName());
        vertexMap.put(name, value);
    }

    public void changeVertexName(String prevName, String newName) {
//        List<Edge> value = vertexMap.get(prevName);
//        vertexMap.remove(prevName);
//        vertexMap.put(newName, value);
        //Vertex prevVertex = new Vertex(prevName);


        for (Edge edge : listEdges) {
            if (edge.getFirstNode().equals(new Vertex(prevName))) {
                edge.getFirstNode().setVertexName(newName);
                //listEdges.add(new Edge(newName, edge.getSecondNode().getVertexName(), edge.getWeight()));
                //listEdges.remove(edge);
            } else if (vertexExists(edge.getSecondNode().getVertexName())) {
                if (edge.getSecondNode().equals(new Vertex(prevName))) {
                    edge.getSecondNode().setVertexName(newName);
                    //listEdges.add(new Edge(edge.getFirstNode().getVertexName(), newName, edge.getWeight()));
                    //listEdges.remove(edge);
                }
            }
        }
    }

    public void changeEdgeWeight(String v1, String v2, int oldWEight, int newWeight) {
        //Edge edge = vertexMap.get(v1);

//        for (String key: getKeys()) {
//            if (key.equals(v1))
//            for (Edge edge: vertexMap.get(key)) {
//                if (edge.getSecondNode().getVertexName().equals(v2)) edge.setWeight(newWeight);
//            }
//        }
        for (Edge edge : listEdges) {
            if (edge.equals(new Edge(v1, v2, oldWEight))) {
                edge.setWeight(newWeight);
            }
        }
    }

    public void changeEdgeWeight(Edge edge, int newWeight) {
        edge.setWeight(newWeight);
    }

    public List getEdgeInputs(String v) {
//        List edgeList = new ArrayList();
//        for (String key: getKeys()) {
//            for (Edge edge: vertexMap.get(key)) {
//                if (edge.getSecondNode().equals(new Vertex(v))){
//                    edgeList.add(edge);
//                }
//            }
//        }
//        return edgeList;
        ArrayList<Edge> inputs = new ArrayList<Edge>();
        for (Edge edge : listEdges) {
            if (edge.getSecondNode().toString() != null && !edge.toString().equals("")) {
                if (edge.getSecondNode().getVertexName().equals(v)) {
                    inputs.add(edge);
                }
            }
        }
        return inputs;
    }

    ArrayList<Edge> listEdges = new ArrayList<Edge>();


    public List getEdgeOutputs(String v) {
        ArrayList<Edge> outputs = new ArrayList<Edge>();
        for (Edge edge : listEdges) {
            if (edge.getFirstNode().toString() != null && !edge.toString().equals("")) {
                if (edge.getFirstNode().getVertexName().equals(v)) {
                    outputs.add(edge);
                }
            }
        }
        return outputs;
        //return vertexMap.get(v);
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
        Vertex vertex = new Vertex(vertexName);
        if (!vertexExist(vertexName)) {
            vertexMap.put(vertexName, new ArrayList<Edge>());
        }
        return vertex;
    }

    public void addEdge(String firstVertex, String secondVertex, Integer weight) {

        Edge edge = new Edge(firstVertex, secondVertex, weight);

//        for (Edge e: listEdges) {
//            if (!edge.getFirstNode().getVertexName().equals(firstVertex) && edge.getSecondNode() != null){
//                listEdges.remove(e);
//            }
//        }
        if (!edgeExists(edge)) {
            listEdges.add(edge);
        }

        //if (!edgeExist(vertex1, vertex2)) {
//        if (!vertexExist(firstVertex)) addVertex(firstVertex);
//        if (!vertexExist(secondVertex)) addVertex(secondVertex);
//        List<Edge> edges = getValue(firstVertex);
//        edges.add(new Edge(firstVertex, secondVertex, weight));
        //Collections.sort(edges);
        //}
    }

    public boolean vertexExist(String vertexName) {
        return vertexMap.containsKey(vertexName);
    }

    public boolean edgeExist(String firstVertex, String secondVertex) {
        // Edge edge = new Edge(firstVertex, secondVertex);
        if (!vertexExist(firstVertex) || !vertexExist(secondVertex)) return false;
        List<Edge> edges = vertexMap.get(firstVertex);
        for (Edge edge : edges) {
            if (edge.getFirstNode().getVertexName().equals(firstVertex) &&
                    edge.getSecondNode().getVertexName().equals(secondVertex)) return true;
        }
        return false;
    }


    public Map<String, List<Edge>> getGraph() {
        return vertexMap;
    }

    private List<Edge> getValue(String name) {
        List<Edge> value = new ArrayList<Edge>();
        for (String key : getKeys()) {
            if (key.equals(name)) value = vertexMap.get(key);
        }
        return value;
    }

    private List<String> getKeys() {
        return new ArrayList<String>(vertexMap.keySet());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
//        for (String key : getKeys()) {
//            sb.append(key).append(":\n");
//            for (Edge edge : vertexMap.get(key)) {
//                sb.append(" -> ").append(
//                        edge.getSecondNode().getVertexName()).append(" (Weight: ").append(
//                        edge.getWeight()).append(");\n");
//
//            }
//        }

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
