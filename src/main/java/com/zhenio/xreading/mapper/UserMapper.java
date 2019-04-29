package com.zhenio.xreading.mapper;

import com.zhenio.xreading.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserMapper {
    //插入
    @Insert("INSERT INTO tb_user(name,password)VALUES (#{name},#{password})")
    @SelectKey(statement = "SELECT seq id FROM sqlite_sequence WHERE (name = 'tb_user')",before = false,keyProperty = "id",resultType = Integer.class)
    int inser(User user);
    // 根据 ID 查询
    @Select("select * from tb_user WHERE id = #{id}")
    User findById(int id);
    @Select("select * from tb_user")
    List<User> findAll();

    @Update("UPDATE tb_user SET value=#{value} WHERE id=#{id}")
    int updateValue(User user);

    @Select("SELECT * from tb_user WHERE name =#{name}")
    User findByName(String name);

}
