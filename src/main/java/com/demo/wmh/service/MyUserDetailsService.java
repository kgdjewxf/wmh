package com.demo.wmh.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.demo.wmh.dao.UserDao;
import com.demo.wmh.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * spring security用到
 */
@Service("userDetailsServicel")
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        QueryWrapper<UserInfo> wrapper=new QueryWrapper<UserInfo>();
        wrapper.eq("name",userName);
        UserInfo userInfo=userDao.selectOne(wrapper);
        if(userInfo==null){
            throw new UsernameNotFoundException("用户名不存在");
        }
       List<GrantedAuthority> auths= AuthorityUtils.commaSeparatedStringToAuthorityList("role");
       return new User(userInfo.getName(),new BCryptPasswordEncoder().encode(userInfo.getPassword()),auths);
    }
}
