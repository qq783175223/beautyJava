package com.xzj.sbh;

import com.xzj.sbh.model.Article;
import com.xzj.sbh.service.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootHibernateApplicationTests {

	@Resource
	private ArticleService articleService;

	/**
	 * 测试增删改查
	 */
	@Test
	public void test() {
		Article article = articleService.getArticleById(1);
		assertThat(article.getTitle(), is("Java Concurrency"));

		List<Article> list = articleService.getAllArticles();
		assertThat(list, notNullValue());
		assertThat(list.size(), is(5));

		boolean flag = articleService.addArticle(article);
		assertThat(flag, is(false));

		article.setTitle("Python Concurrency");
		articleService.updateArticle(article);
		Article article1 = articleService.getArticleById(1);
		assertThat(article1.getTitle(), is("Python Concurrency"));


		articleService.deleteArticle(1);
		Article article2 = articleService.getArticleById(1);
		assertThat(article2, nullValue());

	}

	@Test
	public void testAdd(){
		Article article = new Article();
		article.setTitle("Python编程思想");
		article.setCategory("Python");
		articleService.addArticle(article);
	}
}
