package com.resico.plant;

import com.alibaba.fastjson.JSONObject;
import com.resico.plant.office.WechatOfficeAccountService;
import com.resico.plant.office.WxOfficeConfig;
import com.resico.plant.office.model.*;
import com.resico.plant.office.response.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
public class WxOfficeTest {

    @Autowired
    private WechatOfficeAccountService wechatOfficeAccountService;

    @Autowired
    private WxOfficeConfig wxOfficeConfig;

    /**
     * 测试获取微信公众号token
     */
    @Test
    public void testToken() {
        WxToken token = wechatOfficeAccountService.getToken();
        log.info("token={}", token);
    }

    /**
     * 测试上传图文消息内的图片获取URL
     * 其中url就是上传图片的URL，可用于后续群发中，放置到图文消息中。
     * 错误时微信会返回错误码等信息，请根据错误码查询错误信息
     * <p>
     * <p>
     * 上传图文消息素材【订阅号与服务号认证后均可用】
     */
    @Test
    public void testUploadImage() {

        String token = wxOfficeConfig.getToken();
        String filePath = "src/main/resources/mishang.jpg";
        WxOfficeUploadImgResponse wxOfficeUploadImgResponse = wechatOfficeAccountService.uploadImage(token, filePath);
        log.info("wxOfficeUploadImgResponse={}", JSONObject.toJSONString(wxOfficeUploadImgResponse));

    }

    /**
     * 上传永久素材
     */
    @Test
    public void testAddPermanentMaterial() {

        String token = wxOfficeConfig.getToken();
        String filePath = "src/main/resources/yinhua.png";
        WxOfficePermanentMaterialResponse permanentMaterialResponse = wechatOfficeAccountService.addPermanentMaterial(token, "img", filePath);
        log.info("permanentMaterialResponse={}", JSONObject.toJSONString(permanentMaterialResponse));

        //nkXr99xVPx-KG1ZGAl9XxYhss2YUyaQ57nJgXQajtsNYdGaqNJ7v0LTIMgb_q7iE
    }

    /**
     * 开发者可新增常用的素材到草稿箱中进行使用。上传到草稿箱中的素材被群发或发布后，该素材将从草稿箱中移除。新增草稿可在公众平台官网-草稿箱中查看和管理。
     */
    @Test
    public void testUploadNews() {

        String token = wxOfficeConfig.getToken();
        Articles articles = new Articles();
        News news = new News();
        news.setTitle("测试发布文章1111");
        news.setThumb_media_id("nkXr99xVPx-KG1ZGAl9XxYhss2YUyaQ57nJgXQajtsNYdGaqNJ7v0LTIMgb_q7iE");
        news.setAuthor("Airey");
        news.setContent("<p>发布内容啊啊啊" +
                "<hr>" +
                "<img src=\"http://mmbiz.qpic.cn/mmbiz_png/8gmg5Y1u4FrRvxU2Ftwj8P8QIfV5AAsRr8e2IH2XXgmjBHEHhdO0KiaJJuQEeusEpcyyrMY07iaUPGIfyTZWxuXw/0\"> \n");
        news.setContent_source_url("https://www.baidu.com/");
        news.setNeed_open_comment(0);
        news.setOnly_fans_can_comment(0);

        List<News> list = new ArrayList<>();
        list.add(news);
        articles.setArticles(list);
        WxOfficeDraftResponse wxOfficeDraftResponse = wechatOfficeAccountService.addDraft(token, articles);
        log.info("wxOfficeDraftResponse={}", JSONObject.toJSONString(wxOfficeDraftResponse));
//nkXr99xVPx-KG1ZGAl9XxXqW-KC19J4FJfBcX3MbcadbM9lKpdUta31P5zR6ZdME
    }

    /**
     * 测试查看草稿详情
     */
    @Test
    public void testDraftDetail() {

        String token = wxOfficeConfig.getToken();
        String media_id = "nkXr99xVPx-KG1ZGAl9XxXqW-KC19J4FJfBcX3MbcadbM9lKpdUta31P5zR6ZdME";
        WxOfficeDraftDetailResponse draft = wechatOfficeAccountService.getDraft(token, media_id);
        log.info("draft={}", JSONObject.toJSONString(draft));
    }


    /**
     * 测试群发消息
     */
    @Test
    public void testSendArticle() {
        String token = wxOfficeConfig.getToken();
        WxMessage wxMessage = new WxMessage();
        WxMessage.Fliter fliter = new WxMessage.Fliter();
        fliter.setIs_to_all(true);
        wxMessage.setFilter(fliter);
        WxMessage.Mpnews mpnews = new WxMessage.Mpnews();
        mpnews.setMedia_id("nkXr99xVPx-KG1ZGAl9XxXqW-KC19J4FJfBcX3MbcadbM9lKpdUta31P5zR6ZdME");
        wxMessage.setMpnews(mpnews);
        wxMessage.setMsgtype("mpnews");
        wxMessage.setSend_ignore_reprint(1);
        WxOfficeSendToAllResponse wxOfficeSendToAllResponse = wechatOfficeAccountService.sendArticle(token, wxMessage);
        log.info("wxOfficeSendToAllResponse={}", JSONObject.toJSONString(wxOfficeSendToAllResponse));
    }


    /**
     * 测试查询群发消息发送状态
     */
    @Test
    public void testSendStatus() {
        String token = wxOfficeConfig.getToken();
        String msg_id = "201053012";
        WxOfficeSendStatusResponse sendStatus = wechatOfficeAccountService.getSendStatus(token, msg_id);
        log.info("sendStatus={}", JSONObject.toJSONString(sendStatus));
    }

}
