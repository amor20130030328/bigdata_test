package com.gy.hbase.weibo.utils;

import com.gy.hbase.weibo.constants.Constants;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

import java.io.IOException;

/**
 * 1. 创建命名空间
 * 2. 判断表是否存在
 * 3. 创建表（三张表）
 */
public class HBaseUtils {

    private static Admin admin = null;
    private static Connection connection = null;

    /**
     * 创建命名空间
     * @param namespace
     */
    public  static void createNamespace(String namespace) throws IOException {

        //1.获取Connection对象
        Connection connection = ConnectionFactory.createConnection(Constants.CONFIGURATION);
        //2.获取Admin对象
        Admin admin = connection.getAdmin();
        //3.创建命名空间描述器
        NamespaceDescriptor namespaceDescriptor = NamespaceDescriptor.create(namespace).build();
        //4.创建命名空间
        admin.createNamespace(namespaceDescriptor);

        //5.关闭资源
        admin.close();
        connection.close();
    }

    /**
     * 判断表是否存在
     * @return
     */
    private static boolean isTableExist(String tableName) throws IOException {

        //1.获取Connection对象
        Connection connection = ConnectionFactory.createConnection(Constants.CONFIGURATION);
        //2.获取Admin对象
        Admin admin = connection.getAdmin();
        //3.判断是否存在
        boolean exists = admin.tableExists(TableName.valueOf(tableName));
        //4.关闭资源
        admin.close();
        connection.close();
        return exists;
    }

    /**
     * 3.创建表
     * @param tableName
     * @param version
     * @param cfs
     */
    public static void createTable(String tableName,int version , String ... cfs) throws IOException {

        //1.判断是否传入了列族信息
        if(cfs.length <=0 ){
            System.out.println("请设置列族信息!!!");
            return;
        }

        //2.判断表是否存在
        if(isTableExist(tableName)){
            System.out.println(tableName +"表已存在 ");
            return;
        }

        //3.获取Connection对象
        Connection connection = ConnectionFactory.createConnection(Constants.CONFIGURATION);
        //4.获取Admin对象
        Admin admin = connection.getAdmin();
        //5.创建表描述器
        HTableDescriptor hTableDescriptor = new HTableDescriptor(TableName.valueOf(tableName));
        //6.添加列族信息
        for (String cf : cfs) {
            HColumnDescriptor hColumnDescriptor = new HColumnDescriptor(cf);
            //7.设置版本
            hColumnDescriptor.setMaxVersions(version);
            hTableDescriptor.addFamily(hColumnDescriptor);
        }

        //8.创建表操作
        admin.createTable(hTableDescriptor);
        //9.关闭资源
        admin.close();
        connection.close();



    }
}
