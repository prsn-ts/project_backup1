package test.util;
/*
 *  [Data Base Connection Pool Bean ]
 *  
 *  �Ʒ��� Ŭ������ ���� �Ϸ���
 *  
 *  1. Servers/context.xml ������ DB ���� ������ �־�� �Ѵ�.
 *  
 *  <Resource name="jdbc/myoracle" auth="Container"
              type="javax.sql.DataSource" driverClassName="oracle.jdbc.OracleDriver"
              url="jdbc:oracle:thin:@localhost:1521:xe"
              username="scott" password="tiger" maxTotal="20" maxIdle="10"
              maxWaitMillis="-1"/>
    2. ������Ʈ�� WEB-INF/web.xml ������ �Ʒ��� ������ �־�� �Ѵ�.
    <resource-ref>
		<description>Oracle Datasource example</description>
		<res-ref-name>jdbc/myoracle</res-ref-name>
		<res-type>javax.sql.DataSource</res-type>
		<res-auth>Container</res-auth>
	</resource-ref>
	
	3.  WEB-INF/lib/ ������ ojdbc6.jar ������ �־ ���̺귯���� ����� �غ� �ؾ��Ѵ�.
	
	���� 3���� ������ �� �Ŀ�
	
	- new DbcpBean().getConn() �޼ҵ带 ȣ���ϸ� Connection Pool ����
	Connection ��ü�� �ϳ� ���ϵȴ�.
	
	- Dao ���� Connection ��ü�� ����� �� .close() �޼ҵ带 ȣ���ϸ�
	�ڵ����� Connection Pool �� Connection ��ü�� ��ȯ�ȴ�.
 */

import java.sql.Connection;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DbcpBean {
	//�ʵ�
	private Connection conn;
	//������
	public DbcpBean() {
		//Connection ��ü�� �������� ���ͼ� �ʵ忡 �����ϴ� �۾��� �Ѵ�.
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			// jdbc/myoracle �̶�� �̸��� DataSource(Connection Pool)����
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
			// Connection ��ü�� �ϳ� ������ �´�.
			conn = ds.getConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//Connection ��ü�� �������ִ� �޼ҵ�
	public Connection getConn() {
		return conn;
	}
}
