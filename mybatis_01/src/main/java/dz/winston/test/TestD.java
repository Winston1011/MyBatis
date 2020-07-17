package dz.winston.test;

import dz.winston.entity.Account;
import dz.winston.entity.Student;
import dz.winston.repository.AccountRepository;
import dz.winston.repository.StudentRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;


public class TestD {

    @Test
    public void save(){
        String resource = "mybatis_config.xml";
        //加载myBatis配置文件
        InputStream inputStream = TestD.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        String statement = "dz.winston.mapper.AccountMapper.save";
        Account account = new Account(3L,"winston11","110150",33);
        sqlSession.insert(statement,account);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void save1(){
        String resource = "mybatis_config.xml";
        InputStream inputStream = TestD.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取实现接口的代理对象
        AccountRepository accountRepository = sqlSession.getMapper(AccountRepository.class);
        Account account = new Account(4L,"winston","nnnnnn",22);
        int i = accountRepository.save(account);
        System.out.println(i);
        List<Account> list = accountRepository.findAll();
        for (Account account2:list){
            System.out.println(account2);
        }
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void findall(){
        String resource = "mybatis_config.xml";
        InputStream inputStream = TestD.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取实现接口的代理对象
        AccountRepository accountRepository = sqlSession.getMapper(AccountRepository.class);
        List<Account> list = accountRepository.findAll();
        for (Account account:list){
            System.out.println(account);
        }
        sqlSession.close();
    }

    @Test
    public void findbyid(){
        String resource = "mybatis_config.xml";
        InputStream inputStream = TestD.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取实现接口的代理对象
        AccountRepository accountRepository = sqlSession.getMapper(AccountRepository.class);
        Account account = accountRepository.findById(2);
        System.out.println(account);
        sqlSession.close();
    }

    @Test
    public void delete(){
        String resource = "mybatis_config.xml";
        InputStream inputStream = TestD.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取实现接口的代理对象
        AccountRepository accountRepository = sqlSession.getMapper(AccountRepository.class);
        int t = accountRepository.deleteById(5);
        System.out.println(t);
        List<Account> list = accountRepository.findAll();
        for (Account account:list){
            System.out.println(account);
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void update(){
        String resource = "mybatis_config.xml";
        InputStream inputStream = TestD.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取实现接口的代理对象
        AccountRepository accountRepository = sqlSession.getMapper(AccountRepository.class);
        Account account = accountRepository.findById(2);
        account.setUsername("qwew");
        account.setPassword("gdfgf1");
        account.setAge(15);
        int t = accountRepository.update(account);
        if(t==1){
            System.out.println("修改成功！");
        }
        List<Account> list = accountRepository.findAll();
        for (Account account1:list){
            System.out.println(account1);
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void findbyname(){
        String resource = "mybatis_config.xml";
        InputStream inputStream = TestD.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取实现接口的代理对象
        AccountRepository accountRepository = sqlSession.getMapper(AccountRepository.class);
        Account account = accountRepository.findByName("winston");
        System.out.println(account);
        sqlSession.close();
    }

    @Test
    public void findbynameandage(){
        String resource = "mybatis_config.xml";
        InputStream inputStream = TestD.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取实现接口的代理对象
        AccountRepository accountRepository = sqlSession.getMapper(AccountRepository.class);
        List<Account> list = accountRepository.findByNameAndAge("dd222",55);
        for(Account account:list) {
            System.out.println(account);
        }
        sqlSession.close();
    }

    @Test
    public void count(){
        String resource = "mybatis_config.xml";
        InputStream inputStream = TestD.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取实现接口的代理对象
        AccountRepository accountRepository = sqlSession.getMapper(AccountRepository.class);
        int a = accountRepository.count();
        System.out.println(a);
        sqlSession.close();
    }

    @Test
    public void findnamebyid(){
        String resource = "mybatis_config.xml";
        InputStream inputStream = TestD.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取实现接口的代理对象
        AccountRepository accountRepository = sqlSession.getMapper(AccountRepository.class);
        String a = accountRepository.findNameById(2);
        System.out.println(a);
        sqlSession.close();
    }

    @Test
    public void findById(){
        String resource = "mybatis_config.xml";
        InputStream inputStream = TestD.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取实现接口的代理对象
        StudentRepository studentRepository = sqlSession.getMapper(StudentRepository.class);
        Student student= studentRepository.findById(1);
        System.out.println(student);
        sqlSession.close();
    }
}
