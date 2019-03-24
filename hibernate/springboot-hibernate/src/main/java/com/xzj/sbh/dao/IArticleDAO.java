package com.xzj.sbh.dao;

import com.xzj.sbh.model.Article;

import java.util.List;

/**
 * Create by xuzhijun.online on 2019/3/24.
 */
public interface IArticleDAO {
    List<Article> getAllArticles();

    Article getArticleById(int articleId);

    void addArticle(Article article);

    void updateArticle(Article article);

    void deleteArticle(int articleId);

    boolean articleExists(String title, String category);
}