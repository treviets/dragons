/**
 * 
 */
package net.dragons.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author NhanNguyen
 *
 */
@Entity
@Table(name="currency")
@NamedQuery(name="Currency.findAll", query="SELECT b FROM Currency b")
public class Currency {
	@Id
	@Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="code")
	private String code;
	
	@Column(name="name")
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
