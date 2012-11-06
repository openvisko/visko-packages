package toolkitOperators;
import toolkitOperators.operatorTypes.NCLOperator;
import toolkitOperators.util.CommandRunner;
import toolkitOperators.util.FileUtils;

public class Gsn_csm_xy2_time_series extends NCLOperator
{

	private static final String SCRIPT_TIMESERIES = FileUtils.getNCLScripts() +  "gsn_csm_xy2_time_series.sh ";
	
	public Gsn_csm_xy2_time_series(String netCDFURL){	
		super(netCDFURL, "timeSeries.nc", false, false, "timeSeries.ps");
	}
	
	public String transform(
			String lPlotVariablesList,
			String rPlotVariablesList,
			String xDimName,
			String xDimSize,
			String title,
			String yLAxisLabel,
			String yRAxisLabel){
		
		String cmd = SCRIPT_TIMESERIES + 
		inputPath + 
		" " + outputPath +
		" " + lPlotVariablesList +
		" " + rPlotVariablesList +
		" " + xDimName +
		" " + xDimSize +
		" " + title +
		" " + yLAxisLabel +
		" " + yRAxisLabel +
		" " + FileUtils.getNCLOperatorScripts();
		
	    CommandRunner.run(cmd);   
		return outputURL;
	}
}