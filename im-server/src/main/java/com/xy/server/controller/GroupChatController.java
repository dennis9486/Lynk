package com.xy.server.controller;


import com.xy.domain.dto.GroupDto;
import com.xy.domain.dto.GroupInviteDto;
import com.xy.response.domain.Result;
import com.xy.server.service.GroupService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 群聊
 */
@Slf4j
@RestController
@RequestMapping("/api/{version}/message/group")
@Tag(name = "group", description = "群聊")
public class GroupChatController {

    @Resource
    private GroupService groupService;

    @PostMapping("/invite")
    @Operation(summary = "群聊邀请", tags = {"group"}, description = "请使用此接口群聊邀请")
    @Parameters({
            @Parameter(name = "groupInviteDto", description = "邀请信息", required = true, in = ParameterIn.DEFAULT)
    })
    public Result inviteGroup(@RequestBody GroupInviteDto groupInviteDto) {
        return groupService.inviteGroup(groupInviteDto);
    }

    @PostMapping("/member")
    @Operation(summary = "群成员", tags = {"group"}, description = "请使用此接口查询群成员")
    @Parameters({
            @Parameter(name = "groupDto", description = "群信息", required = true, in = ParameterIn.DEFAULT)
    })
    public Result getGroupMembers(@RequestBody GroupDto groupDto) {
        return groupService.getGroupMembers(groupDto);
    }


    @PostMapping("/info")
    @Operation(summary = "群信息", tags = {"group"}, description = "请使用此接口查询群信息")
    @Parameters({
            @Parameter(name = "groupDto", description = "群信息", required = true, in = ParameterIn.DEFAULT)
    })
    public Result groupInfo(@RequestBody GroupDto groupDto) {
        return groupService.groupInfo(groupDto);
    }


    @PostMapping("/quit")
    @Operation(summary = "群信息", tags = {"group"}, description = "请使用此接口退出群聊")
    @Parameters({
            @Parameter(name = "groupDto", description = "群信息", required = true, in = ParameterIn.DEFAULT)
    })
    public void quit(@RequestBody GroupDto groupDto) {
        groupService.quitGroup(groupDto);
    }

}
