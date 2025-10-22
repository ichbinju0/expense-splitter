package itm.oss.splitter;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class ExpenseValidatorTest {

    @Test
    void validExpenseDoesNotThrow() {
        ArrayList<String> participants = new ArrayList<>(Arrays.asList("Bob", "Charlie"));
        Expense e = new Expense("2025-10-22", "Alice", new BigDecimal("100.00"), "USD", participants, "Food", "Lunch");
        assertDoesNotThrow(() -> ExpenseValidator.validate(e));
    }

    @Test
    void blankPayerThrows() {
        ArrayList<String> participants = new ArrayList<>(Arrays.asList("Bob"));
        Expense e = new Expense("2025-10-22", "", new BigDecimal("100.00"), "USD", participants, "Food", "Lunch");
        Exception ex = assertThrows(IllegalArgumentException.class, () -> ExpenseValidator.validate(e));
        assertEquals("Payer is Empty! Please add payer", ex.getMessage());
    }

    @Test
    void zeroAmountThrows() {
        ArrayList<String> participants = new ArrayList<>(Arrays.asList("Bob"));
        Expense e = new Expense("2025-10-22", "Alice", BigDecimal.ZERO, "USD", participants, "Food", "Lunch");
        Exception ex = assertThrows(IllegalArgumentException.class, () -> ExpenseValidator.validate(e));
        assertEquals("Amount should be larger than 0", ex.getMessage());
    }

    @Test
    void emptyParticipantsThrows() {
        ArrayList<String> participants = new ArrayList<>();
        Expense e = new Expense("2025-10-22", "Alice", new BigDecimal("100.00"), "USD", participants, "Food", "Lunch");
        Exception ex = assertThrows(IllegalArgumentException.class, () -> ExpenseValidator.validate(e));
        assertEquals("Participants list cannot be empty.", ex.getMessage());
    }

    @Test
    void blankParticipantThrows() {
        ArrayList<String> participants = new ArrayList<>(Arrays.asList("Bob", " "));
        Expense e = new Expense("2025-10-22", "Alice", new BigDecimal("100.00"), "USD", participants, "Food", "Lunch");
        Exception ex = assertThrows(IllegalArgumentException.class, () -> ExpenseValidator.validate(e));
        assertEquals("Participant name cannot be blank.", ex.getMessage());
    }

    @Test
    void blankCurrencyThrows() {
        ArrayList<String> participants = new ArrayList<>(Arrays.asList("Bob"));
        Expense e = new Expense("2025-10-22", "Alice", new BigDecimal("100.00"), "", participants, "Food", "Lunch");
        Exception ex = assertThrows(IllegalArgumentException.class, () -> ExpenseValidator.validate(e));
        assertEquals("Currency is Empty! Please add currency", ex.getMessage());
    }

    @Test
    void blankDateThrows() {
        ArrayList<String> participants = new ArrayList<>(Arrays.asList("Bob"));
        Expense e = new Expense("", "Alice", new BigDecimal("100.00"), "USD", participants, "Food", "Lunch");
        Exception ex = assertThrows(IllegalArgumentException.class, () -> ExpenseValidator.validate(e));
        assertEquals("Date cannot be blank.", ex.getMessage());
    }
}