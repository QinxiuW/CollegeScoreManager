package com.qinxiu.patterson.provider.service.tests;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

import com.qinxiu.patterson.provider.domain.Course;
import com.qinxiu.patterson.provider.domain.Student;
import com.qinxiu.patterson.provider.mapper.IStudentMapper;
import com.qinxiu.patterson.provider.service.StudentService;
import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

  @Mock
  IStudentMapper studentMapper;

  @Mock
  Student mockStudent;

  @InjectMocks
  StudentService studentService;

  @Test
  void insert_success() {
    // Arrange
    Mockito.when(studentMapper.insert(any(Student.class))).thenReturn(1);

    // Act
    var result = studentService.insert(mockStudent);

    // Assert
    Assertions.assertEquals(1, result);
    Mockito.verify(studentMapper, Mockito.times(1)).insert(any(Student.class));
  }

  @Test
  void insert_failed_by_empty_param() {
    // Arrange

    // Act
    var result = studentService.insert(null);

    // Assert
    Assertions.assertEquals(0, result);
    Mockito.verify(studentMapper, Mockito.times(0)).insert(any(Student.class));
  }

  @Test
  void insert_failed_by_return_value() {
    // Arrange
    Mockito.when(studentMapper.insert(any(Student.class))).thenReturn(0);

    // Act
    var result = studentService.insert(mockStudent);

    // Assert
    Assertions.assertEquals(0, result);
    Mockito.verify(studentMapper, Mockito.times(1)).insert(any(Student.class));
  }

  @Test
  void update_success() {
    // Arrange
    Mockito.when(studentMapper.selectLinkById(anyLong())).thenReturn(mockStudent);
    Mockito.when(studentMapper.updateById(any(Student.class))).thenReturn(1);

    // Act
    var result = studentService.update(mockStudent);

    // Assert
    Assertions.assertEquals(1, result);
    Mockito.verify(studentMapper, Mockito.times(1)).selectLinkById(anyLong());
    Mockito.verify(studentMapper, Mockito.times(1)).updateById(any(Student.class));
  }

  @Test
  void update_failed_by_empty_param() {
    // Arrange

    // Act
    var result = studentService.update(null);

    // Assert
    Assertions.assertEquals(0, result);
    Mockito.verify(studentMapper, Mockito.times(0)).selectLinkById(anyLong());
    Mockito.verify(studentMapper, Mockito.times(0)).updateById(any(Student.class));
  }

  @Test
  void update_failed_by_no_course_found() {
    // Arrange
    Mockito.when(studentMapper.selectLinkById(anyLong())).thenReturn(null);

    // Act
    var result = studentService.update(mockStudent);

    // Assert
    Assertions.assertEquals(0, result);
    Mockito.verify(studentMapper, Mockito.times(1)).selectLinkById(anyLong());
    Mockito.verify(studentMapper, Mockito.times(0)).updateById(any(Student.class));
  }

  @Test
  void update_failed_by_return_value() {
    // Arrange
    Mockito.when(studentMapper.selectLinkById(anyLong())).thenReturn(mockStudent);
    Mockito.when(studentMapper.updateById(any(Student.class))).thenReturn(0);

    // Act
    var result = studentService.update(mockStudent);

    // Assert
    Assertions.assertEquals(0, result);
    Mockito.verify(studentMapper, Mockito.times(1)).selectLinkById(anyLong());
    Mockito.verify(studentMapper, Mockito.times(1)).updateById(any(Student.class));
  }

  @Test
  void delete_success(){
    // Arrange
    Mockito.when(studentMapper.deleteById(anyLong())).thenReturn(1);

    // Act
    var result = studentService.delete(mockStudent.getId());

    // Assert
    Assertions.assertEquals(1, result);
    Mockito.verify(studentMapper,Mockito.times(1)).deleteById(anyLong());
  }

  @Test
  void delete_failed_by_empty_param(){
    // Arrange

    // Act
    var result = studentService.delete(null);

    // Assert
    Assertions.assertEquals(0, result);
    Mockito.verify(studentMapper,Mockito.times(0)).deleteById(anyLong());
  }

  @Test
  void delete_failed_by_return_value(){
    // Arrange
    Mockito.when(studentMapper.deleteById(anyLong())).thenReturn(0);

    // Act
    var result = studentService.delete(mockStudent.getId());

    // Assert
    Assertions.assertEquals(0, result);
    Mockito.verify(studentMapper,Mockito.times(1)).deleteById(anyLong());
  }

  @Test
  void get_success(){
    // Arrange
    Mockito.when(studentMapper.selectLinkById(anyLong())).thenReturn(mockStudent);

    // Act
    var result = studentService.get(anyLong());

    // Assert
    Assertions.assertEquals(mockStudent, result);
    Mockito.verify(studentMapper,Mockito.times(1)).selectLinkById(anyLong());
  }

  @Test
  void get_failed_by_empty_param(){
    // Arrange

    // Act
    var result = studentService.get(null);

    // Assert
    Assertions.assertNull(result);
    Mockito.verify(studentMapper,Mockito.times(0)).selectLinkById(anyLong());
  }

  @Test
  void get_failed_by_return_value(){
    // Arrange
    Mockito.when(studentMapper.selectLinkById(anyLong())).thenReturn(null);

    // Act
    var result = studentService.get(anyLong());

    // Assert
    Assertions.assertNull(result);
    Mockito.verify(studentMapper,Mockito.times(1)).selectLinkById(anyLong());
  }

  @Test
  void getAll_success(){
    // Arrange
    var studentList = new ArrayList<Student>() {{add(mockStudent);}};
    Mockito.when(studentMapper.selectAll()).thenReturn(studentList);

    // Act
    var result = studentService.getAll();

    // Assert
    Assertions.assertEquals(studentList, result);
    Mockito.verify(studentMapper,Mockito.times(1)).selectAll();
  }

  @Test
  void getAll_failed_by_return_value(){
    // Arrange
    Mockito.when(studentMapper.selectAll()).thenReturn(null);

    // Act
    var result = studentService.getAll();

    // Assert
    Assertions.assertNull(result);
    Mockito.verify(studentMapper,Mockito.times(1)).selectAll();
  }
}
