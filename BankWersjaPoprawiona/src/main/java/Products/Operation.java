package Products;

import java.time.LocalDate;
import java.util.Random;

public class Operation {
    private int OwnerID;
    private Operation_Types Type;
    private LocalDate OperationDate;
    private String Description;
    private int OperatorID;
    private double amount;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


    public Operation(int OwnerID, Operation_Types type, LocalDate operationDate, String description,  double amount) {
        this.OwnerID = OwnerID;
        this.Type = type;
        this.OperationDate = operationDate;
        this.Description = description;
        Random generator = new Random();
        this.OperatorID = generator.nextInt(10);
        this.amount = amount;

    }

    public Operation_Types getType() {
        return Type;
    }

    public void setType(Operation_Types type) {
        Type = type;
    }

    public LocalDate getOperationDate() {
        return OperationDate;
    }

    public void setOperationDate(LocalDate operationDate) {
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
