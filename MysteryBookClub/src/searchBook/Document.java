package searchBook;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Generated("jsonschema2pojo")
public class Document {

private List<String> authors = null;
private String contents;
private String datetime;
private String isbn;
private Integer price;
private String publisher;
private Integer salePrice;
private String status;
private String thumbnail;
private String title;
private List<String> translators = null;
private String url;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public Document() {}

public Document(List<String> authors, String contents, String datetime, String isbn, Integer price, String publisher,
		String status, String thumbnail, String title, List<String> translators, String url,
		Map<String, Object> additionalProperties) {
	super();
	this.authors = authors;
	this.contents = contents;
	this.datetime = datetime;
	this.isbn = isbn;
	this.price = price;
	this.publisher = publisher;
	this.status = status;
	this.thumbnail = thumbnail;
	this.title = title;
	this.translators = translators;
	this.url = url;
	this.additionalProperties = additionalProperties;
}

public List<String> getAuthors() {
return authors;
}


public void setAuthors(List<String> authors) {
this.authors = authors;
}

public String getContents() {
return contents;
}

public void setContents(String contents) {
this.contents = contents;
}

public String getDatetime() {
return datetime;
}

public void setDatetime(String datetime) {
this.datetime = datetime;
}

public String getIsbn() {
return isbn;
}

public void setIsbn(String isbn) {
this.isbn = isbn;
}

public Integer getPrice() {
return price;
}

public void setPrice(Integer price) {
this.price = price;
}

public String getPublisher() {
return publisher;
}

public void setPublisher(String publisher) {
this.publisher = publisher;
}

public Integer getSalePrice() {
return salePrice;
}

public void setSalePrice(Integer salePrice) {
this.salePrice = salePrice;
}

public String getStatus() {
return status;
}

public void setStatus(String status) {
this.status = status;
}

public String getThumbnail() {
return thumbnail;
}

public void setThumbnail(String thumbnail) {
this.thumbnail = thumbnail;
}

public String getTitle() {
return title;
}

public void setTitle(String title) {
this.title = title;
}

public List<String> getTranslators() {
return translators;
}

public void setTranslators(List<String> translators) {
this.translators = translators;
}

public String getUrl() {
return url;
}

public void setUrl(String url) {
this.url = url;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

@Override
public String toString() {
	return "Document [authors=" + authors + ", contents=" + contents + ", datetime=" + datetime + ", isbn=" + isbn
			+ ", price=" + price + ", publisher=" + publisher + ", salePrice=" + salePrice + ", status=" + status
			+ ", thumbnail=" + thumbnail + ", title=" + title + ", translators=" + translators + ", url=" + url
			+ ", additionalProperties=" + additionalProperties + "]";
}

}