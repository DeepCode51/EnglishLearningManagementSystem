package com.chun.myspringboot.mapper;

import com.chun.myspringboot.pojo.Listen;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ListenMapper {
    //根据ID查询一条听力的信息
    Listen queryListenById(Integer listenId);
    //增加一条听力
    int addListen(Listen listen);
    //删除一条听力
    int deleteListen(Integer listenId);
    //修改一条听力
    int updateListen(Listen listen);
    //查看所有听力所有信息
    List<Listen> queryAllListen();
}
