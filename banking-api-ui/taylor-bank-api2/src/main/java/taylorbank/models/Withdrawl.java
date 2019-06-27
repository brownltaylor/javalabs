package taylorbank.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Withdrawl {
    @Id
    @GeneratedValue
    private Long id;

    private enum Type{
        P2p, DEPOSIT, WITHDRAWL;
    }
    private enum Medium{
        BALANCE, REWARDS;
    }
    private enum Status{
        PENDING, CANCELLED, COMPLETED;
    }
    private String transaction_date;
    private Long account_id;
    private Double amount;
    private String description;
    private Medium medium;
    private Type type;
    private Status status;

    public Withdrawl(){

    }

    public Withdrawl(Long id, String transaction_date, Long account_id, Double amount, String description, Status status, Type type, Medium medium) {
        this.id = id;
        this.transaction_date = transaction_date;
        this.account_id = account_id;
        this.amount = amount;
        this.description = description;
        this.status = status;
        this.medium = medium;
        this.type = type;
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

    public Long getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Long payee_id) {
        this.account_id = payee_id;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
