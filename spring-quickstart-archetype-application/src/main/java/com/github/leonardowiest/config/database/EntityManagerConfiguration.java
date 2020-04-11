package com.github.leonardowiest.config.database;

import static com.github.util.constants.GlobalConstants.DATASOURCE_PROPERTIES;
import static com.github.util.constants.GlobalConstants.DB_CONFIG_PREFIX;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.validation.annotation.Validated;

@Configuration
public class EntityManagerConfiguration {

	@Value("${" + DB_CONFIG_PREFIX + ".username:root}")
	private String userName;

	@Value("${" + DB_CONFIG_PREFIX + ".password:root")
	private String password;

	@Value("${" + DB_CONFIG_PREFIX + ".jpa.hibernate.dialect}")
	private String hibernateDialect;

	@Value("${" + DB_CONFIG_PREFIX + ".jpa.hibernate.ddl-auto:none}")
	private String hibernateDdlAuto;

	@Value("${" + DB_CONFIG_PREFIX + ".jpa.hibernate.show_sql:false}")
	private String hibernateShowSql;

	@Value("${" + DB_CONFIG_PREFIX + ".jpa.hibernate.use_sql_comments:true}")
	private String hibernateUseSqlComments;

	@Value("${" + DB_CONFIG_PREFIX + ".jpa.hibernate.format_sql:true}")
	private String hibernateFormatSql;

	@Value("${" + DB_CONFIG_PREFIX + ".jpa.hibernate.enable_lazy_load_no_trans:true}")
	private String hibernateEnableLazyLoadNoTransactional;

	@Value("${" + DB_CONFIG_PREFIX + ".jpa.hibernate.temp.use_jdbc_metadata_defaults:false}")
	private String hibernateUseJdbcMetaDataDefaults;

	@Value("${" + DB_CONFIG_PREFIX + ".jpa.hibernate.query.plan_cache_max_size:16}")
	private String hibernateQueryPlanCacheMaxSize;

	@Value("${" + DB_CONFIG_PREFIX + ".jpa.hibernate.query.plan_parameter_metadata_max_size:128}")
	private String hibernateQueryPlanParameterMetadataMaxSize;

	@Value("${" + DB_CONFIG_PREFIX + ".jpa.hibernate.query.plan_cache_max_soft_references:1024}")
	private String hibernateQueryPlanCacheMaxSoftReferences;

	@Value("${" + DB_CONFIG_PREFIX + ".jpa.hibernate.query.plan_cache_max_strong_references:64}")
	private String hibernateQueryPlanCacheMaxStrongReferences;

	@ConfigurationProperties(prefix = DB_CONFIG_PREFIX)
	@Validated
	@Primary
	@Bean(name = DATASOURCE_PROPERTIES)
	public DataSourceProperties dataSourceProperties() {

		return new DataSourceProperties();
	}
}
