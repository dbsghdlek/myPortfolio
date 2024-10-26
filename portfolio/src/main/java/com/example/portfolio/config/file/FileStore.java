package com.example.portfolio.config.file;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class FileStore {
    private final String fileDir = "/Users/dbsgh/Documents/file/";

    public String getFullPath(String fileName){
        return new StringBuilder(fileDir).append(fileName).toString();
    }

    public List<UploadFile> storeFiles(List<MultipartFile> multipartFileList) throws IOException {
        List<UploadFile> storeFileList = new ArrayList<>();
        for (MultipartFile multipartFile : multipartFileList) {
            if(!multipartFile.isEmpty()){
                storeFileList.add(storeFile(multipartFile));
            }
        }
        return storeFileList;
    }

    public UploadFile storeFile(MultipartFile multipartFile) throws IOException {
        if (multipartFile.isEmpty()){
            throw new MultipartException("파일이 없습니다.");
        }

        String originalFilename = multipartFile.getOriginalFilename();
        String storeFilename = createStoreFileName(originalFilename);

        multipartFile.transferTo(new File(storeFilename));

        return new UploadFile(originalFilename, storeFilename);
    }

    private String createStoreFileName(String originalFilename){
        String ext = extractExt(originalFilename);
        String uuid = UUID.randomUUID().toString();
        return new StringBuilder(uuid).append(".").append(ext).toString();
    }

    private String extractExt(String originalFilename){
        int pos = originalFilename.lastIndexOf(".");
        return originalFilename.substring(pos);
    }
}
