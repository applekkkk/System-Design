package com.lk.dao;

import com.github.pagehelper.Page;
import com.lk.domain.Article;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ArticleDao {
    @Insert("insert into article(title,content,cover_img,state,category_id,create_user,create_time,update_time) " +
            "values (#{title},#{content},#{coverImg},#{state},#{categoryId},#{createUser},now(),now())")
    void add(Article article);


    Page<Article> list(Integer categoryId, String state, Integer userId);

    @Select("select * from article where id=#{id}")
    Article findArticleById(Integer id);

    @Delete("delete from article where id=#{id}")
    void deleteById(Integer id);

    @Update("update article set " +
            "title=#{title}," +
            "content=#{content}," +
            "cover_img=#{coverImg}," +
            "state=#{state}," +
            "category_id=#{categoryId}," +
            "update_time=now()" +
            "where id=#{id}")
    void update(Article article);
}
