package little_util.b2c.filter;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJacksonInputMessage;

import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Type;

/**
 * @Title: json转换器，支持两种json转换风格，下划线风格和驼峰风格
 * @author ning.li
 * @version 2016-03-08
 */
public class Jackson2HttpMessageConverter extends org.springframework.http.converter.json.MappingJackson2HttpMessageConverter {
	private ObjectMapperProvider objectMapperProvider;
	private Logger logger = LoggerFactory.getLogger(Jackson2HttpMessageConverter.class);
	
	@Override
	protected void writeInternal(Object object, Type type, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {
		JsonEncoding encoding = getJsonEncoding(outputMessage.getHeaders().getContentType());
		com.fasterxml.jackson.databind.ObjectMapper om=null;
		try {
			om=objectMapperProvider.getObjectMapper();
			JsonGenerator generator =om.getFactory().createGenerator(outputMessage.getBody(), encoding);
			om.writeValue(generator, object);
			generator.flush();
		}catch (JsonProcessingException ex) {
			throw new HttpMessageNotWritableException("Could not write content: " + ex.getMessage(), ex);
		}finally{
			if(logger.isDebugEnabled()&&om!=null){
				StringWriter str=new StringWriter();
				om.writeValue(str, object);
			}
		}
	}

	public void setObjectMapperProvider(ObjectMapperProvider objectMapperProvider) {
		this.objectMapperProvider = objectMapperProvider;
	}


	@Override
	public Object read(Type type, Class<?> contextClass, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
		JavaType javaType = this.getJavaType(type, contextClass);
		return this.readJavaType(javaType, inputMessage);
	}

	private Object readJavaType(JavaType javaType, HttpInputMessage inputMessage) {
		com.fasterxml.jackson.databind.ObjectMapper om=null;
		try {
			om=objectMapperProvider.getObjectMapper();
			if (inputMessage instanceof MappingJacksonInputMessage) {
				Class<?> deserializationView = ((MappingJacksonInputMessage)inputMessage).getDeserializationView();
				if (deserializationView != null) {
					return om.readerWithView(deserializationView).forType(javaType).readValue(inputMessage.getBody());
				}
			}
			return om.readValue(inputMessage.getBody(), javaType);
		} catch (JsonProcessingException var4) {
			throw new HttpMessageNotReadableException("JSON parse error: " + var4.getOriginalMessage(), var4);
		} catch (IOException var5) {
			throw new HttpMessageNotReadableException("I/O error while reading input message", var5);
		}
	}


}
