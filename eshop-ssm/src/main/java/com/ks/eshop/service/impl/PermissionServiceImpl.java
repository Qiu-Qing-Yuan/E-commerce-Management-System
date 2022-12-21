package com.ks.eshop.service.impl;

import com.ks.eshop.pojo.FunctionMenu;
import com.ks.eshop.pojo.Permission;
import com.ks.eshop.dao.PermissionDao;
import com.ks.eshop.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * (Permission)表服务实现类
 */
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Permission queryById(Integer id) {
        return this.permissionDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Permission> queryAllByLimit(int offset, int limit) {
        return this.permissionDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param permission 实例对象
     * @return 实例对象
     */
    @Override
    public Permission insert(Permission permission) {
        this.permissionDao.insert(permission);
        return permission;
    }

    @Override
    public int insertBatch(List<Permission> entities) {
        return permissionDao.insertBatch(entities);
    }

    /**
     * 修改数据
     *
     * @param permission 实例对象
     * @return 实例对象
     */
    @Override
    public Permission update(Permission permission) {
        this.permissionDao.update(permission);
        return this.queryById(permission.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.permissionDao.deleteById(id) > 0;
    }

    @Override
    public int deleteByAid(Integer aid) {
        return permissionDao.deleteByAid(aid);
    }

    @Override
    public List<FunctionMenu> queryByAidForMenu(Integer aid) {
        return permissionDao.queryByAidForMenu(aid);
    }
}
