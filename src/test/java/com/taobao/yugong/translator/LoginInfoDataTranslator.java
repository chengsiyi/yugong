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
public class LoginInfoDataTranslator extends AbstractDataTranslator implements DataTranslator {
    public static Integer i = 0;
    public boolean translator (Record record){
        //字段不同
        alias(record,"LOGINSERIALNBR","login_serial_nbr");
        alias(record,"LOGINSTAFFID","login_staff_id");
        alias(record,"LOGINSESSIONID","login_session_id");
        alias(record,"LOGINTIME","login_time");
        alias(record,"IPADDR","ip_addr");
        alias(record,"STATE","state");
        alias(record,"STATETIME","state_time");
        //增加的字段
        ColumnMeta id = new ColumnMeta("id", Types.INTEGER);
        ColumnValue idColumn = new ColumnValue(id,i++,false);
        record.addColumn(idColumn);
        return super.translator(record);
    }
}
