/**
 * 
 */
package net.dragons.jpa.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author NhanNguyen
 *
 */
@Entity
@Table(name = "customer")
@NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")
public class Customer {
	
	@JsonProperty("Id")
	@Id
	@Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@JsonProperty("FirstName")
	@Column(name = "first_name")
	private String firstName;
	
	@JsonProperty("LastName")
	@Column(name = "last_name")
	private String lastName;
	
	@JsonProperty("Email")
	@Column(name = "email")
	private String email;
	
	@JsonProperty("Password")
	@Column(name = "password")
	private String password;
	
	@JsonProperty("Phone")
	@Column(name = "phone")
	private String phone;

	@JsonProperty("Status")
	@Column(name = "status")
	private Integer status;
	
	@JsonProperty("RoleId")
	@Column(name = "role_id")
	private int roleId;
	
	@JsonProperty("Avatar")
	@Column(name = "avatar")
	private String avatar;
	
	@JsonProperty("DateOfBirth")
	@Column(name = "date_of_birth")
	private Date dateOfBirth;
	
	@JsonProperty("PreferLanguage")
	@Column(name = "prefer_Language")
	private String preferLanguage;
	
	@JsonProperty("PreferCurrency")
	@Column(name = "prefer_currency")
	private String preferCurrency;
	
	@JsonProperty("Hometown")
	@Column(name = "hometown")
	private String hometown;
	
	@JsonProperty("Introduction")
	@Column(name = "introduction")
	private String introduction;
	
	@JsonProperty("School")
	@Column(name = "school")
	private String school;
	
	@JsonProperty("Work")
	@Column(name = "work")
	private String work;
	
	@JsonProperty("WorkEmail")
	@Column(name = "work_email")
	private String workEmail;
	
	@JsonIgnore
	@OneToMany(mappedBy="customer")
	private List<Review> reviews;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public String getPreferLanguage() {
		return preferLanguage;
	}

	public void setPreferLanguage(String preferLanguage) {
		this.preferLanguage = preferLanguage;
	}

	public String getPreferCurrency() {
		return preferCurrency;
	}

	public void setPreferCurrency(String preferCurrency) {
		this.preferCurrency = preferCurrency;
	}

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public String getWorkEmail() {
		return workEmail;
	}

	public void setWorkEmail(String workEmail) {
		this.workEmail = workEmail;
	}
	
	
	
}
