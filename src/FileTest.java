import java.io.File;
import java.io.IOException;

public class FileTest {
    public static void main(String[] args) throws IOException {
        File file = new File("newFile.txt"); // 해당 위치에 파일을 생성한다. 단 생성 시 디렉터리는 있어야 한다.
        file.createNewFile();

        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
        System.out.println(file.getName());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getPath());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        
        // 결과
        // true
        // false
        // newFile.txt
        // /home/leetaesung/JavaProjects/JAVA_other-inputoutput-classes/newFile.txt
        // newFile.txt
        // true
        // true

        file.delete(); // 파일 삭제
    }
}
