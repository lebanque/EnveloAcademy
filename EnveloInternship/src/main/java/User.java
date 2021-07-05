public class User {

    public String pin;
    public String name;
    public Integer id;

    public User(String pin, String name, Integer id) {
        this.pin = pin;
        this.name = name;
        this.id = id;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getPin() {
        return pin;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
