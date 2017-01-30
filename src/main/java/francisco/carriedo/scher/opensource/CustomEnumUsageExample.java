package francisco.carriedo.scher.opensource;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.jsonschema2pojo.AnnotationStyle;
import org.jsonschema2pojo.DefaultGenerationConfig;
import org.jsonschema2pojo.GenerationConfig;
import org.jsonschema2pojo.NoopAnnotator;
import org.jsonschema2pojo.SchemaGenerator;
import org.jsonschema2pojo.SchemaMapper;
import org.jsonschema2pojo.SchemaStore;
import org.jsonschema2pojo.SourceType;

import com.sun.codemodel.JCodeModel;

public class CustomEnumUsageExample {
	
	private static final String INPUT_BASE_DIR = "/tmp/input/";
	private static final String OUTPUT_BASE_DIR = "/tmp/output/";
	private static final String PACKAGE_NAME = "francisco.carriedo.scher";
	

	public static void main(String[] args) throws IOException {

		String finalClassName;
		GenerationConfig config = getConfig();		
		File directory = new File(INPUT_BASE_DIR);
		
		for (File bp : directory.listFiles()) {

			if (bp.isDirectory() || !bp.getName().endsWith("json"))
				continue;

			finalClassName = bp.getName();
			
			URL source = bp.toURI().toURL();

			JCodeModel codeModel = new JCodeModel();
			SchemaMapper mapper = new SchemaMapper(new CustomRuleFactory(config, new NoopAnnotator(), new SchemaStore()), new SchemaGenerator());
			mapper.generate(codeModel, finalClassName.replace(".json",  ""), PACKAGE_NAME, source);

			File outputDir = new File(OUTPUT_BASE_DIR + finalClassName);
			if (!outputDir.mkdir()) {
				System.err.println("Creation of output directory for model for " + finalClassName + " failed!!!");
				continue;
			}

			codeModel.build(outputDir);
			
			System.out.println("Model created for " + finalClassName);

		}

	}


	private static GenerationConfig getConfig() {

		return new DefaultGenerationConfig() {
			@Override
			public boolean isGenerateBuilders() { // set config option by overriding method
				return false;
			}
			@Override
			public boolean isUseLongIntegers() { // set config option by overriding method
				return true;
			}
			@Override
			public boolean isUseDoubleNumbers() { // set config option by overriding method
				return false;
			}
			@Override
			public boolean isIncludeHashcodeAndEquals() { // set config option by overriding method
				return false;
			}
			@Override
			public boolean isIncludeToString() { // set config option by overriding method
				return false;
			}
			@Override
			public boolean isIncludeJsr303Annotations() { // set config option by overriding method
				return false;
			}
			@Override
			public boolean isIncludeJsr305Annotations() { // set config option by overriding method
				return false;
			}
			@Override
			public boolean isUseJodaDates() { // set config option by overriding method
				return false;
			}
			@Override
			public boolean isUseJodaLocalTimes() { // set config option by overriding method
				return false;
			}
			@Override
			public boolean isUseCommonsLang3() { // set config option by overriding method
				return false;
			}			
			@Override
			public boolean isParcelable() { // set config option by overriding method
				return false;
			}
			@Override
			public boolean isSerializable() { // set config option by overriding method
				return false;
			}
			@Override
			public boolean isInitializeCollections() { // set config option by overriding method
				return false;
			}
			@Override
			public boolean isUseBigDecimals() { // set config option by overriding method
				return false;
			}
			@Override
			public boolean isIncludeConstructors() { // set config option by overriding method
				return false;
			}
			@Override
			public boolean isConstructorsRequiredPropertiesOnly() { // set config option by overriding method
				return false;
			}
			@Override
			public boolean isIncludeAdditionalProperties() { // set config option by overriding method
				return false;
			}
			@Override
			public boolean isIncludeDynamicAccessors() { // set config option by overriding method
				return false;
			}
			@Override
			public boolean isFormatDateTimes() { // set config option by overriding method
				return false;
			}
			@Override
			public boolean isIncludeAccessors() { // New fancy way to call getters and setters
				return true;
			}
			@Override
			public AnnotationStyle getAnnotationStyle() { // set config option by overriding method
				return AnnotationStyle.NONE;
			}
			@Override
			public SourceType getSourceType() { // set config option by overriding method
				return SourceType.JSONSCHEMA;
			}
		};
		
	}
	

}
