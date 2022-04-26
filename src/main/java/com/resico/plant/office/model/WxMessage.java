package com.resico.plant.office.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class WxMessage implements Serializable {


    private Fliter filter;

    private Mpnews mpnews;

    private Text text;

    private Voice voice;

    private Images images;

    private String msgtype;


    private Integer send_ignore_reprint;


    @Data
    public static class Fliter implements Serializable {


        private Boolean is_to_all;

        private Integer tag_id;

    }

    @Data
    public static class Mpnews {

        private String media_id;

    }

    @Data
    public static class Text {

        private String content;

    }

    @Data
    public static class Voice {

        private String media_id;

    }


    @Data
    public static class Images {

        private List<String> media_ids;

        private String recommend;

        private Integer need_open_comment;

        private Integer only_fans_can_comment;

    }


}
