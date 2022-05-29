package com.example.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class Students {

    @TableId(type = IdType.AUTO)
    private Integer sId;

    private String sName;

    private String sSex;

    private Integer sAge;

    private String sTel;

    private String sClass;

}
