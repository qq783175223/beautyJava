package com.xzj.sbh.service;

import com.xzj.sbh.dao.IArticleDAO;
import com.xzj.sbh.model.Article;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Create by xuzhijun.online on 2019/3/24.
 */

@Service
public class ArticleService {

    @Resource
    private IArticleDAO articleDAO;

    public Article getArticleById(int articleId) {
        Article obj = articleDAO.getArticleById(articleId);
        return obj;
    }

    public List<Article> getAllArticles() {
        return articleDAO.getAllArticles();
    }

    public synchronized boolean addArticle(Article article) {
        if (articleDAO.articleExists(article.getTitle(), article.getCategory())) {
            return false;
        } else {
            articleDAO.addArticle(article);
            return true;
        }
    }

    public void updateArticle(Article article) {
        articleDAO.updateArticle(article);
    }

    public void deleteArticle(int articleId) {
        articleDAO.deleteArticle(articleId);
    }
}