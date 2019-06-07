package ycit.service;

import java.util.List;

import ycit.dto.MemHomeSickness;
import ycit.pojo.HomeSickness;
import ycit.pojo.Member;

public interface IHomeSicknessService {

	List<HomeSickness> queryHomeSickness(Integer id);

	boolean insertHomeSickness(MemHomeSickness memHomeSickness,HomeSickness homeSickness,Member member);

	boolean deleteHomeSickness(Integer id);

}
