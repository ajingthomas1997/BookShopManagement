package com.agt.app.pojos;

public class UserFiles {

	private int fileId;
    
	private int userId;
    
	private String fileType;
    
	private String filePath;
	
	private String date;

    // Constructors
    public UserFiles() {
        // Default constructor
    }

    public UserFiles(int fileId, int userId, String fileType, String filePath, String date) {

    	this.fileId = fileId;
        
    	this.userId = userId;
        
    	this.fileType = fileType;
        
    	this.filePath = filePath;
    	
    	this.date = date;
    
    }
    
    public UserFiles(int userId, String fileType, String filePath, String date) {
    
    	this.userId = userId;
        
    	this.fileType = fileType;
        
    	this.filePath = filePath;
    	
    	this.date = date;
    
    }
    

    // Getters and Setters
    public int getFileId() {
    
    	return fileId;
    
    }

    public void setFileId(int fileId) {
    
    	this.fileId = fileId;
    
    }

    public int getUserId() {
   
    	return userId;
    
    }

    public void setUserId(int userId) {
    
    	this.userId = userId;
    
    }

    public String getFileType() {
    
    	return fileType;
    
    }

    public void setFileType(String fileType) {
   
    	this.fileType = fileType;
    
    }

    public String getFilePath() {
   
    	return filePath;
    
    }

    
    public void setFilePath(String filePath) {
    
    	this.filePath = filePath;
    
    }
    
    public String getDate() {
    	   
    	return date;
    
    }

    
    public void setDate(String date) {
    
    	this.date = date;
    
    }

}
