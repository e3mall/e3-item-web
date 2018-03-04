package cn.e3mall.item.listener;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import cn.e3mall.common.utils.E3Result;
import cn.e3mall.item.pojo.Item;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemDesc;
import cn.e3mall.service.ItemService;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class HtmlGemListener implements MessageListener {
	@Value("${HTML_GEN_PATH}")
	private String HTML_GEN_PATH;
	@Autowired
	private ItemService itemService;
	@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer;
	
	@Override
	public void onMessage(Message message) {
		try{
			TextMessage textMessage = (TextMessage) message;
			String itemId = null;
			// 取消息的内容
			itemId = textMessage.getText();
			System.out.println(itemId);
			TbItem tbItem = itemService.getItemById(Long.valueOf(itemId));
			System.out.println(tbItem.getTitle()+"h");
			Item item = new Item(tbItem);
			// 获取商品的描述
			E3Result e3Result = itemService.getItemDescById(Long.valueOf(itemId));
			TbItemDesc itemDesc = (TbItemDesc) e3Result.getData();
			System.out.println(itemDesc.getItemDesc());
			//最后使用freemarker创建静态页面
			//创建数据集 把商品信息封装
			Map data = new HashMap();
			data.put("item", item);
			data.put("itemDesc", itemDesc);
			//创建模板文件
			Configuration configuration = freeMarkerConfigurer.getConfiguration();
			Template template = configuration.getTemplate("item.ftl");
			//创建一个Writer对象，一般创建一FileWriter对象，指定生成的文件名。
			System.out.println(HTML_GEN_PATH+itemId+".html");
			Writer out = new FileWriter(new File(HTML_GEN_PATH+itemId+".html"));
			//第七步：调用模板对象的process方法输出文件。
			template.process(data, out);
			//第八步：关闭流。
			out.flush();
			out.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}
