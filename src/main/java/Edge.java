public class Edge {

    private Integer weight;
    private Vertex firstNode;
    private Vertex secondNode;

    public Edge(String v1, String v2, Integer weight) {
        Vertex firstNode = new Vertex(v1);
        Vertex secondNode = new Vertex(v2);
        this.weight = weight;
        this.firstNode = firstNode;
        this.secondNode = secondNode;
    }


    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Vertex getFirstNode() {
        return firstNode;
    }

    public void setFirstNode(Vertex firstNode) {
        this.firstNode = firstNode;
    }

    public Vertex getSecondNode() {
        return secondNode;
    }

    public void setSecondNode(Vertex secondNode) {
        this.secondNode = secondNode;
    }

    @Override
    public String toString() {
        String s = "";
        String vertexOutput = firstNode.toString()+"\n";
        if (secondNode.toString() != null && firstNode.toString() != null) {
            s = firstNode.toString() + ":\n -> " + secondNode.toString() + " (Weight: " + weight + ");\n";
        } else if (firstNode.toString() != null) s = vertexOutput;

        return s;
    }

    @Override
    public int hashCode() {
        return 8 * (this.getWeight().hashCode() + this.getFirstNode().hashCode() + this.getFirstNode().hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o.getClass() != this.getClass()) return false;
        Edge edge = (Edge) o;
        if (edge.getFirstNode() == null) return false;
        if (edge.getSecondNode().getVertexName() == null && this.getSecondNode().getVertexName() == null) {
            if (edge.getFirstNode().getVertexName().equals(this.getFirstNode().getVertexName())) {
                return true;
            }
        } else if (edge.getSecondNode().getVertexName() == null
                || this.getSecondNode().getVertexName() == null) return false;
        return edge.getFirstNode().getVertexName().equals(this.getFirstNode().getVertexName())
                && edge.getSecondNode().getVertexName().equals(this.getSecondNode().getVertexName())
                && edge.getWeight().equals(this.getWeight());
    }
}

