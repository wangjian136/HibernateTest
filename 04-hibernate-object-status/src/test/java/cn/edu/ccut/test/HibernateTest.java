package cn.edu.ccut.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
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
			//直接瞬时态
			Blog blog = new Blog(111, "张三", "哈哈哈");
			//持久态 -> 瞬时态
			//Blog blog = session.get(Blog.class,101);
			//session.delete(blog);
			//session.getTransaction().commit();
		}
	}
	
	@Test
	public void testHibernatePersistent() {
		try (Session session = factory.openSession();) {
			session.beginTransaction();
			//直接持久态
			//Blog blog = session.get(Blog.class,101);
			//Blog blog = session.load(Blog.class,101);
			//瞬时态 -> 持久态
			//Blog blog = new Blog(111, "张三", "哈哈哈");
			//session.save(blog);
			//session.saveOrUpdate(blog);
			//游离态 -> 持久态
			//Blog blog = session.get(Blog.class,101);
			//session.evict(blog);
			//blog.setName("sss");
			//session.update(blog);
			//session.saveOrUpdate(blog);
			//session.lock(blog, LockMode.READ);
			//session.getTransaction().commit();
		}
	}
	
	@Test
	public void testHibernateDetached() {
		Session session = factory.openSession();
		session.beginTransaction();

		//持久态 -> 游离态
		Blog blog = session.get(Blog.class,101);
		//session.evict(blog);
		//session.clear();
		session.close();
		//session.getTransaction().commit();
	}
	
	
}
