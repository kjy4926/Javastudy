package kr.jy.jyweb.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaTest {
	public static void test() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("web-db");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			TestMember testMember = new TestMember();
			testMember.setName("seq3");
			em.persist(testMember);
			tx.commit();
		}catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			em.close();
		}
		emf.close();
	}
}
