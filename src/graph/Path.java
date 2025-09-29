package graph;

import java.util.ArrayList;
import java.util.List;

public class Path {
    String key;

    public List<String> values;

    public Path(){
        values = new ArrayList<String>();
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
}
