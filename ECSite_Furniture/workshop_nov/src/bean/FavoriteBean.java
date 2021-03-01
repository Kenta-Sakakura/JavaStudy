package bean;

public class FavoriteBean {
	private int userId = 0;
	private int proId = 0;
	private String flag = null;

	public FavoriteBean() {

	}

	public void setuserId(int userId) {
		this.userId = userId;
	}
	public int getuserId() {
		return userId;
	}
	public void setproId(int proId) {
		this.proId = proId;
	}
	public int getproId() {
		return proId;
	}
	public void setflag(String flag) {
		this.flag = flag;
	}
	public String getflag() {
		return flag;
	}
}
