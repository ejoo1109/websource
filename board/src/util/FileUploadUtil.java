package util;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUploadUtil {
	
	public void uploadFile(HttpServletRequest request) {
		//file upload 요청 파악하기
	 	boolean isMultipart = ServletFileUpload.isMultipartContent(request);
	 	
	 	if(isMultipart){
			//전송된 파일을 디스크에 저장하기 위한 객체 생성
			DiskFileItemFactory factory = new DiskFileItemFactory();
			//파일 업로드 handler
			ServletFileUpload upload = new ServletFileUpload(factory);
			//request 파싱하기 위해 리스트 담기
			List<FileItem> fileItems = null;
			try{
				fileItems = upload.parseRequest(request);
			}catch (FileUploadException e) {
				e.printStackTrace();
			}
			
			String fileName = null, filedName = null, vlaue= null;
			Iterator<FileItem> iter = fileItems.iterator();
			while(iter.hasNext()){
				FileItem item = iter.next();
				
				if(item.isFormField()){ //input type= file이 아닌것들 구별
					filedName = item.getFieldName();
					try {
						vlaue= item.getString("utf-8");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}

				}else{					//input type=file인 것만 출력하고 저장
					filedName=item.getFieldName(); //파일이름
					fileName=item.getName(); //파일명
					long size = item.getSize(); //파일크기


					//파일 저장하기
					String path = "c:\\upload"; //서버 저장장소
					if(!fileName.isEmpty()){

						UUID uuid = UUID.randomUUID();

						File uploadFile = new File(path+"\\"+uuid.toString()+"_"+fileName);
						try {
							item.write(uploadFile);
						} catch (Exception e) {
							e.printStackTrace();
						}


					}
				}
			}
	 	}
	}
}