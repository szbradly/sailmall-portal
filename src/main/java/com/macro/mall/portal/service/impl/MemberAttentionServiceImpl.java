package com.macro.mall.portal.service.impl;

import com.macro.mall.portal.domain.MemberBrandAttention;
import com.macro.mall.portal.repository.MemberBrandAttentionRepository;
import com.macro.mall.portal.repository.SpringDataPageable;
import com.macro.mall.portal.service.MemberAttentionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * 会员关注Service实现类
 * Created by macro on 2018/8/2.
 */
@Service
public class MemberAttentionServiceImpl implements MemberAttentionService {
    @Autowired
    private MemberBrandAttentionRepository memberBrandAttentionRepository;

    @Override
    public int add(MemberBrandAttention memberBrandAttention) {
        int count = 0;
        MemberBrandAttention findAttention = memberBrandAttentionRepository.findByMemberIdAndBrandId(memberBrandAttention.getMemberId(), memberBrandAttention.getBrandId());
        if (findAttention == null) {
            memberBrandAttentionRepository.save(memberBrandAttention);
            count = 1;
        }
        return count;
    }

    @Override
    public int delete(Long memberId, Long brandId) {
        return memberBrandAttentionRepository.deleteByMemberIdAndBrandId(memberId,brandId);
    }

    @Override
    public Page<MemberBrandAttention> list(int shopId,int memberId ,int pageNum,int pageSize) {
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        SpringDataPageable pageable = new SpringDataPageable(); 
        pageable.setPagenumber(pageNum); 
        pageable.setPagesize(pageSize);
        pageable.setSort(sort);
        return memberBrandAttentionRepository.findByShopIdAndMemberId(shopId,memberId,pageable);
    }
}
