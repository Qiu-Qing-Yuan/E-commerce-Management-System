package com.ks.eshop.util;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.IOException;
import java.io.InputStream;


public class FtpUtil {

    public static void UploadImageByInputStream(InputStream is,String imageName) throws IOException {
        //创建ftp客户端
        FTPClient ftpClient = new FTPClient();
        ftpClient.setControlEncoding("GBK");
        String hostname = "127.0.0.1";
        int port = 21;
        String username = "vftp";
        String password = "****";

        //连接ftp服务器
        ftpClient.connect(hostname, port);
        //登陆ftp
        ftpClient.login(username, password);
        int reply = ftpClient.getReplyCode();
        System.out.println(reply);
        //如果reply返回230就算成功了，如果返回530密码用户名错误或当前用户无权限
        if (!FTPReply.isPositiveCompletion(reply)) {
            ftpClient.disconnect();
            return;
        }
        //设置文件类型(二进制)
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        //设置被动模式
        ftpClient.enterLocalPassiveMode();

//      ftpClient.makeDirectory("images");//在root目录下创建文件夹
//        String remoteFileName = System.currentTimeMillis()+"_"+imageName;
//        ftpClient.storeFile("/www/wwwroot/vftp/"+imageName, is);//文件你若是不指定就会上传到root目录下
        ftpClient.storeFile(imageName, is);//文件你若是不指定就会上传到root目录下
        is.close();
        ftpClient.logout();
        ftpClient.disconnect();
    }
}
