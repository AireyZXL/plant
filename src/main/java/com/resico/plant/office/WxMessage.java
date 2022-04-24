package com.resico.plant.office;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class WxMessage implements Serializable {


    private Fliter filter;

    private Mpnews mpnews;

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


}
