package francisco.carriedo.scher.opensource;

import org.jsonschema2pojo.Annotator;
import org.jsonschema2pojo.GenerationConfig;
import org.jsonschema2pojo.SchemaStore;
import org.jsonschema2pojo.rules.Rule;
import org.jsonschema2pojo.rules.RuleFactory;

import com.sun.codemodel.JClassContainer;
import com.sun.codemodel.JType;

public class CustomRuleFactory extends RuleFactory {
	
    /**
     * Custom rule factory just invokes the proper superclass constructor
     *  
     */
    public CustomRuleFactory(GenerationConfig generationConfig, Annotator annotator, SchemaStore schemaStore) {
    	super(generationConfig, annotator, schemaStore);        
    }

    /**
     * This is CustomRuleFactory returns a different rule for enum types
     * than the one provided in the library. The code for the custom enum rule
     * can live in your own project, with no need to modify the code of the project. 
     *
     * @return a schema rule that can handle the "enum" declaration respecting the 
     * constants as they originally are in the JSON document.
     */
    public Rule<JClassContainer, JType> getEnumRule() {
        return new CustomEnumRule(this);
    }
	
}
