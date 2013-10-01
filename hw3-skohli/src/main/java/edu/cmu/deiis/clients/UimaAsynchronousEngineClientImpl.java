package edu.cmu.deiis.clients;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import org.apache.uima.adapter.jms.client.BaseUIMAAsynchronousEngine_impl;
import org.apache.uima.aae.client.UimaASProcessStatus;
import org.apache.uima.aae.client.UimaAsBaseCallbackListener;
import org.apache.uima.aae.client.UimaAsynchronousEngine;
import org.apache.uima.aae.monitor.statistics.AnalysisEnginePerformanceMetrics;
import org.apache.uima.cas.CAS;
import org.apache.uima.collection.CollectionReader;
import org.apache.uima.collection.EntityProcessStatus;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceProcessException;
import org.apache.uima.resource.metadata.ProcessingResourceMetaData;

public class UimaAsynchronousEngineClientImpl //implements UimaAsynchronousEngine 
{
/*
	@Override
	public void addStatusCallbackListener(UimaAsBaseCallbackListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void collectionProcessingComplete() throws ResourceProcessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String deploy(String arg0, Map arg1) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deploy(String[] arg0, Map arg1) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CAS getCAS() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProcessingResourceMetaData getMetaData()
			throws ResourceInitializationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPerformanceReport() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSerializationStrategy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void initialize(Map arg0) throws ResourceInitializationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void process() throws ResourceProcessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeStatusCallbackListener(UimaAsBaseCallbackListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String sendAndReceiveCAS(CAS arg0) throws ResourceProcessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String sendAndReceiveCAS(CAS arg0,
			List<AnalysisEnginePerformanceMetrics> arg1)
			throws ResourceProcessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String sendCAS(CAS arg0) throws ResourceProcessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCollectionReader(CollectionReader arg0)
			throws ResourceInitializationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stopProducingCases() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stopProducingCases(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void undeploy(String arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void undeploy(String arg0, int arg1) throws Exception {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String args[])
	
	{//create Asynchronous Client API
		CAS cas=null;
		UimaAsynchronousEngine uimaAsEngine =
				new BaseUIMAAsynchronousEngine_impl();
		uimaAsEngine = new BaseUIMAAsynchronousEngine_impl();
		uimaAsEngine.addStatusCallbackListener(new MyStatusCallbackListener());
		//4.6.2. Calling an Existing Service
		//The following code shows how to establish connection to an existing service:
		//create Map to pass server URI and Endpoint parameters
		Map<String,Object> appCtx = new HashMap<String,Object>();
		// Add Broker URI on local machine
		appCtx.put(UimaAsynchronousEngine.ServerUri, "tcp://localhost:61616");
		// Add Queue Name
		appCtx.put(UimaAsynchronousEngine.Endpoint, "QAqueue");
		// Add the Cas Pool Size
		appCtx.put(UimaAsynchronousEngine.CasPoolSize, 2);
		//initialize
		try {
			uimaAsEngine.initialize(appCtx);
		} catch (ResourceInitializationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Prepare a Cas and send it to the service:
		//get an empty CAS from the Cas pool
		
		try {
			cas = uimaAsEngine.getCAS();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Initialize it with input data
		cas.setDocumentText("Some text to pass to this service.");
		// Send Cas to service for processing
		try {
			uimaAsEngine.sendCAS(cas);
		} catch (ResourceProcessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

class MyStatusCallbackListener extends UimaAsBaseCallbackListener {
	UimaAsynchronousEngine uimaAsEngine;
	
	public void setUimaAsynchronousEngine(UimaAsynchronousEngine uimaAsEngine)
	{this.uimaAsEngine=uimaAsEngine;
		
	}
	// Method called when the processing of a Document is completed.
	public void entityProcessComplete(CAS aCas, EntityProcessStatus aStatus) {
	if (aStatus != null && aStatus.isException()) {
	List exceptions = aStatus.getExceptions();
	for (int i = 0; i < exceptions.size(); i++) {
	((Throwable) exceptions.get(i)).printStackTrace();
	}
	try {
		uimaAsEngine.stop();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return;
	}
	// Process the retrieved Cas here
	if ( aStatus instanceof UimaASProcessStatus ) {
	String casReferenceId =
	((UimaASProcessStatus)aStatus).getCasReferenceId();
	List<AnalysisEnginePerformanceMetrics> metrics =
	((UimaASProcessStatus)aStatus).getPerformanceMetricsList();
	}
	// ...
	}
	// Add other required callback methods below...
*/	}
