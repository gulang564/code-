package com.test.model;

import lombok.Data;

@Data
public class ResponseModel {
    public static final String Success = "success";
    public static final String Fail = "fail";

    private String code = "fail";
    private String message = "";
    private String data;

    //私有构造函数，此类不允许手动实例化，需要调用getInstance()获取实例
    private ResponseModel() {
    }

    /**
     * 返回默认的实例
     * @return
     */
    public static ResponseModel getInstance() {
        ResponseModel model = new ResponseModel();
        model.setCode(ResponseModel.Fail);
        return model;
    }
}
