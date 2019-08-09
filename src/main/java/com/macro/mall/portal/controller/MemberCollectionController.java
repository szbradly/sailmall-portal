package com.macro.mall.portal.controller;

import java.util.List;

import com.macro.mall.portal.dao.CommonResult;
import com.macro.mall.portal.domain.MemberProductCollection;
import com.macro.mall.portal.service.MemberCollectionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 会员收藏管理Controller
 * Created by macro on 2018/8/2.
 */
@Controller
@Api(tags = "MemberCollectionController", description = "会员收藏管理")
@RequestMapping("/member/collection")
public class MemberCollectionController {
    @Autowired
    private MemberCollectionService memberCollectionService;

    @ApiOperation("添加商品收藏")
    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult addProduct(@RequestBody MemberProductCollection productCollection) {
        int count = memberCollectionService.addProduct(productCollection);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("删除收藏商品")
    @RequestMapping(value = "/deleteProduct", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult deleteProduct(Long memberId, Long productId) {
        int count = memberCollectionService.deleteProduct(memberId, productId);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

  

    @ApiOperation("分页显示收藏列表")
    @RequestMapping(value = "/listByPage", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<MemberProductCollection>> list(@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
    @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
    int memberId,int shopId
    ){
        Page<MemberProductCollection> pageData = memberCollectionService.list(shopId, memberId, pageNum, pageSize);
       // return  new CommonResult.pageDocSuccess(pageData);
       CommonResult  <List<MemberProductCollection>>result =new CommonResult<List<MemberProductCollection>> ();
       return result.pageDocSuccess(pageData);
    }
}
