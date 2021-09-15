package com.example.demo.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.mail.search.FlagTerm;

import org.apache.commons.io.FileUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.google.zxing.WriterException;

import org.springframework.stereotype.Service;


@Service
@Async
public class MailService {
	
	
	@Autowired
	private JavaMailSenderImpl mailSender;  
	
	
	
	public void sendEMail(String to,String body,String topic) throws MessagingException {

		System.out.println("sending Mail.....");
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
	    
	       
	       try {
	    	   
	    	messageHelper.setFrom("javaiii0729@gmail.com");
		    messageHelper.setTo(to);
		    
		    messageHelper.setSubject("謝謝您購買我的保險講義");
		    
		 
	        messageHelper.setText(
	            "<html><head></head><body><h1>Hello! Spring!"
	            + "</h1>" 
	            + "</body></html>", true);
		    
		   
//		    messageHelper.setText("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional //EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n"
//		    		+ "\n"
//		    		+ "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" xmlns:v=\"urn:schemas-microsoft-com:vml\">\n"
//		    		+ "<head>\n"
//		    		+ "<!--[if gte mso 9]><xml><o:OfficeDocumentSettings><o:AllowPNG/><o:PixelsPerInch>96</o:PixelsPerInch></o:OfficeDocumentSettings></xml><![endif]-->\n"
//		    		+ "<meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\"/>\n"
//		    		+ "<meta content=\"width=device-width\" name=\"viewport\"/>\n"
//		    		+ "<!--[if !mso]><!-->\n"
//		    		+ "<meta content=\"IE=edge\" http-equiv=\"X-UA-Compatible\"/>\n"
//		    		+ "<!--<![endif]-->\n"
//		    		+ "<title></title>\n"
//		    		+ "<!--[if !mso]><!-->\n"
//		    		+ "<link href=\"https://fonts.googleapis.com/css?family=Roboto\" rel=\"stylesheet\" type=\"text/css\"/>\n"
//		    		+ "<link href=\"https://fonts.googleapis.com/css?family=Abril+Fatface\" rel=\"stylesheet\" type=\"text/css\"/>\n"
//		    		+ "<link href=\"https://fonts.googleapis.com/css?family=Merriweather\" rel=\"stylesheet\" type=\"text/css\"/>\n"
//		    		+ "<link href=\"https://fonts.googleapis.com/css?family=Montserrat\" rel=\"stylesheet\" type=\"text/css\"/>\n"
//		    		+ "<!--<![endif]-->\n"
//		    		+ "<style type=\"text/css\">\n"
//		    		+ "		body {\n"
//		    		+ "			margin: 0;\n"
//		    		+ "			padding: 0;\n"
//		    		+ "		}\n"
//		    		+ "\n"
//		    		+ "		table,\n"
//		    		+ "		td,\n"
//		    		+ "		tr {\n"
//		    		+ "			vertical-align: top;\n"
//		    		+ "			border-collapse: collapse;\n"
//		    		+ "		}\n"
//		    		+ "\n"
//		    		+ "		* {\n"
//		    		+ "			line-height: inherit;\n"
//		    		+ "		}\n"
//		    		+ "\n"
//		    		+ "		a[x-apple-data-detectors=true] {\n"
//		    		+ "			color: inherit !important;\n"
//		    		+ "			text-decoration: none !important;\n"
//		    		+ "		}\n"
//		    		+ "	</style>\n"
//		    		+ "<style id=\"media-query\" type=\"text/css\">\n"
//		    		+ "		@media (max-width: 700px) {\n"
//		    		+ "\n"
//		    		+ "			.block-grid,\n"
//		    		+ "			.col {\n"
//		    		+ "				min-width: 320px !important;\n"
//		    		+ "				max-width: 100% !important;\n"
//		    		+ "				display: block !important;\n"
//		    		+ "			}\n"
//		    		+ "\n"
//		    		+ "			.block-grid {\n"
//		    		+ "				width: 100% !important;\n"
//		    		+ "			}\n"
//		    		+ "\n"
//		    		+ "			.col {\n"
//		    		+ "				width: 100% !important;\n"
//		    		+ "			}\n"
//		    		+ "\n"
//		    		+ "			.col_cont {\n"
//		    		+ "				margin: 0 auto;\n"
//		    		+ "			}\n"
//		    		+ "\n"
//		    		+ "			img.fullwidth,\n"
//		    		+ "			img.fullwidthOnMobile {\n"
//		    		+ "				max-width: 100% !important;\n"
//		    		+ "			}\n"
//		    		+ "\n"
//		    		+ "			.no-stack .col {\n"
//		    		+ "				min-width: 0 !important;\n"
//		    		+ "				display: table-cell !important;\n"
//		    		+ "			}\n"
//		    		+ "\n"
//		    		+ "			.no-stack.two-up .col {\n"
//		    		+ "				width: 50% !important;\n"
//		    		+ "			}\n"
//		    		+ "\n"
//		    		+ "			.no-stack .col.num2 {\n"
//		    		+ "				width: 16.6% !important;\n"
//		    		+ "			}\n"
//		    		+ "\n"
//		    		+ "			.no-stack .col.num3 {\n"
//		    		+ "				width: 25% !important;\n"
//		    		+ "			}\n"
//		    		+ "\n"
//		    		+ "			.no-stack .col.num4 {\n"
//		    		+ "				width: 33% !important;\n"
//		    		+ "			}\n"
//		    		+ "\n"
//		    		+ "			.no-stack .col.num5 {\n"
//		    		+ "				width: 41.6% !important;\n"
//		    		+ "			}\n"
//		    		+ "\n"
//		    		+ "			.no-stack .col.num6 {\n"
//		    		+ "				width: 50% !important;\n"
//		    		+ "			}\n"
//		    		+ "\n"
//		    		+ "			.no-stack .col.num7 {\n"
//		    		+ "				width: 58.3% !important;\n"
//		    		+ "			}\n"
//		    		+ "\n"
//		    		+ "			.no-stack .col.num8 {\n"
//		    		+ "				width: 66.6% !important;\n" + "			}\n" + "\n"
//							+ "			.no-stack .col.num9 {\n" + "				width: 75% !important;\n"
//							+ "			}\n" + "\n" + "			.no-stack .col.num10 {\n"
//							+ "				width: 83.3% !important;\n" + "			}\n" + "\n"
//							+ "			.video-block {\n" + "				max-width: none !important;\n"
//							+ "			}\n" + "\n" + "			.mobile_hide {\n" + "				min-height: 0px;\n"
//							+ "				max-height: 0px;\n" + "				max-width: 0px;\n"
//							+ "				display: none;\n" + "				overflow: hidden;\n"
//							+ "				font-size: 0px;\n" + "			}\n" + "\n" + "			.desktop_hide {\n"
//							+ "				display: block !important;\n"
//							+ "				max-height: none !important;\n" + "			}\n" + "		}\n"
//							+ "	</style>\n" + "<style id=\"menu-media-query\" type=\"text/css\">\n"
//							+ "		@media (max-width: 700px) {\n"
//							+ "			.menu-checkbox[type=\"checkbox\"]~.menu-links {\n"
//							+ "				display: none !important;\n" + "				padding: 5px 0;\n"
//							+ "			}\n" + "\n"
//							+ "			.menu-checkbox[type=\"checkbox\"]~.menu-links span.sep {\n"
//							+ "				display: none;\n" + "			}\n" + "\n"
//							+ "			.menu-checkbox[type=\"checkbox\"]:checked~.menu-links,\n"
//							+ "			.menu-checkbox[type=\"checkbox\"]~.menu-trigger {\n"
//							+ "				display: block !important;\n"
//							+ "				max-width: none !important;\n"
//							+ "				max-height: none !important;\n"
//							+ "				font-size: inherit !important;\n" + "			}\n" + "\n"
//							+ "			.menu-checkbox[type=\"checkbox\"]~.menu-links>a,\n"
//							+ "			.menu-checkbox[type=\"checkbox\"]~.menu-links>span.label {\n"
//							+ "				display: block !important;\n" + "				text-align: center;\n"
//							+ "			}\n" + "\n"
//							+ "			.menu-checkbox[type=\"checkbox\"]:checked~.menu-trigger .menu-close {\n"
//							+ "				display: block !important;\n" + "			}\n" + "\n"
//							+ "			.menu-checkbox[type=\"checkbox\"]:checked~.menu-trigger .menu-open {\n"
//							+ "				display: none !important;\n" + "			}\n" + "\n"
//							+ "			#menu6kkwd3~div label {\n" + "				border-radius: 0% !important;\n"
//							+ "			}\n" + "\n" + "			#menu6kkwd3:checked~.menu-links {\n"
//							+ "				background-color: #9dc185 !important;\n" + "			}\n" + "\n"
//							+ "			#menu6kkwd3:checked~.menu-links a {\n"
//							+ "				color: #ffffff !important;\n" + "			}\n" + "\n"
//							+ "			#menu6kkwd3:checked~.menu-links span {\n"
//							+ "				color: #ffffff !important;\n" + "			}\n" + "		}\n"
//							+ "	</style>\n" + "<style id=\"icon-media-query\" type=\"text/css\">\n"
//							+ "		@media (max-width: 700px) {\n" + "			.icons-inner {\n"
//							+ "				text-align: center;\n" + "			}\n" + "\n"
//							+ "			.icons-inner td {\n" + "				margin: 0 auto;\n" + "			}\n"
//							+ "		}\n" + "	</style>\n" + "</head>\n"
//							+ "<body class=\"clean-body\" style=\"margin: 0; padding: 0; -webkit-text-size-adjust: 100%; background-color: #f2f2f2;\">\n"
//							+ "<!--[if IE]><div class=\"ie-browser\"><![endif]-->\n"
//							+ "<table bgcolor=\"#f2f2f2\" cellpadding=\"0\" cellspacing=\"0\" class=\"nl-container\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; min-width: 320px; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #f2f2f2; width: 100%;\" valign=\"top\" width=\"100%\">\n"
//							+ "<tbody>\n" + "<tr style=\"vertical-align: top;\" valign=\"top\">\n"
//							+ "<td style=\"word-break: break-word; vertical-align: top;\" valign=\"top\">\n"
//							+ "<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td align=\"center\" style=\"background-color:#f2f2f2\"><![endif]-->\n"
//							+ "<div style=\"background-color:transparent;\">\n"
//							+ "<div class=\"block-grid\" style=\"min-width: 320px; max-width: 680px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; Margin: 0 auto; background-color: #eaf2e8;\">\n"
//							+ "<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#eaf2e8;background-image:url('images/header-bg.png');background-position:top left;background-repeat:no-repeat\">\n"
//							+ "<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:680px\"><tr class=\"layout-full-width\" style=\"background-color:#eaf2e8\"><![endif]-->\n"
//							+ "<!--[if (mso)|(IE)]><td align=\"center\" width=\"680\" style=\"background-color:#eaf2e8;width:680px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:0px;\"><![endif]-->\n"
//							+ "<div class=\"col num12\" style=\"min-width: 320px; max-width: 680px; display: table-cell; vertical-align: top; width: 680px;\">\n"
//							+ "<div class=\"col_cont\" style=\"width:100% !important;\">\n"
//							+ "<!--[if (!mso)&(!IE)]><!-->\n"
//							+ "<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:0px; padding-bottom:0px; padding-right: 0px; padding-left: 0px;\">\n"
//							+ "<!--<![endif]-->\n"
//							+ "<div align=\"center\" class=\"img-container center fixedwidth\" style=\"padding-right: 20px;padding-left: 20px;\">\n"
//							+ "<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"padding-right: 20px;padding-left: 20px;\" align=\"center\"><![endif]-->\n"
//							+ "<div style=\"font-size:1px;line-height:20px\"> </div><img align=\"center\" alt=\"Your Logo\" border=\"0\" class=\"center fixedwidth\" src=\"images/logo_sm.png\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: 0; width: 100%; max-width: 100px; display: block;\" title=\"Your Logo\" width=\"100\"/>\n"
//							+ "<div style=\"font-size:1px;line-height:20px\"> </div>\n"
//							+ "<!--[if mso]></td></tr></table><![endif]-->\n" + "</div>\n"
//							+ "<table cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" valign=\"top\" width=\"100%\">\n"
//							+ "<tr style=\"vertical-align: top;\" valign=\"top\">\n"
//							+ "<td align=\"center\" style=\"word-break: break-word; vertical-align: top; padding-bottom: 0px; padding-left: 0px; padding-right: 0px; padding-top: 0px; text-align: center; width: 100%;\" valign=\"top\" width=\"100%\">\n"
//							+ "<h1 style=\"color:#9ab886;direction:ltr;font-family:Cabin, Arial, Helvetica Neue, Helvetica, sans-serif;font-size:54px;font-weight:normal;letter-spacing:5px;line-height:120%;text-align:center;margin-top:0;margin-bottom:0;\">TIME TO</h1>\n"
//							+ "</td>\n" + "</tr>\n" + "</table>\n"
//							+ "<table cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" valign=\"top\" width=\"100%\">\n"
//							+ "<tr style=\"vertical-align: top;\" valign=\"top\">\n"
//							+ "<td align=\"center\" style=\"word-break: break-word; vertical-align: top; padding-bottom: 0px; padding-left: 0px; padding-right: 0px; padding-top: 0px; text-align: center; width: 100%;\" valign=\"top\" width=\"100%\">\n"
//							+ "<h1 style=\"color:#3f783b;direction:ltr;font-family:Cabin, Arial, Helvetica Neue, Helvetica, sans-serif;font-size:100px;font-weight:normal;letter-spacing:5px;line-height:120%;text-align:center;margin-top:0;margin-bottom:0;\">GIVE</h1>\n"
//							+ "</td>\n" + "</tr>\n" + "</table>\n"
//							+ "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\" width=\"100%\">\n"
//							+ "<tbody>\n" + "<tr style=\"vertical-align: top;\" valign=\"top\">\n"
//							+ "<td class=\"divider_inner\" style=\"word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 10px; padding-right: 10px; padding-bottom: 10px; padding-left: 10px;\" valign=\"top\">\n"
//							+ "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider_content\" height=\"35\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 0px solid transparent; height: 35px; width: 100%;\" valign=\"top\" width=\"100%\">\n"
//							+ "<tbody>\n" + "<tr style=\"vertical-align: top;\" valign=\"top\">\n"
//							+ "<td height=\"35\" style=\"word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\"><span></span></td>\n"
//							+ "</tr>\n" + "</tbody>\n" + "</table>\n" + "</td>\n" + "</tr>\n" + "</tbody>\n"
//							+ "</table>\n" + "<!--[if (!mso)&(!IE)]><!-->\n" + "</div>\n" + "<!--<![endif]-->\n"
//							+ "</div>\n" + "</div>\n" + "<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n"
//							+ "<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" + "</div>\n"
//							+ "</div>\n" + "</div>\n" + "<div style=\"background-color:transparent;\">\n"
//							+ "<div class=\"block-grid\" style=\"min-width: 320px; max-width: 680px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; Margin: 0 auto; background-color: #ffffff;\">\n"
//							+ "<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#ffffff;\">\n"
//							+ "<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:680px\"><tr class=\"layout-full-width\" style=\"background-color:#ffffff\"><![endif]-->\n"
//							+ "<!--[if (mso)|(IE)]><td align=\"center\" width=\"680\" style=\"background-color:#ffffff;width:680px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:0px;\"><![endif]-->\n"
//							+ "<div class=\"col num12\" style=\"min-width: 320px; max-width: 680px; display: table-cell; vertical-align: top; width: 680px;\">\n"
//							+ "<div class=\"col_cont\" style=\"width:100% !important;\">\n"
//							+ "<!--[if (!mso)&(!IE)]><!-->\n"
//							+ "<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:0px; padding-bottom:0px; padding-right: 0px; padding-left: 0px;\">\n"
//							+ "<!--<![endif]-->\n"
//							+ "<table cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" valign=\"top\" width=\"100%\">\n"
//							+ "<tr style=\"vertical-align: top;\" valign=\"top\">\n"
//							+ "<td align=\"center\" style=\"word-break: break-word; vertical-align: top; padding-bottom: 10px; padding-left: 30px; padding-right: 30px; padding-top: 40px; text-align: center; width: 100%;\" valign=\"top\" width=\"100%\">\n"
//							+ "<h3 style=\"color:#c0d3b8;direction:ltr;font-family:Cabin, Arial, Helvetica Neue, Helvetica, sans-serif;font-size:16px;font-weight:normal;letter-spacing:6px;line-height:120%;text-align:center;margin-top:0;margin-bottom:0;\">CELEBRATING</h3>\n"
//							+ "</td>\n" + "</tr>\n" + "</table>\n"
//							+ "<table cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" valign=\"top\" width=\"100%\">\n"
//							+ "<tr style=\"vertical-align: top;\" valign=\"top\">\n"
//							+ "<td align=\"center\" style=\"word-break: break-word; vertical-align: top; padding-bottom: 10px; padding-left: 30px; padding-right: 30px; padding-top: 10px; text-align: center; width: 100%;\" valign=\"top\" width=\"100%\">\n"
//							+ "<h1 style=\"color:#40ab35;direction:ltr;font-family:Cabin, Arial, Helvetica Neue, Helvetica, sans-serif;font-size:26px;font-weight:normal;letter-spacing:normal;line-height:120%;text-align:center;margin-top:0;margin-bottom:0;\">World Environment Day</h1>\n"
//							+ "</td>\n" + "</tr>\n" + "</table>\n"
//							+ "<table cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" valign=\"top\" width=\"100%\">\n"
//							+ "<tr style=\"vertical-align: top;\" valign=\"top\">\n"
//							+ "<td align=\"center\" style=\"word-break: break-word; vertical-align: top; padding-bottom: 10px; padding-left: 30px; padding-right: 30px; padding-top: 10px; text-align: center; width: 100%;\" valign=\"top\" width=\"100%\">\n"
//							+ "<h3 style=\"color:#c0d3b8;direction:ltr;font-family:Cabin, Arial, Helvetica Neue, Helvetica, sans-serif;font-size:20px;font-weight:normal;letter-spacing:4px;line-height:120%;text-align:center;margin-top:0;margin-bottom:0;\">05 June</h3>\n"
//							+ "</td>\n" + "</tr>\n" + "</table>\n"
//							+ "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\" width=\"100%\">\n"
//							+ "<tbody>\n" + "<tr style=\"vertical-align: top;\" valign=\"top\">\n"
//							+ "<td class=\"divider_inner\" style=\"word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 20px; padding-right: 20px; padding-bottom: 20px; padding-left: 20px;\" valign=\"top\">\n"
//							+ "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider_content\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 3px solid #6BAE72; width: 10%;\" valign=\"top\" width=\"10%\">\n"
//							+ "<tbody>\n" + "<tr style=\"vertical-align: top;\" valign=\"top\">\n"
//							+ "<td style=\"word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\"><span></span></td>\n"
//							+ "</tr>\n" + "</tbody>\n" + "</table>\n" + "</td>\n" + "</tr>\n" + "</tbody>\n"
//							+ "</table>\n"
//							+ "<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 40px; padding-left: 40px; padding-top: 15px; padding-bottom: 15px; font-family: Arial, sans-serif\"><![endif]-->\n"
//							+ "<div style=\"color:#000000;font-family:Cabin, Arial, Helvetica Neue, Helvetica, sans-serif;line-height:1.5;padding-top:15px;padding-right:40px;padding-bottom:15px;padding-left:40px;\">\n"
//							+ "<div class=\"txtTinyMce-wrapper\" style=\"line-height: 1.5; font-size: 12px; color: #000000; font-family: Cabin, Arial, Helvetica Neue, Helvetica, sans-serif; mso-line-height-alt: 18px;\">\n"
//							+ "<p style=\"margin: 0; font-size: 18px; line-height: 1.5; word-break: break-word; text-align: center; mso-line-height-alt: 27px; margin-top: 0; margin-bottom: 0;\"><span style=\"font-size: 18px;\">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</span></p>\n"
//							+ "</div>\n" + "</div>\n" + "<!--[if mso]></td></tr></table><![endif]-->\n"
//							+ "<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 35px; padding-left: 35px; padding-top: 10px; padding-bottom: 30px; font-family: Arial, sans-serif\"><![endif]-->\n"
//							+ "<div style=\"color:#b5b5b5;font-family:Cabin, Arial, Helvetica Neue, Helvetica, sans-serif;line-height:1.5;padding-top:10px;padding-right:35px;padding-bottom:30px;padding-left:35px;\">\n"
//							+ "<div class=\"txtTinyMce-wrapper\" style=\"line-height: 1.5; font-size: 12px; color: #b5b5b5; font-family: Cabin, Arial, Helvetica Neue, Helvetica, sans-serif; mso-line-height-alt: 18px;\">\n"
//							+ "<p style=\"margin: 0; font-size: 18px; line-height: 1.5; word-break: break-word; text-align: center; mso-line-height-alt: 27px; margin-top: 0; margin-bottom: 0;\"><span style=\"font-size: 18px;\">Help us to reach the goal!</span></p>\n"
//							+ "</div>\n" + "</div>\n" + "<!--[if mso]></td></tr></table><![endif]-->\n"
//							+ "<!--[if (!mso)&(!IE)]><!-->\n" + "</div>\n" + "<!--<![endif]-->\n" + "</div>\n"
//							+ "</div>\n" + "<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n"
//							+ "<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" + "</div>\n"
//							+ "</div>\n" + "</div>\n" + "<div style=\"background-color:transparent;\">\n"
//							+ "<div class=\"block-grid\" style=\"min-width: 320px; max-width: 680px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; Margin: 0 auto; background-color: #fbfbfb;\">\n"
//							+ "<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#fbfbfb;background-image:url('images/body-bg-02.png');background-position:top left;background-repeat:no-repeat\">\n"
//							+ "<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:680px\"><tr class=\"layout-full-width\" style=\"background-color:#fbfbfb\"><![endif]-->\n"
//							+ "<!--[if (mso)|(IE)]><td align=\"center\" width=\"680\" style=\"background-color:#fbfbfb;width:680px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:0px;\"><![endif]-->\n"
//							+ "<div class=\"col num12\" style=\"min-width: 320px; max-width: 680px; display: table-cell; vertical-align: top; width: 680px;\">\n"
//							+ "<div class=\"col_cont\" style=\"width:100% !important;\">\n"
//							+ "<!--[if (!mso)&(!IE)]><!-->\n"
//							+ "<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:0px; padding-bottom:0px; padding-right: 0px; padding-left: 0px;\">\n"
//							+ "<!--<![endif]-->\n"
//							+ "<table cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" valign=\"top\" width=\"100%\">\n"
//							+ "<tr style=\"vertical-align: top;\" valign=\"top\">\n"
//							+ "<td align=\"center\" style=\"word-break: break-word; vertical-align: top; padding-bottom: 0px; padding-left: 0px; padding-right: 0px; padding-top: 40px; text-align: center; width: 100%;\" valign=\"top\" width=\"100%\">\n"
//							+ "<h1 style=\"color:#f39200;direction:ltr;font-family:Cabin, Arial, Helvetica Neue, Helvetica, sans-serif;font-size:59px;font-weight:normal;letter-spacing:5px;line-height:120%;text-align:center;margin-top:0;margin-bottom:0;\">$50.000</h1>\n"
//							+ "</td>\n" + "</tr>\n" + "</table>\n"
//							+ "<div align=\"center\" class=\"img-container center autowidth\" style=\"padding-right: 40px;padding-left: 40px;\">\n"
//							+ "<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"padding-right: 40px;padding-left: 40px;\" align=\"center\"><![endif]-->\n"
//							+ "<div style=\"font-size:1px;line-height:20px\"> </div><img align=\"center\" alt=\"Fundraising Goal\" border=\"0\" class=\"center autowidth\" src=\"images/fund-number-bar.png\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: 0; width: 100%; max-width: 271px; display: block;\" title=\"Fundraising Goal\" width=\"271\"/>\n"
//							+ "<div style=\"font-size:1px;line-height:40px\"> </div>\n"
//							+ "<!--[if mso]></td></tr></table><![endif]-->\n" + "</div>\n"
//							+ "<div align=\"center\" class=\"button-container\" style=\"padding-top:0px;padding-right:0px;padding-bottom:0px;padding-left:0px;\">\n"
//							+ "<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-spacing: 0; border-collapse: collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\"><tr><td style=\"padding-top: 0px; padding-right: 0px; padding-bottom: 0px; padding-left: 0px\" align=\"center\"><v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:w=\"urn:schemas-microsoft-com:office:word\" href=\"\" style=\"height:36pt;width:178.5pt;v-text-anchor:middle;\" arcsize=\"63%\" strokeweight=\"2.25pt\" strokecolor=\"#F39200\" fill=\"false\"><w:anchorlock/><v:textbox inset=\"0,0,0,0\"><center style=\"color:#f39200; font-family:Arial, sans-serif; font-size:16px\"><![endif]-->\n"
//							+ "<div style=\"text-decoration:none;display:inline-block;color:#f39200;background-color:transparent;border-radius:30px;-webkit-border-radius:30px;-moz-border-radius:30px;width:auto; width:auto;;border-top:3px solid #F39200;border-right:3px solid #F39200;border-bottom:3px solid #F39200;border-left:3px solid #F39200;padding-top:5px;padding-bottom:5px;font-family:Cabin, Arial, Helvetica Neue, Helvetica, sans-serif;text-align:center;mso-border-alt:none;word-break:keep-all;\"><span style=\"padding-left:40px;padding-right:40px;font-size:16px;display:inline-block;letter-spacing:1px;\"><span style=\"font-size: 16px; line-height: 2; word-break: break-word; mso-line-height-alt: 32px;\"><span data-mce-style=\"font-size: 16px; line-height: 32px;\" style=\"font-size: 16px; line-height: 32px;\"><strong>DONATE</strong></span></span></span></div>\n"
//							+ "<!--[if mso]></center></v:textbox></v:roundrect></td></tr></table><![endif]-->\n"
//							+ "</div>\n"
//							+ "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\" width=\"100%\">\n"
//							+ "<tbody>\n" + "<tr style=\"vertical-align: top;\" valign=\"top\">\n"
//							+ "<td class=\"divider_inner\" style=\"word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 10px; padding-right: 10px; padding-bottom: 10px; padding-left: 10px;\" valign=\"top\">\n"
//							+ "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider_content\" height=\"35\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 0px solid transparent; height: 35px; width: 100%;\" valign=\"top\" width=\"100%\">\n"
//							+ "<tbody>\n" + "<tr style=\"vertical-align: top;\" valign=\"top\">\n"
//							+ "<td height=\"35\" style=\"word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\"><span></span></td>\n"
//							+ "</tr>\n" + "</tbody>\n" + "</table>\n" + "</td>\n" + "</tr>\n" + "</tbody>\n"
//							+ "</table>\n" + "<!--[if (!mso)&(!IE)]><!-->\n" + "</div>\n" + "<!--<![endif]-->\n"
//							+ "</div>\n" + "</div>\n" + "<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n"
//							+ "<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" + "</div>\n"
//							+ "</div>\n" + "</div>\n" + "<div style=\"background-color:transparent;\">\n"
//							+ "<div class=\"block-grid\" style=\"min-width: 320px; max-width: 680px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; Margin: 0 auto; background-color: #ffffff;\">\n"
//							+ "<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#ffffff;\">\n"
//							+ "<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:680px\"><tr class=\"layout-full-width\" style=\"background-color:#ffffff\"><![endif]-->\n"
//							+ "<!--[if (mso)|(IE)]><td align=\"center\" width=\"680\" style=\"background-color:#ffffff;width:680px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:0px;\"><![endif]-->\n"
//							+ "<div class=\"col num12\" style=\"min-width: 320px; max-width: 680px; display: table-cell; vertical-align: top; width: 680px;\">\n"
//							+ "<div class=\"col_cont\" style=\"width:100% !important;\">\n"
//							+ "<!--[if (!mso)&(!IE)]><!-->\n"
//							+ "<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:0px; padding-bottom:0px; padding-right: 0px; padding-left: 0px;\">\n"
//							+ "<!--<![endif]-->\n"
//							+ "<div align=\"center\" class=\"img-container center autowidth\" style=\"padding-right: 0px;padding-left: 0px;\">\n"
//							+ "<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\"><![endif]-->\n"
//							+ "<div style=\"font-size:1px;line-height:30px\"> </div><img align=\"center\" alt=\"Divider\" border=\"0\" class=\"center autowidth\" src=\"images/plant-divider.png\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: 0; width: 100%; max-width: 38px; display: block;\" title=\"Divider\" width=\"38\"/>\n"
//							+ "<div style=\"font-size:1px;line-height:30px\"> </div>\n"
//							+ "<!--[if mso]></td></tr></table><![endif]-->\n" + "</div>\n"
//							+ "<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 40px; padding-left: 40px; padding-top: 15px; padding-bottom: 15px; font-family: Arial, sans-serif\"><![endif]-->\n"
//							+ "<div style=\"color:#000000;font-family:Cabin, Arial, Helvetica Neue, Helvetica, sans-serif;line-height:1.5;padding-top:15px;padding-right:40px;padding-bottom:15px;padding-left:40px;\">\n"
//							+ "<div class=\"txtTinyMce-wrapper\" style=\"line-height: 1.5; font-size: 12px; color: #000000; font-family: Cabin, Arial, Helvetica Neue, Helvetica, sans-serif; mso-line-height-alt: 18px;\">\n"
//							+ "<p style=\"margin: 0; font-size: 18px; line-height: 1.5; word-break: break-word; text-align: center; mso-line-height-alt: 27px; margin-top: 0; margin-bottom: 0;\"><span style=\"font-size: 18px;\">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</span></p>\n"
//							+ "</div>\n" + "</div>\n" + "<!--[if mso]></td></tr></table><![endif]-->\n"
//							+ "<!--[if (!mso)&(!IE)]><!-->\n" + "</div>\n" + "<!--<![endif]-->\n" + "</div>\n"
//							+ "</div>\n" + "<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n"
//							+ "<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" + "</div>\n"
//							+ "</div>\n" + "</div>\n" + "<div style=\"background-color:transparent;\">\n"
//							+ "<div class=\"block-grid five-up\" style=\"min-width: 320px; max-width: 680px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; Margin: 0 auto; background-color: #ffffff;\">\n"
//							+ "<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#ffffff;\">\n"
//							+ "<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:680px\"><tr class=\"layout-full-width\" style=\"background-color:#ffffff\"><![endif]-->\n"
//							+ "<!--[if (mso)|(IE)]><td align=\"center\" width=\"170\" style=\"background-color:#ffffff;width:170px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:0px;\"><![endif]-->\n"
//							+ "<div class=\"col num3\" style=\"display: table-cell; vertical-align: top; max-width: 320px; min-width: 168px; width: 170px;\">\n"
//							+ "<div class=\"col_cont\" style=\"width:100% !important;\">\n"
//							+ "<!--[if (!mso)&(!IE)]><!-->\n"
//							+ "<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:0px; padding-right: 0px; padding-left: 0px;\">\n"
//							+ "<!--<![endif]-->\n"
//							+ "<div align=\"center\" class=\"img-container center autowidth\" style=\"padding-right: 20px;padding-left: 30px;\">\n"
//							+ "<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"padding-right: 20px;padding-left: 30px;\" align=\"center\"><![endif]-->\n"
//							+ "<div style=\"font-size:1px;line-height:20px\"> </div><img align=\"center\" border=\"0\" class=\"center autowidth\" src=\"images/img-body_1.png\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: 0; width: 100%; max-width: 120px; display: block;\" width=\"120\"/>\n"
//							+ "<div style=\"font-size:1px;line-height:10px\"> </div>\n"
//							+ "<!--[if mso]></td></tr></table><![endif]-->\n" + "</div>\n"
//							+ "<!--[if (!mso)&(!IE)]><!-->\n" + "</div>\n" + "<!--<![endif]-->\n" + "</div>\n"
//							+ "</div>\n" + "<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n"
//							+ "<!--[if (mso)|(IE)]></td><td align=\"center\" width=\"113\" style=\"background-color:#ffffff;width:113px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px;\"><![endif]-->\n"
//							+ "<div class=\"col num2\" style=\"display: table-cell; vertical-align: top; max-width: 320px; min-width: 112px; width: 113px;\">\n"
//							+ "<div class=\"col_cont\" style=\"width:100% !important;\">\n"
//							+ "<!--[if (!mso)&(!IE)]><!-->\n"
//							+ "<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n"
//							+ "<!--<![endif]-->\n"
//							+ "<div align=\"center\" class=\"img-container center autowidth\" style=\"padding-right: 10px;padding-left: 10px;\">\n"
//							+ "<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"padding-right: 10px;padding-left: 10px;\" align=\"center\"><![endif]-->\n"
//							+ "<div style=\"font-size:1px;line-height:10px\"> </div><img align=\"center\" border=\"0\" class=\"center autowidth\" src=\"images/img-body_2.png\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: 0; width: 100%; max-width: 93px; display: block;\" width=\"93\"/>\n"
//							+ "<div style=\"font-size:1px;line-height:10px\"> </div>\n"
//							+ "<!--[if mso]></td></tr></table><![endif]-->\n" + "</div>\n"
//							+ "<!--[if (!mso)&(!IE)]><!-->\n" + "</div>\n" + "<!--<![endif]-->\n" + "</div>\n"
//							+ "</div>\n" + "<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n"
//							+ "<!--[if (mso)|(IE)]></td><td align=\"center\" width=\"113\" style=\"background-color:#ffffff;width:113px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px;\"><![endif]-->\n"
//							+ "<div class=\"col num2\" style=\"display: table-cell; vertical-align: top; max-width: 320px; min-width: 112px; width: 113px;\">\n"
//							+ "<div class=\"col_cont\" style=\"width:100% !important;\">\n"
//							+ "<!--[if (!mso)&(!IE)]><!-->\n"
//							+ "<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n"
//							+ "<!--<![endif]-->\n"
//							+ "<div align=\"center\" class=\"img-container center autowidth\" style=\"padding-right: 10px;padding-left: 10px;\">\n"
//							+ "<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"padding-right: 10px;padding-left: 10px;\" align=\"center\"><![endif]-->\n"
//							+ "<div style=\"font-size:1px;line-height:40px\"> </div><img align=\"center\" border=\"0\" class=\"center autowidth\" src=\"images/img-body_3.png\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: 0; width: 100%; max-width: 93px; display: block;\" width=\"93\"/>\n"
//							+ "<div style=\"font-size:1px;line-height:10px\"> </div>\n"
//							+ "<!--[if mso]></td></tr></table><![endif]-->\n" + "</div>\n"
//							+ "<!--[if (!mso)&(!IE)]><!-->\n" + "</div>\n" + "<!--<![endif]-->\n" + "</div>\n"
//							+ "</div>\n" + "<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n"
//							+ "<!--[if (mso)|(IE)]></td><td align=\"center\" width=\"113\" style=\"background-color:#ffffff;width:113px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px;\"><![endif]-->\n"
//							+ "<div class=\"col num2\" style=\"display: table-cell; vertical-align: top; max-width: 320px; min-width: 112px; width: 113px;\">\n"
//							+ "<div class=\"col_cont\" style=\"width:100% !important;\">\n"
//							+ "<!--[if (!mso)&(!IE)]><!-->\n"
//							+ "<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n"
//							+ "<!--<![endif]-->\n"
//							+ "<div align=\"center\" class=\"img-container center autowidth\" style=\"padding-right: 10px;padding-left: 10px;\">\n"
//							+ "<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"padding-right: 10px;padding-left: 10px;\" align=\"center\"><![endif]-->\n"
//							+ "<div style=\"font-size:1px;line-height:10px\"> </div><img align=\"center\" border=\"0\" class=\"center autowidth\" src=\"images/img-body_4.png\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: 0; width: 100%; max-width: 93px; display: block;\" width=\"93\"/>\n"
//							+ "<div style=\"font-size:1px;line-height:10px\"> </div>\n"
//							+ "<!--[if mso]></td></tr></table><![endif]-->\n" + "</div>\n"
//							+ "<!--[if (!mso)&(!IE)]><!-->\n" + "</div>\n" + "<!--<![endif]-->\n" + "</div>\n"
//							+ "</div>\n" + "<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n"
//							+ "<!--[if (mso)|(IE)]></td><td align=\"center\" width=\"170\" style=\"background-color:#ffffff;width:170px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:30px;\"><![endif]-->\n"
//							+ "<div class=\"col num3\" style=\"display: table-cell; vertical-align: top; max-width: 320px; min-width: 168px; width: 170px;\">\n"
//							+ "<div class=\"col_cont\" style=\"width:100% !important;\">\n"
//							+ "<!--[if (!mso)&(!IE)]><!-->\n"
//							+ "<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:30px; padding-right: 0px; padding-left: 0px;\">\n"
//							+ "<!--<![endif]-->\n"
//							+ "<div align=\"center\" class=\"img-container center autowidth\" style=\"padding-right: 30px;padding-left: 10px;\">\n"
//							+ "<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"padding-right: 30px;padding-left: 10px;\" align=\"center\"><![endif]-->\n"
//							+ "<div style=\"font-size:1px;line-height:20px\"> </div><img align=\"center\" border=\"0\" class=\"center autowidth\" src=\"images/img-body_5.png\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: 0; width: 100%; max-width: 126px; display: block;\" width=\"126\"/>\n"
//							+ "<div style=\"font-size:1px;line-height:10px\"> </div>\n"
//							+ "<!--[if mso]></td></tr></table><![endif]-->\n" + "</div>\n"
//							+ "<!--[if (!mso)&(!IE)]><!-->\n" + "</div>\n" + "<!--<![endif]-->\n" + "</div>\n"
//							+ "</div>\n" + "<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n"
//							+ "<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" + "</div>\n"
//							+ "</div>\n" + "</div>\n" + "<div style=\"background-color:transparent;\">\n"
//							+ "<div class=\"block-grid\" style=\"min-width: 320px; max-width: 680px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; Margin: 0 auto; background-color: #fbfbfb;\">\n"
//							+ "<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#fbfbfb;\">\n"
//							+ "<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:680px\"><tr class=\"layout-full-width\" style=\"background-color:#fbfbfb\"><![endif]-->\n"
//							+ "<!--[if (mso)|(IE)]><td align=\"center\" width=\"680\" style=\"background-color:#fbfbfb;width:680px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px;\"><![endif]-->\n"
//							+ "<div class=\"col num12\" style=\"min-width: 320px; max-width: 680px; display: table-cell; vertical-align: top; width: 680px;\">\n"
//							+ "<div class=\"col_cont\" style=\"width:100% !important;\">\n"
//							+ "<!--[if (!mso)&(!IE)]><!-->\n"
//							+ "<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n"
//							+ "<!--<![endif]-->\n"
//							+ "<div align=\"center\" class=\"img-container center autowidth\" style=\"padding-right: 0px;padding-left: 0px;\">\n"
//							+ "<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\"><![endif]-->\n"
//							+ "<div style=\"font-size:1px;line-height:30px\"> </div><img align=\"center\" alt=\"Divider\" border=\"0\" class=\"center autowidth\" src=\"images/plant-divider2.png\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: 0; width: 100%; max-width: 32px; display: block;\" title=\"Divider\" width=\"32\"/>\n"
//							+ "<div style=\"font-size:1px;line-height:10px\"> </div>\n"
//							+ "<!--[if mso]></td></tr></table><![endif]-->\n" + "</div>\n"
//							+ "<table cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" valign=\"top\" width=\"100%\">\n"
//							+ "<tr style=\"vertical-align: top;\" valign=\"top\">\n"
//							+ "<td align=\"center\" style=\"word-break: break-word; vertical-align: top; padding-bottom: 10px; padding-left: 30px; padding-right: 30px; padding-top: 10px; text-align: center; width: 100%;\" valign=\"top\" width=\"100%\">\n"
//							+ "<h1 style=\"color:#40ab35;direction:ltr;font-family:Cabin, Arial, Helvetica Neue, Helvetica, sans-serif;font-size:26px;font-weight:normal;letter-spacing:normal;line-height:120%;text-align:center;margin-top:0;margin-bottom:0;\">How to save the planet?</h1>\n"
//							+ "</td>\n" + "</tr>\n" + "</table>\n"
//							+ "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\" width=\"100%\">\n"
//							+ "<tbody>\n" + "<tr style=\"vertical-align: top;\" valign=\"top\">\n"
//							+ "<td class=\"divider_inner\" style=\"word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 20px; padding-right: 20px; padding-bottom: 20px; padding-left: 20px;\" valign=\"top\">\n"
//							+ "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider_content\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 3px solid #6BAE72; width: 10%;\" valign=\"top\" width=\"10%\">\n"
//							+ "<tbody>\n" + "<tr style=\"vertical-align: top;\" valign=\"top\">\n"
//							+ "<td style=\"word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\"><span></span></td>\n"
//							+ "</tr>\n" + "</tbody>\n" + "</table>\n" + "</td>\n" + "</tr>\n" + "</tbody>\n"
//							+ "</table>\n" + "<!--[if (!mso)&(!IE)]><!-->\n" + "</div>\n" + "<!--<![endif]-->\n"
//							+ "</div>\n" + "</div>\n" + "<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n"
//							+ "<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" + "</div>\n"
//							+ "</div>\n" + "</div>\n" + "<div style=\"background-color:transparent;\">\n"
//							+ "<div class=\"block-grid two-up\" style=\"min-width: 320px; max-width: 680px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; Margin: 0 auto; background-color: #fbfbfb;\">\n"
//							+ "<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#fbfbfb;\">\n"
//							+ "<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:680px\"><tr class=\"layout-full-width\" style=\"background-color:#fbfbfb\"><![endif]-->\n"
//							+ "<!--[if (mso)|(IE)]><td align=\"center\" width=\"340\" style=\"background-color:#fbfbfb;width:340px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 30px; padding-left: 30px; padding-top:30px; padding-bottom:30px;\"><![endif]-->\n"
//							+ "<div class=\"col num6\" style=\"display: table-cell; vertical-align: top; max-width: 320px; min-width: 336px; width: 340px;\">\n"
//							+ "<div class=\"col_cont\" style=\"width:100% !important;\">\n"
//							+ "<!--[if (!mso)&(!IE)]><!-->\n"
//							+ "<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:30px; padding-bottom:30px; padding-right: 30px; padding-left: 30px;\">\n"
//							+ "<!--<![endif]-->\n"
//							+ "<div align=\"center\" class=\"img-container center fixedwidth\" style=\"padding-right: 0px;padding-left: 0px;\">\n"
//							+ "<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\"><![endif]--><img align=\"center\" alt=\"Commitment\" border=\"0\" class=\"center fixedwidth\" src=\"images/img-left.png\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: 0; width: 100%; max-width: 280px; display: block;\" title=\"Commitment\" width=\"280\"/>\n"
//							+ "<!--[if mso]></td></tr></table><![endif]-->\n" + "</div>\n"
//							+ "<!--[if (!mso)&(!IE)]><!-->\n" + "</div>\n" + "<!--<![endif]-->\n" + "</div>\n"
//							+ "</div>\n" + "<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n"
//							+ "<!--[if (mso)|(IE)]></td><td align=\"center\" width=\"340\" style=\"background-color:#fbfbfb;width:340px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 30px; padding-left: 30px; padding-top:30px; padding-bottom:30px;\"><![endif]-->\n"
//							+ "<div class=\"col num6\" style=\"display: table-cell; vertical-align: top; max-width: 320px; min-width: 336px; width: 340px;\">\n"
//							+ "<div class=\"col_cont\" style=\"width:100% !important;\">\n"
//							+ "<!--[if (!mso)&(!IE)]><!-->\n"
//							+ "<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:30px; padding-bottom:30px; padding-right: 30px; padding-left: 30px;\">\n"
//							+ "<!--<![endif]-->\n"
//							+ "<table cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" valign=\"top\" width=\"100%\">\n"
//							+ "<tr style=\"vertical-align: top;\" valign=\"top\">\n"
//							+ "<td align=\"center\" style=\"word-break: break-word; vertical-align: top; padding-bottom: 0px; padding-left: 0px; padding-right: 0px; padding-top: 0px; text-align: center; width: 100%;\" valign=\"top\" width=\"100%\">\n"
//							+ "<h3 style=\"color:#9dc185;direction:ltr;font-family:Cabin, Arial, Helvetica Neue, Helvetica, sans-serif;font-size:16px;font-weight:normal;letter-spacing:1px;line-height:150%;text-align:left;margin-top:0;margin-bottom:0;\">EVERY DAY IS PLANET DAY</h3>\n"
//							+ "</td>\n" + "</tr>\n" + "</table>\n"
//							+ "<table cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" valign=\"top\" width=\"100%\">\n"
//							+ "<tr style=\"vertical-align: top;\" valign=\"top\">\n"
//							+ "<td align=\"center\" style=\"word-break: break-word; vertical-align: top; padding-bottom: 20px; padding-left: 0px; padding-right: 0px; padding-top: 20px; text-align: center; width: 100%;\" valign=\"top\" width=\"100%\">\n"
//							+ "<h2 style=\"color:#2c1717;direction:ltr;font-family:Cabin, Arial, Helvetica Neue, Helvetica, sans-serif;font-size:22px;font-weight:normal;letter-spacing:normal;line-height:120%;text-align:left;margin-top:0;margin-bottom:0;\">Increasing our commitment<br/></h2>\n"
//							+ "</td>\n" + "</tr>\n" + "</table>\n"
//							+ "<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top: 0px; padding-bottom: 20px; font-family: Arial, sans-serif\"><![endif]-->\n"
//							+ "<div style=\"color:#393d47;font-family:Cabin, Arial, Helvetica Neue, Helvetica, sans-serif;line-height:1.5;padding-top:0px;padding-right:0px;padding-bottom:20px;padding-left:0px;\">\n"
//							+ "<div class=\"txtTinyMce-wrapper\" style=\"line-height: 1.5; font-size: 12px; color: #393d47; font-family: Cabin, Arial, Helvetica Neue, Helvetica, sans-serif; mso-line-height-alt: 18px;\">\n"
//							+ "<p style=\"margin: 0; font-size: 16px; line-height: 1.5; word-break: break-word; mso-line-height-alt: 24px; margin-top: 0; margin-bottom: 0;\"><span style=\"font-size: 16px;\">Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium.</span></p>\n"
//							+ "</div>\n" + "</div>\n" + "<!--[if mso]></td></tr></table><![endif]-->\n"
//							+ "<div align=\"left\" class=\"button-container\" style=\"padding-top:0px;padding-right:0px;padding-bottom:0px;padding-left:0px;\">\n"
//							+ "<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-spacing: 0; border-collapse: collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\"><tr><td style=\"padding-top: 0px; padding-right: 0px; padding-bottom: 0px; padding-left: 0px\" align=\"left\"><v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:w=\"urn:schemas-microsoft-com:office:word\" href=\"\" style=\"height:36pt;width:193.5pt;v-text-anchor:middle;\" arcsize=\"63%\" strokeweight=\"2.25pt\" strokecolor=\"#9AB886\" fill=\"false\"><w:anchorlock/><v:textbox inset=\"0,0,0,0\"><center style=\"color:#9ab886; font-family:Arial, sans-serif; font-size:14px\"><![endif]-->\n"
//							+ "<div style=\"text-decoration:none;display:inline-block;color:#9ab886;background-color:transparent;border-radius:30px;-webkit-border-radius:30px;-moz-border-radius:30px;width:auto; width:auto;;border-top:3px solid #9AB886;border-right:3px solid #9AB886;border-bottom:3px solid #9AB886;border-left:3px solid #9AB886;padding-top:5px;padding-bottom:5px;font-family:Cabin, Arial, Helvetica Neue, Helvetica, sans-serif;text-align:center;mso-border-alt:none;word-break:keep-all;\"><span style=\"padding-left:40px;padding-right:40px;font-size:14px;display:inline-block;letter-spacing:1px;\"><span style=\"font-size: 16px; line-height: 2; word-break: break-word; mso-line-height-alt: 32px;\"><span data-mce-style=\"font-size: 14px; line-height: 28px;\" style=\"font-size: 14px; line-height: 28px;\"><strong>START NOW</strong></span></span></span></div>\n"
//							+ "<!--[if mso]></center></v:textbox></v:roundrect></td></tr></table><![endif]-->\n"
//							+ "</div>\n" + "<!--[if (!mso)&(!IE)]><!-->\n" + "</div>\n" + "<!--<![endif]-->\n"
//							+ "</div>\n" + "</div>\n" + "<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n"
//							+ "<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" + "</div>\n"
//							+ "</div>\n" + "</div>\n" + "<div style=\"background-color:transparent;\">\n"
//							+ "<div class=\"block-grid three-up\" style=\"min-width: 320px; max-width: 680px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; Margin: 0 auto; background-color: #ffffff;\">\n"
//							+ "<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#ffffff;\">\n"
//							+ "<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:680px\"><tr class=\"layout-full-width\" style=\"background-color:#ffffff\"><![endif]-->\n"
//							+ "<!--[if (mso)|(IE)]><td align=\"center\" width=\"226\" style=\"background-color:#ffffff;width:226px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 30px; padding-left: 30px; padding-top:30px; padding-bottom:30px;\"><![endif]-->\n"
//							+ "<div class=\"col num4\" style=\"display: table-cell; vertical-align: top; max-width: 320px; min-width: 224px; width: 226px;\">\n"
//							+ "<div class=\"col_cont\" style=\"width:100% !important;\">\n"
//							+ "<!--[if (!mso)&(!IE)]><!-->\n"
//							+ "<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:30px; padding-bottom:30px; padding-right: 30px; padding-left: 30px;\">\n"
//							+ "<!--<![endif]-->\n"
//							+ "<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top: 0px; padding-bottom: 0px; font-family: Arial, sans-serif\"><![endif]-->\n"
//							+ "<div style=\"color:#40ab35;font-family:Cabin, Arial, Helvetica Neue, Helvetica, sans-serif;line-height:1.2;padding-top:0px;padding-right:0px;padding-bottom:0px;padding-left:0px;\">\n"
//							+ "<div class=\"txtTinyMce-wrapper\" style=\"line-height: 1.2; font-size: 12px; color: #40ab35; font-family: Cabin, Arial, Helvetica Neue, Helvetica, sans-serif; mso-line-height-alt: 14px;\">\n"
//							+ "<p style=\"margin: 0; font-size: 50px; line-height: 1.2; word-break: break-word; text-align: center; mso-line-height-alt: 60px; margin-top: 0; margin-bottom: 0;\"><span style=\"font-size: 50px;\">1</span></p>\n"
//							+ "</div>\n" + "</div>\n" + "<!--[if mso]></td></tr></table><![endif]-->\n"
//							+ "<table cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" valign=\"top\" width=\"100%\">\n"
//							+ "<tr style=\"vertical-align: top;\" valign=\"top\">\n"
//							+ "<td align=\"center\" style=\"word-break: break-word; vertical-align: top; padding-bottom: 20px; padding-left: 0px; padding-right: 0px; padding-top: 20px; text-align: center; width: 100%;\" valign=\"top\" width=\"100%\">\n"
//							+ "<h2 style=\"color:#9ab886;direction:ltr;font-family:Cabin, Arial, Helvetica Neue, Helvetica, sans-serif;font-size:19px;font-weight:normal;letter-spacing:normal;line-height:120%;text-align:center;margin-top:0;margin-bottom:0;\">Reduce</h2>\n"
//							+ "</td>\n" + "</tr>\n" + "</table>\n"
//							+ "<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top: 0px; padding-bottom: 20px; font-family: Arial, sans-serif\"><![endif]-->\n"
//							+ "<div style=\"color:#393d47;font-family:Cabin, Arial, Helvetica Neue, Helvetica, sans-serif;line-height:1.5;padding-top:0px;padding-right:0px;padding-bottom:20px;padding-left:0px;\">\n"
//							+ "<div class=\"txtTinyMce-wrapper\" style=\"line-height: 1.5; font-size: 12px; color: #393d47; font-family: Cabin, Arial, Helvetica Neue, Helvetica, sans-serif; mso-line-height-alt: 18px;\">\n"
//							+ "<p style=\"margin: 0; font-size: 16px; line-height: 1.5; word-break: break-word; text-align: center; mso-line-height-alt: 24px; margin-top: 0; margin-bottom: 0;\"><span style=\"font-size: 16px;\">Nunc sit amet urna in erat consequat lobortis in quis arcu.</span></p>\n"
//							+ "</div>\n" + "</div>\n" + "<!--[if mso]></td></tr></table><![endif]-->\n"
//							+ "<!--[if (!mso)&(!IE)]><!-->\n" + "</div>\n" + "<!--<![endif]-->\n" + "</div>\n"
//							+ "</div>\n" + "<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n"
//							+ "<!--[if (mso)|(IE)]></td><td align=\"center\" width=\"226\" style=\"background-color:#ffffff;width:226px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 30px; padding-left: 30px; padding-top:30px; padding-bottom:30px;\"><![endif]-->\n"
//							+ "<div class=\"col num4\" style=\"display: table-cell; vertical-align: top; max-width: 320px; min-width: 224px; width: 226px;\">\n"
//							+ "<div class=\"col_cont\" style=\"width:100% !important;\">\n"
//							+ "<!--[if (!mso)&(!IE)]><!-->\n"
//							+ "<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:30px; padding-bottom:30px; padding-right: 30px; padding-left: 30px;\">\n"
//							+ "<!--<![endif]-->\n"
//							+ "<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top: 0px; padding-bottom: 0px; font-family: Arial, sans-serif\"><![endif]-->\n"
//							+ "<div style=\"color:#40ab35;font-family:Cabin, Arial, Helvetica Neue, Helvetica, sans-serif;line-height:1.2;padding-top:0px;padding-right:0px;padding-bottom:0px;padding-left:0px;\">\n"
//							+ "<div class=\"txtTinyMce-wrapper\" style=\"line-height: 1.2; font-size: 12px; color: #40ab35; font-family: Cabin, Arial, Helvetica Neue, Helvetica, sans-serif; mso-line-height-alt: 14px;\">\n"
//							+ "<p style=\"margin: 0; font-size: 50px; line-height: 1.2; word-break: break-word; text-align: center; mso-line-height-alt: 60px; margin-top: 0; margin-bottom: 0;\"><span style=\"font-size: 50px;\">2</span></p>\n"
//							+ "</div>\n" + "</div>\n" + "<!--[if mso]></td></tr></table><![endif]-->\n"
//							+ "<table cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" valign=\"top\" width=\"100%\">\n"
//							+ "<tr style=\"vertical-align: top;\" valign=\"top\">\n"
//							+ "<td align=\"center\" style=\"word-break: break-word; vertical-align: top; padding-bottom: 20px; padding-left: 0px; padding-right: 0px; padding-top: 20px; text-align: center; width: 100%;\" valign=\"top\" width=\"100%\">\n"
//							+ "<h2 style=\"color:#9ab886;direction:ltr;font-family:Cabin, Arial, Helvetica Neue, Helvetica, sans-serif;font-size:18px;font-weight:normal;letter-spacing:normal;line-height:120%;text-align:center;margin-top:0;margin-bottom:0;\">Reuse</h2>\n"
//							+ "</td>\n" + "</tr>\n" + "</table>\n"
//							+ "<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top: 0px; padding-bottom: 20px; font-family: Arial, sans-serif\"><![endif]-->\n"
//							+ "<div style=\"color:#393d47;font-family:Cabin, Arial, Helvetica Neue, Helvetica, sans-serif;line-height:1.5;padding-top:0px;padding-right:0px;padding-bottom:20px;padding-left:0px;\">\n"
//							+ "<div class=\"txtTinyMce-wrapper\" style=\"line-height: 1.5; font-size: 12px; color: #393d47; font-family: Cabin, Arial, Helvetica Neue, Helvetica, sans-serif; mso-line-height-alt: 18px;\">\n"
//							+ "<p style=\"margin: 0; text-align: center; line-height: 1.5; word-break: break-word; font-size: 16px; mso-line-height-alt: 24px; margin-top: 0; margin-bottom: 0;\"><span style=\"font-size: 16px;\">Ut suscipit est ac leo rutrum, vel dapibus magna pellentesque.</span></p>\n"
//							+ "</div>\n" + "</div>\n" + "<!--[if mso]></td></tr></table><![endif]-->\n"
//							+ "<!--[if (!mso)&(!IE)]><!-->\n" + "</div>\n" + "<!--<![endif]-->\n" + "</div>\n"
//							+ "</div>\n" + "<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n"
//							+ "<!--[if (mso)|(IE)]></td><td align=\"center\" width=\"226\" style=\"background-color:#ffffff;width:226px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 30px; padding-left: 30px; padding-top:30px; padding-bottom:30px;\"><![endif]-->\n"
//							+ "<div class=\"col num4\" style=\"display: table-cell; vertical-align: top; max-width: 320px; min-width: 224px; width: 226px;\">\n"
//							+ "<div class=\"col_cont\" style=\"width:100% !important;\">\n"
//							+ "<!--[if (!mso)&(!IE)]><!-->\n"
//							+ "<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:30px; padding-bottom:30px; padding-right: 30px; padding-left: 30px;\">\n"
//							+ "<!--<![endif]-->\n"
//							+ "<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top: 0px; padding-bottom: 0px; font-family: Arial, sans-serif\"><![endif]-->\n"
//							+ "<div style=\"color:#40ab35;font-family:Cabin, Arial, Helvetica Neue, Helvetica, sans-serif;line-height:1.2;padding-top:0px;padding-right:0px;padding-bottom:0px;padding-left:0px;\">\n"
//							+ "<div class=\"txtTinyMce-wrapper\" style=\"line-height: 1.2; font-size: 12px; color: #40ab35; font-family: Cabin, Arial, Helvetica Neue, Helvetica, sans-serif; mso-line-height-alt: 14px;\">\n"
//							+ "<p style=\"margin: 0; font-size: 50px; line-height: 1.2; word-break: break-word; text-align: center; mso-line-height-alt: 60px; margin-top: 0; margin-bottom: 0;\"><span style=\"font-size: 50px;\">3</span></p>\n"
//							+ "</div>\n" + "</div>\n" + "<!--[if mso]></td></tr></table><![endif]-->\n"
//							+ "<table cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" valign=\"top\" width=\"100%\">\n"
//							+ "<tr style=\"vertical-align: top;\" valign=\"top\">\n"
//							+ "<td align=\"center\" style=\"word-break: break-word; vertical-align: top; padding-bottom: 20px; padding-left: 0px; padding-right: 0px; padding-top: 20px; text-align: center; width: 100%;\" valign=\"top\" width=\"100%\">\n"
//							+ "<h2 style=\"color:#9ab886;direction:ltr;font-family:Cabin, Arial, Helvetica Neue, Helvetica, sans-serif;font-size:18px;font-weight:normal;letter-spacing:normal;line-height:120%;text-align:center;margin-top:0;margin-bottom:0;\">Recycle</h2>\n"
//							+ "</td>\n" + "</tr>\n" + "</table>\n"
//							+ "<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top: 0px; padding-bottom: 20px; font-family: Arial, sans-serif\"><![endif]-->\n"
//							+ "<div style=\"color:#393d47;font-family:Cabin, Arial, Helvetica Neue, Helvetica, sans-serif;line-height:1.5;padding-top:0px;padding-right:0px;padding-bottom:20px;padding-left:0px;\">\n"
//							+ "<div class=\"txtTinyMce-wrapper\" style=\"line-height: 1.5; font-size: 12px; color: #393d47; font-family: Cabin, Arial, Helvetica Neue, Helvetica, sans-serif; mso-line-height-alt: 18px;\">\n"
//							+ "<p style=\"margin: 0; text-align: center; line-height: 1.5; word-break: break-word; font-size: 16px; mso-line-height-alt: 24px; margin-top: 0; margin-bottom: 0;\"><span style=\"font-size: 16px;\">Integer iaculis tortor nec justo hendrerit euismod.</span></p>\n"
//							+ "</div>\n" + "</div>\n" + "<!--[if mso]></td></tr></table><![endif]-->\n"
//							+ "<!--[if (!mso)&(!IE)]><!-->\n" + "</div>\n" + "<!--<![endif]-->\n" + "</div>\n"
//							+ "</div>\n" + "<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n"
//							+ "<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" + "</div>\n"
//							+ "</div>\n" + "</div>\n" + "<div style=\"background-color:transparent;\">\n"
//							+ "<div class=\"block-grid three-up\" style=\"min-width: 320px; max-width: 680px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; Margin: 0 auto; background-color: #fbfbfb;\">\n"
//							+ "<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#fbfbfb;\">\n"
//							+ "<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:680px\"><tr class=\"layout-full-width\" style=\"background-color:#fbfbfb\"><![endif]-->\n"
//							+ "<!--[if (mso)|(IE)]><td align=\"center\" width=\"226\" style=\"background-color:#fbfbfb;width:226px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 30px; padding-left: 30px; padding-top:30px; padding-bottom:30px;\"><![endif]-->\n"
//							+ "<div class=\"col num4\" style=\"display: table-cell; vertical-align: top; max-width: 320px; min-width: 224px; width: 226px;\">\n"
//							+ "<div class=\"col_cont\" style=\"width:100% !important;\">\n"
//							+ "<!--[if (!mso)&(!IE)]><!-->\n"
//							+ "<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:30px; padding-bottom:30px; padding-right: 30px; padding-left: 30px;\">\n"
//							+ "<!--<![endif]-->\n"
//							+ "<div align=\"center\" class=\"img-container center fixedwidth\" style=\"padding-right: 0px;padding-left: 0px;\">\n"
//							+ "<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\"><![endif]--><img align=\"center\" alt=\"Your Logo\" border=\"0\" class=\"center fixedwidth\" src=\"images/logo_sm.png\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: 0; width: 100%; max-width: 99px; display: block;\" title=\"Your Logo\" width=\"99\"/>\n"
//							+ "<!--[if mso]></td></tr></table><![endif]-->\n" + "</div>\n"
//							+ "<!--[if (!mso)&(!IE)]><!-->\n" + "</div>\n" + "<!--<![endif]-->\n" + "</div>\n"
//							+ "</div>\n" + "<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n"
//							+ "<!--[if (mso)|(IE)]></td><td align=\"center\" width=\"226\" style=\"background-color:#fbfbfb;width:226px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 30px; padding-left: 30px; padding-top:40px; padding-bottom:30px;\"><![endif]-->\n"
//							+ "<div class=\"col num4\" style=\"display: table-cell; vertical-align: top; max-width: 320px; min-width: 224px; width: 226px;\">\n"
//							+ "<div class=\"col_cont\" style=\"width:100% !important;\">\n"
//							+ "<!--[if (!mso)&(!IE)]><!-->\n"
//							+ "<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:40px; padding-bottom:30px; padding-right: 30px; padding-left: 30px;\">\n"
//							+ "<!--<![endif]-->\n"
//							+ "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" valign=\"top\" width=\"100%\">\n"
//							+ "<tr style=\"vertical-align: top;\" valign=\"top\">\n"
//							+ "<td align=\"center\" style=\"word-break: break-word; vertical-align: top; padding-top: 0px; padding-bottom: 0px; padding-left: 0px; padding-right: 0px; text-align: center; font-size: 0px;\" valign=\"top\">\n"
//							+ "<div class=\"menu-links\">\n" + "<!--[if mso]>\n"
//							+ "<table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\">\n"
//							+ "<tr>\n"
//							+ "<td style=\"padding-top:5px;padding-right:5px;padding-bottom:5px;padding-left:5px\">\n"
//							+ "<![endif]--><a href=\"https://www.example.com\" style=\"padding-top:5px;padding-bottom:5px;padding-left:5px;padding-right:5px;display:block;color:#9ab886;font-family:Cabin, Arial, Helvetica Neue, Helvetica, sans-serif;font-size:14px;text-decoration:none;letter-spacing:undefined;\">About</a>\n"
//							+ "<!--[if mso]></td></tr><tr><td style=\"text-align:center;padding-top:5px;padding-right:5px;padding-bottom:5px;padding-left:5px\"><![endif]--><a href=\"https://www.example.com\" style=\"padding-top:5px;padding-bottom:5px;padding-left:5px;padding-right:5px;display:block;color:#9ab886;font-family:Cabin, Arial, Helvetica Neue, Helvetica, sans-serif;font-size:14px;text-decoration:none;letter-spacing:undefined;\">Fundraising</a>\n"
//							+ "<!--[if mso]></td></tr><tr><td style=\"text-align:center;padding-top:5px;padding-right:5px;padding-bottom:5px;padding-left:5px\"><![endif]--><a href=\"https://www.example.com\" style=\"padding-top:5px;padding-bottom:5px;padding-left:5px;padding-right:5px;display:block;color:#9ab886;font-family:Cabin, Arial, Helvetica Neue, Helvetica, sans-serif;font-size:14px;text-decoration:none;letter-spacing:undefined;\">Contact Us</a>\n"
//							+ "<!--[if mso]></td></tr></table><![endif]-->\n" + "</div>\n" + "</td>\n" + "</tr>\n"
//							+ "</table>\n" + "<!--[if (!mso)&(!IE)]><!-->\n" + "</div>\n" + "<!--<![endif]-->\n"
//							+ "</div>\n" + "</div>\n" + "<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n"
//							+ "<!--[if (mso)|(IE)]></td><td align=\"center\" width=\"226\" style=\"background-color:#fbfbfb;width:226px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 30px; padding-left: 30px; padding-top:30px; padding-bottom:30px;\"><![endif]-->\n"
//							+ "<div class=\"col num4\" style=\"display: table-cell; vertical-align: top; max-width: 320px; min-width: 224px; width: 226px;\">\n"
//							+ "<div class=\"col_cont\" style=\"width:100% !important;\">\n"
//							+ "<!--[if (!mso)&(!IE)]><!-->\n"
//							+ "<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:30px; padding-bottom:30px; padding-right: 30px; padding-left: 30px;\">\n"
//							+ "<!--<![endif]-->\n"
//							+ "<table cellpadding=\"0\" cellspacing=\"0\" class=\"social_icons\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" valign=\"top\" width=\"100%\">\n"
//							+ "<tbody>\n" + "<tr style=\"vertical-align: top;\" valign=\"top\">\n"
//							+ "<td style=\"word-break: break-word; vertical-align: top; padding-top: 10px; padding-right: 10px; padding-bottom: 10px; padding-left: 10px;\" valign=\"top\">\n"
//							+ "<table align=\"center\" cellpadding=\"0\" cellspacing=\"0\" class=\"social_table\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-tspace: 0; mso-table-rspace: 0; mso-table-bspace: 0; mso-table-lspace: 0;\" valign=\"top\">\n"
//							+ "<tbody>\n"
//							+ "<tr align=\"center\" style=\"vertical-align: top; display: inline-block; text-align: center;\" valign=\"top\">\n"
//							+ "<td style=\"word-break: break-word; vertical-align: top; padding-bottom: 0; padding-right: 2.5px; padding-left: 2.5px;\" valign=\"top\"><a href=\"https://www.facebook.com/\" target=\"_blank\"><img alt=\"Facebook\" height=\"32\" src=\"images/facebook2x.png\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: 0; display: block;\" title=\"facebook\" width=\"32\"/></a></td>\n"
//							+ "<td style=\"word-break: break-word; vertical-align: top; padding-bottom: 0; padding-right: 2.5px; padding-left: 2.5px;\" valign=\"top\"><a href=\"https://www.twitter.com/\" target=\"_blank\"><img alt=\"Twitter\" height=\"32\" src=\"images/twitter2x.png\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: 0; display: block;\" title=\"twitter\" width=\"32\"/></a></td>\n"
//							+ "<td style=\"word-break: break-word; vertical-align: top; padding-bottom: 0; padding-right: 2.5px; padding-left: 2.5px;\" valign=\"top\"><a href=\"https://www.linkedin.com/\" target=\"_blank\"><img alt=\"Linkedin\" height=\"32\" src=\"images/linkedin2x.png\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: 0; display: block;\" title=\"linkedin\" width=\"32\"/></a></td>\n"
//							+ "<td style=\"word-break: break-word; vertical-align: top; padding-bottom: 0; padding-right: 2.5px; padding-left: 2.5px;\" valign=\"top\"><a href=\"https://www.instagram.com/\" target=\"_blank\"><img alt=\"Instagram\" height=\"32\" src=\"images/instagram2x.png\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: 0; display: block;\" title=\"instagram\" width=\"32\"/></a></td>\n"
//							+ "</tr>\n" + "</tbody>\n" + "</table>\n" + "</td>\n" + "</tr>\n" + "</tbody>\n"
//							+ "</table>\n"
//							+ "<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top: 0px; padding-bottom: 5px; font-family: Arial, sans-serif\"><![endif]-->\n"
//							+ "<div style=\"color:#393d47;font-family:Cabin, Arial, Helvetica Neue, Helvetica, sans-serif;line-height:1.5;padding-top:0px;padding-right:0px;padding-bottom:5px;padding-left:0px;\">\n"
//							+ "<div class=\"txtTinyMce-wrapper\" style=\"line-height: 1.5; font-size: 12px; color: #393d47; font-family: Cabin, Arial, Helvetica Neue, Helvetica, sans-serif; mso-line-height-alt: 18px;\">\n"
//							+ "<p style=\"margin: 0; font-size: 14px; line-height: 1.5; word-break: break-word; text-align: center; mso-line-height-alt: 21px; margin-top: 0; margin-bottom: 0;\"><a href=\"https//www.example.com\" rel=\"noopener\" style=\"text-decoration: underline; color: #9ab886;\" target=\"_blank\">www.yourcompany.com</a></p>\n"
//							+ "</div>\n" + "</div>\n" + "<!--[if mso]></td></tr></table><![endif]-->\n"
//							+ "<!--[if (!mso)&(!IE)]><!-->\n" + "</div>\n" + "<!--<![endif]-->\n" + "</div>\n"
//							+ "</div>\n" + "<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n"
//							+ "<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" + "</div>\n"
//							+ "</div>\n" + "</div>\n" + "<div style=\"background-color:transparent;\">\n"
//							+ "<div class=\"block-grid\" style=\"min-width: 320px; max-width: 680px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; Margin: 0 auto; background-color: #fbfbfb;\">\n"
//							+ "<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#fbfbfb;\">\n"
//							+ "<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:680px\"><tr class=\"layout-full-width\" style=\"background-color:#fbfbfb\"><![endif]-->\n"
//							+ "<!--[if (mso)|(IE)]><td align=\"center\" width=\"680\" style=\"background-color:#fbfbfb;width:680px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:0px;\"><![endif]-->\n"
//							+ "<div class=\"col num12\" style=\"min-width: 320px; max-width: 680px; display: table-cell; vertical-align: top; width: 680px;\">\n"
//							+ "<div class=\"col_cont\" style=\"width:100% !important;\">\n"
//							+ "<!--[if (!mso)&(!IE)]><!-->\n"
//							+ "<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:0px; padding-bottom:0px; padding-right: 0px; padding-left: 0px;\">\n"
//							+ "<!--<![endif]-->\n"
//							+ "<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 30px; padding-left: 30px; padding-top: 30px; padding-bottom: 30px; font-family: Arial, sans-serif\"><![endif]-->\n"
//							+ "<div style=\"color:#393d47;font-family:Cabin, Arial, Helvetica Neue, Helvetica, sans-serif;line-height:1.5;padding-top:30px;padding-right:30px;padding-bottom:30px;padding-left:30px;\">\n"
//							+ "<div class=\"txtTinyMce-wrapper\" style=\"line-height: 1.5; font-size: 12px; color: #393d47; font-family: Cabin, Arial, Helvetica Neue, Helvetica, sans-serif; mso-line-height-alt: 18px;\">\n"
//							+ "<p style=\"margin: 0; font-size: 12px; line-height: 1.5; word-break: break-word; text-align: center; mso-line-height-alt: 18px; margin-top: 0; margin-bottom: 0;\"><span style=\"font-size: 12px; color: #999999;\">If you have questions regarding your Data, please visit our <a href=\"#\" rel=\"noopener\" style=\"text-decoration: underline; color: #9ab886;\" target=\"_blank\">Privacy Policy</a> </span></p>\n"
//							+ "<p style=\"margin: 0; font-size: 12px; line-height: 1.5; word-break: break-word; text-align: center; mso-line-height-alt: 18px; margin-top: 0; margin-bottom: 0;\"><span style=\"font-size: 12px;\"><span style=\"color: #999999;\">Want to change how you receive these emails? You can <a href=\"#\" rel=\"noopener\" style=\"text-decoration: underline; color: #9ab886;\" target=\"_blank\">update your preferences</a> or <a href=\"#\" rel=\"noopener\" style=\"text-decoration: underline; color: #9ab886;\" target=\"_blank\">unsubscribe</a> from this list.</span></span></p>\n"
//							+ "<p style=\"margin: 0; font-size: 12px; line-height: 1.5; word-break: break-word; text-align: center; mso-line-height-alt: 18px; margin-top: 0; margin-bottom: 0;\"><span style=\"font-size: 12px; color: #999999;\">© 2021 Company. All Rights Reserved.</span></p>\n"
//							+ "</div>\n" + "</div>\n" + "<!--[if mso]></td></tr></table><![endif]-->\n"
//							+ "<!--[if (!mso)&(!IE)]><!-->\n" + "</div>\n" + "<!--<![endif]-->\n" + "</div>\n"
//							+ "</div>\n" + "<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n"
//							+ "<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" + "</div>\n"
//							+ "</div>\n" + "</div>\n" + "<div style=\"background-color:transparent;\">\n"
//							+ "<div class=\"block-grid\" style=\"min-width: 320px; max-width: 680px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; Margin: 0 auto; background-color: transparent;\">\n"
//							+ "<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:transparent;\">\n"
//							+ "<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:680px\"><tr class=\"layout-full-width\" style=\"background-color:transparent\"><![endif]-->\n"
//							+ "<!--[if (mso)|(IE)]><td align=\"center\" width=\"680\" style=\"background-color:transparent;width:680px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px;\"><![endif]-->\n"
//							+ "<div class=\"col num12\" style=\"min-width: 320px; max-width: 680px; display: table-cell; vertical-align: top; width: 680px;\">\n"
//							+ "<div class=\"col_cont\" style=\"width:100% !important;\">\n"
//							+ "<!--[if (!mso)&(!IE)]><!-->\n"
//							+ "<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n"
//							+ "<!--<![endif]-->\n"
//							+ "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\" width=\"100%\">\n"
//							+ "<tbody>\n" + "<tr style=\"vertical-align: top;\" valign=\"top\">\n"
//							+ "<td class=\"divider_inner\" style=\"word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 10px; padding-right: 10px; padding-bottom: 10px; padding-left: 10px;\" valign=\"top\">\n"
//							+ "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider_content\" height=\"40\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 0px solid transparent; height: 40px; width: 100%;\" valign=\"top\" width=\"100%\">\n"
//							+ "<tbody>\n" + "<tr style=\"vertical-align: top;\" valign=\"top\">\n"
//							+ "<td height=\"40\" style=\"word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\"><span></span></td>\n"
//							+ "</tr>\n" + "</tbody>\n" + "</table>\n" + "</td>\n" + "</tr>\n" + "</tbody>\n"
//							+ "</table>\n" + "<!--[if (!mso)&(!IE)]><!-->\n" + "</div>\n" + "<!--<![endif]-->\n"
//							+ "</div>\n" + "</div>\n" + "<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n"
//							+ "<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" + "</div>\n"
//							+ "</div>\n" + "</div>\n" + "<div style=\"background-color:transparent;\">\n"
//							+ "<div class=\"block-grid\" style=\"min-width: 320px; max-width: 680px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; Margin: 0 auto; background-color: transparent;\">\n"
//							+ "<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:transparent;\">\n"
//							+ "<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:680px\"><tr class=\"layout-full-width\" style=\"background-color:transparent\"><![endif]-->\n"
//							+ "<!--[if (mso)|(IE)]><td align=\"center\" width=\"680\" style=\"background-color:transparent;width:680px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px;\"><![endif]-->\n"
//							+ "<div class=\"col num12\" style=\"min-width: 320px; max-width: 680px; display: table-cell; vertical-align: top; width: 680px;\">\n"
//							+ "<div class=\"col_cont\" style=\"width:100% !important;\">\n"
//							+ "<!--[if (!mso)&(!IE)]><!-->\n"
//							+ "<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n"
//							+ "<!--<![endif]-->\n"
//							+ "<table cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" valign=\"top\" width=\"100%\">\n"
//							+ "<tr style=\"vertical-align: top;\" valign=\"top\">\n"
//							+ "<td align=\"center\" style=\"word-break: break-word; vertical-align: top; padding-top: 5px; padding-right: 0px; padding-bottom: 5px; padding-left: 0px; text-align: center;\" valign=\"top\">\n"
//							+ "<!--[if vml]><table align=\"left\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"display:inline-block;padding-left:0px;padding-right:0px;mso-table-lspace: 0pt;mso-table-rspace: 0pt;\"><![endif]-->\n"
//							+ "<!--[if !vml]><!-->\n"
//							+ "<table cellpadding=\"0\" cellspacing=\"0\" class=\"icons-inner\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; display: inline-block; margin-right: -4px; padding-left: 0px; padding-right: 0px;\" valign=\"top\">\n"
//							+ "<!--<![endif]-->\n" + "<tr style=\"vertical-align: top;\" valign=\"top\">\n"
//							+ "<td align=\"center\" style=\"word-break: break-word; vertical-align: top; text-align: center; padding-top: 5px; padding-bottom: 5px; padding-left: 5px; padding-right: 6px;\" valign=\"top\"><a href=\"https://www.designedwithbee.com/\"><img align=\"center\" alt=\"Designed with BEE\" class=\"icon\" height=\"32\" src=\"images/bee.png\" style=\"border:0;\" width=\"null\"/></a></td>\n"
//							+ "<td style=\"word-break: break-word; font-family: Cabin, Arial, Helvetica Neue, Helvetica, sans-serif; font-size: 15px; color: #9d9d9d; vertical-align: middle; letter-spacing: undefined;\" valign=\"middle\"><a href=\"https://www.designedwithbee.com/\" style=\"color:#9d9d9d;text-decoration:none;\">Designed with BEE</a></td>\n"
//							+ "</tr>\n" + "</table>\n" + "</td>\n" + "</tr>\n" + "</table>\n"
//							+ "<!--[if (!mso)&(!IE)]><!-->\n" + "</div>\n" + "<!--<![endif]-->\n" + "</div>\n"
//							+ "</div>\n" + "<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n"
//							+ "<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" + "</div>\n"
//							+ "</div>\n" + "</div>\n" + "<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n"
//							+ "</td>\n" + "</tr>\n" + "</tbody>\n" + "</table>\n" + "<!--[if (IE)]></div><![endif]-->\n"
//							+ "</body>\n" + "</html>",true);

			ClassPathResource classPathResource = new ClassPathResource("/static/題庫.pdf");
			InputStream inputStream = classPathResource.getInputStream();
			File somethingFile = File.createTempFile("高命中率題庫", ".pdf");
			try {
				FileUtils.copyInputStreamToFile(inputStream, somethingFile);
			} finally {
				IOUtils.closeQuietly(inputStream);
			}
			messageHelper.addAttachment("題庫.pdf", somethingFile);
			
			
			
			
			
			//使用當下時間當檔名
			Date aDate=new Date();
			
			String QRcodeImgName=aDate.toString();
					
			
			ClassPathResource qrCode = new ClassPathResource("/static/");
//			InputStream qrCodeInputStream = qrCode.getInputStream();
			
			System.out.println(qrCode.getPath());
			
			//產生QRcode
			System.out.println("產生QRcode是否成功");
//			File qrFile = File.createTempFile("Code", ".png");
			
		    File file = qrCode.getFile();
		    
		    
		    
		    String filePatah = qrCode.getPath()+QRcodeImgName+".png";
		    
		    String filePath = "/Users/guowei/Desktop/Test/"+"caterpillar"+".png";
		    
		    System.out.println(filePath);
		    
		    File file2=new File(filePath);
			
			
			String fileType = "png";
			
			File createQRImage = GenerateQRCode.createQRImage(file2,"https://www.facebook.com/",125, fileType);
			
			System.out.println(createQRImage.getName());
			
			System.out.println(createQRImage.getPath());
			
//			String filePath = "/Users/guowei/Desktop/Test/"+QRcodeImgName+".png";
			
			
			messageHelper.addInline("caterpillar", createQRImage);
			
			
			

		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mailSender.send(mimeMessage);

		System.out.println("finsh.....sendMail");

	}

	public void readMail() throws MessagingException {

		final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";// ssl加密

		// 定義
		String port = "993";
		String imapServer = "imap.gmail.com";
		String protocol = "imap";

		// 有些参数可能不需要
		Properties props = new Properties();
		props.setProperty("mail.imap.socketFactory.class", SSL_FACTORY);
		props.setProperty("mail.imap.socketFactory.fallback", "false");
		props.setProperty("mail.transport.protocol", protocol); // 使用協議
		props.setProperty("mail.imap.port", port);
		props.setProperty("mail.imap.socketFactory.port", port);

		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				
				return new PasswordAuthentication("javaiii0729@gmail.com", "omnvpoapnxmnuolz");
			}
		});
		// 儲存對象
		Store store = session.getStore("imap");
		// 連接
		store.connect("imap.gmail.com", 993, "javaiii0729@gmail.com", "omnvpoapnxmnuolz");
		
		
		
		Folder folder = null;
		try {
			// 獲得收件箱
			folder = store.getFolder("INBOX");
			// 以讀寫方式打開
			folder.open(Folder.READ_WRITE);
			// false 表示未读
			FlagTerm flagTerm = new FlagTerm(new Flags(Flags.Flag.SEEN), false);
			// 獲得收件箱未讀郵件
			Message[] messages = folder.search(flagTerm);

			System.out.println("收件箱中共" + messages.length + "封郵件!");
			System.out.println("收件箱中共" + folder.getUnreadMessageCount() + "封未讀郵件!");
			System.out.println("收件箱中共" + folder.getNewMessageCount() + "封新郵件!");
			System.out.println("收件箱中共" + folder.getDeletedMessageCount() + "封已删除郵件!");

			System.out.println("------------------------開始解析----------------------------------");

			for (int i = 0; i < messages.length; i++) {
				System.out.println("消息:" + messages[i].getSubject());
				String from = null;
				try {
					from = MimeUtility.decodeText(messages[i].getFrom()[0].toString());
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				InternetAddress internetAddress = new InternetAddress(from);
				if (internetAddress.getPersonal() == null) {
					System.out.println("沒有名字");
				} else {
				}
				if (internetAddress.getAddress().indexOf("g7huway0310") >= 0) {
					System.out.println(internetAddress);
					System.out.println(internetAddress + "有找到我的信箱");
				}

//	            System.out.println("发件人：" + internetAddress.getPersonal() + '(' + internetAddress.getAddress() + ')');
			}
			System.out.println("執行完畢");

		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} finally {
			try {
				if (folder != null) {
					folder.close(false);
				}
				if (store != null) {
					store.close();
				}
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}

	}

}
