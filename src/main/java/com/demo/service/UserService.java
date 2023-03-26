package com.demo.service;

import com.demo.pojo.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    /**
     * 新增
     * @param user
     * @return
     */
    public Boolean save(User user);

    /**
     * 更新
     * @param user
     * @return
     */
    public Boolean update(User user);

    /**
     * 删除
     * @param id
     * @return
     */
    public Boolean delete(Integer id);

    /**
     * 根据 id 查询
     * @param id
     * @return
     */
    public User getById(Integer id);

    /**
     * 查询所有的 user
     * @return
     */
    public List<User> getAll();

    /**
     * 转账（采用事务）
     * @param out
     * @param in
     * @param money
     */
    @Transactional
    public void transferMoney(String out, String in, Double money);
}
