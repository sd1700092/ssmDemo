package cn.gxufe.ssm.demo.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.abel533.mapper.Mapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public abstract class BaseService<T, ID extends Serializable> {

    @Autowired
	private Mapper<T> baseMapper;

    public T queryById(ID id) {
        return baseMapper.selectByPrimaryKey(id);
    }

    public Integer queryCount() {
        return baseMapper.selectCount(null);
    }

    public Integer queryCount(T t) {
        return baseMapper.selectCount(t);
    }

    public List<T> queryAll() {
        return baseMapper.select(null);
    }

    public List<T> queryByWhere(T t) {
        return baseMapper.select(t);
    }


    public PageInfo<T> queryPageList(Integer page, Integer rows) {
        PageHelper.startPage(page, rows, true);
        List<T> list = baseMapper.select(null);
        return new PageInfo<T>(list);
    }


    public PageInfo<T> queryPageList(T t, Integer page, Integer rows) {
        PageHelper.startPage(page, rows, true);
        List<T> list = baseMapper.select(t);
        return new PageInfo<T>(list);
    }


    public Integer save(T t) {
        return baseMapper.insert(t);
    }


    public Integer saveSelective(T t) {
        return baseMapper.insertSelective(t);
    }


    public Integer update(T t) {
        return baseMapper.updateByPrimaryKey(t);
    }


    public Integer updateSelective(T t) {
        return baseMapper.updateByPrimaryKeySelective(t);
    }

    public Integer deleteByIds(ID[] ids) {
		int i = 0;
		if (ids != null) {
			for (ID id : ids) {
				baseMapper.deleteByPrimaryKey(id);
				i++;
			}
		}
		return i;
    }

    public Integer deleteById(ID id) {
        return baseMapper.deleteByPrimaryKey(id);
    }

    public  T insertOrUpdate(T t,ID id){
        if(id == null){
            baseMapper.insert(t);
            return t;
        }

        T t1 = baseMapper.selectByPrimaryKey(id);
        if(t1==null){
            baseMapper.insert(t);
            return t;
        }
        baseMapper.updateByPrimaryKeySelective(t);
        return t;
    }
}
