package entities;

public class SupplierDto {

    private String supId;
    private String supName;

    SupplierDto() {}

    public SupplierDto(String supId, String supName) {
        this.supId = supId;
        this.supName = supName;
    }

    public String getSupId() {
        return supId;
    }

    public void setSupId(String supId) {
        this.supId = supId;
    }

    public String getSupName() {
        return supName;
    }

    public void setSupName(String supName) {
        this.supName = supName;
    }

    public String toString() {
        return "Supplier ID   : " + supId +
               "\nSupplier Name : " + supName;
    }

}   