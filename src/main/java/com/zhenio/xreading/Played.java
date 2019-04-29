package com.zhenio.xreading;

public class Played {
    private String msg;
    private boolean error;
    private Object data;
    private int code;

    public static final int SUCCESS_CODE = 200;
    public static final String SUCCESS_MSG = "请求成功";
    public static final int ERROR_CODE = 201;
    public static final String ERROR_MSG = "当前没有权限,请登入";

    public static Played isOk(Object data) {
        Builder builder = new Builder();
        builder.msg(SUCCESS_MSG)
                .code(SUCCESS_CODE)
                .data(data)
                .error(false);
        return builder.build();
    }

    public static Played isOk(String msg, Object data) {
        Builder builder = new Builder();
        builder.msg(msg)
                .code(SUCCESS_CODE)
                .data(data)
                .error(false);
        return builder.build();
    }


    public static Played isOk(String msg, Object data, int code) {
        Builder builder = new Builder();
        builder.msg(msg)
                .code(code)
                .data(data)
                .error(false);
        return builder.build();
    }

    public static Played isError(int code, String errorMsg) {
        Builder builder = new Builder();
        builder.msg(errorMsg)
                .code(code)
                .data(null)
                .error(true);
        return builder.build();
    }

    public static Played isError(String errorMsg, Object data, int code) {
        Builder builder = new Builder();
        builder.msg(errorMsg)
                .code(code)
                .data(data)
                .error(true);
        return builder.build();
    }

    public static Played isError(String errorMsg, int code) {
        Builder builder = new Builder();
        builder.msg(errorMsg)
                .code(code)
                .error(true);
        return builder.build();
    }


    private Played(Builder builder) {
        setMsg(builder.msg);
        setError(builder.error);
        setData(builder.data);
        setCode(builder.code);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


    @Override
    public String toString() {
        return "Played{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                ", data=" + data +
                ", error='" + error + '\'' +
                '}';
    }

    public static class Builder {
        private String msg;
        private Boolean error;
        private Object data;
        private int code;

        public Builder() {
        }

        public Builder msg(String val) {
            msg = val;
            return this;
        }

        public Builder error(Boolean val) {
            error = val;
            return this;
        }

        public Builder data(Object val) {
            data = val;
            return this;
        }

        public Builder code(int val) {
            code = val;
            return this;
        }

        public Played build() {
            return new Played(this);
        }
    }
}
