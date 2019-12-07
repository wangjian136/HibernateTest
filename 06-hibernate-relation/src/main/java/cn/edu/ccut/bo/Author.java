package cn.edu.ccut.bo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Author {

	private Integer id;
	private String name;
	private Integer age;
	private List<Blog> blogs;
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Author(Integer id, String name, Integer age, List<Blog> blogs) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.blogs = blogs;
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	//@OneToMany(mappedBy = "author")
	@Transient
	public List<Blog> getBlogs() {
		return blogs;
	}
	public void setBlogs(List<Blog> blogs) {
		this.blogs = blogs;
	}
	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", age=" + age  + "]";
	}
	
	
}
