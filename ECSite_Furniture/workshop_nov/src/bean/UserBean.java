package bean;

public class UserBean {
	private String id;
    private String name;
    private String password;

    public UserBean(String id, String name) {
    	this.id = id;
    	this.name = name;
    }

    public UserBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public void setId(String id) {
    	this.id = id;
    }

    public String getId() {
    	return this.id;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String gePassword() {
        return this.password;
    }
}
