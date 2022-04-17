package com.ns.mptest.entiy;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;

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
