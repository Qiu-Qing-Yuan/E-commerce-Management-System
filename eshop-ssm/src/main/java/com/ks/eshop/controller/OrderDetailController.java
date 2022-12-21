package com.ks.eshop.controller;

import com.ks.eshop.common.Result;
import com.ks.eshop.common.TableData;
import com.ks.eshop.pojo.OrderDetail;
import com.ks.eshop.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * (OrderDetail)表控制层
 *
 * @author makejava
 * @since 2021-06-06 22:48:10
 */
@RestController
@RequestMapping("orderDetail")
public class OrderDetailController {
    /**
     * 服务对象
     */
    @Autowired
    private OrderDetailService orderDetailService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public OrderDetail selectOne(Integer id) {
        return this.orderDetailService.queryById(id);
    }

    //根据订单id查询订单明细
    @GetMapping("/queryDetail")
    public TableData queryDetailById(@RequestParam("oid")Integer oid){
        List<OrderDetail> orderDetails = orderDetailService.queryByOid(oid);
        System.out.println(oid);
        if (orderDetails!=null&&orderDetails.size()>0){
            return new TableData(orderDetails.size(),orderDetails);
        }
        return null;
    }

    //获取订单明细
    @PostMapping("/addDetail")
    public Object tempDetailData(HttpServletRequest request,
                                    @RequestBody HashMap<String, String> map){
        boolean flag = true;
        ArrayList<HashMap<String, String>> detail = (ArrayList<HashMap<String, String>>) request.getSession().getAttribute("detail");
        if (detail!=null&&detail.size()>0){
            for (HashMap<String, String> hashMap : detail) {
                if (map.get("name").equals(hashMap.get("name"))){
                    String str = String.valueOf(Integer.parseInt(hashMap.get("num"))+Integer.parseInt(map.get("num")));
                    hashMap.put("num",str);
                    flag = false;
                    break;
                }
            }
            if (flag){
                detail.add(map);
            }
            request.getSession().setAttribute("detail",detail);
        }else {
            ArrayList<HashMap<String, String>> list = new ArrayList<>();
            list.add(map);
            request.getSession().setAttribute("detail",list);
        }
        return request.getSession().getAttribute("detail");
    }

    //获取订单明细返回table
    @GetMapping("/getDetail")
    public TableData getDetailData(HttpServletRequest request){
        ArrayList<HashMap<String, String>> detail = (ArrayList<HashMap<String, String>>) request.getSession().getAttribute("detail");
        return new TableData(detail.size(),detail);
    }

    //删除订单明细
    @DeleteMapping("/delete/{name}")
    public Result deleteDetail(HttpServletRequest request,@PathVariable("name")String name){
        ArrayList<HashMap<String, String>> detail = (ArrayList<HashMap<String, String>>) request.getSession().getAttribute("detail");

        detail.removeIf(map -> map.get("name").equals(name));
        request.getSession().setAttribute("detail",detail);
        return Result.success();
    }
}
