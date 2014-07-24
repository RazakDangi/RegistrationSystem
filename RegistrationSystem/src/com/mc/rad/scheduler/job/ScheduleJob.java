package com.mc.rad.scheduler.job;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mc.rad.exceptions.ApplicationException;
import com.mc.rad.scheduler.RestfullURL;
import com.mc.rad.scheduler.SchedulerService;

public class ScheduleJob implements SchedulerService {
	
	private static Logger logger=LoggerFactory.getLogger(ScheduleJob.class);

	@Override
	public void schedule() throws ApplicationException {
				
		logger.info("scheduling file creation ");
		@SuppressWarnings("deprecation")
		DefaultHttpClient httpClient = new DefaultHttpClient();
		
		for(RestfullURL restRequest:RestfullURL.values())
		{
			HttpGet getRequest=restRequest.getHttpGETRequest();
			
			HttpResponse response = null;
			try {
				response = httpClient.execute(getRequest);
			} catch (ClientProtocolException e) {
				throw new ApplicationException("Rest service access Failed : with ClientProtocolException: "
						+ e.getLocalizedMessage());
			} catch (IOException e) {
				throw new ApplicationException("Rest service Failed : with IOException: "
						+ e.getLocalizedMessage());
			}

			if (response.getStatusLine().getStatusCode() != 202) {
				throw new ApplicationException("Failed : HTTP error code : "
						+ response.getStatusLine().getStatusCode());
			}
			createFile(response,restRequest.getFileExtn());
			
		}
	
		
		httpClient.getConnectionManager().shutdown();
		logger.info("scheduling file creation done.Files can be found in the path :");
		

	}

	private void createFile(HttpResponse response,String extn) throws ApplicationException {
		BufferedReader br = null;
		FileWriter fw=null;
		BufferedWriter bw=null;
		try {
			br = new BufferedReader(new InputStreamReader(
					(response.getEntity().getContent())));
			 
			File file=createNewFile("C:\\Users\\Public\\Documents",extn);
			if(!file.exists())
			{
				try {
					file.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
 
			 fw = new FileWriter(file.getAbsoluteFile());
			 bw = new BufferedWriter(fw);
			String line;
			while ((line = br.readLine()) != null) {
					bw.write(line+"\n");
			}
		} catch (IllegalStateException e) {
			throw new ApplicationException("Creatating file Failed : with IllegalStateException: "
					+ e.getLocalizedMessage());
		} catch (IOException e) {
			throw new ApplicationException("Creatating file Failed : with IOException: "
					+ e.getLocalizedMessage());
		}finally {
			try {
				if (br != null)br.close();
				if(bw != null) bw.close();
				if(fw != null) fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	private File createNewFile(String dir, String extn) {
		File path=new File(dir);
		path.mkdir();
				
		LocalDate today=new LocalDate().now();
				
		File file=new File(dir+"\\"+today.toString("dd-MM-yyyy")+extn);
		
		return file;
	}

}
