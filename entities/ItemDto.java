package entities;

public class ItemDto {

    private String itemCode;
    private String supplierId;
    private String categoryId;
    private String description;
    private double unitPrice;
    private int quantity;

    ItemDto() {}

    ItemDto(String itemCode,String supplierId,String categoryId,String description,double unitPrice,int quantity) {

        this.itemCode = itemCode;
        this.supplierId = supplierId;
        this.categoryId = categoryId;
        this.description = description;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String toString() {
        return "Item Code   : " + itemCode +
               "\nSupplier ID : " + supplierId +
               "\nCategory ID : " + categoryId +
               "\nDescription : " + description +
               "\nUnit Price  : " + unitPrice +
               "\nQuantity    : " + quantity;
    }
}
