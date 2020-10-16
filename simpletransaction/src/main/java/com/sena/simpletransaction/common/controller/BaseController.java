package com.sena.simpletransaction.common.controller;

import com.sena.simpletransaction.common.api.CommonRs;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;

public class BaseController {
    public <T> ResponseEntity<CommonRs<T>> ok(T data) {
        return new ResponseEntity<>(new CommonRs<>(HttpStatus.OK.value(), "success", data), HttpStatus.OK);
    }

    public <T> ResponseEntity<CommonRs<T>> ok() {
        return new ResponseEntity<>(new CommonRs<>(HttpStatus.OK.value(), "success"), HttpStatus.OK);
    }

    public ResponseEntity<Resource> okDownload(String filename, String mediaType, byte[] data) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"");
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(data.length)
                .contentType(MediaType.parseMediaType(mediaType))
                .body(new ByteArrayResource(data));
    }

    public Pageable pageFromRequest(int page, int size, String sort, Boolean asc) {
        return StringUtils.isEmpty(sort) ? PageRequest.of(page, size) : PageRequest.of(page, size, Sort.by(asc ? Sort.Order.asc(sort) : Sort.Order.desc(sort)));
    }
}
