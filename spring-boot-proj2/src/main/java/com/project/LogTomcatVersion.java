package com.project;

import javax.annotation.PostConstruct;

import org.apache.catalina.startup.Tomcat;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(Tomcat.class)
public class LogTomcatVersion {

	private static Log logger = LogFactory.getLog(LogTomcatVersion.class);
	
	@PostConstruct
	public void init() {
		logger.info("\n\n Tomcat version " + Tomcat.class.getPackage().getImplementationVersion());
	}
}
