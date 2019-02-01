package com.dom4j;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class PlanWriter {
	public void writeXml(){
		String file="D:/work/MyJAVA2/XML/src/test.xml";
		SAXReader reader=new SAXReader();
		try {
			Document document=reader.read(file);
			Element root=document.getRootElement();
			Element course=root.addElement("course");
			course.addAttribute("id", "4");
			Element name=course.addElement("course-name");
			name.setText("数据结构");
			course.addElement("class-hour").setText("40");
			course.addElement("exam-form").setText("上机考试");
			Writer writer=new OutputStreamWriter(new FileOutputStream(file),"UTF-8");
			document.write(writer);
			writer.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PlanWriter test=new PlanWriter();
		test.writeXml();

	}

}
