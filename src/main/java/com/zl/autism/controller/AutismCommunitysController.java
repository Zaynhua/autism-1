package com.zl.autism.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zl.autism.model.AutismCommunitys;
import com.zl.autism.model.AutismGame;
import com.zl.autism.model.response.AutismCommunitysPageResult;
import com.zl.autism.model.response.AutismGamePageResult;
import com.zl.autism.model.response.IDResult;
import com.zl.autism.service.AutismCommunitysService;
import com.zl.autism.service.AutismGameService;
import com.zl.autism.utils.ResponseMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@RequestMapping("/communitys")
@Api(value = "restful", description = "社区模块")
public class AutismCommunitysController {

    private static final Logger logger = LoggerFactory.getLogger(AutismCommunitysController.class);

    @Autowired
    private AutismCommunitysService autismCommunitysService;

    @RequestMapping(value = "/getCommunitys", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(value = "获得社区信息", notes = "")
    @ApiResponses({
            @ApiResponse(code = ResponseMessage.SUCCESS_CODE, message = ResponseMessage.QUERY_SUCCESS_MSG, response = AutismCommunitysPageResult.class),
            @ApiResponse(code = ResponseMessage.ERROR_CODE, message = ResponseMessage.QUERY_ERROR_MSG, response = AutismCommunitysPageResult.class)
    })

    public AutismCommunitysPageResult getCommunitys(
            @ApiParam(name = "uuids", value = "uuid", required = false) @RequestParam(required = false) ArrayList<String> uuids,
            @ApiParam(name = "communitys_city", required = false, value = "杭州市") @RequestParam(required = false) ArrayList<String> communitys_city,
            @ApiParam(name = "pageNum", value = "当前页码") @RequestParam(defaultValue = "1") int pageNum,
            @ApiParam(name = "pageSize", value = "每页显示的条数") @RequestParam(defaultValue = "10") int pageSize) {

        AutismCommunitysPageResult rs = new AutismCommunitysPageResult();

        try {
            PageHelper.startPage(pageNum, pageSize);
            ArrayList<AutismCommunitys> list = this.autismCommunitysService.getAutismCommunitysList(uuids, communitys_city);
            PageInfo<AutismCommunitys> page = new PageInfo<AutismCommunitys>(list);
            rs.setData(page);
            rs.setStatusCode(ResponseMessage.SUCCESS_CODE);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            rs.autoFillException(ResponseMessage.ERROR_CODE, e.getMessage());
        }
        return rs;
    }

    @RequestMapping(value = "/addCommunity", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(value = "添加社区信息", notes = "")
    @ApiResponses({
            @ApiResponse(code = ResponseMessage.SUCCESS_CODE, message = ResponseMessage.ADD_SUCCESS_MSG, response = IDResult.class),
            @ApiResponse(code = ResponseMessage.ERROR_CODE, message = ResponseMessage.ADD_ERROR_MSG, response = IDResult.class)
    })

    public IDResult addCommunity(@ApiParam(name = "community", value = "社区详情") @RequestBody AutismCommunitys community) {

        IDResult rs = new IDResult();

        try {
            String uuid = this.autismCommunitysService.addCommunity(community);
            rs.setData(uuid);
            rs.setStatusCode(ResponseMessage.SUCCESS_CODE);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            rs.autoFillException(ResponseMessage.ERROR_CODE, e.getMessage());
        }
        return rs;
    }


}
