package com.demo.wmh.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@TableName("u_userinfo")
public class UserInfo {
    private Integer id;
    private String name;
    private String password;
}
