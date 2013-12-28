package com.vteba.home.search.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vteba.web.action.BaseAction;

/**
 * 站内搜索控制器。
 * @author yinlei
 * date 2013-8-24 上午10:42:49
 */
@Controller
public class SearchAction extends BaseAction {
	//private Logger logger = LoggerFactory.getLogger(SearchAction.class);
	
	/**
	 * 站内搜索。
	 * @return 搜索结果视图
	 * @author yinlei
	 * date 2013-8-24 下午12:01:26
	 */
	@RequestMapping("/search")
	public String search() {
		
		return "searchList";
	}
}
