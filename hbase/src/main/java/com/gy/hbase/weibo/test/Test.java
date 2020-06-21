package com.gy.hbase.weibo.test;

import com.gy.hbase.weibo.constants.Constants;
import com.gy.hbase.weibo.dao.HBaseDao;
import com.gy.hbase.weibo.utils.HBaseUtils;

import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {

        init();

        //1001发布微博
        HBaseDao.publishWeiBo("1001","lxy，我爱你");
        //1002关注1001和1003
        HBaseDao.addAttends("1002","1001","1003");
        //获取1002初始化页面
        System.out.println("获取1002初始化页面");
        HBaseDao.getInit("1002");
        //1003发布三条微博，同时1001发布2条微博
        HBaseDao.publishWeiBo("1003","lisi我爱你");
        HBaseDao.publishWeiBo("1003","yjl我爱你");
        HBaseDao.publishWeiBo("1003","xh我爱你");
        HBaseDao.publishWeiBo("1002","dzy我爱你");
        HBaseDao.publishWeiBo("1002","gm我爱你");
        System.out.println("获取1002初始化页面");
        HBaseDao.getInit("1002");
        //1002取关1003
        HBaseDao.deleteAttends("1002","1003");
        //获取1002初始化页面
        System.out.println("获取1002初始化页面");
        HBaseDao.getInit("1002");
        //1002再次关注1003
        HBaseDao.addAttends("1002","1003");

        //获取1001微博详情
        System.out.println("获取1001微博详情");
        HBaseDao.getWeiBo("1001");


    }

    public static void init(){


        try {
            //创建命名空间
            HBaseUtils.createNamespace(Constants.NAMESPACE);
            //创建微博内容表
            HBaseUtils.createTable(Constants.CONTENT_TABLE,Constants.CONTENT_TABLE_VERSIONS,Constants.CONTENT_TABLE_CF);
            //创建用户关系表
            HBaseUtils.createTable(Constants.RELATION_TABLE,Constants.RELATION_TABLE_VERSIONS,Constants.RELATION_TABLE_CF1,Constants.RELATION_TABLE_CF2);
            //创建收件箱表
            HBaseUtils.createTable(Constants.INBOX_TABLE,Constants.INBOX_TABLE_VERSIONS,Constants.INBOX_TABLE_CF);



        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
