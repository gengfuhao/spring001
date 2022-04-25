package ltd.newbee.mall.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ltd.newbee.mall.newbeemall.dao.GoodsDetailMapper;
import ltd.newbee.mall.newbeemall.dao.RunRecommendApiHistoryMapper;
import ltd.newbee.mall.newbeemall.entity.RunRecommendApiHistory;
import ltd.newbee.mall.newbeemall.service.CheckUserExistsService;
import ltd.newbee.mall.newbeemall.service.GoodsDetailService;
import ltd.newbee.mall.newbeemall.service.NewBeeMallCategoryService;
import ltd.newbee.mall.newbeemall.service.NewBeeMallIndexConfigService;
import ltd.newbee.mall.newbeemall.service.RunRecommendApiHistoryService;
import ltd.newbee.mall.newbeemall.util.Result;
import ltd.newbee.mall.newbeemall.util.ResultGenerator;

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
//		if (userId != null) {
			return ResultGenerator.genSuccessResult(checkUserExistsService.checkUserExists(userId));
//		} else
//			{
//			Result result = new Result();
//			result.setMessage("该用户不存在");
//			return  result;
//			}
	}
	
	@Resource
	 RunRecommendApiHistoryService runRecommendApiHistoryService;
	@Resource
	RunRecommendApiHistoryMapper runRecommendApiHistoryMapper;
	@GetMapping("/runRecommendApi")
 	@ResponseBody
 	public Result runRecommendApi() {
 		List<RunRecommendApiHistory> list = runRecommendApiHistoryService.selectRecCat();
 		for(RunRecommendApiHistory r : list) {
 			r.setRunDate(new Date());
 		}
 		int count = runRecommendApiHistoryService.insertRunRecommendApiHistory(list);

 		if (count == 0) {
 			return ResultGenerator.genFailResult("failed");
 		} else {
 			return ResultGenerator.genSuccessResult("success");
 		}

 	}
	@Resource GoodsDetailMapper  goodsDetailMapper;
	@Resource GoodsDetailService goodsDetailService;
	@GetMapping("/detail")
	@ResponseBody
	public Result detail000(int goodsId) {

			return ResultGenerator.genSuccessResult(goodsDetailService.getdetail(goodsId));

	}

}