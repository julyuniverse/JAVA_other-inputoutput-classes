# 그 외 여러가지 입출력 클래스들

## File 클래스

- 파일 개념을 추상화한 클래스
- 입출력 기능은 없고, 파일의 이름, 읽기 전용들의 속성을 알 수 있음.
- 이를 지원하는 여러 메서드들이 제공됨.

```java
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
```

## RandomAccessFile 클래스

- 입출력 클래스 중 유일하게 파일에 대한 입력과 출력을 동시에 할 수 있는 클래스
- 파일 포인터가 있어서 읽고 쓰는 위치의 이동이 가능함
- 다양한 메서드가 제공됨

```java
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {
    public static void main(String[] args) throws IOException {
        RandomAccessFile rf = new RandomAccessFile("random.txt", "rw");

        rf.writeInt(100);
        System.out.println("pos(position): " + rf.getFilePointer());
        rf.writeDouble(3.14);
        System.out.println("pos(position): " + rf.getFilePointer());
        rf.writeUTF("안녕하세요");
        System.out.println("pos(position): " + rf.getFilePointer());

        rf.seek(0); // 수동으로 포지션을 처음으로 다시 지정해야 아래 readInt()나 readDouble()가 실행된다.

        int i = rf.readInt();
        double d = rf.readDouble();
        String str = rf.readUTF();

        System.out.println(i);
        System.out.println(d);
        System.out.println(str);

        // 결과
        // pos(position): 4
        // pos(position): 12
        // pos(position): 29
        // 100
        // 3.14
        // 안녕하세요
    }
}
```