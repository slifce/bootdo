package com.bootdo.brave.service;

import com.bootdo.brave.domain.OrgInfo;

import java.util.List;
import java.util.Map;

public interface OrgInfoService {

    List<OrgInfo> list(Map<String, Object> map);

}
