package com.qg.enroll.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 学生资料类
 * @author HC
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Student extends BaseRowModel {

    /**
     * 用户学号
     */
    @ExcelProperty(index = 0)
    String id;

    /**
     * 手机号码
     */
    String tel;

    /**
     * 学生名字
     */
    String name;

    /**
     * 学生性别
     */
    String sex;

    /**
     * 组别
     */
    String grouper;

    /**
     * 当前进度
     */
    @ExcelProperty(index = 1)
    int current;

    /**
     * 回复进度
     */
    int reply;
}
