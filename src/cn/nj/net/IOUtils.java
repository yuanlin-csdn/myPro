package cn.nj.net;

import java.io.*;

/**
 * @author edz
 */
public class IOUtils {
    public static void main(String[] args) throws FileNotFoundException {
        //图片转数组
        byte[] data = fileToByteArray(".idea/images/family.jpg");
        System.out.println(data.length);

        //字节数组转为图片
        byteArrayTOFile(data, "family-copy.jpg");
    }

    //图片转为字节数组
    public static byte[] fileToByteArray(String filePath) {
        File drc = new File(filePath);
        byte[] dest = null;
        //选择操作流
        InputStream is = null;
        try {
            is = new FileInputStream(drc);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            //操作
            int length = -1;
            byte[] datas = new byte[1024];
            while ((length = is.read(datas)) != -1) {
                baos.write(datas, 0, length);
            }
            baos.flush();
            return baos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (is != null) {
                    is.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;

    }

    //字节数组转为图片
    public static void byteArrayTOFile(byte[] drc, String destPath) {
        //创建源
        File dest = new File(destPath);
        //选择流
        ByteArrayInputStream bis = null;
        OutputStream os = null;
        try {
            bis = new ByteArrayInputStream(drc);
            os = new FileOutputStream(dest);
            //操作
            int length = -1;
            byte[] datas = new byte[1024];
            while ((length = bis.read(datas)) != -1) {
                os.write(datas, 0, length);

            }
            os.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null) {
                    os.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
