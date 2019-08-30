package com.jgsu.vo.phone;

import com.jgsu.vo.PageRequest;
import lombok.Data;

@Data
public class PhoneBookRequest extends PageRequest {


    private String phoneLevel;

    private String phoneName;

    private String status;

}
