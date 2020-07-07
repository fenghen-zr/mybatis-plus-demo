package com.priv.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * mybatis-plus 官网文档  https://mp.baomidou.com/
 * mybatis-plus 注解官方文档  https://mp.baomidou.com/guide/annotation.html#tablename
 */
/**
 * 如果数据库表含有user表（忽略大小写）则可以自动映射。
 * 我们可以通过 @TableName 注解来映射数据库表
 */
@Data
@TableName(value = "tb_user")
public class User {

    /**
     * 主键注解，如果没有开启驼峰或者与表中属性命名不一样，需要使用该注解
     * type是enum类型，AUTO,NONE,INPUT容易理解
     * ASSIGN_ID
     * ASSIGN_UUID
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Long uid;
    /**
     * 字段注解，非主键，如果没有开启驼峰或者与表中属性命名不一样，需要使用该注解
     */
    @TableField(value = "name",exist = true)
    private String username;
    private Integer age;
    private String email;
}
