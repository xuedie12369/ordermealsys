package zsc.ordermealsys.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.apache.commons.net.ftp.FTPClient;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.collect.Lists;

import zsc.ordermealsys.service.IFileService;
import zsc.ordermealsys.util.FtpUtil;
@Service("iFileService")
public class FileServiceImpl  implements IFileService {

	@Override
	public String upload(MultipartFile file, String path) {
		// TODO Auto-generated method stub
		
		String fileName=file.getOriginalFilename();
		String fileExtensionName=fileName.substring(fileName.lastIndexOf(".")+1);
		String uploadFileName=UUID.randomUUID().toString()+"."+fileExtensionName;
		System.out.print("开始上传文件");
		File fileDir=new File(path);
		if(!fileDir.exists())
		{
//			赋予fileDir的写权限
			fileDir.setWritable(true);
//			创建目录
			fileDir.mkdirs();
		}
		File targetFile=new File(path,uploadFileName);
		try {
			file.transferTo(targetFile);
			System.out.print("文件上传成功");
			System.out.print(path+"文件名称："+uploadFileName);
//			把应用程序上面的文件上传到FTP服务器上
//			FtpUtil.uploadFile(Lists.newArrayList(targetFile));
////			把上传的文件从应用程序的根目录移除
//			targetFile.delete();
			
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileName;
	}

}
