package com.github.leonardowiest.config.database;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.context.annotation.Configuration;

import liquibase.Contexts;
import liquibase.LabelExpression;
import liquibase.Liquibase;
import liquibase.change.DatabaseChange;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.integration.spring.SpringLiquibase;
import liquibase.integration.spring.SpringLiquibase.SpringResourceOpener;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Leonardo Wiest
 *
 */
@ConditionalOnClass({ SpringLiquibase.class, DatabaseChange.class })
@AutoConfigureAfter({ DataSourceAutoConfiguration.class })
@ConditionalOnMissingBean({ LiquibaseAutoConfiguration.class })
@Slf4j
@Configuration
public class LiquibaseConfiguration implements InitializingBean {

	@Autowired
	private DataSource dataSource;

	@Value("${spring.liquibase.change-log}")
	private String liquibaseChangelog;

	@PostConstruct
	public void initialize() throws SQLException, LiquibaseException {

		log.info("Initialize LiquibaseCustomConfiguration bean...");

		if (isLatestVersion()) {

			log.info("No update required");

			return;
		}

		log.info("Upgrading to a New Version");

		try (Connection connection = dataSource.getConnection()) {

			SpringResourceOpener resourceAccessor = null;//new SpringResourceOpener(liquibaseChangelog);

			Database database = DatabaseFactory.getInstance()
					.findCorrectDatabaseImplementation(new JdbcConnection(connection));

			Liquibase liquibase = new Liquibase(liquibaseChangelog, resourceAccessor, database);

			liquibase.update(new Contexts(), new LabelExpression());
		}

	}

	private Boolean isLatestVersion() {
		// TODO Auto-generated method stub
		return Boolean.FALSE;
	}

	@Override
	public void afterPropertiesSet() throws Exception {

		log.info("teste...");

	}
}
