package in.ashokit.rest;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.response.SearchResponse;
import in.ashokit.service.EligibilityService;
import in.ashokit.request.SearchRequest;
@RestController
public class ReportRestController {
	
	@Autowired
	private EligibilityService service;
	
	@GetMapping("/plans")
	public ResponseEntity<List<String>> getPlanName(){
		List<String> planName=service.getUniquePlanName();
		return new ResponseEntity<>(planName,HttpStatus.OK);
	}
	@GetMapping("/statuses")
	public ResponseEntity<List<String>> getPlanStatuses(){
		List<String> Statuses =service.getUniquePalnStatuses();
		return new ResponseEntity<>(Statuses,HttpStatus.OK);
		
		
	}
	@GetMapping("/search")
	public ResponseEntity<List<SearchResponse>> search(@RequestBody SearchRequest request){
		List<SearchResponse> response=service.search(request);
		return new ResponseEntity<>(response,HttpStatus.OK);
		
	}
	@GetMapping("/excel")
	 public void excelReport(HttpServletResponse response) throws Exception {
		 response.setContentType("application/octet-stream");
		 String headeKey="content-Disposition";
		 String headerValue="attachment;filename=data.xlsx";
		 response.setHeader(headeKey, headerValue);
		 service.generateExcel(response);
		 
		 
	 }
	@GetMapping("/pdf")
	public void pdfReport(HttpServletResponse response) throws Exception {
		response.setContentType("application/pdf");
		String headKey="Content-Dispostion";
		String headValue="attachment;filename=data.pdf";
		response.setHeader(headKey, headValue);
		service.generatePdf(response);
		
		
	}
	
	

}
