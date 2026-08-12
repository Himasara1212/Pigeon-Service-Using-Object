package entities;

public class ItemDto {

    private String itemCode;
    private SupplierDto supplier;
    private CategoryDto category;
    private String description;
    private double unitPrice;
    private int quantity;

    ItemDto() {}

    public ItemDto(String itemCode,SupplierDto supplier,CategoryDto category,String description,double unitPrice,int quantity) {
        this.itemCode = itemCode;
        this.supplier = supplier;
        this.category = category;
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

    public SupplierDto getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierDto supplier) {
        this.supplier = supplier;
    }

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
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
        return "Item Code   : " + itemCode +"\nSupplier ID : " + supplier +"\nCategory ID : " + category +"\nDescription : " + description +"\nUnit Price  : " + unitPrice +"\nQuantity    : " + quantity;
    }
}
