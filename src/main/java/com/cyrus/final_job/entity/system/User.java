package com.cyrus.final_job.entity.system;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 用户表(User)实体类
 *
 * @author cyrus
 * @since 2020-02-16 14:53:32
 */
@Data
public class User implements Serializable{
    private static final long serialVersionUID = 136575939803333143L;
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 登录账号
     */
    private String username;
    /**
     * 登录密码
     */
    private String password;
    /**
     * 用户头像
     */
    private String userFace;
    /**
     * 员工姓名
     */
    private String realName;
    /**
     * 性别,1 男 0 女
     */
    private Integer gender;

    /**
     * 身份证号
     */
    private String idCard;
    /**
     * 0 已婚 1 未婚 2 离异
     */
    private Integer wedlock;
    /**
     * 民族
     */
    private Integer nationId;
    /**
     * 籍贯
     */
    private String nativePlace;
    /**
     * 政治面貌
     */
    private Integer politicsId;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 电话号码
     */
    private String phone;
    /**
     * 联系地址
     */
    private String address;
    /**
     * 所属部门id
     */
    private Integer departmentId;
    /**
     * 职位ID
     */
    private Integer positionId;
    /**
     * 最高学历,0 其他 1 小学 2 初中 3 高中 4 大专 5 本科 6 硕士 7 博士
     */
    private Integer topDegree;
    /**
     * 所属专业
     */
    private String specialty;
    /**
     * 毕业院校
     */
    private String school;
    /**
     * 在职状态:1 在职 0 离职
     */
    private Integer workState;
    /**
     * 工号
     */
    private Long workId;
    /**
     * 合同期限
     */
    private Integer contractTerm;
    /**
     * 工龄
     */
    private Double workAge;
    /**
     * 出生日期
     */
    private Timestamp birthday;
    /**
     * 创建时间、入职时间
     */
    private Timestamp createTime;
    /**
     * 更新时间
     */
    private Timestamp updateTime;
    /**
     * 转正日期
     */
    private Timestamp conversionTime;
    /**
     * 离职日期
     */
    private Timestamp departureTime;
    /**
     * 合同起始日期
     */
    private Timestamp beginContractTime;
    /**
     * 合同终止日期
     */
    private Timestamp endContractTime;
    /**
     * 1 true，0 false
     */
    private Boolean enabled;
}