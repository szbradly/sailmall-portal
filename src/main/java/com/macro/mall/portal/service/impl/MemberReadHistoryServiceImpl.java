package com.macro.mall.portal.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.macro.mall.portal.domain.MemberReadHistory;
import com.macro.mall.portal.repository.MemberReadHistoryRepository;
import com.macro.mall.portal.repository.SpringDataPageable;
import com.macro.mall.portal.service.MemberReadHistoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * 会员浏览记录管理Service实现类
 * Created by macro on 2018/8/3.
 */
@Service
public class MemberReadHistoryServiceImpl implements MemberReadHistoryService {
    @Autowired
    private MemberReadHistoryRepository memberReadHistoryRepository;
    @Override
    public int create(MemberReadHistory memberReadHistory) {
        memberReadHistory.setId(null);
        memberReadHistory.setCreateTime(new Date());
         
        memberReadHistoryRepository.save(memberReadHistory);
        return 1;
    }

    @Override
    public int delete(List<String> ids) {
        List<MemberReadHistory> deleteList = new ArrayList<>();
        for(String id:ids){
            MemberReadHistory memberReadHistory = new MemberReadHistory();
            memberReadHistory.setId(id);
            deleteList.add(memberReadHistory);
        }
        memberReadHistoryRepository.deleteAll(deleteList);
        return ids.size();
    }

    @Override
    public Page<MemberReadHistory> list(int shopId,int memberId ,int pageNum,int pageSize) {
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        SpringDataPageable pageable = new SpringDataPageable(); 
        pageable.setPagenumber(pageNum); 
        pageable.setPagesize(pageSize);
        pageable.setSort(sort);
        return memberReadHistoryRepository.findByShopIdAndMemberId(shopId,memberId,pageable);
    }
}
