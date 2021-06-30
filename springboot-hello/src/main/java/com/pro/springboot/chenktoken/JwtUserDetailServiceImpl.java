package com.pro.springboot.chenktoken;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @className: JwtUserDetailServiceImpl
 * @description: user 服务类
 * @author: liguangyue
 * @date: 2021/2/2 9:33
 **/
@Service
public class JwtUserDetailServiceImpl implements UserDetailsService {

    /**
     * 日志对象
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtUserDetailServiceImpl.class);

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //暂时写成固定的，后期是要在数据库查询做比对
        String userName = "admin";
        if(!s.equals(userName))
        {
            return null;//用户不是admin，报错
        }
        LOGGER.info("传入的用户名是：|{}" + s);
        return new JwtUser("admin","e10adc3949ba59abbe56e057f20f883e", AuthorityUtils.commaSeparatedStringToAuthorityList("user"));
    }
}
