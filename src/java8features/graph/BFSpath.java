package java8features.graph;

import java.util.ArrayList;
import java.util.List;

public class BFSpath {
    String key;
    public List<String> values;
    public BFSpath(){
        key = "";
        values = new ArrayList<>();
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(String value) {
        this.values.add(value);
    }

    @Override
    public String toString() {
        return "BFSpath{" +
                "values=" + values +
                '}';
    }
}
