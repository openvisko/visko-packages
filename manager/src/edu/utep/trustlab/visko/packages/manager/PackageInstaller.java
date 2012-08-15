package edu.utep.trustlab.visko.packages.manager;

import java.io.File;

import edu.utep.trustlab.visko.packages.rdf.RDFWriter;

public class PackageInstaller {
	
	private static final String PARTIAL_QUALIFIED_NAME = ".rdfWriter.RDFWriter";
	
	private String packagesRoot;
	
	public PackageInstaller(String packagesRootDirectory){
		packagesRoot = packagesRootDirectory;
	}
	
	public void installPackages(){
		File packagesRootDir = new File(packagesRoot);
		File[] packages;
		boolean installSuccess;
		if(packagesRootDir.isDirectory()){
			packages = packagesRootDir.listFiles();
			
			for(File viskoPackage : packages){
				if(viskoPackage.getName().startsWith("package")){
					installSuccess = installPackage(viskoPackage);
					
					if(installSuccess)
						System.out.println("package: " + viskoPackage.getName() + " installed successfully!");
					else
						System.out.println("package: " + viskoPackage.getName() + " failed to install!");
				}
			}
		}
	}
	
	private boolean installPackage(File aPackageDirectory){
		String rdfWriterQualifiedClassName = aPackageDirectory.getName() + PARTIAL_QUALIFIED_NAME;
		System.out.println("Installing package: " + aPackageDirectory.getName());
		Class<?> rdfWriterClass;
		try{
			rdfWriterClass = Class.forName(rdfWriterQualifiedClassName);
			RDFWriter writer = (RDFWriter)rdfWriterClass.newInstance();
			
			System.out.println("Set up content manager for this package");
			writer.setContentManager();

			System.out.println("created toolkit");
			writer.createToolkit();
			
			System.out.println("created viewers");
			writer.createViewers();
			
			System.out.println("created viewer sets");
			writer.createViewerSets();
			
			System.out.println("created services");
			writer.createServices();
			
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public static void main(String[] args){
		if(args.length == 1){
			String packagesRootDirectory = args[0];
			PackageInstaller installer = new PackageInstaller(packagesRootDirectory);
			installer.installPackages();
		}
		else
			System.out.println("requires one argument...the full path to the packages directory.");
	}
}