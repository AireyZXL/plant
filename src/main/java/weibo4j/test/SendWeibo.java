package weibo4j.test;

import weibo4j.Timeline;
import weibo4j.model.WeiboException;

/**
 * @author Airey
 * @since 2022/4/20 13:47
 */
public class SendWeibo {

    public static void main(String[] args) {
        String accessToken="2.00ObNAdDdk5_GB948a321d61_CKAbC";
        String message="这是一条手机空气Air发送的微博用于测试，请忽略！";

        Timeline timeline=new Timeline(accessToken);
        try {
            timeline.updateStatus(message);
        } catch (WeiboException e) {
            e.printStackTrace();
        }
        System.out.println("微博发送执行成功!");

    }

}
