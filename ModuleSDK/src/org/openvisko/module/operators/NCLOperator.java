package org.openvisko.module.operators;

import org.openvisko.module.util.AbstractOperatorFileUtils;


public abstract class NCLOperator extends ToolkitOperator
{
	public NCLOperator(String inputDataURL, String baseInputFileName, boolean isTextualInput, boolean shouldBePersistedInMemory, String baseOutputFileName){
		super(inputDataURL, baseInputFileName, isTextualInput, shouldBePersistedInMemory, baseOutputFileName);
	}

	protected void setUpOutputs(String baseOutputFileName){
		String[] fileNameParts = baseOutputFileName.split("\\.");
		String name = fileNameParts[0];
		String extension = fileNameParts[1];
		
		outputFileName = name + "_" + AbstractOperatorFileUtils.getRandomString();
		outputPath = AbstractOperatorFileUtils.makeFullPath(AbstractOperatorFileUtils.getWorkspace(), outputFileName);
		outputURL = AbstractOperatorFileUtils.getOutputURLPrefix() + outputFileName + "." + extension;
	}
}
