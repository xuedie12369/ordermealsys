package zsc.ordermealsys.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.SocketException;
import java.util.List;

import org.apache.commons.net.ftp.FTPClient;

public class FtpUtil {
	private static String ftpIp=PropertiesUtil.getProperty("ftp.server.i");
	private static String ftpUser=PropertiesUtil.getProperty("ftp.user");
	private static String ftpPass=PropertiesUtil.getProperty("ftp.pass");
	private String ip;
	public static String getFtpIp() {
		return ftpIp;
	}
	public static void setFtpIp(String ftpIp) {
		FtpUtil.ftpIp = ftpIp;
	}
	public static String getFtpUser() {
		return ftpUser;
	}
	public static void setFtpUser(String ftpUser) {
		FtpUtil.ftpUser = ftpUser;
	}
	public static String getFtpPass() {
		return ftpPass;
	}
	public static void setFtpPass(String ftpPass) {
		FtpUtil.ftpPass = ftpPass;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public FTPClient getFtpClient() {
		return ftpClient;
	}
	public void setFtpClient(FTPClient ftpClient) {
		this.ftpClient = ftpClient;
	}
	private int port;
	private String user;
	private String pwd;
	private FTPClient ftpClient;
	public FtpUtil(String ip, int port, String user, String pwd) {
		super();
		this.ip = ip;
		this.port = port;
		this.user = user;
		this.pwd = pwd;
	}
/**
 * 上传文件
 * 作者:邵海楠
 * @param fileList
 * @return
 * @throws IOException
 */
	public  static boolean uploadFile(List<File> fileList) throws IOException
	{
		FtpUtil ftpUtil =new FtpUtil(ftpIp, 21, ftpUser, ftpPass);
		boolean result= ftpUtil.uploadFile("img", fileList);
	
		return result;
	}
	/**
	 * 上传webapp下的upload的文件下的文件到远程的ftp服务器上
	 * @param remotePath 远程服务器的ip地址
	 * @param fileList 要上传的文件数组
	 * @return
	 * @throws IOException 
	 */
	private  boolean uploadFile(String remotePath,List<File> fileList) throws IOException
	{
		boolean upload=true;
		FileInputStream fis=null;
		if(connectFtpServer(this.getIp(), this.getPort(), this.getUser(), this.getPwd()));
		{
//			改变工作目录
			try {
				ftpClient.changeWorkingDirectory(remotePath);
				ftpClient.setBufferSize(1024);
				ftpClient.setControlEncoding("utf-8");
				ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
//		打开本地的被动模式
				ftpClient.enterLocalPassiveMode();
				for(File fileItem:fileList)
				{
					fis=new FileInputStream(fileItem);
//					保存文件
					ftpClient.storeFile(fileItem.getName(), fis);
				}
				
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				upload=false;
						System.out.print("保存文件失败");
				e.printStackTrace();
			}finally{
//				关闭文件流
				fis.close();
//				关闭链接
				ftpClient.disconnect();
			}
		}
		return true;
	}
		
	/**
	 * 链接 FTP服务器
	 * 作者：邵海楠
	 * @param ip
	 * @param port
	 * @param user
	 * @param pwd
	 * @return
	 */
	private  boolean connectFtpServer(String ip, int port, String user, String pwd)
	{
		boolean isSuccess=false;
		ftpClient=new FTPClient();
		try {
			ftpClient.connect(ip);
			isSuccess=ftpClient.login(user, pwd);
			System.out.print("链接 FTP服务器成功");
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			System.out.print("链接 FTP服务器异常");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;
		
	}

	

}
