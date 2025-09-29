package september_learn.dfs;

import java.util.List;

public class AdjDfs {
    private String key;
    private List<String> value;

    public AdjDfs(String key, List<String> value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<String> getValue() {
        return value;
    }

    public void setValue(List<String> value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "AdjDfs{" +
                "key='" + key + '\'' +
                ", value=" + value +
                '}';
    }
}
