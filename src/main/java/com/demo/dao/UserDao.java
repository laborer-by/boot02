package com.demo.dao;

import com.demo.pojo.User;
import org.apache.ibatis.annotations.*;
import java.util.List;

// TODO 这个 Mapper 注解必须加上
@Mapper
public interface UserDao {
    @Insert("insert user(id, name, money) values(null, #{name}, #{money})")
    int insert(User user);

    @Update("update user set name = #{name}, money = #{money} where id = #{id}")
    public int update(User user);

    @Delete("delete from user where id = #{id}")
    public int delete(Integer id);

    @Select("select * from user where id = #{id}")
    User getById(Integer id);

    @Select("select id, name, money from user")
    public List<User> getAll();

    @Update("update user set money= money - #{money} where name = #{name}")
    void outMoney(@Param("name") String name, @Param("money") Double money);

    @Update("update user set money= money + #{money} where name = #{name}")
    void inMoney(@Param("name") String name, @Param("money") Double money);
}
