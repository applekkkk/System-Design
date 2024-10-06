package com.lk.service.impl;

import com.github.pagehelper.PageHelper;
import com.lk.dao.ArticleDao;
import com.lk.domain.Article;
import com.lk.domain.PageBean;
import com.lk.service.ArticleService;
import com.lk.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleDao articleDao;
    @Override
    public void add(Article article) {
        Integer id= ThreadLocalUtil.getId();
        article.setCreateUser(id);
        articleDao.add(article);
    }

    @Override
    public PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state) {
        PageBean<Article> page=new PageBean<>();
        PageHelper.startPage(pageNum,pageSize);//开启分页查询
        Integer userId=ThreadLocalUtil.getId();
        List<Article> pageItems = articleDao.list(categoryId,state,userId).getResult();
        page.setTotal(pageItems.size());
        page.setItems(pageItems);
        return page;
    }

    @Override
    public Article findById(Integer id) {
        Article article = articleDao.findArticleById(id);
        return article;

    }

    @Override
    public void deleteById(Integer id) {
        articleDao.deleteById(id);
    }

    @Override
    public void update(Article article) {
        articleDao.update(article);
    }
}
