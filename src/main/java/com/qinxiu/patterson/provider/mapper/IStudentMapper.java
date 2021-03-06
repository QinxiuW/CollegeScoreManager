package com.qinxiu.patterson.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qinxiu.patterson.provider.domain.Student;
import java.util.List;


public interface IStudentMapper extends BaseMapper<Student> {

  Student selectLinkById(Long id);

  List<Student> selectAll();
}
