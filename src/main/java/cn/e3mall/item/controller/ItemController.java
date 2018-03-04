package cn.e3mall.item.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.e3mall.common.utils.E3Result;
import cn.e3mall.item.pojo.Item;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemDesc;
import cn.e3mall.service.ItemService;

@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/item/{itemId}")
	public String showItemInfo(@PathVariable Long itemId, Model model){
		TbItem tbItem = itemService.getItemById(itemId);
		Item item = new Item(tbItem);
		model.addAttribute("item", item);
		
		E3Result e3Result = itemService.getItemDescById(itemId);
		TbItemDesc itemDesc = (TbItemDesc) e3Result.getData();
		model.addAttribute("itemDesc", itemDesc);
		return "item";
	}
}
