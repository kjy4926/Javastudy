package kr.jy.jyweb.repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import kr.jy.jyweb.entity.Member;

@Repository
public class MemberDao {
	public boolean insert(String id, String pwd, String email) {
		boolean result = false;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("web-db");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			Member mem = new Member();
			mem.setId(id);
			mem.setPwd(pwd);
			mem.setEmail(email);
			mem.setSignupDate(Timestamp.valueOf(LocalDateTime.now()));
			em.persist(mem);
			tx.commit();
			result = true;
		}catch(Exception e) {
			tx.rollback();
		}finally {em.close();}	
		emf.close();
		return result;
	}
	public int update() {
		int result = 0;
		
		return result;
	}
	public int delete() {
		int result = 0;
		
		return result;
	}
	// id = pk 이므로 
	public Member selectById(String id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("web-db");
		EntityManager em = emf.createEntityManager();
		Member findMember = em.find(Member.class, id);
		emf.close();
		return findMember;
	}
}
