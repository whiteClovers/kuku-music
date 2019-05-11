package com.xq.serviceadmin.entity.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: mirror-blog-springboot-vue
 * @description:
 * @author: mirrorming
 * @create: 2019-01-31 19:21
 **/
public class BaseResult implements Serializable {
    private static final long serialVersionUID = 1L;

    public static String RESULT_OK = "ok";
    public static String RESULT_NOT_OK = "not_ok";
    public static String SUCCESS = "成功操作";


    private String result;
    private Object data;
    private String success; //接口操作成功的消息

    private List<String> errors; //用来返回具体的错误信息


    public static class Error {
        private String field;   //错误字段
        private String message; //错误消息

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    public static BaseResult createResult(String result, Object data, String success, List<String> errors) {
        BaseResult baseResult = new BaseResult();
        baseResult.setResult(result);
        baseResult.setData(data);
        baseResult.setSuccess(success);
        baseResult.setErrors(errors);
        return baseResult;
    }

    public static BaseResult ok(Object data) {
        return createResult(RESULT_OK, data, SUCCESS, null);
    }

    public static BaseResult ok() {
        return createResult(RESULT_OK, null, SUCCESS, null);
    }

    public static BaseResult notOk(List<String> errors) {
        return createResult(RESULT_NOT_OK, null, "", errors);
    }

    public static BaseResult notOk(String errorMessage) {
        return createResult(RESULT_NOT_OK, null, "", retList(errorMessage));
    }

    //将String消息转为List
    public static List<String> retList(String errorMessage) {
        List<String> retList = new ArrayList<>();
        retList.add(errorMessage);
        return retList;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static String getResultOk() {
        return RESULT_OK;
    }

    public static void setResultOk(String resultOk) {
        RESULT_OK = resultOk;
    }

    public static String getResultNotOk() {
        return RESULT_NOT_OK;
    }

    public static void setResultNotOk(String resultNotOk) {
        RESULT_NOT_OK = resultNotOk;
    }

    public static String getSUCCESS() {
        return SUCCESS;
    }

    public static void setSUCCESS(String SUCCESS) {
        BaseResult.SUCCESS = SUCCESS;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}