package itm.oss.splitter;

import java.util.LinkedHashMap;
import java.util.ArrayList;

public class SimplePersonSummaryMap {
  private LinkedHashMap<String, PersonSummary> m = new LinkedHashMap<String, PersonSummary>();

  public void put(String name, PersonSummary ps) { m.put(name, ps); }
  public PersonSummary get(String name) { return m.get(name); }

  public String[] keys() {
    ArrayList<String> keys = new ArrayList<String>(m.keySet());
    String[] out = new String[keys.size()];
    for (int i = 0; i < keys.size(); i++) out[i] = keys.get(i);
    return out;
  }
}
