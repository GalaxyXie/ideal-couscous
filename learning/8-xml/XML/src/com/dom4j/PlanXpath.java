package com.dom4j;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class PlanXpath {
	public void xpath(String xpathExp){
		String file="D:/work/MyJAVA2/XML/src/test.xml";
		SAXReader reader=new SAXReader();
		try {
			Document document=reader.read(file);
			List<Node>nodes=document.selectNodes(xpathExp);
			for(Node node:nodes){
				Element emp=(Element)node;
				System.out.println(emp.attributeValue("id"));
				System.out.println(emp.elementText("course-name"));
				System.out.println(emp.elementText("class-hour"));
				System.out.println(emp.elementText("exam-form"));
				System.out.println("=====================================");
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PlanXpath testor=new PlanXpath();
		testor.xpath("//course");
		testor.xpath("//course[class-hour<50]");
		testor.xpath("//course[course-name='高等数学']");
		testor.xpath("//course[@id=1]");
		testor.xpath("//course[position()<3]");
	}
}
