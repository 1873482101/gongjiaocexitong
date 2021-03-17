package com.example.demo.service.impl;

import java.util.List;

import com.example.demo.dao.cheliangdao;
import com.example.demo.pojo.cheliang;
import com.example.demo.service.cheliangService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class cheliangServiceImpl implements cheliangService{
    //用来给指定的字段或方法注入所需的外部资源。
    @Autowired
    private cheliangdao cheliangDao = null;
    
    @Override
    public cheliang insertcheliang(cheliang Cheliang){
        return cheliangDao.insertcheliang(Cheliang) >0 ? Cheliang  : null;
    }

    @Override
    public List<cheliang> getbyzhandian(String zhandian){
        return cheliangDao.getbyzhandian(zhandian);
    }

    @Override
    public List<cheliang> getbycityzhandian(String city,String zhandian){
        return cheliangDao.getbycityzhandian(city,zhandian);
    }

    @Override
    public List<cheliang> getbycitygongjiaochehao(String city,Long gongjiaochehao){
        return cheliangDao.getbycitygongjiaochehao(city,gongjiaochehao);
    }

    @Override
    public List<cheliang> getbycity(String city){
        return cheliangDao.getbycity(city);
    }

    @Override
    public cheliang getbyid(Long id){
        return cheliangDao.getbyid(id);
    }

    @Override
    public int deletecheliang(Long id){
        return cheliangDao.deletecheliang(id);
    }
}