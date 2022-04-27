package com.resico.plant.office;

public interface WechatOfficeURLContants {


    String TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    String UPLOAD_IMAGE_URL = "https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=ACCESS_TOKEN";

    String UPLOAD_NEWS_URL = "https://api.weixin.qq.com/cgi-bin/media/uploadnews?access_token=ACCESS_TOKEN";

    String UPLOAD_TEMP_URL = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";

    String UPLOAD_PERMANENT_URL = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=ACCESS_TOKEN&type=TYPE";

    String UPLOAD_DRAFT_URL = "https://api.weixin.qq.com/cgi-bin/draft/add?access_token=ACCESS_TOKEN";

    String SUBMIT_URL = "https://api.weixin.qq.com/cgi-bin/freepublish/submit?access_token=ACCESS_TOKEN";

    String PUBLISH_URL = "https://api.weixin.qq.com/cgi-bin/freepublish/get?access_token=ACCESS_TOKEN";

    String SEND_ALL_URL = "https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=ACCESS_TOKEN";

    String DRAFT_LIST_URL = "https://api.weixin.qq.com/cgi-bin/draft/batchget?access_token=ACCESS_TOKEN";

    String MASS_DELETE_URL="https://api.weixin.qq.com/cgi-bin/message/mass/delete?access_token=ACCESS_TOKEN";


}
