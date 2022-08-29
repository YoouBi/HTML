package searchBook;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Generated("jsonschema2pojo")
public class Books {

private List<Document> documents = null;
private Meta meta;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public Books() {}

public List<Document> getDocuments() {
return documents;
}

public void setDocuments(List<Document> documents) {
this.documents = documents;
}

public Meta getMeta() {
return meta;
}

public void setMeta(Meta meta) {
this.meta = meta;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}
