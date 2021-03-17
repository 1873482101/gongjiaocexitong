package com.example.demo.service;

import java.util.List;

import com.example.demo.pojo.cheliang;


public interface cheliangService {

    public cheliang insertcheliang(cheliang Cheliang);

    public List<cheliang> getbyzhandian(String zhandian);

    public List<cheliang> getbycity(String city);

    public  List<cheliang>getbycityzhandian(String city, String zhandian);

    public  List<cheliang>getbycitygongjiaochehao(String city, Long gongjiaochehao);

    public cheliang getbyid(Long id);
    
    public int deletecheliang(Long id);
}