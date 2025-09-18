package com.app.todoapp.repository;
// it will do the job of interfacing to the database
import com.app.todoapp.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for Task entity.
 *
 * Extends JpaRepository to provide built-in CRUD operations (save, findAll, findById, delete, etc.)
 * without writing any implementation code.
 *
 * Spring Data JPA automatically generates the implementation at runtime.
 */
public interface TaskRepository extends JpaRepository<Task, Long> {
}
