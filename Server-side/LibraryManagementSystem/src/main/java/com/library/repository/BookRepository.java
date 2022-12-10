package com.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.library.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
	
	@Modifying
	@Query("update Book t set t.borrowed = :borrowed where t.id = :id")
	void updateBorrowedById(@Param("borrowed") Boolean borrowed, @Param("id") Long id);
}
