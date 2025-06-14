package com.xy.server.api.database.message;


import com.xy.domain.po.ImGroupMessagePo;
import com.xy.domain.po.ImGroupMessageStatusPo;
import com.xy.domain.po.ImPrivateMessagePo;
import com.xy.server.api.FeignRequestInterceptor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 消息操作数据库远程调用接口
 */
@FeignClient(contextId = "message", value = "im-database", path = "/api/v1/database", configuration = FeignRequestInterceptor.class)
public interface ImMessageFeign {

    /**
     * 获取用户私聊消息
     *
     * @param userId   用户id
     * @param sequence 序列号
     * @return 用户私聊消息
     */
    @GetMapping("/private/message/list")
    List<ImPrivateMessagePo> getPrivateMessageList(@RequestParam("userId") String userId, @RequestParam("sequence") Long sequence);


    /**
     * 获取用户群聊消息
     *
     * @param userId   用户id
     * @param sequence 序列号
     * @return 用户群聊消息
     */
    @GetMapping("/group/message/list")
    List<ImGroupMessagePo> getGroupMessageList(@RequestParam("userId") String userId, @RequestParam("sequence") Long sequence);


    /**
     * 插入私聊消息
     *
     * @param messagePo 私聊消息
     */
    @PostMapping("/private/message/insert")
    Boolean privateMessageInsert(@RequestBody ImPrivateMessagePo messagePo);


    /**
     * 插入群聊消息
     *
     * @param messagePo 群聊消息
     */
    @PostMapping("/group/message/insert")
    Boolean groupMessageInsert(@RequestBody ImGroupMessagePo messagePo);


    /**
     * 批量插入群聊消息状态
     *
     * @param groupReadStatusList 群聊消息群成员阅读状态集合
     */
    @PostMapping("/group/message/status/batch/insert")
    Boolean groupMessageStatusBatchInsert(@RequestBody List<ImGroupMessageStatusPo> groupReadStatusList);

}
