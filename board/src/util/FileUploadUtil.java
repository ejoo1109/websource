package util;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUploadUtil {
	
	public Map<String, String> uploadFile(HttpServletRequest request) {
		//file upload 요청 파악하기
	 	boolean isMultipart = ServletFileUpload.isMultipartContent(request);
	 	
	 	//사용자로부터 넘어온 데이터를 담기 위한 구조 생성
	 	Map<String, String> map = new HashMap<String, String>();
	 	
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
			
			String fileName = null, filedName = null, value= null;
			Iterator<FileItem> iter = fileItems.iterator();
			while(iter.hasNext()){
				FileItem item = iter.next();
				
				if(item.isFormField()){ //input type= file이 아닌것들 구별
					filedName = item.getFieldName();
					try {
						value= item.getString("utf-8");
						map.put(filedName, value); //맵구조에 자료 담기
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}

				}else{					//input type=file인 것만 출력하고 저장
					filedName=item.getFieldName(); //파일이름
					fileName=item.getName(); //파일명

					//파일 저장하기
					String path = "c:\\upload"; //서버 저장장소
					if(!fileName.isEmpty()){
						//아이디 생성
						UUID uuid = UUID.randomUUID();

						File uploadFile = new File(path+"\\"+uuid.toString()+"_"+fileName);
					
						map.put(filedName, uploadFile.getName());
						
						try {
							item.write(uploadFile);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
	 	}return map;
	} 
}