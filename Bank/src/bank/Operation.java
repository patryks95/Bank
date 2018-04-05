package bank;

import java.time.LocalDateTime;
import java.util.Date;

public class Operation {
    private Operation_Types Type;
    private LocalDateTime OperationDate;
    private String Description;
    private int OperatorID;
    private double amount;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


    public Operation(Operation_Types type, LocalDateTime operationDate, String description, int operatorID, double amount) {
        this.Type = type;
        this.OperationDate = operationDate;
        this.Description = description;
        this.OperatorID = operatorID;
        this.amount = amount;

    }

    public Operation_Types getType() {
        return Type;
    }

    public void setType(Operation_Types type) {
        Type = type;
    }

    public LocalDateTime getOperationDate() {
        return OperationDate;
    }

    public void setOperationDate(LocalDateTime operationDate) {
        OperationDate = operationDate;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getOperatorID() {
        return OperatorID;
    }

    public void setOperatorID(int operatorID) {
        OperatorID = operatorID;
    }
}
