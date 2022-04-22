package ltd.newbee.mall.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ltd.newbee.mall.newbeemall.service.NewBeeMallCarouselService;
import ltd.newbee.mall.newbeemall.service.NewBeeMallCategoryService;

import ltd.newbee.mall.newbeemall.service.NewBeeMallIndexConfigService;
import ltd.newbee.mall.newbeemall.util.Result;
import ltd.newbee.mall.newbeemall.util.ResultGenerator;

import ltd.newbee.mall.newbeemall.entity.MallUser;
import ltd.newbee.mall.newbeemall.service.CheckUserExistsService;

@Controller
public class IndexController {
	@Resource
	private NewBeeMallIndexConfigService newBeeMallIndexConfigService;

	@Resource
	private NewBeeMallCategoryService newBeeMallCategoryService;

	@Resource
	private CheckUserExistsService checkUserExistsService;

	// 具体的业务模块流程的控制，controller层主要调用service层里面的接口控制具体的业务流程，控制的配置也要在配置文件中进行
	@GetMapping("/Goodses")
	@ResponseBody
	public Result recommend(int abs) {

		return ResultGenerator.genSuccessResult(newBeeMallIndexConfigService.getConfigGoodsesForIndex(abs, 5));

	}

	@GetMapping("/categories")
	@ResponseBody
	public Result getCategories() {
//result与resuitgenerator 配合输出
		return ResultGenerator.genSuccessResult(newBeeMallCategoryService.getCategoriesForIndex());
	}

//	@GetMapping("/carousel")
//    @ResponseBody 
//    public Result getCarousels(int number) {
////result与resuitgenerator 配合输出
//        return ResultGenerator.genSuccessResult(NewBeeMallCarouselService.getCarouselsForIndex(number));
//    }
//	
//}
//,int number

	@GetMapping("/user")
	@ResponseBody
	public Result user(Long userId) {

		// MallUser user = checkUserExistsService.checkUserExists(userId);
		if (userId != null) {
			return ResultGenerator.genSuccessResult(checkUserExistsService.checkUserExists(userId));
		} else
			{
			Result result = new Result();
			result.setMessage("该用户不存在");
			return  result;
			}
	}

}