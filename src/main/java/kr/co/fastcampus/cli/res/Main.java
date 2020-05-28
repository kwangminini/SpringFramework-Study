package kr.co.fastcampus.cli.res;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
//        ClassPathResource resource = new ClassPathResource("dao.xml");
        //System.out.println(resource.exists()); //리소스 존재하는지 테스트 존재 = true
//        byte[] bytes= FileCopyUtils.copyToByteArray(resource.getInputStream());
//        String daoStr = new String(bytes);
//        System.out.println(daoStr);
//        Resource resource = new UrlResource("file:/Users/kwangmin/IdeaProjects/springFramework/src/main/resources/dao.xml"); //false 절대경로를 써야함
       // Resource resource = new FileSystemResource("/Users/kwangmin/IdeaProjects/springFramework/src/main/resources/dao.xml");
        //System.out.println(resource.exists());

//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
        //Resource resource = context.getResource("dao.xml");
        //Resource resource = context.getResource("classpath:dao.xml"); //from classpath
//        Resource resource = context.getResource("file:/Users/kwangmin/IdeaProjects/springFramework/src/main/resources/dao.xml"); //from FileUrlResource
//        String daoStr = String.valueOf(resource.getInputStream().read());
//        System.out.println(daoStr);
//        context.close();
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ResourceExample.class);
        context.refresh();
        ResourceExample re = context.getBean(ResourceExample.class);
        re.print();
        context.close();
    }
}
