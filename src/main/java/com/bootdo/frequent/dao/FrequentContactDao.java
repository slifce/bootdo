package com.bootdo.frequent.dao;

import com.bootdo.frequent.domain.FrequentContact;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2018/10/18.
 */
@Mapper
public interface FrequentContactDao {

    FrequentContact selectById(Long id);

    List<FrequentContact> selectAll();

}
