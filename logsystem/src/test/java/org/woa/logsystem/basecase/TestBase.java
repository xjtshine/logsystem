package org.woa.logsystem.basecase;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations={"classpath*:applicationContext.xml"})
@TransactionConfiguration(transactionManager="transactionManager",defaultRollback=true)
public abstract class TestBase extends AbstractJUnit4SpringContextTests{

}
