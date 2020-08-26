package com.sanshao.basic.springbootm1.modules.transfile.Itext2Doc;


public class PdfGenerator {

//	public static String language = "cn";
//
//	public static Document createDoc() throws FileNotFoundException, DocumentException {
//		Document document = new Document();
//
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
//		String date = sdf.format(System.currentTimeMillis());
//
//		String fileName = getFilePathAndDeleteFile() + InspectLableEnum.Inspect_Report.getName(language) + "_" + date + ".pdf";
//		System.out.println("filename="+fileName);
//        PdfWriter.getInstance(document, new FileOutputStream(fileName));
//
//        document.open();
//
//        return document;
//	}
//
//	public static String getFilePathAndDeleteFile() {
//		String newPath = getFilePath();
//		File f1 = new File(newPath);
//		if (!f1.exists()) {
//			f1.mkdir();
//		}
//		String fileNames[] = f1.list();
//		File temp = null;
//		if (fileNames.length != 0) {
//			for (int i = 0; i < fileNames.length; i++) {
//				temp = new File(newPath + fileNames[i]);
//				temp.delete();
//			}
//		}
//		if (!f1.exists()) {
//			f1.mkdir();
//		}
//		// newPath =
//		// "E:/J2EE/Luna_projects/NMS_Webnms/WebNMS/Framework/inspect";
//
//		return newPath;
//	}
//	public static String getFilePath() {
//		 File file = new File(PdfGenerator.class.getResource("/").getPath());
//		 String path = file.getAbsolutePath();
//		 String newPath = path.replace("\\", "/");
//		 if (newPath.contains("apache")) {
//		    newPath = newPath.substring(0, newPath.indexOf("/apache"));
//		 }
//		 newPath += "/inspect/";
//		 File f1=new File(newPath);
//			if(!f1.exists()){
//				f1.mkdir();
//			}
////		newPath = "E:/J2EE/Luna_projects/NMS_Webnms/WebNMS/Framework/inspect";
//		 return newPath;
//	}
//	public static boolean addTitle(Document document) throws DocumentException, IOException {
//	    BaseFont bfChinese=BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
//	    Font keyFont=new Font(bfChinese,40,Font.BOLD);
//	    Font textFont=new Font(bfChinese,20,Font.NORMAL);
//
//	    String title = InspectLableEnum.Inspect_Report.getName(language);
//	    Paragraph paragraph = new Paragraph(title, keyFont);
//	    paragraph.setAlignment(Element.ALIGN_CENTER);
//
//        document.add(paragraph);
//        document.add(Chunk.NEWLINE);
//
//        String generateTime = SinoTimeUtils.convertTimeString(String.valueOf(System.currentTimeMillis()));
//        paragraph = new Paragraph(InspectLableEnum.Inspect_Time.getName(language) + generateTime, textFont);
//	    paragraph.setAlignment(Element.ALIGN_CENTER);
//
//        document.add(paragraph);
//        return true;
//	}
//
//	public static Chapter addNeBasicInfo(Document document,
//			SinoDeviceGpon3116 device, int sectionNum) throws DocumentException, IOException {
//
//	    BaseFont bfChinese=BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
//	    Font keyFont=new Font(bfChinese,12,Font.BOLD);
//	    Font textFont=new Font(bfChinese,12,Font.NORMAL);
//
//		StringBuffer sb = new StringBuffer();
//		sb.append(InspectLableEnum.Ne_Name.getName(language)).append(device.getDisplayName())
//		    .append("    ").append(InspectLableEnum.Ne_Ip.getName(language)).append(device.getName());
//
//        Paragraph chapterInfo = new Paragraph(sb.toString(), keyFont);
//        Chapter chapter = new Chapter(chapterInfo, sectionNum);
//
//        sb.delete(0,  sb.length());
//        sb.append(InspectLableEnum.Ne_Status.getName(language));
//
//        int neStatus = device.getStatus();
//        if(neStatus == 12)
//            sb.append(InspectLableEnum.Ne_Online.getName(language));
//        else
//            sb.append(InspectLableEnum.Ne_Offline.getName(language));
//
//        Paragraph neStatusP = new Paragraph(sb.toString(), textFont);
//        Section section;
//        section = chapter.addSection(neStatusP);
//
//
//        if(neStatus != 12) {
//            document.add(chapter);
//            return chapter;
//        }
//
//        sb.delete(0,  sb.length());
//        sb.append(InspectLableEnum.Ne_BasicInfo.getName(language));
//        section = chapter.addSection(new Paragraph(sb.toString(), textFont));
//
//		SinoGponNEBasicService SinoGponNEBasicService = new SinoOtnNEBasicServiceImpl();
//		SinoGponNeBasicInfo_n basicInfo = SinoGponNEBasicService.getSinoGponNeBasicInfo(device.getName());
//		if(basicInfo==null){
//			return chapter;
//		}
////        section = chapter.addSection(new Paragraph("test", textFont));
////        section = chapter.addSection(new Paragraph("test2", textFont));
//        PdfPTable table = new PdfPTable(2);
//
//        Phrase phrase;
//        phrase = new Phrase(InspectLableEnum.Ne_Attribute.getName(language), textFont);
//        table.addCell(phrase);
//
//        table.addCell(new Phrase(InspectLableEnum.Ne_Attribute_Value.getName(language), textFont));
//        table.setHeaderRows(1);
//
//        table.addCell(new Phrase(InspectLableEnum.Ne_Software_Version.getName(language), textFont));
//        table.addCell(basicInfo.getNeSwVersion());
//
//        table.addCell(new Phrase(InspectLableEnum.Ne_Hardware_Version.getName(language), textFont));
//        table.addCell(basicInfo.getNeHwVersion());
//
//        table.addCell(new Phrase(InspectLableEnum.Ne_Serial_Number.getName(language), textFont));
//        table.addCell(basicInfo.getNeSerialNum());
//
//        table.addCell(new Phrase(InspectLableEnum.Ne_Running_Time.getName(language), textFont));
//        table.addCell(basicInfo.getSysUptime());
//
//        table.setSpacingBefore(10);
//        section.add(table);
//
////        document.add(chapter);
//
//		return chapter;
//
//	}
//
//	public static Chapter addNeIpInfo(Document document,
//			SinoDeviceGpon3116 device, int sectionNum, Chapter chapter) throws DocumentException, IOException {
//	    BaseFont bfChinese=BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
//	    Font keyFont=new Font(bfChinese,12,Font.BOLD);
//	    Font textFont=new Font(bfChinese,12,Font.NORMAL);
//
//	    SinoOtnNEManageInfoService sinoOtnNEManageInfoService
//	        =  new SinoOtnNEManageInfoServiceImpl();
//	    SinoOtnNeManageInfo_n ipInfo = sinoOtnNEManageInfoService.getSinoGponNeManageInfo(device.getName());
//	    if(ipInfo==null){
//	    	return chapter;
//	    }
//        Section section = chapter.addSection(new Paragraph(InspectLableEnum.Ne_Ip_Configuraiotn.getName(language), textFont));
//
//        PdfPTable table = new PdfPTable(2);
//
//        Phrase phrase;
//        phrase = new Phrase(InspectLableEnum.DCN_Attribute.getName(language), textFont);
//        table.addCell(phrase);
//
//        table.addCell(new Phrase(InspectLableEnum.DCN_Attribute_Value.getName(language), textFont));
//        table.setHeaderRows(1);
//
//        table.addCell(new Phrase(InspectLableEnum.NodeIp_Confguration.getName(language), textFont));
//        table.addCell(ipInfo.getNodeIP());
//
//        if(!OtnMiscUtils.isOtnMulti5UNe(device.getDeviceType()) && !OtnMiscUtils.isOtnMulti10UNe(device.getDeviceType())) {
//	        if(ipInfo.getEthIp_2() != null && !ipInfo.getEthIp_2().isEmpty()) {
//		        table.addCell(new Phrase(InspectLableEnum.Ip1_Configuration.getName(language), textFont));
//		        table.addCell(ipInfo.getEthIp_2());
//
//		        table.addCell(new Phrase(InspectLableEnum.Ip1_Mask.getName(language), textFont));
//		        table.addCell(ipInfo.getEthIpNetMask_2());
//
//		        table.addCell(new Phrase(InspectLableEnum.Ip1_Ospf.getName(language), textFont));
//		        int ospfValue = ipInfo.getOspfEnable_2();
//		        if(ospfValue == 0)
//		            table.addCell(new Phrase(InspectLableEnum.Disable.getName(language), textFont));
//		        else
//		            table.addCell(new Phrase(InspectLableEnum.Enable.getName(language), textFont));
//	        }
//	        //
//	        if(ipInfo.getEthIp_3() != null && !ipInfo.getEthIp_3().isEmpty() && !OtnMiscUtils.isOtn1UNe(device.getDeviceType())) {
//		        table.addCell(new Phrase(InspectLableEnum.Ip2_Configuration.getName(language), textFont));
//		        table.addCell(ipInfo.getEthIp_3());
//
//		        table.addCell(new Phrase(InspectLableEnum.Ip2_Mask.getName(language), textFont));
//		        table.addCell(ipInfo.getEthIpNetMask_3());
//
//		        table.addCell(new Phrase(InspectLableEnum.Ip2_Ospf.getName(language), textFont));
//		        int ospfValue = ipInfo.getOspfEnable_3();
//		        if(ospfValue == 0)
//		            table.addCell(new Phrase(InspectLableEnum.Disable.getName(language), textFont));
//		        else
//		            table.addCell(new Phrase(InspectLableEnum.Enable.getName(language), textFont));
//	        }
//        } else {
//	        if(ipInfo.getEthIp_3() != null && !ipInfo.getEthIp_3().isEmpty()) {
//		        table.addCell(new Phrase(InspectLableEnum.Ip1_Configuration.getName(language), textFont));
//		        table.addCell(ipInfo.getEthIp_3());
//
//		        table.addCell(new Phrase(InspectLableEnum.Ip1_Mask.getName(language), textFont));
//		        table.addCell(ipInfo.getEthIpNetMask_3());
//
//		        table.addCell(new Phrase(InspectLableEnum.Ip1_Ospf.getName(language), textFont));
//		        int ospfValue = ipInfo.getOspfEnable_3();
//		        if(ospfValue == 0)
//		            table.addCell(new Phrase(InspectLableEnum.Disable.getName(language), textFont));
//		        else
//		            table.addCell(new Phrase(InspectLableEnum.Enable.getName(language), textFont));
//	        }
//	        //
//	        if(ipInfo.getEthIp_2() != null && !ipInfo.getEthIp_2().isEmpty()) {
//		        table.addCell(new Phrase(InspectLableEnum.Ip2_Configuration.getName(language), textFont));
//		        table.addCell(ipInfo.getEthIp_2());
//
//		        table.addCell(new Phrase(InspectLableEnum.Ip2_Mask.getName(language), textFont));
//		        table.addCell(ipInfo.getEthIpNetMask_2());
//
//		        table.addCell(new Phrase(InspectLableEnum.Ip2_Ospf.getName(language), textFont));
//		        int ospfValue = ipInfo.getOspfEnable_2();
//		        if(ospfValue == 0)
//		            table.addCell(new Phrase(InspectLableEnum.Disable.getName(language), textFont));
//		        else
//		            table.addCell(new Phrase(InspectLableEnum.Enable.getName(language), textFont));
//	        }
//        }
//
//        table.addCell(new Phrase(InspectLableEnum.Ip3_Configuration.getName(language), textFont));
//        table.addCell(ipInfo.getEthIp());
//
//        table.addCell(new Phrase(InspectLableEnum.Ip3_Mask.getName(language), textFont));
//        table.addCell(ipInfo.getEthIpNetMask());
//
//
//        table.addCell(new Phrase(InspectLableEnum.Gateway_Configuration.getName(language), textFont));
//        table.addCell(ipInfo.getGateway());
//
//        table.addCell(new Phrase(InspectLableEnum.DefaultRtRedist.getName(language), textFont));
//        int defaultRtRedist = ipInfo.getDefaultRtRedist();
//        if(defaultRtRedist == 0)
//            table.addCell(new Phrase(InspectLableEnum.Disable.getName(language), textFont));
//        else
//            table.addCell(new Phrase(InspectLableEnum.Enable.getName(language), textFont));
//
//        table.setSpacingBefore(10);
//        section.add(table);
//
//        System.out.println("return chaper " + chapter);
//        System.out.println("网元信息巡检完成");
//        return chapter;
//	}
//
//	public static Chapter addShelfInfo(Document document,
//			SinoDeviceGpon3116 device, int sectionNum, Chapter chapter) throws DocumentException, IOException {
//
//	    BaseFont bfChinese=BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
//	    Font keyFont=new Font(bfChinese,12,Font.BOLD);
//	    Font textFont=new Font(bfChinese,12,Font.NORMAL);
//
//	    ShelfInventoryService shelfInventoryService =  new ShelfInventoryServiceImpl();
//	    SinoOtnShelf_n shelfInfo = shelfInventoryService.getShelfInfoForNe(device.getName());
//	    if(shelfInfo==null){
//	    	return chapter;
//	    }
//        Section section = chapter.addSection(new Paragraph(InspectLableEnum.Shelf_Info.getName(language), textFont));
//
//        PdfPTable table = new PdfPTable(2);
//
//        Phrase phrase;
//        phrase = new Phrase(InspectLableEnum.Shelf_Attribute.getName(language), textFont);
//        table.addCell(phrase);
//
//        table.addCell(new Phrase(InspectLableEnum.Ne_Attribute_Value.getName(language), textFont));
//        table.setHeaderRows(1);
//
//        table.addCell(new Phrase(InspectLableEnum.Shelf_Type.getName(language), textFont));
//        table.addCell(new Phrase(ShelfTypeEnum.getNameFromValue(shelfInfo.getShelfType()), textFont));
//
//        table.addCell(new Phrase(InspectLableEnum.Shelf_PN.getName(language), textFont));
//        table.addCell(new Phrase(shelfInfo.getShelfPartNumber(), textFont));
//
//        table.addCell(new Phrase(InspectLableEnum.Shelf_SN.getName(language), textFont));
//        table.addCell(new Phrase(shelfInfo.getShelfSN(), textFont));
//
//        table.addCell(new Phrase(InspectLableEnum.Shelf_Mac.getName(language), textFont));
//        table.addCell(new Phrase(String.valueOf(shelfInfo.getShelfMacAddressMgmt2()), textFont));
//
//        table.addCell(new Phrase(InspectLableEnum.Shelf_Temperature.getName(language), textFont));
//        table.addCell(new Phrase(String.valueOf(shelfInfo.getShelfTemperature()), textFont));
//
//        table.addCell(new Phrase(InspectLableEnum.Shelf_FanSpeed.getName(language), textFont));
//        table.addCell(new Phrase(String.valueOf(shelfInfo.getShelfFanSpeedPwm()) + "%", textFont));
//
//
//        table.addCell(new Phrase(InspectLableEnum.Shelf_Auto.getName(language), textFont));
//        String auto = (shelfInfo.getShelfFanSpeedAutoRegulating() == 1) ? InspectLableEnum.Yes.getName(language) : InspectLableEnum.No.getName(language);
//        table.addCell(new Phrase(auto, textFont));
//
//        table.addCell(new Phrase(InspectLableEnum.Shelf_TopSpeed.getName(language), textFont));
//        String topSpeed = (shelfInfo.getShelfFanTopSpeed() == 1) ? InspectLableEnum.Yes.getName(language) : InspectLableEnum.No.getName(language);
//        table.addCell(new Phrase(topSpeed, textFont));
//
//
//        table.setSpacingBefore(10);
//        section.add(table);
//        System.out.println("机框信息巡检完成");
//		return chapter;
//	}
//
//	public static Chapter addActiveAlarm(Document document,
//			SinoDeviceGpon3116 device, int sectionNum, Chapter chapter) throws DocumentException, IOException {
//	    BaseFont bfChinese=BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
//	    Font keyFont=new Font(bfChinese,12,Font.BOLD);
//	    Font textFont=new Font(bfChinese,12,Font.NORMAL);
//        Section section = chapter.addSection(new Paragraph(InspectLableEnum.ActiveAlarm_Info.getName(language), textFont));
//
//        PdfPTable table = new PdfPTable(11);
//
//        Phrase phrase;
//        phrase = new Phrase(InspectLableEnum.Alarm_Id.getName(language), textFont);
//        table.addCell(phrase);
//
//        table.addCell(new Phrase(InspectLableEnum.Alarm_Severity.getName(language), textFont));
//        table.addCell(new Phrase(InspectLableEnum.Alarm_Ne.getName(language), textFont));
//        table.addCell(new Phrase(InspectLableEnum.Alarm_Source.getName(language), textFont));
//        table.addCell(new Phrase(InspectLableEnum.Alarm_Name.getName(language), textFont));
//        table.addCell(new Phrase(InspectLableEnum.Alarm_Type.getName(language), textFont));
//        table.addCell(new Phrase(InspectLableEnum.Alarm_State.getName(language), textFont));
//        table.addCell(new Phrase(InspectLableEnum.Alarm_RaiseTime.getName(language), textFont));
//        table.addCell(new Phrase(InspectLableEnum.Alarm_Acknowledge_State.getName(language), textFont));
//        table.addCell(new Phrase(InspectLableEnum.Alarm_Acknowledge_User.getName(language), textFont));
//        table.addCell(new Phrase(InspectLableEnum.Alarm_Acknowledge_Time.getName(language), textFont));
//
//        table.setHeaderRows(1);
//
//        SinoActiveAlarmService sinoActiveAlarmService = new SinoActiveAlarmServiceImpl();
//        ArrayList<SinoActiveAlarm> alarmList = sinoActiveAlarmService.getAlarmListQueryByIp(device.getName());
//        if(alarmList == null || alarmList.size() == 0){
//        	return chapter;
//        }
//        int id = 1;
//        for(SinoActiveAlarm alarm: alarmList) {
//        	if(alarm==null){
//        		return chapter;
//        	}
//            table.addCell(String.valueOf(id));
//            table.addCell(new Phrase(InspectAlarmSeverityEnum.getName(language, alarm.getSeverity()), textFont));
//
//            table.addCell(new Phrase(AlarmUtil.transferAlarmMoNameToClient(alarm.getIp(), alarm.getMoName()), textFont));
//            String alarmSource = AlarmUtil.transferAlarmSourceToClient(alarm.getSource(), alarm.getSourceType(), alarm.getIp(), alarm.getType());
//            table.addCell(new Phrase(alarmSource.replaceAll("Shelf", InspectLableEnum.Shelf.getName(language)).replace("Slot", InspectLableEnum.Slot.getName(language))
//            		.replace("Port",InspectLableEnum.Port.getName(language)), textFont));
//
//            table.addCell(new Phrase(AlarmUtil.transferAlarmCodeToClient(alarm.getCode()), textFont));
//            String alarmType = AlarmUtil.transferAlarmTypeToClient(alarm.getCode());
//            table.addCell(new Phrase(InspectAlarmTypeEnum.getName(language, alarmType), textFont));
//
//            table.addCell(new Paragraph(InspectLableEnum.Alarm_State_Raise.getName(language), textFont));
////            table.addCell(new Phrase(AlarmUtil.transferAlarmMoNameToClient(alarm.getIp(), alarm.getMoName()), textFont));
//
//            String raiseTime = SinoTimeUtils.convertTimeString(String.valueOf(alarm.getCreateTime()));
//            table.addCell(new Paragraph(raiseTime, textFont));
//
//
//            String ackUser = alarm.getAcknowledgeUser();
//            if(!ackUser.equals(""))
//            	table.addCell(new Paragraph(InspectLableEnum.Alarm_Acknowledge.getName(language), textFont));
//            else
//            	table.addCell(new Paragraph(InspectLableEnum.Alarm_Unacknowledge.getName(language), textFont));
//
//            if(ackUser.equals("Auto Acknowledge"))
//            	table.addCell(new Paragraph(InspectLableEnum.Alarm_Auto_Acknowledge.getName(language), textFont));
//            else
//            	table.addCell(new Phrase(alarm.getAcknowledgeUser(), textFont));
//
//            if(alarm.getAcknowledgeTime() != 0) {
//	            String ackTime = SinoTimeUtils.convertTimeString(String.valueOf(alarm.getAcknowledgeTime()));
//	            table.addCell(new Paragraph(ackTime, textFont));
//            } else
//            	table.addCell(new Paragraph("", textFont));
//
//        	id ++;
//        }
//
//        table.setSpacingBefore(10);
//        section.add(table);
//        System.out.println("告警信息巡检完成");
//		return chapter;
//	}
//
//	public static Chapter addValidateInfo(Document document,
//			SinoDeviceGpon3116 device, int sectionNum, Chapter chapter) throws DocumentException, IOException {
//	    BaseFont bfChinese=BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
//	    Font keyFont=new Font(bfChinese,12,Font.BOLD);
//	    Font textFont=new Font(bfChinese,12,Font.NORMAL);
//
//	    SinoOtnNEManageInfoService sinoOtnNEManageInfoService
//	        =  new SinoOtnNEManageInfoServiceImpl();
//	    SinoOtnNeManageInfo_n ipInfo = sinoOtnNEManageInfoService.getSinoGponNeManageInfo(device.getName());
//	    if(ipInfo==null){
//	    	return chapter;
//	    }
//        Section section = chapter.addSection(new Paragraph(InspectLableEnum.Configuration_Validate.getName(language), textFont));
//
//        PdfPTable table = new PdfPTable(2);
//
//        Phrase phrase;
//        phrase = new Phrase(InspectLableEnum.Configuration_Item.getName(language), textFont);
//        table.addCell(phrase);
//
//        table.addCell(new Phrase(InspectLableEnum.Configuration_Status.getName(language), textFont));
//        table.setHeaderRows(1);
//
//        table.addCell(new Phrase(InspectLableEnum.Configuration_Trap.getName(language), textFont));
//        table.addCell(new Phrase(InspectUtils.trapConfigurationValidate(device.getName(), language), textFont));
//
//        table.addCell(new Phrase(InspectLableEnum.Configuration_Ftp.getName(language), textFont));
//        table.addCell(new Phrase(InspectUtils.ftpConfigurationValidate(device.getName(), language), textFont));
//
//        table.addCell(new Phrase(InspectLableEnum.Configuration_Ntp.getName(language), textFont));
//        table.addCell(new Phrase(InspectUtils.ntpConfigurationValidate(device.getName(), language), textFont));
//
//        table.addCell(new Phrase(InspectLableEnum.Configuration_MailBox.getName(language), textFont));
//        table.addCell(new Phrase(InspectUtils.mailServerConfigurationValidate(language), textFont));
//
//        table.setSpacingBefore(10);
//        section.add(table);
//        System.out.println("验证信息巡检完成");
//        return chapter;
//	}
//
//	public static Chapter addOpticalInfo(Document document,
//			SinoDeviceGpon3116 device, int sectionNum, Chapter chapter)  throws DocumentException, IOException  {
//	    BaseFont bfChinese=BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
//	    Font keyFont=new Font(bfChinese,12,Font.BOLD);
//	    Font textFont=new Font(bfChinese,12,Font.NORMAL);
//
//        Section section = chapter.addSection(new Paragraph(InspectLableEnum.Optical_Parameter.getName(language), textFont));
//
//        PdfPTable table = new PdfPTable(8);
//
//        Phrase phrase;
//        phrase = new Phrase(InspectLableEnum.Optical_Port.getName(language), textFont);
//        table.addCell(phrase);
//
//        table.addCell(new Phrase(InspectLableEnum.Optical_Port_Mode.getName(language), textFont));
//        table.addCell(new Phrase(InspectLableEnum.Optical_Port_SN.getName(language), textFont));
//
//        table.addCell(new Phrase(InspectLableEnum.Optical_Send.getName(language), textFont));
//        table.addCell(new Phrase(InspectLableEnum.Optical_Received.getName(language), textFont));
//
//        table.addCell(new Phrase(InspectLableEnum.Optical_Temperature.getName(language), textFont));
//
//        table.addCell(new Phrase(InspectLableEnum.Och_Frequency.getName(language), textFont));
//        table.addCell(new Phrase(InspectLableEnum.Och_OSNR.getName(language), textFont));
//        table.setHeaderRows(1);
//
//
//        List<OpticalParameter> opticalParameter = InspectUtils.getOpticalParameter(device.getName(), language);
//
//        for(OpticalParameter para: opticalParameter) {
//        	if(para==null){
//        		return chapter;
//        	}
//	        table.addCell(new Phrase(para.getPortName(), textFont));
//
//	        table.addCell(new Phrase(para.getPortMode(), textFont));
//	        table.addCell(new Phrase(para.getSN(), textFont));
//
//	        table.addCell(new Phrase(para.getTxPower(), textFont));
//	        table.addCell(new Phrase(para.getRxPower(), textFont));
//
//	        table.addCell(new Phrase(para.getTemperature(), textFont));
//	        table.addCell(new Phrase(para.getWaveLength(), textFont));
//	        table.addCell(new Phrase(para.getOsnr(), textFont));
//        }
//
//        table.setSpacingBefore(10);
//        section.add(table);
//        System.out.println("光功率信息巡检完成");
//	    return chapter;
//	}
//
//	public static Chapter addCardInventoryInfo(Document document,
//			SinoDeviceGpon3116 device, int sectionNum, Chapter chapter)  throws DocumentException, IOException  {
//
//		    BaseFont bfChinese=BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
//		    Font keyFont=new Font(bfChinese,12,Font.BOLD);
//		    Font textFont=new Font(bfChinese,12,Font.NORMAL);
//
//	        Section section = chapter.addSection(new Paragraph(InspectLableEnum.Card_Inventory.getName(language), textFont));
//
//	        PdfPTable table = new PdfPTable(12);
//
//	        Phrase phrase;
//	        phrase = new Phrase(InspectLableEnum.Card_Slot.getName(language), textFont);
//	        table.addCell(phrase);
//
//	        table.addCell(new Phrase(InspectLableEnum.Card_Type.getName(language), textFont));
//	        table.addCell(new Phrase(InspectLableEnum.Card_SN.getName(language), textFont));
//	        table.addCell(new Phrase(InspectLableEnum.Card_PN.getName(language), textFont));
//
//	        table.addCell(new Phrase(InspectLableEnum.Card_Hw.getName(language), textFont));
//
//	        table.addCell(new Phrase(InspectLableEnum.Card_Sw.getName(language), textFont));
//	        table.addCell(new Phrase(InspectLableEnum.Card_Sw_In_Load.getName(language), textFont));
//
//	        table.addCell(new Phrase(InspectLableEnum.Card_Cpld.getName(language), textFont));
//
//	        table.addCell(new Phrase(InspectLableEnum.Card_File.getName(language), textFont));
//	        table.addCell(new Phrase(InspectLableEnum.Card_Uboot.getName(language), textFont));
//	        table.addCell(new Phrase(InspectLableEnum.Card_Temperature.getName(language), textFont));
//	        table.addCell(new Phrase(InspectLableEnum.Card_Fpga.getName(language), textFont));
//	        table.setHeaderRows(1);
//
//	        CardInventoryService service = new CardInventoryServiceImpl();
//	        List<SinoOtnCard_n> cards = service.getCardsForNe(device.getName());
//	        int num =0;
//			while (num <= 3 && (cards == null || cards.size() == 0)) {
//				cards = service.getCardsForNe(device.getName());
//				num ++;
//			}
//	        if(cards == null || cards.size() == 0){
//	        	return chapter;
//	        }
//	        for(SinoOtnCard_n card: cards) {
//	        	if(card == null){
//	        		return chapter;
//	        	}
//		        table.addCell(new Phrase(String.valueOf(card.getSlotId()), textFont));
//
//		        table.addCell(new Phrase(CardTypeEnum.getNameFromValue(card.getCardType()), textFont));
//		        table.addCell(new Phrase(card.getCardSN(), textFont));
//		        table.addCell(new Phrase(card.getCardPartN(), textFont));
//
//		        table.addCell(new Phrase(card.getCardHwVersion(), textFont));
//		        table.addCell(new Phrase(card.getCardSwVersion(), textFont));
//		        table.addCell(new Phrase(card.getCardSwVersionInLoad(), textFont));
//
//		        table.addCell(new Phrase(card.getCardCpldVersion(), textFont));
//		        table.addCell(new Phrase(card.getCardRootFsVersion(), textFont));
//		        table.addCell(new Phrase(card.getCardUbootVersion(), textFont));
//
//		        String temperature = String.valueOf(card.getCardTemperature());
//		        if("255".equals(temperature))
//		        	temperature = "N/A";
//
//		        table.addCell(new Phrase(temperature, textFont));
//		        table.addCell(new Phrase(card.getCardFpgaVersion(), textFont));
//	        }
//
//	        table.setSpacingBefore(10);
//	        section.add(table);
//	        System.out.println("板卡信息巡检完成");
//		    return chapter;
//
//	}
//
//	public static Chapter addOlpOpticalPower(Document document,
//			SinoDeviceGpon3116 device, int sectionNum, Chapter chapter)  throws DocumentException, IOException {
//		    BaseFont bfChinese=BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
//		    Font keyFont=new Font(bfChinese,12,Font.BOLD);
//		    Font textFont=new Font(bfChinese,12,Font.NORMAL);
//		    Section section = chapter.addSection(new Paragraph(InspectLableEnum.OpticalPower_Parameter.getName(language), textFont));
//            PdfPTable table = new PdfPTable(4);
//
//	        Phrase phrase;
//	        phrase = new Phrase(InspectLableEnum.OpticalPower_Port.getName(language), textFont);
//	        table.addCell(phrase);
//	        table.addCell(new Phrase(InspectLableEnum.OpticalPower_PortName.getName(language), textFont));
//	        table.addCell(new Phrase(InspectLableEnum.OpticalPower.getName(language), textFont));
//	        table.addCell(new Phrase(InspectLableEnum.Wavelength.getName(language), textFont));
//	        table.setHeaderRows(1);
//	         List<OlpOpticalPower> infos=InspectUtils.getOpticalPowers(device.getName(), language);
//	         if(infos == null){
//	        	 return chapter;
//	         }
//	            for (OlpOpticalPower olpOpticalPower : infos) {
//	            	if(olpOpticalPower==null){
//	            		return chapter;
//	            	}
//	            	table.addCell(new Phrase(String.valueOf(olpOpticalPower.getPortMode()), textFont));
//	            	table.addCell(new Phrase(String.valueOf(OlpPortTypeEnum.getName(olpOpticalPower.getPortType())), textFont));
//
//	            	table.addCell(new Phrase(String.valueOf(olpOpticalPower.getOpticalPower()/100.00), textFont));
//	            	if(olpOpticalPower.getPortType()==23||olpOpticalPower.getPortType()==24){
//	            		 table.addCell(new Phrase("CWDM", textFont));
//	            	}else {
//	            		 table.addCell(new Phrase(String.valueOf(OmpPortValueENnum.getName(olpOpticalPower.getPortWaveLen())), textFont));
//					}
//
//				}
//	         table.setSpacingBefore(10);
//	 	        section.add(table);
//	 	        System.out.println("olp光功率巡检完成");
//				return chapter;
//
//	}
//	public static Chapter addOaOpticalPower(Document document,
//			SinoDeviceGpon3116 device, int sectionNum, Chapter chapter)  throws DocumentException, IOException {
//		    BaseFont bfChinese=BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
//		    Font keyFont=new Font(bfChinese,12,Font.BOLD);
//		    Font textFont=new Font(bfChinese,12,Font.NORMAL);
//		    Section section = chapter.addSection(new Paragraph(InspectLableEnum.OAOpticalPower_Parameter.getName(language), textFont));
//         PdfPTable table = new PdfPTable(3);
//
//	        Phrase phrase;
//	        phrase = new Phrase(InspectLableEnum.OAOpticalPower_Port.getName(language), textFont);
//	        table.addCell(phrase);
//	        table.addCell(new Phrase(InspectLableEnum.OAOpticalPower_PortName.getName(language), textFont));
//	        table.addCell(new Phrase(InspectLableEnum.OAOpticalPower.getName(language), textFont));
//	        table.setHeaderRows(1);
//	         List<OaOpticalPower> infos=InspectUtils.getOaOpticalPowers(device.getName(), language);
//	         if(infos==null){
//	        	 return chapter;
//	         }
//	            for (OaOpticalPower OaOpticalPower : infos) {
//	            	if(OaOpticalPower == null){
//	            		return chapter;
//	            	}
//	            	table.addCell(new Phrase(OaOpticalPower.getPort(), textFont));
//	            	table.addCell(new Phrase(String.valueOf(OaOpticalPower.getPortName()), textFont));
//	            	if(OaOpticalPower.getOpticalPower() == -10000){
//	            	     table.addCell(new Phrase("N/A", textFont));
//	            	}else {
//	            		table.addCell(new Phrase(String.valueOf(OaOpticalPower.getOpticalPower()/100.00), textFont));
//					}
//
//				}
//	         table.setSpacingBefore(10);
//	 	        section.add(table);
//	 	       System.out.println("OA光功率巡检完成");
//				return chapter;
//
//	}

}
