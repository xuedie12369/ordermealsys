package zsc.ordermealsys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import zsc.ordermealsys.common.ServerResponse;
import zsc.ordermealsys.pojo.Category;
import zsc.ordermealsys.pojo.User;

public interface UserMapper {
	int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);
    
    User selectByUserName(String username);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKeyWithBLOBs(User record);

    int updateByPrimaryKey(User record);
    
    int checkUsername(String username);
    
    int checkEmail(String email);
    
    User selectLogin(@Param("username") String username, @Param("pwd") String pwd);
    
    String selectQuestionByUsername(String username);
    
    int checkAnswer(@Param("username") String username, @Param("question") String question, @Param("answer") String answer);
    
    int updatePasswordByUsername(@Param("username")String username,@Param("passwordNew")String passwordNew);
    ServerResponse<List<Category>> getChildrenParallelCategory(@Param("parentId")Integer parentId);
    
    
    
}