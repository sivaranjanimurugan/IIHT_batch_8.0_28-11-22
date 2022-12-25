package com.book.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.book.entity.Book;
import com.book.entity.BookSubscriptionDetails;

@Repository
public interface BookSubcribeRepository extends JpaRepository<BookSubscriptionDetails, Long>{
	
	@Query("select t.book from BookSubscriptionDetails t where t.subName = :username and t.isSubscribed = true")
	List<Book> findAllbooksBySubscription(@Param("username") String username);
	
	@Query("select t.book from BookSubscriptionDetails t where t.subName = :username and t.id = :subscribeId and t.isSubscribed = true")
	Book findbookBySubscriptionIdandUsername(@Param("username") String username, @Param("subscribeId") Long subscribeId);
	
	@Query("select t from BookSubscriptionDetails t where t.subName = :username and t.book.id = :bookId and t.isSubscribed = true")
	BookSubscriptionDetails findBookByusernameandbookId(@Param("username") String username, @Param("bookId") Long bookId);
	
	@Query("select t from BookSubscriptionDetails t where t.book.id = :bookId and t.isSubscribed = true")
	List<BookSubscriptionDetails> findAllBookBybookId(@Param("bookId") Long bookId);

}
