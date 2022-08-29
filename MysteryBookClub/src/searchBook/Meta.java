package searchBook;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Generated("jsonschema2pojo")
public class Meta {

private Boolean isEnd;
private Integer pageableCount;
private Integer totalCount;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public Meta() {}

public Boolean getIsEnd() {
return isEnd;
}

public void setIsEnd(Boolean isEnd) {
this.isEnd = isEnd;
}

public Integer getPageableCount() {
return pageableCount;
}

public void setPageableCount(Integer pageableCount) {
this.pageableCount = pageableCount;
}

public Integer getTotalCount() {
return totalCount;
}

public void setTotalCount(Integer totalCount) {
this.totalCount = totalCount;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}