package com.resico.plant.office;

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
     * 上传图文素材
     *
     * @param token
     * @return
     */
    String uploadNews(String token);


    /**
     * 群发图文消息
     * @param token
     * @param articles
     * @return
     */
    String sendArticle(String token, Articles articles);


}
