package cn.edu.ccut.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
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
	public void testHibernateTransient() {
		try (Session session = factory.openSession();) {
			session.beginTransaction();
			Blog blog = new Blog();
			blog.setName("test");
			blog.setDescs("test");
			session.save(blog);
			session.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testHibernateCache() {
		try (
				Session session1 = factory.openSession();
			) {
			session1.get(Blog.class, 101);
			session1.get(Blog.class, 101);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testHibernateSecondCache() {
		try (
				Session session1 = factory.openSession();
				Session session2 = factory.openSession();
			) {
			session1.get(Blog.class, 101);
			session2.get(Blog.class, 101);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testHibernateSelectCache() {
		try (
				Session session1 = factory.openSession();
				Session session2 = factory.openSession();
			) {
			NativeQuery<Blog> sql1=session1.createSQLQuery(" select * from blog where id=101 ");
			sql1.setCacheable(true);
			sql1.addEntity(Blog.class);
			Blog blog1 = sql1.getSingleResult();
			System.out.println(blog1);
			
			NativeQuery<Blog> sql2=session2.createSQLQuery(" select * from blog where id=101 ");
			sql2.setCacheable(true);
			sql2.addEntity(Blog.class);
			Blog blog2 = sql2.getSingleResult();
			System.out.println(blog2);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
