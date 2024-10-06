package com.lk.controller;

import com.lk.domain.Article;
import com.lk.domain.PageBean;
import com.lk.domain.Result;
import com.lk.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @PostMapping
    public Result add(@RequestBody @Validated Article article){
        articleService.add(article);
        return Result.success();
    }

    @GetMapping
    public Result<PageBean<Article>> list(
            Integer pageNum,
            Integer pageSize,
            @RequestParam(required = false) Integer categoryId,
            @RequestParam(required = false) String state
    ){
        PageBean<Article>page=articleService.list(pageNum,pageSize,categoryId,state);
        return Result.success(page);
    }

    @GetMapping("/detail")
    public Result<Article> detail(Integer id){
        Article article=articleService.findById(id);
        return Result.success(article);
    }

    @DeleteMapping
    public Result delete(Integer id){
        articleService.deleteById(id);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody @Validated Article article){
        articleService.update(article);
        return Result.success();
    }
}
