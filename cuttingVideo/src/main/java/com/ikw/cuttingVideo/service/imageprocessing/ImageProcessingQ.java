package com.ikw.cuttingVideo.service.imageprocessing;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@RequiredArgsConstructor
public class CuttingVideoQ implements CuttingVideoQueue {
    Queue<VideoDto> q = new LinkedList<>();
    List<ImageProcessing> imageProcessingList = new ArrayList<>();

    @Override
    public void addQueue(VideoDto videoDto) {
        q.add(videoDto);
    }

    private void addImageProcessing(ImageProcessing imageProcessing){
        imageProcessingList.add(imageProcessing);
    }

    public void execute(){
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        while(!q.isEmpty()){
            executorService.execute(()->{
                VideoDto poll = q.poll();
                for ()
            });
        }
    }
}
