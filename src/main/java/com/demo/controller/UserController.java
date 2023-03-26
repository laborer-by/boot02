package com.demo.controller;

import com.demo.pojo.User;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Rest 风格的路由（1 个请求参数就放在路径参数中，多个请求参数就放在 json 数据中）
// 使用请求类型 get,post,put,delete 来区分操作类型
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public Result save(@RequestBody User user) {
        Boolean flag = userService.save(user);
        Integer code = flag ? Code.SAVE_OK : Code.SAVE_ERROR;
        return new Result(code, flag);
    }

    @PutMapping
    public Result update(@RequestBody User user) {
        Boolean flag = userService.update(user);
        Integer code = flag ? Code.UPDATE_OK : Code.UPDATE_ERROR;
        return new Result(code, flag);
    }

    // 另一种写法
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable Integer id) {
        Boolean flag = userService.delete(id);
        Integer code = flag ? Code.DELETE_OK : Code.DELETE_ERROR;
        return new Result(code, flag);
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        User obj = userService.getById(id);
        Integer code = obj != null ? Code.GET_OK : Code.GET_ERROR;
        String msg = obj != null ? "ok" : "查询失败，请稍候再试";
        return new Result(code, obj, msg);
    }

    @GetMapping
    public Result getAll() {
        List<User> obj = userService.getAll();
        Integer code = obj != null ? Code.GET_MULTI_OK : Code.GET_MULTI_ERROR;
        String msg = obj != null ? "ok" : "查询失败，请稍候再试";
        return new Result(code, obj, msg);
    }
}