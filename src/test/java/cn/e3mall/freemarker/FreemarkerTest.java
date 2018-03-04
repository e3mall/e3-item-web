package cn.e3mall.freemarker;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class FreemarkerTest {
	// @Test
	/*public void testFreemarker() throws Exception{
		//第一步：创建一个Configuration对象，直接new一个对象。构造方法的参数就是freemarker对于的版本号。
		Configuration configuration = new Configuration(Configuration.getVersion());
		//第二步：设置模板文件所在的路径。
		configuration.setDirectoryForTemplateLoading(new File("E:/workspace/e3-item-web/src/main/webapp/WEB-INF/ftl"));
		//第三步：设置模板文件使用的字符集。一般就是utf-8.
		configuration.setDefaultEncoding("utf-8");
		//第四步：加载一个模板，创建一个模板对象。
		Template template = configuration.getTemplate("student.ftl");
		//第五步：创建一个模板使用的数据集，可以是pojo也可以是map。一般是Map。
		Map data = new HashMap();
		Student stu = new Student(1,"xiaom",18);
		data.put("student", stu);
		ArrayList<Student> list = new ArrayList<>();
		list.add(new Student(2,"xiaomei",18));
		list.add(new Student(3,"xiaomei2",19));
		list.add(new Student(4,"xiaome3",20));
		data.put("studentList", list);
		//第六步：创建一个Writer对象，一般创建一FileWriter对象，指定生成的文件名。
		Writer out = new FileWriter(new File("C:/Users/77867/Desktop/freemarker/student.html"));
		//第七步：调用模板对象的process方法输出文件。
		template.process(data, out);
		//第八步：关闭流。
		out.flush();
		out.close();
	}*/

}
