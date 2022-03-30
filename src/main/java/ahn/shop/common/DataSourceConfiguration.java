package ahn.shop.common;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

import static org.apache.ibatis.type.JdbcType.NULL;

@Slf4j
@Configuration
@MapperScan(basePackages = "ahn.shop.**.mapper.**", sqlSessionFactoryRef = "sqlSessionFactory")
public class DataSourceConfiguration {

    @Bean(name="sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory( DataSource dataSource) throws Exception {

        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setTypeAliasesPackage("ahn/shop/**/dto");
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("mapper/**/*.xml"));

        return factoryBean.getObject();
    }

    @Bean(name="sqlSession")
    public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) {
        sqlSessionFactory.getConfiguration().setMapUnderscoreToCamelCase(true);
        sqlSessionFactory.getConfiguration().setJdbcTypeForNull(NULL);
        sqlSessionFactory.getConfiguration().setCacheEnabled(false);
        sqlSessionFactory.getConfiguration().setLogImpl(org.apache.ibatis.logging.stdout.StdOutImpl.class);
        SqlSessionTemplate sessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
