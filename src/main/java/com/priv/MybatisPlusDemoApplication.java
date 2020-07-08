package com.priv;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

/**
 * @author fenghen
 */
@SpringBootApplication
@MapperScan("com.priv")
public class MybatisPlusDemoApplication {

    /**
     *
     * @param tip
     * @return
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {

        SpringApplication.run(MybatisPlusDemoApplication.class, args);

        AutoGenerator generator = new AutoGenerator();

        /**
         * 全局配置
         * System.getProperty() 获取系统信息 参数user.dir 表示 用户的当前工作目录 参考：https://www.cnblogs.com/leeego-123/p/12418932.html
         * setSwagger2 实体属性 Swagger2 注解
         */
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc      .setOutputDir(projectPath + "/src/main/java")
                .setAuthor("fenghen")
                .setOpen(false)
                .setSwagger2(true);
        generator.setGlobalConfig(gc);

        /**
         * 数据源配置
         */
        DataSourceConfig dsc = new DataSourceConfig();
        dsc     .setUrl("jdbc:mysql://localhost:3306/mybatis_plus_demo?serverTimezone=UTC")
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setUsername("root")
                .setPassword("root");
        generator.setDataSource(dsc);


        /**
         * 包配置
         */
        PackageConfig pc = new PackageConfig();
        pc      .setModuleName(scanner("模块名"))
                .setParent("com.priv")
                .setController("controller")
                .setService("service")
                .setServiceImpl("service.impl")
                .setMapper("mapper")
                .setEntity("entity")
                .setXml("mapper.xml");
        generator.setPackageInfo(pc);


        /**
         * 策略配置
         */
        StrategyConfig strategy=new StrategyConfig();
        strategy.setTablePrefix(pc.getModuleName() + "_")
                .setInclude(scanner("表名，多个英文逗号分割").split(","))
                .setNaming(NamingStrategy.underline_to_camel)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                .setEntityLombokModel(true);
        generator.setStrategy(strategy);

        /**
         * 模板配置，见官网，暂时没了解什么作用
         */
        /*……*/

        /**
         * 模板引擎，默认velocity，这里使用freemarker，pom.xml中需要添加依赖
         */
        generator.setTemplateEngine(new FreemarkerTemplateEngine());
        generator.execute();
    }

}
