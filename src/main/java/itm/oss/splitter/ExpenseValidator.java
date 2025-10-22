package itm.oss.splitter;

import java.math.BigDecimal;

public class ExpenseValidator {
  public static void validate(Expense e) {
    // TODO (Issue 3): implement checks (payer nonblank, amount > 0, participants
    // nonempty, currency nonblank)
    // Keep empty for Phase 1.
    if (e.getPayer().isEmpty()) {
      throw new IllegalArgumentException("Payer is Empty! Pleases add payer");
    }

    if (e.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
      throw new IllegalArgumentException("Amount should be larger than 0");
    }

    if (e.getCurrency().isEmpty()) {
      throw new IllegalArgumentException("Currency is Empty! Please add currency");
    }

  }
}
