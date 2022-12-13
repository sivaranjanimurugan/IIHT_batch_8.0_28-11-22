package com.book.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.book.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
	
	@Modifying
	@Query("update Book t set t.isActive = :isActive where t.id = :id")
	void updateActiveById(@Param("isActive") Boolean isActive, @Param("id") Long id);
	
	@Query("select t from Book t where "
			+ "(:title = null or t.title like (%:title%)) and "
			+ "(:category = null or t.category like (%:category%)) and "
			+ "(:author = null or t.author like (%:author%)) and "
			+ "(:price = null or t.price =:price) and "
			+ "t.isActive = true"
			)
	List<Book> searchBooks(
			@Param("title") String title,
			@Param("category") String category,
			@Param("author") String author,
			@Param("price") Float price
			);

}
