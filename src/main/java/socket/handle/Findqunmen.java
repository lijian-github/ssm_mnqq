package socket.handle;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*�����¼��Ϣ*/
public class Findqunmen {
	Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	public Findqunmen() {
		// TODO �Զ����ɵĹ��캯�����
		connection=new HandleToLineJDBC().GetJDBCConnection();
	}
	public List<Integer> Query(int qid) {
		String sql="select id from qunmen where qid=?";
		List<Integer> list=new ArrayList<Integer>();
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, qid);
			resultSet=preparedStatement.executeQuery();
			while (resultSet.next()){
				list.add(resultSet.getInt("qid"));
			}
		}		catch (SQLException e) {
			System.out.println("�����жϣ�");
			return list;
		}
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return list;
	}
}