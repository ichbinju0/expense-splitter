package itm.oss.splitter;

public class ExpenseValidator {
  public static void validate(Expense e) {
    // TODO (Issue 3): implement checks (payer nonblank, amount > 0, participants
    // nonempty, currency nonblank)
    // Keep empty for Phase 1.
    if (e.getPayer().isEmpty()) {
      System.err.println("error!");
    }
  }
}
