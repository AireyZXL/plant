package com.resico.plant;

import com.resico.plant.mysql.MysqlService;
import com.resico.plant.mysql.config.MysqlProperties;
import com.resico.plant.office.Articles;
import com.resico.plant.office.News;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.resico.plant.office.WxOfficeService;

import java.util.Collections;

@SpringBootTest
class PlantApplicationTests {

    @Autowired
    private MysqlProperties mysqlProperties;

    @Autowired
    private MysqlService mysqlService;

    @Autowired
    private WxOfficeService wxOfficeService;

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
        mysqlService.dbBackUpMysql(dbName,userName,password,dbUrl,path);

            mysqlService.backup(dbUrl,userName,password,path,"airey",dbName);


            //测试备份
            String command1 = "E:\\Program Files\\mysql-5.7.37-winx64\\bin\\mysqldump -h192.168.100.23 -udev -pResico@dev --set-charset=utf8  resico-invoice-dev2";//参数依次是IP、账号、密码、数据库名
            String savePath1 = "F:\\mysqldump\\dev2.sql";
            boolean b1 = mysqlService.backup(command1, savePath1);
            if (b1) {
                System.out.println("备份成功");
            } else {
                System.out.println("备份失败");
            }


            //测试还原
            String command2 = "E:\\Program Files\\mysql-5.7.37-winx64\\bin\\mysql -h192.168.100.23 -udev -pResico@dev  --default-character-set=utf8  resico-invoice-dev2";
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


    @Test
    public void  getToken(){

        System.out.println("11111");
        String token = wxOfficeService.getToken();

    }

    @Test
    public void sendMedia(){

        String token="56_D1_wCodpmkAx6gWb8POGK7fCqpMv3MvE5LZ9V-g6Lw-44nx-guk1FmWEHfJFjHUzPRKkH_DUvpkEmkZZbEMdDL5bzMF_2H82Yk7owA2WJGV8d_Xl3dWRE3dRgXzyAa4Te6QKysC9fd9F17YDQWBjAAAUAF";
        String media="src/main/resources/yinhua.png";
        String result = wxOfficeService.sendMedia(token, media);
        System.out.println("result="+result);

    }


    @Test
    public void uploadNews(){

        String token="56_D1_wCodpmkAx6gWb8POGK7fCqpMv3MvE5LZ9V-g6Lw-44nx-guk1FmWEHfJFjHUzPRKkH_DUvpkEmkZZbEMdDL5bzMF_2H82Yk7owA2WJGV8d_Xl3dWRE3dRgXzyAa4Te6QKysC9fd9F17YDQWBjAAAUAF";
        String result = wxOfficeService.uploadNews(token);
        System.out.println("result="+result);
    }

    @Test
    public void testAddTemporary(){

        String token="56_eGoZ86m59iFp3kVijYyxGdRlyxM9H-tl08FLvD0R6KIu2wj_LeEncwqQPgIP-S54UdbDKp26iWZ343lvAEruzB0Go2ByAM_jcjToGvF7bNE5uTfo38WJ5ypJAXeFzqYkGq3XTezhm1axCUnPGZUcAIAWPK";
        String media="src/main/resources/yinhua.png";
        String result=wxOfficeService.addTemporaryMaterial(token,"image",media);
        System.out.println("result="+result);

    }


    @Test
    public void testAddPermanentMaterial(){

        String token="56_eGoZ86m59iFp3kVijYyxGdRlyxM9H-tl08FLvD0R6KIu2wj_LeEncwqQPgIP-S54UdbDKp26iWZ343lvAEruzB0Go2ByAM_jcjToGvF7bNE5uTfo38WJ5ypJAXeFzqYkGq3XTezhm1axCUnPGZUcAIAWPK";
        String media="src/main/resources/mishang.jpg";
        String result = wxOfficeService.addPermanentMaterial(token, "image",media);
        System.out.println("result="+result);

    }

    @Test
    public void  testDraft(){

        String token="56_eGoZ86m59iFp3kVijYyxGdRlyxM9H-tl08FLvD0R6KIu2wj_LeEncwqQPgIP-S54UdbDKp26iWZ343lvAEruzB0Go2ByAM_jcjToGvF7bNE5uTfo38WJ5ypJAXeFzqYkGq3XTezhm1axCUnPGZUcAIAWPK";

        Articles articles=new Articles();

        News news=new News();
        news.setTitle("觅上夏日新活动来啦!");
        news.setThumb_media_id("mmuCDB4EAA3F21cyzsSc09qQDbb62Ia6Qk7RepHLpnkmkQRiCGw8BolMTnSj2DhN");
        news.setAuthor("airey");
        news.setShow_cover_pic(1);//显示封面
        news.setContent("觅上致力于打造一个无限放大的首饰库，为新奢消费和潮流女性打造最个性的独立风格，呈现中国女性的高端多元之美\n" +
                "理念\n" +
                "摆脱购物束缚，打造随心选款，安心佩戴的全新服务式体验。\n" +
                "使命\n" +
                "让用户随时奢享高品质珠宝带来的欢愉，满足随心佩戴梦想。\n" +
                "愿景\n" +
                "让世界每一位女性，都拥有属于自己的独特风采。啦啦啦大幅度");
        news.setContent_source_url("https://www.baidu.com/");  //图文消息的原文地址，即点击“阅读原文”后的URL
        news.setNeed_open_comment(1);   //Uint32  是否打开评论，0不打开，1打开
        news.setOnly_fans_can_comment(1);    //Uint32 是否粉丝才可评论，0所有人可评论，1粉丝才可评论

        articles.setArticles(Collections.singletonList(news));


       // mmuCDB4EAA3F21cyzsSc09qQDbb62Ia6Qk7RepHLpnkmkQRiCGw8BolMTnSj2DhN

        String result = wxOfficeService.addDraft(articles, token);
        System.out.println("result="+result);

    }

    @Test
    public void testSubmit(){

        String token="56_eGoZ86m59iFp3kVijYyxGdRlyxM9H-tl08FLvD0R6KIu2wj_LeEncwqQPgIP-S54UdbDKp26iWZ343lvAEruzB0Go2ByAM_jcjToGvF7bNE5uTfo38WJ5ypJAXeFzqYkGq3XTezhm1axCUnPGZUcAIAWPK";
        String result = wxOfficeService.submit(token, "mmuCDB4EAA3F21cyzsSc08UOG6UX1DZKpspMyGOKvehO-XFi8D51EVa-lV06ovgx");
        System.out.println("result="+result);

    }


    @Test
    public void testPublishStatus(){

        String token="56_eGoZ86m59iFp3kVijYyxGdRlyxM9H-tl08FLvD0R6KIu2wj_LeEncwqQPgIP-S54UdbDKp26iWZ343lvAEruzB0Go2ByAM_jcjToGvF7bNE5uTfo38WJ5ypJAXeFzqYkGq3XTezhm1axCUnPGZUcAIAWPK";
        String result = wxOfficeService.freePublish(token, "2247488189");
        System.out.println("result="+result);

    }

    @Test
    public void testSendToAll(){
        String token="56_eGoZ86m59iFp3kVijYyxGdRlyxM9H-tl08FLvD0R6KIu2wj_LeEncwqQPgIP-S54UdbDKp26iWZ343lvAEruzB0Go2ByAM_jcjToGvF7bNE5uTfo38WJ5ypJAXeFzqYkGq3XTezhm1axCUnPGZUcAIAWPK";
        String result= wxOfficeService.sendArticle(token, null);
        System.out.println("result="+result);

    }


}
