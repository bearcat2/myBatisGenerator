package com.zzp.mybatis.generate;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Description: 网上找的myBatis 自动生成 实体、接口和映射文件 </p>
 * <p>Title: MybatisGenerator </p>
 * <p>Create Time: 2018/6/9 21:35 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
public class MybatisGenerator {

    public static void main(String[] args) {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        String genCfg = "/mbgConfiguration.xml";
        File configFile = new File(MybatisGenerator.class.getResource(genCfg).getFile());
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = null;
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = null;
        try {
            config = cp.parseConfiguration(configFile);
            myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("genarate ok !!!");
    }
}
