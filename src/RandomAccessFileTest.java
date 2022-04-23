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
