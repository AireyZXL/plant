package com.resico.plant.bean;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.util.List;


/**
 * 资金信息对象 z_funds
 *
 * @author xtzbservice
 * @date 2022-04-20
 */

@Data
@ApiModel("资金信息对象")
public class ZFunds implements Comparable<ZFunds> {
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */

    @ApiModelProperty(value = "编号")
    private String id;


    /**
     * 考核类型（1：预算均衡性考核 2：研发费核算均衡）
     */

    @ApiModelProperty(value = "考核类型 1=：预算均衡性考核,2=：研发费核算均衡")
    private Integer type;

    /**
     * 映射编号
     */

    @ApiModelProperty(value = "映射编号")
    private String mappingId;

    /**
     * 周期（1：月度 2：季度 3：年度）
     */

    @ApiModelProperty(value = "周期 1=：月度,2=：季度,3=：年度")
    private Integer cycle;

    /**
     * 月
     */

    @ApiModelProperty(value = "月")
    private Integer moon;

    /**
     * 季度
     */

    @ApiModelProperty(value = "季度")
    private String quarter;


    /**
     * 考核目标金额
     */
    @ApiModelProperty(value = "考核目标金额")
    private Double assessTarget;

    /**
     * 目标金额
     */


    /**
     * 是否导出全部
     */
    private boolean exportAll;
    private List<String> mappingIds;


    public int convertToQuarter() {

        if ("1-6月预算".equals(quarter)) {
            return 6;
        }

        if ("1-9月预算".equals(quarter)) {
            return 9;
        }

        if ("1-12月预算".equals(quarter)) {
            return 12;
        }

        return 0;
    }


    @Override
    public int compareTo(@NotNull ZFunds o) {
        int q1 = this.convertToQuarter();
        int o1 = o.convertToQuarter();
        return Integer.compare(q1, o1);
    }
}
