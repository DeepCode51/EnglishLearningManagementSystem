package com.chun.myspringboot.service.Impl;

import com.chun.myspringboot.mapper.ListenMapper;
import com.chun.myspringboot.pojo.Listen;
import com.chun.myspringboot.service.ListenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ListenServiceImpl implements ListenService {
    @Autowired
    ListenMapper listenMapper;

    @Override
    public Listen queryListenById(Integer listenId) {
        return listenMapper.queryListenById(listenId);
    }

    @Override
    public int addListen(Listen listen) {
        return listenMapper.addListen(listen);
    }

    @Override
    public int deleteListen(Integer listenId) {
        return listenMapper.deleteListen(listenId);
    }

    @Override
    public int updateListen(Listen listen) {
        return listenMapper.updateListen(listen);
    }

    @Override
    public List<Listen> queryAllListen() {
        return listenMapper.queryAllListen();
    }
}
