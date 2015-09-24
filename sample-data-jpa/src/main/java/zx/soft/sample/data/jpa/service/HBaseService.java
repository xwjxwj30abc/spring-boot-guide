package zx.soft.sample.data.jpa.service;

import java.io.IOException;

import org.apache.hadoop.hbase.client.HConnection;
import org.springframework.stereotype.Service;

import zx.soft.hbase.api.core.HBaseClient;
import zx.soft.hbase.api.core.HBaseTable;
import zx.soft.hbase.api.core.HConn;

import com.google.protobuf.ServiceException;

@Service
public class HBaseService {

	private HConnection conn;

	public HBaseService() {
		HBaseClient client = null;
		try {
			client = new HBaseClient();
			if (!client.isTableExists("tableName")) {
				client.createTable("tableName", "cf");
			}
			client.close();
		} catch (IOException | ServiceException e) {
			e.printStackTrace();
		}
		conn = HConn.getHConnection();
	}

	public void write(String rowKey, String qualifier, String value) {
		try {
			HBaseTable table = new HBaseTable(conn, "tableName");
			table.put(rowKey, "cf", qualifier, value);
			table.execute();
			table.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
