package kr.or.yi.mybatis_dev_ljm.jdbc;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.DataSourceFactory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3p0DataSourecFactory implements DataSourceFactory {
	private ComboPooledDataSource dataSource = null;

	@Override
	public void setProperties(Properties properties) {
		this.dataSource = new ComboPooledDataSource();
		this.dataSource.setPassword(properties.getProperty("password"));
		this.dataSource.setJdbcUrl(properties.getProperty("url"));
		this.dataSource.setUser(properties.getProperty("username"));
		try {
			this.dataSource.setDriverClass(properties.getProperty("driver"));
		} catch (PropertyVetoException e) {
		}

	}

	@Override
	public DataSource getDataSource() {
		return dataSource;
	}

}
