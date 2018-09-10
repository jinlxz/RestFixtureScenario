package com.qa.http;
import java.util.ArrayList;
import java.util.List;

import smartrics.rest.fitnesse.fixture.RestFixture;
public class RestFixtureWrapper extends RestFixture {
	public RestFixtureWrapper(String hostName){
		super(hostName);
	}
	public RestFixtureWrapper(String hostName,String configName){
		super(hostName,configName);
	}
	private List<List<String>> fillTable(final String... data){
		List<List<String>> input_rows=new ArrayList<List<String>>(){{
				this.add(new ArrayList<String>(){{
					for(String item:data){
						this.add(item);
					}
				}});
			}};		
		return this.doTable(input_rows);
	}
	private Boolean processResult(List<List<String>> rows)
	{
		Boolean result=true;
		for(List<String> row: rows){
			for(String cell:row){
				if(cell.trim().startsWith("fail")||cell.trim().startsWith("error")){
					result=result&&false;
					System.out.println("Exection messages===>"+cell);
				}else if(cell.trim().startsWith("pass")||cell.trim().startsWith("ignore")||cell.trim().startsWith("report")){
					System.out.println(cell);
				}else if(cell.trim().equals("")){
					;
				}else{
					System.out.println("Exection messages===>"+cell);
					result=result&&false;
				}	
			}
		}
		return result;
	}
	public Boolean setHeader(String header) {
		List<List<String>> result=this.fillTable("setHeader",header);
		return this.processResult(result);
		//this.setHeader();
	}
	public Boolean setBody(String body){
		List<List<String>> result=this.fillTable("setBody",body);
		return this.processResult(result);
		//this.setBody();
	}
	public Boolean POST(String endpoint,String statusCode,String headers, String body){
		List<List<String>> result=this.fillTable("POST",endpoint,statusCode,headers,body);
		return this.processResult(result);
		//this.setBody();		
	}
	public Boolean PUT(String endpoint,String statusCode,String headers, String body){
		List<List<String>> result=this.fillTable("PUT",endpoint,statusCode,headers,body);
		return this.processResult(result);
		//this.setBody();		
	}
	public Boolean DELETE(String endpoint,String statusCode,String headers, String body){
		List<List<String>> result=this.fillTable("DELETE",endpoint,statusCode,headers,body);
		return this.processResult(result);
		//this.setBody();		
	}
	public Boolean GET(String endpoint,String statusCode,String headers, String body){
		List<List<String>> result=this.fillTable("GET",endpoint,statusCode,headers,body);
		return this.processResult(result);
		//this.setBody();		
	}
	public Boolean let(String varName,String expType,String Loc,String exp){
		List<List<String>> result=this.fillTable("let",varName,expType,Loc,exp);
		return this.processResult(result);
	}
	public static void main(String[] args){
		
	}
}
