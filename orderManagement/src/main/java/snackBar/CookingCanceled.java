
package snackBar;

public class CookingCanceled extends AbstractEvent {

    private Long id;
    private Long clientId;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }
    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
}
