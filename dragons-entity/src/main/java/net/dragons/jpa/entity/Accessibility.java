/**
 * 
 */
package net.dragons.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author NhanNguyen
 *
 */
@Entity
@Table(name="accessibility")
@NamedQuery(name="Accessibility.findAll", query="SELECT a FROM Accessibility a")
public class Accessibility {
	
	@JsonProperty("Id")
	@Id
	@Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@JsonProperty("CategoryId")
	@Column(name="category_id")
	private Long categoryId;
	
	@JsonProperty("Name")
	@Column(name="name") 
	private String name;

	@JsonProperty("Description")
	@Column(name="description") 
	private String description;
	
	@ManyToOne
	@JoinColumn(name="category_id", insertable = false, updatable = false)
	private AccessibilityCategory accessibilityCategory;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public AccessibilityCategory getAccessibilityCategory() {
		return accessibilityCategory;
	}

	public void setAccessibilityCategory(AccessibilityCategory accessibilityCategory) {
		this.accessibilityCategory = accessibilityCategory;
	}
	

	
	
}
