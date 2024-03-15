package api.payload;

public class Store
{

    String id;
    String petId;
    String quantity;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = String.valueOf(date);
    }

    String date;

    public String getId() {
        return id;
    }

    public void setId(int id) {
        this.id = String.valueOf(id);
    }

    public String getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = String.valueOf(petId);
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = String.valueOf(quantity);
    }



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComplete() {
        return complete;
    }

    public void setComplete(String complete) {
        this.complete = complete;
    }

    String status;
    String complete;
}
