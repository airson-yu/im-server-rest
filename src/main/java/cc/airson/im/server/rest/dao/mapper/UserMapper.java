package cc.airson.im.server.rest.dao.mapper;

import cc.airson.im.server.rest.dao.po.User;
import org.apache.ibatis.annotations.*;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

/**
 * @author yuronghua-airson
 * @description Mybatis Mapper: Article
 * @template 2019.08.02 v11.0
 * @organization Zero One More, Inc. http://www.01more.com
 * @remark 视频点名结果表（调度台上报的原始数据）
 * @time 2019-11-25 12:18:03
 */
@Repository
public interface UserMapper {

    @Select("SELECT * FROM tech_user WHERE id = #{id}")
    User load(long id);

    @Select("SELECT * FROM tech_user WHERE account = #{account} AND password = #{password}")
    User selectForLogin(String account, String password);

    @Select("SELECT * FROM tech_user")
    Page<User> list();

    //@SelectKey(statement = "select last_insert_id()", keyProperty = "id", before = false, resultType = Integer.class)
    @Insert("INSERT INTO tech_user(user_name, phone, password, create_time) VALUES(#{userName}, #{phone}, #{password}, NOW())")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(User obj);

    @Update("UPDATE tech_user SET user_name=#{userName},phone=#{phone},update_time=NOW() WHERE id = #{id}")
    int update(User obj);

    @Delete("DELETE FROM tech_user WHERE id= #{id}")
    int delete(Long id);

    /*List<Article> selectDetailListByCondition(Map<String, Object> map);

    Long selectDetailCountByCondition(Map<String, Object> map);

    List<RollcallStatistics> selectHighListByCondition(Map<String, Object> map);

    Long selectHighCountByCondition(Map<String, Object> map);

    int updateStateById(@Param("id") Long id, @Param("state") Integer state);

    // select methods

    RollcallResult load(long id);

    RollcallResult selectByPrimaryKey(long id);

    List<RollcallResult> selectListByCondition(Map<String, Object> map);

    RollcallResult selectByCondition(Map<String, Object> map);

    Long selectCountByCondition(Map<String, Object> map);

    // update methods

    int updateByPrimaryKey(RollcallResult rollcallResult);

    int updateByPrimaryKeySelective(RollcallResult rollcallResult);

    // insert methods

    int insert(RollcallResult rollcallResult);

    int insertSelective(RollcallResult rollcallResult);

    int insertBatch(List<RollcallResult> rollcallResult);

    // delete methods

    int deleteByPrimaryKey(long id);*/

}