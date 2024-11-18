package com.example.pricecomparison.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result<T> {
    private int code;
    private String msg;
    private T data;

    /// *
    /// code 0 success
    /// code 1 exist user
    /// code 2 user too short or too long
    /// code 3 password too short or too long
    /// code 4 email is not valid (exist or invalid format )
    public static <T> Result<T> success(T data) {
        return new Result<>(0, "Success", data);
    }

    public static <T> Result<T> success() {
        return new Result<>(0, "Success", null);
    }

    public static <T> Result<T> error(Integer code, String msg) {
        return new Result<>(code, msg, null);
    }
}
