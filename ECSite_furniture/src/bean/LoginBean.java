package bean;

public class LoginBean {
    private String username;
    private String password;

    public void setuserName(String username){
        this.username=username;
    }
    public String getuserName() {
        return username;
    }
    public void setpassWord(String password) {
        this.password = password;
    }
    public String getpassWord() {
        return password;
    }
}
