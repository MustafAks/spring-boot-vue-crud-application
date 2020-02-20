package com.project.x.course.repository;

import com.project.x.course.model.Course;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CourseCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Course> list(Course course) {
        StringBuilder hql = new StringBuilder();
        hql.append(" from Course c where 1=1 ");
        if (course.getUsername() != null) {
            hql.append(" and c.username like :username");
        }
        if (course.getDescription() != null) {
            hql.append(" and c.description like :description");
        }
        Query query = entityManager.createQuery(hql.toString());
        if (course.getUsername() != null) {
            query.setParameter("username", "%" + course.getUsername() + "%");
        }
        if (course.getDescription() != null) {
            query.setParameter("description", "%" + course.getDescription() + "%");
        }
        return query.getResultList();
    }
}
