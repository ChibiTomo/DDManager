package net.chibidevteam.ddlmanager.controller;

import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ApiErrorDto implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 871686240862125816L;
    private Long              timestamp;
    private Integer           status;
    private String            error;
    private String            message;
    private String            path;
    private Boolean           success;

    public ApiErrorDto(final Integer status, final String error, final String message, final String path) {
        super();
        this.timestamp = new Timestamp(System.currentTimeMillis()).getTime();
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
        this.success = false;
    }

    /**
     * @return the status
     */
    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    /**
     * @return the error
     */
    public String getError() {
        return error;
    }

    /**
     * @param error
     *            the error to set
     */
    public void setError(String error) {
        this.error = error;
    }

    /**
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path
     *            the path to set
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @return the timestamp
     */
    public Long getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp
     *            the timestamp to set
     */
    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return the success
     */
    public Boolean getSuccess() {
        return success;
    }

    /**
     * @param success
     *            the success to set
     */
    public void setSuccess(Boolean success) {
        this.success = success;
    }

    @Override
    public final String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("ApiError [status=").append(status).append(", message=").append(message).append(", path=")
                .append(path).append("]");
        return builder.toString();
    }

}
