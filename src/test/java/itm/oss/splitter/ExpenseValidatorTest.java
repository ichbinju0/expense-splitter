package itm.oss.splitter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class ExpenseValidatorTest {

    @Test
    @DisplayName("Valid expense should be valid")
    void validExpense() {
        Expense e = new Expense("2025-10-23", "Alice", new BigDecimal("100.00"),
                "USD", new ArrayList<>(Arrays.asList("Bob", "Charlie")), "Food", "Lunch");
        boolean result = isValid(e);
        assertTrue(result, "Valid expense should pass validation");
    }

    @Test
    @DisplayName("Blank payer should fail")
    void testBlankPayer() {
        Expense e = new Expense("2025-10-23", "", new BigDecimal("100.00"),
                "USD", new ArrayList<>(Arrays.asList("Bob")), "Food", "Lunch");
        boolean result = isValid(e);
        assertFalse(result, "Payer is Empty! Please add payer");
    }

    @Test
    @DisplayName("Zero or negative amount should fail")
    void testZeroOrNegativeAmount() {
        Expense e1 = new Expense("2025-10-23", "Alice", BigDecimal.ZERO,
                "USD", new ArrayList<>(Arrays.asList("Bob")), "Food", "Lunch");
        Expense e2 = new Expense("2025-10-23", "Alice", new BigDecimal("-10.00"),
                "USD", new ArrayList<>(Arrays.asList("Bob")), "Food", "Lunch");

        assertFalse(isValid(e1), "Amount should be larger than 0");
        assertFalse(isValid(e2), "Amount should be larger than 0");
    }

    @Test
    @DisplayName("Blank currency should fail")
    void testBlankCurrency() {
        Expense e = new Expense("2025-10-23", "Alice", new BigDecimal("100.00"),
                "", new ArrayList<>(Arrays.asList("Bob")), "Food", "Lunch");
        boolean result = isValid(e);
        assertFalse(result, "Currency is Empty! Please add currency");
    }

    @Test
    @DisplayName("Empty participants list should fail")
    void testEmptyParticipants() {
        Expense e = new Expense("2025-10-23", "Alice", new BigDecimal("100.00"),
                "USD", new ArrayList<>(), "Food", "Lunch");
        boolean result = isValid(e);
        assertFalse(result, "Participants list cannot be empty.");
    }

    @Test
    @DisplayName("Blank participant name should fail")
    void testBlankParticipant() {
        Expense e = new Expense("2025-10-23", "Alice", new BigDecimal("100.00"),
                "USD", new ArrayList<>(Arrays.asList("Bob", "")), "Food", "Lunch");
        boolean result = isValid(e);
        assertFalse(result, "Participant name cannot be blank.");
    }

    @Test
    @DisplayName("Blank date should fail")
    void testBlankDate() {
        Expense e = new Expense("", "Alice", new BigDecimal("100.00"),
                "USD", new ArrayList<>(Arrays.asList("Bob")), "Food", "Lunch");
        boolean result = isValid(e);
        assertFalse(result, "Date cannot be blank.");
    }

    
    private boolean isValid(Expense e) {
        try {
            ExpenseValidator.validate(e);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}