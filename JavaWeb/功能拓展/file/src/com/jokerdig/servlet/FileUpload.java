package com.jokerdig.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

/**
 * @author Joker大雄
 * @data 2022/4/21 - 14:52
 **/
public class FileUpload extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 判断上传文件是普通表单还是带文件的表单
        if(!ServletFileUpload.isMultipartContent(req)){
            return ;// 中止方法 是普通表单
        }
        // 带文件的表单  上传文件应该放在WEB-INF目录下 安全
        String uploadPath = this.getServletContext().getRealPath("/WEB-INF/upload");
        File uploadFile = new File(uploadPath);
        if(!uploadFile.exists()){
            // 上传文件夹不存在
            uploadFile.mkdir();// 创建
        }
        // 缓存 临时文件
        String tmpPath = this.getServletContext().getRealPath("/WEB-INF/tmp");
        File tmpFile = new File(tmpPath);
        if(!tmpFile.exists()){
            tmpFile.mkdir();// 创建
        }
        // 1. 创建DiskFileItemFactory对象，get处理文件上传路径或者大小限制
        DiskFileItemFactory factory = getDiskFileItemFactory(tmpFile);
        // 2. 获取ServletFileUpload
        ServletFileUpload upload = getServletFileUpload(factory);
        // 3. 上传文件
        String msg  = getParseRequest(upload,req,uploadPath);
        // 将结果信息发送到页面
        req.setAttribute("msg",msg);
        req.getRequestDispatcher("info.jsp").forward(req,resp);
    }
   //  创建DiskFileItemFactory对象
    public static DiskFileItemFactory getDiskFileItemFactory(File file){
        // *创建DiskFileItemFactory对象，处理文件上传路径或者大小限制
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 通过工厂设置一个缓冲区，当上传文件大于这个缓冲区，将他放到临时文件中
        factory.setSizeThreshold(1024*1024);// 缓冲区大小为1m
        factory.setRepository(file); // 临时保存目录
        return factory;
    }

    // 2. 获取ServletFileUpload
    public static ServletFileUpload getServletFileUpload(DiskFileItemFactory factory) {
        // 2. 获取ServletFileUpload
        ServletFileUpload upload = new ServletFileUpload(factory);
        // 监听文件上传进度
        upload.setProgressListener(new ProgressListener() {
            @Override
            public void update(long pBytesRead, long pContentLength, int pItems) {
                // pBytesRead:已经读取到的文件大小
                // pContentLength：文件大小
                System.out.println("总大小："+pContentLength+"已上传："+pBytesRead);
            }
        });
        // 处理乱码
        upload.setHeaderEncoding("utf-8");
        // 设置单个文件最大值
        upload.setFileSizeMax(1024*1024*10);
        // 设置总共能狗上传文件大小
        // 1024=1kb*1024=1M*10=10M
        upload.setSizeMax(1024*1024*10);

        return upload;
    }
    //  处理上传文件
    public static String getParseRequest(ServletFileUpload upload,HttpServletRequest req,String uploadPath){
        // 把前端请求解析，封装成一个FileItem对象
        List<FileItem> fileItems = null;
        String msg = null;
        try {
            fileItems = upload.parseRequest(req);
            // fileItem  每一个表单对象
            for (FileItem fileItem : fileItems) {
                // 判断上传文件是否为普通表达那
                if(fileItem.isFormField()){
                    String name = fileItem.getFieldName();
                    String value = fileItem.getString("utf-8");
                    System.out.println(name+":"+value);
                }else{
                    // 上传为文件
                    String uploadFileName = fileItem.getName();
                    if(uploadFileName.trim().equals("")||uploadFileName==null){
                        continue;
                    }
                    // 获得上传的文件名
                    String fileName = uploadFileName.substring(uploadFileName.lastIndexOf("/")+1);
                    // 获取文件后缀
                    String fileExtName = uploadFileName.substring(uploadFileName.lastIndexOf(".")+1);
                    // 网络中传输的东西都需要实例化
                    // 所以我们在写实体类，为它实现 implements Serializable
                    // JNI = Java Native Interface Java本地化接口
                    // JVM --> 本地方法栈 native ---> C++
                    // 使用UUID随机生成
                    String uuidPath = UUID.randomUUID().toString();

                    // 文件真是存在路径 realPath
                    String realPath = uploadPath+"/"+uuidPath;
                    // 给每个文件创建对应的文件夹
                    File realPathFile = new File (realPath);
                    if(!realPathFile.exists()){
                        // 不存在就创建
                        realPathFile.mkdir();
                    }

                    // --------------文件传输-------------------
                    // 获得文件上传的流
                    InputStream inputStream = fileItem.getInputStream();
                    // 创建一个文件输出流 文件名字+"/"+uuidFileName
                    FileOutputStream os = new FileOutputStream(realPath+"/"+fileName);
                    // 创建缓冲
                    byte[] buffer = new byte[1024*1024];
                    // 判断是否读取完
                    int len = 0;
                    while((len=inputStream.read(buffer))>0){
                        os.write(buffer,0,len);
                    }
                    // 关闭流
                    os.close();;
                    inputStream.close();

                    msg="文件上传成功";
                    fileItem.delete();// 成功后清除临时文件
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }

}
