package com.ns.mptest.entiy;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

import java.util.Date;

/**
 * @author 宁松
 * @ClassName Student
 * @createTime 2022年04月15日 17:38
 */
@Data
public class Student {
    private Long id;
    private String name;
    private Integer age;


    //在需要自动填充的属性添加注解
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;  //create_time
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime; //update_time

    //mp实现乐观锁
    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version;

    //逻辑删除
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer deleted;
}
