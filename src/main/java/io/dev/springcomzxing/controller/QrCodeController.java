package io.dev.springcomzxing.controller;

import com.google.zxing.qrcode.encoder.QRCode;
import io.dev.springcomzxing.service.QrCodeService;
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
@RequestMapping("/api/qrcode")
@RequiredArgsConstructor
public class QrCodeController {

    private final QrCodeService qrCodeService;

    @GetMapping
    public ResponseEntity<byte[]> getQRCode(@RequestParam(name = "text", defaultValue = "qrcode") String text) {
        byte[] byteArray = qrCodeService.getQrCode(text);

        return ResponseEntity
                .ok()
                .header("Content-Type", "image/png")
                .body(byteArray);

    }



}
