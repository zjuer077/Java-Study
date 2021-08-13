package com.ljt.base;

/*
import java.io.*;

public class fileStreamTest {
    public static void main(String[] args) {
        try {
            byte bWrite[] = {11,21,3,40,5};
            OutputStream os = new FileOutputStream("test.txt");
            for ( int x = 0; x < bWrite.length; x++){
                os.write(bWrite[x]);
            }
            os.close();

            InputStream is = new FileInputStream("test.txt");
            int size = is.available();
            for (int i = 0; i < size; i++){
                System.out.println((char) is.read() + "  ");
            }
            is.close();
        }catch (IOException e){
            System.out.println(("Exception"));
        }
    }
}
*/


/*
import java.io.*;

public class fileStreamTest {
    public static void main(String[] args) throws IOException {
        File f = new File("a.txt");
        FileOutputStream fop = new FileOutputStream(f);
//  构建FileOutputStream对象，文件不存在会自动新建
        OutputStreamWriter writer = new OutputStreamWriter(fop, "UTF-8");
// 构建OutputStreamWriter对象，参数可以指定编码，默认为操作系统默认编码，windows上是gbk
        writer.append("中文输入");
        //写入缓冲区
        writer.append("\r\n");
        //换行
        writer.append("English");
        //刷新缓存冲，写入到文件，如果下面已经没有写入的内容，直接close也会写入
        writer.close();
//关闭写入流，同时会把缓冲区内容写入文件，所以上面的注释掉
        fop.close();
//关闭输出流，释放系统资源
        FileInputStream fip = new FileInputStream(f);
//构建FileInputStream对象，文件不存在会自动新建
        InputStreamReader reader = new InputStreamReader(fip, "UTF-8");
//构建FileInputStreamReader对象，编码与写入相同
        StringBuffer sb = new StringBuffer();
        while(reader.ready()){
            sb.append((char)reader.read());

        }
        System.out.println(sb,toString());
        reader.close();
        fip.close();
    }
}
*/


import java.io.File;

public class fileStreamTest{
    public static void main(String[] args) {
    String dirname = "/desktop";
    File f1 = new File(dirname);
    if (f1.isDirectory()){
        System.out.println("目录" + dirname);
        String s[] = f1.list();
        for (int i = 0; i < s.length; i++){
            File f = new File(dirname + "/" + s[i]);
            if ( f.isDirectory()){
                System.out.println(s[i] + "是一个目录");

            }else {
                System.out.println(s[i] + "是一个文件");
            }
        }
    } else {
        System.out.println(dirname + "不是一个目录");
    }
}
}