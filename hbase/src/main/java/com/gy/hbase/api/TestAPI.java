package com.gy.hbase.api;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.HBaseAdmin;

import java.io.IOException;

public class TestAPI {



    public static void main(String[] args) throws IOException {

        //1.测试表是否存在
        System.out.println(isTableExist("stu"));

    }


    public static boolean isTableExist(String tableName) throws IOException {
        //1.获取配置文件信息
        HBaseConfiguration configuration = new HBaseConfiguration();
        configuration.set("hbase.zookeeper.quorum","hadoop102,hadoop103,hadoop104");
        //2.获取管理员对象
        HBaseAdmin admin = new HBaseAdmin(configuration);
        //3.判断表是否存在
        boolean isExist = admin.tableExists(tableName);
        //关闭连接
        admin.close();
        return  isExist;
    }

}



