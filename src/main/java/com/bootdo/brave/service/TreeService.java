package com.bootdo.brave.service;

import com.bootdo.brave.domain.TreeVo;

import java.util.List;
import java.util.Map;

public interface TreeService {

    List<TreeVo> list(Map<String, Object> map);

    List<TreeVo> treeKeywords(String keywords);

    List<TreeVo> findOneTree();

    List<TreeVo> findTwoTree(Integer id);

    List<TreeVo> findTwoTreeByNumber(String number);
}
