package inventory.api.dto;

public class Outcome {
    private Status status;

    private String message = "";

    public Outcome() {
    }

    public Outcome(Status status) {
        this.status = status;
    }

    public Outcome(Status status, String message) {
        this.status = status;
        this.message = message;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public enum Status {
        FAIL,
        SUCCESS
    }
}
