package com.fudn.demo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class StudentTest {

    @Autowired
    private StudentService studentService;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void testCreateStudent() {
        System.out.println("\n=== Bắt đầu testCreateStudent ===");
        String testEmail = "test@fpt.edu.vn";
        studentService.createStudent("Nguyễn Anh Tấn", testEmail, 21);

        Student student = entityManager.createQuery(
                        "SELECT s FROM Student s WHERE s.email = :email", Student.class)
                .setParameter("email", testEmail)
                .getSingleResult();

        assertNotNull(student);
        assertEquals("Nguyễn Anh Tấn", student.getFullName());
        assertEquals(21, student.getAge());
        System.out.println("Kết quả testCreateStudent: PASSED - Đã tạo Student: " + student.getFullName() + ", Tuổi: " + student.getAge());
    }

    @Test
    public void testDeleteStudent() {
        System.out.println("\n=== Bắt đầu testDeleteStudent ===");
        studentService.createStudent("Lê Văn C", "c@fpt.edu.vn", 22);
        entityManager.flush();

        Student saved = entityManager.createQuery(
                        "SELECT s FROM Student s WHERE s.email = :email", Student.class)
                .setParameter("email", "c@fpt.edu.vn")
                .getSingleResult();
        Long id = saved.getId();
        assertNotNull(id, "ID sau khi tạo phải khác null");
        System.out.println("Đã tạo Student tạm thời với ID: " + id);

        boolean result = studentService.deleteStudent(id);

        assertTrue(result, "deleteStudent phải trả về true khi tìm thấy ID");

        entityManager.flush();
        entityManager.clear();

        Student deleted = entityManager.find(Student.class, id);
        assertNull(deleted, "Student phải bị xóa khỏi database");
        System.out.println("Kết quả testDeleteStudent: PASSED - Đã xóa thành công Student có ID: " + id);
    }

    @Test
    public void testDeleteNonExistentStudent() {
        System.out.println("\n=== Bắt đầu testDeleteNonExistentStudent ===");
        boolean result = studentService.deleteStudent(9999L);

        assertFalse(result, "deleteStudent phải trả về false khi ID không tồn tại");
        System.out.println("Kết quả testDeleteNonExistentStudent: PASSED - Trả về false đúng như mong đợi khi xóa ID không tồn tại.");
    }
}