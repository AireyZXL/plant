package com.resico.plant.office;

import com.resico.plant.office.model.*;
import com.resico.plant.office.response.*;

/**
 * @author Airey
 * @since 2022/4/22 11:17
 */
public interface WechatOfficeAccountService {


    /**
     * 获取token 需要2小时刷新一次
     *
     * @return
     */
    WxToken getToken();

    /**
     * 上传图片
     *
     * @param accessToken
     * @param filePath
     * @return
     */
    WxOfficeUploadImgResponse uploadImage(String accessToken, String filePath);


    /**
     * 新增永久素材
     *
     * @param accessToken
     * @param type        媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb）
     * @param media
     * @return
     */
    WxOfficePermanentMaterialResponse addPermanentMaterial(String accessToken, String type, String media);


    /**
     * 上传图文素材
     *
     * @param accessToken
     * @param articles
     * @return
     */
    WxOfficeUploadNewsResponse uploadNews(String accessToken, Articles articles);


    /**
     * 添加草稿
     *
     * @param articles
     * @param accessToken
     * @return
     */
    WxOfficeDraftResponse addDraft(String accessToken, Articles articles);


    /**
     * 获取草稿
     *
     * @param accessToken
     * @param media_id
     * @return
     */
    WxOfficeDraftDetailResponse getDraft(String accessToken, String media_id);


    /**
     * 群发图文消息
     *
     * @param accessToken
     * @param wxMessage
     * @return
     */
    WxOfficeSendToAllResponse sendArticle(String accessToken, WxMessage wxMessage);


    /**
     * 查询群发消息发送状态【订阅号与服务号认证后均可用】
     *
     * @param accessToken
     * @param msg_id
     * @return
     */
    WxOfficeSendStatusResponse getSendStatus(String accessToken, String msg_id);


    /**
     * 删除群发消息
     *
     * @param accessToken
     * @param wxOfficeDeleteMsg
     * @return
     */
    boolean deleteMessage(String accessToken, WxOfficeDeleteMsg wxOfficeDeleteMsg);


}
