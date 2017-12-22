package io.pivotal.workshop.model;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "shops")
public class Shop {

	public Shop() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue
	private Integer id;

	private String name;

	@Column(name = "employees_number")
	private Integer emplNumber;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getEmplNumber() {
		return emplNumber;
	}

	public void setEmplNumber(Integer emplNumber) {
		this.emplNumber = emplNumber;
	}
}
