package com.macro.mall.portal.service;

import java.util.List;

import com.macro.mall.portal.domain.MemberProductCollection;

import org.springframework.data.domain.Page;

/**
 * 会员收藏Service
 * Created by macro on 2018/8/2.
 */
public interface MemberCollectionService {
    int addProduct(MemberProductCollection productCollection);

    int deleteProduct(Long memberId, Long productId);

    List<MemberProductCollection> listProduct(Long memberId);
    public Page<MemberProductCollection> list(int shopId,int memberId ,int pageNum,int pageSize);
}
