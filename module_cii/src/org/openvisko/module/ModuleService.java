package org.openvisko.module;

import java.io.File;

import javax.jws.WebParam;

import org.openvisko.module.util.CommandRunner;
import org.openvisko.module.util.FileUtils;


public class ModuleService {


  /**
   * Return a url to one image generated randomly
   * @param inputData
   * @return
   */
  public String generateSampleImage(@WebParam(name="inputFileUrl") String inputFileUrl) {
    try {
      // Create temporary directory for this invocation
      File outputDir = FileUtils.getTemporaryOutputDirectory();

      // download input file to temporary directory
      File inputFile = FileUtils.getInputFile(inputFileUrl, outputDir);
      
      // right now we don't use an input file

      // run matlab code to generate image
      File scriptsDir = FileUtils.getScriptsDir();
      File scriptFile = new File(scriptsDir, "run.sh");
      File mainFile = new File(scriptsDir, "main_carina.m");
      File generateFile = new File(scriptsDir, "generate_images.m");
      
      // Dongsheng's code has to be located in same folder as output dir
      // TODO: fix this
      org.apache.commons.io.FileUtils.copyFileToDirectory(scriptFile, outputDir);
      org.apache.commons.io.FileUtils.copyFileToDirectory(mainFile, outputDir);
      org.apache.commons.io.FileUtils.copyFileToDirectory(generateFile, outputDir);
      
      String cmd = "cd " + outputDir.getAbsolutePath() + "; chmod 755 run.sh; ./run.sh";
      CommandRunner.run(cmd);

      // return the url to the file produced by matlab script
      return FileUtils.getOutputURLPrefix(outputDir) + "/image1.tif"; 

    } catch (Throwable e) {
      // TODO: need logging configured
      e.printStackTrace();
      if(e instanceof RuntimeException) {
        throw (RuntimeException)e;

      } else {
        throw new RuntimeException(e);
      }
    }
  }

}
