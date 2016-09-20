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
public class StaffOperateLogDataTranslator extends AbstractDataTranslator implements DataTranslator {
    public static Integer i = 0;
    public boolean translator (Record record){
        //字段不同
        alias(record,"COL01","operate_log_uuid");
        alias(record,"OPERATETYPEID","operate_type_id");
        alias(record,"USERUUID","user_id");
        alias(record,"CALLTYPE","call_type");
        alias(record,"CALLPHONE","call_phone");
        alias(record,"CALLID","call_id");
        alias(record,"OPERATETYPECONTENT","operate_type_content");
        alias(record,"EXPERTNAME01","expert_name");
        alias(record,"REMARK","remark");
        alias(record,"CREATEDSTAFFID","staff_created");
        alias(record,"CREATEDTIME","gmt_created");
        alias(record,"MODIFIEDTIME","gmt_modified");
        //删除多余的字段
        record.removeColumnByName("OPERATELOGUUID");
        record.removeColumnByName("EXPERTNAME02");
        record.removeColumnByName("COL02");
        record.removeColumnByName("COL03");
        record.removeColumnByName("COL04");
        record.removeColumnByName("COL05");
        //增加了gmt_created和gmt_modified字段
        ColumnMeta id = new ColumnMeta("id", Types.INTEGER);
        ColumnValue gmtCreatedColumn = new ColumnValue(id,i++,false);
        record.addColumn(gmtCreatedColumn);
        return super.translator(record);
    }
}
