package ycit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ycit.dto.Page;
import ycit.pojo.PhysicalExamination;

public interface IPhysicalExaminationMapper {

	List<PhysicalExamination> queryAllPhysicalExamination(Page page);

	int insertPhysicalExamination(PhysicalExamination physicalExamination);

	int deletePhysicalExamination(@Param("id")Integer id);

	List<PhysicalExamination> queryExaminationByUserId(@Param("userId")Integer id);
	
	
   
}