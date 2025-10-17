package itm.oss.splitter;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Expense {
  private String date;
  private String payer;
  private BigDecimal amount;
  private String currency;
  private ArrayList<String> participants;
  private String category;
  private String notes;

  public Expense(String date, String payer, BigDecimal amount, String currency,
                 ArrayList<String> participants, String category, String notes) {
    this.date = date;
    this.payer = payer;
    this.amount = amount;
    this.currency = currency;
    this.participants = participants;
    this.category = category;
    this.notes = notes;
  }

  public String getDate() { return date; }
  public String getPayer() { return payer; }
  public BigDecimal getAmount() { return amount; }
  public String getCurrency() { return currency; }
  public ArrayList<String> getParticipants() { return participants; }
  public String getCategory() { return category; }
  public String getNotes() { return notes; }
}
