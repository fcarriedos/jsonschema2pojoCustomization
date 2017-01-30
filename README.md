# jsonschema2pojoCustomization
Sample project to demonstrate how easy it is to customize generation rules for JSONSchema2Pojo opensource project.

Pre-requisites:

1) Clone the project from https://github.com/joelittlejohn/jsonschema2pojo.
2) Compile it.
3) Verify THIS project's (not the one just cloned) pom.xml file to have the proper dependency.

Usage:

1) Copy the Sample.json file (located in the root folder of the project) to a readable location for the Java program to get the JSON schema input files.
2) Create a writable folder for the Java program to output the generated POJOs.
3) Properly adjust the following variables in the main program (classname CustomEnumUsageExample):

	private static final String INPUT_BASE_DIR = "/your/readable/folder/";
	private static final String OUTPUT_BASE_DIR = "/your/writable/folder/";
	private static final String PACKAGE_NAME = "your.java.package.name";

4) Compile and execute the class CustomEnumUsageExample.java.
5) Examine the output folder to get to the created POJOs.

Notes:

1) Tested with version 0.4.30-SNAPSHOT of JSONSchema2POJO project.
