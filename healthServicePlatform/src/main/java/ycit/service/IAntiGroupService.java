package ycit.service;

import com.github.pagehelper.PageInfo;

import ycit.dto.Page;
import ycit.pojo.AntiGroup;

public interface IAntiGroupService {

	PageInfo<AntiGroup> queryAllAntiGroup(Page page);

	boolean insertAntiGroup(AntiGroup antiGroup);

	boolean deleteAntiGroup(Integer id);

}
