package com.cs.ement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cs.ement.domain.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
	
	public Optional<Subject> findBySubjectCode(String subjectCode);
	public List<Subject> findByStatus(int status);
}
