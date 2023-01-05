package com.bootdo.brave.dao;

import com.bootdo.brave.domain.OrgInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 审批流程测试表
 *
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-11-25 13:28:58
 */
@Mapper
public interface OrgInfoDao {

    List<OrgInfo> list(Map<String, Object> map);

}
