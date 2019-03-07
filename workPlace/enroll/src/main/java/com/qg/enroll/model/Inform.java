package com.qg.enroll.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class Inform {

    /**
     * 指向的考核
     */
    int position;

    /**
     * 组别
     */
    String grouper;

    /**
     * 时间地点
     */
    String timeAndPlace;
}
