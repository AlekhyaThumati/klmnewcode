package soapuipoject;

import java.io.File;
import java.io.FileInputStream;

import javax.xml.soap.*;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.w3c.dom.NodeList;
public class WsTester {

	
		// TODO Auto-generated method stub
		// Data source containing our test cases
		public static final String TESTCASES = "C:\\Users\\Sparkelon\\Desktop\\Alekhya\\soapui_maven2019\\soapuitestdata.xls";
		
		// Column ids within our data source
		public static final int COLUMN_TESTCASE = 0;
		public static final int COLUMN_MESSAGE = 1;
		public static final int COLUMN_ENDPOINT = 2;
		public static final int COLUMN_ELEMENT = 3;
		public static final int COLUMN_VALUE = 4;
		public static final int COLUMN_VALIDATE = 5;

	    public static void main(String args[]) {
	    	
	    	try {
				// Open the test data file
				FileInputStream fis = new FileInputStream(TESTCASES);
			
				
				// Access the required test data sheet
				HSSFWorkbook wb = new HSSFWorkbook(fis);
				HSSFSheet sheet = wb.getSheet("Testdata");
				
				// Loop through all rows in the sheet
				// Start at row 1 as row 0 is our header row
				for(int count = 1;count<=sheet.getLastRowNum();count++){
					
					HSSFRow row = sheet.getRow(count);
					System.out.println("Running test case " + row.getCell(COLUMN_TESTCASE).toString());
					
					// Create a SOAP request from the file referenced in the Excel sheet
			SOAPMessage soapRequest = createSOAPRequest(row.getCell(COLUMN_MESSAGE).toString());
					
					System.out.println("row valueeee:" +row.getCell(2).toString());
					System.out.println("soap request msgggg:" +soapRequest);
					// Read test data from the Excel sheet
					String strEndpoint = row.getCell(COLUMN_ENDPOINT).toString();
					String strElement = row.getCell(COLUMN_ELEMENT).toString();
					String strValue = row.getCell(COLUMN_VALUE).toString();
					
					// Send the request to the indicated endpoint and capture the response
					SOAPMessage response = getSOAPResponse(soapRequest,strEndpoint);
		            
		            // Validate the value of the specified element in the response message
		            validateValue(response,strElement,strValue);
		            
				}
				fis.close();
			} catch (Exception e) {
	            System.err.println("Error occurred while testing web service");
	            e.printStackTrace();
	        }	
	    }
	    
	    private static SOAPMessage createSOAPRequest(String strPath) throws Exception {
	        
	    	// Create a SOAP message from the XML file located at the given path
	    	FileInputStream fis = new FileInputStream(new File(strPath));
	    	MessageFactory factory = MessageFactory.newInstance();
	        SOAPMessage message = factory.createMessage(new MimeHeaders(), fis);
	        return message;
	    }
	    
	    private static SOAPMessage getSOAPResponse(SOAPMessage soapRequest, String strEndpoint) throws Exception, SOAPException {
	    	
	    	// Send the SOAP request to the given endpoint and return the corresponding response
	    	SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
	        SOAPConnection soapConnection = soapConnectionFactory.createConnection();
	        SOAPMessage soapResponse = soapConnection.call(soapRequest, strEndpoint);
	        return soapResponse;	
	    }
	    
	    private static void validateValue(SOAPMessage soapMsg, String strEl, String strExpected) throws Exception {
	    	
	    	// Get all elements with the requested element tag from the SOAP message
	    	SOAPBody soapBody = soapMsg.getSOAPBody();
	        NodeList elements = soapBody.getElementsByTagName(strEl);
	        
	        // Check whether there is exactly one element with the given tag
	        if (elements.getLength() != 1){
	        	System.out.println("Expected exactly one element " + strEl + "in message, but found " + Integer.toString(elements.getLength()));
	        } else {
	        	// Validate the element value against the expected value
	        	String strActual = elements.item(0).getTextContent();
	        	if (strActual.equals(strExpected)) {
	        		System.out.println("Actual value " + strActual + " for element " + strEl + " matches expected value");
	        	} else {
	        		System.out.println("Expected value " + strExpected + " for element " + strEl + ", but found " + strActual + " instead");
	        	}
	        }
	    }
	}