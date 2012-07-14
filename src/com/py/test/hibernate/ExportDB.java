package com.py.test.hibernate;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class ExportDB {

	public static void main(String[] args) {
		
		// 读取 hibername.cfg.xml 文件
		Configuration cfg = new Configuration().configure();
		
		SchemaExport export = new SchemaExport(cfg);
		
		export.create(true, true);

	}

}
