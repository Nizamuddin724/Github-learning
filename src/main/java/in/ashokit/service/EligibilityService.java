package in.ashokit.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import in.ashokit.request.SearchRequest;
import in.ashokit.response.SearchResponse;

public interface EligibilityService {
	
	public List<String> getUniquePlanName();
	
	public List<String> getUniquePalnStatuses();
	
	public List<SearchResponse> search(SearchRequest request);
	
	public void generateExcel(HttpServletResponse  response) throws Exception;	
	
	//public HttpServletResponse generateExcel();
	
	public void generatePdf(HttpServletResponse  response) throws Exception;

}
