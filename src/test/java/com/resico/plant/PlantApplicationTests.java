package com.resico.plant;

import com.resico.plant.mysql.MysqlService;
import com.resico.plant.mysql.config.MysqlProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PlantApplicationTests {

    @Autowired
    private MysqlProperties mysqlProperties;

    @Autowired
    private MysqlService mysqlService;

    @Test
    void contextLoads() {
    }


    @Test
    public void testProperties() {


        String userName = mysqlProperties.getUserName();
        String dbUrl = mysqlProperties.getDbUrl();
        String password = mysqlProperties.getPassword();
        String dbName = mysqlProperties.getDbName();

        String path = "F:\\mysqldump\\";
        try {
//        mysqlService.dbBackUpMysql(dbName,userName,password,dbUrl,path);

//            mysqlService.backup(dbUrl,userName,password,path,"airey",dbName);


//            //测试备份
//            String command1 = "E:\\Program Files\\mysql-5.7.13-winx64\\bin\\mysqldump -h192.168.100.23 -udev -pResico@dev --set-charset=utf8  resico-invoice-dev2";//参数依次是IP、账号、密码、数据库名
//            String savePath1 = "F:\\mysqldump\\dev2.sql";
//            boolean b1 = mysqlService.backup(command1, savePath1);
//            if (b1) {
//                System.out.println("备份成功");
//            } else {
//                System.out.println("备份失败");
//            }


            //测试还原
            String command2 = "E:\\Program Files\\mysql-5.7.13-winx64\\bin\\mysql -h192.168.100.23 -udev -pResico@dev  --default-character-set=utf8  resico-invoice-dev2";
            String savePath2 = "F:\\mysqldump\\dev2.sql";
            boolean b2 = mysqlService.recover(command2, savePath2);
            if (b2) {
                System.out.println("还原成功");
            } else {
                System.out.println("还原失败");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
