package com.demo.wmh.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.wmh.pojo.UserInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends BaseMapper<UserInfo> {
}
