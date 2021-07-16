package com.example;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class GenerateTest {
    public static void main(String[] args) {
        //创建generator对象，操作这个对象生成代码
        AutoGenerator autoGenerator = new AutoGenerator();

        //建立数据源
        //generator要跟数据库连接，是根据数据表生成对应的Controller\Service\Mapper
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        //数据库类型，不同数据库语法不同，DbType是一个枚举类型
        //如果想查看具体内容的话，快捷键ctrl+Alt+B
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        //驱动不用改，以下根据数据库实际情况修改
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("Word123456.");
        dataSourceConfig.setUrl("jdbc:mysql://47.94.99.133:3306/Database");
        //将数据源装入Generator
        autoGenerator.setDataSource(dataSourceConfig);

        //全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        //设置生成的java文件、xml文件存放的位置
        //user.dir是获取当前工程的路径
        globalConfig.setOutputDir(System.getProperty("user.dir")+"/src/main/java");
        //代码生成后有一个注释，标注的作者
        globalConfig.setAuthor("xzc");
        //生成后是否打开文档
        globalConfig.setOpen(false);
        //声明Service层接口的名称，默认在前面加个I，%s写法可以把I去掉
        globalConfig.setServiceName("%sService");
        //将全局配置放入Generator
        autoGenerator.setGlobalConfig(globalConfig);

        //包信息
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.example");
        packageConfig.setEntity("entity");
        packageConfig.setMapper("mapper");
        packageConfig.setService("service");
        packageConfig.setServiceImpl("service.impl");
        packageConfig.setController("controller");
        autoGenerator.setPackageInfo(packageConfig);

        //策略配置
        //配置数据库相关的信息
        StrategyConfig strategyConfig = new StrategyConfig();
        //设置相关表，表名e.g."fruit","user"
        strategyConfig.setInclude("dic","user","word","img");
        //setNaming映射表名和实体类（因为java命名方式和数据库有区别）
        //underline_to_camel表示下划线转驼峰
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        //映射字段名和成员变量
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setEntityLombokModel(true);
        autoGenerator.setStrategy(strategyConfig);
        //运行
        autoGenerator.execute();
    }
}