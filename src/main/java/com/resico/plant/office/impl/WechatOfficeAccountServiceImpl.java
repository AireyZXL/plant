package com.resico.plant.office.impl;


import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONValidator;
import com.resico.plant.office.*;
import com.resico.plant.office.model.Articles;
import com.resico.plant.office.model.WxMessage;
import com.resico.plant.office.model.WxToken;
import com.resico.plant.office.response.*;
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

import java.util.Collections;

@Service
@Slf4j
@RequiredArgsConstructor
public class WechatOfficeAccountServiceImpl implements WechatOfficeAccountService {


    private final WxOfficeConfig wxOfficeConfig;

    private final RestTemplate restTemplate;


    /**
     * 获取token 需要2小时刷新一次
     *
     * @return
     */
    @Override
    public WxToken getToken() {
        String appId = wxOfficeConfig.getAppId();
        String secret = wxOfficeConfig.getSecret();
        String url = WechatOfficeURLContants.TOKEN_URL.replace("APPID", appId).replace("APPSECRET", secret);
        log.info("微信公众号获取token请求参数:appId={},secret={}", appId, secret);
        String response = restTemplate.getForObject(url, String.class);
        log.info("微信公众号获取token返回参数={}", response);
        boolean validate = JSONValidator.from(response).validate();
        if (validate) {
            WxToken wxToken = JSONObject.parseObject(response, WxToken.class);
            return wxToken;
        }
        return null;
    }

    /**
     * 上传图片
     *
     * @param accessToken
     * @param filePath
     * @return
     */
    @Override
    public WxOfficeUploadImgResponse uploadImage(String accessToken, String filePath) {
        if (ObjectUtil.isNull(accessToken)) {
            throw new RuntimeException("微信公众号请求accessToken不能为空");
        }
        String url = WechatOfficeURLContants.UPLOAD_IMAGE_URL.replace("ACCESS_TOKEN", accessToken);
        log.info("微信公众号上传图片url:{}", url);

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

        String response = restTemplate.postForObject(url, requestEntity, String.class);
        log.info("微信公众号上传图片返回信息是：{}", response);
        boolean validate = JSONValidator.from(response).validate();
        if (validate) {
            WxOfficeUploadImgResponse wxOfficeUploadImgResponse = JSONObject.parseObject(response, WxOfficeUploadImgResponse.class);
            return wxOfficeUploadImgResponse;
        }
        return null;

    }


    /**
     * 新增永久素材
     *
     * @param accessToken
     * @param type        媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb）
     * @param media
     * @return
     */
    @Override
    public WxOfficePermanentMaterialResponse addPermanentMaterial(String accessToken, String type, String media) {

        if (ObjectUtil.isNull(accessToken)) {
            throw new RuntimeException("微信公众号请求accessToken不能为空");
        }
        String url = WechatOfficeURLContants.UPLOAD_PERMANENT_URL.replace("ACCESS_TOKEN", accessToken).replace("TYPE", type);
        log.info("微信公众号新增永久素材请求url:{}", url);

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
        String response = restTemplate.postForObject(url, requestEntity, String.class);
        log.info("微信公众号新增永久素材请求永久素材上传返回的信息是：{}", response);
        boolean validate = JSONValidator.from(response).validate();
        if (validate) {
            WxOfficePermanentMaterialResponse wxOfficePermanentMaterialResponse = JSONObject.parseObject(response, WxOfficePermanentMaterialResponse.class);
            return wxOfficePermanentMaterialResponse;
        }
        return null;
    }

    /**
     * 上传图文素材
     *
     * @param accessToken
     * @param articles
     * @return
     */
    @Override
    public WxOfficeUploadNewsResponse uploadNews(String accessToken, Articles articles) {

        if (ObjectUtil.isNull(accessToken)) {
            throw new RuntimeException("微信公众号请求accessToken不能为空");
        }
        String url = WechatOfficeURLContants.UPLOAD_NEWS_URL.replace("ACCESS_TOKEN", accessToken);
        log.info("微信公众号上传图文素材url:{}", url);
        String request = JSONObject.toJSONString(articles);
        log.info("微信公众号上传图文素材请求参数:{}", request);
        LinkedMultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.put("Content-Type", Collections.singletonList("application/json;charset=UTF-8"));
        HttpEntity<String> requestEntity = new HttpEntity<>(request, headers);
        String response = restTemplate.postForObject(url, requestEntity, String.class);
        log.info("微信公众号上传图文素材返回信息:{}", response);
        boolean validate = JSONValidator.from(response).validate();
        if (validate) {
            WxOfficeUploadNewsResponse wxOfficeUploadNewsResponse = JSONObject.parseObject(response, WxOfficeUploadNewsResponse.class);
            return wxOfficeUploadNewsResponse;
        }
        return null;

    }

    /**
     * 添加草稿
     * <p>
     *
     * @param articles
     * @param accessToken
     * @return
     */
    @Override
    public WxOfficeDraftResponse addDraft(String accessToken, Articles articles) {
        if (ObjectUtil.isNull(accessToken)) {
            throw new RuntimeException("微信公众号请求accessToken不能为空");
        }
        String url = WechatOfficeURLContants.UPLOAD_DRAFT_URL.replace("ACCESS_TOKEN", accessToken);
        log.info("微信公众号添加草稿url:{}", url);

        //将菜单对象转换成JSON字符串
        String request = JSONObject.toJSONString(articles);
        log.info("微信公众号添加草稿请求参数:{}", request);
        //上传文件,设置请求头
        LinkedMultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.put("Content-Type", Collections.singletonList("application/json;charset=UTF-8"));
        HttpEntity<String> requestEntity = new HttpEntity<>(request, headers);
        String response = restTemplate.postForObject(url, requestEntity, String.class);
        log.info("微信公众号添加草稿返回信息:{}", response);
        boolean validate = JSONValidator.from(response).validate();
        if (validate) {
            WxOfficeDraftResponse wxOfficeDraftResponse = JSONObject.parseObject(response, WxOfficeDraftResponse.class);
            return wxOfficeDraftResponse;
        }
        return null;
    }


    /**
     * 群发图文消息
     *
     * @param accessToken
     * @param wxMessage
     * @return
     */
    @Override
    public WxOfficeSendToAllResponse sendArticle(String accessToken, WxMessage wxMessage) {
        if (ObjectUtil.isNull(accessToken)) {
            throw new RuntimeException("微信公众号请求accessToken不能为空");
        }
        String url = WechatOfficeURLContants.SEND_ALL_URL.replace("ACCESS_TOKEN", accessToken);
        log.info("微信公众号群发消息url:{}", url);

        String request = JSONObject.toJSONString(wxMessage);
        log.info("微信公众号群发消息请求参数:{}", request);

        //发起POST请求创建菜单
        String response = restTemplate.postForObject(url, request, String.class);
        log.info("微信公众号群发消息结果:{}",response);
        boolean validate = JSONValidator.from(response).validate();
        if (validate) {
            WxOfficeSendToAllResponse wxOfficeSendToAllResponse = JSONObject.parseObject(response, WxOfficeSendToAllResponse.class);
            return wxOfficeSendToAllResponse;
        }
        return null;
    }
}
