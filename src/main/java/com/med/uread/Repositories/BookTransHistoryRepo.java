package com.med.uread.Repositories;

import com.med.uread.History.BookTransactionHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookTransHistoryRepo extends JpaRepository<BookTransactionHistory, Integer> {

    @Query("""
    SELECT h
    FROM BookTransactionHistory h
    WHERE h.user.id = :userId
    """)
    Page<BookTransactionHistory> findAllBorrowedBooks(Pageable pageable, Integer userId);

    @Query("""
    SELECT h
    FROM BookTransactionHistory h
    WHERE h.book.owner.id = :userId
    """)
    Page<BookTransactionHistory> findAllReturnedBooks(Pageable pageable, Integer userId);
}
