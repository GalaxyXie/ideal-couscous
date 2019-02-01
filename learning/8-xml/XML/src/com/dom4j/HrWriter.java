package com.dom4j;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class HrWriter {
	public void writeXml(){
		String file="D:/work/MyJAVA2/XML/src/hr.xml";
		SAXReader reader=new SAXReader();
		try {
			Document document=reader.read(file);
			Element root=document.getRootElement();
			Element employee=root.addElement("employee");
			employee.addAttribute("no", "3311");
			Element name=employee.addElement("name");
			name.setText("李铁柱");
			employee.addElement("age").setText("25");
			employee.addElement("salary").setText("3600");
			
			Element department=employee.addElement("department");
			department.addElement("dname").setText("人事部");
			department.addElement("address").setText("XX大厦-B105");
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
		HrWriter hrwriter=new HrWriter();
		hrwriter.writeXml();
	}

}
