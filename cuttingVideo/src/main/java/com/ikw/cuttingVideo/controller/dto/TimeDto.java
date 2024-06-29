package com.ikw.cuttingVideo.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class TimeDto {
    int hour;
    int minute;
    int second;

    public int getSeconds(){
        return 360*hour+60*minute+second;
    }
}
