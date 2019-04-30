public class Edge {

    private Integer weight;
    private Vertex firstNode;
    private Vertex secondNode;

    public Edge(Vertex firstNode, Vertex secondNode, Integer weight) {
        this.weight = weight;
        this.firstNode = firstNode;
        this.secondNode = secondNode;
    }

    public Edge(Vertex firstNode, Vertex secondNode) {
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
        return firstNode.toString() + " -> " + secondNode.toString() + " (W: " + weight + ");";
    }

    @Override
    public int hashCode(){
        return 8 * (this.getWeight().hashCode() + this.getFirstNode().hashCode() + this.getFirstNode().hashCode());
    }

    @Override
    public boolean equals(Object o){
        if (o == null) return false;
        if (!o.equals(this)) return false;
        if (o.getClass() != this.getClass()) return false;
        Edge edge = (Edge) o;
        return edge.getFirstNode().equals(this.getFirstNode())
                && edge.getSecondNode().equals(this.getSecondNode())
                && edge.getWeight().equals(this.getWeight());
    }
}

