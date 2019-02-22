package net.dragons.dto;


public class ResponseLoginDto {
	private String token;
	private int	cusId;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public int getCusId() {
		return cusId;
	}
	public void setCusId(int cusId) {
		this.cusId = cusId;
	}

}
