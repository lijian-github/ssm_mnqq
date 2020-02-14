package socket.handle;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*处理登录信息*/
public class Findqunmen {
	Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	public Findqunmen() {
		// TODO 自动生成的构造函数存根
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
			System.out.println("服务中断！");
			return list;
		}
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return list;
	}
}