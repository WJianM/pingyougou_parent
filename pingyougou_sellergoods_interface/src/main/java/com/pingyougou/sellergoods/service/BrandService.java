package com.pingyougou.sellergoods.service;

import com.pinyougou.entity.PageResult;
import com.pinyougou.pojo.TbBrand;

import java.util.List;

public interface BrandService {

   public List<TbBrand> findAll();

    PageResult findAllByPage(int pageNum, int pageSize);

    void addBrand(TbBrand brand);

    TbBrand findOne(Long id);

    void updateBrand(TbBrand brand);

    void deleteBrand(Long[] ids);

 PageResult findBySearchByPage(int page, int rows, TbBrand brand);
}
