package com.macro.mall.portal.repository;

import java.util.List;

import com.macro.mall.portal.domain.MemberBrandAttention;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 会员关注Repository
 * Created by macro on 2018/8/2.
 */
public interface MemberBrandAttentionRepository extends MongoRepository<MemberBrandAttention,String> {
    MemberBrandAttention findByMemberIdAndBrandId(Long memberId, Long brandId);
    int deleteByMemberIdAndBrandId(Long memberId,Long brandId);
    List<MemberBrandAttention> findByMemberId(Long memberId);
    public Page<MemberBrandAttention> findByShopIdAndMemberId(Integer shopId,Long memberId, Pageable pageable);
    
}
