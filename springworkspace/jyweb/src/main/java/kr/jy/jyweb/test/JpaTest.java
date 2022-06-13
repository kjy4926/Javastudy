package kr.jy.jyweb.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaTest {
	static private EntityManagerFactory emf = Persistence.createEntityManagerFactory("simple-jpa-application");
	static private EntityManager em = emf.createEntityManager();
	static private EntityTransaction tx = em.getTransaction();
	public static void test() {
		tx.begin();
		try {
			TestMember testMember = new TestMember();
			testMember.setId(1L);
			testMember.setName("testmem1");
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
