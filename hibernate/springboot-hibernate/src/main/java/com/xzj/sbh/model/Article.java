package com.xzj.sbh.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Create by xuzhijun.online on 2019/3/24.
 */
@Getter
@Setter
@Entity
@Table(name = "articles")
public class Article{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    private int articleId;
    @Column(name = "title")
    private String title;
    @Column(name = "category")
    private String category;
}