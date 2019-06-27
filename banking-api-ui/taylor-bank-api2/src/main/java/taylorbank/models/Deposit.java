package taylorbank.models;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Deposit {

    @Id
    @GeneratedValue
    private Long id;

    private enum Status{
        PENDING, CANCELLED, COMPLETED;
    }
    private enum Type{
        P2p, DEPOSIT, WITHDRAWL;
    }
    private enum Medium{
        BALANCE, REWARDS;
    }

    private String transaction_date;
    private Long account_id;
    private Medium medium;
    private Status status;
    private Type type;
    private Double amount;
    private String description;

    public Deposit(){

    }

    public Deposit(Long id, String transaction_date, Long account_id, Double amount, String description, Medium medium, Type type, Status status) {
        this.id = id;
        this.transaction_date = transaction_date;
        this.account_id = account_id;
        this.medium = medium;
        this.type = type;
        this.status = status;
        this.amount = amount;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(String transaction_date) {
        this.transaction_date = transaction_date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Long account_id) {
        this.account_id = account_id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Medium getMedium() {
        return medium;
    }

    public void setMedium(Medium medium) {
        this.medium = medium;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
