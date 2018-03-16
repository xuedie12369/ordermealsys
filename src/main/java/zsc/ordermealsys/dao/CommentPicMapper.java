package zsc.ordermealsys.dao;

import zsc.ordermealsys.pojo.CommentPic;

public interface CommentPicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CommentPic record);

    int insertSelective(CommentPic record);

    CommentPic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommentPic record);

    int updateByPrimaryKeyWithBLOBs(CommentPic record);

    int updateByPrimaryKey(CommentPic record);
}