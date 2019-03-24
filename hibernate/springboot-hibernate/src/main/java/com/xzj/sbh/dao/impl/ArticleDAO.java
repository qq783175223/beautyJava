package com.xzj.sbh.dao.impl;

import com.xzj.sbh.dao.IArticleDAO;
import com.xzj.sbh.model.Article;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Create by xuzhijun.online on 2019/3/24.
 */
@Transactional
@Repository
public class ArticleDAO implements IArticleDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Article getArticleById(int articleId) {
        return entityManager.find(Article.class, articleId);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Article> getAllArticles() {
        String hql = "FROM Article as atcl ORDER BY atcl.articleId";
        return (List<Article>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void addArticle(Article article) {
        entityManager.persist(article);
    }

    @Override
    public void updateArticle(Article article) {
        Article artcl = getArticleById(article.getArticleId());
        artcl.setTitle(article.getTitle());
        artcl.setCategory(article.getCategory());
        entityManager.flush();
    }

    @Override
    public void deleteArticle(int articleId) {
        entityManager.remove(getArticleById(articleId));
    }

    @Override
    public boolean articleExists(String title, String category) {
        String hql = "FROM Article as atcl WHERE atcl.title = ?0 and atcl.category = ?1";
        int count = entityManager.createQuery(hql).setParameter(0, title)
                .setParameter(1, category).getResultList().size();
        return count > 0;
    }
}