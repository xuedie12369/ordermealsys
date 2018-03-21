package snippet;

public class Snippet {
	<table schema="DB2ADMIN" tableName="product" domainObjectName="Product" enableCountByExample="false" enableUpdateByExample="false" enableDeleteByExample="false" enableSelectByExample="false" selectByExampleQueryId="false">
				如果设置为true，生成的model类会直接使用column本身的名字，而不会再使用驼峰命名方法，比如BORN_DATE，生成的属性名字就是BORN_DATE,而不会是bornDate
				<property name="useActualColumnNames" value="false" />
					sqlStatement自动获取生成的主键
				<generatedKey column="id" sqlStatement="JDBC" identity="true" />
				
				
				
	 		<columnOverride column="LONG_VARCHAR_FIELD" jdbcType="VARCHAR" />
			</table>
}

