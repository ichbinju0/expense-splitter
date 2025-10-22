package itm.oss.splitter;

import java.math.BigDecimal;

public class ExpenseValidator {
  public static void validate(Expense e) {
    // TODO (Issue 3): implement checks (payer nonblank, amount > 0, participants nonempty, currency nonblank)
    
    //Checking if payer is empty
    if (e.getPayer().isBlank()) {
      // modify isEmpty -> isBlank: for more safe check !!
      throw new IllegalArgumentException("Payer is Empty! Please add payer"); 
    }

    //Checking if amount is larger than 0
    if (e.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
      throw new IllegalArgumentException("Amount should be larger than 0");
    }

    //Checking if currency is empty
    if (e.getCurrency().isBlank()) {
      throw new IllegalArgumentException("Currency is Empty! Please add currency");
    }

    //Checking if the list(participants) is not empty
    if (e.getParticipants().isEmpty()) {
      throw new IllegalArgumentException("Participants list cannot be empty.");
    }

    //Checking if participant in the list(participants) is empty
    for (String participant : e.getParticipants()) {
      if (participant.isBlank()) {
        throw new IllegalArgumentException("Participant name cannot be blank.");
      }
    }
    //Checking if date is blank
    if (e.getDate().isBlank()) {
      throw new IllegalArgumentException("Date cannot be blank.");
    }

  }
}
