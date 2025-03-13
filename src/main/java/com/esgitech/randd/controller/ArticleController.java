package com.esgitech.randd.controller;

import com.esgitech.randd.entities.Article;
import com.esgitech.randd.entities.Domaine;
import com.esgitech.randd.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping
    public Article createArticle(@RequestBody Article article) {
        return articleService.saveArticle(article);
    }
    @GetMapping("/allArticles")
    public ResponseEntity<List<Article>> getAllArticles() {
        return ResponseEntity.ok(articleService.findAllArticles());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Article>> searchByMotCle(@RequestParam String motCle) {
        return ResponseEntity.ok(articleService.findByMotCle(motCle));
    }

    @PutMapping("/{articleId}/assign-user/{userId}")
    public ResponseEntity<Article> assignArticleToUser(@PathVariable Long articleId, @PathVariable Long userId) {
        Article article = articleService.assignArticleToUser(articleId, userId);
        return article != null ? ResponseEntity.ok(article) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{articleId}/assign-domaine")
    public ResponseEntity<Article> assignArticleToDomaine(@PathVariable Long articleId, @RequestParam Domaine domaine) {
        Article article = articleService.assignArticleToDomaine(articleId, domaine);
        return article != null ? ResponseEntity.ok(article) : ResponseEntity.notFound().build();
    }
}
