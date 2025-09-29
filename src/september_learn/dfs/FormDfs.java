package september_learn.dfs;

public class FormDfs {
    private String source;
    private String destination;

    public FormDfs(String source, String destination){
        this.source = source;
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "FormDfs{" +
                "source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                '}';
    }

    public void setSource(String source){
        this.source = source;
    }

    public String getSource(){
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
