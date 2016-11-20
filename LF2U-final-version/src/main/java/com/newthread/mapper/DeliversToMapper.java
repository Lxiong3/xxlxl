package com.newthread.mapper;

import com.newthread.domain.DeliversTo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Author:黄平财
 * Date:2016/11/19
 * Mail:11867939@qq.com
 */
public interface DeliversToMapper {

    @Insert("insert into delivery_to(delivery_to_id,uid,zip) VALUES(#{delivery_to_id},#{uid},#{zip});")
    int insert(DeliversTo deliversTo);

    @Select("select uid from delivery_to where zip = #{zip}")
    List<String> selectUidByZip(Integer zip);

    @Select("select name from delivery_to where zip = #{zip} limit 1")
    String selectNameByByZip(Integer zip);

    @Delete("delete from delivery_to where uid = #{fid}")
    int deleteAllByFid(String fid);

    @Select("select zip from delivery_to where uid = #{uid}")
    List<String> selectZipByUid(String uid);
}
