package com.macro.mall.portal.repository;

import java.util.List;

import com.macro.mall.portal.domain.MemberProductCollection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 商品收藏Repository
 * Created by macro on 2018/8/2.
 */
public interface MemberProductCollectionRepository extends MongoRepository<MemberProductCollection,String> {
    MemberProductCollection findByMemberIdAndProductId(Long memberId, Long productId);
    int deleteByMemberIdAndProductId(Long memberId,Long productId);
    List<MemberProductCollection> findByMemberId(Long memberId);
    public Page<MemberProductCollection> findByMemberId(Integer memberId, Pageable pageable);
    
}
