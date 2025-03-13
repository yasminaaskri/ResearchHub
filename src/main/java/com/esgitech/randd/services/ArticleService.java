package com.esgitech.randd.services;

import com.esgitech.randd.entities.Article;
import com.esgitech.randd.entities.Domaine;

import java.util.List;

public interface ArticleService {
    Article saveArticle(Article article);
    List<Article> findByMotCle(String motCle);
    Article assignArticleToUser(Long articleId, Long userId);
    Article assignArticleToDomaine(Long articleId, Domaine domaine);
}
