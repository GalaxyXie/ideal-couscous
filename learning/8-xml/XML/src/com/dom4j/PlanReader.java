package com.dom4j;

import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class PlanReader {

	public void readXml(){
		String file="D:/work/MyJAVA2/XML/src/test.xml";
		//SAXReader类是读取XML文件的核心类，用于将XML解析后以树的形式保存在内存中
		SAXReader reader=new SAXReader();
		try {
			Document document=reader.read(file);
			//获取XML文档的根节点，即hr标签
			Element root=document.getRootElement();
			//elements方法用于获取指定的标签集合
			List<Element> courses=root.elements("course");
			for(Element course:courses)
			{
				//element方法用于获取唯一的子节点对象
				Element name =course.element("course-name");
				String courseName=name.getText();
				System.out.println(courseName);
				System.out.println(course.elementText("class-hour"));
				System.out.println(course.elementText("exam-form"));
				Attribute att=course.attribute("id");
				System.out.println(att.getText());
				
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PlanReader test=new PlanReader();
		test.readXml();
	}

}
