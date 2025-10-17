package itm.oss.splitter;

import java.io.IOException;
import java.util.ArrayList;

public class ExpenseStore {

  public ArrayList<Expense> load(String path) throws IOException {
    // TODO (Issue 1): parse CSV file into Expense list.
    // Format: date,payer,amount,currency,participants,category,notes
    // participants are semicolon-separated.
    throw new UnsupportedOperationException("load() not implemented yet");
  }

  public void append(String path, Expense e) throws IOException {
    // TODO (Issue 2): append a row to CSV (create file with header if missing).
    throw new UnsupportedOperationException("append() not implemented yet");
  }

  // Optional helper
  Expense parseLine(String line) {
    // split by comma (basic), then build Expense (participants split by ';')
    throw new UnsupportedOperationException("parseLine() not implemented yet");
  }
}
