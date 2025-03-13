package com.esgitech.randd.repository;

import com.esgitech.randd.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByMotsClesContaining(String motCle);
}
