package com.zhongz.rental.common.utils;

import com.zhongz.rental.result.base.Result;

import java.util.ArrayList;
import java.util.List;

public class PageUtils {

    public static<T> Result<T> page(Integer pageNum, Integer pageSize, List<T> data) {
        if(data == null || data.size() == 0 || pageNum == null || pageSize == null) {
            return new Result<>(pageNum,pageSize,0,new ArrayList<>());
        }
        int total = data.size();
        int fromIndex = (pageNum - 1) * pageSize;
        if (fromIndex >= total) {
            return new Result<>(pageNum,pageSize,total,new ArrayList<>());//解决空页中分页信息错误的bug
        }
        if(fromIndex < 0){
            return new Result<>(pageNum,pageSize,total,new ArrayList<>());
        }
        int toIndex = pageNum * pageSize;
        if (toIndex > total) {
            toIndex = total;
        }
        //data.subList(fromIndex, toIndex)将无法序列化，因为从subList()返回的子列表对象未实现无参构造函数。
        return new Result<>(pageNum,pageSize,total,new ArrayList<>(data.subList(fromIndex, toIndex)));
    }
}
