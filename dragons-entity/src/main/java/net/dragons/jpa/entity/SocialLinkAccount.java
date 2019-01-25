package net.dragons.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "social_link_account")
public class SocialLinkAccount {
	
	@Id
	@Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="gg_id")
	private String ggId;
	
	@Column(name="fb_id")
	private String fbId;
	
	@Column(name="full_name")
	private String fullName;
	
	@Column(name="given_name")
	private String givenName;
	
	@Column(name="family_name")
	private String familyName;
	
	@Column(name="img")
	private String img;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getGgId() {
		return ggId;
	}

	public void setGgId(String ggId) {
		this.ggId = ggId;
	}

	public String getFbId() {
		return fbId;
	}

	public void setFbId(String fbId) {
		this.fbId = fbId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

}
