package kr.co.fastcampus.cli.res;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
//        ClassPathResource resource = new ClassPathResource("dao.xml");
        //System.out.println(resource.exists()); //리소스 존재하는지 테스트 존재 = true
//        byte[] bytes= FileCopyUtils.copyToByteArray(resource.getInputStream());
//        String daoStr = new String(bytes);
//        System.out.println(daoStr);
//        Resource resource = new UrlResource("file:/Users/kwangmin/IdeaProjects/springFramework/src/main/resources/dao.xml"); //false 절대경로를 써야함
        Resource resource = new FileSystemResource("/Users/kwangmin/IdeaProjects/springFramework/src/main/resources/dao.xml");
        System.out.println(resource.exists());
    }
}
