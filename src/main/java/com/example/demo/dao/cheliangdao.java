package com.example.demo.dao;

import java.util.List;

import com.example.demo.pojo.cheliang;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface cheliangdao {
    public List<cheliang> getbychelianghao(Long chelianghao);

    public List<cheliang> getbyzhandian(String zhandian);

    public List<cheliang> getbycity(String city);

    public List<cheliang> getbycityzhandian(String city, String zhandian);

    public List<cheliang> getbycitygongjiaochehao(String city, Long gongjiaochehao);

    public cheliang getbyid(Long id);

    public int insertcheliang(cheliang Cheliang);
    
    public int deletecheliang(Long id);

}