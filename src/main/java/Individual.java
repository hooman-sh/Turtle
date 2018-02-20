import java.util.ArrayList;

public class Individual extends User {
    private Individual(){
        super();
    }
    private String phone;
    private Integer balance;
    private String username;
    private String password;

    public String getPhone() {
        return phone;
    }

    public Integer getBalance() {
        return balance;
    }

    public String getUsername() {
        return username;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
