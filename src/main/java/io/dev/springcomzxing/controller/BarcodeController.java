package io.dev.springcomzxing.controller;

import io.dev.springcomzxing.service.BarcodeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping("/api/barcode")
@RequiredArgsConstructor
public class BarcodeController {

    private final BarcodeService barcodeService;

    @GetMapping
    public ResponseEntity<byte[]> barcode(@RequestParam("text") String text) {

        byte[] barcode = barcodeService.getBarcode(text);

        return ResponseEntity
                .ok()
                .header("Content-Type", "image/png")
                .body(barcode);

    }

}
