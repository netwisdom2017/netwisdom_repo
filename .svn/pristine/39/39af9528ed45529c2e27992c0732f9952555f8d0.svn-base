package com.dev.warehouse.sys.common;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URL;

public class AppFileUtils {
	
    /**
     * 文件下载的保存路径  默认值
     */
    public static String DOWNLOAD_PATH = System.getProperty("user.dir");
    
    /**
     * 根据URL下载文件到本地
     * @param url 远程url地址
     */
    public static String downloadFileFromUrl(String url){
    	try {
    		  //获取原文件名
              String fileName = url.substring(url.lastIndexOf("/") + 1);  
    	      URL remoteUrl = new URL(url);
    	      java.io.BufferedInputStream bis = new BufferedInputStream(remoteUrl.openStream());
    	      byte[] bytes = new byte[100];
    	      //プロジェクトパス
    	      String savePath = DOWNLOAD_PATH  + ConstInfo.USER_PHOTO;
    	      File files = new File(savePath);
    	      if(!files.exists()){
    	          files.mkdirs();
    	      }
    	      String newFileName = createNewFileName(fileName);
    	      //ファイル保存場所
    	      String filePath = savePath + newFileName;
    	      OutputStream bos = new FileOutputStream(filePath);
    	      int len;
    	      while ( (len = bis.read(bytes)) > 0) {
    	        bos.write(bytes, 0, len);
    	      }
    	      bis.close();
    	      bos.flush();
    	      bos.close();
    	      return ConstInfo.USER_PHOTO + newFileName;
    	    }catch (Exception e) {
    	      e.printStackTrace();
    	}
    	return "";
    }

    /**
     * 根据文件老名字得到新名字
     * @param oldName 文件老名字
     * @return 新名字由32位随机数加图片后缀组成
     */
    public static String createNewFileName(String oldName) {
        //获取文件名后缀
        String stuff=oldName.substring(oldName.lastIndexOf("."), oldName.length());
        //将UUID与文件名后缀进行拼接，生成新的文件名  生成的UUID为32位
        return IdUtil.simpleUUID().toUpperCase() + stuff;
    }

    /**
     * 文件下载
     * @param path
     * @return
     */
    public static ResponseEntity<Object> createResponseEntity(String path) {
        //1,构造文件对象
        File file=new File(DOWNLOAD_PATH, path);
        if(file.exists()) {
            //将下载的文件，封装byte[]
            byte[] bytes=null;
            try {
                bytes = FileUtil.readBytes(file);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //创建封装响应头信息的对象
            HttpHeaders header=new HttpHeaders();
            //封装响应内容类型(APPLICATION_OCTET_STREAM 响应的内容不限定)
            header.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            //创建ResponseEntity对象
            ResponseEntity<Object> entity= new ResponseEntity<Object>(bytes, header, HttpStatus.CREATED);
            return entity;
        }
        return null;
    }

    /**
     * 更该图片的名字 去掉_temp
     * @param goodsimg
     * @return
     */
    public static String renameFile(String goodsimg) {
        File file = new File(DOWNLOAD_PATH,goodsimg);
        String replace = goodsimg.replace("_temp","");
        if (file.exists()){
            file.renameTo(new File(DOWNLOAD_PATH,replace));
        }
        return replace;
    }

    /**
     * 根据老路径删除图片
     * @param oldPath
     */
    public static void removeFileByPath(String oldPath) {
        //图片的路径不是默认图片的路径
        if (!oldPath.equals(ConstInfo.DEFAULT_IMG)){
            File file = new File(DOWNLOAD_PATH,oldPath);
            if (file.exists()){
                file.delete();
            }
        }
    }
}