package ycit.service.imp;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import ycit.excel.WriteExcel;
import ycit.mapper.IDayCookBookMapper;
import ycit.pojo.DayCookBook;
import ycit.service.IDayCookBookService;
//每日食谱接口的实现类
@Service("dayCookBookService")
public class DayCookBookServiceImpl implements IDayCookBookService{

	@Autowired
	private IDayCookBookMapper dayCookBookMapper;
	@Override
	public PageInfo<DayCookBook> queryAllCookBook(Integer pageNo) {
		PageHelper.startPage(pageNo, 5);
		List<DayCookBook> list = dayCookBookMapper.queryAllCookBook();
		PageInfo<DayCookBook> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}
	@Override
	public boolean insertCookBook(DayCookBook dayCookBook) {
		int row = dayCookBookMapper.insertCookBook(dayCookBook);
		return row==1?true:false;
	}
	@Override
	public PageInfo<DayCookBook> queryBookCookByHtmedType(String htmedType,Integer pageNo) {
		PageHelper.startPage(pageNo, 10);
		List<DayCookBook> list = dayCookBookMapper.queryBookCookByHtmedType(htmedType);
		PageInfo<DayCookBook> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}
	@Override
	public InputStream getInputStream(){
		String[] title=new String[]{"早中晚餐","主食","蔬菜","肉类","水果","吃水果时间","喝酒","具体一天"};
		List<DayCookBook> pList=dayCookBookMapper.queryAllCookBook();
		List<Object[]> dataList=new ArrayList<Object[]>();	
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat s1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (int i = 0; i < pList.size(); i++) {
			Object[] obj=new Object[8];
			obj[0]=pList.get(i).getHtmedType();
			obj[1]=pList.get(i).getStapleFood();
			obj[2]=pList.get(i).getVegetables();
			obj[3]=pList.get(i).getMeat();
			obj[4]=pList.get(i).getFruit();
			obj[5]=s1.format(pList.get(i).getFruitTime());
			obj[6]=pList.get(i).getDrinking();
			obj[7]=s.format(pList.get(i).getDayTime());
			dataList.add(obj);
		}
		WriteExcel ex=new WriteExcel(title, dataList);
		InputStream in = null;
        try {
			in = ex.export();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return in;
	}
	@Override
	public boolean deleteDayCookBookById(Integer id) {
        int row = dayCookBookMapper.deleteDayCookBookById(id);
		return row==1?true:false;
	}

}
