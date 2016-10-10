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
public class TaskPoolDataTranslator extends AbstractDataTranslator implements DataTranslator {
    public static Integer i = 0;
    public boolean translator (Record record){
        //字段不同
        alias(record,"USERUUID","task_uuid");
        alias(record,"USERREGPHONE","task_type");
        alias(record,"CALLTYPE","task_group_id");
        alias(record,"CALLPHONE","order_id");
        alias(record,"CALLLOG","hospital_uuid");
        alias(record,"CREATEDSTAFFID","hospital_shortname");
        alias(record,"CREATEDTIME","hospdept_uuid");
        alias(record,"TASKUUID","expert_name");
        alias(record,"TASKUUID","user_uuid");
        alias(record,"TASKUUID","user_regphone");
        alias(record,"TASKUUID","user_name");
        alias(record,"TASKUUID","outdial_count");
        alias(record,"TASKUUID","handle_staff");
        alias(record,"TASKUUID","staff_created");
        alias(record,"TASKUUID","gmt_created");
        alias(record,"TASKUUID","completed_time");
        alias(record,"TASKUUID","task_state_time");
        alias(record,"TASKUUID","task_state");
        alias(record,"TASKUUID","expert_arrange_uuid");
        alias(record,"TASKUUID","clinical_date");
        alias(record,"TASKUUID","reserve_timerange");
        alias(record,"TASKUUID","change_reason");
        alias(record,"TASKUUID","order_created_time");
        alias(record,"TASKUUID","id_no");
        alias(record,"TASKUUID","order_state");
        alias(record,"TASKUUID","area_id");
        alias(record,"TASKUUID","inform_state");
        alias(record,"TASKUUID","inform_result");
        alias(record,"TASKUUID","sms_seq");
        alias(record,"TASKUUID","gmt_modifird");
        //删除多余的字段
        record.removeColumnByName("CALLLOGUUID");
        record.removeColumnByName("CALLID");
        //增加了gmt_created和gmt_modified字段
        ColumnMeta id = new ColumnMeta("id", Types.INTEGER);
        ColumnValue idColumn = new ColumnValue(id,i++,false);
        record.addColumn(idColumn);
        ColumnMeta gmtModified = new ColumnMeta("gmt_modified", Types.TIMESTAMP);
        ColumnValue gmtModifiedColumn = new ColumnValue(gmtModified, new Date(),false);
        record.addColumn(gmtModifiedColumn);
        return super.translator(record);
    }
}
