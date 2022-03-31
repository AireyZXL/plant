package com.resico.plant.mysql;

import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;
import org.apache.commons.net.ntp.TimeStamp;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;


public class ServerUtil {

//    private static Logger logger = LogManager.getLogger(ServerUtil.class);
    public static void main(String[] args) {


        getHostAddress();
        getLocalTime();
        getNTPServerTime();
//        modifyDate();
//        modifyTime();
        updateLocaltime(null,null);


    }


    /**
     * 返回本机服务器地址
     * */
    public static String getHostAddress() {
        try {
            System.out.println("本机服务器地址：" + InetAddress.getLocalHost().getHostAddress());
            return InetAddress.getLocalHost().getHostAddress();//获得本机IP
        } catch (UnknownHostException e) {
            throw new RuntimeException("获取服务器地址失败异常"+e.getMessage());
        }
    }


    /**
     * 返回本机服务器时间
     * */
    public static LocalDateTime getLocalTime() {
        long milliSecond = Instant.now().toEpochMilli();
        LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(milliSecond), ZoneOffset.ofHours(8));
//        logger.info("本机服务器时间"+dateTime);
        System.out.println("本机服务器时间"+dateTime);
        return dateTime;

//        Date date = new Date();//创建日期
//        SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");//设置日期格式
//        System.out.println("本机服务器时间：" + df.format(date));
//        return df.format(date);
    }


    /***
     * 获取NTP服务时间
     * @return
     */
    public static LocalDateTime getNTPServerTime() {
//        logger.info("开始获取NTP服务时间");
        System.out.println("开始获取NTP服务时间");
        SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        try {
            NTPUDPClient timeClinent = new NTPUDPClient();
            //上海交通大学网络中心NTP服务器地址ntp.sjtu.edu.cn     北京时间ntp.baijinshan.cn
            InetAddress timeServerAddress = InetAddress.getByName("ntp.sjtu.edu.cn");
            TimeInfo timeInfo = timeClinent.getTime(timeServerAddress);
            TimeStamp timeStamp = timeInfo.getMessage().getTransmitTimeStamp();
            Date date = timeStamp.getDate();
            LocalDateTime localDateTime = date.toInstant().atOffset(ZoneOffset.ofHours(8)).toLocalDateTime();
//            logger.info("开始获取NTP服务时间"+localDateTime);
            System.out.println("NTP服务时间"+localDateTime);
            return localDateTime;
        } catch (UnknownHostException e) {
            throw new RuntimeException("获取服务器地址失败异常"+e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException("获取服务器地址失败异常"+e.getMessage());
        }
    }

    public static void updateLocaltime (String strDate, String strTime)  {
        String osName = System.getProperty("os.name" );
        try  {
            if  (osName.contains( "Windows" )) { // Window 系统
                // 格式 HH:mm:ss
                strTime = "  cmd /c time 22:35:00" ;
                Runtime.getRuntime().exec(strTime);
                // 格式：yyyy-MM-dd
                strDate = " cmd /c date 2009-03-26" ;
                Runtime.getRuntime().exec(strDate);
            } else  { // Linux 系统
                // 格式：yyyyMMdd
                strDate = "  date -s 20090326" ;
                Runtime.getRuntime().exec(strDate);
                // 格式 HH:mm:ss
                strTime = "  date -s 22:35:00" ;
                Runtime.getRuntime().exec(strTime);
            }
        } catch  (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("修改服务器时间失败异常"+e.getMessage());
        }
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
    }


    /**
     * windows修改时间
     */
//    public static void modifyTime(){
//        try {
//            Process p = Runtime.getRuntime().exec("cmd /c time 08:55:00");
//            // p.waitFor();
//            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
//            if (!br.ready()) {
//                Thread.sleep(100);
//            }
//            while (true) {
//                String s = br.readLine();
//                if (s == null)
//                    break;
//                System.out.println(s);
//            }
//            br.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }

    /**
     * windows修改日期
     */
//    public static void modifyDate(){
//        String date="2015-06-15";
//        try{
//            Runtime run=Runtime.getRuntime();
//            String command="cmd.exe /c date"+" "+(date);
//            run.exec(command);
//        }
//        catch(Exception e)
//        {
//            e.printStackTrace();
//        }
//    }



    public void runLinuxScript() throws IOException {
        //通过exec 来运行Linux shell脚本：在这个demo中 setDate.sh 是和 LinuxTimeSetter 在同一个文件夹中
        String[] command = new String[]{"sudo","./setDate.sh","2010-10-10","12:12:12"};
        Process proc = Runtime.getRuntime().exec(command);
        BufferedReader br = new BufferedReader(new InputStreamReader(proc.getInputStream()));
        String text = null;
        //输出操作结果
        while ((text = br.readLine()) != null) {
            System.out.println(text);
        }
    }


}


