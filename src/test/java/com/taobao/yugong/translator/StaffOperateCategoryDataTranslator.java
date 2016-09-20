/*
 * Project: yugong
 * 
 * File Created at 2016-09-19
 * 
 * Copyright 2012-2015 Greenline.com Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Greenline Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Greenline.com.
 */
package com.taobao.yugong.translator;

import com.taobao.yugong.common.db.meta.ColumnMeta;
import com.taobao.yugong.common.db.meta.ColumnValue;
import com.taobao.yugong.common.model.record.Record;

import java.sql.Types;
import java.util.Date;

/**
 * @author chengsy
 * @version V1.0
 * @since 2016-09-19 16:13
 */
public class StaffOperateCategoryDataTranslator extends AbstractDataTranslator implements DataTranslator {

    public boolean translator (Record record){
        //sort_code字段不同
        ColumnValue columnValue = record.getColumnByName("sortcode");
        if (columnValue!=null){
            columnValue.getColumn().setName("sort_code");
        }
        //增加了gmt_created和gmt_modified字段
        ColumnMeta gmtCreatedMeta = new ColumnMeta("gmt_created", Types.TIMESTAMP);
        ColumnValue gmtCreatedColumn = new ColumnValue(gmtCreatedMeta, new Date());
        gmtCreatedColumn.setCheck(false);// 该字段不做对比
        record.addColumn(gmtCreatedColumn);
        ColumnMeta gmtModified = new ColumnMeta("gmt_modified", Types.TIMESTAMP);
        ColumnValue gmtModifiedColumn = new ColumnValue(gmtModified, new Date());
        gmtModifiedColumn.setCheck(false);// 该字段不做对比
        record.addColumn(gmtModifiedColumn);
        return super.translator(record);
    }

}
