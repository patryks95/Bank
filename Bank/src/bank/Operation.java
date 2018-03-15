package bank;

import java.util.Date;

public class Operation {
    private String Type;
    private Date OperationDate;
    private String Description;
    private int OperatorID;

    public Operation(String type, Date operationDate, String description, int operatorID) {
        this.Type = type;
        this.OperationDate = operationDate;
        this.Description = description;
        this.OperatorID = operatorID;

    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public Date getOperationDate() {
        return OperationDate;
    }

    public void setOperationDate(Date operationDate) {
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
