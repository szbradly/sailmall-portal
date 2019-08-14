package com.macro.mall.portal.service.impl;

import java.util.List;

import com.macro.mall.portal.domain.MemberProductCollection;
import com.macro.mall.portal.repository.MemberProductCollectionRepository;
import com.macro.mall.portal.repository.SpringDataPageable;
import com.macro.mall.portal.service.MemberCollectionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * 会员收藏Service实现类
 * Created by macro on 2018/8/2.
 */
@Service
public class MemberCollectionServiceImpl implements MemberCollectionService {
    @Autowired
    private MemberProductCollectionRepository productCollectionRepository;

    @Override
    public int addProduct(MemberProductCollection productCollection) {
        int count = 0;
        MemberProductCollection findCollection = productCollectionRepository.findByMemberIdAndProductId(productCollection.getMemberId(), productCollection.getProductId());
        if (findCollection == null) {
            productCollectionRepository.save(productCollection);
            count = 1;
        }
        return count;
    }

    @Override
    public int deleteProduct(Long memberId, Long productId) {
        return productCollectionRepository.deleteByMemberIdAndProductId(memberId, productId);
    }


    @Override
    public Page<MemberProductCollection> list(int memberId ,int pageNum,int pageSize) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        SpringDataPageable pageable = new SpringDataPageable(); 
        pageable.setPagenumber(pageNum); 
        pageable.setPagesize(pageSize);
        pageable.setSort(sort);
        Page o = productCollectionRepository.findByMemberId( memberId, pageable);
        int i=0;
        return o;
    }

    @Override
    public List<MemberProductCollection> listProduct(Long memberId) {
        return productCollectionRepository.findByMemberId(memberId);
    }
}
