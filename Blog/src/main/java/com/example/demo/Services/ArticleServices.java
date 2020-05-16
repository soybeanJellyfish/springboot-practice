package com.example.demo.Services;

import com.example.demo.DAO.Article;
import com.example.demo.DAO.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleServices {
    @Autowired
    private ArticleRepository articleRepository;

    /**
     * get all article
     * @return list of article
     */
    public List<Article> getAllArticles(){
        return articleRepository.findAll();
    }

    /**
     * save article
     * @param article
     * @return boolean
     */
    public boolean saveNewArticle(Article article){
        try {
            articleRepository.save(article);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    /**
     * get Article by Id
     * @param id
     * @return article
     */
    public Article getArticleById(int id ){
         Optional<Article> article = articleRepository.findById(id);
         if(article.isPresent())
             return article.get();
         else
             return null;

    }


}
