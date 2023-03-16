package com.m3ds.que.center.entity.struct;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wjs on 2023/03/15
 * {
 * 		‘queIds’:[’100001’,’100002’],
 * 		‘operator’:3,
 * 		‘type’:1,
 * 		‘value’:3,
 * 		‘and’:{
 * 			‘queIds’:,
 * 			‘operator’:,
 * 			‘type’:,
 * 			‘value’:,
 * 			‘and’:{}
 * 			‘or’:{}
 * }
 * 		‘or’:{
 *
 * }
 * }
 */
@Data
public class ConditionStruct implements Serializable {
    /**
    * 问题id集合
    */
    private List<String> queIds;

    /**
    * 操作 等于0,大于1，小于2，大于等于3，小于等于4
    */
    private int operator;

    /**
    * type(选项0,  数量1，分数2)
    */
    private int type;

    /**
    * 0否，1是，>=2其他选项或分数
    */
    private int value;

    /**
    * 与子树
    */
    private ConditionStruct and;

    /**
    * 或子树
    */
    private ConditionStruct or;

}
