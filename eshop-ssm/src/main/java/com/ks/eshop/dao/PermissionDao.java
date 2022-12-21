package com.ks.eshop.dao;

import com.ks.eshop.pojo.FunctionMenu;
import com.ks.eshop.pojo.Permission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * (Permission)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-10 17:08:19
 */
@Mapper
public interface PermissionDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Permission queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Permission> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param permission 实例对象
     * @return 对象列表
     */
    List<Permission> queryAll(Permission permission);

    /**
     * 新增数据
     *
     * @param permission 实例对象
     * @return 影响行数
     */
    int insert(Permission permission);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Permission> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Permission> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Permission> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Permission> entities);

    /**
     * 修改数据
     *
     * @param permission 实例对象
     * @return 影响行数
     */
    int update(Permission permission);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 通过aid删除数据
     *
     * @param aid 主键
     * @return 影响行数
     */
    @Delete("delete from permission where aid = #{aid}")
    int deleteByAid(Integer aid);

    //根据aid查询
    @Select("select * from permission where aid = #{aid}")
    List<Permission> queryByAid(Integer aid);

    //根据aid查询相应的菜单及子菜单
    List<FunctionMenu> queryByAidForMenu(Integer aid);
    //根据parentId查询包含aid管理员的权限
    FunctionMenu queryByParentIdForMenu(Integer id,Integer aid);
}

