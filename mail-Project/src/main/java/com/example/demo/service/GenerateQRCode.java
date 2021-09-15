package com.example.demo.service;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class GenerateQRCode {
	
	//測試
	public static void main(String[] args) throws WriterException, IOException {
		
		//要連接到的網址
		String qrCodeText = "https://medium.com/k8s%E7%AD%86%E8%A8%98/kubernetes-k8s-service%E5%AF%A6%E7%8F%BE%E8%97%8D%E7%B6%A0%E7%99%BC%E5%B8%83-kubernetes-blue-green-deployment-80d021152d05";
		
		//使用當下時間當檔名
		Date aDate=new Date();
		String QRcodeImgName=aDate.toString();
				
		String filePath = "/Users/guowei/Desktop/Test/"+QRcodeImgName+".png";
		
		//設定QR大小
		int size = 125;
		
		String fileType = "png";
		
		File qrFile = new File(filePath);
		
		File getCode = createQRImage(qrFile, qrCodeText, size, fileType);
		
		System.out.println("DONE");
	}
	
	public static File createQRImage(File qrFile, String qrCodeText, int size, String fileType)
			throws WriterException, IOException {
		// Create the ByteMatrix for the QR-Code that encodes the given String
		Hashtable<EncodeHintType, ErrorCorrectionLevel> hintMap = new Hashtable<>();
		hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix byteMatrix = qrCodeWriter.encode(qrCodeText, BarcodeFormat.QR_CODE, size, size, hintMap);
		// Make the BufferedImage that are to hold the QRCode
		int matrixWidth = byteMatrix.getWidth();
		BufferedImage image = new BufferedImage(matrixWidth, matrixWidth, BufferedImage.TYPE_INT_RGB);
		image.createGraphics();

		Graphics2D graphics = (Graphics2D) image.getGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, matrixWidth, matrixWidth);
		// Paint and save the image using the ByteMatrix
		graphics.setColor(Color.BLACK);

		for (int i = 0; i < matrixWidth; i++) {
			for (int j = 0; j < matrixWidth; j++) {
				if (byteMatrix.get(i, j)) {
					graphics.fillRect(i, j, 1, 1);
				}
			}
		}
		boolean write = ImageIO.write(image,fileType,qrFile);
		
		System.out.println(write);
		
		String name = qrFile.getName();
		
		String path = qrFile.getPath();
		
		System.out.println(path);
		
		System.out.println(name);
		
		return qrFile;
		
		
	}


}
