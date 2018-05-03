package zsc.ordermealsys.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service("iFileService")
public interface IFileService {
	public String upload(MultipartFile file,String path);
}
