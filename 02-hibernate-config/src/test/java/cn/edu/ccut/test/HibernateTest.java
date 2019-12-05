package cn.edu.ccut.test;

import java.io.InputStream;
import java.util.List;

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
	public void testHibernateInit() {
		try (Session session = factory.openSession();) {
			Blog blog = session.get(Blog.class, 101);
	        System.out.println(blog);
		}
	}
}
