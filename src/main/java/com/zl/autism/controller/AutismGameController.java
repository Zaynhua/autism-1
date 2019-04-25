package com.zl.autism.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zl.autism.model.AutismGame;
import com.zl.autism.model.response.AutismGamePageResult;
import com.zl.autism.model.response.IDResult;
import com.zl.autism.service.AutismGameService;
import com.zl.autism.utils.ResponseMessage;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/game")
@Api(value="restful",description="游戏模块")
public class AutismGameController {

    private static final Logger logger = LoggerFactory.getLogger(AutismGameController.class);

    @Autowired
    private AutismGameService autismGameService;

    @RequestMapping(value="/getGames",method= RequestMethod.GET,produces="application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(value="获得游戏信息",notes="")
    @ApiResponses({
            @ApiResponse(code= ResponseMessage.SUCCESS_CODE,message=ResponseMessage.QUERY_SUCCESS_MSG,response=AutismGamePageResult.class),
            @ApiResponse(code=ResponseMessage.ERROR_CODE,message=ResponseMessage.QUERY_ERROR_MSG,response=AutismGamePageResult.class)
    })

    public AutismGamePageResult getGames(
            @ApiParam(name = "uuids",value = "uuid",required = false)@RequestParam(required = false)ArrayList<String> uuids,
            @ApiParam(name="pageNum",value="当前页码")@RequestParam(defaultValue="1") int pageNum,
            @ApiParam(name="pageSize",value="每页显示的条数")@RequestParam(defaultValue="10") int pageSize) {

        AutismGamePageResult rs = new AutismGamePageResult();

        try {
            PageHelper.startPage(pageNum,pageSize);
            ArrayList<AutismGame> list = this.autismGameService.getAutismGameList(uuids);
            PageInfo<AutismGame> page = new PageInfo<AutismGame>(list);
            rs.setData(page);
            rs.setStatusCode(ResponseMessage.SUCCESS_CODE);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            rs.autoFillException(ResponseMessage.ERROR_CODE, e.getMessage());
        }
        return rs;
    }

    @RequestMapping(value="/addGame",method= RequestMethod.POST,produces="application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(value="添加游戏信息",notes="")
    @ApiResponses({
            @ApiResponse(code= ResponseMessage.SUCCESS_CODE,message=ResponseMessage.ADD_SUCCESS_MSG,response=IDResult.class),
            @ApiResponse(code=ResponseMessage.ERROR_CODE,message=ResponseMessage.ADD_ERROR_MSG,response=IDResult.class)
    })

    public IDResult getGames(@ApiParam(name = "game",value = "游戏详情") @RequestBody AutismGame game) {

        IDResult rs = new IDResult();

        try {
            String uuid = this.autismGameService.addGame(game);
            rs.setData(uuid);
            rs.setStatusCode(ResponseMessage.SUCCESS_CODE);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            rs.autoFillException(ResponseMessage.ERROR_CODE, e.getMessage());
        }
        return rs;
    }

    @RequestMapping(value = "/updateGame",method = RequestMethod.PUT,produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(value = "更新游戏",notes = "")
    @ApiResponses({
            @ApiResponse(code= ResponseMessage.SUCCESS_CODE,message=ResponseMessage.UPDATE_SUCCESS_MSG,response=IDResult.class),
            @ApiResponse(code=ResponseMessage.ERROR_CODE,message=ResponseMessage.UPDATE_ERROR_MSG,response=IDResult.class)
    })
    public IDResult updateGame(@ApiParam(name = "game",value = "游戏详情") @RequestBody AutismGame game){

        IDResult rs = new IDResult();

        try {
            String uuid = this.autismGameService.updateGame(game);
            rs.setData(uuid);
            rs.setStatusCode(ResponseMessage.SUCCESS_CODE);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            rs.autoFillException(ResponseMessage.ERROR_CODE, e.getMessage());
        }
        return rs;
    }

    @RequestMapping(value = "/delGame",method = RequestMethod.DELETE,produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(value = "删除游戏",notes = "")
    @ApiResponses({@ApiResponse(code = ResponseMessage.SUCCESS_CODE,message = ResponseMessage.DELETE_SUCCESS_MSG,response = IDResult.class),
            @ApiResponse(code = ResponseMessage.ERROR_CODE,message = ResponseMessage.DELETE_ERROR_MSG,response = IDResult.class)})
    public IDResult delGame(@ApiParam(name = "uuid",value = "uuid",required = true)@RequestParam String uuid){

        IDResult rs = new IDResult();

        try {
            this.autismGameService.delGame(uuid);
            rs.setData(uuid);
            rs.setStatusCode(ResponseMessage.SUCCESS_CODE);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            rs.autoFillException(ResponseMessage.ERROR_CODE, e.getMessage());
        }
        return rs;
    }

}
