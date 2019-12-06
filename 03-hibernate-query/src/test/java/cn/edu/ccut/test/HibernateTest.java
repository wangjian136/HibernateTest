package cn.edu.ccut.test;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
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
	public void testHibernateOIDQuery() {
		try (Session session = factory.openSession();) {
			//Blog blog1 = session.load(Blog.class, 101);
			//System.out.println(blog1.getDescs());
			Blog blog2 = session.get(Blog.class, 101);
			System.out.println(blog2.getDescs());
		}
	}
	
	@Test
	public void testHibernateHQLQuery() {
		try (Session session = factory.openSession();) {
			Query<Blog> query = session.createQuery(" from Blog where id = 101 ");
			List<Blog> result = query.list();
			System.out.println(result);
		}
	}
	
	
	@Test
	public void testHibernateQBCQuery() {
		try (Session session = factory.openSession();) {
			/*Criteria criteria = session.createCriteria(Blog.class);
			criteria.add(Restrictions.eq("id", 101));
			List<Blog> result = criteria.list();
			System.out.println(result);*/
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Blog> criteriaQuery = builder.createQuery(Blog.class);
			Root<Blog> root = criteriaQuery.from(Blog.class);
			Predicate predicate = builder.equal(root.get("id"), 101);
			criteriaQuery.where(predicate);
			Query<Blog> query = session.createQuery(criteriaQuery);
			Blog result = query.getSingleResult();
			System.out.println(result);
		}
	}
	
	
	@Test
	public void testHibernateSQLQuery() {
		try (Session session = factory.openSession();) {
			NativeQuery<Blog> sql=session.createSQLQuery(" select * from blog where id=101 ");
			sql.addEntity(Blog.class);
			Blog blog = sql.getSingleResult();
			System.out.println(blog);
		}
	}
	
}
