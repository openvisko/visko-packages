package org.openvisko.module.operators;

import org.openvisko.module.util.AbstractOperatorFileUtils;
import org.openvisko.module.util.GetURLContents;

public abstract class ToolkitOperator {
	
	protected String stringData;
	protected byte[] binaryData;
	
	protected String inputPath;
	protected String inputFileName;
	
	protected String outputFileName;
	protected String outputPath;
	protected String outputURL;
	
	public ToolkitOperator(String datasetURL, String baseInputFileName, boolean textualData, boolean persistInputDataInMemory, String baseOutputFileName){
		setUpInputs(datasetURL, baseInputFileName, textualData, persistInputDataInMemory);
		setUpOutputs(baseOutputFileName);
	}
	
	private static boolean isStaticFileURL(String url){
		if(url.contains("?"))
			return false;
		return true;
	}

	protected void setUpInputs(String datasetURL, String baseInputFileName, boolean textualData, boolean persistInputDataInMemory){
		if(datasetURL != null){
			
			if(isStaticFileURL(datasetURL) && AbstractOperatorFileUtils.existsOnLocalFileSystem(datasetURL)){
				System.out.println("file exists on file system of server...don't need to http get!");
		
				inputFileName = datasetURL.substring(datasetURL.lastIndexOf("/") + 1);
				System.out.println("input file name on local system is: " + inputFileName);
				
				inputPath = AbstractOperatorFileUtils.getWorkspace() + inputFileName;
			
				if(persistInputDataInMemory && textualData)
					stringData = AbstractOperatorFileUtils.readTextFile(inputPath);
				else if(persistInputDataInMemory && !textualData)
					binaryData = AbstractOperatorFileUtils.readBinaryFile(inputPath);
			
			}
			else{
				System.out.println("file doesn't exist on file system of server...need to http get it");
	
				inputFileName = AbstractOperatorFileUtils.getRandomFileNameFromFileName(baseInputFileName);
				inputPath = AbstractOperatorFileUtils.getWorkspace() + inputFileName;
			
				if(textualData){
					stringData = GetURLContents.downloadText(datasetURL);
				
					if(!persistInputDataInMemory)
						AbstractOperatorFileUtils.writeTextFile(stringData, AbstractOperatorFileUtils.getWorkspace(), inputFileName);
				}
				else {
					binaryData = GetURLContents.downloadFile(datasetURL);
				
					if(!persistInputDataInMemory)
						AbstractOperatorFileUtils.writeBinaryFile(binaryData, AbstractOperatorFileUtils.getWorkspace(), inputFileName);
				}
			}
		}
	}
	
	protected void setUpOutputs(String baseOutputFileName){		
		outputFileName = AbstractOperatorFileUtils.getRandomFileNameFromFileName(baseOutputFileName);
		outputPath = AbstractOperatorFileUtils.makeFullPath(AbstractOperatorFileUtils.getWorkspace(), outputFileName);
		outputURL = AbstractOperatorFileUtils.getOutputURLPrefix() + outputFileName;
	}
}