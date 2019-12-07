package cn.edu.ccut.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Blog {

	private Integer id;
	private String name;
	private String descs;
	private Author author;
	public Blog() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Blog(Integer id, String name, String descs, Author author) {
		super();
		this.id = id;
		this.name = name;
		this.descs = descs;
		this.author = author;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	public String getDescs() {
		return descs;
	}
	public void setDescs(String descs) {
		this.descs = descs;
	}
	@ManyToOne
	@JoinColumn(name = "author_id",referencedColumnName = "id")
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "Blog [id=" + id + ", name=" + name + ", descs=" + descs + "]";
	}
	
	
}
