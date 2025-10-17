package itm.oss.splitter;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.ArrayList;

public class SimpleMap {
  private LinkedHashMap<String, BigDecimal> m = new LinkedHashMap<String, BigDecimal>();

  public void put(String key, BigDecimal value) { m.put(key, value); }
  public BigDecimal get(String key) { return m.get(key); }

  public String[] keys() {
    ArrayList<String> keys = new ArrayList<String>(m.keySet());
    String[] out = new String[keys.size()];
    for (int i = 0; i < keys.size(); i++) out[i] = keys.get(i);
    return out;
  }
}
