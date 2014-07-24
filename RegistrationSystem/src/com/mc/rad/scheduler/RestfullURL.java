package com.mc.rad.scheduler;

import org.apache.http.client.methods.HttpGet;

public enum RestfullURL {

	JSONREQUEST("application/json","data.json") {

		@Override
		public HttpGet getHttpGETRequest() {
			HttpGet getRequest = new HttpGet(RESTURLs.JSON.getUrl());
			getRequest.addHeader("accept", getAcceptHeader());
			return getRequest;
		}

	},

	XMLREQUEST("application/xml","data.xml") {
		@Override
		public HttpGet getHttpGETRequest() {

			HttpGet getRequest = new HttpGet(RESTURLs.XML.getUrl());
			getRequest.addHeader("accept", getAcceptHeader());
			return getRequest;
		}
	};

	private RestfullURL(String acceptHeader,String extn) {
		this.acceptHeader = acceptHeader;
		this.fileExtn=extn;
	}

	private String acceptHeader;

	private HttpGet httpGet;
	
	private String fileExtn;

	public abstract HttpGet getHttpGETRequest();

	public String getAcceptHeader() {
		return acceptHeader;
	}

	public HttpGet getHttpGet() {
		return httpGet;
	}

	public String getFileExtn() {
		return fileExtn;
	}
}
