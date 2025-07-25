package com.xy.database.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xy.database.mapper.ImFriendshipMapper;
import com.xy.database.service.ImFriendshipService;
import com.xy.domain.po.ImFriendshipPo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dense
 * @description 针对表【im_friendship】的数据库操作Service实现
 */
@Service
public class ImFriendshipServiceImpl extends ServiceImpl<ImFriendshipMapper, ImFriendshipPo>
        implements ImFriendshipService {


    @Resource
    private ImFriendshipMapper imFriendshipMapper;


    public List<ImFriendshipPo> list(String ownerId, Long sequence){
       return imFriendshipMapper.selectFriendList(ownerId,sequence);
    }
}




