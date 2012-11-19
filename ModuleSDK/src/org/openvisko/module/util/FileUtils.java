package org.openvisko.module.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;
import java.util.Date;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.UUID;

public class FileUtils{
  public static final int BUFFER_SIZE = 4096;
  
  private static String SERVER_URL;
  private static String WEBAPP_NAME;
  private static File WEBAPP_DIR;
  private static File OUTPUT_DIR;
  private static File SCRIPTS_DIR;

  private static final String OUTPUT_DIR_NAME = "output";
  private static final String SCRIPTS_DIR_NAME = "scripts";
  
  static {
    
    try {
      // Initialize properties
      Properties props = new Properties();
      InputStream propsFile = FileUtils.class.getResourceAsStream("/module.properties");
      props.load(propsFile);
      SERVER_URL = props.getProperty("module.server.url");
      if(!SERVER_URL.endsWith("/")) {
        SERVER_URL += "/";
      }
      WEBAPP_NAME = props.getProperty("module.server.webapp.name");
      
      File tomcatHome = new File(props.getProperty("module.server.tomcat.home"));
      File webappsDir = new File(tomcatHome, "webapps");
      WEBAPP_DIR = new File(webappsDir, WEBAPP_NAME);
      OUTPUT_DIR = new File(WEBAPP_DIR, OUTPUT_DIR_NAME);
      SCRIPTS_DIR = new File(WEBAPP_DIR, SCRIPTS_DIR_NAME);
      
    } catch (Throwable e) {
      e.printStackTrace();
    }

  }

  public static File getLoggingDir(){
    return new File(WEBAPP_DIR, "log");
  }

  

  public static File getOutputDir() {
    return OUTPUT_DIR;
  }



  public static File getScriptsDir() {
    return SCRIPTS_DIR;
  }



  public static String getGravityTrustTableFilePath(){
    return "trust-data/gravity_trust.txt";
  }

  public static String getOutputURLPrefix(File temporaryOutputDir){
    return SERVER_URL + WEBAPP_NAME + "/" + OUTPUT_DIR_NAME + "/" + temporaryOutputDir.getName();
  }
  
  /**
   * Copy the contents of the given InputStream to the given OutputStream.
   * Closes both streams when done.
   * @param in the stream to copy from
   * @param out the stream to copy to
   * @return the number of bytes copied
   * @throws IOException in case of I/O errors
   */
  public static int copy(InputStream in, OutputStream out) throws IOException {

    try {
      int byteCount = 0;
      byte[] buffer = new byte[BUFFER_SIZE];
      int bytesRead = -1;
      while ((bytesRead = in.read(buffer)) != -1) {
        out.write(buffer, 0, bytesRead);
        byteCount += bytesRead;
      }
      out.flush();
      return byteCount;
    }
    finally {
      try {
        in.close();
      }
      catch (IOException ex) {
      }
      try {
        out.close();
      }
      catch (IOException ex) {
      }
    }
  }
  
  public static String writeTextFile(String fileContents, String dirName, String fileName){
    File dirFile = new File(dirName);
    dirFile.mkdirs();

    String filePath = makeFullPath(dirName, fileName);

    try{
      BufferedWriter out = new BufferedWriter(new FileWriter(filePath));
      out.write(fileContents);
      out.close();
      return filePath;
    }
    catch (Exception e){
      e.printStackTrace();
      return e.toString();
    }
  }

  public static boolean exists(String filePath){
    File file = new File(filePath);
    if (file.exists())
      return true;
    return false;
  }

  public static FileOutputStream getLoggingStream(){
    try{
      return new FileOutputStream(getLoggingDir() + "/log.txt");
    }
    catch (Exception e){
      e.printStackTrace();
      return null;
    }
  }

  public static String writeBinaryFile(byte[] fileContents, String dirName, String fileName){
    File dirFile = new File(dirName);
    dirFile.mkdirs();

    String filePath = makeFullPath(dirName, fileName);

    try{
      FileOutputStream out = new FileOutputStream(filePath);
      out.write(fileContents);
      out.close();
      return filePath;
    }
    catch (Exception e){
      e.printStackTrace();
      return e.toString();
    }
  }

  public static byte[] readBinaryFile(String fileName){
    try{
      FileInputStream in = new FileInputStream(fileName);
      byte[] fileContents = new byte[fileSize(fileName)];
      in.read(fileContents);
      in.close();
      return fileContents;
    }
    catch (Exception e){
      e.printStackTrace();
      return null;
    }
  }

