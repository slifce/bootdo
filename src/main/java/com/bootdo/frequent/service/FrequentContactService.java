package com.bootdo.frequent.service;

import com.bootdo.frequent.domain.FrequentContact;

import java.util.List;

/**
 * Created by Administrator on 2018/10/18.
 */
public interface FrequentContactService {

    FrequentContact selectById(Long id);

    List<FrequentContact> selectAll();

    int save(FrequentContact frequentContact);

    int updateSysIdById(FrequentContact frequentContact);
}
