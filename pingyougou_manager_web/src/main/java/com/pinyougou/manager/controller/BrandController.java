package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pingyougou.sellergoods.service.BrandService;
import com.pinyougou.entity.PageResult;
import com.pinyougou.entity.Result;
import com.pinyougou.pojo.TbBrand;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("brand")
public class BrandController {
    @Reference
    private BrandService brandService;

    @RequestMapping("/findAll")
    public List<TbBrand> getList(){
       return brandService.findAll();
    }

    @RequestMapping("/findPage")
    public PageResult getListByPage(int page , int rows){
       return brandService.findAllByPage(page,rows);
    }
    @RequestMapping("/search")
    public PageResult searchByPage(int page , int rows,TbBrand brand){
       return brandService.findBySearchByPage(page,rows,brand);
    }
    @RequestMapping("/findOne")
    public TbBrand getOne(Long id){
       return brandService.findOne(id);
    }
     @RequestMapping("/add")
    public Result addBrand(@RequestBody TbBrand brand){
       try {
           brandService.addBrand(brand);
           return  new Result(true,"添加品牌成功");
       }catch (Exception e){
           e.printStackTrace();
           return new Result(false,"添加失败");
       }
    }
    @RequestMapping("/update")
    public Result updateBrand(@RequestBody TbBrand brand){
       try {
           brandService.updateBrand(brand);
           return  new Result(true,"添加品牌成功");
       }catch (Exception e){
           e.printStackTrace();
           return new Result(false,"添加失败");
       }
    }

    @RequestMapping("delete")
    public Result deleteBrand(String ids){

        String[] split = ids.split(",");
        Long[] idss = new Long[split.length];
        for (int i = 0; i < split.length; i++) {
            idss[i] = Long.parseLong(split[i]);
        }

        try {
            brandService.deleteBrand(idss);
            return  new Result(true,"删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"删除失败");
        }
    }


}
