package com.shaziyou.demo.mapper;

import com.shaziyou.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author shaziyou
 */
@Mapper
public interface UserMapper {

    /**
     * 根据用户名查询用户信息
     *
     * @param userName 用户名
     * @return 用户信息
     */
    @Select("select * from user where name = #{param} ")
    User selectByUserName(String userName);

}
