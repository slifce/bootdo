package com.bootdo.brave.service.impl;

import com.bootdo.brave.dao.OrgInfoDao;
import com.bootdo.brave.domain.OrgInfo;
import com.bootdo.brave.service.OrgInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class OrgInfoServiceImpl implements OrgInfoService {
    @Autowired
    private OrgInfoDao orgInfoDao;

    @Override
    public List<OrgInfo> list(Map<String, Object> map) {
        return orgInfoDao.list(map);
    }
}
