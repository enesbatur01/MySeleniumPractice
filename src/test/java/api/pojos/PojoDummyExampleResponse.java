package api.pojos;

import java.util.LinkedHashMap;
import java.util.Map;


public class PojoDummyExampleResponse {

    private String status;
    private PojoDummyExampleData pojoDummyExampleData;
    private String message;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public PojoDummyExampleResponse() {
    }

    /**
     *
     * @param pojoDummyExampleData
     * @param message
     * @param status
     */
    public PojoDummyExampleResponse(String status, PojoDummyExampleData pojoDummyExampleData, String message) {
        super();
        this.status = status;
        this.pojoDummyExampleData = pojoDummyExampleData;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public PojoDummyExampleData getData() {
        return pojoDummyExampleData;
    }

    public void setData(PojoDummyExampleData pojoDummyExampleData) {
        this.pojoDummyExampleData = pojoDummyExampleData;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PojoDummyExampleResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null)?"<null>":this.status));
        sb.append(',');
        sb.append("data");
        sb.append('=');
        sb.append(((this.pojoDummyExampleData == null)?"<null>":this.pojoDummyExampleData));
        sb.append(',');
        sb.append("message");
        sb.append('=');
        sb.append(((this.message == null)?"<null>":this.message));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}