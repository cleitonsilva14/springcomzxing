package io.dev.springcomzxing.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Slf4j
@Service
public class BarcodeService {

    @Value("${app.qrcode.width}")
    private int width;

    @Value("${app.qrcode.height}")
    private int height;


    public byte[] getBarcode(String text) {
        try {
            BitMatrix barcode = new MultiFormatWriter().encode(text, BarcodeFormat.CODE_128, width, height);

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(barcode, "png", outputStream);
            return outputStream.toByteArray();

        }catch (WriterException | IOException e){
            throw new RuntimeException(e);
        }
    }


}
