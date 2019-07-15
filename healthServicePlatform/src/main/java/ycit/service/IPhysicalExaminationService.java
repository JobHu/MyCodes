package ycit.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import ycit.dto.Page;
import ycit.pojo.PhysicalExamination;

//个人体检数据的接口
public interface IPhysicalExaminationService {

	PageInfo<PhysicalExamination> queryAllPhysicalExamination(Page page);

	boolean insertPhysicalExamination(PhysicalExamination physicalExamination);

	boolean deletePhysicalExamination(Integer id);

	List<PhysicalExamination> queryExaminationByUserId(Integer id);

}
