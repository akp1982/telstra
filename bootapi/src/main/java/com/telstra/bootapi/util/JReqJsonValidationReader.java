/*
 * package com.telstra.bootapi.util; import java.io.BufferedReader; import
 * java.io.ByteArrayInputStream; import java.io.FileInputStream; import
 * java.io.IOException; import java.io.InputStream; import
 * java.io.InputStreamReader; import java.io.UnsupportedEncodingException;
 * import java.lang.annotation.Annotation; import java.lang.reflect.Type;
 * 
 * import javax.servlet.ServletContext; import javax.ws.rs.Consumes; import
 * javax.ws.rs.WebApplicationException; import javax.ws.rs.core.Context; import
 * javax.ws.rs.core.MediaType; import javax.ws.rs.core.MultivaluedMap; import
 * javax.ws.rs.ext.MessageBodyReader; import javax.ws.rs.ext.Provider;
 * 
 * import com.fasterxml.jackson.databind.JsonNode; import
 * com.fasterxml.jackson.databind.ObjectMapper; import
 * com.github.fge.jackson.JsonLoader; import
 * com.github.fge.jsonschema.core.exceptions.ProcessingException; import
 * com.github.fge.jsonschema.core.report.ProcessingReport; import
 * com.github.fge.jsonschema.main.JsonSchemaFactory; import
 * com.github.fge.jsonschema.main.JsonValidator; import
 * com.telstra.bootapi.models.JRequest;
 * 
 * import
 * at.fhj.ase.xmlvalidation.msbreader.MessageBodyReaderValidationException;
 * 
 * @Provider
 * 
 * @Consumes(MediaType.APPLICATION_JSON) public class JReqJsonValidationReader
 * implements MessageBodyReader<JRequest> {
 * 
 * private final String jsonSchemaFileAsString;
 * 
 * public JReqJsonValidationReader(@Context ServletContext servletContext) {
 * this.jsonSchemaFileAsString = servletContext
 * .getRealPath("jrequest_schema.json"); }
 * 
 * @Override public boolean isReadable(Class<?> type, Type genericType,
 * Annotation[] annotations, MediaType mediaType) { if (type == JRequest.class)
 * { return true; } return false; }
 * 
 * @Override public JRequest readFrom(Class<JRequest> type, Type genericType,
 * Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, String>
 * httpHeaders, InputStream entityStream) throws IOException,
 * WebApplicationException {
 * 
 * final String jsonData = getStringFromInputStream(entityStream);
 * System.out.println(jsonData);
 * 
 * InputStream isSchema = new FileInputStream(jsonSchemaFileAsString); String
 * jsonSchema = getStringFromInputStream(isSchema);
 * 
 * 
 * Perform JSON data validation against schema
 * 
 * validateJsonData(jsonSchema, jsonData);
 * 
 * 
 * Convert stream to data entity
 * 
 * ObjectMapper m = new ObjectMapper(); JRequest addr =
 * m.readValue(stringToStream(jsonData), JRequest.class);
 * 
 * return addr; }
 * 
 *//**
	 * Validate the given JSON data against the given JSON schema
	 * 
	 * @param jsonSchema as String
	 * @param jsonData   as String
	 * @throws MessageBodyReaderValidationException in case of an error during
	 *                                              validation process
	 */
/*
 * private void validateJsonData(final String jsonSchema, final String jsonData)
 * throws MessageBodyReaderValidationException { try { final JsonNode d =
 * JsonLoader.fromString(jsonData); final JsonNode s =
 * JsonLoader.fromString(jsonSchema);
 * 
 * final JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
 * JsonValidator v = factory.getValidator();
 * 
 * ProcessingReport report = v.validate(s, d); System.out.println(report); if
 * (!report.toString().contains("success")) { throw new
 * MessageBodyReaderValidationException( report.toString()); }
 * 
 * } catch (IOException e) { throw new MessageBodyReaderValidationException(
 * "Failed to validate json data", e); } catch (ProcessingException e) { throw
 * new MessageBodyReaderValidationException( "Failed to validate json data", e);
 * } }
 * 
 *//**
	 * Taken from <a href=
	 * "http://www.mkyong.com/java/how-to-convert-inputstream-to-string-in-java/"
	 * >www.mkyong.com</a>
	 * 
	 * @param is {@link InputStream}
	 * @return Stream content as String
	 *//*
		 * private String getStringFromInputStream(InputStream is) { BufferedReader br =
		 * null; StringBuilder sb = new StringBuilder();
		 * 
		 * String line; try {
		 * 
		 * br = new BufferedReader(new InputStreamReader(is)); while ((line =
		 * br.readLine()) != null) { sb.append(line); }
		 * 
		 * } catch (IOException e) { e.printStackTrace(); } finally { if (br != null) {
		 * try { br.close(); } catch (IOException e) { e.printStackTrace(); } } }
		 * 
		 * return sb.toString(); }
		 * 
		 * private InputStream stringToStream(final String str) throws
		 * UnsupportedEncodingException { return new
		 * ByteArrayInputStream(str.getBytes("UTF-8")); }
		 * 
		 * }
		 */