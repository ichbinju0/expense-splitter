package itm.oss.splitter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Balance {
  private LinkedHashMap<String, BigDecimal> net = new LinkedHashMap<String, BigDecimal>();

  public void put(String name, BigDecimal amt) { net.put(name, amt); }

  public BigDecimal getAmount(String name) {
    BigDecimal v = net.get(name);
    if (v == null) return BigDecimal.ZERO;
    return v;
  }

  public String[] getNames() {
    ArrayList<String> keys = new ArrayList<String>(net.keySet());
    String[] out = new String[keys.size()];
    for (int i = 0; i < keys.size(); i++) out[i] = keys.get(i);
    return out;
  }

  public LinkedHashMap<String, BigDecimal> asMap() { return net; }
}
