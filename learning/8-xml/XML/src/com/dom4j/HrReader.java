package com.dom4j;


import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class HrReader {
	
	public void readXml(){
		String file="D:/work/MyJAVA2/XML/src/hr.xml";
		//SAXReader类是读取XML文件的核心类，用于将XML解析后以树的形式保存在内存中
		SAXReader reader=new SAXReader();
		try {
			Document document=reader.read(file);
			//获取XML文档的根节点，即hr标签
			Element root=document.getRootElement();
			//elements方法用于获取指定的标签集合
			List<Element> employees=root.elements("employee");
			for(Element employee:employees)
			{
				//element方法用于获取唯一的子节点对象
				Element name =employee.element("name");
				String empName=name.getText();
				System.out.println(empName);
				System.out.println(employee.elementText("age"));
				System.out.println(employee.elementText("salary"));
				Element department=employee.element("department");
				System.out.println(department.element("dname").getText());
				System.out.println(department.elementText("address"));
				Attribute att=employee.attribute("no");
				System.out.println(att.getText());
				
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HrReader reader=new HrReader();
		reader.readXml();

	}

}
