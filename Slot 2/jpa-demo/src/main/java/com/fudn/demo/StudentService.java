package com.fudn.demo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void createStudent(String name, String email, int age) {
        Student s = new Student(name, email, age);
        em.persist(s);
        System.out.println("Saved with ID = " + s.getId());
    }

    @Transactional(readOnly = true)
    public void printAll() {
        em.createQuery("SELECT s FROM Student s", Student.class)
                .getResultList()
                .forEach(System.out::println);
    }

    @Transactional
    public boolean deleteStudent(Long id) {
        Student s = em.find(Student.class, id);
        if (s == null) {
            System.out.println("Không tìm thấy Student với ID = " + id);
            return false;
        }
        em.remove(s);
        System.out.println("Đã xóa Student: " + s);
        return true;
    }
}