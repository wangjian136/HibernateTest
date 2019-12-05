package cn.edu.ccut.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.Before;
import org.junit.Test;

import cn.edu.ccut.bo.Blog;

public class HibernateTest {
	
	private SessionFactory factory;
	
	@Before
	public void init() throws Exception {
		Configuration configiguration = new Configuration().configure();
        factory = configiguration.buildSessionFactory();
	}

	@Test
	public void testHibernateAdd() {
		try (Session session = factory.openSession();) {
			session.beginTransaction();
			Blog blog = new Blog(null, "C++", "C++开发");
			session.save(blog);
			session.getTransaction().commit();
		}
	}
	
	@Test
	public void testHibernateUpdate() {
		try (Session session = factory.openSession();) {
			session.beginTransaction();
			/*Blog blog = new Blog(108, "C++", "test,C++开发");
			session.saveOrUpdate(blog);*/
			Blog blog = session.get(Blog.class, 108);
			blog.setDescs("sss");
			session.update(blog);
			session.getTransaction().commit();
		}
	}
	
	
	@Test
	public void testHibernateDelete() {
		try (Session session = factory.openSession();) {
			session.beginTransaction();
			Blog blog = session.get(Blog.class, 108);
			session.delete(blog);
			session.getTransaction().commit();
		}
	}
	
	@Test
	public void testHibernateSelect() {
		try (Session session = factory.openSession();) {
			Query<Blog> query = session.createQuery("from Blog");
			List<Blog> blogs = query.list();
			System.out.println(blogs);
		}
	}
}
