import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-04-28 11:43
 */
public class Test11 {


    @Test
    public void test2344(){

        List<String> auditDTOs = new ArrayList<>(2);
        List<String> result = new ArrayList<>(2);

        result.addAll(auditDTOs);
        System.out.println(result);
    }

    @Test
    public void test12() throws IOException {

        FileInputStream fileInputStream = new FileInputStream("D:/360MoveData/Users/xxing/Desktop/新建文本文档 (2).txt");
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader br = new BufferedReader(inputStreamReader);
        String str;
        while ((str = br.readLine())!=null){
            System.out.println(str);
        }

        fileInputStream.close();

    }
}
