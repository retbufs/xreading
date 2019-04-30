package com.zhenio.xreading.mapper;

import com.zhenio.xreading.model.Shares;
import com.zhenio.xreading.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface SharesMapper {
    @Insert("INSERT INTO tb_shares(fdcode,abbrev,spell,type)VALUES (#{fdcode},#{abbrev},#{spell},#{type})")
    @SelectKey(statement = "SELECT seq id FROM sqlite_sequence WHERE (name = 'tb_shares')", before = false, keyProperty = "id", resultType = Integer.class)
    int insert(Shares shares);

    @Select("SELECT *,count(*) FROM tb_shares limit {pageSize} offset {currPage}")
    List<Shares> page(int currPage, int pageSize);

    @Select("SELECt * FROM tb_shares group by id")
    List<Shares> findAll();

    @Select("SELECT count(*) as count FROM tb_shares")
    public int count();
}
