package com.priv.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *  mybatis-plus 官网文档  https://mp.baomidou.com/
 *  mybatis-plus 注解官方文档  https://mp.baomidou.com/guide/annotation.html#tablename
 * 如果数据库表含有user表（忽略大小写）则可以自动映射。
 * 我们可以通过 @TableName 注解来映射数据库表
 * </p>
 * @author fenghen
 * @since 2020-07-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_user")
@ApiModel(value="User对象", description="")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * @TableId 主键注解，如果没有开启驼峰或者与表中属性命名不一样，需要使用注解
     * ex:
     * @TableId(value = "id",type = IdType.AUTO)
     * private Long uid;
     * type是enum类型，AUTO,NONE,INPUT容易理解
     * ASSIGN_ID
     * ASSIGN_UUID
     * @TableField 字段注解，非主键，如果没有开启驼峰或者与表中属性命名不一样，需要使用注解
     * ex:
     * @TableField(value = "name",exist = true)
     * private String username;
     */
    @ApiModelProperty(value = "主键ID")
    private Long id;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "邮箱")
    private String email;


}
