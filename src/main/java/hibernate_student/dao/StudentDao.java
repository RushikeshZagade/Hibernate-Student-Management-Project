package hibernate_student.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hibernate_student.dto.Student;

public class StudentDao {

	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("rushikesh").createEntityManager();
	}

	public void saveStudent(Student student) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
		System.out.println("Saved Successful");

	}

	public void deleteStudent(int id) {
		EntityManager entityManager = getEntityManager();

		Student student = entityManager.find(Student.class, id);
		if (student != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(student);
			entityTransaction.commit();
		} else {
			System.out.println("Student with the given id " + id + " not found");
		}

	}

	public void updateStudent(int id, Student student) {
		EntityManager entityManager = getEntityManager();
		Student dbStudent = entityManager.find(Student.class, id);
		if (dbStudent != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			student.setId(id);
			entityTransaction.begin();
			entityManager.merge(student);
			entityTransaction.commit();
		} else {
			System.out.println("Student with the given id " + id + " not found");
		}
	}

	public void fetchAllStudent() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("SELECT s FROM Student s");
		List<Student> list = query.getResultList();
		System.out.println(list);

	}

	public void findById(int id) {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("SELECT s FROM Student s WHERE s.id=?1");
		query.setParameter(1, id);
		try {
			Student student = (Student) query.getSingleResult();
			System.out.println(student);

		} catch (Exception e) {
			System.out.println("Student with the given phone " + id + " not found");
		}

	}

	public void findByPhone(long phone) {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("SELECT s FROM Student s WHERE s.phone=?1");
		query.setParameter(1, phone);
		try {
			Student student = (Student) query.getSingleResult();
			System.out.println(student);

		} catch (Exception e) {
			System.out.println("Student with the given phone " + phone + " not found");
		}

	}

	public void fetchByEmail(String email) {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("SELECT s FROM Student s WHERE s.email=?1");
		query.setParameter(1, email);
		try {
			Student student = (Student) query.getSingleResult();
			System.out.println(student);
		} catch (Exception e) {
			System.out.println("Student with the given Email " + email + " not found");
		}

	}

	public void fetchByAddress(String address) {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("SELECT s FROM Student s WHERE s.address=?1");
		query.setParameter(1, address);
		try {
			List<Student> list = query.getResultList();
			System.out.println(list);
		} catch (Exception e) {
			System.out.println("Student with the given Address " + address + " not found");
		}
	}
}
