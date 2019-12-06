package cn.edu.ccut.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "blog")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Blog {

	private Integer id;
	private String name;
	private String descs;
	public Blog() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Blog(Integer id, String name, String descs) {
		super();
		this.id = id;
		this.name = name;
		this.descs = descs;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "descs")
	public String getDescs() {
		return descs;
	}
	public void setDescs(String descs) {
		this.descs = descs;
	}
	@Override
	public String toString() {
		return "Blog [id=" + id + ", name=" + name + ", descs=" + descs + "]";
	}
}
