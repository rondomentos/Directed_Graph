public class Vertex {

    private String vertexName;

    public Vertex(String vertexName){

        this.vertexName = vertexName;
    }


    public String getVertexName() {
        return vertexName;
    }

    public void setVertexName(String vertexName) {
        this.vertexName = vertexName;
    }

    @Override
    public String toString(){
        return vertexName;
    }
    @Override
    public int hashCode(){
        return 32 + this.getVertexName().hashCode() * 8;
    }

    @Override
    public boolean equals(Object o){
        if (o == null) return false;
        if (o.getClass() != this.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return vertex.getVertexName().equals(this.getVertexName());
    }
}
