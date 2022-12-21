package com.ks.eshop.controller;

import com.ks.eshop.common.Page;
import com.ks.eshop.common.Result;
import com.ks.eshop.common.TableData;
import com.ks.eshop.pojo.OrderDetail;
import com.ks.eshop.pojo.OrderInfo;
import com.ks.eshop.pojo.UserInfo;
import com.ks.eshop.service.OrderDetailService;
import com.ks.eshop.service.OrderInfoService;
import com.ks.eshop.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * (OrderInfo)表控制层
 */
@RestController
@RequestMapping("orderInfo")
public class OrderInfoController {
    /**
     * 服务对象
     */
    @Autowired
    private OrderInfoService orderInfoService;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private OrderDetailService orderDetailService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne/{id}")
    public Result selectOne(@PathVariable("id") Integer id) {
        OrderInfo orderInfo = this.orderInfoService.queryById(id);
        if (orderInfo!=null){
            return Result.success(orderInfo);
        }
        return Result.fail();
    }

    //分页查询订单信息，在table上展示
    @GetMapping("/queryAll")
    public TableData queryByPage(@RequestParam("pageNumber")Integer pageNumber,
                                 @RequestParam("pageSize")Integer pageSize){

        int total = orderInfoService.queryCounts();
        Page page = new Page(pageNumber, pageSize);

        List<OrderInfo> orderInfos = orderInfoService.queryAllByLimit(page.getStartIoc(), page.getPageSize());
        if (orderInfos!=null&&orderInfos.size()>0){
            return new TableData(total,orderInfos);
        }else {
            return null;
        }
    }

    //根据id删除订单
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable("id")Integer id){
        boolean b = orderInfoService.deleteById(id);
        if (b){
            return Result.success();
        }else {
            return Result.fail();
        }
    }

    //按条件查询
    @GetMapping("/query")
    public TableData queryByCondition(@RequestParam("pageNumber")Integer pageNumber,
                                      @RequestParam("pageSize")Integer pageSize,
                                      @RequestParam("orderCode")String orderCode,
                                      @RequestParam("orderName")String orderName,
                                      @RequestParam("orderStatus")String orderStatus,
                                      @RequestParam("startTime")String startTime,
                                      @RequestParam("endTime")String endTime) throws ParseException {
        if (orderCode.isEmpty() && orderName.isEmpty() && orderStatus.isEmpty() && startTime.isEmpty() && endTime.isEmpty()){
            return queryByPage(pageNumber, pageSize);
        }else {
            //根据查询的用户名找其id
            Integer id = null;
            if (!orderName.isEmpty()){
                UserInfo userInfo = new UserInfo();
                userInfo.setUserName(orderName);
                List<UserInfo> query = userInfoService.query(userInfo);
                 id = query.get(0).getId();
            }

            //时间格式化
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            if (startTime.isEmpty() && endTime.isEmpty()){
                startTime = "2000-01-01";
                endTime = simpleDateFormat.format(new Date());
            }

            Date sTime = simpleDateFormat.parse(startTime);
            Date eTime = simpleDateFormat.parse(endTime);

            List<OrderInfo> orderInfos = orderInfoService.queryAll(new OrderInfo(id, orderCode, orderStatus, sTime, eTime));
            return new TableData(orderInfos.size(),orderInfos);
        }
    }

    //保存订单信息
    @PostMapping("/saveInfo")
    public Result saveOrderInfo(@RequestBody OrderInfo orderInfo, HttpServletRequest request) throws ParseException {

        //生成编号
        orderInfo.setOrderCode(String.valueOf(System.currentTimeMillis()));
        //插入订单信息，返回插入结果
        OrderInfo orderInfo1 = orderInfoService.insert(orderInfo);
        //获取插入记录的id
        Integer id = orderInfo1.getId();
        //获取订单明细
        ArrayList<OrderDetail> orderDetail = orderInfo.getOrderDetail();
        for (OrderDetail detail : orderDetail) {
            detail.setOid(id);//设置订单明细的oid
        }
        //批量插入订单明细
        int i = orderDetailService.insertBatch(orderInfo.getOrderDetail());
        if (i>0){
            request.getSession().setAttribute("detail",null);
//            request.getSession().invalidate();
            return Result.success();
        }
        return Result.fail();
    }
}
