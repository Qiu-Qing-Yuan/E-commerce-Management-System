package com.ks.eshop.service;

import com.ks.eshop.pojo.FunctionMenu;
import com.ks.eshop.pojo.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Permission)表服务接口
 */
public interface PermissionService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Permission queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Permission> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param permission 实例对象
     * @return 实例对象
     */
    Permission insert(Permission permission);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Permission> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Permission> entities);

    /**
     * 修改数据
     *
     * @param permission 实例对象
     * @return 实例对象
     */
    Permission update(Permission permission);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 通过aid删除数据
     *
     * @param aid 主键
     * @return 影响行数
     */
    int deleteByAid(Integer aid);

    //根据aid查询相应的菜单及子菜单
    List<FunctionMenu> queryByAidForMenu(Integer aid);
}
