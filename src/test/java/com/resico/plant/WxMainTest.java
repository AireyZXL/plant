package com.resico.plant;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONObject;
import com.resico.plant.office.WechatOfficeAccountService;
import com.resico.plant.office.WxOfficeConfig;
import com.resico.plant.office.model.Articles;
import com.resico.plant.office.model.News;
import com.resico.plant.office.model.WxToken;
import com.resico.plant.office.response.WxOfficeDraftDetailResponse;
import com.resico.plant.office.response.WxOfficeDraftResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
public class WxMainTest {

    @Autowired
    private WechatOfficeAccountService wechatOfficeAccountService;

    @Autowired
    private WxOfficeConfig wxOfficeConfig;

    /**
     * 测试获取微信公众号token  可以反复run
     */
    @Test
    public void testToken() {
        WxToken token = wechatOfficeAccountService.getToken();
        log.info("token={}", token);
    }

    /**
     * 测试发布草稿文章，直接返回文章详情   可以反复run
     */
    @Test
    public void testSendDraft() {

        WxToken wxToken = wechatOfficeAccountService.getToken();
        String token = wxToken.getAccessToken();
        if (StringUtils.isBlank(token)) {
            throw new RuntimeException("token获取失败");
        }
        Articles articles = new Articles();
        News news = new News();
        news.setTitle("测试发布文章樱花苹果");
        news.setThumb_media_id("nkXr99xVPx-KG1ZGAl9XxYhss2YUyaQ57nJgXQajtsNYdGaqNJ7v0LTIMgb_q7iE");
        news.setAuthor("jinxing");
        news.setContent("<p>发布内容啊啊啊" + "<hr>" + "<img src=\"http://mmbiz.qpic.cn/mmbiz_png/8gmg5Y1u4FrRvxU2Ftwj8P8QIfV5AAsRr8e2IH2XXgmjBHEHhdO0KiaJJuQEeusEpcyyrMY07iaUPGIfyTZWxuXw/0\"> \n");
        news.setContent_source_url("https://www.baidu.com/");
        news.setNeed_open_comment(0);
        news.setOnly_fans_can_comment(0);
        List<News> list = new ArrayList<>();
        list.add(news);
        articles.setArticles(list);
        WxOfficeDraftResponse wxOfficeDraftResponse = wechatOfficeAccountService.addDraft(token, articles);
        if (ObjectUtil.isNull(wxOfficeDraftResponse)) {
            throw new RuntimeException("发送草稿失败");
        }
        log.info("wxOfficeDraftResponse={}", JSONObject.toJSONString(wxOfficeDraftResponse));
        String media_id = wxOfficeDraftResponse.getMedia_id();
        WxOfficeDraftDetailResponse draft = wechatOfficeAccountService.getDraft(token, media_id);
        log.info("草稿文章信息={}", JSONObject.toJSONString(draft));

    }


}
