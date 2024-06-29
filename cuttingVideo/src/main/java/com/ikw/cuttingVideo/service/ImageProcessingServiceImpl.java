package com.ikw.cuttingVideo.service;

import com.ikw.cuttingVideo.controller.dto.TimeDto;
import lombok.RequiredArgsConstructor;
import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFmpegExecutor;
import net.bramp.ffmpeg.builder.FFmpegBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class VideoCuttingService {

    @Value("${ffmpeg.location}")
    private String ffmpegLocation;

    @Value("${output.location}")
    private String outputPath;

    public boolean cuttingFileNoDownload(TimeDto start, TimeDto end, String inputFile, String outputName){
        try{
            FFmpeg fFmpeg = new FFmpeg(ffmpegLocation);
            FFmpegExecutor executor = new FFmpegExecutor(fFmpeg);

            FFmpegBuilder builder = new FFmpegBuilder()
                    .setInput(inputFile)
                    .overrideOutputFiles(false)
                    .addOutput(outputPath+outputName)
                    .setStartOffset(start.getSeconds(), TimeUnit.SECONDS)
                    .setDuration(end.getSeconds(), TimeUnit.SECONDS)
                    .done();

            executor.createJob(builder).run();
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}
