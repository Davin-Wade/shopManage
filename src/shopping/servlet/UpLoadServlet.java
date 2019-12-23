package shopping.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@WebServlet("/upLoadServlet")
public class UpLoadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fileName = "";
        String errMsg = "";

        try {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);

            List<FileItem> fileItemList = upload.parseRequest(req);

            if(fileItemList != null && fileItemList.size() > 0){
                for(FileItem fileItem:fileItemList){
                    if(fileItem.isFormField()){
                        if("name".equals(fileItem.getFieldName())){
                            String name = fileItem.getString("utf-8");
                        }
                    }else{
                        if(fileItem.getName()!=null && !"".equals(fileItem.getName())){
                            String parentPath = req.getServletContext().getRealPath("/upload");
                            File parentFile = new File(parentPath);
                            if(parentFile.exists()) parentFile.mkdirs();

                            File newFile = new File(parentPath,fileItem.getName());
                            InputStream is = fileItem.getInputStream();
                            OutputStream out = new FileOutputStream(newFile);
                            IOUtils.copy(is,out);

                            fileName = fileItem.getName();
                        }
                    }
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
            errMsg = e.getMessage();
        }

        PrintWriter out = resp.getWriter();
        out.flush();
        if(errMsg != null && !"".equals(errMsg)){
            out.println("<script type='text/javascript'>alert('" + errMsg + "');history.back();</script>");
        }else{
            // 用于父窗口的设置图片的src
            out.println("<script type='text/javascript'>window.opener.resetImg('" + fileName + "');window.close();</script>");
        }

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
