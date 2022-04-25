package com.resico.plant.office;

import io.swagger.models.auth.In;

import java.util.List;

/**
 * @author Airey
 * @since 2022/4/22 11:17
 */
public interface WxOfficeService {


    /**
     * 获取token 需要2小时刷新一次
     *
     * @return
     */
    String getToken();

    /**
     * 发送图片
     *
     * @param token
     * @param media
     * @return
     */
    String sendMedia(String token, String media);

    /**
     * 新增临时素材
     *
     * @param token
     * @param type
     * @param media
     * @return
     */
    String addTemporaryMaterial(String token, String type, String media);


    /**
     * 新增永久素材
     * @param token
     * @param type
     * @param media
     * @return
     */
    String addPermanentMaterial(String token,String type,String media);


    /**
     * 上传图文素材
     *
     * @param token
     * @return
     */
    String uploadNews(String token);


    /**
     * 发布草稿
     *
     * mmuCDB4EAA3F21cyzsSc001C9gTfnvJz1Se2zePmZqCd8H8TsGmMjQq4KwiIV_PO
     * @param news
     * @return
     */
    String addDraft(Articles articles, String accessToken);


    /**
     * 获取草稿列表
     * @param accessToken
     * @return
     */
    String draftList(String accessToken, Integer offset,Integer count);


    /**
     * 发布信息
     * @param token
     * @param draftId
     * @return
     */
    String submit(String token,String draftId);


    /**
     * 查询发布状态
     * 2247488186
     * @param token
     * @param publishId
     * @return
     */
    String freePublish(String token,String publishId);


    /**
     * 群发图文消息
     * @param token
     * @param articles
     * @return
     */
    String sendArticle(String token, Articles articles);






}
