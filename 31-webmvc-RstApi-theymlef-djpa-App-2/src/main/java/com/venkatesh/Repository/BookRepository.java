package com.venkatesh.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.venkatesh.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
