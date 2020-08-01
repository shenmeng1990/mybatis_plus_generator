package com.alibaba.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

/**
 * @Author shenmeng
 * @Date 2020/8/1
 **/
public class CodeGenerator {

    public static void main(String[] args) {
        //使用代码生成器
        AutoGenerator mpg = new AutoGenerator();

        //使用全局配置
        GlobalConfig gc = new GlobalConfig();
        // 获取项目路径
        String projectPath = System.getProperty("user.dir");
        // 生成文件的输出目录
        gc.setOutputDir(projectPath + "/src/main/java");
        // 作者
        gc.setAuthor("shenmeng");
        // 开启 swagger2 模式
        gc.setSwagger2(true);
        // 是否打开输出目录
        gc.setOpen(false);
        // 指定生成的主键的ID类型
        gc.setIdType(IdType.AUTO);
        // 如果有同名文件，是否覆盖
        gc.setFileOverride(true);
        // 设置给到代码生成器
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        // 选择使用 MySQL
        dsc.setDbType(DbType.MYSQL);
        dsc.setUrl("jdbc:mysql://mysqlos:3306/springdb?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=Asia/Shanghai");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        mpg.setDataSource(dsc);

        //包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.alibaba");
        mpg.setPackageInfo(pc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        //表名，多个用逗号隔开
        strategy.setInclude("user");
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}
