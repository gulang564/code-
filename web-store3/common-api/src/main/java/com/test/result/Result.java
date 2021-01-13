package com.test.result;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Result<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;

    public static Result success(Object data) {
        return new Result(400, "处理成功", data);
    }

    public static Result fail500(Object data) {
        return new Result(500, "处理失败", data);
    }

}
