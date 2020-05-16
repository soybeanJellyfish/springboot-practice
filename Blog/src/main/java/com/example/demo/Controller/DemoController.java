package com.example.demo.Controller;

import com.example.demo.DAO.Article;
import com.example.demo.DAO.ArticleRepository;
import com.example.demo.Services.ArticleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DemoController {

    @Autowired
    private ArticleServices articleServices;

    @GetMapping("/articles")
    public List<Article> getAllArticle(){
        return articleServices.getAllArticles();
    }

    @PostMapping("/newArticle")
    public String createNewArticle(@RequestBody  Article article){
        System.out.println(article.toString());
        articleServices.saveNewArticle(article);
        return "new article has been created";
    }

    @GetMapping("/article")
    public Article getArticleById(@RequestParam(value = "id",required = true) int id){
        Article article = articleServices.getArticleById(id);
        return article;
    }
}
