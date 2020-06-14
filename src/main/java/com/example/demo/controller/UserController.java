package com.example.demo.controller;

import com.example.demo.model.RestResponseVO;
import com.example.demo.model.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author zhbin
 * @date 2019-08-19
 */
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * valid 能组合嵌套验证
     */
    @RequestMapping("/get")
    public RestResponseVO getUser(@Valid @RequestBody User user){
        return RestResponseVO.ok();
    }
}
