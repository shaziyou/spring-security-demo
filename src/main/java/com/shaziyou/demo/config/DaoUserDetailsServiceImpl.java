package com.shaziyou.demo.config;

import com.shaziyou.demo.mapper.UserMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class DaoUserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.shaziyou.demo.entity.User user = userMapper.selectByUserName(username);
        if (null == user) {
            throw new UsernameNotFoundException("未找到用户：" + username);
        }
        String password = user.getPassword();
        String roles = user.getRoles();
        User userDetail = new User(username, password, generateGrantedAuthority(roles));
        return userDetail;
    }

    private Collection<? extends GrantedAuthority> generateGrantedAuthority(String roles) {
        List<SimpleGrantedAuthority> grantedAuthorityList = new ArrayList<>();
        String[] role = roles.split(",");
        for (String r : role) {
            grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_" + r));
        }
        return grantedAuthorityList;
    }
}
