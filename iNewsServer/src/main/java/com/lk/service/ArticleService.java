package com.lk.service;

import com.lk.domain.Article;
import com.lk.domain.PageBean;

public interface ArticleService {
    void add(Article article);

    PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state);

    Article findById(Integer id);

    void deleteById(Integer id);

    void update(Article article);
}
