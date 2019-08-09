package com.macro.mall.portal.repository;

import java.util.List;

import com.macro.mall.portal.domain.MemberReadHistory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 会员商品浏览历史Repository
 * Created by macro on 2018/8/3.
 */
public interface MemberReadHistoryRepository extends MongoRepository<MemberReadHistory,String> {
    List<MemberReadHistory> findByMemberIdOrderByCreateTimeDesc(Long memberId);
    // Page <MemberReadHistory>findAllByPage
    public Page<MemberReadHistory> findByShopIdAndMemberId(int shopId,int memberId, Pageable pageable);
}