  public static String readTextFile(String fileName){
    try{
      BufferedReader in = new BufferedReader(new FileReader(fileName));
      String line, fileContents;

      fileContents = null;

      while ((line = in.readLine()) != null){
        if (fileContents == null)
          fileContents = line + "\n";
        else
          fileContents = fileContents + line + "\n";
      }

      in.close();
      return fileContents;
    }
    catch (Exception e){
      e.printStackTrace();
      return null;
    }
  }

  public static String getRandomString(){
    // get the current time in milliseconds to use as data source temp file
    // name
    long miliseconds = (new Date()).getTime();
    String localFileName = new String("" + miliseconds);
    return localFileName;
  }

  public static void deleteFile(String fileName){
    File file = new File(fileName);
    file.delete();
  }

  public static void cleanWorkspace(String workspace){
    File file = new File(workspace);
    String[] wsFiles = file.list();
    if (wsFiles != null){
      for (String aFile : wsFiles){
        deleteFile(FileUtils.makeFullPath(workspace, aFile));
      }
    }
  }

  public static String getRandomFileNameFromFileName(String fileName){
    if(fileName.contains(".")){
      String[] fileNameParts = fileName.split("\\.");
      String name = fileNameParts[0];
      String extension = fileNameParts[1];

      return name + "_" + FileUtils.getRandomString() + "." + extension;
    }

    System.out.println("fileName: " + fileName + " doesn't have a file extension...bad move man.");
    return fileName + "_" + FileUtils.getRandomString();
  }

  public static String makePathWellFormedURI(String path){
    try{
      String uri = path.replaceAll("\"", "");
      return uri.replaceAll(" ", "%20");

    }
    catch (Exception e){
      e.printStackTrace();
      return null;
    }
  }

  public static String makeFullPath(String dir, String fileName){
    File directory = new File(dir);
    File file = new File(fileName);

    return directory.getAbsolutePath() + File.separator + file.getName();
  }

  public static int fileSize(String fileName){
    File file = new File(fileName);
    return (int) file.length();
  }


  public static String getNameFromFilename(String fileName) {
    StringTokenizer tokens = new StringTokenizer(fileName, ".");
    String output = tokens.nextToken();
    return output;
  }

  public static String getNameFromPath(String fileName) {
    String name = new File(fileName).getName();
    return name;
  }

  public static String getDirFromPath(String fileName) {
    String path = new File(fileName).getParent();
    return path;
  }
  
  /**
   * Modules can use this method to create a unique output directory
   * for an invocation of their service
   * @return
   */
  public static File getTemporaryOutputDirectory() {
    // TODO: use date and time instead of uuid
    String uuid = UUID.randomUUID().toString();
    File tempDir = new File(OUTPUT_DIR, uuid);
    tempDir.mkdir();
    return tempDir;
  }
  
  private static boolean isStaticFileURL(String url){
    if(url.contains("?"))
      return false;
    return true;
  }
  
  /**
   * Download the input file from remote location or copy it from
   * local file system, depending on format of url.
   * @param fileUrl
   * @param destFolder
   */
  public static File getInputFile(String fileUrl, File destFolder) throws Exception { 
    File inputFile = null;

    if(fileUrl.startsWith("file:")) {
      // this is a local file url
      URI uri = new URL(fileUrl).toURI();
      inputFile = new File(uri);

    } else { // http url 
    
      // see if url points to file on same web server
      if(fileUrl.startsWith(SERVER_URL)) {
        URL url = new URL(fileUrl);
        String localFilePath = OUTPUT_DIR.getAbsolutePath() + url.getFile();
        inputFile = new File(localFilePath);
      }
      
      if(!inputFile.exists()) {
        System.out.println("file doesn't exist on file system of server...need to http get it");
        inputFile = GetURLContents.getFile(fileUrl, OUTPUT_DIR);
        
      }
    }
  
    return inputFile;
  }
  
  public static File getOutputFile(String outputFileName){
    File outputFile = new File (OUTPUT_DIR, outputFileName);
    return outputFile;
  }
  
  public static String getFileName(String fileUrl) {
    // Get the file name
    if(fileUrl.endsWith("/")) {
      fileUrl = fileUrl.substring(0, fileUrl.length() - 1);
    }
    int lastSlash = fileUrl.lastIndexOf('/');
    String fileName = fileUrl.substring(lastSlash + 1);

    return fileName;

  }

}
