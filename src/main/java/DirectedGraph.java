import java.util.*;

public class DirectedGraph {

    private LinkedHashMap<String, List<Edge>> vertexMap = new LinkedHashMap<String, List<Edge>>();

    public void changeVertexName(Vertex vertex, String name) {
        List<Edge> value = vertexMap.get(vertex.getVertexName());
        vertexMap.remove(vertex.getVertexName());
        vertexMap.put(name, value);
    }

    public void changeVertexName(String prevName, String newName) {
        List<Edge> value = vertexMap.get(prevName);
        vertexMap.remove(prevName);
        vertexMap.put(newName, value);
    }
    
    public void changeEdgeWeight(String v1, String v2, int newWeight) {
        //Edge edge = vertexMap.get(v1);
        for (String key: getKeys()) {
            if (key.equals(v1))
            for (Edge edge: vertexMap.get(key)) {
                if (edge.getSecondNode().getVertexName().equals(v2)) edge.setWeight(newWeight);
            }
        }
        //edge.setWeight(newWeight);
    }

    public void changeEdgeWeight(Edge edge, int newWeight) {
        edge.setWeight(newWeight);
    }
    
    public List getEdgeInputs(String v){
        List edgeList = new ArrayList();
        for (String key: getKeys()) {
            for (Edge edge: vertexMap.get(key)) {
                if (edge.getSecondNode().equals(new Vertex(v))){
                    edgeList.add(edge);
                }
            }
        }
        return edgeList;
    }
    
    public List getEdgeOutputs(String v){
        return vertexMap.get(v);
    }

    public void deleteVertex(String v){
        vertexMap.remove(v);
    }

    public void deleteEdge(Edge edge){
        for (String key : getKeys()) {
            for (Edge e: vertexMap.get(key)) {
                if (e.equals(edge)) vertexMap.remove(key);
            }
        }

    }

    public Vertex addVertex(String vertexName) {
        Vertex vertex = new Vertex(vertexName);
        if (!vertexExist(vertexName)) {
            vertexMap.put(vertexName, new ArrayList<Edge>());
        }
        return vertex;
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

    public void addEdge(String firstVertex, String secondVertex, Integer weight) {

        //if (!edgeExist(vertex1, vertex2)) {
        if (!vertexExist(firstVertex)) addVertex(firstVertex);
        if (!vertexExist(secondVertex)) addVertex(secondVertex);
        List<Edge> edges = getValue(firstVertex);
        edges.add(new Edge(firstVertex, secondVertex, weight));
        //Collections.sort(edges);
        //}
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
        for (String key : getKeys()) {
            sb.append(key).append(":\n");
            for (Edge edge : vertexMap.get(key)) {
                sb.append(" -> ").append(
                        edge.getSecondNode().getVertexName()).append(" (Weight: ").append(
                        edge.getWeight()).append(");\n");

            }
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
