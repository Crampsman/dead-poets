package com.DeadPoets.exceptions;

public class ImageUploadException extends Exception {

	private static final long serialVersionUID = 6283079773644283515L;
	
		private Exception hidden;
	
		public ImageUploadException (String ms)	{
			super(ms);
		}
	
		public ImageUploadException (String ms, Exception e){
			super(ms);
			hidden = e;
		}
		
	
}
