package com.qinxiu.patterson.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qinxiu.patterson.provider.domain.Teacher;
import java.util.List;

public interface ITeacherMapper extends BaseMapper<Teacher> {

  Teacher selectLinkById(Long id);

  List<Teacher> selectAll();

}
