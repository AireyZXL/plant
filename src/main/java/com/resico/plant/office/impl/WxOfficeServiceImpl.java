package com.resico.plant.office.impl;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.resico.plant.office.*;
import com.resico.plant.office.model.Articles;
import com.resico.plant.office.model.News;
import com.resico.plant.office.model.WxMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.*;

/**
 * @author Airey
 * @since 2022/4/22 11:23
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class WxOfficeServiceImpl implements WxOfficeService {


    private final WxOfficeConfig wxOfficeConfig;


    private final RestTemplate restTemplate;

    private static final String TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token";

    private static final String UPLOAD_IMAGE_URL = "https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=ACCESS_TOKEN";

    private static final String UPLOAD_NEWS_URL = "https://api.weixin.qq.com/cgi-bin/media/uploadnews?access_token=ACCESS_TOKEN";

    private static final String UPLOAD_TEMP_URL = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";


    private static final String UPLOAD_PERMANENT_URL = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=ACCESS_TOKEN&type=TYPE";

    private static final String UPLOAD_DRAFT_URL = "https://api.weixin.qq.com/cgi-bin/draft/add?access_token=ACCESS_TOKEN";


    private static final String SUBMIT_URL = "https://api.weixin.qq.com/cgi-bin/freepublish/submit?access_token=ACCESS_TOKEN";


    private static final String PUBLISH_URL = "https://api.weixin.qq.com/cgi-bin/freepublish/get?access_token=ACCESS_TOKEN";


    private static final String SEND_ALL_URL = "https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=ACCESS_TOKEN";


    private static final String DRAFT_LIST_URL = "https://api.weixin.qq.com/cgi-bin/draft/batchget?access_token=ACCESS_TOKEN";


    /**
     * 获取token
     *
     * @return
     */
    @Override
    public String getToken() {

        String appId = wxOfficeConfig.getAppId();
        String secret = wxOfficeConfig.getSecret();

        Map<String, Object> map = new HashMap<>();//存放参数
        map.put("grant_type", "client_credential");
        map.put("appid", appId);
        map.put("secret", secret);

        String body = HttpUtil.createGet(TOKEN_URL).form(map).execute().body();
        log.info("body={}", body);
        JSONObject jsonObject = JSONObject.parseObject(body);
        if (jsonObject.containsKey("access_token")) {
            return jsonObject.getString("access_token");
        }
        return null;
    }

    /**
     * 发送图片
     *
     * @param accessToken
     * @param filePath
     * @return
     */
    @Override
    public String sendMedia(String accessToken, String filePath) {

        if (accessToken != null) {
            String url = UPLOAD_IMAGE_URL.replace("ACCESS_TOKEN", accessToken);
            log.info("UPLOAD_IMG_URL:{}", url);

            //设置请求体，注意是LinkedMultiValueMap
            MultiValueMap<String, Object> data = new LinkedMultiValueMap<>();

            //设置上传文件
            FileSystemResource fileSystemResource = new FileSystemResource(filePath);
            data.add("media", fileSystemResource);

            //上传文件,设置请求头
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);
            httpHeaders.setContentLength(fileSystemResource.getFile().length());

            HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<MultiValueMap<String, Object>>(data,
                    httpHeaders);
            try {
                //这里RestTemplate请求返回的字符串直接转换成JSONObject会报异常,后续深入找一下原因
//                ResponseEntity<JSONObject> resultEntity = restTemplate.exchange(url,
//                        HttpMethod.POST, requestEntity, JSONObject.class);
                String resultJSON = restTemplate.postForObject(url, requestEntity, String.class);
                log.info("上传返回的信息是：{}", resultJSON);
                return resultJSON;
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
        return null;
    }

    /**
     * 新增临时素材
     *
     * @param accessToken
     * @param type
     * @param filePath
     * @return
     */
    @Override
    public String addTemporaryMaterial(String accessToken, String type, String filePath) {
        if (accessToken != null) {
            String url = UPLOAD_TEMP_URL.replace("ACCESS_TOKEN", accessToken).replace("TYPE", type);
            log.info("UPLOAD_IMG_URL:{}", url);

            //设置请求体，注意是LinkedMultiValueMap
            MultiValueMap<String, Object> data = new LinkedMultiValueMap<>();

            //设置上传文件
            FileSystemResource fileSystemResource = new FileSystemResource(filePath);
            data.add("media", fileSystemResource);

            //上传文件,设置请求头
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);
            httpHeaders.setContentLength(fileSystemResource.getFile().length());

            HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<MultiValueMap<String, Object>>(data,
                    httpHeaders);
            try {
                //这里RestTemplate请求返回的字符串直接转换成JSONObject会报异常,后续深入找一下原因
//                ResponseEntity<JSONObject> resultEntity = restTemplate.exchange(url,
//                        HttpMethod.POST, requestEntity, JSONObject.class);
                String resultJSON = restTemplate.postForObject(url, requestEntity, String.class);
                log.info("上传返回的信息是：{}", resultJSON);
                return resultJSON;
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
        return null;

    }

    /**
     * 新增永久素材
     *
     * @param token
     * @param type
     * @param media
     * @return
     */
    @Override
    public String addPermanentMaterial(String token, String type, String media) {
        if (token != null) {
            String url = UPLOAD_PERMANENT_URL.replace("ACCESS_TOKEN", token).replace("TYPE", type);
            log.info("UPLOAD_IMG_URL:{}", url);

            //设置请求体，注意是LinkedMultiValueMap
            MultiValueMap<String, Object> data = new LinkedMultiValueMap<>();

            //设置上传文件
            FileSystemResource fileSystemResource = new FileSystemResource(media);
            data.add("media", fileSystemResource);

            //上传文件,设置请求头
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);
            httpHeaders.setContentLength(fileSystemResource.getFile().length());

            HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<MultiValueMap<String, Object>>(data,
                    httpHeaders);
            try {
                //这里RestTemplate请求返回的字符串直接转换成JSONObject会报异常,后续深入找一下原因
//                ResponseEntity<JSONObject> resultEntity = restTemplate.exchange(url,
//                        HttpMethod.POST, requestEntity, JSONObject.class);
                String resultJSON = restTemplate.postForObject(url, requestEntity, String.class);
                log.info("永久素材 = 上传返回的信息是：{}", resultJSON);
                return resultJSON;
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
        return null;

    }


    private Articles createArticles() {

        Articles articles = new Articles();

        List<News> dataList = new ArrayList<>();
        News news1 = new News();
        news1.setTitle("标题1");
        news1.setThumb_media_id("mmuCDB4EAA3F21cyzsSc017xuaWjwR4_JxSi0UgTyF2N0TZF3hCwx7Q5SfxLKHWA");
        news1.setAuthor("作者Air");
        news1.setDigest("图文消息的摘要，仅有单图文消息才有摘要，多图文此处为空。如果本字段为没有填写，则默认抓取正文前64个字。");
        news1.setShow_cover_pic(1);//显示封面
        news1.setContent("图文消息的具体内容，支持HTML标签，必须少于2万字符，小于1M，且此处会去除JS,涉及图片url必须来源 \"上传图文消息内的图片获取URL\"接口获取。外部图片url将被过滤。");
        news1.setContent_source_url("https://www.baidu.com/");  //图文消息的原文地址，即点击“阅读原文”后的URL
        news1.setNeed_open_comment(1);   //Uint32  是否打开评论，0不打开，1打开
        news1.setOnly_fans_can_comment(1);    //Uint32 是否粉丝才可评论，0所有人可评论，1粉丝才可评论


        News news2 = new News();
        news2.setTitle("标题2");
        news2.setThumb_media_id("mmuCDB4EAA3F21cyzsSc017xuaWjwR4_JxSi0UgTyF2N0TZF3hCwx7Q5SfxLKHWA");
        news2.setAuthor("作者Air");
        news2.setDigest("图文消息的摘要，仅有单图文消息才有摘要，多图文此处为空。如果本字段为没有填写，则默认抓取正文前64个字。");
        news2.setShow_cover_pic(1);//显示封面
        news2.setContent("图文消息的具体内容，支持HTML标签，必须少于2万字符，小于1M，且此处会去除JS,涉及图片url必须来源 \"上传图文消息内的图片获取URL\"接口获取。外部图片url将被过滤。");
        news2.setContent_source_url("https://www.baidu.com/");  //图文消息的原文地址，即点击“阅读原文”后的URL
        news2.setNeed_open_comment(1);   //Uint32  是否打开评论，0不打开，1打开
        news2.setOnly_fans_can_comment(1);    //Uint32 是否粉丝才可评论，0所有人可评论，1粉丝才可评论
        dataList.add(news1);
        dataList.add(news2);

        articles.setArticles(dataList);
        return articles;

    }


    /**
     * 上传图文消息素材
     */
    public String uploadNews(String accessToken) {

        Articles articles = this.createArticles();

        if (accessToken != null) {
            log.info("URL{}", UPLOAD_NEWS_URL);
            String url = UPLOAD_NEWS_URL.replace("ACCESS_TOKEN", accessToken);
            log.info("UPLOAD_NEWS_URL:{}", url);

            //将菜单对象转换成JSON字符串
            String jsonNews = JSONObject.toJSONString(articles);
            log.info("JSONNEWS:{}", jsonNews);

            //发起POST请求创建菜单
            String jsonObject = restTemplate.postForObject(url, jsonNews, String.class);

            return jsonObject;
        }
        return null;
    }

    /**
     * 发布草稿
     *
     * @param articles
     * @return
     */
    @Override
    public String addDraft(Articles articles, String accessToken) {

        if (accessToken != null) {
            log.info("URL{}", UPLOAD_DRAFT_URL);
            String url = UPLOAD_DRAFT_URL.replace("ACCESS_TOKEN", accessToken);
            log.info("UPLOAD_NEWS_URL:{}", url);

            //将菜单对象转换成JSON字符串
            String jsonNews = JSONObject.toJSONString(articles);

            log.info("JSONNEWS:{}", jsonNews);


            //上传文件,设置请求头
            LinkedMultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
            headers.put("Content-Type", Collections.singletonList("application/json;charset=UTF-8"));

            HttpEntity<String> requestEntity = new HttpEntity<>(jsonNews,
                    headers);

            //发起POST请求创建菜单
            String jsonObject = restTemplate.postForObject(url, requestEntity, String.class);

            return jsonObject;
        }
        return null;
    }

    /**
     * 获取草稿列表
     *
     * @param accessToken
     * @return
     */
    @Override
    public String draftList(String accessToken, Integer offset, Integer count) {

        if (accessToken != null) {
            log.info("URL{}", DRAFT_LIST_URL);
            String url = DRAFT_LIST_URL.replace("ACCESS_TOKEN", accessToken);
            log.info("DRAFT_LIST_URL:{}", url);

            //将菜单对象转换成JSON字符串

            JSONObject jsbi = new JSONObject();
            jsbi.put("offset", offset);
            jsbi.put("count", count);

            String jsonNews = jsbi.toJSONString();
            log.info("JSONNEWS:{}", jsonNews);

            //发起POST请求创建菜单
            String jsonObject = restTemplate.postForObject(url, jsonNews, String.class);

            return jsonObject;
        }
        return null;

    }

    /**
     * 发布信息
     *
     * @param token
     * @param draftId
     * @return
     */
    @Override
    public String submit(String token, String draftId) {

        if (token != null) {
            log.info("URL:{}", SUBMIT_URL);
            String url = SUBMIT_URL.replace("ACCESS_TOKEN", token);
            log.info("submitUrl:{}", url);

            //将菜单对象转换成JSON字符串
            JSONObject js = new JSONObject();
            js.put("media_id", draftId);
            String jsonNews = js.toJSONString();
            log.info("JSONNEWS:{}", jsonNews);

            //发起POST请求创建菜单
            String jsonObject = restTemplate.postForObject(url, jsonNews, String.class);

            return jsonObject;
        }


        return null;
    }

    /**
     * 查询发布状态
     * 2247488186
     *
     * @param token
     * @param publishId
     * @return
     */
    @Override
    public String freePublish(String token, String publishId) {


        if (token != null) {
            log.info("URL:{}", PUBLISH_URL);
            String url = PUBLISH_URL.replace("ACCESS_TOKEN", token);
            log.info("submitUrl:{}", url);

            //将菜单对象转换成JSON字符串
            JSONObject js = new JSONObject();
            js.put("publish_id", publishId);
            String jsonNews = js.toJSONString();
            log.info("JSONNEWS:{}", jsonNews);

            //发起POST请求创建菜单
            String jsonObject = restTemplate.postForObject(url, jsonNews, String.class);

            return jsonObject;
        }

        return null;
    }

    /**
     * 群发图文消息
     *
     * @param token
     * @param articles
     * @return
     */
    @Override
    public String sendArticle(String token, Articles articles) {

        WxMessage wxMessage = new WxMessage();
        WxMessage.Fliter fliter = new WxMessage.Fliter();
        fliter.setIs_to_all(true);
        wxMessage.setFilter(fliter);
        WxMessage.Mpnews mpnews = new WxMessage.Mpnews();
        mpnews.setMedia_id("mmuCDB4EAA3F21cyzsSc0wlZfwzUihjEuSlFzDBlaeLfHCYeZh_kyeysGR5KqDtx");
        wxMessage.setMpnews(mpnews);

        wxMessage.setMsgtype("mpnews");
        wxMessage.setSend_ignore_reprint(0);

        if (token != null) {
            log.info("URL:{}", SEND_ALL_URL);
            String url = SEND_ALL_URL.replace("ACCESS_TOKEN", token);
            log.info("submitUrl:{}", url);

            //将菜单对象转换成JSON字符串

            String jsonNews = JSONObject.toJSONString(wxMessage);
            log.info("JSONNEWS:{}", jsonNews);

            //发起POST请求创建菜单
            String jsonObject = restTemplate.postForObject(url, jsonNews, String.class);

            return jsonObject;
        }
        return null;
    }

}
