package com.sandytech.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.sandytech.model.StudentCsv;
import com.sandytech.model.StudentJdbc;
import com.sandytech.model.StudentJson;
import com.sandytech.postgresql.entity.Student;

@Component
public class FirstItemProcessor implements ItemProcessor<Student, com.sandytech.mysql.entity.Student> {

	@Override
	public com.sandytech.mysql.entity.Student process(Student item) throws Exception {
		
		System.out.println(item.getId());
		
		com.sandytech.mysql.entity.Student student = new 
				com.sandytech.mysql.entity.Student();
		
		student.setId(item.getId());
		student.setFirstName(item.getFirstName());
		student.setLastName(item.getLastName());
		student.setEmail(item.getEmail());
		student.setDeptId(item.getDeptId());
		student.setIsActive(item.getIsActive() != null ? 
				Boolean.valueOf(item.getIsActive()) : false);
		
		return student;
		
	}

}
