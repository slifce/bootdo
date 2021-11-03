package com.bootdo.frequent.service.impl;

import com.bootdo.frequent.dao.FrequentContactDao;
import com.bootdo.frequent.domain.FrequentContact;
import com.bootdo.frequent.service.FrequentContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/10/18.
 */

@Service
public class FrequentContactServiceImpl implements FrequentContactService{

    @Autowired
    private FrequentContactDao frequentContactDao;

    @Override
    public FrequentContact selectById(Long id) {
        return frequentContactDao.selectById(id);
    }

    @Override
    public List<FrequentContact> selectAll() {
        return frequentContactDao.selectAll();
    }

    @Override
    public int save(FrequentContact frequentContact) {
        return frequentContactDao.save(frequentContact);
    }

    @Override
    public int updateSysIdById(FrequentContact frequentContact) {
        return frequentContactDao.updateSysIdById(frequentContact);
    }
}
