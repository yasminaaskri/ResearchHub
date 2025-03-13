package com.esgitech.randd.services;

import com.esgitech.randd.entities.Article;
import com.esgitech.randd.entities.Domaine;
import com.esgitech.randd.entities.User;
import com.esgitech.randd.repository.ArticleRepository;
import com.esgitech.randd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Article saveArticle(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public List<Article> findByMotCle(String motCle) {
        return articleRepository.findByMotsClesContaining(motCle);
    }

    @Override
    public Article assignArticleToUser(Long articleId, Long userId) {
        Optional<Article> optionalArticle = articleRepository.findById(articleId);
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalArticle.isPresent() && optionalUser.isPresent()) {
            Article article = optionalArticle.get();
            article.setUser(optionalUser.get());
            return articleRepository.save(article);
        }

        return null;
    }

    @Override
    public Article assignArticleToDomaine(Long articleId, Domaine domaine) {
        Optional<Article> optionalArticle = articleRepository.findById(articleId);

        if (optionalArticle.isPresent()) {
            Article article = optionalArticle.get();
            article.setDomaine(domaine);
            return articleRepository.save(article);
        }

        return null;
    }
    @Override
    public List<Article> findAllArticles() {
        return articleRepository.findAll();
    }

}
