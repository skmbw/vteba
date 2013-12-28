package com.vteba.common.service;

import java.util.List;

import com.vteba.common.model.ModuleMenu;
import com.vteba.service.generic.IGenericService;
import com.vteba.user.model.EmpUser;

/**
 * 菜单service接口
 * @author yinlei 
 * date 2012-6-6 下午12:52:29
 */
public interface IModuleMenuService extends IGenericService<ModuleMenu, String> {
	
	/**
	 * 返回菜单数据
	 * @return List<ModuleMenu>
	 * @author yinlei
	 * @date 2012-6-6 下午9:58:02
	 */
	public List<ModuleMenu> getModuleMenuList(EmpUser user);
}
