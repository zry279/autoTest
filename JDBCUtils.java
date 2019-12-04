import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JDBCUtils {
    public static Connection getConnection() throws Exception{
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("env.properties");
        Properties prop = new Properties();
        prop.load(is);
        String user = prop.getProperty("user");
        String password = prop.getProperty("password");
        String url = prop.getProperty("url");
        String driverClass = prop.getProperty("driverClass");
        Class.forName(driverClass);
        Connection conn = DriverManager.getConnection(url,user,password);
        if(conn!=null){
            return conn;
        } else {
            throw new Exception("链接获取失败");
        }
    }

    public static void closeResource(Connection conn, PreparedStatement stmt) throws Exception {
        try{
            if(conn!=null){
                conn.close();
            }
        } catch (Exception e){
            throw new Exception("链接关闭失败"+e);
        }
        try{
            if(stmt!=null){
                stmt.close();
            }
        } catch (Exception e){
            throw new Exception("statement关闭异常");
        }
    }

    /**
     * 获取数据库访问结果
     * @param clazz  表对象
     * @param sql    预编译sql串
     * @param args   限制词 appname,version,invoke_time
     * @param <T>
     * @return
     * @throws Exception
     */
    public static  <T> List<T> getInstance(Class<T> clazz,String sql,Object...args) throws Exception{
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try{
            conn =JDBCUtils.getConnection();
            preparedStatement = conn.prepareStatement(sql);
            for(int i = 0;i<args.length;i++){
                preparedStatement.setObject(i+1,args[i]);

            }
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<T> list = new ArrayList<T>();
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            while (resultSet.next()){
                int colCount = resultSetMetaData.getColumnCount();
                T t =clazz.getDeclaredConstructor().newInstance();
                for(int i=0;i<colCount;i++){
                    Object Value =resultSet.getObject(i+1);
                    Object Name = resultSetMetaData.getColumnLabel(i+1);
                    Field field =clazz.getDeclaredField(Name.toString());
                    field.setAccessible(true);
                    field.set(t,Value);
                }
                list.add(t);

            }
            return list;
        } catch (Exception e){
            throw new Exception("数据库读取失败");
        } finally {
            JDBCUtils.closeResource(conn,preparedStatement);
        }

    }
}
