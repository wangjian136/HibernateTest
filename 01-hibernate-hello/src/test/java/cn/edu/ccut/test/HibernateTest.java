package cn.edu.ccut.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.edu.ccut.bo.Blog;

public class HibernateTest {

	@Test
	public void testHibernateInit() {
        Configuration configiguration = new Configuration().configure();
        SessionFactory factory = configiguration.buildSessionFactory();
        Session session = factory.openSession();
        Blog blog = session.get(Blog.class, 101);
        System.out.println(blog);
        //πÿ±’¡¨Ω”
        session.close();
        factory.close();
	}
}
