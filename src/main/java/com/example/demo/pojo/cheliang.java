package com.example.demo.pojo;

import org.apache.ibatis.type.Alias;
//公交车站点表数据对象原型
//对实体类加注解从mapper中的xml文件映射到下方
@Alias("cheliang")
public class cheliang {
    private Long id;
    private String city;
    private Long gongjiaochehao;
//    private Long shuliang;
    private String zhandian;
    private String time;

    public Long getid(){
        return id;
    }

    public String getcity(){
        return city;
    }

    public Long getgongjiaochehao(){
        return gongjiaochehao;
    }

    // public Long getshuliang(){
    //     return shuliang;
    // }

    public String getzhandian(){
        return zhandian;
    }

    public String gettime(){
        return time;
    }

    public void setid(Long id){
        this.id = id;
    }

    public void setcity(String city){
        this.city = city;
    }

    public void setgongjiaochehao(Long gongjiaochehao){
        this.gongjiaochehao = gongjiaochehao;
    }

    // public void setshuliang(Long shuliang){
    //     this.shuliang = shuliang;
    // }

    public void setzhandian(String zhandian){
        this.zhandian = zhandian;
    }

    public void settime(String time){
        this.time = time;
    }
}