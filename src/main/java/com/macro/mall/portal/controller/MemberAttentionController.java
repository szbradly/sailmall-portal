package com.macro.mall.portal.controller;

import java.util.List;

import com.macro.mall.portal.dao.CommonResult;
import com.macro.mall.portal.domain.MemberBrandAttention;
import com.macro.mall.portal.service.MemberAttentionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 会员关注品牌管理Controller
 * Created by macro on 2018/8/2.
 */
@Controller
@Api(tags = "MemberAttentionController", description = "会员关注品牌管理")
@RequestMapping("/member/attention")
public class MemberAttentionController {
    @Autowired
    private MemberAttentionService memberAttentionService;
    @ApiOperation("添加品牌关注")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestBody MemberBrandAttention memberBrandAttention) {
        int count = memberAttentionService.add(memberBrandAttention);
        if(count>0){
            return CommonResult.success(count);
        }else{
            return CommonResult.failed();
        }
    }

    @ApiOperation("取消关注")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(Long memberId, Long brandId) {
        int count = memberAttentionService.delete(memberId,brandId);
        if(count>0){
            return CommonResult.success(count);
        }else{
            return CommonResult.failed();
        }
    }

    @ApiOperation("显示关注列表")
    @RequestMapping(value = "/list/{memberId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<MemberBrandAttention>> list(@PathVariable Long memberId
    ,@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
    @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<MemberBrandAttention> memberBrandAttentionList = memberAttentionService.list(memberId);
        return CommonResult.success(memberBrandAttentionList);
    }
}
