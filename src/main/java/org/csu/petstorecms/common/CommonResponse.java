package org.csu.petstorecms.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
//status 就设为0和1，message表示错误或者成功信息
public class CommonResponse<T> {
        private int status;
        private String message;
        private T data;
        private CommonResponse(int status ,String message){
            this.status=status;
            this.message=message;
        }
        private CommonResponse(int status,String message,T data){
            this.status=status;
            this.message=message;
            this.data=data;
        }
        public static<T> CommonResponse<T> createForSuccess(){
            return new CommonResponse<>(1,"请求成功");
        }
        public static<T> CommonResponse<T> createForSuccess(T data){
            return new CommonResponse<>(1,"请求成功",data);
        }

        public static<T> CommonResponse<T> createForFailure() {
            return new CommonResponse<>(0,"请求错误");
        }
        public static<T> CommonResponse<T> createForFailure(String message) {
            return new CommonResponse<>(0,message);
        }

}
