package com.example.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Classes {

    @TableId
    private String cClass;

    private String cTeacher;

    private String cSubject;

    private Date cStartday;

}
