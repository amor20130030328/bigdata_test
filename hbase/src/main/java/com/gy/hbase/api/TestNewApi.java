package com.gy.hbase.api;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

public class TestNewApi {

    private static Admin admin = null;
    private static  Connection connection = null;

    static {
        //1.获取配置文件信息

        Configuration configuration = HBaseConfiguration.create();
        configuration.set("hbase.zookeeper.quorum","hadoop102,hadoop103,hadoop104");
        //2.获取管理员对象
        try {
            connection = ConnectionFactory.createConnection(configuration);
            admin = connection.getAdmin();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void close(){

        if(admin != null){
            try {
                admin.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(connection != null ){
            try {
                connection.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 判断表是否存在
     * @param tableName
     * @return
     * @throws IOException
     */
    public static boolean isTableExist(String tableName) throws IOException {

        boolean isExist = admin.tableExists(TableName.valueOf(tableName));
        return  isExist;
    }


    /**
     * 创建表
     * @param tableName
     * @param cfs
     * @throws IOException
     */
    public static void createTable(String tableName,String ... cfs) throws IOException {

        if(cfs.length < 1){
            System.out.println("请设置列族信息");
            return;
        }

        if (isTableExist(tableName)){
            System.out.println("表已经存在");
            return;
        }

        //创建表描述器信息
        HTableDescriptor hTableDescriptor = new HTableDescriptor(TableName.valueOf(tableName));
        for(String cf : cfs ){
            //5.创建列族描述器
            HColumnDescriptor hColumnDescriptor = new HColumnDescriptor(cf);
            //添加具体的列族信息
            hTableDescriptor.addFamily(hColumnDescriptor);
        }

        //创建表
        admin.createTable(hTableDescriptor);
    }


    /**
     * 删除表
     * @param tableName
     * @throws IOException
     */
    public static void dropTable(String tableName) throws IOException {
        if (!isTableExist(tableName)){
            System.out.println("表不存在");
            return;
        }

        //使表下线
        admin.disableTable(TableName.valueOf(tableName));
        //删除表
        admin.deleteTables(tableName);
    }


    /**
     * 创建命名空间
     * @param namespace
     */
    public  static void createNamespace(String namespace){

        //1.创建命名空间描述器
        NamespaceDescriptor namespaceDescriptor = NamespaceDescriptor.create(namespace).build();
        //2.创建命名空间

        try {
            admin.createNamespace(namespaceDescriptor);
        }catch (NamespaceExistException e){
            System.out.println(namespace + "命名空间已经存在");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void putData(String tableName,String rowKey,String cf,String cn, String value) throws IOException {

        //1、获取表对象
        Table table = connection.getTable(TableName.valueOf(tableName));

        //2.创建Put对象
        Put put = new Put(Bytes.toBytes(rowKey));

        //3.给Put对象赋值
        put.addColumn(Bytes.toBytes(cf) , Bytes.toBytes(cn),Bytes.toBytes(value));
        //4.插入数据
        table.put(put);

        table.close();


    }


    public static void GetData(String tableName,String rowKey) throws IOException {

        //1、获取表对象
        Table table = connection.getTable(TableName.valueOf(tableName));

        //2.创建Get对象
        Get get = new Get(Bytes.toBytes(rowKey));

        Result result = table.get(get);

        Cell[] cells = result.rawCells();

        for (Cell cell : cells){
            System.out.println("cf:" + Bytes.toString(CellUtil.cloneFamily(cell)));
            System.out.println("cn:"+Bytes.toString(CellUtil.cloneQualifier(cell)));
            System.out.println("value"+Bytes.toString(CellUtil.cloneValue(cell)));
        }

        table.close();
    }

    public static void GetData(String tableName,String rowKey,String cf,String cn) throws IOException {

        //1、获取表对象
        Table table = connection.getTable(TableName.valueOf(tableName));

        //2.创建Get对象
        Get get = new Get(Bytes.toBytes(rowKey));
        get.addFamily(Bytes.toBytes(cf));
        get.addColumn(Bytes.toBytes(cf),Bytes.toBytes(cn));
        get.setMaxVersions(5);    //设置最大版本数

        Result result = table.get(get);

        Cell[] cells = result.rawCells();

        for (Cell cell : cells){
            System.out.println("cf:" + Bytes.toString(CellUtil.cloneFamily(cell)));
            System.out.println("cn:"+Bytes.toString(CellUtil.cloneQualifier(cell)));
            System.out.println("value"+Bytes.toString(CellUtil.cloneValue(cell)));
        }


        table.close();


    }

    public static void ScanTable(String tableName) throws IOException {

        //1、获取表对象
        Table table = connection.getTable(TableName.valueOf(tableName));

        Scan scan = new Scan(Bytes.toBytes("10001"),Bytes.toBytes("10004"));
        ResultScanner resultScanner = table.getScanner(scan);

        for (Result result : resultScanner) {
            for (Cell cell : result.rawCells()){
                System.out.println("rowkey:" + Bytes.toString(CellUtil.cloneRow(cell)));
                System.out.println("cf:" + Bytes.toString(CellUtil.cloneFamily(cell)));
                System.out.println("cn:"+Bytes.toString(CellUtil.cloneQualifier(cell)));
                System.out.println("value"+Bytes.toString(CellUtil.cloneValue(cell)));
            }
        }


        table.close();
    }

    public static void delete(String tableName,String rowkey) throws IOException {

        //1、获取表对象
        Table table = connection.getTable(TableName.valueOf(tableName));

       Delete delete = new Delete(Bytes.toBytes(rowkey));
       table.delete(delete);
        table.close();
    }

    public static void deleteColumn(String tableName,String rowkey,String cf,String cn) throws IOException {

        //1、获取表对象
        Table table = connection.getTable(TableName.valueOf(tableName));

        Delete delete = new Delete(Bytes.toBytes(rowkey));
        //delete.addColumns(Bytes.toBytes(cf),Bytes.toBytes(cn));
        delete.addColumn(Bytes.toBytes(cf),Bytes.toBytes(cn),1592473712544L);   //只删除最近的一个版本，之前的版本会重现
        table.delete(delete);
        table.close();
    }

    public static void main(String[] args) throws Exception {

        //1.测试表是否存在
       // System.out.println(isTableExist("stu"));
       // System.out.println(isTableExist("stu222"));


        //2.测试创建表

       // createTable("teacher","baseInfo","otherInfo");

       //3.测试删除表
       // dropTable("teacher");

        //4.新增命名空间
        //createNamespace("lianyi");

        //4.新增数据测试
       // putData("teacher","10001","baseInfo","name","fanbingjie");

        //5.测试查询
        //GetData("teacher","10001","baseInfo","name");   //指定一行一列
        //GetData("teacher","10001");     //获取一行数据
        //ScanTable("teacher");   //全表查询

        //6.测试删除
        //delete("stu2","1004");
        deleteColumn("stu2","10000","info","name");

        close();
    }

}

