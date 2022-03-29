package com.resico.plant.mysql;

import com.resico.plant.mysql.config.MysqlProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author Airey
 * @since 2022/3/29 14:43
 */
@Service
@RequiredArgsConstructor
public class MysqlService {

    private final MysqlProperties mysqlProperties;


    /**
     * 备份mysql数据库
     *
     * @param username 账号
     * @param pwd      密码
     * @param url      地址
     * @param path     路径
     * @throws Exception
     */
    public void dbBackUpMysql(String dbName, String username, String pwd, String url, String path) throws Exception {
        //mysqldump -h 127.0.0.1 -uroot -proot mysql user >D:/info/server/var/backupdata/backups.sql

        String pathSql = path + dbName + ".sql";
        File fileSql = new File(pathSql);
        File filePath = new File(path);
        //创建备份sql文件
        if (!filePath.exists()) {
            fileSql.mkdirs();
        }
        if (!fileSql.exists()) {
            fileSql.createNewFile();
        }
        //mysqldump -hlocalhost -uroot -p123456 db > /home/back.sql
        StringBuffer sb = new StringBuffer();
        sb.append("E:\\Program Files\\mysql-5.7.13-winx64\\bin\\mysqldump");
        sb.append(" -h" + url);
        sb.append(" -u" + username);
        sb.append(" -p" + pwd);
        sb.append(" --set-charset=utf8 ");
        sb.append(" " + dbName + " >");
        sb.append(pathSql);
        System.out.println("cmd命令为：" + sb.toString());
        System.out.println("开始备份：" + dbName);
        Process process = null;
        //判断操作系统 windwos与linux使用的语句不一样
        if (System.getProperty("os.name").toLowerCase().indexOf("windows") > -1) {
            process = Runtime.getRuntime().exec("cmd /c" + sb.toString());
        } else if (System.getProperty("os.name").toLowerCase().indexOf("linux") > -1) {
            process = Runtime.getRuntime().exec("/bin/sh -c" + sb.toString());
        } else {
            throw new Exception("暂不支持该操作系统，进行数据库备份或还原！");
        }
        //设置超时一分钟
        process.waitFor(60000, TimeUnit.MILLISECONDS);
        //输出返回的错误信息


        StringBuffer mes = new StringBuffer();
        String tmp = "";
        BufferedReader error = new BufferedReader(new InputStreamReader(process.getErrorStream(), "utf8"));
        while ((tmp = error.readLine()) != null) {
            mes.append(tmp + "\n");
        }
        if (mes != null || !"".equals(mes)) {
            System.out.println("备份成功!==>" + mes.toString());
        }
        error.close();
    }

    /**
     * @param hostIP       ip地址，可以是本机也可以是远程
     * @param userName     数据库的用户名
     * @param password     数据库的密码
     * @param savePath     备份的路径
     * @param fileName     备份的文件名
     * @param databaseName 需要备份的数据库的名称
     * @return
     */
    public boolean backup(String hostIP, String userName, String password, String savePath, String fileName,
                          String databaseName) {
        fileName += ".sql";
        File saveFile = new File(savePath);
        if (!saveFile.exists()) {// 如果目录不存在
            saveFile.mkdirs();// 创建文件夹
        }
        if (!savePath.endsWith(File.separator)) {
            savePath = savePath + File.separator;
        }

        //拼接命令行的命令
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("E:\\Program Files\\mysql-5.7.13-winx64\\bin\\mysqldump").append(" --opt").append(" -h").append(hostIP);
        stringBuilder.append(" --user=").append(userName).append(" --password=").append(password)
                .append(" --lock-all-tables=true");
        stringBuilder.append(" --result-file=").append(savePath + fileName).append(" --default-character-set=utf8 ")
                .append(databaseName);
        try {
            //调用外部执行exe文件的javaAPI
            Process process = Runtime.getRuntime().exec(stringBuilder.toString());
            if (process.waitFor() == 0) {// 0 表示线程正常终止。
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }


    /**
     * mysql的备份方法
     *
     * @param command  命令行
     * @param savePath 备份路径
     * @return
     */
    public boolean backup(String command, String savePath) {
        boolean flag;
        // 获得与当前应用程序关联的Runtime对象
        Runtime r = Runtime.getRuntime();
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            // 在单独的进程中执行指定的字符串命令
            Process p = r.exec(command);
            // 获得连接到进程正常输出的输入流，该输入流从该Process对象表示的进程的标准输出中获取数据
            InputStream is = p.getInputStream();
            // InputStreamReader是从字节流到字符流的桥梁：它读取字节，并使用指定的charset将其解码为字符
            InputStreamReader isr = new InputStreamReader(is, "utf-8");
            //BufferedReader从字符输入流读取文本，缓冲字符，提供字符，数组和行的高效读取
            br = new BufferedReader(isr);
            String s;
            StringBuffer sb = new StringBuffer("");
            // 组装字符串
            while ((s = br.readLine()) != null) {
                sb.append(s + System.lineSeparator());
            }
            s = sb.toString();
            // 创建文件输出流
            FileOutputStream fos = new FileOutputStream(savePath);
            // OutputStreamWriter是从字符流到字节流的桥梁，它使用指定的charset将写入的字符编码为字节
            OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
            // BufferedWriter将文本写入字符输出流，缓冲字符，以提供单个字符，数组和字符串的高效写入
            bw = new BufferedWriter(osw);
            bw.write(s);
            bw.flush();
            flag = true;
        } catch (IOException e) {
            flag = false;
            e.printStackTrace();
        } finally {
            //由于输入输出流使用的是装饰器模式，所以在关闭流时只需要调用外层装饰类的close()方法即可，
            //它会自动调用内层流的close()方法
            try {
                if (null != bw) {
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (null != br) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }


    /**
     * mysql的还原方法
     *
     * @param command  命令行
     * @param savePath 还原路径
     * @return
     */
    public boolean recover(String command, String savePath) {
        boolean flag;
        Runtime r = Runtime.getRuntime();
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            Process p = r.exec(command);
            OutputStream os = p.getOutputStream();
            FileInputStream fis = new FileInputStream(savePath);
            InputStreamReader isr = new InputStreamReader(fis, "utf-8");
            br = new BufferedReader(isr);
            String s;
            StringBuffer sb = new StringBuffer("");
            while ((s = br.readLine()) != null) {
                sb.append(s + System.lineSeparator());
            }
            s = sb.toString();
            OutputStreamWriter osw = new OutputStreamWriter(os, "utf-8");
            bw = new BufferedWriter(osw);
            bw.write(s);
            bw.flush();
            flag = true;
        } catch (IOException e) {
            flag = false;
            e.printStackTrace();
        } finally {
            try {
                if (null != bw) {
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (null != br) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }





}
